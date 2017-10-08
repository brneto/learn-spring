<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Goal</title>

<link rel="stylesheet" type="text/css" href="asset/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="asset/css/bootstrap-responsive.css">
<link rel="stylesheet" type="text/css" href="asset/css/error.css">
<style>
	body {
		/* 60px to make the container go all the way to the bottom of the topbar */ 
		padding-top: 60px; 
    }
</style>
<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="asset/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="asset/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="asset/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="asset/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="asset/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
	<div class="navbar navbar-fixed-top navbar-inverse">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#">Add Goal</a>
				<ul class="nav"></ul>
			</div>
		</div>
	</div>
	<div>
		<div>
			<h1>Add Goal</h1>
			<p>
				Add your workout goal in minutes for the day.
				<br />
				&nbsp;
 			</p>
		</div>
		
		<form:form commandName="goal">
		<form:errors path="*" cssClass="errorblock" element="div" />
			<label for="textinput1">
	          Enter Minutes:
	        </label>	
			<form:input path="minutes" cssErrorClass="error" />
			<form:errors path="minutes" cssClass="error" />
			<br/>
			<input type="submit" class="btn" value="Enter Goal Minutes"/>
	  </form:form>
	  <div class="control-group"></div>
	</div>
	
	<script type="text/javascript" src="asset/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="asset/js/bootstrap.js"></script>
</body>
</html>