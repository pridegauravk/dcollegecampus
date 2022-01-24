package org.studyeasy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.studyeasy.hibernate.DAO.requestInfo;
import org.studyeasy.hibernate.entity.requestAcceptance;

/**
 * Servlet implementation class receivedRequestToLearn
 */
@WebServlet("/receivedRequestToLearn")
public class receivedRequestToLearn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	String emailOfUser=null;
	
	
	
	
	String[] rData = new String[1000];
	int adder=0;
    public receivedRequestToLearn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	

		Cookie[] temp=request.getCookies();
		for(Cookie varia:temp) {
			String v= varia.getName();
			System.out.println("cookies received");
			System.out.println(v);
			if(v.equals("userin")) {
			emailOfUser	 =varia.getValue();
			
			}
		
		
			List<requestAcceptance> d=new requestInfo().existingUsers();
			
			for(requestAcceptance t:d) {
				
	if(t.getRequest2().equals(emailOfUser)) {
					
					
					rData[adder]=t.getRequest1();
					
					System.out.println("insideREQUEST");
					
					adder++;
				}
				
if(t.getRequest3().equals(emailOfUser)) {
		
		
		rData[adder]=t.getRequest1();
		
		System.out.println("insideREQUEST");
		
		
		adder++;
	}
			
			
if(t.getRequest4().equals(emailOfUser)) {
	
	
	rData[adder]=t.getRequest1();
	
	System.out.println("insideREQUEST");
	
	
	adder++;
}
			
			
if(t.getRequest5().equals(emailOfUser)) {
	
	
	rData[adder]=t.getRequest1();
	
	System.out.println("insideREQUEST");
	
	
	adder++;
}
			
if(t.getRequest6().equals(emailOfUser)) {
	
	
	rData[adder]=t.getRequest1();
	
	
	System.out.println("insideREQUEST");
	
	adder++;
}
			
		
			}}
	
	System.out.print(rData);
	

	System.out.println(rData[0]);

	System.out.println(rData[1]);

	System.out.println(rData[2]);

	System.out.println(rData[3]);

	System.out.println(rData[4]);
	request.setAttribute("receivedRequestData1", rData[0]);
	request.setAttribute("receivedRequestData2", rData[1]);
	request.setAttribute("receivedRequestData3", rData[2]);
	request.setAttribute("receivedRequestData4", rData[3]);
	request.setAttribute("receivedRequestData5", rData[4]);
	request.getRequestDispatcher("receivedRequestData.jsp").forward(request, response);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
