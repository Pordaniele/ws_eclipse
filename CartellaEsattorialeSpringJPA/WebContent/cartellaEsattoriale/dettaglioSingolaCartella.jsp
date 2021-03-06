<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page
	import="it.prova.cartellaesattorialespringjpa.model.CartellaEsattoriale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div class="page-header">


		<h3>Dettaglio cartella esattoriale</h3>
	</div>
	<div class="container-fluid">
		<dl class="row">
			<dt class="col-sm-3 text-right">Id</dt>
			<dd class="col-sm-9">${cartellaSingola.id }</dd>
		</dl>
		<dl class="row">
			<dt class="col-sm-3 text-right">Denominazione</dt>
			<dd class="col-sm-9">${cartellaSingola.denominazione }</dd>
		</dl>
		<dl class="row">
			<dt class="col-sm-3 text-right">Importo</dt>
			<dd class="col-sm-9">${cartellaSingola.importo }</dd>
		</dl>
	</div>
	<dl class="row">
		<dt class="col-sm-3 text-right">Contribuente</dt>
		<dd class="col-sm-9">${contribuente.nome } ${contribuente.cognome }</dd>
	</dl>


	<a href="<%= request.getContextPath()%>/home.jsp" class="btn btn-info">Torna
		alla pagina iniziale</a>

</body>
</html>