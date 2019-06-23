<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Libro</title>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Ricerca</h3>
	</div>

		<form:form class="form-horizontal" action="list" method="post" commandName="adminCommand">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeId">nome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeId" name="nome" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cognomeId">cognome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeId" name="cognome" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="usernameId">username:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="usernameId" name="username" >
			 	</div>
  			</div>
  				<div class="form-group">
      			<label class="control-label col-sm-2" for="dataRegistrazioneId">data registrazione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="date" id="dataRegistrazioneeId" name="dataRegistrazione" >
			 	</div>
  			</div>
  				<div class="form-group">
      			<label class="control-label col-sm-2" for="esperienzaAccumulataId">Esperienza Accumulata:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="esperienzaAccumulataId" name="esperienzaAccumulata" >
			 	</div>
  			</div>
  				<div class="form-group">
      			<label class="control-label col-sm-2" for="creditoAccumulatoId">Credito accumulato:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="creditoAccumulatoId" name="creditoAccumulato" >
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Effetua Ricerca</button>
		        <a href="create" class="btn btn-primary btn-md">Inserisci Nuovo Elemento</a>
		      </div>
		    </div>
		</form:form>
		
    </div><!-- /.container -->

</body>
</html>