package com.School.ServiceImp;

import com.School.Dao.ResultDao;
import com.School.DaoImp.ResultDaoImp;
import com.School.Service.ResultService;
import com.School.entities.Result;

import java.util.List;

public class ResultServiceImp implements ResultService {

    private final ResultDao resultDao = new ResultDaoImp();

    public ResultServiceImp(ResultDaoImp resultDaoImp) {
		// TODO Auto-generated constructor stub
	}

	@Override
    public Result createResult(Result result) {
        return resultDao.createResult(result);
    }

    @Override
    public List<Result> getAllResults() {
        return resultDao.getAllResults();
    }

    @Override
    public Result getResultById(Long resultId) {
        return resultDao.getResultById(resultId);
    }

    @Override
    public Result updateResult(Long resultId, Result updatedResult) {
        return resultDao.updateResult(resultId, updatedResult);
    }

    @Override
    public String deleteResult(Long resultId) {
        return resultDao.deleteResult(resultId);
    }

    @Override
    public List<Result> getResultsByStudentId(Long studentId) {
        return resultDao.getResultsByStudentId(studentId);
    }
    
    @Override
    public List<Result> getResultsBySubjectId(Long subjectId) {
        return resultDao.getResultsBySubjectId(subjectId);
    }
}
