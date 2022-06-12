/**
 * 
 */
package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.Exam;
import com.ibm.bean.Student;

/**
 * @author 003OQX744
 *
 */

public class ExamMapper implements RowMapper<Exam> {
	
	@Override
	public Exam mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Exam exam = new Exam();
		exam.setStudent_id(rs.getInt("student_id"));;
		exam.setStudent_name(rs.getString("student_name"));;
		exam.setCourse_name(rs.getString("course_name"));
		exam.setExam_approval(rs.getString("exam_approval"));
		return exam;
	}

}
