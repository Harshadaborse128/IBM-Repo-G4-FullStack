/**
 * 
 */
package com.ibm.dao;

import java.util.List;

import com.ibm.bean.Course;
import com.ibm.bean.Payment;
import com.ibm.bean.Professor;
import com.ibm.bean.User;

/**
 * @author 003OQX744
 *
 */
public interface AdminDaoInterface
{
	
	 public void profesosr(int professor_id, String professor_name, String address,  String course_name, String email);
	 
	 public void deleteprofessor(int professor_id);

	 public List<Professor> listprofessor();
	 
	 public void course(int course_id, String course_name, String course_grade, String course_type, String course_status, int course_fees);
	 
	 public List<Course> listcourse();
	 
	 public void UpdateStudPayment(int Student_id, String admin_approval);
	 
	 public List<Payment> listpayment();
	 
	 public void deletecourse(int course_id);
	 
	 public void AdminApprovalUser(String user_id,int admin_approval);
	 
	 public List<User> listuser();	

}
