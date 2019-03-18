package com.example.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value="my")
public class User 
{
String userName;
String password;
String admin;
public String getAdmin() {
	return admin;
}
public void setAdmin(String admin) {
	this.admin = admin;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
