package com.School.Dao;

import com.School.entities.Parent;
import com.School.entities.Student;

import java.util.List;

public interface ParentDao {
	 // Create a new Parent
    Parent createParent(Parent parentEntity);

    // Retrieve all Parents
    List<Parent> getAllParents();

    // Retrieve a specific Parent by its ID
    Parent getParentById(Long parentId);

    // Update an existing Parent
    Parent updateParent(Long parentId, Parent updatedParent);

    // Delete a Parent by its ID
    String deleteParent(Long parentId);

    // Get Students by Parent ID (optional, based on your use case)
    List<Student> getStudentsByParentId(Long parentId);
}
