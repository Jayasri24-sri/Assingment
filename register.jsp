<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.techpalle.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration page</title>
</head>
<body>
	<% 
		Employee s=(Employee) request.getAttribute("Employee");
		if(s==null)
		{
	%>	
	<h2>Employee Registration</h2>
	<form action="reg">
	    <div hidden>
			<input type="number" name="tbid" >
		</div>
		Name: <input type="text" name="tbName" >
		<br>
		Email: <input type="email" name="tbEmail" >
		<br>
		Department: <input type="text" name="tbdept">
		<br>
		Status: <input type="text" name="tbstatus" >
		<br>
		<input type="submit" name="btnReg" value="Click here">
	<%
		}
		if(s!=null)
		{
	%>
		<h1>Employee Edit form</h1>
		<form action="update">
		<div hidden>
			<input type="number" name="tbid" value="<%= s.getId()%>">
		</div>
		Name: <input type="text" name="tbName" value="<%= s.getName()%>">
		<br>
		Email: <input type="email" name="tbEmail" value="<%= s.getEmail()%>">
		<br>
		Department: <input type="text" name="tbdept"  value="<%= s.getDepartment()%>">
		<br>
		Status: <input type="text" name="tbstatus" value="<%= s.getStatus()%>">
		<br>
		<input type="submit" name="btnReg" value="Click here">
	<%
		}
	%>
		
				
	</form>
</body>
</html>
