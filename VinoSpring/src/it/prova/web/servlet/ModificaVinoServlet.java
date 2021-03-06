package it.prova.web.servlet;

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

import it.prova.model.Vino;
import it.prova.service.VinoService;

/**
 * Servlet implementation class ModificaVinoServlet
 */
@WebServlet("/ModificaVinoServlet")
public class ModificaVinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private VinoService vinoService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ModificaVinoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;
		int annataTemp = 0;
		try {
			annataTemp = Integer.parseInt((String) request.getParameter("annataInput"));
		} catch (NumberFormatException e) {
			annataTemp = -1;
		}
		String nomeDaPagina = request.getParameter("nomeInput");
		String cantinaDaPagina = request.getParameter("cantinaInput");
		String localitaDaPagina = request.getParameter("localitaInput");
		String uvaDaPagina = request.getParameter("uvaInput");

		Long idPagina = Long.parseLong((String) request.getParameter("idVino"));

		if (nomeDaPagina.equals("") || cantinaDaPagina.equals("") || localitaDaPagina.equals("")
				|| uvaDaPagina.contentEquals("") || annataTemp <= 0) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			Vino c = vinoService.get(idPagina);
			request.setAttribute("vinoDaModificare", c);
			destinazione = "modificaVino.jsp";
		} else {
			try {
				Vino p1 = new Vino(idPagina, nomeDaPagina, cantinaDaPagina, annataTemp, localitaDaPagina, uvaDaPagina);
				vinoService.update(p1);
				request.setAttribute("listaVinoAttributeName", vinoService.list());
				destinazione = "result.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}
}
