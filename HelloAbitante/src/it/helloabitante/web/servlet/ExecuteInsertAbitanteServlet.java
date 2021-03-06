package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteInsertAbitanteServlet
 */
@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertAbitanteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String destinazione = null;
		int etaTemp = 0;
		try {
			etaTemp = Integer.parseInt((String) request.getParameter("etaInput"));
		} catch (NumberFormatException e) {
			etaTemp = -1;
		}
		String nomeDaPagina = request.getParameter("nomeInput");
		String cognomeDaPagina = request.getParameter("cognomeInput");
		String codiceFiscaleDaPagina = request.getParameter("codicefiscaleInput");
		// String etaDaPagina=request.getParameter("etaInput");
		String mottodivitaInput = request.getParameter("mottodivitaInput");

		if (nomeDaPagina.equals("") || cognomeDaPagina.equals("") || codiceFiscaleDaPagina.contentEquals("")
				|| etaTemp <= 0) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			destinazione = "nuovoAbitante.jsp";
		} else {
			try {
				Abitante a1 = new Abitante(nomeDaPagina, cognomeDaPagina, codiceFiscaleDaPagina, etaTemp,
						mottodivitaInput);
				MyServiceFactory.getAbitanteServiceInstance().inserisciNuovoAbitante(a1);
				request.setAttribute("listAbitantiAttributeName", MyServiceFactory.getAbitanteServiceInstance().list());
				destinazione = "results.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}
}
