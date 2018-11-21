<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

	Simple login Example using servlet jsp and mysql database connectivity
	
	<br>

	<form action="LoginController" method="post">
		Enter username :<input type="text" name="username"> <br>
		Enter password :<input type="password" name="password"><br>
		<input type="submit" value="Login">
	</form>

</body>
</html>
