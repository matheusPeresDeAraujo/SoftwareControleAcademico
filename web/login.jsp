<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>P�gina - Login</title>
</head>
<body>
<fieldset>
<h1>P�gina de Login!</h1>
<form action="AutenticadorCredencialController" method="post">
<label>Usu�rio:</label>
<input type="text" name="usuario"><br>
<label>Senha:</label>
<input type="password" name="senha"><br>
<input type="submit" value="Logar"><br>
</form>
</fieldset>
</body>
</html>