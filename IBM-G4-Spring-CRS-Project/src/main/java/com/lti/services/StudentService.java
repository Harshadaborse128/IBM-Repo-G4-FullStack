/**
 * 
 */
package com.lti.services;

import java.util.Scanner;

import com.lit.dao.AdminDaoInterface;
import com.lit.dao.AdminDaoService;
import com.lit.dao.ProfessorDaoInterface;
import com.lit.dao.ProfessorDaoService;
import com.lit.dao.StudentDaoInterface;
import com.lit.dao.StudentDaoService;

/**
 * @author 003OQX744
 *
 */
public class StudentService implements StudentInterface 
{
	StudentDaoInterface sd = new StudentDaoService();
	AdminDaoInterface ad = new AdminDaoService();
	ProfessorDaoInterface pd = new ProfessorDaoService();
	
	 Scanner s=new Scanner(System.in);
	 //List<String> a= new ArrayList<String>();
	
public void coursereg()
{
	//student registration
	 sd.addstudents();
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
	sd.Addcourse();
}

public void dropcouse(int id)
{
	// student can drop the course 
	sd.deletecourse();
	
}
public void fee()
{
	
	sd.Payment();
	 
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
