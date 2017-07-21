package com.chitra.school.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.chitra.school.utils.StringUtils;

@Table(name="GENERATION")
@Entity
public class Generation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="generation_id", nullable=false, unique=true)
	private long id;
	private String generation;
	
	//yyyy-MM
	@Column(name="CLASS_START", nullable=false, length=6)
	private String classStart;
	@Column(name="REGISTER_DATE", length=14, nullable=false)
	private String registerDate = StringUtils.getSystemDate();
	@Column(name="REGISTER_PERSON", nullable=false,length=50)
	private String registerPerson;
	
	@Column(name="DESCRIPTION", length=500)
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGeneration() {
		return generation;
	}
	public void setGeneration(String generation) {
		this.generation = generation;
	}
	public String getClassStart() {
		return classStart;
	}
	public void setClassStart(String classStart) {
		this.classStart = classStart;
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
