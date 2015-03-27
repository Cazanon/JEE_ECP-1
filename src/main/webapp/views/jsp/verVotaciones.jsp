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

	<div style="position:absolute; width: 100%; ">
		<c:forEach var="columnHeader"
			items="${verVotacionesBean.columnHeaders}">
			<p style="float: left; width: 15%; ">${columnHeader}</p>
		</c:forEach>
	</div>

	<div style="position:absolute; top:12%; width: 100%; ">
		<ul style="float: left; width: 12%;">
			<c:forEach var="tema" items="${verVotacionesBean.temas}">
				<li>${tema.name}</li>
			</c:forEach>
		</ul>

		<ul style="float: left; width: 12%;">
			<c:forEach var="numeroVotos"
				items="${verVotacionesBean.numeroVotosPorTema}">
				<li>${numeroVotos}</li>
			</c:forEach>
		</ul>

		<c:forEach var="nivelEstudios"
			items="${verVotacionesBean.numeroVotosPorTemaYNivelDeEstudios}">
			<ul style="float: left; width: 12%;">
				<c:forEach var="numeroVotosPorNivelDeEstudios"
					items="${nivelEstudios}">
					<li>${numeroVotosPorNivelDeEstudios}</li>
				</c:forEach>
			</ul>
		</c:forEach>
	</div>
	
	<div style="position:absolute; top:35%; width: 100%; ">
		<p><a href="/JEE_ECP/jsp/home">Volver a Home</a></p>
	</div>
	
</body>
</html>