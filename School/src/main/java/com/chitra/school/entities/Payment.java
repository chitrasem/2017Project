package com.chitra.school.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.chitra.school.utils.StringUtils;

@Entity
@Table(name="TB_PAYMENT")
public class Payment {

    @Id 
   // @GenericGenerator(name = "sequence_payment_id", strategy = "com.chitra.school.id.PaymentIDGenerator")
   // @GeneratedValue(generator = "sequence_payment_id")
    @Column(name = "PAY_ID",unique = true, nullable = false, length = 10)
	private String paymentId;	
	
	@ManyToOne(optional=true)
	@JoinColumn(name="USER_ID")
	private User user;	
	
	@ManyToOne(optional=true)
	@JoinColumn(name="STUDENT_ID")	
	private Student student;
	
	@Column(name="PAY_DESCR")
	private String description;

	@Column(name="PAY_DATE")
	private String transactionDate = StringUtils.getStrDate();
	
	@Column(name="PAY_NM")
	private String payNm;
	
	
	public String getPayNm() {
		return payNm;
	}
	public void setPayNm(String payNm) {
		this.payNm = payNm;
	}
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
}
