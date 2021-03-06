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

import it.prova.cartellaesattorialespringjpa.model.Contribuente;
import it.prova.cartellaesattorialespringjpa.model.dto.ContribuenteDTO;
import it.prova.cartellaesattorialespringjpa.service.contribuente.ContribuenteService;

@WebServlet("/PreparaModificaContribuenteServlet")
public class PreparaModificaContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public PreparaModificaContribuenteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// controllo utente in sessione (va fatto in tutte le servlet)
		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		Long idTemp = Long.parseLong((String) request.getParameter("idContribuente"));
		Contribuente c = contribuenteService.caricaSingoloContribuente(idTemp);
		ContribuenteDTO c1= ContribuenteDTO.buildContribuenteDTOFromContribuente(c);
		request.setAttribute("contribuenteDaModificare", c1);

		RequestDispatcher rd = request.getRequestDispatcher("/contribuente/modificaContribuente.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
