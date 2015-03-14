<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar Tema</title>
</head>
<body>
	<c:set var="bean" scope="request" value="${eliminarTemaBean}" />
	<h2>Eliminar tema</h2>

		<c:choose>
			<c:when test="${bean.autorizacion==666}">
				<h5>Seleccione el tema que desea borrar:</h5>
			    <form method="POST" action="/JEE_ECP/jsp/eliminarTema">
					<input type="hidden" name="autorizacion" value="${bean.autorizacion}"/>
					<c:forEach items="${bean.temas}" var="tema">
							<input type="radio" name="id" value="${tema.id}"/>${tema.nombre}
							<br/>
					</c:forEach>
					<br/>
					<input type="submit" value="Borrar" />
				</form>
			</c:when>
			<c:otherwise>
				<form method="POST" action="/JEE_ECP/jsp/eliminarTema">
					<label for="autorizacion">C&oacute;digo de autorizaci&oacute;n</label>
					<input id="autorizacion" name="autorizacion" type="text" value="${bean.autorizacion}"/> <br/>
					<input type="submit" value="Enviar"/>
				</form>
			</c:otherwise>
		</c:choose>
		
		<br/><br/>
		<a href="/JEE_ECP/jsp/home">Volver a home</a>
</body>
</html>