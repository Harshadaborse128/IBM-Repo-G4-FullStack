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

import com.ibm.bean.Course;
import com.ibm.bean.Payment;
import com.ibm.bean.Professor;
import com.ibm.bean.Student;
import com.ibm.bean.User;
import com.ibm.constant.SqlQueryConstant;
import com.ibm.dao.StudentDaoInterface;
import com.ibm.dao.StudentDaoService;
import com.ibm.utile.DButils;

/**
 * @author 003OQX744
 *
 */
@Repository
public class AdminDaoService implements AdminDaoInterface {
	
Scanner s=new Scanner(System.in);

private static List<Professor> enrollprofessor = new ArrayList<Professor>();

private static List<Course> showcourse = new ArrayList<Course>();

private static List<User> showuser = new ArrayList<User>();

private static List<Payment> showpayment = new ArrayList<Payment>();



	public List GetProfessor() 
	{
		return enrollprofessor;
	}
	
	public List GetCourse() 
	{
		return  showcourse;
	}
	
	public List GetPayment() 
	{
		return showpayment;
	}
	
	public List GetUser()
	{
		return showuser;
	}
	
/** Method professor Admin assigning course to professor
*  Declared in AdminDaoInterfcace
*  @SqlQueryREGISTRATION_PROFESSOR 
*/
	
	
@SuppressWarnings("null")
public void profesosr(int professor_id, String professor_name, String address,  String course_name, String email) 
{
	Connection conn = null;
	PreparedStatement stmt = null;
	
	try{			   
		   
		conn = DButils.getConnection();
		System.out.println("Creating professor...");
		stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_PROFESSOR);
		
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
**/
	
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
				int professor_id = rs.getInt("professor_id");
				String professor_name = rs.getString("profesor_name");
				String address = rs.getString("adress");
				String course_name = rs.getString("course_name");
				String email = rs.getString("email");
				
				enrollprofessor.add(new Professor(professor_id, professor_name, address, course_name, email));
				
				
				
				System.out.format("%5s %10s %10s %10s %10s", professor_id, professor_name, address, course_name, email);
				System.out.println();
			}
			System.out.println("\n-------------------------------------------------------------------------------------------");
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
	
public void course(int course_id, String course_name, String course_grade, String course_type, String course_status, String course_fees)
{
	Connection conn = null;
	PreparedStatement stmt = null;
	
	try{			   
		   
		conn = DButils.getConnection();
		System.out.println("Creating Course...");
		stmt = conn.prepareStatement(SqlQueryConstant.REGISTRATION_COURSE);
		      
			  stmt.setInt(1, course_id);  
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
 * * @SqlQuery Update
*/
	
public void student(int Student_id)
{
		
		StudentDaoInterface sd=new StudentDaoService();
		 sd.displaystudent();
		 
		 
		    Connection conn = null;
			PreparedStatement stmt = null;		
		 try{
			 conn = DButils.getConnection();
			 
			 System.out.println("Update in Payments ...");
			 String sql="update payments SET admin_approval = 'paid' WHERE student_id='" + Student_id + "'";
			 
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
				}
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
	
public void dropcourse(int course_id) 	
{
	Connection conn = null;
	PreparedStatement stmt = null;
	
	try{			   
		   
		conn = DButils.getConnection();
		    // Execute a query
		      System.out.println("updating the Course...");
		      String sql="DELETE FROM course WHERE course_id='" + course_id + "'";
		    
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
 **/
	
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
				
				showcourse.add(new Course(course_id, course_name, grade, type, status, fees));
				
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
	
public void Admin_approval(String user_id)
{
		Connection conn = null;
		PreparedStatement stmt = null;
	
		try 
		{
			conn = DButils.getConnection();
			stmt = (PreparedStatement) conn.prepareStatement(SqlQueryConstant.GET_APPROVAL);
			ResultSet rs = stmt.executeQuery(SqlQueryConstant.GET_APPROVAL);
			
			/*System.out.println("\nEnter the user id for admin approval  ");
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
						
					}*/
					stmt = (PreparedStatement) conn.prepareStatement(SqlQueryConstant.SET_ADMIN_APPROVAL + "'1' Where user_id='" + user_id + "'");	
				
					System.out.println("User "  + user_id + " has been approved by admin\n");
			
			
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
				String payment_mode = rs.getString("payment_mode");
				long card_no = rs.getInt("card_no");
				int student_id = rs.getInt("student_id");
				int course_id = rs.getInt("course_id");
				int amount = rs.getInt("amount");
				String approval = rs.getString("admin_approval");
				
				showpayment.add(new Payment(payment_mode, card_no, student_id, course_id, amount, approval));
				
				System.out.format("%12s %10s %12s %10s %10s %15s", payment_mode,  card_no  ,  student_id  ,  course_id   , amount , approval   );
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
					int user_type = rs.getInt("user_type");
					String user_id = rs.getString("user_id");
					String user_pass = rs.getString("user_pass");
					int admin_approval = rs.getInt("admin_approval");
					
					showuser.add(new User(user_type, user_id, user_pass, admin_approval ));
					
					System.out.format("%10s %10s %12s %10s ", user_type,  user_id  , user_pass  ,  admin_approval   );
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
