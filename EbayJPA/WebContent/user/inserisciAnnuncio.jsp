<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function validateForm() {
	
  var testoAnnuncio = document.forms["myForm"]["testoAnnuncioInput"].value;

    if ((testoAnnuncio == "") || (testoAnnuncio == "undefined")) {
    	alert("Il campo Nome è obbligatorio.");
    	document.forms["myForm"]["testoAnnuncioInput"].focus();
    	return false;
    	}
 
}
</script>
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


			<form name="myForm" class="form-horizontal" action="EseguiInserisciAnnuncioServlet"
				method="post" onsubmit="return validateForm()">
				<div class="form-group">
					<label class="control-label col-sm-2" for="testoAnnuncioId">Annuncio:</label>
					<div class="col-sm-4">
						<input class="form-control" value="" type="text"
							id="testoAnnuncioId" name="testoAnnuncioInput">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="prezzoInputId">Prezzo:</label>
					<div class="col-sm-4">
						<input class="form-control" value="" type="text"
							id="prezzoInputId" name="prezzoInput">
					</div>
				</div>



				<input class="form-control" value="${userInfo.id }" type="hidden"
					id="utenteId" name="userIdList">


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
</html>