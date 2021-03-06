package it.prova.cartellaesattorialespringjpa.web.servlet.contribuente;

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

import it.prova.cartellaesattorialespringjpa.model.Contribuente;
import it.prova.cartellaesattorialespringjpa.model.dto.ContribuenteDTO;
import it.prova.cartellaesattorialespringjpa.service.contribuente.ContribuenteService;


@WebServlet("/ModificaContribuenteServlet")
public class ModificaContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ContribuenteService contribuenteService;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public ModificaContribuenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("khkhghgjhgjhg").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// controllo utente in sessione (va fatto in tutte le servlet)
		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}String destinazione = null;
		ContribuenteDTO contribuenteDTO= new ContribuenteDTO();
		contribuenteDTO.setId( Long.parseLong((String) request.getParameter("idInput")));
		contribuenteDTO.setNome(request.getParameter("nomeInput"));
		contribuenteDTO.setCognome(request.getParameter("cognomeInput"));
		contribuenteDTO.setIndirizzo( request.getParameter("indirizzoInput"));
		contribuenteDTO.setCodiceFiscale( request.getParameter("codiceFiscaleInput"));
		
		if (!contribuenteDTO.validate().isEmpty()) {
			
			request.setAttribute("messaggioDiErrore", contribuenteDTO.validate());
			request.setAttribute("contribuenteDaModificare", contribuenteDTO);
			destinazione = "/contribuente/modificaContribuente.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
			return;
		}
		

		Contribuente contribuenteNuovoDaInserire = ContribuenteDTO.buildContribuenteFromDTO(contribuenteDTO);
				
				
				contribuenteService.aggiorna(contribuenteNuovoDaInserire);
				request.setAttribute("listaContribuenteAttribute", contribuenteService.listAll());
				destinazione = "/contribuente/result.jsp";
		
		
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
