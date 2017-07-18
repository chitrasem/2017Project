package com.chitra.school.dao;

import java.util.List;

import com.chitra.school.model.Payment;
import com.chitra.school.model.PaymentDetail;
import com.chitra.school.model.Student;
import com.chitra.school.model.User;

public interface PaymentDao {
	void save(Payment payment
			, List<PaymentDetail> paymentDetails
			, Student student
			, User user
			)throws Exception;
	List<Payment> list();
	List<Balance> curBalanceList();
	void save(PaymentDetail paymentDetail);
	boolean isPaid(String studentId, String payDtlDescr);
}
