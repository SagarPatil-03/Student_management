package com.Student_Application.service.implementation;



import java.util.List;

import org.springframework.stereotype.Service;

import com.Student_Application.entity.Student;
import com.Student_Application.repository.StudentRepository;
import com.Student_Application.service.StudentService;



@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repo.save(student);
    }
}

