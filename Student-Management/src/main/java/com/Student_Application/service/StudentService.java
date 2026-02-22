package com.Student_Application.service;



import java.util.List;

import com.Student_Application.entity.Student;


public interface StudentService {

    List<Student> getAllStudents();
    Student saveStudent(Student student);
}
