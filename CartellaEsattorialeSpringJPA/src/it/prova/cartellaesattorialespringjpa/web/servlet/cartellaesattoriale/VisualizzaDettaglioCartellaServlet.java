package it.prova.cartellaesattorialespringjpa.web.servlet.cartellaesattoriale;

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

import it.prova.cartellaesattorialespringjpa.model.dto.CartellaEsattorialeDTO;
import it.prova.cartellaesattorialespringjpa.service.cartellaesattoriale.CartellaEsattorialeService;
import it.prova.cartellaesattorialespringjpa.service.contribuente.ContribuenteService;

/**
 * Servlet implementation class VisualizzaDettaglioCartellaServlet
 */
@WebServlet("/VisualizzaDettaglioCartellaServlet")
public class VisualizzaDettaglioCartellaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CartellaEsattorialeService cartellaEsattorialeService;
	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public VisualizzaDettaglioCartellaServlet() {
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
		String idCartellaDaPagina = request.getParameter("idCartella");
		CartellaEsattorialeDTO temp= CartellaEsattorialeDTO.buildDTOFromCartellaEsattoriale(cartellaEsattorialeService.caricaSingolaCartella(Long.parseLong(idCartellaDaPagina)));
		request.setAttribute("contribuente", contribuenteService.caricaSingoloContribuente(temp.getIdContribuente()));
		request.setAttribute("cartellaSingola", temp);

		RequestDispatcher rd = request.getRequestDispatcher("/cartellaEsattoriale/dettaglioSingolaCartella.jsp");
		rd.forward(request, response);
	}
}