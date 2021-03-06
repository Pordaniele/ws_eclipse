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
import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;

/**
 * Servlet implementation class SearchAbitanteServlet
 */
@WebServlet("/SearchAbitanteServlet")
public class SearchAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AbitanteService abitanteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public SearchAbitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//controllo utente in sessione (va fatto in tutte le servlet)
		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		int etaInput= 0;
		try {
			etaInput = Integer.parseInt((String) request.getParameter("etaInput"));
		} catch (NumberFormatException e) {
			etaInput = -1;
		}
		
String nomeInput = request.getParameter("nomeInput");
String cognomeInput = request.getParameter("cognomeInput");

String residenzaInput=request.getParameter("residenzaInput");
if (etaInput==-1) {
	Abitante example = new Abitante();
	example.setCognome(cognomeInput);
	example.setNome(nomeInput);
	example.setResidenza(residenzaInput);
	request.setAttribute("listaAbitanteAttributeName", abitanteService.findByExample(example));
}else {
Abitante example = new Abitante(nomeInput, cognomeInput, etaInput, residenzaInput);

request.setAttribute("listaAbitanteAttributeName", abitanteService.findByExample(example));
}
RequestDispatcher rd = request.getRequestDispatcher("/abitante/result.jsp");
rd.forward(request, response);
}
}
