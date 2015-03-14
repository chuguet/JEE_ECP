<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votar</title>
</head>
<body>
	<c:set var="bean" scope="request" value="${votarBean}" />
	<h2>Votar</h2>

		<c:choose>
			<c:when test="${empty bean.tema.id}">
				<h5>Elige un tema para votar:</h5>
				<form method="POST" action="">
					<c:forEach items="${bean.temas}" var="tema">
							<input type="radio" name="id" value="${tema.id}"/>${tema.nombre}
							<br/>
					</c:forEach>
					<br/>
					<input type="submit" value="Seleccionar" />
				</form>
			</c:when>
			<c:otherwise>
				<h5>Vote para el siguiente tema: ${bean.tema.nombre}</h5>
				<form method="POST" action="">
					<input type="hidden" name="idTema" value="${bean.tema.id}"/>
					<label for="">${bean.tema.pregunta}</label><br/>
					<input type="range" id="valoracion" name="valoracion" value="0" min="0" max="10"><br/>
					<select name="nivel_estudios">
						<option value="LICENCIADO">Licenciado</option>
						<option value="DIPLOMADO">Diplomado</option>
						<option value="BACHILLERATO">Bachillerato</option>
					</select>
					<input type="submit" value="Votar" />
				</form>
			</c:otherwise>
		</c:choose>
			<br/><br/>
			<a href="/JEE_ECP/jsp/home">Volver a home</a>
</body>
</html>