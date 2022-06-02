package com.ibm.application;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.lit.dao.AdminDaoInterface;
import com.lit.dao.AdminDaoService;
import com.lit.dao.UserDaoInterface;
import com.lit.dao.UserDaoService;
import com.lti.configuration.AppConfig;
import com.lti.services.AdminInterface;
import com.lti.services.AdminService;
import com.lti.services.ProfessorInterface;
import com.lti.services.ProfessorService;
import com.lti.services.StudentInterface;
import com.lti.services.StudentService;
import com.lti.services.UserInterface;
import com.lti.services.UserService;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@Import(AppConfig.class)
public class LtiCrsSpringCoreProjectApplication {
	
	public static void main(String args[])
	{
		ApplicationContext context=SpringApplication.run(AppConfig.class);
		
	AdminInterface a = (AdminInterface)context.getBean("AdminBean");
	ProfessorInterface p = (ProfessorInterface) context.getBean("ProfessorBean");
	StudentInterface s = (StudentInterface) context.getBean("StudentBean");
	UserInterface u = (UserInterface) context.getBean("UserBean");	
	
	Scanner sc = new Scanner(System.in);
	PrintStream out = System.out;
	out.println("\n Welcome to CRS Application");
	
	while(true)
	{
	LocalDate localdate = LocalDate.now();
	LocalTime localtime = LocalTime.now();
	System.out.println("\nCurrent Date :" +localdate +"\tTime :\t" +localtime);
	
	System.out.println("\n1: Login  ");
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
	   Boolean IsSuccessful = u.ChangePassword();
	   if(false == IsSuccessful)
		   continue;
	   System.out.println("\nSuccessfully change the password...");
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

	int ou = sc.nextInt();
	sc.nextLine();
	Boolean IsLoginSucc = false;
	
	while(false == IsLoginSucc) {
	
	IsLoginSucc = u.IsLoginSuccessful(ou);
	
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
	       case 1:// Here professor can add a view the details
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
            	a.studapproval();
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
