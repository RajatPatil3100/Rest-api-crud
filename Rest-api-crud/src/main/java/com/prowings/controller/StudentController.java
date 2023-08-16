package com.prowings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.prowings.entity.Student;
import com.prowings.service.StudentService;


@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student std){
		System.out.println("Request received to create student :" + std);
		
		if(studentService.saveStudent(std))
			return std;
		else
			return null;
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student std) {
		System.out.println("request received to update student  : " + std);
		
		return studentService.updateStudent(std);
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		System.out.println("request received to get student of id : " + id);

		Student retrivedStudent = studentService.getStudent(id);

		return retrivedStudent;

	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		System.out.println("request received to get all students");
		
		return studentService.getStudents();
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudentById(@PathVariable("id") int id) {
		System.out.println("request received to delete student with id : "+id);
		
		if(studentService.deleteStudent(id))
			return "Student deleted successfully!!";
		else
			return "error while deleteing specified student!!!";
	}
	
}
