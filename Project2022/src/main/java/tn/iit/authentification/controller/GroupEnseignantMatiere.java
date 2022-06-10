package tn.iit.authentification.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.authentification.model.Groupe;
import tn.iit.authentification.model.GroupeEnseignantMatiere;
import tn.iit.authentification.model.Matiere;
import tn.iit.authentification.model.User;
import tn.iit.util.GroupDAO;
import tn.iit.util.GroupEnseignantMatiereDAO;

/**
 * Servlet implementation class GroupEnseignantMatiere
 */
@WebServlet("/GroupEnseignantMatiere")
public class GroupEnseignantMatiere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GroupEnseignantMatiereDAO grpEnseignantMatiereDao;
	private GroupeEnseignantMatiere GEM;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		grpEnseignantMatiereDao = new GroupEnseignantMatiereDAO();

	}

	public GroupEnseignantMatiere() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");

		if (action.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			if (grpEnseignantMatiereDao.deleteGroupe(id)) {
				response.sendRedirect("GroupEnseignantMatiere?action=list");
			}
		}
		if (action.equals("list")) {
			response.setContentType("text/html");
			List<User> users = grpEnseignantMatiereDao.listGroupnseignant();

			response.setCharacterEncoding("UTF-8");
			/*
			 * PrintWriter out = response.getWriter();
			 * response.setContentType("application/json");
			 * response.setCharacterEncoding("UTF-8"); out.print(userJsonString);
			 * out.flush();
			 */
			request.setAttribute("list", users);
			RequestDispatcher dispatcher = request.getRequestDispatcher("group_enseignant_matiere_list.jsp");
			dispatcher.forward(request, response);
		}
		if (action.equals("add")) {
			request.setAttribute("list_enseignant", grpEnseignantMatiereDao.listUser());
			request.setAttribute("list_groupe", grpEnseignantMatiereDao.listGroup());
			request.setAttribute("list_matiere", grpEnseignantMatiereDao.listMatiere());
			RequestDispatcher dispatcher = request.getRequestDispatcher("group_enseignant_matiere_add.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("edit")) {
			request.setAttribute("list_enseignant", grpEnseignantMatiereDao.listUser());
			request.setAttribute("list_groupe", grpEnseignantMatiereDao.listGroup());
			request.setAttribute("list_matiere", grpEnseignantMatiereDao.listMatiere());
			GEM = grpEnseignantMatiereDao.geById(Integer.parseInt(request.getParameter("id")));
			/*
			 * String userJsonString = this.gson.toJson(GEM);
			 * response.setCharacterEncoding("UTF-8"); PrintWriter out =
			 * response.getWriter(); response.setContentType("application/json");
			 * response.setCharacterEncoding("UTF-8"); out.print(userJsonString);
			 * out.flush();
			 */
			request.setAttribute("GEM", GEM); // Will be available as ${products} in JSP
			request.getRequestDispatcher("group_enseignant_matiere_edit.jsp").forward(request, response);
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
			GroupeEnseignantMatiere groupe = new GroupeEnseignantMatiere();
			Groupe grp = new Groupe();
			grp.setId(Integer.parseInt(request.getParameter("groupe")));

			User user = new User();
			user.setId(Integer.parseInt(request.getParameter("user")));

			Matiere matiere = new Matiere();
			matiere.setId(Integer.parseInt(request.getParameter("matiere")));

			groupe.setGroupe_id(grp);
			groupe.setEnseignant_id(user);
			groupe.setMatiere_id(matiere);
			grpEnseignantMatiereDao.save_update_Groupe(groupe);

			response.sendRedirect("GroupEnseignantMatiere?action=list");
		}
		if (action.equals("edit1")) {
			GroupeEnseignantMatiere groupe = new GroupeEnseignantMatiere();
			Groupe grp = new Groupe();
			grp.setId(Integer.parseInt(request.getParameter("groupe")));

			User user = new User();
			user.setId(Integer.parseInt(request.getParameter("user")));

			Matiere matiere = new Matiere();
			matiere.setId(Integer.parseInt(request.getParameter("matiere")));

			groupe.setGroupe_id(grp);
			groupe.setEnseignant_id(user);
			groupe.setMatiere_id(matiere);
			groupe.setId(Integer.parseInt(request.getParameter("id")));
			grpEnseignantMatiereDao.save_update_Groupe(groupe);
			response.sendRedirect("GroupEnseignantMatiere?action=list");
		}

	}

}
