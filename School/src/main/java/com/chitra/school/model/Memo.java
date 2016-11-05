package com.chitra.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tb_memo")
public class Memo{
	
	@Id
    @GenericGenerator(name = "sequence_memo_id", strategy = "com.chitra.school.utils.MemoIdGenerator")
    @GeneratedValue(generator = "sequence_memo_id")
    @Column(name = "MEMO_ID",unique = true, nullable = false, length = 10)
	private String id;
	private String content;
	private String registerPerson;
	private String registerDate;
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
	
	
	
}