package com.School.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Result {

    @Id
    @Column(name = "resultId")
    private Long resultId;

    @Column(name = "marks_obtained")
    private Double marksObtained;

    @Column(name = "total_marks")
    private Double totalMarks;

    @Column(name = "grade")
    private String grade;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

	public Long getResultId() {
		return resultId;
	}

	public void setResultId(Long resultId) {
		this.resultId = resultId;
	}

	public Double getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(Double marksObtained) {
		this.marksObtained = marksObtained;
	}

	public Double getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Double totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Result(Long resultId, Double marksObtained, Double totalMarks, String grade, Student student,
			Subject subject) {
		super();
		this.resultId = resultId;
		this.marksObtained = marksObtained;
		this.totalMarks = totalMarks;
		this.grade = grade;
		this.student = student;
		this.subject = subject;
	}

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Result [resultId=" + resultId + ", marksObtained=" + marksObtained + ", totalMarks=" + totalMarks
				+ ", grade=" + grade + ", student=" + student + ", subject=" + subject + "]";
	}

    
    
}