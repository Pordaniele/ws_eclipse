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

import it.prova.model.Persona;
import it.prova.service.PersonaService;

/**
 * Servlet implementation class ModificaPersonaServlet
 */
@WebServlet("/ModificaPersonaServlet")
public class ModificaPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
		@Autowired
		private PersonaService personaService;
		
		@Override
		public void init(ServletConfig config) throws ServletException{
			super.init(config);
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		}
    public ModificaPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String destinazione = null;
		int etaTemp = 0;
		try {
			etaTemp = Integer.parseInt((String) request.getParameter("etaInput"));
		} catch (NumberFormatException e) {
			etaTemp = -1;
		}
		String nomeDaPagina = request.getParameter("nomeInput");
		String cognomeDaPagina = request.getParameter("cognomeInput");
		String codiceFiscaleDaPagina = request.getParameter("cfInput");
		String indirizzoDaPagina = request.getParameter("indirizzoInput");
		
		Long idPagina =Long.parseLong((String)request.getParameter("idPersona"));

		if (nomeDaPagina.equals("") || cognomeDaPagina.equals("") ||indirizzoDaPagina.equals("") || codiceFiscaleDaPagina.contentEquals("")
				|| etaTemp <= 0) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			Persona c= personaService.caricaSingolaPersona(idPagina);
			request.setAttribute("personaDaModificare",c);
			destinazione = "modificaPersona.jsp";
		} else {
			try {
				Persona p1 = new Persona(nomeDaPagina, cognomeDaPagina, codiceFiscaleDaPagina, indirizzoDaPagina, etaTemp, idPagina);
				personaService.aggiorna(p1);
				request.setAttribute("listaPersoneAttributeName", personaService.list());
				destinazione = "result.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}
}