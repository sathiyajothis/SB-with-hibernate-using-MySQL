<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>First Web Application</title>
</head>

<body>
    <font color="red">${errorMessage}</font>
    <form method="post">
    <table>
    <tr>
       <TD> Name </TD> <TD> <input type="text" name="name" /></TD>
        </tr>
        <TR>
        <TD>Password</TD> <TD>  <input type="password" name="password" /></TD>
        </TR> 
        <TR align="center">
        <td>
        <input type="submit" />
        </td>
        </TR>
        </table>
    </form>
</body>

</html>