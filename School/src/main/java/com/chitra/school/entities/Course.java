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
@Table(name="TB_COURSE")
public class Course{
	
	 @Id 
	/* @GenericGenerator(name = "sequence_cls_id", strategy = "com.chitra.school.id.ClassroomIdGenerator")
	 @GeneratedValue(generator = "sequence_cls_id")*/
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name = "ID",unique = true, nullable = false, length = 10)	 
	 private int id;
	 @Column(name="COURSE", nullable=false, length=25)
	 private String course;
	 @Column(name="REGISTER_DATE", length=14, nullable = false)
	 private String registerDate; // = StringUtils.getSystemDate();
	 @Column(name="REGISTER_PERSON", length = 25, nullable = false)
	 private String registerPerson;
	 @Column(name="DESCRIPTION", length=500)
	 private String descritpion;
	 
	 
	 
	 
	 @ManyToOne(optional=true, fetch = FetchType.LAZY)
	 @JoinColumn(name="ACY_ID")
	 private AcademicYear academicYear;
	 
	 @ManyToOne(optional=true, fetch = FetchType.LAZY)
	 @JoinColumn(name="grade_id")
	 private Grade grade;
	 
	 
	 
	 public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Column(name="STATE")
	 private String state;// = State.ACTIVE.getState();
	 
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
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

	public String getDescritpion() {
		return descritpion;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}

	public AcademicYear getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	
	

}
