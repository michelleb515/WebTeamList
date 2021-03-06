package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListTeam;
import model.ListTeams;

/**
 * Servlet implementation class editPlayerServlet
 */
@WebServlet("/editPlayerServlet")
public class editPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editPlayerServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//create ListTeamHelper object
		ListTeamHelper lth = new ListTeamHelper();
		ListTeamsHelper ltsh = new ListTeamsHelper(); 

		//get updated values from the page
		String name = request.getParameter("name");
		int jersey = Integer.parseInt(request.getParameter("jersey"));
		int weight = Integer.parseInt(request.getParameter("weight"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		int teamId = Integer.parseInt(request.getParameter("teamId"));
		System.out.println("team id = " + teamId);
		
		//get all team values
		//Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		//create new listTeams ojbect and populate wtih values
		//then pass listTeams object to ListTeam (player) object
		
		
		//create ListTeam by using ListTeamHelper search method
		ListTeam playerToUpdate = lth.searchForPlayerById(tempId);
		ListTeams lt = new ListTeams(teamId);
		
		//update new values in ListTeam
		playerToUpdate.setName(name);
		playerToUpdate.setJersey(jersey);
		playerToUpdate.setWeight(weight);
		playerToUpdate.setTeamId(lt);

		//Update database using ListTeamHelper update method
		lth.updatePlayer(playerToUpdate);
				
		getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
	}

}
