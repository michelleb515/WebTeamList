<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Player List</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.AllPlayers}" var="currentplayer">
				<tr>
					<td><input type="radio" name="id" value="${currentplayer.id}" ></td>
					<td>${currentplayer.name}</td>
					<td>${currentplayer.jersey}</td>
					<td>${currentplayer.weight}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToPlayer"> <input
			type="submit" value="delete" name="doThisToPlayer"> <input
			type="submit" value="add" name="doThisToPlayer">
	</form>
</body>
</html>