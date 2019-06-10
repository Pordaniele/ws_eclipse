package it.prova.web.servlet;

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

import it.prova.model.Vino;
import it.prova.service.VinoService;

@WebServlet("/SearchVinoServlet")
public class SearchVinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private VinoService vinoService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public SearchVinoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeInput = request.getParameter("nomeInput");
		String cantinaInput = request.getParameter("cantinaInput");
		String localitaInput = request.getParameter("localitaInput");
		String uvaInput = request.getParameter("uvaInput");
		Vino example = new Vino(nomeInput, cantinaInput, localitaInput, uvaInput);

		request.setAttribute("listaVinoAttributeName", vinoService.findByExample(example));

		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
}
