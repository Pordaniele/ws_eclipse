<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Tavolo</title>
</head>
<body>

	<div class="container">

	   <%@ include file="../header.jsp" %>
	      
	    <div class="page-header">
		  <h3>Pagina di Modifica tavolo</h3>
		</div>
	
			<form:form class="form-horizontal" action="update" method="post" commandName="tavoloCommand">
				<form:hidden path="id"/>
				<form:hidden path="dataCreazione"/>
	      		<div class="form-group">
	      			<label class="control-label col-sm-2" for="denominazione">denominazione:</label>
		    		<div class="col-sm-4">
						<form:input class="form-control" path="denominazione" id="denominazioneId" />
						<form:errors path="denominazione" cssStyle="color:red;"/>
				 	</div>
	  			</div>
	  			<div class="form-group">
	      			<label class="control-label col-sm-2" for="esperienzaMinId">Esperienza Minima:</label>
		    		<div class="col-sm-4">
		    			<form:input class="form-control" path="esperienzaMin" id="esperienzaMinId" />
		    			<form:errors path="esperienzaMin" cssStyle="color:red;"/>
				 	</div>
	  			</div>
	  			<div class="form-group">
	      			<label class="control-label col-sm-2" for="cifraMinId">Cifra Minima:</label>
		    		<div class="col-sm-4">
		    			<form:input type="number" class="form-control" path="cifraMin" id="dataNascitaId" />
		    			<form:errors path="cifraMin" cssStyle="color:red;"/>
				 	</div>
	  			</div>
	  			<div class="form-group">        
			      <div class="col-sm-offset-2 col-sm-10">
			      	<a href="list" class="btn btn-primary btn-md">Torna alla lista</a>
			        <button type="submit" class="btn btn-primary btn-md">Effettua Modifica</button>
			      </div>
			    </div>
			</form:form>
		
    </div><!-- /.container -->

</body>
</html>