<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

   <%@ include file="/header.jsp" %>
      
    <div class="page-header">

<h3>Inserisci Abitante</h3>
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

		<form class="form-horizontal" action="${pageContext.request.contextPath }/abitante.do"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nome">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognome">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="etaInputId">eta:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId"
						name="eta">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="residenzaInputId"
						name="residenza">
				</div>
			</div>
			
				<label class="control-label col-sm-2" for="ContribuenteInputId">Municipio:</label>
				<select name="municipioId">
					<option value="-1">----SELEZIONA Municipio----</option>

					<c:forEach items="${listaMunicipi }" var="item">
						<option value="${item.id }">${item.descrizione }</option>

					</c:forEach>
				</select>
			<input type="hidden" name="codop" value="save"> 
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Inserisci</button>
				</div>
			</div>
		</form>

	</div>
	<!-- /.container -->
</body>
</html>