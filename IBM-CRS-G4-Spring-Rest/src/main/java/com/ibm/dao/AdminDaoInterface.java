/**
 * 
 */
package com.ibm.dao;

/**
 * @author 003OQX744
 *
 */
public interface AdminDaoInterface {
	
	public void profesosr(int professor_id, String professor_name, String address,  String course_name, String email) ;
	public void Displayprofessor();
	public void course(int course_id, String course_name, String course_grade, String course_type, String course_status, String course_fees);
	public void student(int Student_id);
	public void dropcourse(int course_id);
	public void displaycourse();
	public void Admin_approval(String user_id);
	public void Displaypayment() ;
	public void Displaynewuser() ;

}
