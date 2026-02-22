package com.Student_Application.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Student_Application.entity.Student;
import com.Student_Application.exception.Resource;
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
    public Student getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new Resource("Student Not Found"));
    }

    @Override
    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {

        Student existing = repo.findById(id)
                .orElseThrow(() -> new Resource("Student Not Found"));

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setAge(student.getAge());

        return repo.save(existing);
    }

    @Override
    public void deleteStudent(Long id) {

        Student existing = repo.findById(id)
                .orElseThrow(() -> new Resource("Student Not Found"));

        repo.delete(existing);
    }
}