package com.example.demo.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;
import com.example.demo.service.StudentServiceImpl;

import nonapi.io.github.classgraph.utils.Assert;

@SpringBootTest
class SaveStudentTest {
    @Autowired
    private StudentRepo repo;
    @Autowired
    private StudentServiceImpl st;

    @Test
    void saveStudent(){
        Student s=new Student(0, null, null);
        s.setId(1);
        s.setDepartment("ECE");
        s.setName("Revanth");
        repo.save(s);
        Optional<Student> es=repo.findById(s.getId());
         Student ns=es.get(); 
         assertEquals(s.getId(),ns.getId());
         assertEquals(s.getDepartment(),ns.getDepartment());
        assertEquals(s.getName(),ns.getName());
        
        }   
    }
    

