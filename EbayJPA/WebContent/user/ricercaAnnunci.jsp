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
			<h3>Pagina Ricerca</h3>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Denominazione</th>
					<th>Importo</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:forEach items="${listaAnnunci}" var="item">

				<tr>
					<td>${item.testoAnnuncio }</td>
					<td>${item.prezzo }</td>
					<td><a
						href="<%= request.getContextPath()%>/VisualizzaDettaglioAnnuncioUtenteServlet?idAnnuncio=${item.id }"
						class="btn btn-info">Dettaglio</a> <a
						href="<%= request.getContextPath()%>/PreparaModificaAnnuncioServlet?idAnnuncio=${item.id }"
						class="btn btn-info">Modifica</a> <a
						href="<%= request.getContextPath()%>/PreparaEliminaAnnuncioServlet?idAnnuncio=${item.id }"
						class="btn btn-info">Elimina</a></td>
				</tr>

			</c:forEach>
			<a
				href="<%= request.getContextPath()%>/InserisciAnnuncioUtenteServlet"
				class="btn btn-info">Aggiungi Annuncio</a>
		</table>
	</div>
	<!-- /.container -->
</body>
</html>