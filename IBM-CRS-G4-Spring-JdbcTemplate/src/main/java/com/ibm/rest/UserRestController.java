/**
 * 
 */
package com.ibm.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dao.UserDaoService;

/**
 * @author 003OQX744
 *
 */
@RestController
@CrossOrigin
public class UserRestController {
	
	@Autowired
	UserDaoService userdaoservice;
	
	/**path="/user-login" User can login with register id and password 
	 * @param iUser_type
	 * @param iUser_id
	 * @param iPass
	 */
	
	@GetMapping(path="/user-login/{User_type}/{User_id}/{Password}")
	@Produces(MediaType.APPLICATION_JSON)
	public String login(@PathVariable("User_type")int iUser_type, @PathVariable("User_id") String iUser_id,
			@PathVariable("Password") String iPass)
	{
		Boolean IsSuccess = userdaoservice.IsLoginSuccessful(iUser_type, iUser_id, iPass);
		if(IsSuccess)
			return "Logged in successfully..";
		return "Log in failed.";
	}
	
	/**path="/user-registration" User can do Registration with user type , id and password 
	 * @param iUser_type
	 * @param iUser_id
	 * @param iPass
	 */
	
	@GetMapping(path="/user-registration/{usertype}/{userid}/{userpass}")
	@Produces(MediaType.APPLICATION_JSON)
	public void userregistration(@PathVariable("usertype")int user_type, @PathVariable("userid") String user_id,
			@PathVariable("userpass") String user_pass)
	{
		userdaoservice.registrationlogin(user_type, user_id, user_pass);
	}

	/**path="/changepass" User can Change the password 
	 * @param iUser_type
	 * @param iUser_id
	 * @param iPass
	 * @param newpass
	 */
	
	@GetMapping(path="/changepass/{User_type}/{User_id}/{Password}/{newpass}")
	@Produces(MediaType.APPLICATION_JSON)
	public String changepassword(@PathVariable("User_type")int iUser_type, @PathVariable("User_id") String iUser_id,
			@PathVariable("Password") String iPass, @PathVariable("newpass") String newpass)
	{
		Boolean IsSuccess = userdaoservice.ChangePassword(iUser_type, iUser_id, iPass, newpass);
		if(IsSuccess)
			return "ChangePassword in successfully....";
		return "ChangePassword failed....";
	}
	
}
