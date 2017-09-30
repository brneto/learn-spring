<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Attendee Page</title>

<link href="/css/error.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<s:form commandName="attendee">
		<s:errors path="*" cssClass="errorBlock" element="div" />
		<label for="textinput1">Enter Name:</label>
		<s:input path="name" cssErroClass="error" />
		<s:errors path="name" cssClass="error" />
		<br />
		<label for="textinput1">Enter Email Address:</label>
		<s:input path="emailAddress" cssErroClass="error" />
		<s:errors path="emailAddress" cssClass="error" />
		<br />
		<input type="submit" class="btn" value="Enter Attendee">
	</s:form>

</body>
</html>