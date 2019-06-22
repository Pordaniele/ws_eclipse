package it.prova.ebayjpa.web.servlet.categorie;

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

import it.prova.ebayjpa.dto.CategoriaDTO;
import it.prova.ebayjpa.model.Categoria;
import it.prova.ebayjpa.service.annuncio.AnnuncioService;
import it.prova.ebayjpa.service.categoria.CategoriaService;
import it.prova.ebayjpa.service.utente.UtenteService;

/**
 * Servlet implementation class ExecuteInserisciCategoriaServlet
 */
@WebServlet("/admin/ExecuteInserisciCategoriaServlet")
public class ExecuteInserisciCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CategoriaService categoriaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteInserisciCategoriaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;
		String descrizioneDaPagina = request.getParameter("descrizioneInput");
		String codiceDaPagina = request.getParameter("codiceInput");
		CategoriaDTO categoriaDTO = new CategoriaDTO(descrizioneDaPagina, codiceDaPagina);
		if (!categoriaDTO.validate().isEmpty()) {
			request.setAttribute("messaggioDiErrore", categoriaDTO.validate());
			destinazione = "/admin/categorie/inserisciCategoria.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
			return;
		}
		for (Categoria item : categoriaService.list()) {
			if (categoriaDTO.getCodice().equals(item.getCodice())) {
				request.setAttribute("messaggioDiErrore", "esiste gia una categoria con questo codice");
				destinazione = "/admin/categorie/inserisciCategoria.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(destinazione);
				rd.forward(request, response);
				return;
			}

		}
		Categoria cat1 = CategoriaDTO.buildCategoriaFromDTO(categoriaDTO);
		categoriaService.insert(cat1);
		request.setAttribute("listaCategorie", categoriaService.list());
		destinazione = "/admin/categorie/risultatoRicercaCategorie.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
