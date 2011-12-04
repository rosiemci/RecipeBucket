<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Recipe Application</title>
		<style type="text/css">
		body {
			font-family: Trebuchet MS, Verdana;
			font-size: 18px;
		}
		</style>
	</head>
<body>
	<img src="recipebucket.jpg">

<br><br><br>
	Who is logged in: <security:authentication property="principal.username"/>

	<br>
	<br>
	
	<a href="j_spring_security_logout">Logout <security:authentication property="principal.username"/></a><br>
	
	
	<hr>
	<h1>Create a new Recipe</h1>
	<form method="post">
	Enter Recipe Name:
	<textarea name="name" cols="50" rows="1"></textarea>
	<br> 
	Enter Recipe Description:
	<textarea name="description" cols="50" rows="5"></textarea>
	<br>
	Number of Servings:
	<textarea name="numServings" cols="5" rows="1"></textarea>
	Serving Size:
	<textarea name="servingSize" cols="50" rows="1"></textarea>
	<br>
	Posted By:
	<textarea name="username" cols="50" rows="1" readonly><security:authentication property="principal.username"/></textarea>
	<br>
	Preparation time in mins:
	<textarea name="preparationTime" cols="5" rows="1"></textarea>
	Cooking time in mins:
	<textarea name="cookingTime" cols="5" rows="1"></textarea>
	<br>
	Ingredients<br>
	<textarea name="ingredients" cols="50" rows="20"></textarea>
	<br> 
	Enter Recipe Method:<br>
	<textarea name="method" cols="50" rows="5"></textarea>
	<br>
	
	
	
	
	<br>
	<input type="submit">
	
	</form>
</body>
</html>