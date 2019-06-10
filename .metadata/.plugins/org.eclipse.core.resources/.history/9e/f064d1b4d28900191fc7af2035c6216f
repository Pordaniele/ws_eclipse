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

<%
			if (request.getAttribute("messaggioDiErrore") != null) {
		%>
		<%=request.getAttribute("messaggioDiErrore")%>
		<%
			} else {
		%>Inserire dati da Modificare<br>
		<%
			}
		%>
		<%
			Municipio municipioInPagina = (Municipio) request.getAttribute("MunicipioDaModificare");
		%>
		<div class="page-header">
			<h3>Pagina di modifica</h3>
		</div>

		<form class="form-horizontal" action="ModificaMunicipioServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
				<div class="col-sm-4">
					<input class="form-control" value=<%=municipioInPagina.getDescrizione()%>
						type="text" id="descrizioneInputId" name="descrizioneInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="ubicazioneInputId">Ubicazione:</label>
				<div class="col-sm-4">
					<input class="form-control" value="<%=municipioInPagina.getUbicazione()%>"
						type="text" id="ubicazioneInputId" name="ubicazioneInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
				<div class="col-sm-4">
					<input class="form-control" value="<%=municipioInPagina.getCodice()%>"
						type="text" id="codiceInputId" name="codiceInput">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Modifica</button>
				</div>
			</div>
			<input class="form-control" value="<%=municipioInPagina.getId()%>"
				type="hidden" id="idInputId" name="idMunicipio">
		</form>

	</div>
	<!-- /.container -->
</body>
</html>