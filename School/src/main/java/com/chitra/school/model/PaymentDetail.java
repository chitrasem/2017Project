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
	@Column(name="PAY_DTL_SEQ")
	private String payDtlSeq;
	
	@Column(name="PAY_DTL_DATE", length=50)
	private String payDtlDate = StringUtils.getStrDate();
	@Column(name="PAY_NM", length=20)
	private String payDtlNm;
	@Column(name="PAY_DTL_DESCR", length=50)
	private String payDtlDescr;
	@Column(name="PAY_DTL_AMT_US", length=20)
	private String payDtlAmtUs;
	@Column(name="PAY_DTL_AMT_KM", length=20)
	private String payDtlAmtKm;
	@Column(name="PAY_DTL_DISC", length=20)
	private String payDtlDisc;
	@Column(name="PAY_DTL_GET_US", length=20)
	private String payDtlGetUs;
	@Column(name="PAY_DTL_GET_KM", length=20)
	private String payDtlGetKm;
	@Column(name="PAY_STATUS", length=20)
	private String pay_status;
	@Column(name="PAY_TYPE", length=20)
	private String pay_type;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="PAY_ID")
	private Payment payment;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="STAFF_ID")
	private User user;

	public String getPayDtlSeq() {
		return payDtlSeq;
	}

	public void setPayDtlSeq(String payDtlSeq) {
		this.payDtlSeq = payDtlSeq;
	}

	public String getPayDtlDate() {
		return payDtlDate;
	}

	public void setPayDtlDate(String payDtlDate) {
		this.payDtlDate = payDtlDate;
	}

	public String getPayDtlNm() {
		return payDtlNm;
	}

	public void setPayDtlNm(String payDtlNm) {
		this.payDtlNm = payDtlNm;
	}

	public String getPayDtlDescr() {
		return payDtlDescr;
	}

	public void setPayDtlDescr(String payDtlDescr) {
		this.payDtlDescr = payDtlDescr;
	}

	public String getPayDtlAmtUs() {
		return payDtlAmtUs;
	}

	public void setPayDtlAmtUs(String payDtlAmtUs) {
		this.payDtlAmtUs = payDtlAmtUs;
	}

	public String getPayDtlAmtKm() {
		return payDtlAmtKm;
	}

	public void setPayDtlAmtKm(String payDtlAmtKm) {
		this.payDtlAmtKm = payDtlAmtKm;
	}

	public String getPayDtlDisc() {
		return payDtlDisc;
	}

	public void setPayDtlDisc(String payDtlDisc) {
		this.payDtlDisc = payDtlDisc;
	}

	public String getPayDtlGetUs() {
		return payDtlGetUs;
	}

	public void setPayDtlGetUs(String payDtlGetUs) {
		this.payDtlGetUs = payDtlGetUs;
	}

	public String getPayDtlGetKm() {
		return payDtlGetKm;
	}

	public void setPayDtlGetKm(String payDtlGetKm) {
		this.payDtlGetKm = payDtlGetKm;
	}

	public String getPay_status() {
		return pay_status;
	}

	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PaymentDetail [payDtlSeq=" + payDtlSeq + ", payDtlDate=" + payDtlDate + ", payDtlNm=" + payDtlNm
				+ ", payDtlDescr=" + payDtlDescr + ", payDtlAmtUs=" + payDtlAmtUs + ", payDtlAmtKm=" + payDtlAmtKm
				+ ", payDtlDisc=" + payDtlDisc + ", payDtlGetUs=" + payDtlGetUs + ", payDtlGetKm=" + payDtlGetKm
				+ ", pay_status=" + pay_status + ", pay_type=" + pay_type + ", payment=" + payment + ", student="
				+ student + ", user=" + user + "]";
	}
	
	
	
	
	
	

}
