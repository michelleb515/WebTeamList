package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addRosterServlet
 */
@WebServlet("/addRosterServlet")
public class addRosterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addRosterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get List of Teams
		ListTeamsHelper ltsh = new ListTeamsHelper(); 
		request.setAttribute("allTeams", ltsh.showAllTeams());
		//System.out.println("All Teams: " + ltsh.showAllTeams());
		if (ltsh.showAllTeams().isEmpty()) {
			request.setAttribute("allTeams", " ");
		}
		
		//Get List of Players
		ListTeamHelper lth = new ListTeamHelper();
		request.setAttribute("allPlayers", lth.showAllPlayers());
		if (lth.showAllPlayers().isEmpty()) {
			request.setAttribute("allPlayers", " ");
		}
		//System.out.println("~~~~~~~~~~~~  sending to new-list.jsp");
		getServletContext().getRequestDispatcher("/add-roster.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
