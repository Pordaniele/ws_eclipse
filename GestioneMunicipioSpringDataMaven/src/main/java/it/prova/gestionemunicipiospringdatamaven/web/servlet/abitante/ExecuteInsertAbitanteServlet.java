package it.prova.gestionemunicipiospringdatamaven.web.servlet.abitante;

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

import it.prova.gestionemunicipiospringdatamaven.dto.AbitanteDTO;
import it.prova.gestionemunicipiospringdatamaven.model.Abitante;
import it.prova.gestionemunicipiospringdatamaven.model.Municipio;
import it.prova.gestionemunicipiospringdatamaven.service.abitante.AbitanteService;
import it.prova.gestionemunicipiospringdatamaven.service.municipio.MunicipioService;

@WebServlet("/abitante/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AbitanteService abitanteService;
	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteInsertAbitanteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");

		String residenzaInput = request.getParameter("residenzaInput");
		Long municipioId=null;
		Integer etaInput = null;
		try {
			etaInput = Integer.parseInt((String) request.getParameter("etaInput"));
			municipioId = Long.parseLong((String) request.getParameter("municipioId"));
		} catch (NumberFormatException e) {
			
		}
		try {
			
			municipioId = Long.parseLong((String) request.getParameter("municipioId"));
		} catch (NumberFormatException e) {
			
		}
		AbitanteDTO abitanteDTO = new AbitanteDTO(nomeInput, cognomeInput, etaInput, residenzaInput);
		if (!abitanteDTO.validate().isEmpty()) {
			request.setAttribute("messaggioDiErrore", abitanteDTO.validate());

			RequestDispatcher rd = request.getRequestDispatcher("/abitante/inserisciNuovo.jsp");
			rd.forward(request, response);
			return;
		}
		Abitante insertAbitante = AbitanteDTO.buildAbitanteFromDTO(abitanteDTO);
		Municipio temp = municipioService.caricaSingoloMunicipio(municipioId);
		insertAbitante.setMunicipio(temp);
		abitanteService.inserisciNuovo(insertAbitante);
		request.setAttribute("listaAbitanti", abitanteService.listAllAbitanti());

		RequestDispatcher rd = request.getRequestDispatcher("/abitante/results.jsp");
		rd.forward(request, response);
	}
//		response.getWriter().append("Parametri =====>>> ").append("\nnomeInput: " + nomeInput)
//				.append("\ncognomeInput: " + cognomeInput).append("\netaInput: " + etaInput)
//				.append("\nresidenzaInput: " + residenzaInput).append("\nmunicipioId: " + municipioId);

}
