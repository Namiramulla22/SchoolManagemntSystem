package com.School.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subject {

    @Id
    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "subject_name", length = 50)
    private String subjectName;

    // Many-to-Many relationship with Exam
    @ManyToMany(mappedBy = "subjects")
    private List<Exam> exams;
    
    @ManyToOne
    @JoinColumn(name = "teacher_id") // This should match the column name in your database
    private Teacher teacher;


	public Long getSubjectId() {
		return subjectId;
	}

	public Subject(Teacher teacher) {
		super();
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Subject(Long subjectId, String subjectName, List<Exam> exams) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.exams = exams;
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", exams=" + exams + ", teacher="
				+ teacher + "]";
	}

 
}
