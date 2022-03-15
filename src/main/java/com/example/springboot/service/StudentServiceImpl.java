package com.example.springboot.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Student;
import com.example.springboot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentrepository;
	
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentrepository.findAll();
	}

	@Override
	public void saveStudent(Student student) {
		this.studentrepository.save(student);
		
	}

	@Override
	public Student getStudentById(long id) {
		Optional<Student> optional = studentrepository.findById(id);
		Student student = null;
		if(optional.isPresent()) {
			student = optional.get();
		}else {
			throw new RuntimeException("Student not found for id: " +id);
		}
		return student;
	}

	@Override
	public void deleteStudentById(long id) {
		this.studentrepository.deleteById(id);
		
	}

}
