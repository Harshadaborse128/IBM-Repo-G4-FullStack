/**
 * 
 */
package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.Course;
import com.ibm.bean.Student;

/**
 * @author 003OQX744
 *
 */
public class CourseMapper  implements RowMapper<Course> {
	
	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Course course = new Course();
		course.setCours_id(rs.getInt("course_id"));;
		course.setCourse_name(rs.getString("course_name"));;
		course.setCourse_grade(rs.getString("course_grade"));
		course.setCourse_type(rs.getString("course_type"));
		course.setCourse_status(rs.getString("course_status"));
		course.setCourse_fees(rs.getInt("course_fees"));
		return course;
	}


}
