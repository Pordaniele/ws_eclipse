package it.prova.cartellaesattorialespringjpa.web.servlet.utente;

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

import it.prova.cartellaesattorialespringjpa.service.ruolo.RuoloService;
import it.prova.cartellaesattorialespringjpa.service.utente.UtenteService;

/**
 * Servlet implementation class VisualizzaDettaglioUtenteServlet
 */
@WebServlet("/admin/VisualizzaDettaglioUtenteServlet")
public class VisualizzaDettaglioUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private RuoloService ruoloService;

    public VisualizzaDettaglioUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idDaPagina = request.getParameter("idUtente");
	

		
		request.setAttribute("UtenteSingolo",
				utenteService.CaricaEager((Long.parseLong(idDaPagina))));

		RequestDispatcher rd = request.getRequestDispatcher("/admin/dettaglioSingoloUtente.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
