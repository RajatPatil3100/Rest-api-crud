package com.prowings.dao;

import java.util.List;

import com.prowings.entity.Student;

public interface StudentDao {

	public boolean saveStudent(Student std);
	
	public Student getStudent(int id);
	
	public List<Student> getStudents();
	
	public boolean deleteStudent(int id);
	
	public Student updateStudent(Student std);
}
