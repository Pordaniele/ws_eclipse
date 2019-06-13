package it.prova.ebayjpa.web.servlet.user;

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

import it.prova.ebayjpa.service.annuncio.AnnuncioService;
import it.prova.ebayjpa.service.utente.UtenteService;

/**
 * Servlet implementation class VisualizzaDettaglioAnnuncioUtenteServlet
 */
@WebServlet("/VisualizzaDettaglioAnnuncioUtenteServlet")
public class VisualizzaDettaglioAnnuncioUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private AnnuncioService annuncioService;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}  
    public VisualizzaDettaglioAnnuncioUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
long idInput = Long.parseLong((String) request.getParameter("idAnnuncio"));

	
		
		request.setAttribute("dettaglioAnnuncio", annuncioService.caricaEager(idInput));
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/visualizzaDettaglioAnnuncioUser.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
