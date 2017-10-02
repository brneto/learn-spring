<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Attendee Page</title>

<link href="/css/error.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<a href="?lang=en">
		English
	</a>
	
	<a href="?lang=br">
		Portuguese
	</a>
	
	<form:form commandName="attendee">
		<form:errors path="*" cssClass="errorBlock" element="div" />
		<label for="textinput1"><spring:message code="attendee.name" />:</label>
		<form:input path="name" cssErroClass="error" />
		<form:errors path="name" cssClass="error" />
		<br />
		<label for="textinput1"><spring:message code="attendee.email.address" />:</label>
		<form:input path="emailAddress" cssErroClass="error" />
		<form:errors path="emailAddress" cssClass="error" />
		<br />
		<input type="submit" class="btn" value="Enter Attendee">
	</form:form>

</body>
</html>