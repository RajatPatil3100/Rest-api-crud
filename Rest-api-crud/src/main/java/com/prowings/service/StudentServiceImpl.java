package com.prowings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.dao.StudentDao;
import com.prowings.entity.Student;

@Service
public class StudentServiceImpl {
	
	@Autowired
	StudentDao studentDao;
	
	public boolean saveStudent(Student std) {
		return studentDao.saveStudent(std);
	}

	public Student getStudent(int id) {
		return studentDao.getStudent(id);
	}

	public List<Student> getStudents() {
		return studentDao.getStudents();
	}


	public boolean deleteStudent(int id) {
		return studentDao.deleteStudent(id);
	}


	public Student updateStudent(Student std) {
		return studentDao.updateStudent(std);
	}

	
}
