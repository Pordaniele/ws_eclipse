<%@page import="java.util.List"%>
<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
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

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">

<h3>Inserisci Abitante</h3>
			<%if(request.getAttribute("messaggioDiErrore") != null){ %>
			<%=request.getAttribute("messaggioDiErrore") %>
			<% }else{ %>Inserire dati<br>
			<%} %>
		</div>

		<form class="form-horizontal" action="InserisciAbitanteServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="etaInputId">Eta:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId"
						name="etaInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="residenzaInputId"
						name="residenzaInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="municipioInputId">Municipio:</label>
			<select name="municipioInput">
			<option value ="-1">---SELEZIONA MUNICIPIO----</option>
			<%
				List<Municipio> listaMunicipio = (List<Municipio>) request.getAttribute("listaMunicipioAttributeName");
				for (Municipio municipioItem : listaMunicipio) {
			%>
			<option value ="<%=municipioItem.getId() %>" ><%=municipioItem.getDescrizione() %></option>
			
			<%} %>
			</select>
			</div>
			</div>
			<br><br>
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