package it.prova.ebayjpa.web.servlet.admin;

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
import it.prova.ebayjpa.service.ruolo.RuoloService;
import it.prova.ebayjpa.service.utente.UtenteService;

/**
 * Servlet implementation class PreparaModificaUtenteServlet
 */
@WebServlet("/admin/PreparaModificaUtenteServlet")
public class PreparaModificaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private RuoloService ruoloService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}   
    public PreparaModificaUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idTemp = Long.parseLong((String) request.getParameter("idUtente"));
		Utente c1 = utenteService.caricaEagerAnnunci(idTemp);
		
		request.setAttribute("utenteDaModificare", c1);
		request.setAttribute("listaRuoli", ruoloService.list());
		RequestDispatcher rd = request.getRequestDispatcher("/admin/modificaUtente.jsp");
		rd.forward(request, response);
	}
	


}
