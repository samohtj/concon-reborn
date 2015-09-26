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

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//TODO have security
public class ConConServer extends Thread {
	private int port;
	private ServerSocket serverSocket = null;
	private boolean listening = true;

	public ConConServer(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		try {
			this.serverSocket = new ServerSocket(this.port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (listening) {
			Socket clientSocket = null;
			try {
				clientSocket = this.serverSocket.accept();
			} catch (IOException e) {
				if (!listening) {
					System.out.println("Server Stopped.");
					return;
				}
				e.printStackTrace();
			}
			new ConnectionWorker(clientSocket).start();
		}
	}

	/**
	 * Temp.
	 */
	public void quit() {
		this.listening = false;
		try {
			this.serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class ConnectionWorker extends Thread {
		private Socket clientSocket = null;

		public ConnectionWorker(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {
			try {
				DataOutputStream toClient = new DataOutputStream(
						clientSocket.getOutputStream());
				BufferedReader fromClient = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));

				int ch = 0;
				String message = "";
				while ((ch = fromClient.read()) != -1) {
					message += (char) ch;
				}

				NetworkManager.post(NetworkManager.decodeFromXml(message));

				toClient.close();
				fromClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
