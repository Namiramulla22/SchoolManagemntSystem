package com.School.ServiceImp;

import com.School.Dao.SubjectDao;
import com.School.DaoImp.SubjectDaoImp;
import com.School.Service.SubjectService;
import com.School.entities.Subject;

import java.util.List;

public class SubjectServiceImp implements SubjectService {

    private final SubjectDao subjectDao;

    // Constructor-based dependency injection
    public SubjectServiceImp(SubjectDao subjectDao) {
        this.subjectDao = subjectDao != null ? subjectDao : new SubjectDaoImp(); // Fallback to default implementation if null
    }

    @Override
    public Subject createSubject(Subject subject) {
        return subjectDao.createSubject(subject);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectDao.getAllSubjects();
    }

    @Override
    public Subject getSubjectById(Long subjectId) {
        return subjectDao.getSubjectById(subjectId);
    }

    @Override
    public Subject updateSubject(Long subjectId, Subject updatedSubject) {
        return subjectDao.updateSubject(subjectId, updatedSubject);
    }

    @Override
    public String deleteSubject(Long subjectId) {
        return subjectDao.deleteSubject(subjectId);
    }

    @Override
    public List<Subject> getSubjectsByExamId(Long examId) {
        return subjectDao.getSubjectsByExamId(examId);
    }
}
