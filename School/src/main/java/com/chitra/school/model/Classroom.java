package com.chitra.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.chitra.school.utils.DateUtils;
import com.chitra.school.utils.StringUtils;

@Entity
@Table(name="TB_CLASSROOM")
public class Classroom {
	
	 @Id 
	 @GenericGenerator(name = "sequence_stu_id", strategy = "com.chitra.school.id.StudentIdGenerator")
	 @GeneratedValue(generator = "sequence_stu_id")
	 @Column(name = "STUDENT_ID",unique = true, nullable = false, length = 10)	 
	 private String id;
	 @Column(name="CLASSROOM", nullable=false, length=25)
	 private String classroom;
	 @Column(name="GENERATION", nullable=false, length=5)
	 private int generation;
	 @Column(name="ACADEMIC_YEAR", nullable = false, length=9)
	 private String academic_year;
	 @Column(name="REGISTER_DATE", length=14, nullable = false)
	 private String registerDate = StringUtils.getSystemDate();
	 @Column(name="REGISTER_PERSON", length = 25, nullable = false)
	 private String registerPerson;
	 @Column(name="DESCRIPTION", length=50)
	 private String descritpion;
	 
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public int getGeneration() {
		return generation;
	}
	public void setGeneration(int generation) {
		this.generation = generation;
	}
	public String getAcademic_year() {
		return academic_year;
	}
	public void setAcademic_year(String academic_year) {
		this.academic_year = academic_year;
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
	 
	 
	
	
	
	 
	

	
	
	

}
