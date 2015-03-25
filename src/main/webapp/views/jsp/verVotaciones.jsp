<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ver Votaciones</title>
</head>
<body>
	<h1>Ver Votaciones</h1>
	<c:set var="verVotacionesBean" scope="request" value="${verVotaciones}" />
	<div>${verVotacionesBean.update()}</div>
	<form action="/JEE_ECP/jsp/verVotaciones" method="post">
		<p>Temas actuales:</p>

		<select name="select" id="select" >
			<c:forEach var="tema" items="${verVotacionesBean.temas}">
				<option value="${tema.id}">${tema.name}</option>
			</c:forEach>
		</select>

		<p>Número de votos:</p>
		<p>${verVotacionesBean.numeroVotosPorTema}</p>

		<p>
			<input type="submit" value="Ver Votaciones" />
		</p>
	</form>
	<p><a href="/JEE_ECP/jsp/home">Volver a Home</a></p>
</body>
</html>