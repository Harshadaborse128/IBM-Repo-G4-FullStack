/**
 * 
 */
package com.ibm.bean;

/**
 * @author 003OQX744
 *
 */
public class User {
	
	private int user_type;
	private String user_id;
	private String user_pass;
	private int admin_approval;
	
	
	public User(int user_type, String user_id, String user_pass, int admin_approval)
	{
		this.setUser_type(user_type);
		this.setUser_id(user_id);
		this.setUser_pass(user_pass);
		this.setAdmin_approval(admin_approval);
	}


	public int getUser_type() {
		return user_type;
	}


	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_pass() {
		return user_pass;
	}


	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}


	public int getAdmin_approval() {
		return admin_approval;
	}


	public void setAdmin_approval(int admin_approval) {
		this.admin_approval = admin_approval;
	}

}
