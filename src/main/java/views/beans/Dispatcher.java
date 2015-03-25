package views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dispatcher
 */
@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/views/jsp/";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo().substring(1);

		String view;
		switch(action) {
		case "anyadirTema":
			AnyadirTemaBean anyadirTemaBean = new AnyadirTemaBean();
			request.setAttribute(action, anyadirTemaBean);
			view = action;
			break;
		case "eliminarTema":
			EliminarTemaBean eliminarTemaBean = new EliminarTemaBean();
			request.setAttribute(action, eliminarTemaBean);
			view = action;
			break;
		case "verVotaciones":
			VerVotacionesBean verVotacionesBean = new VerVotacionesBean();
			request.setAttribute(action, verVotacionesBean);
			view = action;
			break;
		default:
			view = "home";
		}

		this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo().substring(1);

		String view;
		switch(action) {
		case "anyadirTema":
			AnyadirTemaBean anyadirTemaBean = new AnyadirTemaBean();
			anyadirTemaBean.setName(request.getParameter("name"));
			anyadirTemaBean.setPregunta(request.getParameter("pregunta"));
			anyadirTemaBean.process();
			view = "home";
			break;
		case "eliminarTema":
			EliminarTemaBean eliminarTemaBean = new EliminarTemaBean();
			eliminarTemaBean.setId(Integer.valueOf(request.getParameter("select")));
			eliminarTemaBean.process();
			view = "home";
			break;
		case "verVotaciones":
			VerVotacionesBean verVotacionesBean = new VerVotacionesBean();
			verVotacionesBean.setId(Integer.valueOf(request.getParameter("select")));
			verVotacionesBean.process();
			view = "home";
			break;
		default:
			view = "home";
		}

		this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
		.forward(request, response);

	}

}
