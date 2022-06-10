package tn.iit.authentification.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.authentification.model.Groupe;
import tn.iit.authentification.model.User;
import tn.iit.util.GroupDAO;
import tn.iit.util.UserDAO;

/**
 * Servlet implementation class InscriptionController
 */
@WebServlet("/InscriptionController")
public class InscriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO loginDao;
	private User user;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		loginDao = new UserDAO();

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("delete")) {
			int id=Integer.parseInt(request.getParameter("id"));
			if (loginDao.deleteUser(id)) {
				response.sendRedirect("InscriptionController?action=list");
			}
		}
		if (action.equals("list")) {
			request.setAttribute("list",loginDao.getUsers()); // Will be available as ${products} in JSP
			//response.sendRedirect("Liste_user.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Liste_user.jsp");
			dispatcher.forward(request, response);
		}
		
		if (action.equals("Actif")) {
			User user = new User();

			user.setId(Integer.parseInt(request.getParameter("id")));
			
			user=loginDao.geById(Integer.parseInt(request.getParameter("id")));
			user.setStatus("1");
			loginDao.saveUser(user);

			response.sendRedirect("InscriptionController?action=list");
			
		}
		if (action.equals("inActif")) {
			User user = new User();

			user.setId(Integer.parseInt(request.getParameter("id")));
			
			user=loginDao.geById(Integer.parseInt(request.getParameter("id")));
			user.setStatus("0");
			loginDao.saveUser(user);

			response.sendRedirect("InscriptionController?action=list");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
 {
			User user = new User();
			user.setFirstName(request.getParameter("first_name"));
			user.setLastName(request.getParameter("last_name"));
			user.setUsername(request.getParameter("user_name"));
			user.setPassword(request.getParameter("password"));
			user.setRole(request.getParameter("role"));
			user.setEmail(request.getParameter("email"));
			user.setCin(request.getParameter("cin"));
			user.setStatus("0");

			loginDao.saveUser(user);

			response.sendRedirect("login.jsp");
			
		}

		/*
		 * Utilisateur u = new Utilisateur(request.getParameter("nom"),
		 * request.getParameter("prenom"), request.getParameter("login"),
		 * request.getParameter("password")); ServletContext application =
		 * getServletContext(); HttpSession session = request.getSession();
		 * //Utilisateur u1 = new Utilisateur( (Utilisateur)
		 * session.getAttribute("currentUser"));
		 * 
		 * List<Utilisateur> liste = (List<Utilisateur>)
		 * session.getAttribute("listeUsers"); if (liste == null) { liste = new
		 * ArrayList<Utilisateur>(); } liste.add(u); session.setAttribute("currentUser",
		 * u); /*try { session.setAttribute("listeUsers", UserDAO.getAll()); } catch
		 * (SQLException e1) { // TODO Auto-generated catch block e1.printStackTrace();
		 * } // application.setAttribute("listeUsers", liste); try { UserDAO.save(u); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		// response.sendRedirect("login-success.jsp");
	}

}
