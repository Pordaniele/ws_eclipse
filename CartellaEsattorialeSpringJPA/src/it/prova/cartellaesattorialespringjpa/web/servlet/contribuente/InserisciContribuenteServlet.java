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

/**
 * Servlet implementation class InserisciContribuenteServlet
 */
@WebServlet("/InserisciContribuenteServlet")
public class InserisciContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	public ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public InserisciContribuenteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// controllo utente in sessione (va fatto in tutte le servlet)
		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		String destinazione = null;
		ContribuenteDTO contribuenteDTOInstance = new ContribuenteDTO();
		contribuenteDTOInstance.setNome(request.getParameter("nomeInput"));
		contribuenteDTOInstance.setCognome(request.getParameter("cognomeInput"));
		contribuenteDTOInstance.setIndirizzo(request.getParameter("indirizzoInput"));
		contribuenteDTOInstance.setCodiceFiscale(request.getParameter("codiceFiscaleInput"));

		if (!contribuenteDTOInstance.validate().isEmpty()) {
			request.setAttribute("messaggioDiErrore", contribuenteDTOInstance.validate());
			destinazione = "/contribuente/inserisciContribuente.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
			return;
		}

		Contribuente contribuenteNuovoDaInserire = ContribuenteDTO.buildContribuenteFromDTO(contribuenteDTOInstance);
		contribuenteService.inserisciNuovo(contribuenteNuovoDaInserire);
		request.setAttribute("listaContribuenteAttribute", contribuenteService.listAll());
		destinazione = "/contribuente/result.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
