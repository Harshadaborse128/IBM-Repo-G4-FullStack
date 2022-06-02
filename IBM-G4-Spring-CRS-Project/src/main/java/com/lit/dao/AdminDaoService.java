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
public class AdminDaoService implements AdminDaoInterface {
	
Scanner s=new Scanner(System.in);
	
	/** Method professor Admin assigning course to professor
	 *  Declared in AdminDaoInterfcace
	 *  @SqlQueryREGISTRATION_PROFESSOR 
	 */
	
	public void profesosr() 
	{
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try{			   
		   
		conn = DButils.getConnection();
		   
		    
		      // Execute a query
		      System.out.println("Creating professor...");
		     
		      stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_PROFESSOR);
		      
		      System.out.println("Enter professorid:");
		      int professor_id=s.nextInt();
		      s.nextLine();
		      
		      System.out.println("Enter professorname:");
		      String professor_name=s.nextLine();
		      
		      System.out.println("Enter address:");
		      String address=s.nextLine();
		      
		      System.out.println("Enter Email:");
		      String email=s.nextLine();
		      
		      System.out.println("Enter course_name:");
		      String course_name=s.nextLine();

		  //Bind values into the parameters.
		      stmt.setInt(1, professor_id);  // This would set age
		      stmt.setString(2, professor_name);
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
	
   /** Method Diplayprofessor show the professor Details
     * Declared in AdminDaoIntergac
     * @SqlQueryREGISTRATION_DISPLAYPROFESSOR
     */
	
	public void Displayprofessor()
	{
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DButils.getConnection();
			
			System.out.println("Displaying Professor detail....");
			
			if(conn!=null)
				stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_DISPLAYPROFESSOR);
			rs=stmt.executeQuery();
			System.out.println("");
			//Column Titles
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.format("%5s %10s %10s %10s %10s", "ID", "Name", "Address","CourseName","Email");
			System.out.println("\n-------------------------------------------------------------------------------------------");
			while(rs.next())
			{
				int professorid = rs.getInt("professor_id");
				String professorname = rs.getString("profesor_name");
				String address = rs.getString("adress");
				String coursename = rs.getString("course_name");
				String Email = rs.getString("email");
				System.out.format("%5s %10s %10s %10s %10s", professorid, professorname, address,coursename,Email);
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
	
	 /** Method course Admin can add coures 
	  * Declared In AdminDaoInterface
	  * @SqlQueryREGISTRATION_COURSE
	  */
	
	public void course()
	{
		
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try{			   
		   
		conn = DButils.getConnection();
		   
		    
		      // Execute a query
		      System.out.println("Creating Course...");
		     
		      stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_COURSE);
		      
		      System.out.println("Enter CourseId:");
		      int course_id=s.nextInt();
		      s.nextLine();
		      
		      System.out.println("Enter CourseName:");
		      String course_name=s.nextLine();

		      System.out.println("Enter CourseGrade:");
		      String course_grade=s.nextLine();
		      
		      System.out.println("Enter CourseType:");
		      String course_type=s.nextLine();
		      
		      System.out.println("Enter CourseStatus:");
		      String course_status=s.nextLine();
		      
		      System.out.println("Enter CourseFees:");
		      String course_fees=s.nextLine();

		  //Bind values into the parameters.
		      stmt.setInt(1, course_id);  // This would set age
		      stmt.setString(2, course_name);
		      stmt.setString(3, course_grade);
		      stmt.setString(4, course_type);
		      stmt.setString(5, course_status);
		      stmt.setString(6, course_fees);
		      
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
	
	/** Method student admin can give the approval to student course registation
	 * @SqlQuery Update
	 */
	
	public void student()
	{
		
		StudentDaoInterface sd=new StudentDaoService();
		 sd.displaystudent();
		 
		 
		    Connection conn = null;
			PreparedStatement stmt = null;
		
		 try{			   
			   
				conn = DButils.getConnection();
				   
				    
				      // Execute a query
				      System.out.println("Update in Payments ...");
				      System.out.println("Enter the id of students whose fee is paid separated by space:");
				      
				      String sql = "";
				      int id = 0;				      
				      //while(0 != s.nextInt())
				      {
				    	  id = s.nextInt();
				    	  sql="update payments SET admin_approval = 'paid' WHERE student_id='" + id + "'";
				      }
				     
				      stmt = conn.prepareStatement(sql);
				   
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
	
	/** Method dropcourse admin can delete course 
	 * @SqlQueryDelete
	 */
	
	public void dropcourse() 
	{
		
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try{			   
		   
		conn = DButils.getConnection();
		   
		    
		      // Execute a query
		      System.out.println("updating the Course...");
		      System.out.println("Enter the course id if you want to delete:");
		      
		      String sql = "";
		      int id = 0;				     
		     
		    	  id = s.nextInt();
		    	  sql="DELETE FROM course WHERE course_id='" + id + "'";
		    
		      stmt = conn.prepareStatement(sql);		      
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
	
	
	
	/**Method displaycourse display all course deatils
	 *@SqlQuery REGISTRATION_DISPLAYCOURSE
	 */
	
	public void displaycourse() 
	{
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DButils.getConnection();
			
			System.out.println("Displaying enrolled students detail....");
			
			if(conn!=null)
				stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_DISPLAYCOURSE);
			rs=stmt.executeQuery();
			System.out.println("");
			//Column Titles
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.format("%10s %15s %10s %15s %10s %10s", "CourseID", "Name", "Grade","Type","Status","Fees");
			System.out.println("\n-------------------------------------------------------------------------------------------");
			while(rs.next())
			{
				int course_id = rs.getInt("course_id");
				String course_name = rs.getString("course_name");
				String grade = rs.getString("course_grade");
				String type = rs.getString("course_type");
				String status = rs.getString("course_status");
				String fees = rs.getString("course_fees");
				
				System.out.format("%10s %15s %10s %15s %10s %10s", course_id, course_name, grade,type,status,fees);
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
	
   /**Method Admin_approval for user loging approval
   * @SqlQueryConstant GET_APPROVAL
   * @SqlQueryConstant SET_ADMIN_APPROVAL
   */
	
public void Admin_approval()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
	
		//int user_type = 0;
		//int fail = 0;
		try 
		{
			conn = DButils.getConnection();
			stmt = (PreparedStatement) conn.prepareStatement(SqlQueryConstant.GET_APPROVAL);
			ResultSet rs = stmt.executeQuery(SqlQueryConstant.GET_APPROVAL);
			
			System.out.println("\nEnter the user id for admin approval  ");
			String user_id=s.nextLine();
			
			
			while(rs.next()) {
				String user = rs.getString("user_id");
				int ap= rs.getInt("admin_approval");
				if(user_id.equals(user)) 
				{
					if(ap == 1)
					{
						System.out.println("user has already been approved");
						
						break;
						
					}
					stmt = (PreparedStatement) conn.prepareStatement(SqlQueryConstant.SET_ADMIN_APPROVAL + "'1' Where user_id='" + user_id + "'");	
				
					System.out.println("User "  + user + " has been approved by admin\n");
				}
			}
			stmt.execute();
			stmt.close();
			conn.close();
		}catch(SQLException se){
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


	/**Method Displaypayment see all payment deatails
	 * SqlQueryConstant SET_DISPLAYPAYMENT
	 */
	
	public void Displaypayment() 
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DButils.getConnection();
			
			System.out.println("\nDisplaying Enrolled Students Detail....");
		
			if(conn!=null)
			stmt = conn.prepareStatement(SqlQueryConstant.SET_DISPLAYPAYMENT);
			rs=stmt.executeQuery();
			System.out.println("");
			//Column Titles
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			System.out.format("%12s %10s %12s %10s %10s %15s", "Payment Mode", "Card No", "Student Id", "Course Id", "Amount","Admin Approval");
			System.out.println("\n-------------------------------------------------------------------------------------------------------------");
			while(rs.next())
			{
				String paymentmode = rs.getString("payment_mode");
				long cardno = rs.getInt("card_no");
				int studentid = rs.getInt("student_id");
				int courseid = rs.getInt("course_id");
				int amount = rs.getInt("amount");
				String fees = rs.getString("admin_approval");
				System.out.format("%12s %10s %12s %10s %10s %15s", paymentmode,   cardno  ,   studentid  ,  courseid   ,   amount    ,   fees   );
				System.out.println();
			}
			System.out.println("--------------------------------------------------------------------------------------------------------------");
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
	
	
	
	/**Method Displaynewuser viwe new register userlogin
	 * 
	 */
	
	
		public void Displaynewuser() 
			{
			
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				
				conn = DButils.getConnection();
				
				System.out.println("\nDisplaying New Register User detail....");
			
				if(conn!=null)
				stmt = conn.prepareStatement(SqlQueryConstant.SET_DISPLAYNEWUSER);
				rs=stmt.executeQuery();
				System.out.println("");
				//Column Titles
				System.out.println("--------------------------------------------------------------------------------------------------------------");
				System.out.format("%10s %10s %12s %10s ", "User Type", "User Id", "User Pass","Admin Approval");
				System.out.println("\n-------------------------------------------------------------------------------------------------------------");
				while(rs.next())
				{
					int usertype = rs.getInt("user_type");
					String userid = rs.getString("user_id");
					String userpass = rs.getString("user_pass");
					int admin = rs.getInt("admin_approval");
					System.out.format("%10s %10s %12s %10s ", usertype,  userid  , userpass  ,  admin   );
					System.out.println();
				}
				System.out.println("--------------------------------------------------------------------------------------------------------------");
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
