<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Añadir Tema</title>
</head>
<body>
	<h1>Añadir Tema</h1>
	<c:set var="anyadirTemaBean" scope="request" value="${anyadirTema}" />
	<div>${anyadirTemaBean.update()}</div>
	<form action="/JEE_ECP/jsp/anyadirTema" method="post">
		<p>Temas actuales:</p>
		<ul>
			<c:forEach var="tema" items="${anyadirTemaBean.temas}">
				<li>${tema.name}</li>
			</c:forEach>
		</ul>
		<p>Tema nuevo: <input name="name" type="text" /></p>
		<p>Pregunta: <input name="pregunta" type="text" /></p>
		<p><input type="submit" value="Enviar" /></p>
	</form>
	<p><a href="/JEE_ECP/jsp/home">Volver a Home</a></p>
</body>
</html>