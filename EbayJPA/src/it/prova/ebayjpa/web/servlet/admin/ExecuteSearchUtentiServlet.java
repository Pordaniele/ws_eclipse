package it.prova.ebayjpa.web.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.ebayjpa.model.Utente;
import it.prova.ebayjpa.service.annuncio.AnnuncioService;
import it.prova.ebayjpa.service.categoria.CategoriaService;
import it.prova.ebayjpa.service.utente.UtenteService;

/**
 * Servlet implementation class ExecuteSearchUtentiServlet
 */
@WebServlet("/admin/ExecuteSearchUtentiServlet")
public class ExecuteSearchUtentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AnnuncioService annuncioService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteSearchUtentiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("ciaoooooooooooooooo ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione=null;
		String nome = request.getParameter("nomeInput");
		String cognome = request.getParameter("cognomeInput");
		String username = request.getParameter("usernameInput");
		Utente example = new Utente();
		example.setNome(nome);
		example.setCognome(cognome);
		example.setUsername(username);
		request.setAttribute("listaUtenti", utenteService.findByExample(example));
		destinazione = "/admin/risultatoRicercaUtenti.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);

	}

}
