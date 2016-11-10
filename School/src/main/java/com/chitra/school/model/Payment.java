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
@Table(name="TB_PAYMENT")
public class Payment {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="PAYMENT_ID")	
	private String paymentId;
	
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="USER_ID")
	private User user;	
	@ManyToOne(optional=true)
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	@Column(name="TRANSACTION_DATE")
	private String transactionDate = StringUtils.getStrDate();
	@Column(name="AMOUNT_US", length= 4)
	private String amountUs;
	@Column(name="AMOUNT_KM", length = 7)
	private String amountKm;
	public final String getPaymentId() {
		return paymentId;
	}
	public final void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public final String getDescription() {
		return description;
	}
	public final void setDescription(String description) {
		this.description = description;
	}
	public final User getUser() {
		return user;
	}
	public final void setUser(User user) {
		this.user = user;
	}
	public final Student getStudent() {
		return student;
	}
	public final void setStudent(Student student) {
		this.student = student;
	}
	public final String getTransactionDate() {
		return transactionDate;
	}
	public final void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public final String getAmountUs() {
		return amountUs;
	}
	public final void setAmountUs(String amountUs) {
		this.amountUs = amountUs;
	}
	public final String getAmountKm() {
		return amountKm;
	}
	public final void setAmountKm(String amountKm) {
		this.amountKm = amountKm;
	}
	
	
	
	
	
	

}
