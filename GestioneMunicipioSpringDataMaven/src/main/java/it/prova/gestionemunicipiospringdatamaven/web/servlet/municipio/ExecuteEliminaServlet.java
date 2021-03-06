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

import it.prova.gestionemunicipiospringdatamaven.model.Municipio;
import it.prova.gestionemunicipiospringdatamaven.service.municipio.MunicipioService;

/**
 * Servlet implementation class ExecuteEliminaServlet
 */
@WebServlet("/municipio/ExecuteEliminaServlet")
public class ExecuteEliminaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
  
    public ExecuteEliminaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinazione = null;

		Long idPagina = Long.parseLong((String) request.getParameter("idMunicipio"));
		Municipio m1=municipioService.caricaEager(idPagina);
		
		municipioService.rimuovi(m1);
		
		request.setAttribute("listaMunicipi", municipioService.listAllMunicipi());
		RequestDispatcher rd = request.getRequestDispatcher("/municipio/results.jsp");
		rd.forward(request, response);
		
	}

}
