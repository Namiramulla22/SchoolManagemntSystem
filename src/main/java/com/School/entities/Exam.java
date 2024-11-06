package com.School.entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Exam {

    @Id
    @Column(name = "exam_id")
    private Long examId;

    @Column(name = "exam_name", length = 50)
    private String examName;

    @Column(name = "exam_date")
    @Temporal(TemporalType.DATE)
    private Date examDate;

    @ManyToMany
    @JoinTable(
            name = "exam_subjects",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects = new ArrayList<>();;

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Exam(Long examId, String examName, Date examDate, List<Subject> subjects) {
		super();
		this.examId = examId;
		this.examName = examName;
		this.examDate = examDate;
		this.subjects = subjects;
	}

	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", examName=" + examName + ", examDate=" + examDate + ", subjects=" + subjects
				+ "]";
	}

    
    

}
