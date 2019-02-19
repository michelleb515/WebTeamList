package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListRoster;

/**
 * Servlet implementation class navigationServletRoster
 */
@WebServlet("/navigationServletRoster")
public class navigationServletRoster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServletRoster() {
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
		ListRosterHelper lth = new ListRosterHelper();
		String act = request.getParameter("doThisToRoster");

		try {		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllRostersServlet").forward(request, response);
		} else if (act.equals("delete")) {
			//try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				// create a ListRoster to hold the result from ListRosterHelper search
				ListRoster rosterToDelete = lth.searchForRosterById(tempId);
				lth.deleteRoster(rosterToDelete);
				getServletContext().getRequestDispatcher("/viewAllRostersServlet").forward(request, response);
			//} catch (NumberFormatException e) {
				// If user didn't make a selection, just refresh the page
			//	getServletContext().getRequestDispatcher("/viewAllRostersServlet").forward(request, response);
			//}
		} else if (act.equals("edit")) {
			//try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListRoster rosterToEdit = lth.searchForRosterById(tempId);
				request.setAttribute("rosterToEdit", rosterToEdit);
				getServletContext().getRequestDispatcher("/edit-roster.jsp").forward(request, response);
			//} catch (NumberFormatException e) {
				// If user didn't make a selection, just refresh the page
				//getServletContext().getRequestDispatcher("/viewAllRostersServlet").forward(request, response);
			//}
		} else if (act.equals("add")) {
			System.out.println("~~~~~~~Adding");
			getServletContext().getRequestDispatcher("/addRosterServlet").forward(request, response);
		} 
		else if (act.equals("create")) { 
			System.out.println("~~~~~~~Creating Roster");
			//Get values from screen
			Integer teamId = Integer.parseInt(request.getParameter("teamId")); 
			Integer playerId = Integer.parseInt(request.getParameter("playerId"));
			System.out.println("TeamID = " + teamId + " PlayerID = " + playerId);
			//Populate values to ListRoster Object
			ListRoster rosterToCreate = new ListRoster(teamId, playerId); 
			System.out.println("Roster to Create: " + rosterToCreate.toString());
			ListRosterHelper lrh = new ListRosterHelper();
			lrh.insertRoster(rosterToCreate);
			getServletContext().getRequestDispatcher("/viewAllRostersServlet").forward(request, response);

			//Call ListRosterHelper to load to database
		} else {
			getServletContext().getRequestDispatcher("/viewAllRostersServlet").forward(request, response);
		}
		
		
		} catch (NumberFormatException e) {
			// If user didn't make a selection, just refresh the page
			getServletContext().getRequestDispatcher("/viewAllRostersServlet").forward(request, response);
		}
	}

}