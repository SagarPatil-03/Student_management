package com.Student_Application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Student_Application.entity.Student;
import com.Student_Application.exception.Resource;
import com.Student_Application.repository.StudentRepository;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Student add(@RequestBody Student s) {
    	
        return repo.save(s);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student s) {
        Student st = repo.findById(id).orElseThrow(()-> new Resource("Not Found"));
        st.setName(s.getName());
        st.setEmail(s.getEmail());
        st.setAge(s.getAge());
       Student s1= repo.save(st);
       
       return ResponseEntity.ok(s1);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
