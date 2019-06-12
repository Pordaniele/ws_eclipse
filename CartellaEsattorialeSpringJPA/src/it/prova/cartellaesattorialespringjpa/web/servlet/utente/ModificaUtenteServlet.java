package it.prova.cartellaesattorialespringjpa.web.servlet.utente;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.cartellaesattorialespringjpa.model.Utente;
import it.prova.cartellaesattorialespringjpa.model.dto.UtenteDTO;
import it.prova.cartellaesattorialespringjpa.service.ruolo.RuoloService;
import it.prova.cartellaesattorialespringjpa.service.utente.UtenteService;

/**
 * Servlet implementation class ModificaUtenteServlet
 */
@WebServlet("/admin/ModificaUtenteServlet")
public class ModificaUtenteServlet extends HttpServlet {
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
    public ModificaUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("dfgfgdf ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinazione=null;
		Long idInput = 0L;
		idInput = Long.parseLong((String) request.getParameter("idInput"));
			
	
		String nomeDaPagina = request.getParameter("nomeInput");
		String cognomeDaPagina = request.getParameter("cognomeInput");
		String usernameDaPagina = request.getParameter("usernameInput");
		String passwordDaPagina = request.getParameter("passwordInput");
		Date dataInInput = new Date();
		UtenteDTO temp = new UtenteDTO(nomeDaPagina, cognomeDaPagina, usernameDaPagina, passwordDaPagina, dataInInput);
		if(!temp.validate().isEmpty()) {
			request.setAttribute("messaggioDiErrore", temp.validate());
			Utente c= utenteService.CaricaEager(idInput);
			request.setAttribute("utenteDaModificare", c);
			request.setAttribute("listaRuoli", ruoloService.list());
			destinazione = "/admin/modificaUtente.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
			return;}
		
		String []ruoli=request.getParameterValues("ruoloId");
		if(ruoli != null && ruoli.length> 0) {
		for (int i = 0; i < ruoli.length; i++) {
			temp.getRuoli().add(ruoloService.get(Long.parseLong(ruoli[i])));
		}
		}
		Utente inserUtente= UtenteDTO.buildUtenteFromDTO(temp);
		inserUtente.setId(idInput);
		utenteService.aggiorna(inserUtente);;
		request.setAttribute("listaUtentiAttribute", utenteService.listAllUtenti());
		destinazione = "/admin/result.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
		
		}

}
