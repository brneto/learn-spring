<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Event Page</title>
<style type="text/css">
	.error{
		color: #ff0000;
	}
	.errorblock{
		color: #000;
		background-color: #ffeeee;
		border: 3px solid #ff0000;
		padding: 8px;
		margin: 16px;
	}
</style>
	
</head>
<body>

	<s:form commandName="event">
		<s:errors path="*" cssClass="errorBlock" element="div" />
		<label for="textinput1">Enter Minutes:</label>
		<s:input path="name" cssErroClass="error" />
		<s:errors path="name" cssClass="error" />
		<br />
		<input type="submit" class="btn" value="Enter Event">
	</s:form>

</body>
</html>