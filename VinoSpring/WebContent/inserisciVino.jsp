<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="page-header">
		<div class="container">

			<%@ include file="header.jsp"%>

			<h3>Inserisci Vino</h3>
			<%if(request.getAttribute("messaggioDiErrore") != null){ %>
			<%=request.getAttribute("messaggioDiErrore") %>
			<% }else{ %>Inserire dati<br>
			<%} %>
		</div>

		<form class="form-horizontal" action="InserisciVinoServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cantinaInputId">Cantina:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cantinaInputId"
						name="cantinaInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="annataInputId">Annata:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="annataInputId"
						name="annataInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="localitaInputId">Localit�:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="localitaInputId"
						name="localitaInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="uvaInputId">uva:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="uvaInputId"
						name="uvaInput">
				</div>
			</div>
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