package com.chitra.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.chitra.school.utils.StringUtils;

@Entity
@Table(name="TB_CLASSROOM")
public class Classroom {
	
	 @Id 
	 @GenericGenerator(name = "sequence_cls_id", strategy = "com.chitra.school.id.ClassroomIdGenerator")
	 @GeneratedValue(generator = "sequence_cls_id")
	 @Column(name = "CLASSROOM_ID",unique = true, nullable = false, length = 10)	 
	 private String id;
	 @Column(name="CLASSROOM", nullable=false, length=25)
	 private String classroom;
	 @Column(name="REGISTER_DATE", length=14, nullable = false)
	 private String registerDate = StringUtils.getSystemDate();
	 @Column(name="REGISTER_PERSON", length = 25, nullable = false)
	 private String registerPerson;
	 @Column(name="DESCRIPTION", length=500)
	 private String descritpion;
	 
	 
	 @ManyToOne(optional=true)
	 @JoinColumn(name="GENERATION_ID")
	 private Generation generation;
	 
	 
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
	public Generation getGeneration() {
		return generation;
	}
	public void setGeneration(Generation generation) {
		this.generation = generation;
	}
	 
	 
	
	
	
	 
	

	
	
	

}
