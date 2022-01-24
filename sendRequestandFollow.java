package org.studyeasy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.hibernate.DAO.FilesDAO;
import org.studyeasy.hibernate.DAO.followerDAO;
import org.studyeasy.hibernate.DAO.loginInfoDAO;
import org.studyeasy.hibernate.DAO.requestInfo;
import org.studyeasy.hibernate.entity.Files;
import org.studyeasy.hibernate.entity.LoginData;
import org.studyeasy.hibernate.entity.follower;
import org.studyeasy.hibernate.entity.requestAcceptance;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.uploadcare.api.Client;
import com.uploadcare.api.Project;
import com.uploadcare.upload.FileUploader;
import com.uploadcare.upload.UploadFailureException;
import com.uploadcare.upload.Uploader;

/**
 * Servlet implementation class ImageUpload
 */
@WebServlet("/sendRequestandFollow")
public class sendRequestandFollow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String path="C:/Users/Gaurav/Pictures/uploadedimages/";
	String		emailOfUser="noCookiesFound";
	String  userno;
	String firstUserEmailString;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletFileUpload upload=new ServletFileUpload(new DiskFileItemFactory());
	
		String action=request.getParameter("action");
		switch(action)
		{
		
		case "dpupload":
				
		
		listImages(request,response);
		
		filesUpload(request,response);
		System.out.println(request.getContextPath()+"/ImageUpload?action=listingImages");
		response.sendRedirect(request.getContextPath()+"/ImageUpload?action=listingImages");
		//request.getRequestDispatcher("userProfileEditable.jsp").forward(request, response);
		
	System.out.println("inside dpuupload");
		
		break;
		
		case "Image":
			System.out.println("inside ImageUPload**********************************************************************************************************");
			
			
			filesPostImageUpload(request,response);
		
		
			response.sendRedirect(request.getContextPath()+"/ImageUpload?action=listingImages");
		
		
		break;
		
		
		
		
	case "dvup":
		System.out.println("inside ImageUPload**********************************************************************************************************");
		
		
		filesPostDVideoUpload(request,response);
	
	
		response.sendRedirect(request.getContextPath()+"/ImageUpload?action=listingImages");
	
	
	break;
	
	
	
	case "delete":
		
		
		
	String postToDelete= request.getParameter("image");
		List<Files> files= listfiles();
		
		
		
		
		
		for(Files file:files){
			if(file.getEmailUser().equals(emailOfUser)) {
					if(file.getFilename().equals(postToDelete)) {
					int id=file.getId();
					String email=file.getEmailUser();
					String imagename=file.getFilename();
					String fileType=file.getType();
					
					
					new FilesDAO().imageDeleted(new Files(id,email,imagename,fileType));
		
		
		
		
		
		

		
		
		
		
	
	}}}
		

		response.sendRedirect(request.getContextPath()+"/ImageUpload?action=listingImages");

		
		
		
		
		break;}
	
		
			
		
		
		
		
		
		
		
		
	}
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletFileUpload upload=new ServletFileUpload(new DiskFileItemFactory());
		
		String action="listingImages";
		switch(action)
		{
		case "listingImages":
			
			String flag="0";
			List<Files> files= listfiles();
			
			request.setAttribute("alldata", files);
			Cookie[] temp=request.getCookies();
			for(Cookie varia:temp) {
				String v= varia.getName();
				System.out.println("cookies received");
				System.out.println(v);
				if(v.equals("userin")) {
				emailOfUser	 =varia.getValue();
				request.setAttribute("emailOfUser", emailOfUser);
				
				}
			
			
			
			
			
			}
			for(Files file:files){
				System.out.println("inside Listingfiles");
				System.out.println(file.getEmailUser());
				System.out.println(emailOfUser);
				if(file.getEmailUser().equals(emailOfUser)) {
					
					if(file.getType().equals("d")) {
			System.out.println("inside if");
		request.setAttribute("files", file);
		flag="1";
					}	}}
			if(flag.equals("0")) {
				
		Files file=new Files("blog-4.jpg",emailOfUser,"d");
		new FilesDAO().addFileDetails(file);
		
			request.setAttribute("files", file);	
				
			}
			System.out.println("inside if1");
			
			
			
			
			
			
			
			
			
			
			
			 userno=request.getParameter("userNo");
			 request.setAttribute("emailOfUser", userno);
				
				System.out.println("parameterreceiver");
				System.out.println(userno);
				System.out.println("true condition");
				List<LoginData> databundle=new loginInfoDAO().existingUsers();
				for(LoginData data:databundle) {
					
				if( data.getEmail().equals(userno) ){
					Cookie[] temp1=request.getCookies();
					for(Cookie varia:temp1) {
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
				
				String flag1="0";
				String x="0";
				System.out.println("inside main ");
				System.out.println(copyingR2);
				System.out.println(x);
				System.out.println(flag1);
			if(copyingR2.equals(x)&& flag1.equals(x)) {	
				System.out.println("inside main ");
				new requestInfo().requestDeleted(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
				copyingR2=userno;
				new requestInfo().addRequest(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
				flag1="gotit";
			}
				
			if(copyingR3.equals(x)&& flag1.equals(x)) {	
				System.out.println("inside main ");
				new requestInfo().requestDeleted(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
				copyingR3=userno;
				new requestInfo().addRequest(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
				flag1="gotit";
			}	
				
			if(copyingR4.equals(x)&& flag1.equals(x)) {	
				System.out.println("inside main ");
				new requestInfo().requestDeleted(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
				copyingR4=userno;
				new requestInfo().addRequest(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
				flag1="gotit";
			}	
				
				
			if(copyingR5.equals(x)&& flag1.equals(x)) {	
				System.out.println("inside main ");
				new requestInfo().requestDeleted(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
				copyingR5=userno;
				new requestInfo().addRequest(new requestAcceptance(firstUserEmailStringId,copyingR1,copyingR2,copyingR3,copyingR4,copyingR5,copyingR6,copyingR7,copyingR8,copyingR9,copyingR10));
				flag1="gotit";
			}	
				
				
				
				
				
				
				
				
					}
				
				
				
						}		
							
						
								System.out.println("in2");
							
								System.out.println("in3");	
							//	requestAcceptance to= new requestAcceptance(3,"hello","hello","hello","hello","hello","hello","hello","hello","hello","hello");
								
							//	new requestInfo().requestRegistered(to);
									
									System.out.println("in4");		
									request.setAttribute("memberInformation", data);
							
			
			
			
			
			
			
			
			
		
				}}
			
			
			
			
			follower add=new follower(0,userno , firstUserEmailString);
			new followerDAO().addFollower(add);
			
			
			
			
			
			
	int followersNo=		noOfFollower(userno);
			
			
			
			request.setAttribute("showFollower",followersNo );
			
			
		
			
			
			request.getRequestDispatcher("afterSendRequestAndLearn.jsp").forward(request, response);
		
				
		break;
		
		case "getImage":
			
	
			 
			try{
				
				System.out.println("INSIDE jsp Try page  -");
		         String fileName = request.getParameter("image");
		         System.out.println(fileName);
		         FileInputStream fis = new FileInputStream(new File("C:/Users/Gaurav/Pictures/uploadedimages/resized/"+fileName));
		         System.out.println(fileName);
		         BufferedInputStream bis = new BufferedInputStream(fis);             
		         response.setContentType(getServletContext().getMimeType(fileName));
		         BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
		         for (int data; (data = bis.read()) > -1;) {
		           output.write(data);
		         }             
		      }
		      catch(IOException e){

		      }finally{
		          // close the streams
		      }
			
			
			
			
			break;
			
		case "delete":
			
			
			
			String postToDelete= request.getParameter("image");
				List<Files> files1= listfiles();
				
				
				
				
				
				for(Files file:files1){
					if(file.getEmailUser().equals(emailOfUser)) {
							if(file.getFilename().equals(postToDelete)) {
							int id=file.getId();
							String email=file.getEmailUser();
							String imagename=file.getFilename();
							String fileType=file.getType();
							
							
							new FilesDAO().imageDeleted(new Files(id,email,imagename,fileType));
				
				
				
				
				
				

				
				
				
				
			
			}}}
				

				response.sendRedirect(request.getContextPath()+"/ImageUpload?action=listingImages");

		
		}	
			
		
		
			
			
		
		
	}
		
		
		
		
		
		
		
		
	

	private void listImages(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		List<Files> files= listfiles();

		Cookie[] temp=request.getCookies();
		for(Cookie varia:temp) {
			String v= varia.getName();
			System.out.println("cookies received");
			System.out.println(v);
			if(v.equals("userin")) {
			emailOfUser	 =varia.getValue();
			
			}
		
		
		
		
		
		}
		
		for(Files file:files){
			if(file.getEmailUser().equals(emailOfUser)) {
					if(file.getType().equals("d")) {
					int id=file.getId();
					String email=file.getEmailUser();
					String imagename=file.getFilename();
					String fileType=file.getType();
					
					
					new FilesDAO().imageDeleted(new Files(id,email,imagename,fileType));
					
					
					
					
	
		
		}
		}
	
		// TODO Auto-generated method stub
		
	}}


	protected void filesUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletFileUpload upload=new ServletFileUpload(new DiskFileItemFactory());
		
		try {
			List<FileItem> images=upload.parseRequest(request);
			
			
			Cookie[] temp=request.getCookies();
			for(Cookie varia:temp) {
				String v= varia.getName();
				System.out.println("cookies received");
				System.out.println(v);
				if(v.equals("userin")) {
				emailOfUser	 =varia.getValue();
				
				}
			
			
			
			
			
			}
			for(FileItem image:images){
				String onlyname=image.getName();
				onlyname.lastIndexOf("\\");
				
				onlyname=onlyname.substring(onlyname.lastIndexOf("\\")+1);
				System.out.println("filesupload");
				System.out.println(onlyname);
				new FilesDAO().addFileDetails(new Files(onlyname,emailOfUser, "d" ));
				image.write(new File("C:/Users/Gaurav/Pictures/uploadedimages/"+onlyname));
				
				String   inputImagePath="C:/Users/Gaurav/Pictures/uploadedimages/"+onlyname;
				String     outputImagePath1="C:/Users/Gaurav/Pictures/uploadedimages/resized/"+onlyname;
				 imageResizer.resize(inputImagePath, outputImagePath1, 600, 600);
				
					List<Files> files= listfiles();
			

			 
				
	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
			
			
			
			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	protected void filesPostImageUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletFileUpload upload=new ServletFileUpload(new DiskFileItemFactory());
		
		try {
			List<FileItem> images=upload.parseRequest(request);
			
			
			Cookie[] temp=request.getCookies();
			for(Cookie varia:temp) {
				String v= varia.getName();
				System.out.println("cookies received");
				System.out.println(v);
				if(v.equals("userin")) {
				emailOfUser	 =varia.getValue();
				
				}
			
			
			
			
			
			}
			for(FileItem image:images){
				String onlyname=image.getName();
				onlyname.lastIndexOf("\\");
				
				onlyname=onlyname.substring(onlyname.lastIndexOf("\\")+1);
				System.out.println("filesupload");
				System.out.println(onlyname);
				new FilesDAO().addFileDetails(new Files(onlyname,emailOfUser, "p" ));
				image.write(new File("C:/Users/Gaurav/Pictures/uploadedimages/"+onlyname));
				
				String   inputImagePath="C:/Users/Gaurav/Pictures/uploadedimages/"+onlyname;
				String     outputImagePath1="C:/Users/Gaurav/Pictures/uploadedimages/resized/"+onlyname;
				 imageResizer.resize(inputImagePath, outputImagePath1, 600, 600);
				
					List<Files> files= listfiles();
			

			 
				
	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
			
			
			
			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	

	protected void filesPostDVideoUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletFileUpload upload=new ServletFileUpload(new DiskFileItemFactory());
		
		try {
			List<FileItem> images=upload.parseRequest(request);
			
			
			Cookie[] temp=request.getCookies();
			for(Cookie varia:temp) {
				String v= varia.getName();
				System.out.println("cookies received");
				System.out.println(v);
				if(v.equals("userin")) {
				emailOfUser	 =varia.getValue();
				
				}
			
			
			
			
			
			}
			for(FileItem image:images){
				String onlyname=image.getName();
				onlyname.lastIndexOf("\\");
				
				onlyname=onlyname.substring(onlyname.lastIndexOf("\\")+1);
				System.out.println("filesupload");
				System.out.println(onlyname);
				new FilesDAO().addFileDetails(new Files(onlyname,emailOfUser, "dv" ));
				image.write(new File("C:/Users/Gaurav/Pictures/uploadedimages/resized/"+onlyname));
				
		//		String   inputImagePath="C:/Users/Gaurav/Pictures/uploadedimages/"+onlyname;
		//		String     outputImagePath1="C:/Users/Gaurav/Pictures/uploadedimages/resized/"+onlyname;
		//		 imageResizer.resize(inputImagePath, outputImagePath1, 600, 600);
				
					List<Files> files= listfiles();
			

			 
				
	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
			
			
			
			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	public int noOfFollower(String emailbyuser) {
		int count=0;
	List<follower> data=	new followerDAO().existingUsers();
	
	for(follower x:data) {
		if(x.getFirstPerson().equals(emailbyuser))
		
		{
			count++;
		
		
		}
		
	}
	
	
		
		return count;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public  List<Files> listfiles(){

		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Files.class).buildSessionFactory();
Session session = factory.getCurrentSession();
session.beginTransaction();
List<Files> files=session.createQuery("from files").getResultList();

return files;
}
	
	}
		

