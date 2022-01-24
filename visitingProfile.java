package org.studyeasy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.hibernate.entity.Files;

/**
 * Servlet implementation class visitingProfile
 */
@WebServlet("/visitingProfile")
public class visitingProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public visitingProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	String action=request.getParameter("action");
if(action.equals("notavailable")) {
		
		request.getRequestDispatcher("notAvailable.jsp").forward(request, response);
		
		
		
	}
	
	List<Files> files= listfiles();
	
	request.setAttribute("emailOfUser", action);
	request.setAttribute("alldata", files);
	request.getRequestDispatcher("realHomeForwardToIndividualUser.jsp").forward(request, response);
	
	
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	public  List<Files> listfiles(){

		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Files.class).buildSessionFactory();
Session session = factory.getCurrentSession();
session.beginTransaction();
List<Files> files=session.createQuery("from files").getResultList();

return files;
}
	

}
