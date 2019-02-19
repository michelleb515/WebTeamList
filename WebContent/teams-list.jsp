<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teams List</title>
</head>
<body>
	<form method="post" action="navigationServletTeams">
		<table>
			<c:forEach items="${requestScope.allTeams}" var="currentteam">
				<tr>
					<td><input type="radio" name="id" value="${currentteam.id}" ></td>
					<td>Team Name:  ${currentteam.teamName}</td>
					<td>Team Colors:  ${currentteam.teamColors}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToTeam"> <input
			type="submit" value="delete" name="doThisToTeam"> <input
			type="submit" value="add" name="doThisToTeam"> 
	</form>
	<br /> <a href="index.html">Home Page</a>
</body>
</html>