package com.School.ServiceImp;

import com.School.Dao.TeacherDao;
import com.School.DaoImp.TeacherDaoImp;
import com.School.Service.TeacherService;
import com.School.entities.Teacher;

import java.util.List;

public class TeacherServiceImp implements TeacherService {

    TeacherDao teacherDao = new TeacherDaoImp();
    
    public TeacherServiceImp(TeacherDao teacherdao2) {
		// TODO Auto-generated constructor stub
	}

	@Override
    public Teacher createTeacher(Teacher teacher) {
    	return teacherDao.createTeacher(teacher);
    }
    
    @Override
    public List<Teacher>getAllTeachers(){
    	return teacherDao.getAllTeachers();
    }
    
    @Override
    public Teacher getTeacher(Long teacherId) {
    	return teacherDao.getTeacher(teacherId);
    }
    
    @Override
    public Teacher updateTeacher(Long teacherId,Teacher updateTeacher) {
    	return teacherDao.updateTeacher(teacherId, updateTeacher);
    }
    
    @Override
    public String deleteTeacher(Long teacherId) {
    	return teacherDao.deleteTeacher(teacherId);
    }
    
    @Override
    public List<Teacher>getTeachersByClassId(Long classId){
    	return teacherDao.getTeachersByClassId(classId);
    }
    
    @Override
    public List<Teacher>getTeachersBySubjectId(Long subjectId){
    	return teacherDao.getTeachersBySubjectId(subjectId);
    }
}
