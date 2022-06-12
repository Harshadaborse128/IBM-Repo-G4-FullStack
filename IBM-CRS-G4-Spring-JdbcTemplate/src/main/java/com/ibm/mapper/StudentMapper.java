/**
 * 
 */
package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.ibm.bean.Student;

/**r
 * @author 003OQX744
 *
 */
public class StudentMapper  implements RowMapper<Student>{
	
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Student student = new Student();
		student.setStud_id(rs.getInt("student_id"));;
		student.setStud_name(rs.getString("student_name"));;
		student.setAddress(rs.getString("address"));
		student.setStud_course(rs.getString("course_name"));
		student.setStud_email(rs.getString("email"));
		return student;
	}

}
