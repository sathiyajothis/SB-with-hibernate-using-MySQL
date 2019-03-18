<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
Create Student Here
</br>
<font color="red">
${errorMessage}</font>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Student</title>
</head>
<body>
<form action="save" method="post">
<table>
<tr>
<td> Student Id </td> 
<td><input type="text" name="studentId"  /></td>
</tr>

<tr>
<td> Student Name </td> 
<td><input type="text" name="studentName" /></td>
</tr>

<tr>
<td> Student Percentage </td> 
<td><input type="text" name="studentPercentage" /></td>
</tr>
</table>

<input type="submit" name="submit" value="Submit">
</form>
</body>
</html>