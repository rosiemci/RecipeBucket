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
	<a href="j_spring_security_logout">Logout <security:authentication property="principal.username"/></a><br>
	
	<br>
	<hr>
	<form method="post">
	<table>
	<tr>
		<td>Enter Recipe Name:</td>
		<td><textarea name="name" cols="50" rows="1"></textarea></td>
	</tr>
	<tr>
	<td>Enter Recipe Description:</td>
	<td><textarea name="description" cols="50" rows="5"></textarea></td>
	</tr>
	<tr>
		<td>Number of Servings:</td>
		<td><textarea name="numServings" cols="5" rows="1"></textarea></td>
	</tr>
	<tr>
	<td>Serving Size:</td>
	<td><textarea name="servingSize" cols="50" rows="1"></textarea></td>
	</tr>
	<tr>
	<td>Posted By:</td>
	<td><textarea name="username" cols="50" rows="1" readonly><security:authentication property="principal.username"/></textarea></td>
	</tr>
	<tr>
	<td>Preparation time in mins:</td>
	<td><textarea name="preparationTime" cols="5" rows="1"></textarea></td>
	</tr>
	<tr>
	<td>Cooking time in mins:<td>
	<td><textarea name="cookingTime" cols="5" rows="1"></textarea></td>
	</tr>
	<tr>
	<td>Ingredients</td>
	<td><textarea name="ingredients" cols="50" rows="20"></textarea></td>
	</tr>
	<tr>
	<td>Enter Recipe Method:</td>
	<td><textarea name="method" cols="50" rows="5"></textarea></td>
	</tr>
	</table>
	<br>
	
	
	
	
	<br>
	<input type="submit">
	
	</form>
</body>
</html>