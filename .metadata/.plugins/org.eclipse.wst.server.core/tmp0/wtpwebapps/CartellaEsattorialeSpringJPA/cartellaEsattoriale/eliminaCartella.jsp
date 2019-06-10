<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="it.prova.cartellaesattorialespringjpa.model.CartellaEsattoriale"%>
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

	
			<h3>Pagina di eliminazione cartella esattoriale</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${cartellaDaEliminare.id }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Denominazione</dt>
				<dd class="col-sm-9">${cartellaDaEliminare.denominazione }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Importo</dt>
				<dd class="col-sm-9">${cartellaDaEliminare.importo }</dd>
			</dl>
			</div>
	<a href="EliminaCartellaServlet?idCartella=${cartellaDaEliminare.id }" class="btn btn-info">Elimina</a>
	<a href="<%= request.getContextPath()%>/home.jsp" class="btn btn-info">Torna alla pagina
		iniziale</a>
</body>
</html>