package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createPlayerServlet
 */
@WebServlet("/createPlayerServlet")
public class createPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public createPlayerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In createPlayerServlet");
		// Get List of Teams
		ListTeamsHelper ltsh = new ListTeamsHelper();
		request.setAttribute("allTeams", ltsh.showAllTeams());
		// System.out.println("All Teams: " + ltsh.showAllTeams());
		if (ltsh.showAllTeams().isEmpty()) {
			request.setAttribute("allTeams", " ");

		}
		getServletContext().getRequestDispatcher("/add-player.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In createPlayerServlet");
		// Get List of Teams
		ListTeamsHelper ltsh = new ListTeamsHelper();
		request.setAttribute("allTeams", ltsh.showAllTeams());
		// System.out.println("All Teams: " + ltsh.showAllTeams());
		if (ltsh.showAllTeams().isEmpty()) {
			request.setAttribute("allTeams", " ");

			getServletContext().getRequestDispatcher("/add-player.jsp").forward(request, response);
		}
	}

}
