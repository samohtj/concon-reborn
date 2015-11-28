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

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package edu.wright.cs.fa15.ceg3120.concon.server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.AbstractTableModel;

/**
 * Creates a panel for the user's tab.
 * @author Carly
 * */
public class CreateButtonsSearch extends JPanel{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates a panel for the User's Tab.
	 */
	public CreateButtonsSearch(ServerGui parent) {
		super();
		this.setLayout(new BorderLayout());
		
		JPanel functionality = new JPanel();
		functionality.setLayout(new GridLayout(1,3));
		functionality.setOpaque(true);
		functionality.setBackground(Color.ORANGE);
		
		JTextField searchBar = new JTextField(25);
		functionality.add(searchBar);
		
		JButton search = new JButton();
		search.setText("Search");
		search.addActionListener(new SearchListener());
		SearchListener.searchInfo(searchBar);
		functionality.add(search);
		
		JRadioButton homeOwner = new JRadioButton();
		homeOwner.setText("Homeowner");
		homeOwner.setSelected(true);
		ButtonGroup userTypes = new ButtonGroup();
		
		userTypes.add(homeOwner);
		JPanel userButtons = new JPanel();
		userButtons.setOpaque(true);
		userButtons.setBackground(Color.ORANGE);
		userButtons.setLayout(new GridLayout(1,2));
		userButtons.add(homeOwner);
		
		JRadioButton contractor = new JRadioButton();
		contractor.setText("Contractor");
		userTypes.add(contractor);
		userButtons.add(contractor);
		functionality.add(userButtons);
		this.setOpaque(true);
		this.setBackground(Color.ORANGE);
		this.add(functionality, BorderLayout.NORTH);
			
		JTable users = new JTable(new UserTableModel());
		users.setBackground(Color.ORANGE);
		users.addMouseListener(new EditListener());
		EditListener.passValues(users);
	
		users.setFillsViewportHeight(true);	
		
		this.add(users, BorderLayout.CENTER);
		
		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem test = new JMenuItem("Send Message");
		
		test.addActionListener(new NewMessageListener(parent));
		popupMenu.add(test);
		
		test = new JMenuItem("View Transactions");
		
		test.addActionListener(new LoadTransactionsListener(parent));
		popupMenu.add(test);
		popupMenu.addPopupMenuListener(new PopupListener(users, popupMenu));
		
		users.setComponentPopupMenu(popupMenu);
		
		this.add(new JScrollPane(users), BorderLayout.CENTER);
	}//end constructor
	
	/**
	 * Table for displaying user information.
	 * */
	static class UserTableModel extends AbstractTableModel { //Copied from Transactions tab
		private static final long serialVersionUID = 1L;

		private String[] columnNames = { "Name", "Phone Number","Address", "E-Mail" };
		
		private Object[][] dummyData = {
										{ "Kathy", "(555)555-5555", "123 Main St.",
			"Kathy@gmail.com" },
										{ "Geroge", "(555)555-5555", "456 S. West Dr.",
			"George@yahoo.com" },
										{ "Megan", "(555)555-5555", "789 Oak Rd.", 
			"Megan@hotmail.com" },
										{ "Mitch", "(555)555-5555","1011 Maple Ave.",
			"Mitch@aol.com"},
										{ "Barbara", "(555)555-5555", 
			"1213  Pennyworth Blvd","mrs.gordon@gcpd.gov"}
		};

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}
		
		@Override
		public String getColumnName(int col) {
			return columnNames[col];
		}

		@Override
		public int getRowCount() {
			return dummyData.length;
		}

		@Override
		public Object getValueAt(int row, int col) {
			return dummyData[row][col];
		}
		
		@Override
		public Class<?> getColumnClass(int column) {
			return getValueAt(0, column).getClass();
		}
		
		/*
		 * Possible implementation of resolving issues
		 */
		@Override
		public boolean isCellEditable(int row, int col) {
			return false; // Could return true on different columns.
		}
		
		@Override
		public void setValueAt(Object value, int row, int col) {
			//validation
			dummyData[row][col] = value;
			fireTableCellUpdated(row, col);
		}
	}//end UserTableModel
	
	/**
	 * Searches the database for the name input in the search bar.
	 * */
	private static class SearchListener implements ActionListener{
		static JTextField searchBar;
		
		/**
		 * Passes the search bar.
		 * */
		public static void searchInfo(JTextField searchBar2) {
			searchBar = searchBar2;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				if (searchBar.getText().isEmpty()) {
					System.out.println("You must enter a name to search");
					//if (contractor.isSelected()) {}
				} else {
					System.out.println("The search is not empty");
					//add search functionality, probably return a 2D array
				}
			} catch (RuntimeException ex) {
				throw ex;
			} catch (Exception ex) {
				System.out.println("Error occured searching "
						+ "for users with that name");
			} //end catch
		}//end actionPerformed
	}//end SearchListener
	
	/**
	 * opens a new window when you double click a user on the table.
	 * */
	private static class EditListener implements MouseListener{
		private static JTable users;
		
		/**
		 * Passes the table.
		 * */
		public static void passValues(JTable users2) {
			users = users2;
		}
		
		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getClickCount() == 2) {				
				
				JPanel functionality = new JPanel();
				functionality.setLayout(new GridLayout(2,1));
				
				JPanel textFields = new JPanel();
				textFields.setLayout(new GridLayout(1,4));
				
				JTextField name = new JTextField();
				name.setText((String) users.getValueAt(users.getSelectedRow(), 0));
				textFields.add(name);
				
				JTextField phoneNumber = new JTextField();
				phoneNumber.setText((String) users.getValueAt(users.getSelectedRow(), 1));
				textFields.add(phoneNumber);
				
				JTextField address = new JTextField();
				address.setText((String) users.getValueAt(users.getSelectedRow(), 2));
				textFields.add(address);
				
				JTextField email = new JTextField();
				email.setText((String) users.getValueAt(users.getSelectedRow(), 3));
				textFields.add(email);
				functionality.add(textFields);
				
				JPanel buttons = new JPanel();
				buttons.setLayout(new GridLayout(1,3));

				JButton disable = new JButton();
				disable.setText("Disable Account");
				disable.addActionListener(new DisableListener());
				buttons.add(disable);

				JButton reset = new JButton();
				reset.setText("Reset Password");
				reset.addActionListener(new ResetListener());
				buttons.add(reset);

				JButton save = new JButton();
				save.setText("Save Changes");
				save.addActionListener(new SaveListener());
				SaveListener.passUserInfo(users, name, phoneNumber, address, email);
				buttons.add(save);
				functionality.add(buttons);
				
				JFrame editInfo = new JFrame();
				editInfo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				editInfo.setVisible(true);
				editInfo.setSize(700, 100);
				
				editInfo.add(functionality);
			}		
		}

		//There are all required, but not used:
		@Override
		public void mousePressed(MouseEvent event) {}

		@Override
		public void mouseReleased(MouseEvent event) {}

		@Override
		public void mouseEntered(MouseEvent event) {}

		@Override
		public void mouseExited(MouseEvent event) {}
	}
	
	/**
	 * Resets the selected user's password.
	 * */
	private static class ResetListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				//add functionality
				System.out.println("Password reset");
			} catch (Exception ex) {
				System.out.println("Error occured resetting");
			} //end catch
		}//end actionPerformed
	}//end ResetListener
	
	/**
	 * Disables the selected account.
	 * */
	private static class DisableListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				//add functionality
				System.out.println("User's account disabled");
			} catch (Exception ex) {
				System.out.println("Error occured disabling");
			} //end catch
		}//end actionPerformed
	}//end DisableListener
	
	/**
	 * Updates the table with the new user information.
	 * */
	private static class SaveListener implements ActionListener{
		static JTable users;
		static JTextField name;
		static JTextField phoneNumber;
		static JTextField address;
		static JTextField email;
		
		/**
		 * Passes the table.
		 * */
		public static void passUserInfo(JTable users2, 
				JTextField name2, JTextField phoneNumber2, JTextField address2, JTextField email2) {
			users = users2;
			name = name2;
			phoneNumber = phoneNumber2;
			address = address2;
			email = email2;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				System.out.println("Saved info");	
				users.setValueAt(name.getText(), users.getSelectedRow(), 0);
				users.setValueAt(phoneNumber.getText(), users.getSelectedRow(), 1);
				users.setValueAt(address.getText(), users.getSelectedRow(), 2);
				users.setValueAt(email.getText(), users.getSelectedRow(), 3);
			} catch (RuntimeException ex) {
				throw ex;
			} catch (Exception ex) {
				System.out.println("Error saving update");
			}
		}
	}
	
	/**
	 * A listener that will switch the current tab to the messages tab.
	 * @author Quintin
	 *
	 */
	private static class NewMessageListener implements ActionListener{
		private ServerGui parent;
		
		/**
		 * Creates a listener that has access to the GUI's tabs.
		 * @param parent the parent component that holds the view.
		 */
		public NewMessageListener(ServerGui parent) {
			this.parent = parent;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			parent.switchTabs(2);
		}
	}
	
	/**
	 * A listener that will switch the current tab to the transaction tab.
	 * @author Quintin
	 *
	 */
	private static class LoadTransactionsListener implements ActionListener{
		private ServerGui parent;
		
		/**
		 * Creates a listener that has access to the GUI's tabs.
		 * @param parent the parent component that holds the view.
		 */
		public LoadTransactionsListener(ServerGui parent) {
			this.parent = parent;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			parent.switchTabs(4);
		}
	}
	
	/**
	 * A listener that will highlight the row of a table that was right-clicked.
	 * @author Quintin
	 *
	 */
	private static class PopupListener implements PopupMenuListener {
		private JTable users;
		private JPopupMenu menu;
		
		/**
		 * Creates a listener that has access to the GUI's table.
		 * @param table the table that the popup menu and listener is attached to.
		 * @param menu the menu that the listener is attached to.
		 */
		public PopupListener(JTable table, JPopupMenu menu) {
			this.users = table;
			this.menu = menu;
		}

		@Override
		public void popupMenuWillBecomeVisible(PopupMenuEvent event) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					int rowAtPoint = users.rowAtPoint(SwingUtilities.convertPoint(menu, 
							new Point(0, 0), users));
					if (rowAtPoint > -1) {
						users.setRowSelectionInterval(rowAtPoint, rowAtPoint);
					}
				}
			});
		}

		@Override
		public void popupMenuWillBecomeInvisible(PopupMenuEvent event) {
			//Auto-generated method stub
		}

		@Override
		public void popupMenuCanceled(PopupMenuEvent event) {
			//Auto-generated method stub
		}
	}
}//end CreateButtonsSearch