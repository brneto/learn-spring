<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Minutes Page</title>

<link rel="stylesheet" type="text/css" href="asset/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="asset/css/error.css">
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
				<a class="brand" href="#"><spring:message code="minutes.exercised"/></a>
			</div>
		</div>
	</div>
	
	<div class="container">
		<a class="btn" href="?lang=en">English</a>
		<a class="btn" href="?lang=pt">Portuguese</a>
		
		<div>
			<h1><spring:message code="minutes.exercised"/></h1>
		</div>
		<br/><br/>
		
		<form:form commandName="exercise">
			<form:errors path="*" cssClass="errorblock" element="div" />
			
			<div class="control-group">
				<label for="textinput1">
					<spring:message code="minutes.text"/>
				</label>
				<form:input path="minutes"/>
				<form:errors path="minutes" cssClass="error" />
			</div>
			
			<div class="control-group">
				<label for="selectinput1">
					<spring:message code="minutes.activity" />
				</label>
				<form:select id="activities" path="activity" />
			</div>
			
			<input type="submit" class="btn" value="<spring:message code="minutes.button.enter"/>" />
		</form:form>
		
		<span class="label">
 			<spring:message code="minutes.goal"/> ${goal.minutes}
		</span>
	</div>
	
	<script type="text/javascript" src="asset/js/jquery-3.2.1.js"></script>
	<script type="text/javascript">
		$(document).ready(
			function() {
				$.getJSON('<spring:url value="activities.json" />', {
					ajax : 'true'
				}, function(data) {
					var html = '<option value="">--Please select one--</option>';
					var len = data.length;
					for (var i = 0; i < len; i++) {
						html += '<option value="' + data[i].desc + '">'
								+ data[i].desc + '</option>';
					}
					html += '</option>';
					
					$('#activities').html(html);
				});
				
			});
	
	</script>
	<script type="text/javascript" src="asset/js/bootstrap.js"></script>
</body>
</html>