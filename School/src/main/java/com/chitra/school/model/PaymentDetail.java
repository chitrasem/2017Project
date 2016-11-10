package com.chitra.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.chitra.school.utils.StringUtils;

@Entity
@Table(name="TB_PAYMENT_DETAIL")
public class PaymentDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PD_ID")
	private String pdId;
	// YYYYMM
	@Column(name="PAY_FOR", length=6)
	private String pdFor;	
	@ManyToOne(optional=true)
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	@ManyToOne(optional=true)
	@JoinColumn(name="USER_ID")
	private User user;	
	@Column(name="TRANSACTION_DATE")
	private String transactionDate = StringUtils.getStrDate();
	@ManyToOne(optional=false)
	@JoinColumn(name="PAYMENT_ID")
	private Payment payment;
	public final String getPdId() {
		return pdId;
	}
	public final void setPdId(String pdId) {
		this.pdId = pdId;
	}
	public final String getPdFor() {
		return pdFor;
	}
	public final void setPdFor(String pdFor) {
		this.pdFor = pdFor;
	}
	public final Student getStudent() {
		return student;
	}
	public final void setStudent(Student student) {
		this.student = student;
	}
	public final User getUser() {
		return user;
	}
	public final void setUser(User user) {
		this.user = user;
	}
	public final String getTransactionDate() {
		return transactionDate;
	}
	public final void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public final Payment getPayment() {
		return payment;
	}
	public final void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	
	
	
	
	
	

}
