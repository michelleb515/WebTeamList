<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Team</title>
</head>
<body>
	<form action="editTeamsServlet" method="post">
		Team Name: <input type="text" name="teamName" value="${teamToEdit.teamName}">
		Team Colors: <input type="text" name="teamColors" value="${teamToEdit.teamColors}">
		<input type="hidden" name="id" value="${teamToEdit.id}"> <input
			type="submit" value="Save Edited Team">
	</form>
</body>
</html>