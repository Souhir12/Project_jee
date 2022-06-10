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

import tn.iit.authentification.model.User;
import tn.iit.util.UserDAO;

/**
 * Servlet implementation class InscriptionController
 */
@WebServlet("/InscriptionEditController")
public class InscriptionEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO loginDao;

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
	public InscriptionEditController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = loginDao.geById(id);

		request.setAttribute("user", user); // Will be available as ${products} in JSP
		request.setAttribute("role", user.getRole()); // Will be available as ${products} in JSP
		request.getRequestDispatcher("EditUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();

		
		//user.setStatus("0");
		user=loginDao.geById(Integer.parseInt(request.getParameter("id")));
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setFirstName(request.getParameter("first_name"));
		user.setLastName(request.getParameter("last_name"));
		user.setUsername(request.getParameter("user_name"));
		user.setPassword(request.getParameter("password"));
		user.setRole(request.getParameter("role"));
		user.setEmail(request.getParameter("email"));
		user.setCin(request.getParameter("cin"));
		loginDao.saveUser(user);
		request.setAttribute("list", loginDao.getUsers()); // Will be available as ${products} in JSP
		// response.sendRedirect("Liste_user.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Liste_user.jsp");
		dispatcher.forward(request, response);

		// request.setAttribute("list", loginDao.getUsers()); // Will be available as
		// ${products} in JSP
		// request.getRequestDispatcher("InscriptionController?action=list").forward(request,
		// response);

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
