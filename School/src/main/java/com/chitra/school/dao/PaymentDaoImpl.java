package com.chitra.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.school.model.Payment;

@Repository("paymentDao")
@Transactional
public class PaymentDaoImpl extends AbstractDao<Integer, Payment>  implements PaymentDao{
	public void save(Payment payment) {
		persist(payment);		
	}

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

}
