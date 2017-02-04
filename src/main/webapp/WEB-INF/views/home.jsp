<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form action="login.ajax" method="post">
	<input type="text" name="adminId"/>
	<input type="password" name="passwd"/>
	<button type="submit"></button>
	
</form>
</body>
</html>
