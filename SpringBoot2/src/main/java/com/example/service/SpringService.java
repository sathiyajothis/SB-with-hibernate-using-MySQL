package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Student;
import com.example.dao.SpringDao;

@Service
public class SpringService 
{
	@Autowired
	SpringDao dao;
	public boolean validateUser(String name, String password) 
	{
		System.out.println("User Name "+name+" Password "+password);
		return dao.isValidUser( name,  password);
	}
	
	public List<Student> getAllStudents()
	{
		
		return dao.getAllStudents();
		
	}
	public void saveStudent(Student std) 
	{
		
		 dao.saveStudent(std);
	}
		
	public Student getStudentWithId(String Id)
	{
		return dao.getStudentWithId(Id);
	}
	
	public void updateStudent(String stdId,String studentName,double percentage)
	{
		dao.updateStudent(stdId, studentName, percentage);
	}

	public void deleteStudent(String studentId) 
	{
		dao.deleteStudent(studentId);
		
	}

}
