<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">

		<%@ include file="../header.jsp"%>
<div class="page-header">

	
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${dettaglioAcquisto.id }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9">${dettaglioAcquisto.descrizione }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Anno</dt>
				<dd class="col-sm-9">${dettaglioAcquisto.anno }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Prezzo</dt>
				<dd class="col-sm-9">${dettaglioAcquisto.prezzo }</dd>
			</dl>
	<a href="${pageContext.request.contextPath}/home" class="btn btn-info">Torna alla pagina
		iniziale</a>
</body>
</html>