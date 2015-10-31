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

package edu.wright.cs.fa15.ceg3120.concon.common.net;

/**
 * A basic tuple class for holding any object and a channel identifier.
 */
public class MessageHolder {
	public String channel;
	public Object message;

	/**
	 * Constructor.
	 * @param channel the channel.
	 * @param message the message.
	 */
	public MessageHolder(String channel, Object message) {
		this.channel = channel;
		this.message = message;
	}
}
