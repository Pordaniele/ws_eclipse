package it.prova.cartellaesattorialespringjpa.web.servlet.contribuente;

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

import it.prova.cartellaesattorialespringjpa.service.contribuente.ContribuenteService;


@WebServlet("/VisualizzaDettaglioContribuenteServlet")
public class VisualizzaDettaglioContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public VisualizzaDettaglioContribuenteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// controllo utente in sessione (va fatto in tutte le servlet)
		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		String idContribuenteDaPagina = request.getParameter("idContribuente");

		request.setAttribute("contribuenteSingoloAttributeName",
				contribuenteService.caricaSingoloContribuente(Long.parseLong(idContribuenteDaPagina)));

		RequestDispatcher rd = request.getRequestDispatcher("/contribuente/dettaglioSingoloContribuente.jsp");
		rd.forward(request, response);
}
}