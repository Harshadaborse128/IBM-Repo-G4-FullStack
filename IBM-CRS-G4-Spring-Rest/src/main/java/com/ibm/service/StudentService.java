/**
 * 
 */
package com.ibm.service;

import java.util.Scanner;

import com.ibm.dao.AdminDaoInterface;
import com.ibm.dao.AdminDaoService;
import com.ibm.dao.ProfessorDaoInterface;
import com.ibm.dao.ProfessorDaoService;
import com.ibm.dao.StudentDaoInterface;
import com.ibm.dao.StudentDaoService;
import com.ibm.dao.UserDaoInterface;
import com.ibm.dao.UserDaoService;
import com.ibm.exception.UserNotFound;

/**
 * @author 003OQX744
 *
 */
public class StudentService implements StudentInterface {
	
	StudentDaoInterface sd = new StudentDaoService();
	AdminDaoInterface ad = new AdminDaoService();
	ProfessorDaoInterface pd = new ProfessorDaoService();
	
	 Scanner s=new Scanner(System.in);
	 //List<String> a= new ArrayList<String>();
	
public void coursereg()
{
	//student registration
	 //sd.addstudents();
	 sd.displaystudent();
		
}
public void grades()
{
	 // student can  view the grades
	ad.displaycourse();
	 System.out.println("student can  view the grades");

}

public void addcourse()
{
	//student can addcourse
	//sd.Addcourse();
}

public void dropcouse(int id)
{
	// student can drop the course 
	//sd.deletecourse(id);
	
}
public void fee()
{
	
	//sd.Payment(null, 0, 0, 0, 0);
	 
}
public void examschedule()
{
	//student can view exam details
	 pd.Displayexam();
}
public void resultstatus() {
	pd.Displayresult();
	
}
	

}
