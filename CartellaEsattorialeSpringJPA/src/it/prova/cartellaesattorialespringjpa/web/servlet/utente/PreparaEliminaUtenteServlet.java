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

import it.prova.cartellaesattorialespringjpa.model.CartellaEsattoriale;
import it.prova.cartellaesattorialespringjpa.model.Utente;
import it.prova.cartellaesattorialespringjpa.model.dto.CartellaEsattorialeDTO;
import it.prova.cartellaesattorialespringjpa.service.cartellaesattoriale.CartellaEsattorialeService;
import it.prova.cartellaesattorialespringjpa.service.contribuente.ContribuenteService;
import it.prova.cartellaesattorialespringjpa.service.ruolo.RuoloService;
import it.prova.cartellaesattorialespringjpa.service.utente.UtenteService;

/**
 * Servlet implementation class PreparaEliminaUtenteServlet
 */
@WebServlet("/admin/PreparaEliminaUtenteServlet")
public class PreparaEliminaUtenteServlet extends HttpServlet {
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

    public PreparaEliminaUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idTemp = Long.parseLong((String) request.getParameter("idUtente"));
		Utente c = utenteService.CaricaEager(idTemp);
		
		request.setAttribute("UtenteSingolo", c);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/eliminaUtente.jsp");
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
