/**
 * 
 */
package com.lti.services;

/**
 * @author 003OQX744
 *
 */
public interface UserInterface {
	public void portal();
	public void newuser();
	public Boolean ChangePassword();
	public Boolean IsLoginSuccessful(int iUserType);
}
