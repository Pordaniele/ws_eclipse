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
 * Servlet implementation class SearchContribuenteServlet
 */
@WebServlet("/SearchContribuenteServlet")
public class SearchContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public SearchContribuenteServlet() {
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

		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		String codiceFiscaleInput = request.getParameter("codiceFiscaleInput");
		String indirizzoInput = request.getParameter("indirizzoInput");
		ContribuenteDTO c1 = new ContribuenteDTO(nomeInput, cognomeInput, codiceFiscaleInput, indirizzoInput);
		Contribuente example = ContribuenteDTO.buildContribuenteFromDTO(c1);
		request.setAttribute("listaContribuenteAttribute", contribuenteService.findByExample(example));

		RequestDispatcher rd = request.getRequestDispatcher("/contribuente/result.jsp");
		rd.forward(request, response);
	}
}
