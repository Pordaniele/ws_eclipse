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


@WebServlet("/InserisciMunicipioServlet")
public class InserisciMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public InserisciMunicipioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//controllo utente in sessione (va fatto in tutte le servlet)
				if(request.getSession().getAttribute("userInfo") == null) {
					response.sendRedirect(request.getContextPath());
					return;}
					String destinazione = null;
					
					String descrizioneDaPagina = request.getParameter("descrizioneInput");
					String codiceDaPagina = request.getParameter("codiceInput");
					String ubicazioneDaPagina = request.getParameter("ubicazioneInput");
					

					if (descrizioneDaPagina.equals("") || codiceDaPagina.equals("") || ubicazioneDaPagina.equals("")) {
						String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare.";
						request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);

						destinazione = "/municipio/inserisciMunicipio.jsp";
					} else {
						try {
							Municipio p1 = new Municipio(descrizioneDaPagina, codiceDaPagina, ubicazioneDaPagina);
							municipioService.inserisciNuovo(p1);
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

	

