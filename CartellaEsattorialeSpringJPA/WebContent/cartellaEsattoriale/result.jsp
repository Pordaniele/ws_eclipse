<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="it.prova.cartellaesattorialespringjpa.model.CartellaEsattoriale"%>
<%@page import="java.util.List"%>
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

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
			<h3>Pagina delle cartelle esattoriali</h3>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Denominazione</th>
					<th>Importo</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:forEach items="${listaCartelle }" var="item">

			<tr>
				<td>${item.denominazione }</td>
				<td>${item.importo }</td>
				<td><a
					href="VisualizzaDettaglioCartellaServlet?idCartella=${item.id }"
					class="btn btn-info">Dettaglio</a> <a
					href="PreparaModificaCartellaServlet?idCartella=${item.id }"
					class="btn btn-info">Modifica</a> <a
					href="PreparaEliminaCartellaServlet?idCartella=${item.id }"
					class="btn btn-info">Elimina</a></td>
			</tr>

			</c:forEach>

		</table>
		 </div><!-- /.container -->
</body>
</html>