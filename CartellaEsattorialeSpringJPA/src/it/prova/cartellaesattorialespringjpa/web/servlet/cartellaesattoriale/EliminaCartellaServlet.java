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
import it.prova.cartellaesattorialespringjpa.service.cartellaesattoriale.CartellaEsattorialeService;
import it.prova.cartellaesattorialespringjpa.service.contribuente.ContribuenteService;

/**
 * Servlet implementation class EliminaCartellaServlet
 */
@WebServlet("/EliminaCartellaServlet")
public class EliminaCartellaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CartellaEsattorialeService cartellaEsattorialeService;
	@Autowired
	private ContribuenteService contribuenteService;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	} 
    public EliminaCartellaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// controllo utente in sessione (va fatto in tutte le servlet)
				if (request.getSession().getAttribute("userInfo") == null) {
					response.sendRedirect(request.getContextPath());
					return;
				}

				String destinazione = null;

				Long idPagina = Long.parseLong((String) request.getParameter("idCartella"));
				CartellaEsattoriale c1=cartellaEsattorialeService.caricaSingolaCartella(idPagina);

				cartellaEsattorialeService.rimuovi(c1);
				request.setAttribute("listaCartelle", cartellaEsattorialeService.listAll());
				destinazione = "/cartellaEsattoriale/result.jsp";

				RequestDispatcher rd = request.getRequestDispatcher(destinazione);
				rd.forward(request, response);
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
