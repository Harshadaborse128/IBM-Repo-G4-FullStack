/**
 * 
 */
package com.crs.ibm.constant;

/**
 * @author 003OQX744
 *
 */
public class SqlQueryConstant {
	/**
	 * Student Query
	 */
	public static final String REGISTRATION_STUDENT="insert into student values(?,?,?,?,?)";
	public static final String REGISTRATION_DISPLAYSTUDENT="Select * from student";
	public static final String REGISTRATION_STUDENTCOURSE="insert into courseregistration values(?,?,?)";
	public static final String REGISTRATION_STUDENTDELETECOURSE="DELETE FROM courseregistration ";
	public static final String REGISTRATION_PAYMENTS="insert into payments values(?,?,?,?,?,?)";
	
	
	/**
	 * User Query
	 */
	public static final String GET_NEW_USER="Select * from new_user";
	public static final String SET_ADMIN_APPROVAL="update new_user set admin_approval=";
	public static final String GET_APPROVAL="select user_id, admin_approval from new_user";
	public static final String SET_UPDATE_USER="update new_user set user_pass=";
	public static final String SET_INTO_NEW_USER="insert into new_user values(?,?,?,?)";
	public static final String SET_USER_LOGIN="insert into user values(?,?)";
	
	
	
	/**
	 * Admin Query
	 */
	public static final String REGISTRATION_PROFESSOR="insert into professor values(?,?,?,?,?)";
	public static final String REGISTRATION_DISPLAYPROFESSOR="Select * from professor";
	public static final String REGISTRATION_COURSE="insert into course values(?,?,?,?,?,?)";
	public static final String REGISTRATION_DISPLAYCOURSE="Select * from course";
	public static final String SET_DISPLAYPAYMENT="Select * from payments";
	public static final String SET_DISPLAYNEWUSER="Select * from new_user";
	
	/**
	 * Professor Query
	 */
	
	public static final String REGISTRATION_EXAM="insert into exam values(?,?,?,?)";
	public static final String REGISTRATION_DISPLAYEXAM="Select * from exam";
	public static final String REGISTRATION_RESULT="insert into result values(?,?,?,?)";
	public static final String REGISTRATION_DISPLAYRESULT= "Select * from result";
	
}
