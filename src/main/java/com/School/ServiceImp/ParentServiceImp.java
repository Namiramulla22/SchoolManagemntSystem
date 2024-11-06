package com.School.ServiceImp;

import com.School.Dao.ParentDao;
import com.School.DaoImp.ParentDaoImp;
import com.School.Service.ParentService;
import com.School.entities.Parent;
import com.School.entities.Student;

import java.util.List;

public class ParentServiceImp implements ParentService {
	ParentDao parentDao = new ParentDaoImp();

    public ParentServiceImp(ParentDaoImp parentDaoImp) {
		// TODO Auto-generated constructor stub
	}

	@Override
    public Parent createParent(Parent parent) {
        return parentDao.createParent(parent);
    }

    @Override
    public List<Parent> getAllParents() {
        return parentDao.getAllParents();
    }

    @Override
    public Parent getParentById(Long parentId) {
        return parentDao.getParentById(parentId);
    }

    @Override
    public Parent updateParent(Long parentId, Parent updatedParent) {
        return parentDao.updateParent(parentId, updatedParent);
    }

    @Override
    public String deleteParent(Long parentId) {
        return parentDao.deleteParent(parentId);
    }

    @Override
    public List<Student> getStudentsByParentId(Long parentId) {
        return parentDao.getStudentsByParentId(parentId);
    }
}
