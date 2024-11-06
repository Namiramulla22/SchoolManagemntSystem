package com.School.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Attendance {

    @Id
    @Column(name = "attendance_id")
    private Long attendanceId;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private String status;

    // Many-to-One with Student
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Many-to-One with Class
    @ManyToOne
    @JoinColumn(name = "ClassId") // Assuming you meant to map Class with class_id
    private Class aClass;

    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Attendance(Long attendanceId, Date date, String status, Student student, Class aClass) {
        super();
        this.attendanceId = attendanceId;
        this.date = date;
        this.status = status;
        this.student = student;
        this.aClass = aClass;
    }

    public Attendance() {
        super();
    }

    @Override
    public String toString() {
        return "Attendance [attendanceId=" + attendanceId + ", date=" + date + ", status=" + status + ", student="
                + student + ", class=" + aClass + "]";
    }

	public String isPresent() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPresent(boolean presentStatus) {
		// TODO Auto-generated method stub
		
	}

	public void setDate(String attendanceDate) {
		// TODO Auto-generated method stub
		
	}

	public void setClass(Class schoolClass) {
		// TODO Auto-generated method stub
		
	}


}
