package com.chitra.school.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_CLASSROOM")
public class Classroom {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ROOM_ID",unique = true, nullable = false, length = 10)	 
	private String id;
	@ManyToOne(optional=true, fetch = FetchType.LAZY)
	@JoinColumn(name="GRADE_ID")
	private Grade grade;	 
	@ManyToOne(optional=true, fetch = FetchType.LAZY)
	@JoinColumn(name="TEACHER_ID")
	private Staff staff;	

	@ManyToOne(optional=true, fetch = FetchType.LAZY)
	@JoinColumn(name="ACY_ID")
	private AcademicYear academicYear;

	@Column(name="SECTION", length = 50)
	 private String section;
	@Column(name="STATUS", length = 10 )
	 private String status;
	@Column(name="REMARKS", length = 50)
	 private String remarks;
	@ManyToOne(optional=true, fetch = FetchType.LAZY)
	@JoinColumn(name="SESSION_ID")
	private STSession session;
	
	public STSession getSession() {
		return session;
	}
	public void setSession(STSession session) {
		this.session = session;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public AcademicYear getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	 
	
	

}
