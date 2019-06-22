package it.prova.ebayjpa.web.servlet.admin;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.ebayjpa.dto.UtenteDTO;
import it.prova.ebayjpa.model.Utente;
import it.prova.ebayjpa.service.ruolo.RuoloService;
import it.prova.ebayjpa.service.utente.UtenteService;

@WebServlet("/admin/ExecuteModificaUtenteServlet")
public class ExecuteModificaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private RuoloService ruoloService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteModificaUtenteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;
		Long idInput = 0L;
		idInput = Long.parseLong((String) request.getParameter("idInput"));
		double prezzoInput = 0L;
		try {

			prezzoInput = Double.parseDouble((String) request.getParameter("creditoInput"));
		} catch (NumberFormatException e) {
			prezzoInput = -1;
		}
		String nomeDaPagina = request.getParameter("nomeInput");
		String cognomeDaPagina = request.getParameter("cognomeInput");
		String usernameDaPagina = request.getParameter("usernameInput");
		String passwordDaPagina = request.getParameter("passwordInput");
		Date dataInInput = new Date();
		String[] ruoli = request.getParameterValues("ruoloId");
		UtenteDTO temp = new UtenteDTO(nomeDaPagina, cognomeDaPagina, usernameDaPagina, passwordDaPagina, dataInInput);
		temp.setCreditoResiduo(prezzoInput);

		if (!temp.validate().isEmpty() || !(ruoli != null && ruoli.length > 0)) {
			Utente c = utenteService.caricaEagerAnnunci(idInput);
			request.setAttribute("utenteDaModificare", c);
			request.setAttribute("messaggioDiErrore", temp.validate());
			request.setAttribute("listaRuoli", ruoloService.list());
			RequestDispatcher rd = request.getRequestDispatcher("/admin/modificaUtente.jsp");
			rd.forward(request, response);
			return;
		}

		if (ruoli != null && ruoli.length > 0) {
			for (int i = 0; i < ruoli.length; i++) {
				temp.getRuoli().add(ruoloService.get(Long.parseLong(ruoli[i])));
			}
		}
		for (Utente item : utenteService.listAllUtenti()) {
			if (temp.getId() != item.getId())
				if (temp.getUsername().equals(item.getUsername())) {

					request.setAttribute("messaggioDiErrore", "esiste gia questo username");
					Utente c = utenteService.caricaEagerAnnunci(idInput);
					request.setAttribute("utenteDaModificare", c);
					request.setAttribute("listaRuoli", ruoloService.list());
					RequestDispatcher rd = request.getRequestDispatcher("/admin/modificaUtente.jsp");
					rd.forward(request, response);
					return;
				}
		}
		Utente inserUtente = UtenteDTO.buildUtenteFromDTO(temp);
		inserUtente.setId(idInput);
		Utente utenteTemp = utenteService.caricaEagerAnnunci(idInput);
		inserUtente.setAcquisti(utenteTemp.getAcquisti());
		inserUtente.setDataRegistrazione(utenteTemp.getDataRegistrazione());
		inserUtente.setAnnunci(utenteTemp.getAnnunci());
		utenteService.aggiorna(inserUtente);
		request.setAttribute("listaUtenti", utenteService.listAllUtenti());

		RequestDispatcher rd = request.getRequestDispatcher("/admin/risultatoRicercaUtenti.jsp");
		rd.forward(request, response);
	}

}
