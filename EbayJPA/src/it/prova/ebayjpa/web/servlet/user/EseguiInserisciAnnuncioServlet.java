package it.prova.ebayjpa.web.servlet.user;

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

import it.prova.ebayjpa.dto.AnnuncioDTO;
import it.prova.ebayjpa.model.Annuncio;
import it.prova.ebayjpa.service.annuncio.AnnuncioService;
import it.prova.ebayjpa.service.categoria.CategoriaService;
import it.prova.ebayjpa.service.utente.UtenteService;

/**
 * Servlet implementation class EseguiInserisciAnnuncioServlet
 */
@WebServlet("/EseguiInserisciAnnuncioServlet")
public class EseguiInserisciAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AnnuncioService annuncioService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public EseguiInserisciAnnuncioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;
		Long idUtente = 0L;
		double prezzoInput = 0;
		try {
			idUtente = Long.parseLong((String) request.getParameter("userIdList"));

			prezzoInput = Double.parseDouble((String) request.getParameter("prezzoInput"));
		} catch (NumberFormatException e) {
			prezzoInput = -1;
		}
		String testoDaPagina = request.getParameter("testoAnnuncioInput");
		AnnuncioDTO annuncioDTO = new AnnuncioDTO();
		annuncioDTO.setPrezzo(prezzoInput);
		annuncioDTO.setTestoAnnuncio(testoDaPagina);
		String[] categorie = request.getParameterValues("categoriaId");
		if (!annuncioDTO.validate().isEmpty() || !(categorie != null && categorie.length > 0)) {

			request.setAttribute("messaggioDiErrore", annuncioDTO.validate());

			request.setAttribute("listaCategorie", categoriaService.list());
			destinazione = "/user/inserisciAnnuncio.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
			return;
		}
		Annuncio c1 = AnnuncioDTO.buildAnnuncioFromDto(annuncioDTO);
		Date data = new Date();
		c1.setDataAnnuncio(data);
		c1.setApertoChiuso(true);
		c1.setUtente(utenteService.caricaEager(idUtente));
		if (categorie != null && categorie.length > 0) {
			for (int i = 0; i < categorie.length; i++) {
				c1.getCategorie().add(categoriaService.get(Long.parseLong(categorie[i])));
			}
		}
		annuncioService.insert(c1);
		request.setAttribute("listaAnnunci", annuncioService.list());
		destinazione = "/result.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
