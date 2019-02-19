package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListTeams; 

/**
 * Servlet implementation class navigationServletTeams
 */
@WebServlet("/navigationServletTeams")
public class navigationServletTeams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServletTeams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// figure out which button was clicked.
		// If no button was clicked, then we’ll just reload the page by calling the
		// viewAllTeamsServlet.
		// If ‘Add New Team’ was clicked, then we’ll send them on to index.html.

		ListTeamsHelper lth = new ListTeamsHelper();
		String act = request.getParameter("doThisToTeam");
		
		try {		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllTeamssServlet").forward(request, response);
		} else if (act.equals("delete")) {
			//try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				// create a ListTeams to hold the result from ListTeamHelper search
				ListTeams teamToDelete = lth.searchForTeamsById(tempId);
				lth.deleteTeams(teamToDelete);
				getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
		} else if (act.equals("edit")) {
			//try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListTeams teamToEdit = lth.searchForTeamsById(tempId);
				request.setAttribute("teamToEdit", teamToEdit);
				getServletContext().getRequestDispatcher("/edit-teams.jsp").forward(request, response);
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
		}
		
		
		} catch (NumberFormatException e) {
			// If user didn't make a selection, just refresh the page
			getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
		}
	}

}
