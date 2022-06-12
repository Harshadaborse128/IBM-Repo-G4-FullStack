/**
 * 
 */
package com.ibm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.ibm.bean.Student;
import com.ibm.constant.SqlQueryConstant;
import com.ibm.utile.DButils;

/**
 * @author 003OQX744
 *
 */

@Repository
public class StudentDaoService implements StudentDaoInterface  
{
	
	Scanner s = new Scanner(System.in);
	private static List<Student> enrollStudent = new ArrayList<Student>();

	 /**Method addstudents student registration
	  * @SqlQueryConstant is REGISTRATION_STUDENT
	  * 
	  */
	
public List GetStudents()
{
	return enrollStudent;
}
	   
public void addstudents(int student_id, String student_name, String address, String course_name, String email)
{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{			   
			   
			conn = DButils.getConnection();
			   
			    
			      // Execute a query
			      System.out.println("\nCreating student...");
			      
			      stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_STUDENT);			     
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
 ** @SqlQueryConstant REGISTRATION_DISPLAYSTUDENT
 **/

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
				int student_id = (rs.getInt("student_id"));
				String student_name = (rs.getString("student_name"));
				String address = (rs.getString("address"));
				String course_name = (rs.getString("course_name"));
				String email = (rs.getString("email"));
				
				enrollStudent.add(new Student(student_id, student_name, address, course_name, email));
				
				System.out.format("%5s %10s %10s %10s %23s", student_id, student_name, address, course_name, email);
				System.out.println("");
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
 * *@SqlQueryConstant REGISTRATION_STUDENTCOURSE
 * */
	
public void Addcourse(int course_id, String course_name, int student_id)
{
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			conn = DButils.getConnection();
			
			 System.out.println("\nCreating courseregistration...");
			 
			 stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_STUDENTCOURSE);
			 
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
public void deletecourse(int course_id)
{
	Connection conn = null;
	PreparedStatement stmt = null;
	
	try{
		conn = DButils.getConnection();
		
		// Execute a query
		System.out.println("\nUpdating the Course...");
		String DelCondition = "WHERE course_id=" + "'" + course_id + "'";
		
		stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_STUDENTDELETECOURSE + DelCondition);
		int rows = stmt.executeUpdate();
		
		stmt.close();
		conn.close();
		System.out.println("Rows impacted : " + rows );
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
	
public void Payment(String payment_mode, long card_no, int student_id, int course_id, int amount)
{
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			conn = DButils.getConnection();
			
			 stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_PAYMENTS);
			 
			 System.out.println("\nStudent can pay the fess of course:");
			 		
			 stmt.setString(1, payment_mode);
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
