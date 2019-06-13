package it.prova.ebayjpa.web.servlet.user;

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

import it.prova.ebayjpa.dto.AnnuncioDTO;
import it.prova.ebayjpa.model.Annuncio;
import it.prova.ebayjpa.service.annuncio.AnnuncioService;
import it.prova.ebayjpa.service.categoria.CategoriaService;

/**
 * Servlet implementation class PreparaModificaAnnuncioServlet
 */
@WebServlet("/PreparaModificaAnnuncioServlet")
public class PreparaModificaAnnuncioServlet extends HttpServlet {
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
    
    public PreparaModificaAnnuncioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idTemp = Long.parseLong((String) request.getParameter("idAnnuncio"));
		Annuncio c1 = annuncioService.caricaEager(idTemp);
		
		
		request.setAttribute("annuncioDaModificare", c1);
		request.setAttribute("listaCategorie", categoriaService.list());
		RequestDispatcher rd = request.getRequestDispatcher("/user/modificaAnnuncio.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
