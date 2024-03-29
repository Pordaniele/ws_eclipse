<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
<%@page import="java.util.List"%>
<%@page import="it.prova.gestionemunicipiospringjpa.model.Abitante"%>
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
			<%
			Abitante abitanteInPagina = (Abitante) request.getAttribute("abitanteDaModificare");
		%>
		</div>

		<form class="form-horizontal" action="ModificaAbitanteServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" value="<%=abitanteInPagina.getNome() %>" type="text" id="nomeInputId"
						name="nomeInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" value="<%=abitanteInPagina.getCognome() %>" type="text" id="cognomeInputId"
						name="cognomeInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="etaInputId">Eta:</label>
				<div class="col-sm-4">
					<input class="form-control" value="<%=abitanteInPagina.getEta() %>" type="text" id="etaInputId"
						name="etaInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
				<div class="col-sm-4">
					<input class="form-control" value="<%=abitanteInPagina.getResidenza() %>" type="text" id="residenzaInputId"
						name="residenzaInput">
				</div>
			</div>
			<input class="form-control" value="<%=abitanteInPagina.getId() %>" type="hidden" id="idInputId"
						name="idInput">
			<div class="form-group">
				<label class="control-label col-sm-2" for="municipioInputId">Municipio:</label>
			<select name="municipioInput">
			<option value ="<%=abitanteInPagina.getMunicipio().getId()%>"><%=abitanteInPagina.getMunicipio().getDescrizione() %></option>
			<%
				List<Municipio> listaMunicipio = (List<Municipio>) request.getAttribute("listaMunicipi");
				for (Municipio municipioItem : listaMunicipio) {
					if(abitanteInPagina.getMunicipio().getId()!= municipioItem.getId()){
			%>
			<option value ="<%=municipioItem.getId() %>" ><%=municipioItem.getDescrizione() %></option>
			
			<%}
					} %>
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