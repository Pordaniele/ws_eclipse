package it.prova.gestionemunicipiospringdatamaven.web.servlet.municipio;

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

import it.prova.gestionemunicipiospringdatamaven.dto.MunicipioDTO;
import it.prova.gestionemunicipiospringdatamaven.model.Municipio;
import it.prova.gestionemunicipiospringdatamaven.service.municipio.MunicipioService;

/**
 * Servlet implementation class ExecuteModificaMunicipioServlet
 */
@WebServlet("/municipio/ExecuteModificaMunicipioServlet")
public class ExecuteModificaMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	} 
    public ExecuteModificaMunicipioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idInput = Long.parseLong((String) request.getParameter("idInput"));
		String descrizioneDaPagina = request.getParameter("descrizioneInput");
		String codiceDaPagina = request.getParameter("codiceInput");
		String ubicazioneDaPagina = request.getParameter("ubicazioneInput");
		MunicipioDTO municipioDTO= new MunicipioDTO(descrizioneDaPagina, codiceDaPagina, ubicazioneDaPagina);
		if(!municipioDTO.validate().isEmpty()) {
			request.setAttribute("messaggioDiErrore", municipioDTO.validate());
			Municipio muniDaModificare = municipioService.caricaSingoloMunicipio(idInput);
			request.setAttribute("municipioDaModificare", muniDaModificare);
			RequestDispatcher rd = request.getRequestDispatcher("/municipio/modificaMunicipio.jsp");
			rd.forward(request, response);
			return;
		}
		Municipio municipioInsert= municipioDTO.buildMunicipioFromDTO(municipioDTO);
		Municipio temp= municipioService.caricaEager(idInput);
		municipioInsert.setAbitanti(temp.getAbitanti());
		municipioInsert.setId(idInput);
		municipioService.aggiorna(municipioInsert);
		request.setAttribute("listaMunicipi", municipioService.listAllMunicipi());
		RequestDispatcher rd = request.getRequestDispatcher("/municipio/results.jsp");
		rd.forward(request, response);
		
	}

}
