package com.School.Dao;

import com.School.entities.Class;
import java.util.List;

public interface ClassDao {

    // Create a new Class
    Class createClass(Class classes);

    // Retrieve all Classes
    List<Class> getAllClasses();

    // Retrieve a specific Class by its ID
    Class getClassById(Long classId);

    // Update an existing Class
    Class updateClass(Long classId, Class updatedClass);

    // Delete a Class by its ID
    String deleteClass(Long classId);

    // Get Classes by Teacher ID (optional, based on your use case)
    List<Class> getClassesByTeacherId(Long teacherId);
    
    // Get Classes by Student ID (optional, based on your use case)
    List<Class> getClassesByStudentId(Long studentId);
}
