<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<
<title>Insert title here</title>
</head>
<body>
<%
response.setHeader("Cache-Control","no cache,no-store,must-revalidate");
%>
<table align="center" border="1">
<h1 align="center">
<a href="new">Add New User</a>
&nbsp; &nbsp; &nbsp;
<a href="list">List User</a>
&nbsp; &nbsp;
<a href="logout">Logout</a>
</h1>
<p> Welcome ${name}</p>
<tr>
<td>ID</td>
<td>Name</td>
<td>Address</td>
<td>Age</td>
<td>Email</td>
<td>Edit/Delete</td>
</tr>


<c:forEach var="user" items="${usersList }">
<tr>
<td><c:out value="${user.id}"/></td> 
<td><c:out value="${user.name }"/></td> 
<td><c:out value="${user.address }"/></td> 
<td><c:out value="${user.age}"/></td> 
<td><c:out value="${user.email}"/></td> 
<td><a href="edit?id=<c:out value="${user.id}"/>">Edit</a>&nbsp; &nbsp;<a href="delete?id=<c:out value="${user.id}"/>">DELETE</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>