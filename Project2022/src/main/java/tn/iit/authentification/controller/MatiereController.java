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
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import tn.iit.authentification.model.Matiere;
import tn.iit.authentification.model.User;
import tn.iit.util.MatiereDAO;
import com.google.gson.Gson;
 
/**
 * Servlet implementation class GroupController
 */
@WebServlet("/MatiereController")
public class MatiereController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MatiereDAO matiereDao;
	private  Matiere matiere;
	private Gson gson = new Gson();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MatiereController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		matiereDao = new MatiereDAO();

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
			if (matiereDao.deleteMatiere(id)) {
				response.sendRedirect("MatiereController?action=list");
			}
		}
		if (action.equals("list")) {
			request.setAttribute("list", matiereDao.listMatiere());
			HttpSession session = request.getSession();
            User utilisateur=(User)session.getAttribute("currentuser");
            System.out.println("***********");
            System.out.println(utilisateur.id);
            
            List<Matiere> users =matiereDao.listMatiereENS(utilisateur); 
            request.setAttribute("listEns", users);
         /*   String userJsonString = this.gson.toJson(users);
			 response.setCharacterEncoding("UTF-8");
		   PrintWriter out = response.getWriter();
		        response.setContentType("application/json");
		        response.setCharacterEncoding("UTF-8");
		        out.print(userJsonString);
		        out.flush();*/
			// Will be available as ${products} in JSP
			// response.getRequestDispatcher("list_group.jsp").forward(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("list_matiere.jsp");
			dispatcher.forward(request, response);
			// response.sendRedirect("list_group.jsp");
		}
		if (action.equals("add")) {
			System.out.println("xx");
			// response.sendRedirect("add_group.jsp");
			response.sendRedirect("add_matiere.jsp");

		} else

		if (action.equals("edit")) {
			matiere = matiereDao.geById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("matiere", matiere); // Will be available as ${products} in JSP
			request.getRequestDispatcher("edit_matiere.jsp").forward(request, response);
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
			Matiere matiere = new Matiere();
			matiere.setLabel(request.getParameter("label"));
			matiereDao.save_update_Matiere(matiere);
			response.sendRedirect("MatiereController?action=list");
		}
		if (action.equals("edit1")) {
			Matiere matiere = new Matiere();
			matiere.setId(Integer.parseInt(request.getParameter("id")));
			matiere.setLabel(request.getParameter("label"));
			matiereDao.save_update_Matiere(matiere);
			response.sendRedirect("MatiereController?action=list");
		}

		
	}

}
