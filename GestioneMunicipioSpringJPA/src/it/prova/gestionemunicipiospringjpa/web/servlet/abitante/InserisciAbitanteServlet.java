package it.prova.gestionemunicipiospringjpa.web.servlet.abitante;

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

import it.prova.gestionemunicipiospringjpa.model.Abitante;
import it.prova.gestionemunicipiospringjpa.model.Municipio;
import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;
import it.prova.gestionemunicipiospringjpa.service.municipio.MunicipioService;

@WebServlet("/InserisciAbitanteServlet")
public class InserisciAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AbitanteService abitanteService;
	@Autowired
	private MunicipioService municipioService;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public InserisciAbitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//controllo utente in sessione (va fatto in tutte le servlet)
		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;}
			
		String destinazione = null;
			int etaInput = 0;
			Long idInput=0L;
			try {
				idInput= Long.parseLong((String) request.getParameter("municipioInput"));
				etaInput = Integer.parseInt((String) request.getParameter("etaInput"));
			} catch (NumberFormatException e) {
				etaInput = -1;
			}
			Municipio m1= new Municipio();
			m1.setId(idInput);
			String nomeDaPagina = request.getParameter("nomeInput");
			String cognomeDaPagina = request.getParameter("cognomeInput");
			String residenzaDaPagina = request.getParameter("residenzaInput");
			

			if (nomeDaPagina.equals("") || cognomeDaPagina.equals("") || residenzaDaPagina.equals("") || etaInput<=0|| idInput<=0) {
				String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare.";
				request.setAttribute("listaMunicipioAttributeName", municipioService.listAllMunicipi());
				request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);

				destinazione = "/abitante/inserisciAbitante.jsp";
			} else {
				try {
					Abitante a1 = new Abitante(nomeDaPagina, cognomeDaPagina, etaInput, residenzaDaPagina);
					a1.setMunicipio(m1);
					abitanteService.inserisciNuovo(a1);
					request.setAttribute("listaAbitanteAttributeName", abitanteService.listAllAbitanti());
					destinazione = "/abitante/result.jsp";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
		}
}


