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

/**
 * Servlet implementation class SearchCartellaServlet
 */
@WebServlet("/SearchCartellaServlet")
public class SearchCartellaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CartellaEsattorialeService cartellaEsattorialeService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public SearchCartellaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// controllo utente in sessione (va fatto in tutte le servlet)
		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		String denominazioneInput = request.getParameter("denominazioneInput");

		CartellaEsattorialeDTO cartella = new CartellaEsattorialeDTO();
		cartella.setDenominazione(denominazioneInput);
		int importoInput = 0;

		try {

			importoInput = Integer.parseInt((request.getParameter("importoInput")));
		} catch (NumberFormatException e) {
			importoInput = -1;
		}
		if (importoInput >= 0)
			cartella.setImporto(importoInput);
		CartellaEsattoriale example = CartellaEsattorialeDTO.buildCartellaFromDTO(cartella);
		request.setAttribute("listaCartelle", cartellaEsattorialeService.findByExample(example));

		RequestDispatcher rd = request.getRequestDispatcher("/cartellaEsattoriale/result.jsp");
		rd.forward(request, response);
	}

}
