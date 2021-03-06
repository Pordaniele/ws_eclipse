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

import it.prova.cartellaesattorialespringjpa.model.CartellaEsattoriale;
import it.prova.cartellaesattorialespringjpa.model.Contribuente;
import it.prova.cartellaesattorialespringjpa.model.dto.CartellaEsattorialeDTO;
import it.prova.cartellaesattorialespringjpa.service.cartellaesattoriale.CartellaEsattorialeService;
import it.prova.cartellaesattorialespringjpa.service.contribuente.ContribuenteService;

@WebServlet("/InserisciCartellaServlet")
public class InserisciCartellaServlet extends HttpServlet {
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

	public InserisciCartellaServlet() {
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
		int importoInput = 0;
		Long idInput = 0L;
		try {
			idInput = Long.parseLong((String) request.getParameter("contribuenteInput"));
			importoInput = Integer.parseInt((String) request.getParameter("importoInput"));
		} catch (NumberFormatException e) {
			importoInput = -1;
		}
		Contribuente contribuente1 = new Contribuente();
		contribuente1.setId(idInput);
		String denominazioneDaPagina = request.getParameter("denominazioneInput");
		CartellaEsattorialeDTO cartellaDTO = new CartellaEsattorialeDTO(denominazioneDaPagina, importoInput);
		cartellaDTO.setIdContribuente(idInput);
		if (!cartellaDTO.validate().isEmpty()) {

			request.setAttribute("listaContribuentiAttribute", contribuenteService.listAll());
			request.setAttribute("messaggioDiErrore", cartellaDTO.validate());

			destinazione = "/cartellaEsattoriale/inserisciCartella.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
			return;
		}

		CartellaEsattoriale cartella1 = CartellaEsattorialeDTO.buildCartellaFromDTO(cartellaDTO);
		cartella1.setContribuente(contribuente1);
		cartellaEsattorialeService.inserisciNuovo(cartella1);
		request.setAttribute("listaCartelle", cartellaEsattorialeService.listAll());
		destinazione = "/cartellaEsattoriale/result.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}
}