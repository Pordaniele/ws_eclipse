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
	  <h3>Pagina di Ricerca Tavoli</h3>
	</div>

		<form:form class="form-horizontal" action="list" method="post" commandName="playCommand">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="titoloId">Denominazione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="titoloId" name="denominazione" >
			 	</div>
  			</div>
  			
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="dataPubblicazioneId">Data:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="date" id="dataPubblicazioneId" name="dataCreazione" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="creatoreId">Username Creatore:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="creatoreId" name="creatore" >
			 	</div>
  			</div>
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Effetua Ricerca</button>
		        <a href="create" class="btn btn-primary btn-md">Inserisci Nuovo Elemento</a>
		      </div>
		    </div>
		</form:form>
		
		<h3>Cerca Per giocatore</h3>
			<form:form class="form-horizontal" action="cercaPerGiocatore" method="post" commandName="playCommand">
      		
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="giocatoreId">Giocatore:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="giocatoreId" name="giocatore" >
			 	</div>
  			</div>
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Effetua Ricerca</button>
		      </div>
		    </div>
		</form:form>
		
		
		
    </div><!-- /.container -->

</body>
</html>