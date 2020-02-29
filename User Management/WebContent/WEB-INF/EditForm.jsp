<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" style="color:green">User Edit Form</h1>
<br>

<form method="get" action="update">
<table border="1" align="center">
<tr>
<td>ID</td>
<td><input type="text" value="${user.id}" name="id"></td> 
</tr>

<tr>
<td>Name</td>
<td><input type="text"  value="${user.name}" name="name"></td> 
</tr>
<tr>
<td>Address</td>
<td><input type="text"  value="${user.address}" name="address"></td> 
</tr>
<tr>
<td>Age</td>
<td><input type="text"  value="${user.age}" name="age"></td> 
</tr>
<tr>
<td>Email</td>
<td><input type="email"  value="${user.email}"name="email"></td> 
</tr>
<tr align="center">

<td><input align="center" type="submit" value="UPDATE" ></td> 
</tr>
</table>


</form>

</body>
</html>