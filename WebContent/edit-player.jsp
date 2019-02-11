<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<input type="hidden" name="id" value="${playerToEdit.id}"> <input
			type="submit" value="Save Edited Player">
	</form>
</body>
</html>