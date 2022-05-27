/**
 * 
 */
package com.crs.ibm.application;


import java.util.Scanner;

import com.crs.ibm.bean.Student;
import com.crs.ibm.dao.AdminDaoInterface;
import com.crs.ibm.dao.AdminDaoService;
import com.crs.ibm.dao.StudentDaoService;
import com.crs.ibm.dao.UserDaoInterface;
import com.crs.ibm.dao.UserDaoService;
import com.crs.ibm.exception.UserNotFound;

import cob.crs.ibm.service.AdminInterface;
import cob.crs.ibm.service.AdminService;
import cob.crs.ibm.service.ProfessorInterface;
import cob.crs.ibm.service.ProfessorService;
import cob.crs.ibm.service.StudentInterface;
import cob.crs.ibm.service.StudentService;
import cob.crs.ibm.service.UserInterface;
import cob.crs.ibm.service.UserService;

/**
 * @author 003OQX744
 *
 */

/** Main method CRSApplication
 * @param args String[]
 * class UserInterface, UserService
 * class AdminInterfac, AdminService
 * class ProfessorInterface, ProfessorService
 * class UserDaoInterface , UserDaoService
 * class AdminDaoInterface, AdminDaoService
 */

public class CRSApplication 
{
	  
	public static void main(String args[])
	{
	
		UserInterface u=new UserService();
	AdminInterface a=new AdminService();
	ProfessorInterface p=new ProfessorService();
	StudentInterface s=new StudentService();
	UserDaoInterface UserItf = new UserDaoService();
	AdminDaoInterface ad = new AdminDaoService();
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("\n Welcome to CRS Application");
	
	while(true)
	{
	System.out.println("1: Login  ");
	System.out.println("2: New Registration");
	System.out.println("3: Change the Password");
	System.out.println("4: Exit");
	int l=sc.nextInt();
	sc.nextLine();
	
   switch(l)
   {
   case 1: 
	   //u.portal();
		
	   break;
	   
   case 2:
	   u.newuser();
	    break;
	    
   case 3:
	   System.out.println("Enter the user type:");
	   int iUser_Type=sc.nextInt();
	   sc.nextLine();
	   
	   System.out.println("Enter the user id:");
	   String iUser_id=sc.nextLine();
	   
	   System.out.println("Enter the user pass:");
	   String iPassword=sc.nextLine();
	   
	   	Boolean IsSuccessful = UserItf.ChangePassword( iUser_Type, iUser_id, iPassword);
	   	if(false == IsSuccessful)
	   		continue;
	   //System.out.println("\nSuccessfully change the password...");
	    break;
	    
   case 4:
	   System.out.println("\nYou are exiting from CRS Application ");
	   System.exit(l);
	   break;
	   
   default:
	   System.out.println("\nChoose the valid option.");
   }
   
	System.out.println("\nChoose the profession:");
	System.out.println("1: Student");
	System.out.println("2: Professor");
	System.out.println("3: Admin");
	//int ou;
	//ou=v;
	int ou=sc.nextInt();
	sc.nextLine();
	Boolean IsLoginSucc = false;
	
	while(false == IsLoginSucc) {
	System.out.println("Please Enter Your UserId:");
	String user_id = sc.nextLine();
	
	System.out.println("Please Enter Your Password:");
	String user_pass = sc.nextLine();
	IsLoginSucc = UserItf.IsLoginSuccessful(ou, user_id, user_pass);
	
	if(false == IsLoginSucc)
	{
		System.out.println("Press 1 to retry login");
		int value = sc.nextInt();
		sc.nextLine();
		if(1 == value)
			System.out.println("\nPlease check and re-Enter user_id and password.");
		else
			break;
	}
	
	}
	
	if(IsLoginSucc)
	{
	switch(ou) 
	{
	case 1:
	       int k=0;
	       while(k==0)
	       {
	    	   System.out.println("\n******Welcome to Student Menu*******");			   
		       System.out.println("\nChoose the following option:");
		       System.out.println("\n1: Student registration for Course:");
		       System.out.println("\n2: Student can view the available course:");
		       System.out.println("\n3: Student Add Course:");
		       System.out.println("\n4: Student Drop the course:");
               System.out.println("\n5: Student can payment here for course:");
               System.out.println("\n6: Student can view the exam details:");
               System.out.println("\n7: Student can view the result:");
		       int f=sc.nextInt();
	       switch(f)
	       {
	       
	       case 1: // student can register for course  
	    	   s.coursereg();
	    	   System.out.println("\nStudent registration Successfully");
	    	   break;
	    	   
	       case 2: // student can  view the grades
	    	   s.grades();
	    	   System.out.println("\nView course gread Successfully");
	    	   break;
	    	   
	       case 3:// student can add the course 
	    	   s.addcourse();
	    	   System.out.println("\nCourse Added Successfully");
	    	   break;
	    	  
	       case 4: // student can drop the course 
	    	   s.dropcouse(2);
	    	   System.out.println("\nCourse deleted Successfully:");
	    	   break;
	    	   
	       case 5://student can payment fee
	    	   s.grades();
	    	   s.fee();
	    	   System.out.println("\nFee Payment Successfully:");
	    	   break;
	    	   
	       case 6://student can view the exam details
	    	   s.examschedule();
	    	   System.out.println("\nView exam Detail Successfully:");
	    	   break;
	    	   
	       case 7://student can view the result
	    	   s.resultstatus();
	    	   System.out.println("\nView result Successfully:");
	    	   break;
	    	   
	       default:
	    	   System.out.println("\nChoose the valid section");
	    	   break;
	       }
	       
	       System.out.println("Press 0 Go to students menu or 1 to exit.");
	       k=sc.nextInt();	       
	       }
	       
	   break;
	   
	case 2:int i=0;
	       while(i==0)
	       {
		   System.out.println("\n**********Welcome to professor Menu*************");		
		   System.out.println("\nChoose the following option:");
	       System.out.println("\n1: Professor View the details : ");
	       System.out.println("\n2: Professor Enrollment the student for exam : ");
	       System.out.println("\n3: Report genration for students:");
	       int g=sc.nextInt();
	       switch(g)
	       {
	       case 1:// Here proffesor can add a view the details
	    	   p.View();
	    	   System.out.println("\nView Details Successfully:");
	       break;
	       case 2:// Here professor can check the student enrollment of course
	    	   p.studentenroll();
	    	   System.out.println("\nEnrollment Successfully:");
	       break;
	       case 3:
	    	   System.out.println("\nReport Generated Successfully:");
	    	   p.report();
	    	  break;
	       default:
	    	   System.out.println("\nChoose the valid selection:");
	    	   break;
	       }
	       System.out.println("Press 0 Go to professor menu:");
	       i=sc.nextInt();
	       }
	       
	       break;
	    
	 case 3:int c=0;
	        while(c==0)
	        {
		    System.out.println("\n*********Welcome to Admin menu************");		
		    System.out.println("\nChoose the require details:");
            System.out.println("\n1: Adding professor course and details:");
            System.out.println("\n2: Approving student registration:");
            System.out.println("\n3: Adding course in college portal:");
            System.out.println("\n4: Removing the courses from the portal:");
            System.out.println("\n5: Admin can give approval to userlogin:");
            int h=sc.nextInt();
            switch(h)
            {
            case 1:// here admin can add the professor to the particular courses
            	a.addprof();
            	System.out.println("\nProfessor added for the course Successfully:");
            break;
            case 2:// here admin can approve the student registration for courses
            	a.studreg();
            	System.out.println("\nStudent Approval Successfully:");
            break;
            case 3://here admin can add the new courses in college portal
            	a.courseadd();
            	System.out.println("\nCourse Added Successfully:");
            break;
            case 4://here admin can remove the courses in college portal
            	a.courserem();
            	System.out.println("\nCourse Deleted Sucessfully:");
            break;
            case 5:
            	ad.Displaynewuser();
            	ad.Admin_approval();
            	System.out.println("\nApproval succesful");
            default:
            	System.out.println("\nChoose the valid selection:");
                break;
            }
            System.out.println("Press 0 Go to admin menu:");
            c=sc.nextInt();
	        }	
	        
	        break;
	}
	}
	}
}
}

