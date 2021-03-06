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
 * Servlet implementation class InserisciVinoServlet
 */
@WebServlet("/InserisciVinoServlet")
public class InserisciVinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private VinoService vinoService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public InserisciVinoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at:InserisciVinoServlet  ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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

		if (nomeDaPagina.equals("") || cantinaDaPagina.equals("") || localitaDaPagina.equals("")
				|| uvaDaPagina.contentEquals("") || annataTemp <= 0) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);

			destinazione = "inserisciVino.jsp";
		} else {
			try {
				Vino p1 = new Vino(nomeDaPagina, cantinaDaPagina, annataTemp, localitaDaPagina, uvaDaPagina);
				vinoService.insert(p1);
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
