<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>A&ntilde;adir tema</h2>

	<form action="/JEE_ECP/dispatcher/anadirtema" method="POST">
		<label for="nombre">Nombre del tema: </label>
		<input id="nombre" name="nombre" type="text"/><br/>
		<label for="pregunta">Pregunta del tema: </label>
		<input id="pregunta" name="pregunta" type="text"/><br/><br/>
		<input type=submit value="A&ntilde;adir tema"/>
	</form>
	
	<br/><br/>
	
	<a href="/JEE_ECP/dispatcher/home">Volver a home</a>
</body>
</html>