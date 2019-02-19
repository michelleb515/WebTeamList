<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Roster</title>
</head>
<body>

	<form action="navigationServletRoster" method="post">
	    Teams: <br />
	    	<c:forEach items="${requestScope.allTeams}" var="currentteam">
	    		<input type="radio" name="teamId" value="${currentteam.id}">
				<option value="${currentlist.id}">${currentteam.teamName}|
					${currentteam.teamColors}</option>  <br/>
			</c:forEach>
			<br />
		Players:<br /> <select name="playerId" multiple size="6">
			<c:forEach items="${requestScope.allPlayers}" var="currentplayer">
				<option value="${currentplayer.id}">${currentplayer.name}|
					${currentplayer.jersey}</option>
			</c:forEach>
		</select> <br /> <br /> <input type="submit" value="create" name=doThisToRoster>
	</form>
	<br />
	<a href="index.html">Home Page</a>
</body>
</html>