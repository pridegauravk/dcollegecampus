package org.studyeasy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.hibernate.DAO.FilesDAO;
import org.studyeasy.hibernate.DAO.loginInfoDAO;
import org.studyeasy.hibernate.DAO.requestInfo;
import org.studyeasy.hibernate.entity.Files;
import org.studyeasy.hibernate.entity.LoginData;
import org.studyeasy.hibernate.entity.requestAcceptance;

/**
 * Servlet implementation class userinfo
 */
@WebServlet("/userinfo")
public class userinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	String	userEmailReceived=	null;

	String	userPasswordRepeatReceived=	null;
	String	userPasswordReceived=null;	
	String	userNameReceived=null;	
	String	userCourseReceived=	null;
	String	userBranchReceived=null;
	String           userSkillReceived= null;
String	userGenderReceived=null;
String userrePasswordReceived=null;
	int flag=0;
	
	String found="0";
	
	
	
	
	
	
    public userinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String locateparamer=request.getParameter("action");
		
		switch(locateparamer) {
		
		case "userlogin":
			
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			System.out.println("separate");
			System.out.println(password);
			System.out.println(username);
			System.out.println("separate");
			List<LoginData> databundle=new loginInfoDAO().existingUsers();
			
			request.setAttribute("listusers", databundle);
			for(LoginData user:databundle) {
				System.out.println("clearConsole");
				//System.out.println(user.getEmail());
				System.out.println(user.getEmail());
				System.out.println(user.getPassword());
				
				if(user.getEmail().equals(username)&&user.getPassword().equals(password)) {
					
				
					HttpSession newsession = request.getSession(true);
					
					newsession.setAttribute("sessionuser", newsession);
					newsession.setMaxInactiveInterval(300);
					Cookie d = new Cookie("userin",username);
					response.addCookie(d);
					
					
					
					
					
					
					
					System.out.println(user.getEmail());
					List<Files> files= listfiles();
					
					request.setAttribute("alldata", files);
					System.out.println("missionEntry");
					request.getRequestDispatcher("afterLogin.jsp").forward(request, response);
					flag++;
			}
			
			}
			while(flag==0) {
				request.getRequestDispatcher("login2.jsp").forward(request, response);
				
			}
			break;
			
			
		
		case "register":
		
		
	userEmailReceived=	request.getParameter("email");

	userrePasswordReceived=	request.getParameter("psw-repeat");

	userGenderReceived=	request.getParameter("Gender");
	userPasswordReceived=	request.getParameter("password");
	userNameReceived=	request.getParameter("name");
	userCourseReceived=	request.getParameter("course");
	userBranchReceived=	request.getParameter("branch");
	userSkillReceived=  request.getParameter("fromItemList");
	
	System.out.println(userBranchReceived);
	System.out.println(userSkillReceived);
	
	List<LoginData> databundle1=new loginInfoDAO().existingUsers();
	for(LoginData data:databundle1) {
		
	if( data.getEmail().equals(userEmailReceived) ){
	
	request.getRequestDispatcher("usedEmail.jsp").forward(request, response);
	
	
	}
	
	}
	if(userPasswordReceived.equals(userrePasswordReceived)) {
		
		
		System.out.println(userPasswordReceived);
		System.out.println(userrePasswordReceived);
	setValuesInEntity(request,response);
	}
	
	else {

		request.getRequestDispatcher("repeatWrong.jsp").forward(request, response);
	}

	request.getRequestDispatcher("repeatWrong.jsp").forward(request, response);
		break;
		
		}}

public void setValuesInEntity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		new loginInfoDAO().addLoginInfo(new LoginData(0, userNameReceived, userCourseReceived, userPasswordReceived,userGenderReceived, userEmailReceived,userBranchReceived,userSkillReceived ));
		
		new requestInfo().requestRegistered(new requestAcceptance(userEmailReceived,"0","0","0","0","0","0","0","0","0"));

	//	System.out.println("successful");
Files instDp =new Files("noDp.png",userEmailReceived,"d");
		
		new FilesDAO().addFileDetails(instDp);
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
		
	}public  List<Files> listfiles(){

		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Files.class).buildSessionFactory();
Session session = factory.getCurrentSession();
session.beginTransaction();
List<Files> files=session.createQuery("from files").getResultList();

return files;
}
		}
	
	
	
