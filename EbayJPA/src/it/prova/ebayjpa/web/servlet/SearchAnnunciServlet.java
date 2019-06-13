package it.prova.ebayjpa.web.servlet;

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

import it.prova.ebayjpa.dto.AnnuncioDTO;
import it.prova.ebayjpa.model.Annuncio;
import it.prova.ebayjpa.model.Categoria;
import it.prova.ebayjpa.service.annuncio.AnnuncioService;
import it.prova.ebayjpa.service.categoria.CategoriaService;

@WebServlet("/SearchAnnunciServlet")
public class SearchAnnunciServlet extends HttpServlet {
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
  
    public SearchAnnunciServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("ciaoooo ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String []categorie=request.getParameterValues("categoriaId");
		String descrizioneDaPagina = request.getParameter("descrizioneInput");
		double prezzoInInput = 0L;
		
		AnnuncioDTO temp= new AnnuncioDTO();
		temp.setTestoAnnuncio(descrizioneDaPagina);
		if(categorie != null && categorie.length> 0) {
			for (int i = 0; i < categorie.length; i++) {
				temp.getCategorie().add(categoriaService.get(Long.parseLong(categorie[i])));
			}
			}else {List<Categoria> categorie2= new ArrayList<>();
				for (Categoria catItem : categoriaService.list()) {
				temp.getCategorie().add(catItem);
				}
			}
		try {
			prezzoInInput =Double.parseDouble((String) request.getParameter("prezzoMaxInput"));
			
		} catch (NumberFormatException e) {
			prezzoInInput = -1;
		}
		if (prezzoInInput >0) {
			temp.setPrezzo(prezzoInInput);
		}else temp.setPrezzo(99999999);
		Annuncio example=  AnnuncioDTO.buildAnnuncioFromDto(temp);
		request.setAttribute("listaAnnunci", annuncioService.findByExampleEager(example));
		RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
	}

}
