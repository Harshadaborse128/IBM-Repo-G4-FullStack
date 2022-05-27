/**
 * 
 */
package cob.crs.ibm.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.crs.ibm.dao.AdminDaoInterface;
import com.crs.ibm.dao.AdminDaoService;
import com.crs.ibm.dao.ProfessorDaoInterface;
import com.crs.ibm.dao.ProfessorDaoService;
import com.crs.ibm.dao.StudentDaoInterface;
import com.crs.ibm.dao.StudentDaoService;
import com.crs.ibm.utils.DButils;

/**
 * @author 003OQX744
 *
 */
public class StudentService implements StudentInterface{
	
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
		

