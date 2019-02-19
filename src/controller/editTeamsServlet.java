package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListTeams;

/**
 * Servlet implementation class editTeamsServlet
 */
@WebServlet("/editTeamsServlet")
public class editTeamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editTeamsServlet() {
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
		//create ListTeamsHelper object
		ListTeamsHelper lth = new ListTeamsHelper();
		//get updated values from the page
		String teamName = request.getParameter("teamName");
		String teamColors = request.getParameter("teamColors");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		//create ListTeams by using ListTeamsHelper search method
		ListTeams teamToUpdate = lth.searchForTeamsById(tempId);
		
		//update new values in ListTeam
		teamToUpdate.setTeamName(teamName);
		teamToUpdate.setTeamColors(teamColors);
		
		//Update database using ListTeamHelper update method
		lth.updateTeams(teamToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
	}

}