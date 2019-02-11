package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListTeam;

/**
 * Servlet implementation class addPlayerServlet
 */
@WebServlet("/addPlayerServlet")
public class addPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name"); 
		int jersey = Integer.parseInt(request.getParameter("jersey"));
		int weight = Integer.parseInt(request.getParameter("weight")); 
		
		ListTeamHelper lth = new ListTeamHelper(); 
		ListTeam toAdd = new ListTeam(name, jersey, weight);
		lth.insertPlayer(toAdd);
		
		//add the request dispatcher to direct back to the index.html page
		//getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
		
	}

}
