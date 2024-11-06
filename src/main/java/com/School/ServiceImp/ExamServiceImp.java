package com.School.ServiceImp;

import com.School.Service.ExamService;
import com.School.Dao.ExamDao;
import com.School.DaoImp.ExamDaoImp;
import com.School.entities.Exam;

import java.util.List;

public class ExamServiceImp implements ExamService {

    // Instantiate ExamDao with ExamDaoImp
    ExamDao examDao = new ExamDaoImp();

    // Constructor-based dependency injection
    public ExamServiceImp(ExamDao examDao) {
        this.examDao = examDao;
    }
    // Create a new Exam
    @Override
    public Exam createExam(Exam exam) {
        return examDao.createExam(exam); // Call the DAO to create the Exam entity
    }

    // Retrieve all Exams
    @Override
    public List<Exam> getAllExams() {
        return examDao.getAllExams(); // Fetch all Exam records from the DAO
    }

    // Retrieve a specific Exam by its ID
    @Override
    public Exam getExamById(Long examId) {
        return examDao.getExamById(examId); // Fetch an Exam by its ID
    }

    // Update an existing Exam
    @Override
    public Exam updateExam(Long examId, Exam updatedExam) {
        return examDao.updateExam(examId, updatedExam); // Update the Exam record in the DAO
    }

    // Delete an Exam by its ID
    @Override
    public String deleteExam(Long examId) {
        return examDao.deleteExam(examId); // Delete the Exam using its ID
    }

    // Optional: Retrieve Exams by Subject ID
    @Override
    public List<Exam> getExamsBySubjectId(Long subjectId) {
        return examDao.getExamsBySubjectId(subjectId); // Get Exams associated with a specific Subject
    }
}
