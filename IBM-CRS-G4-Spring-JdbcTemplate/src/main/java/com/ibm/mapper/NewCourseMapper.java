/**
 * 
 */
package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.NewCourse;

/**
 * @author 003OQX744
 *
 */
public class NewCourseMapper implements RowMapper<NewCourse>{
	

	public NewCourse mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		NewCourse newCourse = new NewCourse();
		newCourse.setCourse_id(rs.getInt("course_id"));;
		newCourse.setCourse_name(rs.getString("course_name"));;
		newCourse.setStudent_id(rs.getInt("student_id"));
		return newCourse;
	}

}
