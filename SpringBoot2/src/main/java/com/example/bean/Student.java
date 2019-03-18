package com.example.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Student")
public class Student 
{
	@Column
	String studentName;
	@Id
	String stdId;
	@Column
	double percentage;
	public Student()
	{
		System.out.println("Student Constructor called");
	}
	
	public Student(String stdId, String studentName, double percentage) {
	
		this.studentName = studentName;
		this.stdId = stdId;
		this.percentage = percentage;
	}

	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getGrade()
	{
		
		
		if(this.percentage>70)
		return"A";
		else if(this.percentage>60 && this.percentage<70)
		return "B";
		else
		return "C";
	}
	

}
