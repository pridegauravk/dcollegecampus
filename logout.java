package org.studyeasy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at:what ").append(request.getContextPath());
		
		
		
		request.getSession().invalidate();
		
		
		Cookie[] cookie=request.getCookies();
		
		for(Cookie temp:cookie) {
			
			if(temp.getName().equals("cookiename")) {

				System.out.println("cookie destruction started");
				request.getSession().invalidate();
				temp.setValue(null);
				temp.setMaxAge(0);
			System.out.println(temp.getName());	
			response.addCookie(temp);
			

				
				
			}
			
			
			
		}
		request.getRequestDispatcher("member.jsp").forward(request, response);
	}
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
