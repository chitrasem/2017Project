package com.chitra.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tb_memo")
public class Memo{
	
	@Id
    @GenericGenerator(name = "sequence_memo_id", strategy = "com.chitra.school.id.MemoIdGenerator")
    @GeneratedValue(generator = "sequence_memo_id")
    @Column(name = "MEMO_ID",unique = true, nullable = false, length = 10)
	private String id;
	
	@Column(name="content", length=500)
	private String content;
	@Column(name="registerPerson", length=50)
	private String registerPerson;
	@Column(name="registerDate", length=14)
	private String registerDate;
	@ManyToOne(optional=true)
	@JoinColumn(name="student_id")
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