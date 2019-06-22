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
	<%@ include file="../../header.jsp"%>

	<div class="page-header">



		<h3>Pagina di Eliminazione Categoria</h3>
	</div>
	<div class="container-fluid">
		<dl class="row">
			<dt class="col-sm-3 text-right">Id</dt>
			<dd class="col-sm-9">${categoriaDaEliminare.id }</dd>
		</dl>
		<dl class="row">
			<dt class="col-sm-3 text-right">Descrizione</dt>
			<dd class="col-sm-9">${categoriaDaEliminare.descrizione }</dd>
		</dl>
		<dl class="row">
			<dt class="col-sm-3 text-right">Cognome</dt>
			<dd class="col-sm-9">${categoriaDaEliminare.codice }</dd>
		</dl>
	</div>
	<c:if test='${listaAnnunci.size()>0}'>
		<h4>ATTENZIONE: i seguenti annunci contengono la categoria che
			stai eliminando! vuoi eliminarla lo stesso?</h4>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Denominazione</th>
					<th>Importo</th>
					<th>Data annuncio</th>
				</tr>
			</thead>
			<c:forEach items="${listaAnnunci}" var="item">

				<tr>
					<td>${item.testoAnnuncio }</td>
					<td>${item.prezzo }</td>
					<td>${item.dataAnnuncio }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<div class="container-fluid">
		<a href="${pageContext.request.contextPath}/home" class="btn btn-info">Torna
			alla Home</a> <a
			href="${pageContext.request.contextPath}/admin/ExecuteEliminaCategoriaServlet?idCategoria=${categoriaDaEliminare.id }"
			class="btn btn-info">Elimina Categoria</a>
	</div>
</body>
</html>