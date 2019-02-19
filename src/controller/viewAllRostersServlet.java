package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewAllRostersServlet
 */
@WebServlet("/viewAllRostersServlet")
public class viewAllRostersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllRostersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("~~~~~~~viewAllRostersServlet ~~~~~");
		ListRosterHelper lrh = new ListRosterHelper(); 
		System.out.println("~~~~~~~created ListRosterHelper");
		request.setAttribute("allRosters",lrh.showAllRosters());
		System.out.println("All Rosters:  " + lrh.showAllRosters());
		
		if (lrh.showAllRosters().isEmpty()) {
			request.setAttribute("allRosters", "-");
		}
		
		//Dispatch to appropriate jsp
		getServletContext().getRequestDispatcher("/roster-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
