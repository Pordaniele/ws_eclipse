<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


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
	<h3>Vuoi Comprare questo oggetto?</h3>

	<form class="form-horizontal" action="ExecuteCompraServlet"
		method="post">
		
			<label class="control-label col-sm-2" for="descrizioneInputId">id:</label>
			<div class="col-sm-4">
				<input class="form-control" type="text"
					value="${AnnuncioDaComprare.id }" id="descrizioneInputId"
					name="idInput" readonly>
			</div>
			<div class="col-sm-4">
				<input class="form-control" type="text"
					value="${AnnuncioDaComprare.testoAnnuncio }"
					id="testoAnnuncioInputId" name="descrizioneInput" readonly>
			</div>
			<div class="col-sm-4">
				<input class="form-control" type="text"
					value="${AnnuncioDaComprare.dataAnnuncio }" id="descrizioneInputId"
					name="dataInput" readonly>
			</div>
			<div class="col-sm-4">
				<input class="form-control" type="text"
					value="${AnnuncioDaComprare.prezzo }" id="descrizioneInputId"
					name="prezzoInput" readonly>
			</div>
			<div class="col-sm-4">
				<input class="form-control" type="text"
					value="${AnnuncioDaComprare.utente.nome } ${AnnuncioDaComprare.utente.cognome}"
					id="nomeUtenteInputId" name="descrizioneInput" readonly>
			</div>


			<button type="submit" class="btn btn-primary btn-md">Effettua
				Ricerca</button>
	</form>


</body>
</html>