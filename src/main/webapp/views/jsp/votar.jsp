<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votar</title>

<script>
	function preguntaTema(pregunta) {
		var x = document.getElementById("select").value;
		document.getElementById("pregunta").innerHTML = "Pregunta: " + pregunta;
	}
</script>

</head>
<body>
	<h1>Votar</h1>
	<c:set var="votarBean" scope="request" value="${votar}" />
	<div>${votarBean.update()}</div>
	<form action="/JEE_ECP/jsp/votar" method="post">
		<p>Temas actuales:</p>

		<select name="select" id="select" >
			<c:forEach var="tema" items="${votarBean.temas}">
				<option value="${tema.id}" title="preguntaTema(${tema.pregunta})" >${tema.name}</option>
			</c:forEach>
		</select>

		<p id="pregunta"></p>

		<p>Valoración: <input name="valoracion" type="text" /></p>
		
		<select name="selectEstudios" id="selectEstudios" >
			<c:forEach var="nivelEstudios" items="${votarBean.nivelesEstudios}">
				<option value="${nivelEstudios}" >${nivelEstudios}</option>
			</c:forEach>
		</select>
		
		<p><input type="submit" value="Votar" /></p>
		
	</form>
	
	<p><a href="/JEE_ECP/jsp/home">Volver a Home</a></p>
	
</body>
</html>