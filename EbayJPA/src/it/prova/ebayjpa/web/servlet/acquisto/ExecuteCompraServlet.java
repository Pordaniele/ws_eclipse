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
import it.prova.ebayjpa.service.acquisto.AcquistoService;
import it.prova.ebayjpa.service.annuncio.AnnuncioService;
import it.prova.ebayjpa.service.categoria.CategoriaService;
import it.prova.ebayjpa.service.utente.UtenteService;

/**
 * Servlet implementation class ExecuteCompraServlet
 */
@WebServlet("/ExecuteCompraServlet")
public class ExecuteCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AnnuncioService annuncioService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private AcquistoService acquistoService;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public ExecuteCompraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("compraaaa ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinazione = null;
		long idInput = 0L;
		idInput = Long.parseLong((String) request.getParameter("idInput"));
		System.out.println(idInput);
		HttpSession session = request.getSession();
		Utente utenteInSessione = (Utente) request.getSession().getAttribute("userInfo");
		System.out.println(utenteInSessione.getId());
		
		long idDaUtente = utenteInSessione.getId();
		System.out.println(idDaUtente);
		
		
		acquistoService.compraVendita(idDaUtente, idInput);
		request.setAttribute("listaAnnunci",annuncioService.list());
		destinazione = "result.jsp";
	

RequestDispatcher rd = request.getRequestDispatcher(destinazione);
rd.forward(request, response);
	}

}
