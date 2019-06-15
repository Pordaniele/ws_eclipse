package it.prova.ebayjpa.web.servlet.admin;

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

import it.prova.ebayjpa.dto.UtenteDTO;
import it.prova.ebayjpa.model.Utente;
import it.prova.ebayjpa.service.ruolo.RuoloService;
import it.prova.ebayjpa.service.utente.UtenteService;

/**
 * Servlet implementation class ExecuteInserisciUtenteServlet
 */
@WebServlet("/admin/ExecuteInserisciUtenteServlet")
public class ExecuteInserisciUtenteServlet extends HttpServlet {
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
    public ExecuteInserisciUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("oleeeeee: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeDaPagina = request.getParameter("nomeInput");
		String cognomeDaPagina = request.getParameter("cognomeInput");
		String usernameDaPagina = request.getParameter("usernameInput");
		String passwordDaPagina = request.getParameter("passwordInput");
		double prezzoInput=0L;
		try {
			
			prezzoInput = Double.parseDouble((String) request.getParameter("creditoInput"));
		} catch (NumberFormatException e) {
			prezzoInput = -1;
		}
		Date dataInInput = new Date();
		String []ruoli=request.getParameterValues("ruoloId");
		UtenteDTO temp = new UtenteDTO(nomeDaPagina, cognomeDaPagina, usernameDaPagina, passwordDaPagina, dataInInput);
		temp.setCreditoResiduo(prezzoInput);
		
		if(!temp.validate().isEmpty() ||!(ruoli != null && ruoli.length> 0) ) {
			
			request.setAttribute("messaggioDiErrore", temp.validate());
			request.setAttribute("listaRuoli", ruoloService.list());
			RequestDispatcher rd = request.getRequestDispatcher("/admin/inserisciUtente.jsp");
			rd.forward(request, response);
			return;}
		if(ruoli != null && ruoli.length> 0) {
			for (int i = 0; i < ruoli.length; i++) {
				temp.getRuoli().add(ruoloService.get(Long.parseLong(ruoli[i])));
			}
	
		}
		Utente insertUtente =UtenteDTO.buildUtenteFromDTO(temp);
		utenteService.inserisciNuovo(insertUtente);
		request.setAttribute("listaUtenti", utenteService.listAllUtenti());
		

		RequestDispatcher rd = request.getRequestDispatcher("/admin/risultatoRicercaUtenti.jsp");
		rd.forward(request, response);
	}

}
