/**
 * 
 */
package com.ibm.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibm.constant.SqlQueryConstant;
import com.ibm.dao.AdminDaoInterface;
import com.ibm.dao.AdminDaoService;
import com.ibm.dao.StudentDaoInterface;
import com.ibm.dao.StudentDaoService;
import com.ibm.utile.DButils;

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
		ad.profesosr(0, null, null, null, null);
	}
	public void studreg()
	{
		// here admin can approve the student registration for courses
		ad.Displaypayment();
		System.out.println("Admin can approve the student registration for courses");
		ad.student(0);
	
	}
	public void courseadd()
	{
		//here admin can give the approval for student registration 
		ad.displaycourse();
		System.out.println("Admin can Add new course");
		ad.course(0, null, null, null, null, null);
	}
	public void courserem() 
	{
		//here admin can remove the courses in college portal
		System.out.println("Admin can remove the courses in college portal");
		ad.displaycourse();
		ad.dropcourse(0);
	}
	public void studapproval()
	{
		ad.Displaynewuser();
    	ad.Admin_approval(null);
	}
}
