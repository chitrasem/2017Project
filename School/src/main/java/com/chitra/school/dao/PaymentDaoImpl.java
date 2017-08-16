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
import com.chitra.school.bean.PaymentYearlyBean;
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
				if(this.isPaid(student.getId(), paymentDetails.get(i).getPayDtlDt() )){
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();	
					msg = "ការបង់ប្រាក់សម្រាប់ "+ paymentDetails.get(i).getPayDtlDt() +" បង់រួចហើយ";
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
	public boolean isPaid(String studentId, String payDtlDt) {
		boolean yes = false;
		String query = "SELECT COUNT(*) "
				+ "FROM TB_PAYMENT_DETAIL "
				+ "WHERE STUDENT_ID = ? "
				+ "AND PAY_DTL_DT = ?";
		SQLQuery sql = getSession().createSQLQuery(query);
		sql.setParameter(0, studentId);
		sql.setParameter(1, payDtlDt);
		String countStr = sql.uniqueResult().toString();
		int count = Integer.parseInt(countStr);
		if(count>0){
			yes = true;
		}
		return yes;
	}
	public List<PaymentYearlyBean> yearlyReport() {
		
		String query = "SELECT STATUS "
						+",STUDENT_ID "
						+",FULL_NAME_KM "
						+",FULL_NAME_EN "
						+",GENDER "
						+",AMT_YYYY_TOT "
						+",DISC_YYYY_TOT "
						+",AMT_YYYY_TOT - DISC_YYYY_TOT SUM_AMT_TOT "
						+",AMT_MM_JAN "
						+",DISC_MM_JAN "
						+",AMT_MM_JAN - DISC_MM_JAN AS TOT_MM_JAN "
						+",AMT_MM_FEB "
						+",DISC_MM_FEB "
						+",AMT_MM_FEB - DISC_MM_FEB AS TOT_MM_FEB "
						+",AMT_MM_MAR "
						+",DISC_MM_MAR "
						+",AMT_MM_MAR - DISC_MM_MAR AS TOT_MM_MAR "
						+",AMT_MM_APR "
						+",DISC_MM_APR "
						+",AMT_MM_APR - DISC_MM_APR AS TOT_MM_APR "
						+",AMT_MM_MAY "
						+",DISC_MM_MAY "
						+",AMT_MM_MAY - DISC_MM_MAY AS TOT_MM_MAY "
						+",AMT_MM_JUN "
						+",DISC_MM_JUN "
						+",AMT_MM_JUN - DISC_MM_JUN AS TOT_MM_JUN "
						+",AMT_MM_JUL "
						+",DISC_MM_JUL "
						+",AMT_MM_JUL - DISC_MM_JUL AS TOT_MM_JUL "
						+",AMT_MM_AUG "
						+",DISC_MM_AUG "
						+",AMT_MM_AUG - DISC_MM_AUG AS TOT_MM_AUG "
						+",AMT_MM_SEP "
						+",DISC_MM_SEP "
						+",AMT_MM_SEP - DISC_MM_SEP AS TOT_MM_SEP "
						+",AMT_MM_OCT "
						+",DISC_MM_OCT "
						+",AMT_MM_OCT - DISC_MM_OCT AS TOT_MM_OCT "
						+",AMT_MM_NOV "
						+",DISC_MM_NOV "
						+",AMT_MM_NOV - DISC_MM_NOV AS TOT_MM_NOV "
						+",AMT_MM_DEC "
						+",DISC_MM_DEC "
						+",AMT_MM_DEC - DISC_MM_DEC AS TOT_MM_DEC " 
				+ "FROM( "
				+ "SELECT " 
				+"'2' AS STATUS "
				+",'' AS STUDENT_ID "
				+",'' AS GENDER "
				+",'' AS FULL_NAME_KM "
				+",'' AS FULL_NAME_EN "
				+ ",(select SUM(A.PAY_DTL_AMT_KM) AS AMT_YYYY_TOT from TB_PAYMENT_DETAIL A WHERE PAY_DTL_DT LIKE :PAY_DTL_DT ||'%') "
				+ ",(select SUM(A.PAY_DTL_DISC) AS DISC_YYYY_TOT from TB_PAYMENT_DETAIL A WHERE PAY_DTL_DT LIKE :PAY_DTL_DT ||'%') "
				+",(SELECT SUM(PAY_DTL_AMT_KM) as AMT_MM_JAN from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '01' ) "
				+",(SELECT SUM(PAY_DTL_DISC) as DISC_MM_JAN from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '01' ) "
				+",(SELECT SUM(PAY_DTL_AMT_KM) as AMT_MM_FEB from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '02' ) "
				+",(SELECT SUM(PAY_DTL_DISC) as DISC_MM_FEB from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '02' ) "
				+",(SELECT SUM(PAY_DTL_AMT_KM) as AMT_MM_MAR from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '03' ) "
				+",(SELECT SUM(PAY_DTL_DISC) as DISC_MM_MAR from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '03' ) "
				+",(SELECT SUM(PAY_DTL_AMT_KM) as AMT_MM_APR from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '04' ) "
				+",(SELECT SUM(PAY_DTL_DISC) as DISC_MM_APR from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '04' ) "
				+",(SELECT SUM(PAY_DTL_AMT_KM) as AMT_MM_MAY from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '05' ) "
				+",(SELECT SUM(PAY_DTL_DISC) as DISC_MM_MAY from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '05' ) "
				+",(SELECT SUM(PAY_DTL_AMT_KM) as AMT_MM_JUN from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '06' ) "
				+",(SELECT SUM(PAY_DTL_DISC) as DISC_MM_JUN from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '06' ) " 
				+",(SELECT SUM(PAY_DTL_AMT_KM) as AMT_MM_JUL from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '07' ) "
				+",(SELECT SUM(PAY_DTL_DISC) as DISC_MM_JUL from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '07' ) "
				+",(SELECT SUM(PAY_DTL_AMT_KM) as AMT_MM_AUG from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '08' ) "
				+",(SELECT SUM(PAY_DTL_DISC) as DISC_MM_AUG from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '08' ) "
				+",(SELECT SUM(PAY_DTL_AMT_KM) as AMT_MM_SEP from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '09' ) "
				+",(SELECT SUM(PAY_DTL_DISC) as DISC_MM_SEP from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '09' ) "
				+",(SELECT SUM(PAY_DTL_AMT_KM) as AMT_MM_OCT from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '10' ) "
				+",(SELECT SUM(PAY_DTL_DISC) as DISC_MM_OCT from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '10' ) "
				+",(SELECT SUM(PAY_DTL_AMT_KM) as AMT_MM_NOV from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '11' ) "
				+",(SELECT SUM(PAY_DTL_DISC) as DISC_MM_NOV from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '11' ) "
				+",(SELECT SUM(PAY_DTL_AMT_KM) as AMT_MM_DEC from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '12' ) "
				+",(SELECT SUM(PAY_DTL_DISC) as DISC_MM_DEC from tb_payment_detail where PAY_DTL_DT = :PAY_DTL_DT || '12') "
				+"UNION ALL "
				+"SELECT "
				+"'1' AS STATUS "
				+",B.STUDENT_ID "
				+",B.GENDER "
				+",CONCAT(B.KM_LAST_NAME, ' ', B.KM_FIRST_NAME) AS FULL_NAME_KM "
				+",CONCAT(B.LAST_NAME, ' ', B.FIRST_NAME) AS FULL_NAME_EN "
				+ ",(select SUM(A.PAY_DTL_AMT_KM) AS AMT_YYYY_TOT from TB_PAYMENT_DETAIL A WHERE PAY_DTL_DT LIKE :PAY_DTL_DT ||'%' AND B.STUDENT_ID = A.STUDENT_ID) "
				+ ",(select SUM(A.PAY_DTL_DISC) AS DISC_YYYY_TOT from TB_PAYMENT_DETAIL A WHERE PAY_DTL_DT LIKE :PAY_DTL_DT ||'%' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_AMT_KM AS AMT_MM_JAN FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '01' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_DISC AS DISC_MM_JAN FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '01' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_AMT_KM AS AMT_MM_FEB FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '02' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_DISC AS DISC_MM_FEB FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '02' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_AMT_KM AS AMT_MM_MAR FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '03' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_DISC AS DISC_MM_MAR FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '03' AND B.STUDENT_ID = A.STUDENT_ID) " 
				+",(SELECT A.PAY_DTL_AMT_KM AS AMT_MM_APR FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '04' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_DISC AS DISC_MM_APR FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '04' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_AMT_KM AS AMT_MM_MAY FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '05' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_DISC AS DISC_MM_MAY FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '05' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_AMT_KM AS AMT_MM_JUN FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '06' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_DISC AS DISC_MM_JUN FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '06' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_AMT_KM AS AMT_MM_JUL FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '07' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_DISC AS DISC_MM_JUL FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '07' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_AMT_KM AS AMT_MM_AUG FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '08' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_DISC AS DISC_MM_AUG FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '08' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_AMT_KM AS AMT_MM_SEP FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '09' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_DISC AS DISC_MM_SEP FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '09' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_AMT_KM AS AMT_MM_OCT FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '10' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_DISC AS DISC_MM_OCT FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '10' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_AMT_KM AS AMT_MM_NOV FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '11' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_DISC AS DISC_MM_NOV FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '11' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_AMT_KM AS AMT_MM_DEC FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '12' AND B.STUDENT_ID = A.STUDENT_ID) "
				+",(SELECT A.PAY_DTL_DISC AS DISC_MM_DEC FROM TB_PAYMENT_DETAIL A WHERE A.PAY_DTL_DT = :PAY_DTL_DT || '12' AND B.STUDENT_ID = A.STUDENT_ID) "
				+"FROM TB_STUDENT B) A "
				+ "ORDER BY A.FULL_NAME_KM, A.FULL_NAME_EN";
		SQLQuery sql = getSession().createSQLQuery(query);
		sql.setParameter("PAY_DTL_DT", "2017");
		sql.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);			
		//return (List<PaymentYearlyBean>) sql.list();	
		return sql.list();
	}

}