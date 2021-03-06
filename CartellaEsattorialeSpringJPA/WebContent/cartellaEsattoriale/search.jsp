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
			<h3>Pagina di Ricerca Cartella Esattoriale</h3>
		</div>

		<form class="form-horizontal" action="SearchCartellaServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="denominazioneInputId">Denominazione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="denominazioneInputId"
						name="denominazioneInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="importoInputId">Importo:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="importoInputId"
						name="importoInput">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Effettua
						Ricerca</button>
					<a href="PreparaInsertCartellaServlet"
						class="btn btn-primary btn-md">Inserisci Nuovo Elemento</a>
				</div>
			</div>
		</form>

	</div>
	<!-- /.container -->
</body>
</html>