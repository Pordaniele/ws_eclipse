<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualizza Municipio</title>
</head>
<body>
<div class="container">

		<%@ include file="/header.jsp"%>

		<div class="page-header">
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${AbitanteForm.id }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${AbitanteForm.nome }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${AbitanteForm.cognome }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Eta</dt>
				<dd class="col-sm-9">${AbitanteForm.eta }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Residenza</dt>
				<dd class="col-sm-9">${AbitanteForm.residenza }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Municipio</dt>
				<dd class="col-sm-9">${AbitanteForm.municipio.descrizione }</dd>
			</dl>
		</div>

<a href="${pageContext.request.contextPath }/abitante.do?codop=create">Nuovo Abitante</a>
<form action="${pageContext.request.contextPath }/municipio.do">
	<input type="hidden" name="codop" value="delete" >
	<input type="hidden" name="idMunicipio" value="${MunicipioForm.id }">
	<input type="submit" value="RIMUOVI">
</form>
</body>
</html>