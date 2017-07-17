package com.chitra.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.school.model.Payment;
import com.chitra.school.model.PaymentDetail;
import com.chitra.school.model.Student;
import com.chitra.school.utils.SSOIdUtil;

@Repository("paymentDao")
@Transactional
public class PaymentDaoImpl extends AbstractDao<Integer, Object>  implements PaymentDao{	

	SSOIdUtil sSOIdUtil = new SSOIdUtil();

	public List<Payment> list() {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		
		return (List<Payment>) crit.list();
	}

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

	public void save(Payment payment, List<PaymentDetail> paymentDetails, Student student) {
		String query = "SELECT  CONCAT('PAY', LPAD(CAST(FN_TB_UID_SEQ('PAY_ID') AS VARCHAR),7,'0')) AS PAY_ID";

		SQLQuery sql = getSession().createSQLQuery(query);// session.createSQLQuery(sql);
		//sql.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);	
		String payId = sql.uniqueResult().toString();	
		payment.setPaymentId(payId);
		payment.setStudent(student);
		payment.setPayNm(sSOIdUtil.getPrincipal());
		persist(payment);		
		for(int i = 0; i< paymentDetails.size(); i++){
			paymentDetails.get(i).setPayment(payment);
			paymentDetails.get(i).setStudent(student);
			this.save(paymentDetails.get(i));
		}
		
	}
	public void save(PaymentDetail paymentDetail) {
		persist(paymentDetail);
		
	}

}