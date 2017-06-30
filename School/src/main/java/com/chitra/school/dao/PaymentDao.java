package com.chitra.school.dao;

import java.util.List;

import com.chitra.school.model.Payment;

public interface PaymentDao {
	void save(Payment payment);
	List<Payment> list();
	List<Balance> curBalanceList();
}
