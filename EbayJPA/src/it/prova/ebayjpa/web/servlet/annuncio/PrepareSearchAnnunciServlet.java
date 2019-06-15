package it.prova.ebayjpa.web.servlet.annuncio;

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

import it.prova.ebayjpa.model.Utente;
import it.prova.ebayjpa.service.categoria.CategoriaService;
import it.prova.ebayjpa.service.utente.UtenteService;

/**
 * Servlet implementation class PrepareSearchAnnunciServlet
 */
@WebServlet("/user/PrepareSearchAnnunciServlet")
public class PrepareSearchAnnunciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private UtenteService utenteService;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public PrepareSearchAnnunciServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idTemp = Long.parseLong((String) request.getParameter("idUtente"));
		Utente c1 = utenteService.caricaEagerAnnunci(idTemp);
		
		request.setAttribute("listaAnnunci", c1.getAnnunci());
		RequestDispatcher rd = request.getRequestDispatcher("/user/ricercaAnnunci.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
