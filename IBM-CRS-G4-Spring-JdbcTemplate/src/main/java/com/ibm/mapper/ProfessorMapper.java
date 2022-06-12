/**
 * 
 */
package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.Professor;
import com.ibm.bean.Student;

/**
 * @author 003OQX744
 *
 */
public class ProfessorMapper  implements RowMapper<Professor>{
	
	@Override
	public Professor mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Professor professor = new Professor();
		professor.setProfessorid(rs.getInt("professor_id"));;
		professor.setProfessorname(rs.getString("professor_name"));;
		professor.setAddress(rs.getString("address"));
		professor.setCoursename(rs.getString("course_name"));
		professor.setEmail(rs.getString("email"));
		return professor;
	}

}
