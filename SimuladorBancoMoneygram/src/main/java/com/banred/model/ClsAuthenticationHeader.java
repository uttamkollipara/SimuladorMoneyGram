package com.banred.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class ClsAuthenticationHeader.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = Authentication.AUTH_NS)
public class ClsAuthenticationHeader {
	
	/** The Constant AUTH_NS. */
	public static final String AUTH_NS = "http://www.Moneycom.com.ec/";

	/** The User name. */
	@XmlElement(namespace = AUTH_NS)
	private String UserName;
	
	/** The Password. */
	@XmlElement(namespace = AUTH_NS)
	private String Password;
	
	/**
	 * Instantiates a new cls authentication header.
	 */
	public ClsAuthenticationHeader() {
	}

	/**
	 * Instantiates a new cls authentication header.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public ClsAuthenticationHeader(String username, String password) {
		this.UserName = username;
		this.Password = password;
	}
	
	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return UserName;
	}
	
	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		Password = password;
	}
	

}
