<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Management</title>
</head>
<body>
<div align="center">
	<h2>Course Management</h2>
	<form method="get" action="search">
		<input type="text" name="keyword" /> &nbsp;
		<input type="submit" value="Search" />
	</form>
	<h3><a href="add">Add Course</a></h3>
	<table border="1" cellpadding="5">
		<tr>
			<th>courseId</th>
			<th>courseName</th>
			<th>duration</th>
			<th>fee</th>
			<th>courseDesc</th>
			<th>credits</th>
			<th>date</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${list}" var="course">
		<tr>
			<td>${course.courseId}</td>
			<td>${course.courseName}</td>
			<td>${course.duration}</td>
			<td>${course.fee}</td>
			<td>${course.courseDesc}</td>
			<td>${course.credits}</td>
			<td>${course.date}</td>
			<td>
				<a href="editDetails/${course.courseId}">Edit</a>
				&nbsp;&nbsp;&nbsp;
				<a href="delete/${course.courseId}">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>	
</body>
</html>