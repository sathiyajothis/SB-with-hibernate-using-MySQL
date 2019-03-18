package com.example.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bean.LoginUser;
import com.example.bean.Student;

@Repository
public class SpringDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Transactional
	public boolean isValidUser(String name, String password) {


		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LoginUser.class);
		criteria.add(Restrictions.eq("userId", name));
		criteria.add(Restrictions.eq("password", password));

		LoginUser result = (LoginUser) criteria.uniqueResult();

		if(result!=null)
			return true;
		else
			return false;
	}
	@Transactional
	public List<Student> getAllStudents()
	{

		return (sessionFactory.getCurrentSession().createQuery(" from Student ")).list();

	}

	@Transactional
	public Student getStudentWithId(String stdId)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
		criteria.add(Restrictions.eq("stdId", stdId));
		Student result = (Student) criteria.uniqueResult();
		//System.out.println("Student Name "+result.getStudentName());
		return result;

	}

	@Transactional
	public void updateStudent(String stdId,String studentName,double percentage) 
	{
		Student student = new Student();
        student.setStdId(stdId);
        student.setStudentName(studentName);
        student.setPercentage(percentage);
        sessionFactory.getCurrentSession().update(student);
	}
	@Transactional
	public void saveStudent(Student std)
	{
		
        sessionFactory.getCurrentSession().save(std);
		
		
	}
	@Transactional
	public void deleteStudent(String studentId) 
	{
		Student std=new Student();
		std.setStdId(studentId);
        sessionFactory.getCurrentSession().delete(std);
	}

}
