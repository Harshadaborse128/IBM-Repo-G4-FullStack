/**
 * 
 */
package com.ibm.exception;

/**
 * @author 003OQX744
 *
 */
public class UserNotFound extends Exception {
	public UserNotFound() {
		super("User not found.....");
	}
	public UserNotFound(String message) {
		super(message);
	}

}
