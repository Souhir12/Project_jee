package tn.iit.authentification.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.authentification.model.Groupe;
import tn.iit.authentification.model.Matiere;
import tn.iit.authentification.model.User;
import tn.iit.util.GroupDAO;
import tn.iit.util.UserDAO;

/**
 * Servlet implementation class GroupController
 */
@WebServlet("/GroupController")
public class GroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GroupDAO groupDao;
	private Groupe groupe;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GroupController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		groupDao = new GroupDAO();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		if (action.equals("delete")) {
			int id=Integer.parseInt(request.getParameter("id"));
			if (groupDao.deleteGroupe(id)) {
				response.sendRedirect("GroupController?action=list");
			}
		}
		if (action.equals("list")) {
			request.setAttribute("list", groupDao.listGroup()); // Will be available as ${products} in JSP
			// response.getRequestDispatcher("list_group.jsp").forward(request, response);
			HttpSession session = request.getSession();
            User utilisateur=(User)session.getAttribute("currentuser");

            List<Groupe> grp =groupDao.listGroupeeENS(utilisateur); 
            request.setAttribute("listEns", grp);
			RequestDispatcher dispatcher = request.getRequestDispatcher("list_group.jsp");
			dispatcher.forward(request, response);
			// response.sendRedirect("list_group.jsp");
		}
		if (action.equals("add")) {
			System.out.println("xx");
			// response.sendRedirect("add_group.jsp");
			response.sendRedirect("add_group.jsp");

		} else

		if (action.equals("edit")) {
			groupe = groupDao.geById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("groupe", groupe); // Will be available as ${products} in JSP
			request.getRequestDispatcher("edit_group.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

		if (action.equals("add1")) {
			Groupe groupe = new Groupe();
			groupe.setLabel(request.getParameter("label"));
			groupe.setNb_etd(request.getParameter("nb_etd"));
			groupDao.save_update_Groupe(groupe);
			response.sendRedirect("GroupController?action=list");
		}
		if (action.equals("edit1")) {
			Groupe groupe = new Groupe();
			groupe.setId(Integer.parseInt(request.getParameter("id")));
			groupe.setLabel(request.getParameter("label"));
			groupe.setNb_etd(request.getParameter("nb_etd"));
			groupDao.save_update_Groupe(groupe);
			response.sendRedirect("GroupController?action=list");
		}

		
	}

}
