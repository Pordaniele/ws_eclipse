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

import it.prova.ebayjpa.model.Categoria;
import it.prova.ebayjpa.service.categoria.CategoriaService;
import it.prova.ebayjpa.service.utente.UtenteService;

@WebServlet("/admin/PrepareEliminaCategoriaServlet")
public class PrepareEliminaCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private UtenteService utenteService;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public PrepareEliminaCategoriaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idTemp = Long.parseLong((String) request.getParameter("idCategoria"));
		Categoria c1 = categoriaService.caricaEager(idTemp);
		
		
		request.setAttribute("categoriaDaEliminare", c1);
		request.setAttribute("listaAnnunci", c1.getAnnunci());
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/categorie/eliminaCategorie.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
