package com.chitra.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.TransactionException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.chitra.school.bean.PaymentBean;
import com.chitra.school.entities.Payment;
import com.chitra.school.entities.PaymentDetail;
import com.chitra.school.entities.Student;
import com.chitra.school.entities.User;

@Repository("paymentDao")
@Transactional
@EnableTransactionManagement
public class PaymentDaoImpl extends AbstractDao<Integer, Object>  implements PaymentDao{
	@SuppressWarnings("unchecked")
	public List<Payment> list() {
		Criteria crit = createEntityCriteria();		
		return (List<Payment>) crit.list();
	}
	@SuppressWarnings("unchecked")
	public List<PaymentBean> curBalanceList() {
		String query = "SELECT "
				   +"B.PAY_ID "
				   +", B.STUDENT_ID "
				   +", CONCAT(D.km_last_name, ' ', D.km_first_name) as PAYER_KM "
				   +", CONCAT(D.last_name, ' ', D.first_name) as PAYER_EN "
				   +", B.PAY_DATE "
				   +", B.PAY_DESCR "
				   +", B.USER_ID  "
				   +", CONCAT(C.last_name, ' ' , C.first_name) as RECEIVER "
				   +", (select "
				   +"COUNT ( * ) as COUNT_UNIT "
				   +"from tb_payment_detail A "
				   	+"where A.pay_id = B.pay_id "
				   +") "
				   + ",( select coalesce(SUM((case when A.pay_id = B.pay_id then A.pay_dtl_amt_km end )), 0) as pay_dtl_amt_km "
				   + " from tb_payment_detail A "
				   + ")"
				   + ",( select coalesce(SUM((case when A.pay_id = B.pay_id then A.pay_dtl_disc end )), 0) as pay_dtl_disc "
				   + "from tb_payment_detail A "
				   + ")"
				   +"from tb_payment B "
				   + "inner join app_user C on B.user_id = C.user_id "
				   + "inner join tb_student D on B.student_id = D.student_id "; 
		SQLQuery sql = getSession().createSQLQuery(query);// session.createSQLQuery(sql);
		sql.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);			
		return (List<PaymentBean>) sql.list();
	}
	/**
	 * TODO SAVE PAYMENT & PAYMENT_DTL
	 */
	// these settings have precedence for this method
	@Transactional(rollbackFor=Exception.class)
	public void save(Payment payment
			, List<PaymentDetail> paymentDetails
			, Student student
			, User user
			)throws Exception{
		boolean isSuccess = true;
		String query = "SELECT  CONCAT('PAY', LPAD(CAST(FN_TB_UID_SEQ('PAY_ID') AS VARCHAR),7,'0')) AS PAY_ID";
		SQLQuery sql = getSession().createSQLQuery(query);// session.createSQLQuery(sql);
		//sql.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);	
		String payId = sql.uniqueResult().toString();			
		if(payId == "0"){
			isSuccess =  false;
		}
		payment.setPaymentId(payId);
		payment.setStudent(student);
		//payment.setPayNm();
		payment.setUser(user);
		String msg = "";
		try{
			System.out.println("Trying Block...");
			persist(payment);
			for(int i = 0; i< paymentDetails.size(); i++){
				System.out.println("Foring Block...");
				if(this.isPaid(student.getId(), paymentDetails.get(i).getPayDtlDescr())){
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();	
					msg = "ការបង់ប្រាក់សម្រាប់ "+ paymentDetails.get(i).getPayDtlDescr() +" បង់រួចហើយ";
					isSuccess = false;					
				}else{
					String sqlDtl = "SELECT COALESCE(("
							+ "SELECT  PAY_DTL_SEQ + 1 "
							+ "FROM  TB_PAYMENT_DETAIL "
							+ "WHERE  PAY_ID = ? "
							+ "ORDER  BY PAY_DTL_SEQ DESC LIMIT 1 "
							+ "), 1)";
					SQLQuery queryDtl = getSession().createSQLQuery(sqlDtl);
					queryDtl.setParameter(0, payment.getPaymentId());					
					int seq = Integer.parseInt(queryDtl.uniqueResult().toString());					
					//System.out.print("MMMM"+seq);					
					paymentDetails.get(i).setPayment(payment);
					paymentDetails.get(i).setStudent(student);
					paymentDetails.get(i).setUser(user);
					//paymentDetails.get(i).setPayDtlSeq(seq);					
					this.save(paymentDetails.get(i));
					}
			}
		}catch(Exception e){
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();			
		}finally {
			if(!isSuccess){
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();	
				
				throw new TransactionException(msg);				
			}
		}
	}
	@Transactional
	public void save(PaymentDetail paymentDetail) {
		persist(paymentDetail);
		
	}
	public boolean isPaid(String studentId, String payDtlDescr) {
		boolean yes = false;
		String query = "SELECT COUNT(*) "
				+ "FROM TB_PAYMENT_DETAIL "
				+ "WHERE STUDENT_ID = ? "
				+ "AND PAY_DTL_DESCR = ?";
		SQLQuery sql = getSession().createSQLQuery(query);
		sql.setParameter(0, studentId);
		sql.setParameter(1, payDtlDescr);
		String countStr = sql.uniqueResult().toString();
		int count = Integer.parseInt(countStr);
		if(count>0){
			yes = true;
		}
		return yes;
	}

}