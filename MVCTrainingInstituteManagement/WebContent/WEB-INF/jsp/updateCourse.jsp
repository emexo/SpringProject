<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Course</title>
</head>
<body>
	<div align="center">
		<h2>Edit Course</h2>
		<form:form action="/MVCTrainingInstituteManagement/course/update"
			modelAttribute="course">
			<table border="0" cellpadding="5">
				<tr>
					<td>Course Id</td>
					<td><form:input path="courseId" readonly="true" /></td>
				</tr>
				<tr>
					<td>Course Name</td>
					<td><form:input path="courseName" /></td>
				</tr>
				<tr>
					<td>Duration</td>
					<td><form:input path="duration" /></td>
				</tr>
				<tr>
					<td>Fee</td>
					<td><form:input path="fee" /></td>
				</tr>
				<tr>
					<td>Course Description</td>
					<td><form:input path="courseDesc" /></td>
				</tr>

				<tr>
					<td>Credits</td>
					<td><form:input path="credits" /></td>
				</tr>				
				<tr>
					<td colspan="2"><input type="submit" value="Update" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>