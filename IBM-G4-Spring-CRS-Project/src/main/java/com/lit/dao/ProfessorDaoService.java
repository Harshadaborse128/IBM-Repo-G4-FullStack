/**
 * 
 */
package com.lit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibm.constant.SqlQueryConstant;
import com.lti.utile.DButils;

/**
 * @author 003OQX744
 *
 */
public class ProfessorDaoService  implements ProfessorDaoInterface{
Scanner s=new Scanner(System.in);
	
	
	AdminDaoInterface ad = new AdminDaoService ();
	
	public void details() 
	{
		
		ad.Displayprofessor();
	}
	
	/**Method Exam report for exam
	 * @SqlQueryConstant REGISTRATION_EXAM
	 */
	
	public void Exam()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{			   
			   
			conn = DButils.getConnection();
			   
			    
			      // Execute a query
			      System.out.println("\nProfessor creat Exam schedule..");
			     
			      stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_EXAM);
			      
			      System.out.println("Enter studentid:");
			      int student_id=s.nextInt();
			      s.nextLine();
			      
			      System.out.println("Enter studentname:");
			      String student_name=s.nextLine();
			      
			      System.out.println("Enter course_name:");
			      String course_name=s.nextLine();
			      
			      System.out.println("Enter Approval:");
			      String exam_approval=s.nextLine();
			    
			      //Bind values into the parameters.
			      stmt.setInt(1, student_id);  
			      stmt.setString(2, student_name);
			      stmt.setString(3, course_name);
			      stmt.setString(4, exam_approval);
			    
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
	
	/**Method Displayexam student check exam details
	 * @SqlQueryConstant REGISTRATION_DISPLAYEXAM
	 */
	
	public void Displayexam() 
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DButils.getConnection();
			
			System.out.println("\nDisplaying  Students Exam Details ....");
			
			if(conn!=null)
				stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_DISPLAYEXAM);
			rs=stmt.executeQuery();
			System.out.println("");
			//Column Titles
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.format("%5s %10s %15s %12s", "ID", "Name", "Course", "Exam approval");
			System.out.println("\n-------------------------------------------------------------------------------------------");
			while(rs.next())
			{
				int student_id = rs.getInt("student_id");
				String student_name = rs.getString("student_name");
				String course_name = rs.getString("course_name");
				String examapproval = rs.getString("exam_approval");
				
				System.out.format("%5s %10s %15s %12s ", student_id, student_name, course_name, examapproval );
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

	/**Method result for student result
	 * @SqlQueryConstant REGISTRATION_RESULT
	 */
	
	public void result()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{			   
			   
			conn = DButils.getConnection();
			   
			    
			      // Execute a query
			      System.out.println("\n Prpfessor Creating Student Result...");
			      
			      stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_RESULT);
			      
			      System.out.println("Enter studentid:");
			      int student_id=s.nextInt();
			      s.nextLine();
			      
			      System.out.println("Enter studentname:");
			      String student_name=s.nextLine();
			      
			      System.out.println("Enter course_name:");
			      String course_name=s.nextLine();
			      
			      System.out.println("Enter result:");
			      String result=s.nextLine();
			      

			     
			     
			      //Bind values into the parameters.
			      stmt.setInt(1, student_id);  // This would set age
			      stmt.setString(2, student_name);
			      stmt.setString(3, course_name);
			      stmt.setString(4, result);
			    
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
	
	/**Method Displayresult student check result
	 * @SqlQueryConstant REGISTRATION_DISPLAYRESULT
	 */
	
	public void Displayresult()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DButils.getConnection();
			
			System.out.println("\nDisplaying  students Result....");
			
			if(conn!=null)
				stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_DISPLAYRESULT);
			rs=stmt.executeQuery();
			System.out.println("");
			//Column Titles
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.format("%5s %10s %10s %10s", "ID", "Name", "Course", "result");
			System.out.println("\n-------------------------------------------------------------------------------------------");
			while(rs.next())
			{
				int student_id = rs.getInt("student_id");
				String student_name = rs.getString("student_name");
				String course_name = rs.getString("course_name");
				String Sresult = rs.getString("result");
				
				System.out.format("%5s %10s %10s %10s ", student_id, student_name, course_name,Sresult );
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

}
