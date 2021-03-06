/*
 * Copyright (C) 2015
 * 
 * 
 * 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package edu.wright.cs.fa15.ceg3120.concon.common.net.data;

import edu.wright.cs.fa15.ceg3120.concon.common.net.MessageHolder;
import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * LogonMessage is used to send the login info to the server.
 * @author Networking team
 * @version 1
 * 
 */
public class LoginData implements Serializable {
	private static final Logger LOG = LoggerFactory.getLogger(LoginData.class);

	private static final long serialVersionUID = -2279299798905393963L;
	private String username;
	private String password;

	/**
	 * Create login message.
	 * Default constructor required for java beans.
	 */
	public LoginData() {} // 

	/**
	 * Create login message. Passwords should be encrypted before
	 * adding to this class.
	 * @param username The user logging in.
	 * @param password The encrypted password string for the user. 
	 */
	public LoginData(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	/**
	 * This method is called when logging on to the server.
	 */
	@NetworkHandler(channel = "login")
	public static MessageHolder login(LoginData login) {
		LOG.trace("Logging in...");
		//TODO decrypt password then verify user and password with database and fetch user data
		// for now just return generic user data
		UserData user = new UserData(login.username, "junkuuid");
		return new MessageHolder("returnUserData", user);
	}

	/**
	 * Get user's name.
	 * @return user's name
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set user's name.
	 * @param username the user's name
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get the pass.
	 * @return the pass
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the pass.
	 * @param password the pass
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequest [username=" + username + "]";
	}
}
