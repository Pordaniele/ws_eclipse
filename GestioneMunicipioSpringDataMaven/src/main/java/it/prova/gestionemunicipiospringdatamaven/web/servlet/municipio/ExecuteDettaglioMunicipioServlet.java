package it.prova.gestionemunicipiospringdatamaven.web.servlet.municipio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionemunicipiospringdatamaven.service.municipio.MunicipioService;


/**
 * Servlet implementation class ExecuteDettaglioMunicipioServlet
 */
@WebServlet("/municipio/ExecuteDettaglioMunicipioServlet")
public class ExecuteDettaglioMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	} 
   
    public ExecuteDettaglioMunicipioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idInput = Long.parseLong((String) request.getParameter("idMunicipio"));

		request.setAttribute("dettaglioMunicipio", municipioService.caricaSingoloMunicipio(idInput) );

		RequestDispatcher rd = request.getRequestDispatcher("/municipio/dettaglioMunicipio.jsp");
		rd.forward(request, response);
	
	}

	
}
