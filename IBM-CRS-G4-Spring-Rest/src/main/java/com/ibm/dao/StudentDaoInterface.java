/**
 * 
 */
package com.ibm.dao;

/**
 * @author 003OQX744
 *
 */
public interface StudentDaoInterface {
	
	public void addstudents(int student_id, String student_name, String address, String course_name, String email);
	public void displaystudent();
	public void Addcourse(int course_id, String course_name, int student_id);
	public void deletecourse(int course_id);
	public void Payment(String payment_mode, long card_no, int student_id, int course_id, int amount);


}
