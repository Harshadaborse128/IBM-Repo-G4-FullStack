/**
 * 
 */
package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.Result;


/**
 * @author 003OQX744
 *
 */
public class ResultMapper implements RowMapper<Result>{
	
	@Override
	public Result mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Result result = new Result();
		result.setStudent_id(rs.getInt("student_id"));;
		result.setStudent_name(rs.getString("student_name"));;
		result.setCourse_name(rs.getString("course_name"));
		result.setResult(rs.getString("result"));
		return result;
	}

}
