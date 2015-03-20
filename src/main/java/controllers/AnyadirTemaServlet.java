package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import views.beans.AnyadirTemaBean;

@WebServlet("/views/anyadirTemaServlet")
public class AnyadirTemaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private AnyadirTemaBean anyadirTemaBean;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		anyadirTemaBean = new AnyadirTemaBean();
        request.setAttribute("tema", anyadirTemaBean);
        
        this.getServletContext().getRequestDispatcher("/views/anyadirTemaView.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		anyadirTemaBean.anyadirTema();
        //request.setAttribute("tema", anyadirTemaBean);
        
        this.getServletContext().getRequestDispatcher("/views/anyadirTemaView.jsp").forward(request, response);
	}
}
