package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import com.example.bean.User;
@ComponentScan("com.example")
@ServletComponentScan("com.example.servlet")
@SpringBootApplication
public class SpringBoot2Application {
    
    @Bean
    public User getUser()
    {
    	return new User(); 
    }

	/*
	 * @Bean public HibernateJpaSessionFactoryBean sessionFactory() { return new
	 * HibernateJpaSessionFactoryBean(); }
	 */
    public SpringBoot2Application()
    {
    	System.out.println("Calling SpringBoot2Application constructor");
    	
    }
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2Application.class, args);
		System.out.println("HI");
		System.out.println("Calling SpringBoot2Application main method");
		
		
	}
	
	/*
	 * @PostConstruct public void init() {
	 * System.out.println("Calling Student class"); std.setStdId("1001");
	 * std.setStudentName("Vishnu"); std.setPercentage(63.21);
	 * System.out.println("Grade is:"+std.getGrade()); }
	 */

}
