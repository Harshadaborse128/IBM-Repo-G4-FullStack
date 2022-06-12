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

import com.ibm.bean.User;
import com.ibm.configuration.JDBCConfiguration;
import com.ibm.mapper.UserMapper;

/**
 * @author 003OQX744
 *
 */
@Repository
public class UserDaoService implements UserDaoInterface {
	
	Logger logger = LoggerFactory.getLogger(StudentDaoService.class);
	
	@Autowired
	JDBCConfiguration jdbcConfiguration;
	
	
	@Transactional
	public Boolean IsLoginSuccessful(int iUser_type, String iUser_id,String iPassword) {
		
		String SQL = "update new_user set admin_approval='1' where user_type = ? AND User_id = ? AND user_pass = ? AND admin_approval='1'";
		int nRow = jdbcConfiguration.jdbcTemplate().update(SQL, iUser_type, iUser_id, iPassword);
		logger.debug("in debug");
		if(nRow > 0)
			return true;
		return false;
	}
	
	
	@Transactional
	public void registrationlogin(int user_type, String user_id, String user_pass) 
	{
		String SQL = "insert into new_user values(?,?,?,?)";
		jdbcConfiguration.jdbcTemplate().update(SQL, user_type, user_id, user_pass, 0);
		System.out.println("Created Record Type = " + user_type + " Id = " + user_id + "Password = " + user_pass +"adminapproval = 0");
		return;
		
	}
	
	
	@Transactional
	public Boolean ChangePassword(int iUser_Type, String iUser_id, String iPassword, String new_pass)
	{
		String SQL = "update new_user set user_pass = ? where user_type = ? AND User_id = ? AND user_pass = ?";
		int nRow = jdbcConfiguration.jdbcTemplate().update(SQL, new_pass, iUser_Type, iUser_id, iPassword);
		logger.debug("in debug");
		if(nRow > 0)
			return true;
		return false;
	}
}
