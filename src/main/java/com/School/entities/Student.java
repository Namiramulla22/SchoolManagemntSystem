package com.School.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Student {

    @Id
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "first_name",length=30)
    private String firstName;

    @Column(name = "last_name", length=30)
    private String lastName;

    @Column(name = "dob")
    private String dob;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
    
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classes;

    
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
    
     //One-to-Many with Result
     @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
     private List<Result> results;

    // One-to-Many with Attendance
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Attendance> attendances;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Class getaClass() {
		return classes;
	}

	public void setaClass(Class aClass) {
		this.classes = aClass;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	public Student(Long studentId, String firstName, String lastName, String dob, String address, String email,
			String phone, Class aClass, Parent parent, List<Result> results, List<Attendance> attendances) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.classes = aClass;
		this.parent = parent;
		this.results = results;
		this.attendances = attendances;
	}

	public Student(Long studentId) {
		super();
		this.studentId = studentId;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
				+ dob + ", address=" + address + ", email=" + email + ", phone=" + phone + ", aClass=" + classes
				+ ", parent=" + parent + ", results=" + results + ", attendances=" + attendances + "]";
	}
    
    
    

	}