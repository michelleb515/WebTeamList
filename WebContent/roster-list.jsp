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
	<form method="post" action="navigationServletRoster">
		<table>
			<c:forEach items="${requestScope.allRosterss}" var="currentroster">
				<tr>
					<td><input type="radio" name="rosterId" value="${currentroster.rosterId}"></td>
					<td><h2>${currentroster.rosterId}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Trip Date: ${currentroster.listOfTeams.teamName}</td>
				</tr>
				<tr>
					<td colspan="3">Shopper: ${currentroster.listOfTeams.teamID}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToRoster"> <input
			type="submit" value="delete" name="doThisToRoster"> <input
			type="submit" value="add" name="doThisToRoster">
	</form>
	<a href="index.html">Home Page</a>
</body>
</html>