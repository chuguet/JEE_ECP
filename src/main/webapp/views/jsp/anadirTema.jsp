<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>A&ntilde;adir Tema</title>
</head>
<body>
	<c:set var="bean" scope="request" value="${anadirTemaBean}" />
	<h2>A&ntilde;adir tema</h2>

	<form action="/JEE_ECP/jsp/anadirTema" method="POST">
		<label for="id">Id del tema: </label>
		<input id="id" name="id" type="text" value="${bean.tema.id}"/><br/>
		<label for="nombre">Nombre del tema: </label>
		<input id="nombre" name="nombre" type="text" value="${bean.tema.nombre}"/><br/>
		<label for="pregunta">Pregunta del tema: </label>
		<input id="pregunta" name="pregunta" type="text" value="${bean.tema.pregunta}"/><br/><br/>
		<input type=submit value="A&ntilde;adir tema"/>
	</form>
	
	<br/><br/>
	
	<a href="/JEE_ECP/jsp/home">Volver a home</a>
</body>
</html>