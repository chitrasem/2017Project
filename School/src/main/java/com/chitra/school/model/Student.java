package com.chitra.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="TB_STUDENT")
public class Student {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", length=13)
	private long id;    
    //Basic Info
    @NotEmpty
    @Column(name = "FIRST_NAME", nullable=false, length=20)
	private String firstName;    
    @NotEmpty
    @Column(name = "LAST_NAME", nullable=false, length=20)
	private String lastName;
    @NotEmpty
    @Column(name="KM_FIRST_NAME", nullable=false, length=20)
    private String kmFirstName;
    @NotEmpty
    @Column(name="KM_LAST_NAME", nullable=false, length=20)
    private String kmLastName;  
    @NotEmpty
    @Column(name="GENDER", nullable=false, length=1)
    private String gender;
    @Column(name="BIRTH_DATE", length=10)
    private String birthDate;
    @Column(name="BIRTH_PLACE", length=200)
    private String birthPlace;
    @Column(name="BIOGRAPHY", length=500)
    private String biography;
    
    //Contact Info
    @Column(name="PHONE1", length=10)
    private String phone1;
    @Column(name="PHONE2", length=10)
    private String phone2;
    @Column(name="EMAIL", length=50)
    private String email;
    @Column(name="CURRENT_ADDR", length=200)
    private String currentAddr;    
    
    // Family Contact
    @Column(name="MOTHER_NAME", length=20)
    private String motherName;
    @Column(name="MOTHER_PHONE", length=20)
    private String motherPhone;
    @Column(name="FATHER_NAME", length=20)
    private String fatherName;
    @Column(name="FATHER_PHONE", length=20)
    private String fatherPhone;
    
    @Column(name="ENROLL_DATE")
    private String enroll_date;

    @Column(name="REGISTER_PERSON")
    private String registerPerson;
    @Column(name="REGISTER_DATE")
    private String registerDate;
    @Column(name="CHANGE_PERSON")
    private String changePerson;
    @Column(name="CHANGE_DATE")
    private String changeDate;

    @Column(name = "STUDENT_ID", nullable=false, length=10, unique= true)
    private String studentId;
    

    @NotEmpty
    @Column(name="STATE", nullable=false)
    private String state=State.INACTIVE.getState();
    
    
    // New Field appended
    @Column(name="AGE")
    private String age;


	public long getId() {
		return id;
	}


	public void setId(long id) {
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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public String getBirthPlace() {
		return birthPlace;
	}


	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}


	public String getBiography() {
		return biography;
	}


	public void setBiography(String biography) {
		this.biography = biography;
	}


	public String getPhone1() {
		return phone1;
	}


	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}


	public String getPhone2() {
		return phone2;
	}


	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCurrentAddr() {
		return currentAddr;
	}


	public void setCurrentAddr(String currentAddr) {
		this.currentAddr = currentAddr;
	}


	public String getMotherName() {
		return motherName;
	}


	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}


	public String getMotherPhone() {
		return motherPhone;
	}


	public void setMotherPhone(String motherPhone) {
		this.motherPhone = motherPhone;
	}


	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public String getFatherPhone() {
		return fatherPhone;
	}


	public void setFatherPhone(String fatherPhone) {
		this.fatherPhone = fatherPhone;
	}


	public String getEnroll_date() {
		return enroll_date;
	}


	public void setEnroll_date(String enroll_date) {
		this.enroll_date = enroll_date;
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


	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	
	
	}
