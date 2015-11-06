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

package edu.wright.cs.fa15.ceg3120.concon.common.net.message;

import edu.wright.cs.fa15.ceg3120.concon.common.net.MessageHolder;
import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkHandler;
import edu.wright.cs.fa15.ceg3120.concon.common.net.data.UserData;

import java.io.Serializable;

/**
 * Holds data needed to send a chat message to another user.
 * @author NathanJent
 *
 */
public class ChatMessage extends MessageHolder {

	private static final long serialVersionUID = -5939310825171066784L;
	private String text;
	private UserData from;
	private UserData to;

	/**
	 * Default Constructor required for Java bean.
	 */
	public ChatMessage() { }

	/**
	 * Holds data needed to send a chat message to another user.
	 */
	public ChatMessage(String messageText, UserData from, UserData to) {
		this.text = messageText;
		this.from = from;
		this.to = to;
	}

	/**
	 * Get text.
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set text.
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Get from.
	 * @return the from
	 */
	public UserData getFrom() {
		return from;
	}

	/**
	 * Set from.
	 * @param from the from to set
	 */
	public void setFrom(UserData from) {
		this.from = from;
	}

	/**
	 * Get to.
	 * @return the to
	 */
	public UserData getTo() {
		return to;
	}

	/**
	 * Set to.
	 * @param to the to to set
	 */
	public void setTo(UserData to) {
		this.to = to;
	}
	
	/**
	 * Posts a chat message to the user's chat panel.
	 * @return The message
	 */
	@NetworkHandler(channel = "chat")
	public static MessageHolder postChat(ChatMessage message) {
		return new MessageHolder("chat", new ChatMessage(message.text, message.from, message.to));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChatMessage [text=" + text + ", from=" + from + ", to=" + to + "]";
	}

}
