package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewAllTeamsServlet
 */
@WebServlet("/viewAllTeamsServlet")
public class viewAllTeamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllTeamsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListTeamsHelper lth = new ListTeamsHelper(); 
		request.setAttribute("allTeams",lth.showAllTeams()); 
				
		if (lth.showAllTeams().isEmpty()) {
			System.out.println("oh no!  No data!");
			request.setAttribute("allTeams", "-");
		}
		
		System.out.println("ViewAllTeams: " + lth.showAllTeams());
		
		//Dispatch to appropriate jsp
		getServletContext().getRequestDispatcher("/teams-list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
