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

package edu.wright.cs.fa15.ceg3120.concon.common.data;

/**
 * Class used for accessing database.
 * @author Cody Bensman
 */
public class Data {
	private Database db = new Database();
	
	
	/**
	 * No argument constructor.
	 */
	public Data() {}
	
	/**
	 * Creates a new home owner account in database.
	 */
	public void createHomeowner(UserAccount user) {
		
	}
	
	/**
	 * Returns information to a specific home owner account in the database.
	 * 
	 */
	public UserAccount getHomeowner(String id) {
		return null;
	}
	
	/**
	 * Creates a new contractor account in database.
	 */
	public void createContractor(UserAccount user) {
		
	}
	
	/**
	 * Returns information to a specific contractor account.
	 */
	public UserAccount getContractor(String id) {
		return null;
	}
	
	/**
	 * Creates a new job request in database.
	 */
	public void createJob(JobRequest job) {
		
	}
	
	/**
	 * Returns information for a specific job in the database.
	 */
	public JobRequest getJob(String id) {
		return null;
	}
	
	/**
	 * Creates a new review in database.
	 */
	public void createReview() {
		
	}
	
	/**
	 * Returns information for a specific review in the database.
	 */
	public Review getReview() {
		return null;
	}
	
	/**
	 * Receive de-serialized Send object from networking team.
	 */
	private void receive(Send send){
		
	}
}