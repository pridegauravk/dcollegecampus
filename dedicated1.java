package org.studyeasy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dedicated1
 */
@WebServlet("/dedicated1")
public class dedicated1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dedicated1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("before");
		
		
		 
		 
		 
		try{
			
			System.out.println("INSIDE jsp Try page  -");
	         String fileName = "dvtest.mp4";
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
	
	
	
	
	
	
	
		 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
