package com.chitra.school.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.chitra.school.utils.StringUtils;

@Entity
@Table(name="TB_GRADE")
public class Grade {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
    @Column(name = "GRADE_ID",unique = true, nullable = false, length = 10)	 
	private int grade_id;

	@Column(name = "NAME", nullable = false, length = 100)
	private String name;
	@Column(name = "DESCR",nullable = false, length = 200)
	private String descr;
	@Column(name="REG_DT")
	private String regDate = StringUtils.getStrDate();
	@Column(name="REG_NM")
	private String regNm;
	public int getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(int grade_id) {
		this.grade_id = grade_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getRegNm() {
		return regNm;
	}
	public void setRegNm(String regNm) {
		this.regNm = regNm;
	}
	
	
	
}
