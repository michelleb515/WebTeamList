<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Player</title>
</head>
<body>
	<form action="editPlayerServlet" method="post">
		Name: <input type="text" name="name" value="${playerToEdit.name}">
		Jersey: <input type="text" name="jersey" value="${playerToEdit.jersey}">
		Weight: <input type="text" name="weight" value="${playerToEdit.weight}">
		Team:  <input type = "text" name = "teamName" value="${playerToEdit.teamId}" readonly>
		<br />
		Teams: <br />
	    	<c:forEach items="${requestScope.allTeams}" var="currentteam">
	    		<input type="radio" name="teamId" value="${currentteam.id}">
				<option value="${currentlist.id}">${currentteam.teamName}|
					${currentteam.teamColors}</option>  <br/>
			</c:forEach>
			<br />
		<input type="hidden" name="id" value="${playerToEdit.id}"> <input
			type="submit" value="Save Edited Player">
	</form>
</body>
</html>