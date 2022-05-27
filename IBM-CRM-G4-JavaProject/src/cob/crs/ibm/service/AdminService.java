/**
 * 
 */
package cob.crs.ibm.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.crs.ibm.dao.AdminDaoInterface;
import com.crs.ibm.dao.AdminDaoService;

/**
 * @author 003OQX744
 *
 */
public class AdminService implements AdminInterface {

	/**@class AdminDaoInterface
	 * @class AdminDaoService
	 */
	AdminDaoInterface ad = new AdminDaoService ();
	Scanner s=new Scanner(System.in);

	public void addprof()
	{
		// here admin can add the professor to the particular courses
		ad.Displayprofessor();
		System.out.println("\nAdmin can add the professor to the particular courses:");
		ad.profesosr();
	}
	public void studreg()
	{
		// here admin can approve the student registration for courses
		ad.Displaypayment();
		System.out.println("Admin can approve the student registration for courses");
		ad.student();
	
	}
	public void courseadd()
	{
		//here admin can give the approval for student registration 
		ad.displaycourse();
		System.out.println("Admin can Add new course");
		ad.course();
	}
	public void courserem() 
	{
		//here admin can remove the courses in college portal
		System.out.println("Admin can remove the courses in college portal");
		ad.displaycourse();
		ad.dropcourse();
	}
	
	
}
