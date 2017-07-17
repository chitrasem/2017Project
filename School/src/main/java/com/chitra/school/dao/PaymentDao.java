package com.chitra.school.dao;

import java.util.List;

import com.chitra.school.model.Payment;
import com.chitra.school.model.PaymentDetail;
import com.chitra.school.model.Student;

public interface PaymentDao {
	void save(Payment payment,  List<PaymentDetail> paymentDetails, Student student);
	List<Payment> list();
	List<Balance> curBalanceList();
	void save(PaymentDetail paymentDetail);
}
