/**
 * 
 */
package com.ibm.exception;

/**
 * @author 003OQX744
 *
 */
public class PasswordMismatch  extends Exception{
	public PasswordMismatch() {
		super("Password Mismatch..");
	}
	public PasswordMismatch(String message) {
		super(message);
	}

}
