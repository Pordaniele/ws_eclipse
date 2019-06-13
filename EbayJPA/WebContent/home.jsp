<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accedi</title>
</head>
<body>

<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h1>EbFake</h1>
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
		

		<form class="form-horizontal" action="${pageContext.request.contextPath}/SearchAnnunciServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId"
						name="descrizioneInput">
				</div>
				<label class="control-label col-sm-2" for="descrizioneInputId">Prezzo Massimo:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId"
						name="prezzoMaxInput">
				</div>
			</div>
			<c:forEach items="${listaCategorie }" var="item">
				<input type="checkbox" name="categoriaId" value="${item.id }">${item.descrizione }<br>
			</c:forEach>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Effettua
						Ricerca</button>
				</div>
			</div>
		</form>

	</div>
	<!-- /.container -->

</body>
</html>