/**
 * 
 */
package com.crs.ibm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.crs.ibm.bean.Student;
import com.crs.ibm.constant.SqlQueryConstant;
import com.crs.ibm.exception.NotRemoved;
import com.crs.ibm.utils.DButils;

/**
 * @author 003OQX744
 *
 */
public class StudentDaoService implements StudentDaoInterface
{
	Scanner s=new Scanner(System.in);

	 /**Method addstudents student registration
	  * @SqlQueryConstant is REGISTRATION_STUDENT
	  * 
	  */
	   
	public void addstudents()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{			   
			   
			conn = DButils.getConnection();
			   
			    
			      // Execute a query
			      System.out.println("\nCreating student...");
			      
			      stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_STUDENT);
			      
			      System.out.println("Enter studentid:");
			      int student_id=s.nextInt();
			      s.nextLine();
			      
			      System.out.println("Enter studentname:");
			      String student_name=s.nextLine();
			      
			      System.out.println("Enter address:");
			      String address=s.nextLine();
			      
			      System.out.println("Enter course_name:");
			      String course_name=s.nextLine();
			      
			      System.out.println("Enter Email:");
			      String email=s.nextLine();
			     
			      stmt.setInt(1, student_id);  
			      stmt.setString(2, student_name);
			      stmt.setString(3, address);
			      stmt.setString(4, course_name);
			      stmt.setString(5, email);
			      
			      stmt.executeUpdate();
			      
			      int rows = stmt.executeUpdate();
			      System.out.println("Rows impacted : " + rows );
			      
			      stmt.close();
			      conn.close();			      
			   }
		catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }
		catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }
		finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }
			      catch(SQLException se2){
			    	  se2.printStackTrace();
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }
			      catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
	}
	
	
	/**Method displaystudent show student table
	 * @SqlQueryConstant REGISTRATION_DISPLAYSTUDENT
	 */
	
	public void displaystudent()
	{
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DButils.getConnection();
			
			System.out.println("\nDisplaying enrolled students detail....");
		
			if(conn!=null)
			stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_DISPLAYSTUDENT);
			rs=stmt.executeQuery();
			System.out.println("");
			//Column Titles
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.format("%5s %10s %10s %10s %23s", "ID", "Name", "Address", "Course", "Email ID");
			System.out.println("\n-------------------------------------------------------------------------------------------");
			while(rs.next())
			{
				int student_id = rs.getInt("student_id");
				String student_name = rs.getString("student_name");
				String address = rs.getString("address");
				String course_name = rs.getString("course_name");
				String email = rs.getString("email");
				System.out.format("%5s %10s %10s %10s %23s", student_id, student_name, address, course_name, email);
				System.out.println();
			}
			System.out.println("-------------------------------------------------------------------------------------------");
		}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }
	catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
	  
	}
	
	/**Method Addcourse student register for course
	 *@SqlQueryConstant REGISTRATION_STUDENTCOURSE
	 */
	
	public void Addcourse() {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			conn = DButils.getConnection();
			
			 System.out.println("\nCreating courseregistration...");
			 
			 stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_STUDENTCOURSE);
			 
		 // student can add the course
		 System.out.println("\nStudent can add the course:");
		 System.out.println("Enter the course Id:");
		 int course_id=s.nextInt();
			s.nextLine();
		 System.out.println("Enter the course name:");
		 String course_name=s.nextLine();
		 
		 System.out.println("Enter the student Id:");
		 int student_id=s.nextInt();
			s.nextLine();
			
		 stmt.setInt(1,course_id);
		 stmt.setString(2, course_name);
		 stmt.setInt(3, student_id);
		 stmt.executeUpdate();
			
		 stmt.close();
	     conn.close();
		}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }
		      catch(SQLException se2){
		    	  se2.printStackTrace();
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }
		      catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		
	}
	
	/**Method deletecourse student delete register course
	 *@SqlQueryConstant  REGISTRATION_STUDENTDELETECOURSE
	 */
	
	public void deletecourse()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try{			   
		   
		conn = DButils.getConnection();
		  
		      // Execute a query
		      System.out.println("\nUpdating the Course...");
		      System.out.println("\nEnter the course id if you want to delete:");
		      
		      String sql = "";
		      int id = 0;				     
		     
		    	  id = s.nextInt();
		    	 
		    	  String DelCondition = "WHERE course_id=" + "'" + id + "'";
		    
		      stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_STUDENTDELETECOURSE + DelCondition);
		      stmt.executeUpdate();
		      
		      int rows = stmt.executeUpdate();
		      System.out.println("Rows impacted : " + rows );
		      {
		    	  
		      }
		      
		      stmt.close();
		      conn.close();			      
		   }
	
	catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }
	catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
	finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }
		      catch(SQLException se2){
		    	  se2.printStackTrace();
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }
		      catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
	}
	
	/**Method Payment student can pay fee of course
	 * @SqlQueryConstant REGISTRATION_PAYMENTS
	 */
	
	public void Payment()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			conn = DButils.getConnection();
			
			// System.out.println("\nCreating payment...");
			
			 stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_PAYMENTS);
			 
			 System.out.println("\nStudent can pay the fess of course:");
			 
			 System.out.println("Enter the payment mode\n 1: Credit card\n 2: Debit card\n 3: Cash \n 4: UPI");
			 int no = s.nextInt();
			 String payment_mode=s.nextLine();
			 if(1==no) {
				 payment_mode="Credit Card";
			 }
			 else if(2==no) 
			 {
				 payment_mode="Debit Card";
			 }
			 else if(3==no) {
				 payment_mode="Cash";
			 }
			 else if(4==no) {
				 payment_mode="UPI";
			 }
			 
			 long card_no = 0;
			 if(1==no || 2==no) 
			 {
				 System.out.println("Enter the Card No:");				 
				 card_no=s.nextLong();
				 s.nextLine();				 
			 }
			
			 System.out.println("Enter the student Id:");
			 int student_id=s.nextInt();
				s.nextLine();	
				
			 System.out.println("Enter the course Id:"); 
			 int course_id=s.nextInt();
				s.nextLine();
			 
			 System.out.println("Enter the Amount:");
			 int amount=s.nextInt();
				 s.nextLine();
			
			
			 stmt.setString(1,payment_mode);
			 stmt.setLong(2, card_no);
			 stmt.setInt(3, student_id);
			 stmt.setInt(4, course_id);
			 stmt.setInt(5, amount);
			 stmt.setString(6, null);
			 
			 stmt.executeUpdate();
			 
			 stmt.close();
	         conn.close(); 
			 
		}
	catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }
	      catch(SQLException se2){
	    	  se2.printStackTrace();
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }
	      catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	}
}
