package it.prova.ebayjpa.web.servlet.user;

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
import it.prova.ebayjpa.model.Ruolo;
import it.prova.ebayjpa.model.Utente;
import it.prova.ebayjpa.service.ruolo.RuoloService;
import it.prova.ebayjpa.service.utente.UtenteService;

/**
 * Servlet implementation class ExecuteRegistraUtenteServlet
 */
@WebServlet("/ExecuteRegistraUtenteServlet")
public class ExecuteRegistraUtenteServlet extends HttpServlet {
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
    public ExecuteRegistraUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("resgitrati ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeDaPagina = request.getParameter("nomeInput");
		String cognomeDaPagina = request.getParameter("cognomeInput");
		String usernameDaPagina = request.getParameter("usernameInput");
		String passwordDaPagina = request.getParameter("passwordInput");
		double prezzoInput=0L;
		
		Date dataInInput = new Date();
		
		UtenteDTO temp = new UtenteDTO(nomeDaPagina, cognomeDaPagina, usernameDaPagina, passwordDaPagina, dataInInput);
		temp.setCreditoResiduo(prezzoInput);
		
		if(!temp.validate().isEmpty() )  {
			
			request.setAttribute("messaggioDiErrore", temp.validate());
			
			RequestDispatcher rd = request.getRequestDispatcher("/registraUtente.jsp");
			rd.forward(request, response);
			return;}
		for(Utente item:utenteService.listAllUtenti()) {
			if(temp.getUsername().equals(item.getUsername())){
				request.setAttribute("messaggioDiErrore", "esiste gia questo username");
				
				RequestDispatcher rd = request.getRequestDispatcher("/registraUtente.jsp");
				rd.forward(request, response);
				return;
			}
		}
		Utente insertUtente =UtenteDTO.buildUtenteFromDTO(temp);
		Ruolo temp2= ruoloService.findByExample(new Ruolo(Ruolo.CLASSIC_USER_ROLE)).get(0);
		insertUtente.getRuoli().add(temp2);
		
		utenteService.inserisciNuovo(insertUtente);
		
		

		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
}
