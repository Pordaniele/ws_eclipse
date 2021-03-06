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
import it.prova.cartellaesattorialespringjpa.model.dto.CartellaEsattorialeDTO;
import it.prova.cartellaesattorialespringjpa.service.cartellaesattoriale.CartellaEsattorialeService;
import it.prova.cartellaesattorialespringjpa.service.contribuente.ContribuenteService;

@WebServlet("/ModificaCartellaServlet")
public class ModificaCartellaServlet extends HttpServlet {
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

	public ModificaCartellaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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

			idInput = Long.parseLong((String) request.getParameter("idInput"));
			importoInput = Integer.parseInt((String) request.getParameter("importoInput"));
		} catch (NumberFormatException e) {
			importoInput = -1;
		}

		String denominazioneDaPagina = request.getParameter("denominazioneInput");

		Long idContribuenteInput = Long.parseLong((String) request.getParameter("contribuenteInput"));
		CartellaEsattorialeDTO cartellaDTO= new CartellaEsattorialeDTO(denominazioneDaPagina, importoInput);
		cartellaDTO.setId(idInput);
		cartellaDTO.setIdContribuente(idContribuenteInput);
		if (!cartellaDTO.validate().isEmpty()) {
			
			request.setAttribute("messaggioDiErrore", cartellaDTO.validate());
			CartellaEsattoriale c = cartellaEsattorialeService.caricaSingolaCartella(idInput);
			request.setAttribute("cartellaDaModificare", c);
			request.setAttribute("listaContribuenti", contribuenteService.listAll());
			destinazione = "/cartellaEsattoriale/modificaCartella.jsp";
		} else {
			try {
				CartellaEsattoriale c1 =CartellaEsattorialeDTO.buildCartellaFromDTO(cartellaDTO);
				c1.setId(idInput);
				c1.setContribuente(contribuenteService.caricaSingoloContribuente(idContribuenteInput));
				cartellaEsattorialeService.aggiorna(c1);
				request.setAttribute("listaCartelle", cartellaEsattorialeService.listAll());
				destinazione = "/cartellaEsattoriale/result.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
