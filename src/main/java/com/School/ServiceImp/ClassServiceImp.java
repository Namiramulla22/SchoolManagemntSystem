package com.School.ServiceImp;

import com.School.Dao.ClassDao;
import com.School.DaoImp.ClassDaoimp;
import com.School.Service.ClassService;
import com.School.entities.Class;

import java.util.List;

public class ClassServiceImp implements ClassService {

    ClassDao classDao= new ClassDaoimp() ;

    // Constructor-based dependency injection
    public ClassServiceImp(ClassDao classDao) {
        this.classDao = classDao;
    }

    @Override
    public Class createClass(Class classes) {
        return classDao.createClass(classes);
    }

    @Override
    public List<Class> getAllClasses() {
        return classDao.getAllClasses();
    }

    @Override
    public Class getClassById(Long classId) {
        return classDao.getClassById(classId);
    }

    @Override
    public Class updateClass(Long classId, Class updatedClass) {
        return classDao.updateClass(classId, updatedClass);
    }

    @Override
    public String deleteClass(Long classId) {
        return classDao.deleteClass(classId);
    }

    @Override
    public List<Class> getClassesByTeacherId(Long teacherId) {
        return classDao.getClassesByTeacherId(teacherId);
    }
    
    @Override
    public List<Class> getClassesByStudentId(Long studentId) {
        return classDao.getClassesByStudentId(studentId);
    }
}
