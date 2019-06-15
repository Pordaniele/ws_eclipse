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
					<th>Nome</th>
					<th>Cognome</th>
					<th>username</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:forEach items="${listaUtenti}" var="item">

				<tr>
					<td>${item.nome }</td>
					<td>${item.cognome }</td>
					<td>${item.username }</td>
					
					<td><a
						href="${pageContext.request.contextPath}/admin/VisualizzaDettaglioUtenteServlet?idUtente=${item.id }"
						class="btn btn-info">Dettaglio</a>  <a
						href="${pageContext.request.contextPath}/admin/PreparaEliminaUtenteServlet?idUtente=${item.id }"
						class="btn btn-info">Elimina</a> <a
						href="${pageContext.request.contextPath}/admin/PreparaModificaUtenteServlet?idUtente=${item.id }"
						class="btn btn-info">Modifica</a></td>
						
				</tr>

			</c:forEach>

		</table>
		<a
						href="${pageContext.request.contextPath}/admin/PrepareInserisciUtenteServlet?idUtente=${item.id }"
						class="btn btn-info">Inserisci nuovo utente</a>
	</div>
	<!-- /.container -->
</body>
</html>