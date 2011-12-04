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
	
	My Recipes (total: ${fn:length(recipes)})
		<table>
			<c:forEach var="recipe" items="${recipes}" varStatus="index">
				<tr>
					<td>${index.count}.</td>
					<td>${recipe.name} - </td>
					<td>${recipe.description}</td>
				</tr>
			</c:forEach>
		</table>
		
		<br>
		
		<a href="create">Create More</a>
	
	
	
</body>
</html>