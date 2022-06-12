/**
 * 
 */
package com.ibm.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.bean.Course;
import com.ibm.bean.Payment;
import com.ibm.bean.Professor;
import com.ibm.bean.Student;
import com.ibm.bean.User;
import com.ibm.configuration.JDBCConfiguration;
import com.ibm.mapper.CourseMapper;
import com.ibm.mapper.PaymentMapper;
import com.ibm.mapper.ProfessorMapper;
import com.ibm.mapper.StudentMapper;
import com.ibm.mapper.UserMapper;

/**
 * @author 003OQX744
 *
 */
@Repository
public class AdminDaoService implements AdminDaoInterface{
	
	Logger logger = LoggerFactory.getLogger(StudentDaoService.class);
	

	 @Autowired
	 JDBCConfiguration jdbcConfiguration;
	 
	
	 @Transactional
	 public void profesosr(int professor_id, String professor_name, String address,  String course_name, String email) 
	 {
		 String SQL = "insert into professor values(?,?,?,?,?)";
		 
		 jdbcConfiguration.jdbcTemplate().update( SQL, professor_id, professor_name, address, course_name, email);
		 System.out.println("Created Record ID = " + professor_id + " Name = " + professor_name + "Address = " + address +
				 " Coursename = " + course_name + " Email = " + email );
		 return;
	 }
	 
	 @Override
	 @Transactional
	 public void deleteprofessor(int professor_id) 
	 {
		 String SQL = "delete from professor where professor_id = ?";
		 jdbcConfiguration.jdbcTemplate().update(SQL, professor_id);
		 System.out.println("Deleted Record with ID = " + professor_id );
		 return;
	 }
	 
	 
	 @Override
	 @Transactional
	 public List<Professor> listprofessor()
	 {
		 String SQL = "Select * from professor";
		 List <Professor> professor = jdbcConfiguration.jdbcTemplate().query(SQL, new ProfessorMapper());
		 logger.debug("in debug");
		 return professor;
		 
	 }
	 
	 @Override
	 @Transactional
	 public void course(int course_id, String course_name, String course_grade, String course_type, String course_status, int course_fees)
	 {
		 String SQL = "insert into course values(?,?,?,?,?,?)";
		 
		 jdbcConfiguration.jdbcTemplate().update( SQL, course_id, course_name, course_grade, course_type, course_status, course_fees);
		 System.out.println("Created Record ID = " + course_id + " Name = " + course_name + "coursegrade = " + course_grade +
				 " coursetype = " + course_type + " coursestatus = " + course_status + "coursefees = " + course_fees);
		 return;

	 }
	 
	 @Override
	 @Transactional
	 public List<Course> listcourse()
	 {
		 String SQL = "Select * from course";
		 List <Course> course = jdbcConfiguration.jdbcTemplate().query(SQL, new CourseMapper());
		 logger.debug("in debug");
		 return course;
		 
	 }
	 
	 @Override
	 @Transactional
	 public void deletecourse(int course_id) 
	 {
		 String SQL = "delete from course where course_id = ?";
		 jdbcConfiguration.jdbcTemplate().update(SQL, course_id);
		 System.out.println("Deleted Record with ID = " + course_id );
		 return;
	 }
	 
	 @Override
	 @Transactional
	 public void UpdateStudPayment(int Student_id, String admin_approval )
	 {
		 String SQL="update payments SET admin_approval = ? WHERE student_id=?";
		 jdbcConfiguration.jdbcTemplate().update(SQL, admin_approval, Student_id);
	      System.out.println("Updated Record with ID = " + Student_id );
	      return;
	 }
	 
	 
	 @Override
	 @Transactional
	 public List<Payment> listpayment()
	 {
		 String SQL = "Select * from payments";
		 List <Payment> payment = jdbcConfiguration.jdbcTemplate().query(SQL, new PaymentMapper());
		 logger.debug("in debug");
		 return payment;
		 
	 }
	 
	 
	 @Override
	 @Transactional
	 public void AdminApprovalUser(String user_id ,int admin_approval)
	 {
		 String SQL="update new_user SET admin_approval = ? WHERE user_id=?";
		 jdbcConfiguration.jdbcTemplate().update(SQL, admin_approval, user_id);
		 System.out.println("Updated Record with ID = " + user_id );
		 return;		 
	 }
	 
	 
	 @Transactional
	 public List<User> listuser()
	 {
		 String SQL = "Select * from new_user";
		 List <User> user = jdbcConfiguration.jdbcTemplate().query(SQL, new UserMapper());
		 logger.debug("in debug");
		 return user;
		 
	 }
	 


}
