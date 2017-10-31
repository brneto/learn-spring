<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Index</title>

<link rel="stylesheet" type="text/css" href="asset/css/bootstrap.css">
<style>
body {
	/* 60px to make the container go all the way to the bottom of the topbar */
	padding-top: 60px;
}
</style>
<link rel="stylesheet" type="text/css" href="asset/css/bootstrap-responsive.css">
<!-- The HTML5 shim, for IE6-8 support of HTML 5 elements -->
<!-- [if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
	</script>
<![endif] -->
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
				<a class="brand" href="addGoal.html"> Get started </a>
				<ul class="nav">
				</ul>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="hero-unit">
			<div>
				<h1>
					Welcome to Fitness Tracker <sec:authentication property="name" />!
				</h1>
				<p>
					To get started, we need to enter a goal for what we want to exercise for today.
				</p>
			</div>
			<a class="btn btn-primary" href="addGoal.html">
				Add Goal »
			</a>
			
			<!-- By default if the supplied role does not start with 'ROLE_' it will be added. -->
			<sec:authorize access="hasAnyRole('ADMIN')">
			<a class="btn btn-primary" href="editGoal.html">
				Edit Goal »
			</a>
			</sec:authorize>
			
			<a class="btn btn-primary" href="addMinutes.html">
				Add Exercise Minutes »
			</a>
			
			<a class="btn btn-warning" href="logout">
				Logout »
			</a>
			
		</div>
	</div>

	<script src="asset/js/jquery-3.2.1.js"></script>
	<script src="asset/js/bootstrap.js"></script>
</body>
</html>
