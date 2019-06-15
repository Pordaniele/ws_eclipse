package it.prova.ebayjpa.web.servlet.acquisto;

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

import it.prova.ebayjpa.model.Annuncio;
import it.prova.ebayjpa.model.Utente;
import it.prova.ebayjpa.service.annuncio.AnnuncioService;
import it.prova.ebayjpa.service.categoria.CategoriaService;
import it.prova.ebayjpa.service.utente.UtenteService;

/**
 * Servlet implementation class PrepareCompraServlet
 */
@WebServlet("/PrepareCompraServlet")
public class PrepareCompraServlet extends HttpServlet {
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

	public PrepareCompraServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		String destinazione = null;
		HttpSession session = request.getSession();
		Utente utenteInSessione = (Utente) request.getSession().getAttribute("userInfo");
		Long idAnnuncio = Long.parseLong((String) request.getParameter("idAnnuncio"));
		Annuncio annuncio = annuncioService.caricaEager(idAnnuncio);
		if (utenteInSessione.getId() == annuncio.getUtente().getId()) {
			request.setAttribute("messaggioDiErrore", "stai comprando da te stesso");
			destinazione = "user/userHome.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
		}

		request.setAttribute("AnnuncioDaComprare", annuncio);
		destinazione = "/user/paginaCompra.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
