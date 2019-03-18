package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.bean.User;
@Configuration
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter 
{

	@Autowired
	User user;
	  // Authentication : set user/password details and mention the role
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	System.out.println("SpringSecurityConfig called");
    	System.out.println("User Name:"+user.getUserName()+":password:"+user.getPassword()+":Admin:"+user.getAdmin());
        auth.inMemoryAuthentication().passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
            .withUser(user.getUserName()).password(user.getPassword()).roles("USER")
            .and()
            .withUser(user.getAdmin()).password(user.getPassword()).roles("USER", "ADMIN");
       
    }

    // Authorization : mention which role can access which URL
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
            .antMatchers("/userlogin").hasRole("USER")
            .antMatchers("/adminlogin").hasRole("ADMIN")
            .and()
            .csrf().disable().headers().frameOptions().disable();
    }
}
