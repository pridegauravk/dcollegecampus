package org.studyeasy;

import java.io.File;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.*;
import static java.lang.String.format;
import static java.util.logging.Level.FINE;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MediaFileServlet
 */
@WebServlet("/media")
public class MediaFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	 private File folder;

	    @Override
	    public void init() throws ServletException {
	        folder = new File("C:/Users/Gaurav/Music/FlexStart/assets/img/blog");
	    }
	   
	  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * @see HttpServlet#HttpServlet()
     */
    public MediaFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("returning4");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
	getFile(request);
		
		
	System.out.println("returning3");	
		
		

		
		
		
		
		
		
		
		
		
		
	}
	
	  protected File getFile(HttpServletRequest request) {  
		  
		  System.out.println("returning1");
		  
	        String pathInfo = request.getPathInfo();

	        if (pathInfo == null || pathInfo.isEmpty() || "/".equals(pathInfo)) {
	            throw new IllegalArgumentException();
	        }
System.out.println("returning");
	        return new File(folder, pathInfo);
	        
	        
	        
	        
	        
	        
	        
	    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
