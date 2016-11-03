package com.chitra.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_MEMO")
public class Memo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMO_ID", length = 13)
	private String id;

	@Column(length = 200, name = "CONTENT")
	private String content;
	@Column(length = 200, name = "REGISTER_PERSON")
	private String registerPerson;
	@Column(name = "REGISTER_DATE")
	private String registerDate;
	
	@JoinColumn(name="STU_ID")
	@ManyToOne(optional = true)
	private Student student;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegisterPerson() {
		return registerPerson;
	}

	public void setRegisterPerson(String registerPerson) {
		this.registerPerson = registerPerson;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
