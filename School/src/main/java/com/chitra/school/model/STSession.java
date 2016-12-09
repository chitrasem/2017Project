package com.chitra.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.chitra.school.utils.StringUtils;

@Entity
@Table(name="TB_ST_SESSION")
public class STSession{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	@Id
	private int id;
	
	@Column(name="SESSION")
	private String session;
	
	@Column(name="REGISTER_DATE")
	private String registerDate = StringUtils.getSystemDate();
	
	@Column(name="REGISTER_PERSON")
	private String registerPerson;
	
	@Column(name="STATE")
	 private String state = State.ACTIVE.getState();
	 
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
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
