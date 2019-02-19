package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListTeam;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public navigationServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// figure out which button was clicked.
		// If no button was clicked, then we’ll just reload the page by calling the
		// viewAllPlayersServlet.
		// If ‘Add New Player’ was clicked, then we’ll send them on to index.html.

		ListTeamHelper lth = new ListTeamHelper();
		String act = request.getParameter("doThisToPlayer");

		try {		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
		} else if (act.equals("delete")) {
			//try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				// create a ListTeam to hold the result from ListTeamHelper search
				ListTeam playerToDelete = lth.searchForPlayerById(tempId);
				lth.deletePlayer(playerToDelete);
				getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
			//} catch (NumberFormatException e) {
				// If user didn't make a selection, just refresh the page
			//	getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
			//}
		} else if (act.equals("edit")) {
			//try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListTeam playerToEdit = lth.searchForPlayerById(tempId);
				request.setAttribute("playerToEdit", playerToEdit);
								
				// Get List of Teams
				ListTeamsHelper ltsh = new ListTeamsHelper();
				request.setAttribute("allTeams", ltsh.showAllTeams());
				 System.out.println("All Teams: " + ltsh.showAllTeams());
				if (ltsh.showAllTeams().isEmpty()) {
					request.setAttribute("allTeams", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-player.jsp").forward(request, response);
			//} catch (NumberFormatException e) {
				// If user didn't make a selection, just refresh the page
				//getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
			//}
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/createPlayerServlet").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
		}
		
		
		} catch (NumberFormatException e) {
			// If user didn't make a selection, just refresh the page
			getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
		}
	}

}
