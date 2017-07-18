package com.chitra.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.chitra.school.model.Payment;
import com.chitra.school.model.PaymentDetail;
import com.chitra.school.model.Student;
import com.chitra.school.model.User;

@Repository("paymentDao")
@Transactional
@EnableTransactionManagement
public class PaymentDaoImpl extends AbstractDao<Integer, Object>  implements PaymentDao{
	public List<Payment> list() {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		
		return (List<Payment>) crit.list();
	}
	@SuppressWarnings("unchecked")
	public List<Balance> curBalanceList() {
		String query = "SELECT"
				+ "  PAY_ID"
				+ ", STU_ID"
				+ ", STAFF_ID"
				+ ", PAY_DATE"
				+ ", PAY_NM"
				+ ", PAY_DESCR"
				+ " FROM TB_PAYMENT";

		SQLQuery sql = getSession().createSQLQuery(query);// session.createSQLQuery(sql);
		sql.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);	
		
		return (List<Balance>) sql.list();
	}
	// these settings have precedence for this method
	@SuppressWarnings("finally")
	@Transactional(rollbackFor=Exception.class)
	public void save(Payment payment
			, List<PaymentDetail> paymentDetails
			, Student student
			, User user
			)throws Exception{
		String query = "SELECT  CONCAT('PAY', LPAD(CAST(FN_TB_UID_SEQ('PAY_ID') AS VARCHAR),7,'0')) AS PAY_ID";
		SQLQuery sql = getSession().createSQLQuery(query);// session.createSQLQuery(sql);
		//sql.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);	
		String payId = sql.uniqueResult().toString();	
		payment.setPaymentId(payId);
		payment.setStudent(student);
		//payment.setPayNm();
		payment.setUser(user);
		String msg = "";
		boolean isSuccess = true;
		try{
			persist(payment);
			for(int i = 0; i< paymentDetails.size(); i++){
				paymentDetails.get(i).setPayment(payment);
				paymentDetails.get(i).setStudent(student);
				paymentDetails.get(i).setUser(user);
				if(this.isPaid(student.getId(), paymentDetails.get(i).getPayDtlDescr())){
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();	
					msg = paymentDetails.get(i).getPayDtlDescr();
					isSuccess = false;
					//throw new TransactionException("ការបង់ប្រាក់សម្រាប់  "+ paymentDetails.get(i).getPayDtlDescr() +" បង់រួចហើយ");
				//	throw new Exception("ការបង់ប្រាក់សម្រាប់  "+ paymentDetails.get(i).getPayDtlDescr() +" បង់រួចហើយ");	
					
				}else{
					persist(paymentDetails.get(i));
				}
			}
		}catch(Exception e){
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();			
		}finally {
			if(!isSuccess){
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();	
				
				throw new TransactionException("ការបង់ប្រាក់សម្រាប់ "+msg+" បង់រួចហើយ");				
			}
		}
	}
	@Transactional
	public void save(PaymentDetail paymentDetail) {
		persist(paymentDetail);
		
	}
	public boolean isPaid(String studentId, String payDtlDescr) {
		boolean isValid = false;
		String query = "SELECT COUNT(*) "
				+ "FROM TB_PAYMENT_DETAIL "
				+ "WHERE STUDENT_ID = ? "
				+ "AND PAY_DTL_DESCR = ?";
		SQLQuery sql = getSession().createSQLQuery(query);
		sql.setParameter(0, studentId);
		sql.setParameter(1, payDtlDescr);
		String countStr = sql.uniqueResult().toString();
		int count = Integer.parseInt(countStr);
		System.out.println(count+"Pring");
		if(count>0){
			isValid = true;
		}
		return isValid;
	}

}