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

			<h3>Modifica Municipio</h3>
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


			<form name="myForm" class="form-horizontal"
				action="${pageContext.request.contextPath}/municipio/ExecuteModificaMunicipioServlet"
				method="post" onsubmit="return validateForm()">
				<div class="form-group" onsubmit="return validateForm()">
					<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
					<div class="col-sm-4">
						<input class="form-control"
							value="${municipioDaModificare.descrizione}" type="text"
							id="nomeInputId" name="descrizioneInput">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
					<div class="col-sm-4">
						<input class="form-control"
							value="${municipioDaModificare.codice }" type="text"
							id="cognomeInputId" name="codiceInput">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="ubicazioneInputId">Ubicazione:</label>
					<div class="col-sm-4">
						<input class="form-control"
							value="${municipioDaModificare.ubicazione }" type="text"
							id="usernameInputId" name="ubicazioneInput">
					</div>
				</div>

				<input class="form-control" value="${municipioDaModificare.id }"
					type="hidden" id="idInputId" name="idInput">

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary btn-md">Modifica
							Municipio</button>
					</div>
				</div>

			</form>
		</div>
	</div>
</body>