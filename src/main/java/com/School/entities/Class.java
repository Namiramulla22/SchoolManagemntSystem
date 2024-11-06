package com.School.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Class {
	@Id
	@Column(name = "ClassId")
    private Long classId;
	
	@Column(name = "Name",length = 50)
    private String name;
	
	@Column(name = "Section",length = 10)
    private String section;

	@OneToMany(mappedBy = "classes", fetch = FetchType.EAGER)
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Class(Long classId, String name, String section, List<Student> students, Teacher teacher) {
		super();
		this.classId = classId;
		this.name = name;
		this.section = section;
		this.students = students;
		this.teacher = teacher;
	}
	

	public Class(Long classId) {
		super();
		this.classId = classId;
	}

	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Class [classId=" + classId + ", name=" + name + ", section=" + section + ", students=" + students
				+ ", teacher=" + teacher + "]";
	}

	public String getaClassId() {
		// TODO Auto-generated method stub
		return null;
	}


}
