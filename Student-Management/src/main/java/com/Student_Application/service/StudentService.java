package com.Student_Application.service;

import java.util.List;
import com.Student_Application.entity.Student;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}