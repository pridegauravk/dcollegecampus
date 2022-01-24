package org.studyeasy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/** 
 * Servlet implementation class sitecontroller
 */
@WebServlet("/sitecontroller")
public class sitecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sitecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	System.out.println("hello");
	System.out.println(username);
	String we="gaurav";
	String pass="9897";
	if(username.equals(we)&&password.equals(pass)) {
  HttpSession dsession=request.getSession(true);
  dsession.setAttribute("sessionname", dsession);
  dsession.setMaxInactiveInterval(4);
  System.out.println(dsession.getId());
  
  
  String cookievalue="9897556828";
Cookie dcookie= new Cookie("cookiename",cookievalue);
  
  response.addCookie(dcookie);
  
  
  System.out.println(dcookie.getName());
  String Cpath=request.getContextPath();
  response.sendRedirect(Cpath+"/home");
  
	}
	else {
		
		  String path=request.getContextPath();
		  response.sendRedirect(path+"/wronginfo");
	}
	}
}
