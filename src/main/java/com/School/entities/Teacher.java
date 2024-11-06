package com.School.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Teacher {
	 @Id
	  
	 	@Column(name="Teacher_ID")
	    private Long teacherId;
	 	
	 	@Column(name = "T_FullName",length = 100)
	    private String fullname;
	 	
	 	@Column(name = "Specialization",length = 50)
	    private String specialization;

	    @OneToMany(mappedBy = "teacher")
	    private List<Class> classes;

	   @OneToMany(mappedBy = "teacher")
	    private List<Subject> subjects;

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Teacher(Long teacherId, String fullname, String specialization, List<Class> classes,
			List<Subject> subjects) {
		super();
		this.teacherId = teacherId;
		this.fullname = fullname;
		this.specialization = specialization;
		this.classes = classes;
		this.subjects = subjects;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", fullname=" + fullname + ", specialization=" + specialization
				+ ", classes=" + classes + "]";
	}

	   
}