package com.chitra.school.dao;

import java.util.List;

import com.chitra.school.bean.PaymentBean;
import com.chitra.school.bean.PaymentYearlyBean;
import com.chitra.school.entities.Payment;
import com.chitra.school.entities.PaymentDetail;
import com.chitra.school.entities.Student;
import com.chitra.school.entities.User;

public interface PaymentDao {
	void save(Payment payment
			, List<PaymentDetail> paymentDetails
			, Student student
			, User user
			)throws Exception;
	List<Payment> list();
	List<PaymentYearlyBean> yearlyReport();
	List<PaymentBean> curBalanceList();
	void save(PaymentDetail paymentDetail);
	boolean isPaid(String studentId, String payDtlDescr);
}
