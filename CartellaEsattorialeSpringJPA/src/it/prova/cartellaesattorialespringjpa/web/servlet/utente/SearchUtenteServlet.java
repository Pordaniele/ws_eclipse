package it.prova.cartellaesattorialespringjpa.web.servlet.utente;

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

import it.prova.cartellaesattorialespringjpa.model.Utente;
import it.prova.cartellaesattorialespringjpa.service.utente.UtenteService;

/**
 * Servlet implementation class SearchUtenteServlet
 */
@WebServlet("/admin/SearchUtenteServlet")
public class SearchUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public SearchUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
	
		Utente example = new Utente();
		example.setNome(nomeInput);
		example.setCognome(cognomeInput);
		
		request.setAttribute("listaUtentiAttribute", utenteService.findByExample(example));

		RequestDispatcher rd = request.getRequestDispatcher("/admin/result.jsp");
		rd.forward(request, response);
	}
}


