<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Person Details SSN Form </h1>
	<form:form action="handleSubmitBtn" method="post" modelAttribute="person">
		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName"/></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>
					<form:radiobutton path="gender" value="male" checked="checked"/>Male &nbsp;
					<form:radiobutton path="gender" value="female" />Female 
				</td>
			</tr>
			<tr>
				<td>DOB:</td>
				<td><form:input path="dob" type="date"/></td>
			</tr>
			<tr>
				<td>State:</td>
				<td>
					<form:select path="state">
						<form:option value="">--select state--</form:option>
						<form:options items="${states }" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>