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
			<h3>Cronologia acquisti</h3>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Denominazione</th>
					<th>Importo</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:forEach items="${listaAcquisti}" var="item">

				<tr>
					<td>${item.descrizione }</td>
					<td>${item.prezzo }</td>
					<td><a
						href="${pageContext.request.contextPath}/visualizzaDettaglioAcquistoServlet?idAcquisto=${item.id }"
						class="btn btn-info">Dettaglio</a>
						
				</tr>

			</c:forEach>

		</table>
	</div>
	<!-- /.container -->
</body>
</html>