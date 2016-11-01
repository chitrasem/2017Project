package com.chitra.school.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="APP_STUDENT")
public class Student {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
	private int id;
    
    @Column(name = "FIRST_NAME", nullable=false)
	private String firstName;
    
    @Column(name = "LAST_NAME", nullable=false)
	private String lastName;
    
    private String kmFirstName;
    private String kmLastName;
    
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(name = "BIRTHDATE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate dateOfBirth;
    
    @Column(name = "GENDER", nullable=false)
	private String gender;
    private String nationality;
    private boolean isMarried;
    private String stu_id;
    
    
    private String phoneNumber;
    private String emailaddress;
    private String currentAddress;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID")
    private User user;
    
    
 
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "APP_STUDENT_SUBJECT",
    		joinColumns = { @JoinColumn(name = "STUDENT_ID")},
    		inverseJoinColumns = { @JoinColumn(name = "SUBJECT_ID")}
    		)
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	public String getKmFirstName() {
		return kmFirstName;
	}
	public void setKmFirstName(String kmFirstName) {
		this.kmFirstName = kmFirstName;
	}
	public String getKmLastName() {
		return kmLastName;
	}
	public void setKmLastName(String kmLastName) {
		this.kmLastName = kmLastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public boolean getMaritalStatus() {
		return isMarried;
	}
	public void setMaritalStatus(boolean isMarried) {
		this.isMarried = isMarried;
	}
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
