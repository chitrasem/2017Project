package com.chitra.school.dao;

public class Balance {

	private double tot_inc_amt_km;
	private double tot_inc_amt_us;
	private double tot_exp_amt_km;
	private double tot_exp_amt_us;
	private double curBalance_km;
	private double curBalance_us;
	public double getTot_inc_amt_km() {
		return tot_inc_amt_km;
	}
	public void setTot_inc_amt_km(double tot_inc_amt_km) {
		this.tot_inc_amt_km = tot_inc_amt_km;
	}
	public double getTot_inc_amt_us() {
		return tot_inc_amt_us;
	}
	public void setTot_inc_amt_us(double tot_inc_amt_us) {
		this.tot_inc_amt_us = tot_inc_amt_us;
	}
	public double getTot_exp_amt_km() {
		return tot_exp_amt_km;
	}
	public void setTot_exp_amt_km(double tot_exp_amt_km) {
		this.tot_exp_amt_km = tot_exp_amt_km;
	}
	public double getTot_exp_amt_us() {
		return tot_exp_amt_us;
	}
	public void setTot_exp_amt_us(double tot_exp_amt_us) {
		this.tot_exp_amt_us = tot_exp_amt_us;
	}
	public double getCurBalance_km() {
		return curBalance_km;
	}
	public void setCurBalance_km(double curBalance_km) {
		this.curBalance_km = curBalance_km;
	}
	public double getCurBalance_us() {
		return curBalance_us;
	}
	public void setCurBalance_us(double curBalance_us) {
		this.curBalance_us = curBalance_us;
	}
	
	

}
