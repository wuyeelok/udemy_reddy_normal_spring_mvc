<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Kenneth</title>
</head>
<body>
	<h1>Welcome to Kenneth</h1>

	<form action="addAlien" method="post">
		<label for="aid">Enter your id : </label> <input type="number"
			name="aid" id="aid" required /><br> <label for="aname">Enter
			your name : </label> <input type="text" name="aname" id="aname" required /><br>
		<input type="submit" value="Submit Form" />
	</form>
	<hr>
	<form action="getAlien" method="get">
		<label for="alienid">Enter alien id: </label> <input type="number"
			id="alienid" name="alienid"> <br> <input type="submit"
			value="Submit Form" />
	</form>
</body>
</html>