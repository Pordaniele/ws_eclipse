<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci nuovo elemento</title>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Modifica</h3>
	</div>

		<form:form class="form-horizontal" action="update" method="post" commandName="adminCommand">
      		<form:hidden path="id"/>
				<form:hidden path="dataRegistrazione"/>
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeId">Nome:</label>
	    		<div class="col-sm-4">
					<form:input class="form-control" path="nome" id="nomeId" />
					<form:errors path="nome" cssStyle="color:red;"/>
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cognomeId">Cognome:</label>
	    		<div class="col-sm-4">
	    			<form:input class="form-control" path="cognome" id="cognomeId" />
	    			<form:errors path="cognome" cssStyle="color:red;"/>
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="username">Username:</label>
	    		<div class="col-sm-4">
	    			<form:input type="text" class="form-control" path="username" id="username" />
	    			<form:errors path="username" cssStyle="color:red;"/>
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="passwordId">Password:</label>
	    		<div class="col-sm-4">
	    			<form:input type="text" class="form-control" path="password" id="passwordId" />
	    			<form:errors path="password" cssStyle="color:red;"/>
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="esperienzaAccumulataId">Esperienza Accumulata:</label>
	    		<div class="col-sm-4">
	    			<form:input type="text" class="form-control" path="esperienzaAccumulata" id="esperienzaAccumulataId" />
	    			<form:errors path="esperienzaAccumulata" cssStyle="color:red;"/>
			 	</div>
  			</div>
  		<div class="form-group">
      			<label class="control-label col-sm-2" for="creditoAccumulatoId">Credito:</label>
	    		<div class="col-sm-4">
	    			<form:input type="text" class="form-control" path="creditoAccumulato" id="creditoAccumulatoId" />
	    			<form:errors path="creditoAccumulato" cssStyle="color:red;"/>
			 	</div>
  			</div>
  				
				<div class="form-group">
	      			<label class="control-label col-sm-2" for="ruoliId">Ruoli:</label>
		    		<div class="col-sm-2">
		    		<form:checkboxes	 class="form-control" multiple="true" name="ruoliId" path="ruoli" id="ruoliId" itemLabel="codice" itemValue="id" items="${listRuoli}"/>
			 			${item.descrizione } <br>
						<form:errors path="ruoli" cssStyle="color:red;"/>
				 	</div>
	  			</div>	
			</div>
				<div class="form-group">
				<label class="control-label col-sm-2" for="ContribuenteInputId">stato:</label>
				<form:select name="statoUtenzaInput" path="statoUtenza.id">
					

					<c:forEach items="${listStati }" var="item">
						<option  value="${item.id }">${item.descrizione }</option>
					
					</c:forEach>
				</form:select>
				
			</div>
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Effettua Modifica</button>
		      </div>
		    </div>
		</form:form>
		
    </div><!-- /.container -->

</body>
</html>