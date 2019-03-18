package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.bean.Student;
import com.example.service.SpringService;

@Controller
public class SpringContrainer 
{
	
	@Autowired
	SpringService service;
	 
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
    public String validateUser(ModelMap model, @RequestParam String name, @RequestParam String password){

    	System.out.println("login post called");
        boolean isValidUser = service.validateUser(name, password);

        if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }
        model.put("studentList",service.getAllStudents());
        model.put("name", name);
        model.put("password", password);

        return "studentList";
    }
	

	@RequestMapping(value="/getStudentInfo", method = RequestMethod.GET)
    public String customerInformation() {
		System.out.println("getStudentInfo called");
		 
        return "studentList";
    }
	
	
	
	@RequestMapping(value="/createStduent", method = RequestMethod.GET)
    public String createStudent() {
		System.out.println("createStduent called");
		 
        return "createStudent";
    }
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveStudent(ModelMap model,@RequestParam(value="studentId") String studentId, @RequestParam(value="studentName") String studentName , @RequestParam(value="studentPercentage") String studentPercentage) 
	{
		System.out.println("studentId:"+studentId+":studentName:"+studentPercentage+":studentPercentage:"+studentPercentage);

		
		if(studentId.length()==0 || studentName.length()==0 || studentPercentage.length()==0)
		{
			model.put("errorMessage", "All Fields are Mandatory");
			return "createStudent";
		}
		else
		{
			
			if(service.getStudentWithId(studentId)==null)
			{
				Student std=new Student(studentId,studentName,new Double(studentPercentage));
				service.saveStudent(std);
				model.put("studentList",service.getAllStudents());
				return "studentList";
			}
			else
			{
				model.put("errorMessage", "Student already exists");
				return "createStudent";
			}


		}
	}
	
	 @RequestMapping(value="/login", method = RequestMethod.GET)
	    public String showLoginPage(ModelMap model){
	    	System.out.println("login get called");
	        return "login";
	    }
	
	
	
	@RequestMapping(value="/updateStudent/{studId}", method = RequestMethod.GET)
    public String updateStudent(ModelMap model,@PathVariable("studId")String studId ){
    	System.out.println("updateStudent get called  studId "+studId);
    	
    	model.put("student",service.getStudentWithId(studId));
        return "updateStudent";
    }
	
	@RequestMapping(value="/updateStudent/updateStdVal", method = RequestMethod.POST)
    public String updateStudentDetails(ModelMap model,@RequestParam(value="studentId") String studentId, @RequestParam(value="studentName") String studentName , @RequestParam(value="studentPercentage") String studentPercentage){
    	System.out.println("updateStudent get called  studId "+studentId+":studentName:"+studentName+":studentPercentage:"+studentPercentage);
    	
    	service.updateStudent(studentId, studentName, new Double(studentPercentage));
    	  model.put("studentList",service.getAllStudents());
        
       
          return "studentList";
        
    }
	
	@RequestMapping(value="/deleteStudent/{studId}", method = RequestMethod.GET)
    public String delete(ModelMap model,@PathVariable("studId") String studentId){
    	System.out.println("deleteStudent  called  studId "+studentId);
    	
    	service.deleteStudent(studentId);
    	  model.put("studentList",service.getAllStudents());
        
       
          return "studentList";
        
    }
	
	@RequestMapping(value="/passObject", method = RequestMethod.GET)
    public String passObject(ModelMap model,@PathVariable("student") Student student){
    	System.out.println("deleteStudent  called  studId "+student);
    	
    
    	
    	 return "studentList";
    }
	
	
}
