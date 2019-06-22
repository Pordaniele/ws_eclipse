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

			<h3>Modifica Annuncio</h3>
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


			<form name="myForm" class="form-horizontal" action="ModificaAnnuncioServlet"
				method="post" onsubmit="return validateForm()">
				<div class="form-group">
					<label class="control-label col-sm-2" for="testoAnnuncioId">testo:</label>
					<div class="col-sm-4">
						<input class="form-control"
							value="${annuncioDaModificare.testoAnnuncio}" type="text"
							id="testoAnnuncioId" name="testoAnnuncioInput">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="prezzoInputId">Prezzo:</label>
					<div class="col-sm-4">
						<input class="form-control"
							value="${annuncioDaModificare.prezzo }" type="text"
							id="prezzoInputId" name="prezzoInput">
					</div>
				</div>
				
				<input class="form-control" value="${annuncioDaModificare.id }"
					type="hidden" id="idInputId" name="idInput">
					<input class="form-control" value="${annuncioDaModificare.utente.getId() }"
					type="hidden" id="utenteId" name="utenteInput">
					<input class="form-control" value="${userInfo.id }"
					type="hidden" id="utenteId" name="userIdList">
				<input class="form-control" value="${annuncioDaModificare.isApertoChiuso() }"
					type="hidden" id="apertoChiusoInputId" name="aprtoChiusoInput">
					<input class="form-control" value="${annuncioDaModificare.dataAnnuncio }"
					type="hidden" id="dataAnnuncioInputId" name="dataInput">
					<c:forEach items="${listaCategorie }" var="item">
					<input type="checkbox" name="categoriaId" value="${item.id }">${item.descrizione }<br>
				</c:forEach>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary btn-md">Inserisci</button>
					</div>
				</div>
				
			</form>
		</div>
	</div>
</body>
<script>
function validateForm() {
	
  var testoAnnuncio = document.forms["myForm"]["testoAnnuncioInput"].value;
  var prezzo = document.forms["myForm"]["prezzoInput"].value;

    if ((testoAnnuncio == "") || (testoAnnuncio == "undefined")) {
    	alert("Il campo Nome è obbligatorio.");
    	document.forms["myForm"]["testoAnnuncioInput"].focus();
    	return false;
    	}
    if((prezzo<=0)){
    	alert("inserisci un numero");
    	document.forms["myForm"]["prezzoInput"].focus();
    	return false;
    	}
    
 
}
</script>
</html>