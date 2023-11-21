package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.service.StudentInterface;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentInterface{

	@Autowired
	private StudentRepo repo;
	
    @Override
    public Student save(Student student) {
        return repo.save(student);
    }

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	// @Value("${myapplication.message}")
    // private String welcomeMessage;

    // public String retrieveWelcomeMessage() {
    //     //Complex Method
    //     return welcomeMessage;
    // }
	@Override
	public Student getStudentById(int id) throws StudentNotFoundException {
		// TODO Auto-generated method stub

		Optional<Student> student=repo.findById(id);
		if(student.isPresent()){
			return student.get();
		}
		else{
			 throw new StudentNotFoundException("Student id: "+ id +" not found");
		}
		
	}

    @Override
	public Student updateStudentById(Student updateStudent,int id) {
        Optional<Student> student = repo.findById(id);
        if(student.isPresent()) {
        	Student existStudent=student.get();
        	existStudent.setDepartment(updateStudent.getDepartment());
        	existStudent.setName(updateStudent.getName());
        	repo.save(existStudent);
            return student.get();
        } else {
            throw new StudentNotFoundException("Student id: "+ id +" not found");
        }
    }



	@Override
	public void deleteStudentById(int id) throws StudentNotFoundException{
		Optional<Student> student=repo.findById(id);
		if(student.isPresent()){
			repo.deleteById(id);;
		}
		else{
			 throw new StudentNotFoundException("Student id: "+ id +" not found");
		}
		
		
		
	}
	
    
    
}