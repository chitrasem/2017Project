package com.chitra.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="POSITION")
public class Position {

    @Id 
    @GenericGenerator(name = "sequence_position_id", strategy = "com.chitra.school.id.PositionIdGenerator")
    @GeneratedValue(generator = "sequence_position_id")
    @Column(name = "POSITION_ID",unique = true, nullable = false, length = 10)
	private long id;
    @Column(name="POSITION")
	private String positon;
	
    @Column(name="REGISTER_PERSON", length=50)
    private String registerPerson;

    @Column(name="REGISTER_DATE", length=14)
    private String registerDate;
    @Column(name="CHANGE_PERSON",length=50)
    private String changePerson;
    @Column(name="CHANGE_DATE", length=14)
    private String changeDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPositon() {
		return positon;
	}
	public void setPositon(String positon) {
		this.positon = positon;
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
	public String getChangePerson() {
		return changePerson;
	}
	public void setChangePerson(String changePerson) {
		this.changePerson = changePerson;
	}
	public String getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
    
    

}
