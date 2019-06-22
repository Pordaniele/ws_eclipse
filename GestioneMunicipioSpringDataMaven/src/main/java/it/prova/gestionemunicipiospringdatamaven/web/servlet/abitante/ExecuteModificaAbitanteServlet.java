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
import it.prova.gestionemunicipiospringdatamaven.dto.MunicipioDTO;
import it.prova.gestionemunicipiospringdatamaven.model.Abitante;
import it.prova.gestionemunicipiospringdatamaven.model.Municipio;
import it.prova.gestionemunicipiospringdatamaven.service.abitante.AbitanteService;
import it.prova.gestionemunicipiospringdatamaven.service.municipio.MunicipioService;

/**
 * Servlet implementation class ExecuteModificaAbitanteServlet
 */
@WebServlet("/abitante/ExecuteModificaAbitanteServlet")
public class ExecuteModificaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MunicipioService municipioService;
	@Autowired
	private AbitanteService abitanteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public ExecuteModificaAbitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idInput = Long.parseLong((String) request.getParameter("idInput"));
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		String residenzaInput = request.getParameter("residenzaInput");
		Long municipioId=null;
		Integer etaInput = null;
		
		
		
		try {
			
		
			etaInput = Integer.parseInt((String) request.getParameter("etaInput"));
} catch (NumberFormatException e) {
			
		}
		
		try {
			
			municipioId = Long.parseLong((String) request.getParameter("municipioId"));
		} catch (NumberFormatException e) {
			
		}
		 
			
	
		
		System.out.println(etaInput);
		AbitanteDTO abitanteDTO = new AbitanteDTO(nomeInput, cognomeInput, etaInput, residenzaInput);
		abitanteDTO.setMunicipio(municipioId);
		if (!abitanteDTO.validate().isEmpty()) {
			request.setAttribute("messaggioDiErrore", abitanteDTO.validate());
			
			request.setAttribute("abitanteDaModificare", abitanteService.caricaEager(idInput));
			RequestDispatcher rd = request.getRequestDispatcher("/abitante/modificaAbitante.jsp");
			rd.forward(request, response);
			return;
		}
		Abitante abitanteModifica= AbitanteDTO.buildAbitanteFromDTO(abitanteDTO);
		Municipio temp= municipioService.caricaEager(municipioId);
		abitanteModifica.setMunicipio(temp);
		abitanteModifica.setId(idInput);
		abitanteService.aggiorna(abitanteModifica);
		request.setAttribute("listaAbitanti", abitanteService.listAllAbitanti());
		RequestDispatcher rd = request.getRequestDispatcher("/abitante/results.jsp");
		rd.forward(request, response);
	}

}
