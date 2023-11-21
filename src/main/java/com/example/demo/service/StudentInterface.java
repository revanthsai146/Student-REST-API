package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;

public interface StudentInterface {
	public Student save(Student student);
	public List<Student> getAllStudents();
	public Student getStudentById(int id)throws StudentNotFoundException;
	public Student updateStudentById(Student student,int id)throws StudentNotFoundException;
	public void deleteStudentById(int id)throws StudentNotFoundException;

}
