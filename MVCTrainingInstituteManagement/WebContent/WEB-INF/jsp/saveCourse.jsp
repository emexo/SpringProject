<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Customer</title>
</head>
<body>
	<div align="center">
		<h2>Add Course</h2>
		<form:form action="save" method="post" modelAttribute="course">
			<table border="0" cellpadding="5">
				<tr>
					<td>courseName: </td>
					<td><form:input path="courseName" /></td>
				</tr>
				<tr>
					<td>duration: </td>
					<td><form:input path="duration" /></td>
				</tr>
				<tr>
					<td>fee: </td>
					<td><form:input path="fee" /></td>
				</tr>		
				<tr>
					<td>courseDesc: </td>
					<td><form:input path="courseDesc" /></td>
				</tr>
				<tr>
					<td>credits: </td>
					<td><form:input path="credits" /></td>
				</tr>		
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>						
			</table>
		</form:form>
	</div>
</body>
</html>