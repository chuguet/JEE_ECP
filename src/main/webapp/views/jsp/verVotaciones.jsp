<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ver Votaciones</title>
</head>
<body>
	<c:set var="bean" scope="request" value="${verVotacionesBean}" />
	<h2>Ver Votaciones</h2>

		<c:choose>
			<c:when test="${empty bean.tema.id}">
				<h5>Elige un tema para ver los votos:</h5>
				<form method="POST" action="/JEE_ECP/jsp/verVotaciones">
					<c:forEach items="${bean.temas}" var="tema">
							<input type="radio" name="id" value="${tema.id}"/>${tema.nombre}
							<br/>
					</c:forEach>
					<br/>
					<input type="submit" value="Seleccionar" />
				</form>
			</c:when>
			<c:otherwise>
				<h5>Seleccione el nivel de estudios para ver la media de votos del tema: ${bean.tema.nombre}</h5>
				<form method="POST" action="/JEE_ECP/jsp/verVotaciones">
					<input type="hidden" name="id" value="${bean.tema.id}"/>
					<label for="votos">N&uacute;mero de votos: </label>
					<span id="votos">${bean.numeroVotos}</span><br/>
					<label for="nivel_estudios">Elija el nivel de estudios: </label>
					<select id="nivel_estudios" name="nivel_estudios">
						<c:forEach items="${bean.nivelEstudiosList}" var="nivelEstudiosIt">
							<c:choose>
								<c:when test="${nivelEstudiosIt == bean.nivelEstudios}">
									<option selected value="${nivelEstudiosIt}">${nivelEstudiosIt}</option>
								</c:when>
								<c:otherwise>
									<option value="${nivelEstudiosIt}">${nivelEstudiosIt}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					<br/>
					<input type="submit" value="Seleccionar" />
					<br/>
					<c:if test="${not empty bean.mediaVotos}">
						<label for="media">Para el nivel de estudios ${bean.nivelEstudios} hay una media de: </label>
						<span id="media">${bean.mediaVotos}</span>
					</c:if>
				</form>
			</c:otherwise>
		</c:choose>
			<br/><br/>
			<a href="/JEE_ECP/jsp/home">Volver a home</a>
</body>
</html>