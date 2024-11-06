package com.School.Service;

import com.School.entities.Result;
import java.util.List;

public interface ResultService {

    // Create a new Result
    Result createResult(Result result);

    // Retrieve all Results
    List<Result> getAllResults();

    // Retrieve a specific Result by its ID
    Result getResultById(Long resultId);

    // Update an existing Result
    Result updateResult(Long resultId, Result updatedResult);

    // Delete a Result by its ID
    String deleteResult(Long resultId);

    // Get Results by Student ID (optional, based on your use case)
    List<Result> getResultsByStudentId(Long studentId);
    
    // Get Results by Subject ID (optional, based on your use case)
    List<Result> getResultsBySubjectId(Long subjectId);
}
