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

import com.ibm.bean.Exam;
import com.ibm.bean.Result;
import com.ibm.configuration.JDBCConfiguration;
import com.ibm.mapper.ExamMapper;
import com.ibm.mapper.ResultMapper;


/**
 * @author 003OQX744
 *
 */

@Repository
public class ProfessorDaoService  implements ProfessorDaoInterface{
	
	Logger logger = LoggerFactory.getLogger(StudentDaoService.class);
	
	 @Autowired
	 JDBCConfiguration jdbcConfiguration;
	 
	 @Override
	 @Transactional
	 public void CreateExam(int student_id, String student_name, String course_name, String exam_approval) {
		 
		 String SQL = "insert into exam values(?,?,?,?)";
		 
		 jdbcConfiguration.jdbcTemplate().update( SQL, student_id, student_name, course_name, exam_approval);
		 System.out.println("Created Record ID = " + student_id + " Name = " + student_name +
				 " Coursename = " + course_name + " examapproval = " + exam_approval );
		 return;
	 }
	 
	 @Override
	 @Transactional
	 public List<Exam> listsExam()
	 {
		 String SQL = "Select * from exam";
		 List <Exam> exam = jdbcConfiguration.jdbcTemplate().query(SQL, new ExamMapper());
		 logger.debug("in debug");
		 return exam;
		 
	 }
	 
	 @Override
	 @Transactional
	 public void CreateResult(int student_id, String student_name, String course_name, String result) {
		 
		 String SQL = "insert into result values(?,?,?,?)";
		 
		 jdbcConfiguration.jdbcTemplate().update( SQL, student_id, student_name, course_name, result);
		 System.out.println("Created Record ID = " + student_id + " Name = " + student_name +
				 " Coursename = " + course_name + " result = " + result );
		 return;
		 
	 }
	 
	 @Override
	 @Transactional
	 public List<Result> listsResult()
	 {
		 String SQL = "Select * from result";
		 List <Result> result = jdbcConfiguration.jdbcTemplate().query(SQL, new ResultMapper());
		 logger.debug("in debug");
		 return result;
		 
	 }
	 
	 @Override
		public void updateresult(int student_id, String result) 
	 {
			// TODO Auto-generated method stub
			 String SQL = "update result set result = ? where student_id = ?";
			 jdbcConfiguration.jdbcTemplate().update(SQL, result, student_id);
		      System.out.println("Updated Record with ID = " + student_id );
		      return;

	 }
	 
	 @Override
		public void updateexam(int student_id, String exam_approval) 
	 {
			// TODO Auto-generated method stub
			 String SQL = "update exam set exam_approval = ? where student_id = ?";
			 jdbcConfiguration.jdbcTemplate().update(SQL, exam_approval, student_id);
		      System.out.println("Updated Record with ID = " + student_id );
		      return;

	 }
}
