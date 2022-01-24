package org.studyeasy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.studyeasy.hibernate.DAO.loginInfoDAO;
import org.studyeasy.hibernate.DAO.requestInfo;
import org.studyeasy.hibernate.entity.LoginData;
import org.studyeasy.hibernate.entity.requestAcceptance;


@WebServlet("/usersHome")
public class usersHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
String	 firstUserEmailString;

String requestSender;
    public usersHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at:  hey ").append(request.getContextPath());
		
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	String action=request.getParameter("action");
	
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
	
	
	
	
	
	
	
	
	
	switch(action) {
	
	case "receivedRequest":
		
		
		List<requestAcceptance> d=new requestInfo().existingUsers();
		
		for(requestAcceptance t:d) {
			
	System.out.println(t.getRequest2());
								System.out.println("inside listabove");
		if(t.getRequest2().equals(firstUserEmailString) ){
				System.out.println("inside list2");
			requestSender=t.getRequest1();}
	
		if(t.getRequest3().equals(firstUserEmailString) ){
			System.out.println("inside list2");
		requestSender=t.getRequest1();}
	
		if(t.getRequest4().equals(firstUserEmailString) ){
			System.out.println("inside list2");
		requestSender=t.getRequest1();}
		if(t.getRequest5().equals(firstUserEmailString) ){
			System.out.println("inside list2");
		requestSender=t.getRequest1();}
	
	
	
	}
		
		
		List<LoginData> databundle=new loginInfoDAO().existingUsers();
		
		request.setAttribute("listusers", databundle);
		for(LoginData user:databundle) {
			System.out.println("clearConsole");
			//System.out.println(user.getEmail());
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			System.out.println("clearConsoleinsideoutside");
			System.out.println(requestSender);
			if(user.getEmail().equals(requestSender)) {
				
			request.setAttribute("requestSenderInformation", user);
			System.out.println("clearConsoleinside");
		request.getRequestDispatcher("userHomePagewithRespectToAnotherUser.jsp").forward(request, response);
		
		
		
		
		
	
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}}
		break;
	case "acceptedRequest":
		
		
	String userno=	(String) request.getParameter("useremail");
	System.out.println("value of "+userno);
		List<requestAcceptance> x=new requestInfo().existingUsers();
		for(requestAcceptance t:x) {
		
		if(t.getRequest1().equals(firstUserEmailString) ){
			
			
			System.out.println("inside list2okurl");
			
	int		firstUserEmailStringId=t.getIduserRequestInfo();
String  copyingR1  =t.getRequest1();
String     copyingR2=t.getRequest2();			

String     copyingR3=t.getRequest3();			
			
			
String     copyingR4=t.getRequest4();			
			
String     copyingR5=t.getRequest5();

String     copyingR6=t.getRequest6();
System.out.println(copyingR6);
System.out.println(copyingR6);
System.out.println(copyingR6);
System.out.println(copyingR6);
String     copyingR7=t.getRequest7();
System.out.println(copyingR7);
String     copyingR8=t.getRequest8();

String     copyingR9=t.getRequest9();


String     copyingR10=t.getRequest10();

String flag="0";
String x1="0";
System.out.println("inside main begin");
System.out.println(copyingR2);
System.out.println(x1);
System.out.println(flag);
if(copyingR6.equals(x1)&& flag.equals(x1)) {	
System.out.println("inside main11 ");
new requestInfo().requestDeleted(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
copyingR6=userno;

new requestInfo().addRequest(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
flag="gotit";
}

if(copyingR7.equals(x1)&& flag.equals(x1)) {	
System.out.println("inside main12 ");
new requestInfo().requestDeleted(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
copyingR7=userno;
System.out.println("userno problem");
System.out.println(userno);
new requestInfo().addRequest(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
flag="gotit";
}	

if(copyingR8.equals(x1)&& flag.equals(x1)) {	
System.out.println("inside main13 ");
new requestInfo().requestDeleted(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
copyingR8=userno;
new requestInfo().addRequest(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
flag="gotit";
}	


if(copyingR9.equals(x1)&& flag.equals(x1)) {	
System.out.println("inside main14 ");
new requestInfo().requestDeleted(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
copyingR9=userno;
new requestInfo().addRequest(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
flag="gotit";
}	








	}



		}		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	}}}
