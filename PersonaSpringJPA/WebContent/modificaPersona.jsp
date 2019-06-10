<%@page import="it.prova.model.Persona"%>
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

   <%@ include file="header.jsp" %>
<%if(request.getAttribute("messaggioDiErrore") != null){ %>
		<%=request.getAttribute("messaggioDiErrore") %>
	<% }else{ %>
		Inserire dati da ricercare<br>
	<%} %>
<%
		Persona personaInPagina = (Persona) request.getAttribute("personaDaModificare");
	%>
<div class="page-header">
	  <h3>Pagina di modifica</h3>
	</div>

      	<form class="form-horizontal" action="ModificaPersonaServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" value= <%=personaInPagina.getNome() %> type="text" id="nomeInputId" name="nomeInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" value= "<%=personaInPagina.getCognome() %>" type="text" id="cognomeInputId" name="cognomeInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="etaInputId">Eta:</label>
	    		<div class="col-sm-4">
					<input class="form-control" value= "<%=personaInPagina.getEta() %>" type="text" id="etaInputId" name="etaInput" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="cfInputId">CF:</label>
	    		<div class="col-sm-4">
					<input class="form-control" value= "<%=personaInPagina.getCf() %>" type="text" id="cfInputId" name="cfInput" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="indirizzoInputId">Indirizzo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" value= "<%=personaInPagina.getIndirizzo() %>" type="text" id="indirizzoInputId" name="indirizzoInput" >
			 	</div>
  			</div>
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Modifica</button>
		      </div>
		    </div>
		    <input class="form-control" value= "<%=personaInPagina.getId() %>" type="hidden" id="idInputId" name="idPersona" >
		</form>

    </div><!-- /.container -->

</body>
</html>