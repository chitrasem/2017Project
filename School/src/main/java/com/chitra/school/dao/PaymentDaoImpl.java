package com.chitra.school.dao;

import java.util.List;

import org.hibernate.Criteria;
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

}
