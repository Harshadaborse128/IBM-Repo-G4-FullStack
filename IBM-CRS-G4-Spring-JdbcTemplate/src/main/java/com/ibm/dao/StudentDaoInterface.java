/**
 * 
 */
package com.ibm.dao;

import java.util.List;

import com.ibm.bean.NewCourse;
import com.ibm.bean.Student;

/**
 * @author 003OQX744
 *
 */
public interface StudentDaoInterface {
	

	/**  This is the method to be used to initialize
	 * database resources ie. connection.
	 */
	
	public void addstudents(int student_id, String student_name, String address, String course_name, String email);
	
    public List<Student> liststudent();
    
    public void Addcourse(int course_id, String course_name, int student_id);
    
    public List<NewCourse> listsregistercourse();
    
    public void deletecourse(int course_id);
    
    public void Payment(String payment_mode, long card_no, int student_id, int course_id, int amount ,String admin_approval);
}
