<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Fitness Tracker Custom Login Page</title>
	
	<link rel="stylesheet" type="text/css" href="asset/css/error.css">
</head>
<body onload="document.f.username.focus();">
	<h3>Fitness Tracker Custom Login Page</h3>
	<c:if test="${error}">
		<div class="errorblock">
			Your login was unsuccessful. <br />
			Caused: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

	<form action="login" name="f" method="post">
		<table>
			<tr>
				<td><label for="username">User:</label></td>
				<td><input type="text" id="username" name="username"/></td>
			</tr>
			<tr>
				<td><label for="password">Password:</label></td>
				<td><input type="password" id="password" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" name="reset"></td>
			</tr>
		</table>	
	</form>

</body>
</html>