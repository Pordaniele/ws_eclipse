package it.prova.ebayjpa.web.servlet.categorie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.ebayjpa.model.Annuncio;
import it.prova.ebayjpa.model.Categoria;
import it.prova.ebayjpa.service.annuncio.AnnuncioService;
import it.prova.ebayjpa.service.categoria.CategoriaService;

/**
 * Servlet implementation class ExecuteEliminaCategoriaServlet
 */
@WebServlet("/admin/ExecuteEliminaCategoriaServlet")
public class ExecuteEliminaCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private AnnuncioService annuncioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteEliminaCategoriaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long idPagina = Long.parseLong((String) request.getParameter("idCategoria"));
		Categoria c1 = categoriaService.caricaEager(idPagina);
		Annuncio annuncioTemp = new Annuncio();
//		List<Annuncio> listaAnnunciTemp = new ArrayList<>();
		List<String> erroreAnnuncio = new ArrayList<>();
//		listaAnnunciTemp = annuncioService.cercaAnnuncioPerCategoria(c1);
		for (Annuncio itemAnnuncio : c1.getAnnunci()) {
			annuncioTemp = annuncioService.caricaEager(itemAnnuncio.getId());
			if (annuncioTemp.getCategorie().size() <= 1) {
				erroreAnnuncio.add(annuncioTemp.getTestoAnnuncio() + " " + annuncioTemp.getId());
			}
		}
		if (erroreAnnuncio.size() >= 1) {
			erroreAnnuncio.add(
					"i seguenti annunci hanno solo questa categoria, provvedere ad assegnarne una nuova prima dell'eliminazione");
			request.setAttribute("messaggioDiErrore", erroreAnnuncio);

			request.setAttribute("listaCategorie", categoriaService.list());

			RequestDispatcher rd = request.getRequestDispatcher("/admin/categorie/risultatoRicercaCategorie.jsp");
			rd.forward(request, response);
			return;
		} else {
			categoriaService.delete(c1);
			request.setAttribute("listaCategorie", categoriaService.list());

			RequestDispatcher rd = request.getRequestDispatcher("/admin/categorie/risultatoRicercaCategorie.jsp");
			rd.forward(request, response);
		}
	}

}
