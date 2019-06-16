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

			<h3>Inserisci Categoria</h3>

		</div>
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
		<form class="form-horizontal"
			action="${pageContext.request.contextPath}/admin/ExecuteInserisciCategoriaServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId"
						name="descrizioneInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId"
						name="codiceInput">
				</div>
			</div>

			<button type="submit" class="btn btn-primary btn-md">Inserisci Categoria</button>

		</form>

	</div>

	<!-- /.container -->
</body>