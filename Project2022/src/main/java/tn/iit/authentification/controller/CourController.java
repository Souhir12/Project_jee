package tn.iit.authentification.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.Part;

import com.google.gson.Gson;

import tn.iit.authentification.model.Cour;
import tn.iit.authentification.model.GroupeEnseignantMatiere;
import tn.iit.authentification.model.User;
import tn.iit.util.CourDAO;
import tn.iit.util.GroupEnseignantMatiereDAO;


/**
 * Servlet implementation class GroupController
 */
@WebServlet("/CourController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class CourController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SAVE_DIRECTORY = "uploadDir";
	private CourDAO courDao;
	private GroupEnseignantMatiereDAO grpEnseignantMatiereDao;
	private Cour cour;
	 private Gson gson = new Gson();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		courDao = new CourDAO();
		grpEnseignantMatiereDao = new GroupEnseignantMatiereDAO();

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
			int id = Integer.parseInt(request.getParameter("id"));
			if (courDao.deleteCour(id)) {
				response.sendRedirect("GroupController?action=list");
			}
		}
		if (action.equals("list")) {
			List<Cour> users = courDao.listCour();

			String userJsonString = this.gson.toJson(users);
			 response.setCharacterEncoding("UTF-8");
		    /*PrintWriter out = response.getWriter();
		        response.setContentType("application/json");
		        response.setCharacterEncoding("UTF-8");
		        out.print(userJsonString);
		        out.flush();*/
			request.setAttribute("list", courDao.listCour()); // Will be available as ${products} in JSP
			// response.getRequestDispatcher("list_group.jsp").forward(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("list_cours.jsp");
			dispatcher.forward(request, response);
			// response.sendRedirect("list_group.jsp");
			
			
		}
		if (action.equals("add")) {
		
			//int id = Integer.parseInt(request.getParameter("id_user"));
		//	System.out.println(id);
			HttpSession session = request.getSession();
		User enseignant= (User) session.getAttribute("currentuser");
			 
			List<User> users = grpEnseignantMatiereDao.listGroupMatiere2(enseignant);
			
		String userJsonString = this.gson.toJson(users);
		 response.setCharacterEncoding("UTF-8");
	   /* PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.print(userJsonString);
	        out.flush();*/
		
		
		
	        request.setAttribute("list",users);
			RequestDispatcher dispatcher = request.getRequestDispatcher("add_cour.jsp");
			dispatcher.forward(request, response);	
			// response.sendRedirect("add_group.jsp");
			//response.sendRedirect("add_cour.jsp");

		} 
		if (action.equals("erreur")) {

		
			//int id = Integer.parseInt(request.getParameter("id_user"));
		//	System.out.println(id);
			HttpSession session = request.getSession();
		User enseignant= (User) session.getAttribute("currentuser");
			 
			List<User> users = grpEnseignantMatiereDao.listGroupMatiere2(enseignant);
			
		String userJsonString = this.gson.toJson(users);
		 response.setCharacterEncoding("UTF-8");
	   /* PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.print(userJsonString);
	        out.flush();*/
		
		
		 	request.setAttribute("erreur","nombre de copie suppérieur au nombre des étudiants !!");
	        request.setAttribute("list",users);
			RequestDispatcher dispatcher = request.getRequestDispatcher("add_cour.jsp");
			dispatcher.forward(request, response);	
			// response.sendRedirect("add_group.jsp");
			//response.sendRedirect("add_cour.jsp");

		
			
		}
		
		if (action.equals("edit")) {
			cour = courDao.geById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("cour", cour); // Will be available as ${products} in JSP
			request.getRequestDispatcher("edit_cour.jsp").forward(request, response);
		}
		
		if(action.equals("file")) {
			int id =Integer.parseInt(request.getParameter("filename"));
			Cour c = courDao.geById(id);
			String filename = c.getFilename();
			System.out.println(filename);
			response.setContentType("text/html");  
			PrintWriter out = response.getWriter();  
			 
			//String filepath = "c:\\";   
			response.setContentType("APPLICATION/OCTET-STREAM");   
			response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
			  
			FileInputStream fileInputStream = new FileInputStream(filename);  
			            
			int i;   
			while ((i=fileInputStream.read()) != -1) {  
			out.write(i);   
			}   
			fileInputStream.close();   
			out.close();   
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
			int nb_copie = Integer.parseInt(request.getParameter("nb_copie"));
			int gem_id = Integer.parseInt(request.getParameter("gem_id"));
			List<GroupeEnseignantMatiere> liste = (List<GroupeEnseignantMatiere>) courDao.valide_nb_etd(gem_id);
		System.out.println("**************************");
		
		String nb_etd = null;
			for (GroupeEnseignantMatiere gem : liste)  {
				nb_etd= gem.getGroupe_id().getNb_etd();
			}
			if(Integer.parseInt(request.getParameter("nb_copie")) > Integer.parseInt(nb_etd)) {
				
				// response.sendRedirect("login.jsp");
				response.sendRedirect("CourController?action=erreur");
			
			}else {
			/*String userJsonString = this.gson.toJson(courDao.valide_nb_etd(gem_id));
			 response.setCharacterEncoding("UTF-8");
		    PrintWriter out = response.getWriter();
		        response.setContentType("application/json");
		        response.setCharacterEncoding("UTF-8");
		        out.print(userJsonString);
		        out.flush();*/
			try {
				String appPath = "C:/";
				appPath = appPath.replace('\\', '/');
				String fullSavePath = null;
				if (appPath.endsWith("/")) {
					fullSavePath = appPath + SAVE_DIRECTORY;
				} else {
					fullSavePath = appPath + "/" + SAVE_DIRECTORY;
				}
				File fileSaveDir = new File(fullSavePath);
				if (!fileSaveDir.exists()) {
					fileSaveDir.mkdir();
				}
				Cour cour = new Cour();
				System.out.println("ss");
				for (Part part : request.getParts()) {
					String fileName = extractFileName(part);

					if (fileName != null && fileName.length() > 0) {
						String filePath = fullSavePath + File.separator + fileName;
						System.out.println("Write attachment to file: " + filePath);
						// Write to file
						part.write(filePath);
						cour.setFilename(filePath);
						// return;
					}
				}

				System.out.println("aa");

				String tiragedate = request.getParameter("tiragedate");
				
				
				cour.setNb_copie(nb_copie);
				System.out.println(tiragedate + "----------");
				
				Timestamp created_date = new Timestamp(System.currentTimeMillis());
				cour.setTirage_date(tiragedate);
				cour.setCreated_date(created_date);
				GroupeEnseignantMatiere grp= new GroupeEnseignantMatiere();
				grp.setId(gem_id);		
				
				cour.setGem_id(grp);
				courDao.save_update_Cour(cour);
				response.sendRedirect("CourController?action=list");

//				response.sendRedirect(request.getContextPath() + "/uploadFileResults");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "Error: " + e.getMessage());
				// RequestDispatcher dispatcher =
				// getServletContext().getRequestDispatcher("/WEB-INF/jsps/uploadFile.jsp");
				// dispatcher.forward(request, response);
			}

		}}
		if (action.equals("edit1")) {
			Cour cour = new Cour();
			cour.setFilename(null);
			String tiragedate = request.getParameter("tiragedate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String startDate = null;
			startDate = sdf.format(tiragedate);
			cour.setTirage_date(startDate);
			response.sendRedirect("GroupController?action=list");
		}

	}

	private String extractFileName(Part part) {
		// form-data; name="file"; filename="C:\file1.zip"
		// form-data; name="file"; filename="C:\Note\file2.zip"
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				// C:\file1.zip
				// C:\Note\file2.zip
				String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
				clientFileName = clientFileName.replace("\\", "/");
				int i = clientFileName.lastIndexOf('/');
				// file1.zip
				// file2.zip
				return clientFileName.substring(i + 1);
			}
		}
		return null;
	}
	

}
