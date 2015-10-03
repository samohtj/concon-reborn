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

package edu.wright.cs.fa15.ceg3120.concon.client.customer;

import edu.wright.cs.fa15.ceg3120.concon.common.net.ConConClient;
import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkManager;
import edu.wright.cs.fa15.ceg3120.concon.common.net.message.BeanMessage;

public class CustomerClient {

	public static void main(String[] args) {
		ConConClient client = new ConConClient("localhost", 9667);
		
		BeanMessage message = new BeanMessage("Hello World");
		client.sendMessage(NetworkManager.encodeToXML(message));
	}
}