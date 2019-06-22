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
	  <h3>Pagina di Inserimento</h3>
	</div>

		<form:form class="form-horizontal" action="save" method="post" commandName="tavoloCommand">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="denominazione">Denominazione:</label>
	    		<div class="col-sm-4">
					<form:input class="form-control" path="denominazione" id="denominazione" />
					<form:errors path="denominazione" cssStyle="color:red;"/>
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="esperienzaMin">Esperienza Minima:</label>
	    		<div class="col-sm-4">
	    			<form:input class="form-control" path="esperienzaMin" id="esperienzaMin" />
	    			<form:errors path="esperienzaMin" cssStyle="color:red;"/>
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cifraMin">Cifra Minima:</label>
	    		<div class="col-sm-4">
	    			<form:input type="number" class="form-control" path="cifraMin" id="cifraMin" />
	    			<form:errors path="cifraMin" cssStyle="color:red;"/>
			 	</div>
  			</div>
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Effettua Inserimento</button>
		      </div>
		    </div>
		</form:form>
		
    </div><!-- /.container -->

</body>
</html>