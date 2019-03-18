<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.bean.Student"%>

<% Student student = (Student)session.getAttribute("student");%>
Update Student Here


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Student</title>
</head>
<body>
<form action="updateStdVal" method="post">
<table>
<tr>
<td> Student Id </td> 
<td><input type="text" name="stdId" value="${student.getStdId()}" disabled="disabled"/></td>
<input type="hidden" name="studentId" value="${student.getStdId()}" />
</tr>

<tr>
<td> Student Name </td> 
<td><input type="text" name="studentName" value="${student.getStudentName()}"/></td>
</tr>

<tr>
<td> Student Percentage </td> 
<td><input type="text" name="studentPercentage" value="${student.getPercentage()}"/></td>
</tr>
</table>

<input type="submit" name="submit" value="Submit">
</form>
</body>
</html>