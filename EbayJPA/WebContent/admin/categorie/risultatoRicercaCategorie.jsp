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

		<%@ include file="../../header.jsp"%>

		<div class="page-header">
		<div
				class="alert alert-danger alert-dismissible fade show ${messaggioDiErrore != null?'':'d-none' }"
				role="alert">
				<c:forEach items="${messaggioDiErrore }" var="item">
					<p>${item }</p>
				</c:forEach>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<h3>Pagina Ricerca Categorie</h3>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Codice</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:forEach items="${listaCategorie}" var="item">

				<tr>
					<td>${item.descrizione }</td>
					<td>${item.codice }</td>
					<td> <a
						href="${pageContext.request.contextPath}/admin/PrepareModificaCategoriaServlet?idCategoria=${item.id }"
						class="btn btn-info">Modifica</a> <a
						href="${pageContext.request.contextPath}/admin/PrepareEliminaCategoriaServlet?idCategoria=${item.id }"
						class="btn btn-info">Elimina</a></td>
				</tr>

			</c:forEach>
			<a
				href="${pageContext.request.contextPath}/admin/PrepareInserisciCategoriaServlet"
				class="btn btn-info">Crea una nuova categoria</a>
		</table>
	</div>
	<!-- /.container -->
</body>
</html>