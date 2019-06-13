package it.prova.ebayjpa.web.servlet.user;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import it.prova.ebayjpa.model.Utente;
import it.prova.ebayjpa.service.annuncio.AnnuncioService;
import it.prova.ebayjpa.service.categoria.CategoriaService;
import it.prova.ebayjpa.service.utente.UtenteService;


/**
 * Servlet implementation class ModificaAnnuncioServlet
 */
@WebServlet("/ModificaAnnuncioServlet")
public class ModificaAnnuncioServlet extends HttpServlet {
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
    public ModificaAnnuncioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinazione = null;

		double prezzoInput = 0;
		Long idInput = 0L;
		Long idUtente=0L;
		try {
			idUtente= Long.parseLong((String) request.getParameter("utenteInput"));
			idInput = Long.parseLong((String) request.getParameter("idInput"));
			prezzoInput = Double.parseDouble((String) request.getParameter("prezzoInput"));
		} catch (NumberFormatException e) {
			prezzoInput = -1;
		}
		String testoDaPagina = request.getParameter("testoAnnuncioInput");
		Date dataDaPagina =null;
		try {
			dataDaPagina= new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataInput"));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		AnnuncioDTO annuncioDTO= new AnnuncioDTO();
		annuncioDTO.setId(idInput);
		annuncioDTO.setPrezzo(prezzoInput);
		annuncioDTO.setTestoAnnuncio(testoDaPagina);
		annuncioDTO.setDataAnnuncio(dataDaPagina);
		annuncioDTO.setApertoChiuso(true);
		String []categorie=request.getParameterValues("categoriaId");
		if (!annuncioDTO.validate().isEmpty() || !(categorie != null && categorie.length<= 0)) {
			
			request.setAttribute("messaggioDiErrore", annuncioDTO.validate());
			Annuncio c = annuncioService.caricaEager(idInput);
			request.setAttribute("annuncioDaModificare", c);
			request.setAttribute("listaCategorie", categoriaService.list());
			destinazione = "/user/modificaAnnuncio.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
			return;
		} 
		Annuncio c1 =AnnuncioDTO.buildAnnuncioFromDto(annuncioDTO);
		c1.setUtente(utenteService.CaricaEager(idUtente));
		c1.setId(idInput);
		
		if(categorie != null && categorie.length> 0) {
		for (int i = 0; i < categorie.length; i++) {
			c1.getCategorie().add(categoriaService.get(Long.parseLong(categorie[i])));
		}
		}
		annuncioService.update(c1);
		
		request.setAttribute("listaAnnunci",annuncioService.list());
		destinazione = "result.jsp";
	

RequestDispatcher rd = request.getRequestDispatcher(destinazione);
rd.forward(request, response);
}
	

}
