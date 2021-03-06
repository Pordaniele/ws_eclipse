package it.prova.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MottoDelGiornoServlet")
public class MottoDelGiornoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MottoDelGiornoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mottoDelGiornoInput = request.getParameter("messaggioDelGiornoInput");
		request.setAttribute("mottodelgiorno_attribute", mottoDelGiornoInput);
		RequestDispatcher rd=request.getRequestDispatcher("mostraMotto.jsp");
		rd.forward(request, response);
	}

}
