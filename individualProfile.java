package org.studyeasy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.hibernate.DAO.loginInfoDAO;
import org.studyeasy.hibernate.DAO.requestInfo;
import org.studyeasy.hibernate.entity.Files;
import org.studyeasy.hibernate.entity.LoginData;
import org.studyeasy.hibernate.entity.requestAcceptance;

/**
 * Servlet implementation class individualprofile
 */
@WebServlet("/individualProfile")
public class individualProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String  userno;
	String firstUserEmailString;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public individualProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
	doPost(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 userno=request.getParameter("userNo");
		 
			
			System.out.println("parameterreceiver");
			System.out.println(userno);
			System.out.println("true condition");
			List<LoginData> databundle=new loginInfoDAO().existingUsers();
			for(LoginData data:databundle) {
				
			if( data.getEmail().equals(userno) ){
				Cookie[] temp=request.getCookies();
				for(Cookie varia:temp) {
					String v= varia.getName();
					System.out.println("cookies received");
					System.out.println(v);
					if(v.equals("userin")) {
					 firstUserEmailString=varia.getValue();
					System.out.println( firstUserEmailString+"cok");
					}
				}
				List<requestAcceptance> d=new requestInfo().existingUsers();
				
				for(requestAcceptance t:d) {
						
						System.out.println("in");
											System.out.println(t.getRequest1());
											System.out.println("inside list");
					if(t.getRequest1().equals(firstUserEmailString) ){
						
						
						System.out.println("inside list2");
						
				int		firstUserEmailStringId=t.getIduserRequestInfo();
			String  copyingR1  =t.getRequest1();
			String     copyingR2=t.getRequest2();			
		
			String     copyingR3=t.getRequest3();			
						
						
			String     copyingR4=t.getRequest4();			
						
			String     copyingR5=t.getRequest5();
			
			String     copyingR6=t.getRequest6();
			
			String     copyingR7=t.getRequest7();
			String     copyingR8=t.getRequest8();
			
			String     copyingR9=t.getRequest9();
			
			
			String     copyingR10=t.getRequest10();
			
			String flag="0";
			String x="0";
			System.out.println("inside main ");
			System.out.println(copyingR2);
			System.out.println(x);
			System.out.println(flag);
		if(copyingR2.equals(x)&& flag.equals(x)) {	
			System.out.println("inside main ");
			new requestInfo().requestDeleted(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
			copyingR2=userno;
			new requestInfo().addRequest(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
			flag="gotit";
		}
			
		if(copyingR3.equals(x)&& flag.equals(x)) {	
			System.out.println("inside main ");
			new requestInfo().requestDeleted(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
			copyingR3=userno;
			new requestInfo().addRequest(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
			flag="gotit";
		}	
			
		if(copyingR4.equals(x)&& flag.equals(x)) {	
			System.out.println("inside main ");
			new requestInfo().requestDeleted(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
			copyingR4=userno;
			new requestInfo().addRequest(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
			flag="gotit";
		}	
			
			
		if(copyingR5.equals(x)&& flag.equals(x)) {	
			System.out.println("inside main ");
			new requestInfo().requestDeleted(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
			copyingR5=userno;
			new requestInfo().addRequest(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
			flag="gotit";
		}	
			
			
			
			
			
			
			
			
				}
			
			
			
					}		
						
					
							System.out.println("in2");
						
							System.out.println("in3");	
						//	requestAcceptance to= new requestAcceptance(3,"hello","hello","hello","hello","hello","hello","hello","hello","hello","hello");
							
						//	new requestInfo().requestRegistered(to);
								
								System.out.println("in4");		
								request.setAttribute("memberInformation", data);
								request.getRequestDispatcher("socialPeople2.jsp").forward(request, response);	
								
							
								
							
						
							
						
						
						
						
						
						
						
						
						
					}
					
					
					
				
				
				
				
				
				
				
				
			
			}
			
		}
		
		
	
		
		
		
	







	public  List<Files> listfiles(){

		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Files.class).buildSessionFactory();
Session session = factory.getCurrentSession();
session.beginTransaction();
List<Files> files=session.createQuery("from files").getResultList();

return files;
}


}
		

	
	
	
		
		
	

