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
import it.prova.ebayjpa.service.ruolo.RuoloService;
import it.prova.ebayjpa.service.utente.UtenteService;


@WebServlet("/admin/ExecuteSearchCategorieServlet")
public class ExecuteSearchCategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private CategoriaService categoriaService;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    public ExecuteSearchCategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descrizioneDaInput= request.getParameter("descrizioneInput");
		Categoria example= new Categoria();
		example.setDescrizione(descrizioneDaInput);
		request.setAttribute("listaCategorie", categoriaService.findByExample(example));
		

		RequestDispatcher rd = request.getRequestDispatcher("/admin/categorie/risultatoRicercaCategorie.jsp");
		rd.forward(request, response);
	}
}
