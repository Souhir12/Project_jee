package tn.iit.authentification.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.util.UserDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private UserDAO loginDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		loginDao = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 try {
	            authenticate(request, response);

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	private void authenticate(HttpServletRequest request, HttpServletResponse response)
		    throws Exception {
		        String username = request.getParameter("username");
		        String password = request.getParameter("password");

				if (loginDao.validate(username, password)  ) {
					HttpSession session = request.getSession();
		            session.setAttribute("currentuser", loginDao.geByUsername_Password(username, password));
		        	response.sendRedirect("index.jsp");
		            
		      
		        }else if (loginDao.VerifActif(username, password)  )
		        {
		        	request.setAttribute("erreur", "Compte inactif");
		        	//response.sendRedirect("login.jsp");
		            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		            dispatcher.forward(request, response);
		        }
				else
		        {
		        	request.setAttribute("erreur", "Erreur d'authentification !!!");
		        	//response.sendRedirect("login.jsp");
		            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		            dispatcher.forward(request, response);

					//getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		        }
		    }

}
