package com.chitra.school.bean;

public class PaymentBean {
	private String pay_id;
	private String student_id;
	private String payer_km;
	private String payer_en;
	private String pay_date;
	private String pay_descr;
	private String user_id;
	private String receiver;
	private String count_unit;
	private String pay_dtl_amt_km;
	private String pay_dtl_disc;
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getPayer_km() {
		return payer_km;
	}
	public void setPayer_km(String payer_km) {
		this.payer_km = payer_km;
	}
	public String getPayer_en() {
		return payer_en;
	}
	public void setPayer_en(String payer_en) {
		this.payer_en = payer_en;
	}
	public String getPay_date() {
		return pay_date;
	}
	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}
	public String getPay_descr() {
		return pay_descr;
	}
	public void setPay_descr(String pay_descr) {
		this.pay_descr = pay_descr;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getCount_unit() {
		return count_unit;
	}
	public void setCount_unit(String count_unit) {
		this.count_unit = count_unit;
	}
	public String getPay_dtl_amt_km() {
		return pay_dtl_amt_km;
	}
	public void setPay_dtl_amt_km(String pay_dtl_amt_km) {
		this.pay_dtl_amt_km = pay_dtl_amt_km;
	}
	public String getPay_dtl_disc() {
		return pay_dtl_disc;
	}
	public void setPay_dtl_disc(String pay_dtl_disc) {
		this.pay_dtl_disc = pay_dtl_disc;
	}
	@Override
	public String toString() {
		return "PaymentBean [pay_id=" + pay_id + ", student_id=" + student_id + ", payer_km=" + payer_km + ", payer_en="
				+ payer_en + ", pay_date=" + pay_date + ", pay_descr=" + pay_descr + ", user_id=" + user_id
				+ ", receiver=" + receiver + ", count_unit=" + count_unit + ", pay_dtl_amt_km=" + pay_dtl_amt_km
				+ ", pay_dtl_disc=" + pay_dtl_disc + "]";
	}
	
	
	

}
