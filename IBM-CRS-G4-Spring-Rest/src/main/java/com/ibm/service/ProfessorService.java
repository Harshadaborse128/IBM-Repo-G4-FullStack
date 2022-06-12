/**
 * 
 */
package com.ibm.service;

import java.util.Scanner;

import com.ibm.dao.ProfessorDaoInterface;
import com.ibm.dao.ProfessorDaoService;
import com.ibm.dao.StudentDaoInterface;
import com.ibm.dao.StudentDaoService;

/**
 * @author 003OQX744
 *
 */
public class ProfessorService implements ProfessorInterface{
	
	/**Method View professor see about all details
	 * Method studentenroll for student exam details
	 * Method report for student result
	 * @param args
	 */
	
	ProfessorDaoInterface pd = new ProfessorDaoService();
	StudentDaoInterface sd = new StudentDaoService();
	
	Scanner s=new Scanner(System.in);

	public void View()
	{
		pd.details();
	}
	public void studentenroll()
	{
		// Here professor can check the student details of course
	  sd.displaystudent();
	  //pd.Exam();
	}
	public void report() {
		pd.Displayexam();
		//pd.result();
	}



}
