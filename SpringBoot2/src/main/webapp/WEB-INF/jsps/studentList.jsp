<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>

<% List studentList = (List)session.getAttribute("studentList");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
<h3>Student Details</h3>
<hr size="4" color="gray"/>
<table>

 <thead>
        <tr>
            <th >Student ID</th>
            <th >Student Name</th>
            <th >Student Percentage</th>
            <th >Student Grade</th>
        </tr>
    </thead>
    <c:forEach items="${studentList}" var="student">
        
        
        <tr>
        
            <td><c:out value="${student.getStdId()}"/></td>
            <td><c:out value="${student.getStudentName()}"/></td>  
            <td> <c:out value="${student.getPercentage()}"/></td>
            <td><c:out value="${student.getGrade()}"/></td> 
            <td><a href="<c:url value='/updateStudent/${student.getStdId()}' />" ><input type="button" value="Edit"></a></td>
            <td><a href="<c:url value='/deleteStudent/${student.getStdId()}' />" ><input type="button" value="Delete"></a></td>
          <%--   <td><a href="<c:url value='/passObject/${student}' />" ><input type="button" value="Delete"></a></td> --%>
 
        </tr>
    </c:forEach>
    <tr>
    <td><a href="<c:url value='/createStduent' />" ><input type="button" value="Create New Student"></a></td>
    </tr>
</table>
  
</body>
</html>