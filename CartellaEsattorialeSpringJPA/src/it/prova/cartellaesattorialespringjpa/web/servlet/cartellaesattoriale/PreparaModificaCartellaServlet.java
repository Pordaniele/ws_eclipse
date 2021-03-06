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

@WebServlet("/PreparaModificaCartellaServlet")
public class PreparaModificaCartellaServlet extends HttpServlet {
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

	public PreparaModificaCartellaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idTemp = Long.parseLong((String) request.getParameter("idCartella"));
		CartellaEsattoriale c1 = cartellaEsattorialeService.caricaSingolaCartella(idTemp);
		
		request.setAttribute("cartellaDaModificare", c1);
		request.setAttribute("listaContribuenti", contribuenteService.listAll());
		RequestDispatcher rd = request.getRequestDispatcher("/cartellaEsattoriale/modificaCartella.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
