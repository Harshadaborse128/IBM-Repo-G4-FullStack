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

import com.ibm.bean.NewCourse;
import com.ibm.bean.Student;
import com.ibm.configuration.JDBCConfiguration;
import com.ibm.mapper.NewCourseMapper;
import com.ibm.mapper.StudentMapper;

/**
 * @author 003OQX744
 *
 */
@Repository
public class StudentDaoService implements StudentDaoInterface{
	
	Logger logger = LoggerFactory.getLogger(StudentDaoService.class);
	
	
	// DI injection of JDBCTemplate
	/*
	 * * * @Autowired private JdbcTemplate jdbcTemplateObject;
     */

	
	 @Autowired
	 JDBCConfiguration jdbcConfiguration;
	 
	 @Override
	 @Transactional
	 public void addstudents(int student_id, String student_name, String address, String course_name, String email) 
	 {
		 
		 String SQL = "insert into student values(?,?,?,?,?)";
		 
		 jdbcConfiguration.jdbcTemplate().update( SQL, student_id, student_name, address, course_name, email);
		 System.out.println("Created Record ID = " + student_id + " Name = " + student_name + "Address = " + address +
				 " Coursename = " + course_name + " Email = " + email );
		 return;
	 }
	 
	 
	 @Override
	 @Transactional
	 public List<Student> liststudent()
	 {
		 String SQL = "Select * from student";
		 List <Student> student = jdbcConfiguration.jdbcTemplate().query(SQL, new StudentMapper());
		 logger.debug("in debug");
		 return student;
		 
	 }
	 
	 @Override
	 @Transactional
	 public void Addcourse(int course_id, String course_name, int student_id) 
	 {
		 String SQL = "insert into courseregistration values(?,?,?)";
		 
		 jdbcConfiguration.jdbcTemplate().update( SQL, course_id, course_name, student_id);
		 System.out.println("Created Record ID = " + course_id + " Name = " + course_name +" Coursename = " + student_id  );
		 return;
	 }
	 
	
	 @Transactional
	 public List<NewCourse> listsregistercourse()
	 {
		 String SQL = "Select * from courseregistration";
		 List <NewCourse> newCourse1 = jdbcConfiguration.jdbcTemplate().query(SQL, new NewCourseMapper());
		 logger.debug("in debug");
		 return newCourse1;		 
	 }
	 
	 
	 @Transactional
	 public void deletecourse(int course_id) {
		 String SQL = "delete from courseregistration where course_id = ?";
		 jdbcConfiguration.jdbcTemplate().update(SQL, course_id);
		 System.out.println("Deleted Record with ID = " + course_id );
		 return;
	 }
	 
	 
	 @Transactional
	 public void Payment(String payment_mode, long card_no, int student_id, int course_id, int amount, String admin_approval) {
		 
		 String SQL = "insert into payments values(?,?,?,?,?,?)";		 
		 jdbcConfiguration.jdbcTemplate().update(SQL, payment_mode, card_no, student_id, course_id, amount, admin_approval);
		 System.out.println("Created Record payment_mode = " + payment_mode + " card_no = " + card_no + "student_id = " + student_id +
				 " course_id = " + course_id + " amount = " + amount + " admin_approval = " + admin_approval);
	 }
	 
	 
	 
}
