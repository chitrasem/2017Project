package com.chitra.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.chitra.school.utils.StringUtils;
@Entity
@Table(name="TB_ACADEMIC_YEAR")
public class AcademicYear {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", unique = true, nullable = false)
	@Id
	private int id;
	
	@Column(name="ACADEMIC_YEAR",nullable =false)
	private String academicYear;
	
	@Column(name="REGISTER_DATE")
	private String registerDate = StringUtils.getSystemDate();
	@Column(name="REGISTER_PERSON")
	private String registerPerson;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getRegisterPerson() {
		return registerPerson;
	}
	public void setRegisterPerson(String registerPerson) {
		this.registerPerson = registerPerson;
	}
	
	
	
}
