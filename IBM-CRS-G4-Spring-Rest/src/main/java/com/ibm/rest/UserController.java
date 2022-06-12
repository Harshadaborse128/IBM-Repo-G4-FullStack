/**
 * 
 */
package com.ibm.rest;

import java.util.Scanner;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dao.UserDaoService;

/**
 * @author 003OQX744
 *
 */
@RestController
public class UserController {
	
	@Autowired
	private UserDaoService userDaoSrv;
	private Scanner scanner = new Scanner(System.in);
	
	@RequestMapping(path = "/login/{user_type}/{user_id}/{user_pass}")
	@Produces(MediaType.APPLICATION_JSON)
	public String login(@PathVariable("user_type") int user_type, @PathVariable("user_id") String user_id, 
			@PathVariable("user_pass") String user_pass)
	{
		Boolean IsSucess = userDaoSrv.IsLoginSuccessful(user_type, user_id, user_pass);
		if(IsSucess)
			return "Login Successful..";
		return "Login Failed";
	}
	
	
	@RequestMapping(path = "/registration/{user_type}/{user_id}/{user_pass}")
	@Produces(MediaType.APPLICATION_JSON)
	public void newregistration(@PathVariable("user_type") int user_type, @PathVariable("user_id") String user_id, 
			@PathVariable("user_pass") String user_pass)
	{	
		userDaoSrv.registrationlogin(user_type, user_id, user_pass);
	}
	
	
	@RequestMapping(path = "/changepass/{user_type}/{user_id}/{user_pass}/{new_pass}")
	@Produces(MediaType.APPLICATION_JSON)
	public String changepassword(@PathVariable("user_type") int user_type, @PathVariable("user_id") String user_id, 
			@PathVariable("new_pass") String new_pass, @PathVariable("user_pass") String user_pass)
	{
		Boolean IsSucess = userDaoSrv.ChangePassword(user_type, user_id, user_pass, new_pass);
		if(IsSucess)
			return "ChangePassword Successful..";
		return "ChangePassword Failed";
	}
}
