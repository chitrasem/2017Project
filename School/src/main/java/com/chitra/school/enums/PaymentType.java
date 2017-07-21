package com.chitra.school.enums;

public enum PaymentType {
	INCOME("1"),
	EXSPENSE("2");
	
	private String paymentType;
	
	private PaymentType(final String PaymentType){
		this.paymentType = PaymentType;
	}

	public String getPaymentType() {
		return paymentType;
	}
	@Override
	public String toString() {
		return this.paymentType;
	}
}
