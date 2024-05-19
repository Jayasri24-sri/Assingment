<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.techpalle.model.Employee" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>display page</title>
</head>
<body>
	<h1>Employee details</h1>
	
	<table border="1">
		<tr>
			<th>Sno</th>
			<th>Name</th>
			<th>Email</th>
			<th>Department</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
		<%
		ArrayList<Employee> al=(ArrayList<Employee>) request.getAttribute("obj");
		
		for(Employee s: al)
		{
		%>
		<tr>
			<td><%= s.getId() %></td>
			<td><%= s.getName() %></td>
			<td><%= s.getEmail() %></td>
			<td><%= s.getDepartment() %></td>
			<td><%= s.getStatus() %></td>
			<td>
				<a href="edit?id=<%= s.getId()%>">Edit</a>
				<a href="delete?id=<%= s.getId()%>">Delete</a>
			</td>
		</tr>
		<%
		}
		%>
	
	</table>
</body>
</html>
