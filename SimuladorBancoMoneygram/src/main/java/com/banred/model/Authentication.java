package com.banred.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class Authentication.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = Authentication.AUTH_NS)
public class Authentication {
	
	/** The Constant AUTH_NS. */
	public static final String AUTH_NS = "http://www.Moneycom.ec/";

	/** The User name. */
	@XmlElement(namespace = AUTH_NS)
	private String UserName;
	
	/** The Password. */
	@XmlElement(namespace = AUTH_NS)
	private String Password;
	
	

	/**
	 * Instantiates a new authentication.
	 */
	public Authentication() {
	}

	/**
	 * Instantiates a new authentication.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public Authentication(String username, String password) {
		this.UserName = username;
		this.Password = password;
	}
	

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return UserName;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.UserName = username;
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
		this.Password = password;
	}

}
