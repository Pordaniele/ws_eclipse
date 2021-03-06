package it.prova.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.model.Persona;


@WebServlet("/HelloPersonaServlet")
public class HelloPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HelloPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Persona p1= new Persona();
	p1.setNome(request.getParameter("nomeInput"));
	p1.setCognome(request.getParameter("cognomeInput"));
	request.setAttribute("persona_attribute", p1);
	
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
