package com.chitra.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import com.chitra.school.utils.StringUtils;

@Entity
@Table(name="TB_STUDENT")
public class Student {
    @Id 
    @GenericGenerator(name = "sequence_stu_id", strategy = "com.chitra.school.id.StudentIdGenerator")
    @GeneratedValue(generator = "sequence_stu_id")
    @Column(name = "STUDENT_ID",unique = true, nullable = false, length = 10)
	private String id;
	
    //Basic Info
    @NotEmpty
    @Column(name = "FIRST_NAME", nullable=false)
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
    @Column(name="BIRTH_DATE", length=8)
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
    @Column(name="MOTHER_NAME", length=50)
    private String motherName;
    @Column(name="MOTHER_PHONE", length=10)
    private String motherPhone;
    
    @Column(name="FATHER_NAME", length=50)
    private String fatherName;
    @Column(name="FATHER_PHONE", length=10)
    private String fatherPhone;
    
    @Column(name="ENROLL_DATE", length=8)
    private String enroll_date;

    @Column(name="REGISTER_PERSON", length=50)
    private String registerPerson;

    @Column(name="REGISTER_DATE", length=14)
    private String registerDate = StringUtils.getStrDate();
    @Column(name="CHANGE_PERSON",length=50)
    private String changePerson;
    @Column(name="CHANGE_DATE", length=14)
    private String changeDate = StringUtils.getStrDate();
    
    @Column(name="IMG_URL")
    private String imageUrl;
    @Column(name="IMG_PATH")
    private String imagePath;
    
    @ManyToOne(optional=true, fetch = FetchType.LAZY)
	@JoinColumn(name="COURSE_ID")
	private Course course;
    

    @ManyToOne(optional=true, fetch = FetchType.LAZY)
	 @JoinColumn(name="STS_ID")
	 private STSession sTSession;

	@NotEmpty
    @Column(name="STATE", nullable=false)
    private String state=State.INACTIVE.getState();
    // New Field appended
    @Column(name="AGE")
    private String age;
    


    

    public STSession getsTSession() {
		return sTSession;
	}
	public void setsTSession(STSession sTSession) {
		this.sTSession = sTSession;
	}
    


    public Course getCource() {
		return course;
	}
	public void setCource(Course cource) {
		this.course = cource;
	}
	public STSession getSession() {
		return sTSession;
	}
	public void setSession(STSession session) {
		this.sTSession = session;
	}
	public String getImageUrl(){
    	return imageUrl;
    }
    public void setImageUrl(String imageUrl){
    	this.imageUrl = imageUrl;
    }
	public String getId() {
		return id;
	}


	public void setId(String id) {
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
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Course getClassroom() {
		return course;
	}
	public void setClassroom(Course classroom) {
		this.course = classroom;
	}


	
	
	
	}
