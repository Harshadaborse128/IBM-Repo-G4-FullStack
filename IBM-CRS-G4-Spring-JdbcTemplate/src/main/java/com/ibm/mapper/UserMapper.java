/**
 * 
 */
package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.Student;
import com.ibm.bean.User;


/**
 * @author 003OQX744
 *
 */
public class UserMapper implements RowMapper<User>{
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		User user = new User();
		user.setUser_type(rs.getInt("user_type"));;
		user.setUser_id(rs.getString("user_id"));;
		user.setUser_pass(rs.getString("user_pass"));
		user.setAdmin_approval(rs.getInt("admin_approval"));
		return user;
	}


}
