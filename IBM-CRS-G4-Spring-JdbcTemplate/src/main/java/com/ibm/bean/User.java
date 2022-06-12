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
	
	@Override
	public String toString() {
		return "Student[user_type = "+ user_type +", user_id = "+ user_id +", user_pass = "+ user_pass +",admin_approval = " + admin_approval +"]";
	}



}
