<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addPlayerServlet" method="post">
		Player Name: <input type="text" name="name"> Jersey No: <input
			type="text" name="jersey"> Weight: <input type="text"
			name="weight">
		<br /> 
		Teams: <br />
		<c:forEach items="${requestScope.allTeams}" var="currentteam">
			<input type="radio" name="teamId" value="${currentteam.id}">
			<option value="${currentlist.id}">${currentteam.teamName}|
				${currentteam.teamColors}</option>
			<br />
		</c:forEach>
		<br /> <input type="submit" value="Add Player">
	</form>
</body>
</html>