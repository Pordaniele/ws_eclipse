package it.prova.gestionemunicipiospringjpa.web.servlet.municipio;

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

import it.prova.gestionemunicipiospringjpa.model.Municipio;
import it.prova.gestionemunicipiospringjpa.service.municipio.MunicipioService;

/**
 * Servlet implementation class ModificaMunicipioServlet
 */
@WebServlet("/ModificaMunicipioServlet")
public class ModificaMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public ModificaMunicipioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// controllo utente in sessione (va fatto in tutte le servlet)
		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}String destinazione = null;
		
		
		String descrizioneDaPagina = request.getParameter("descrizioneInput");
		String ubicazioneDaPagina = request.getParameter("ubicazioneInput");
		String codiceDaPagina = request.getParameter("codiceInput");
		

		Long idPagina = Long.parseLong((String) request.getParameter("idMunicipio"));

		if (descrizioneDaPagina.equals("") || ubicazioneDaPagina.equals("") || codiceDaPagina.equals("")) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			Municipio c = municipioService.caricaSingoloMunicipio(idPagina);
			request.setAttribute("MunicipioDaModificare", c);
			destinazione = "/municipio/modificaMunicipio.jsp";
		} else {
			try {
				Municipio p1 = new Municipio(descrizioneDaPagina, codiceDaPagina, ubicazioneDaPagina);
				p1.setId(idPagina);
				municipioService.aggiorna(p1);
				request.setAttribute("listaMunicipioAttributeName", municipioService.listAllMunicipi());
				destinazione = "/municipio/result.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}
	

}
