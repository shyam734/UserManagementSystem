<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red">User Form</h1>
<br>
<br>
<form method="get" action="insert">
<table border="1" align="center">
<tr>
<td>ID</td>
<td><input type="text" name="id"></td> 
</tr>

<tr>
<td>Name</td>
<td><input type="text" name="name"></td> 
</tr>
<tr>
<td>Address</td>
<td><input type="text" name="address"></td> 
</tr>
<tr>
<td>Age</td>
<td><input type="text" name="age"></td> 
</tr>
<tr>
<td>Email</td>
<td><input type="email" name="email"></td> 
</tr>
<tr>

<td><input type="submit" value="ADD"></td> 
</tr>
</table>


</form>

</body>
</html>