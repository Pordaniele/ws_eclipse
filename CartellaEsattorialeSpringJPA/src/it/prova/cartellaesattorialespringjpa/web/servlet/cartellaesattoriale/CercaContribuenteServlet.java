package it.prova.cartellaesattorialespringjpa.web.servlet.cartellaesattoriale;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.cartellaesattorialespringjpa.model.Contribuente;
import it.prova.cartellaesattorialespringjpa.service.contribuente.ContribuenteService;

@WebServlet("/CercaContribuenteServlet")
public class CercaContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public CercaContribuenteServlet() {
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
		String destinazione = null;
		Long idPagina = Long.parseLong((String) request.getParameter("idContribuente"));
		List<Contribuente> listaContribuente = new ArrayList<Contribuente>();
		Contribuente c1 = contribuenteService.caricaSingoloContribuente(idPagina);
		listaContribuente.add(c1);
		request.setAttribute("listaContribuenteAttribute", listaContribuente);
		destinazione = "/contribuente/result.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
