<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="it.prova.cartellaesattorialespringjpa.model.Contribuente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../header.jsp" %>
      
    <div class="page-header">


	
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${UtenteSingolo.id }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${UtenteSingolo.nome }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${UtenteSingolo.cognome }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">username</dt>
				<dd class="col-sm-9">${UtenteSingolo.username }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Data di registrazione</dt>
				<dd class="col-sm-9">${UtenteSingolo.dataRegistrazione }</dd>
			</dl>	
				
			<dl class="row">
				<dt class="col-sm-3 text-right">Ruolo</dt>
				<dd class="col-sm-9"><c:forEach items="${UtenteSingolo.ruoli }" var="item">${item.descrizione }  </c:forEach></dd>
			</dl>	
			
		</div>

	
	<a href="<%= request.getContextPath()%>/home.jsp" class="btn btn-info">Torna alla pagina
		iniziale</a>
</body>
</html>