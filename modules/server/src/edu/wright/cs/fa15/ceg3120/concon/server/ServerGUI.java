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

//package components;
package edu.wright.cs.fa15.ceg3120.concon.server;

/*
 * TabbedPaneDemo.java requires one additional file:
 *   images/middle.gif.
 */
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class ServerGUI extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField textField;
    protected JTextArea textArea;
    private final static String newline = "\n";
	
    
    public ServerGUI() {
        super(new GridLayout(1, 1));
        

        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("images/jno4TAP.png");
        
        
        JComponent panel1 = makeTextPanel("nah");
        tabbedPane.addTab("Dash board", icon, panel1,
                "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
      

        JComponent panel2 = createButtonsSearch();
        tabbedPane.addTab("User's info", icon, panel2,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        JComponent panel3 = createButtonsMessages();
        tabbedPane.addTab("Messages", icon, panel3,
                "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        
        JComponent panel4 = createControlPanel();
        panel4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Remote Control", icon, panel4,
                "Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_5);
        
        JComponent panel5 = makeTextPanel("Panel #5");
        tabbedPane.addTab("Transactions", icon, panel5,
                "Still does nothing");
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_4);
       
        
        //Add the tabbed pane to this panel.
        add(tabbedPane);
        
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
    
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
    
    protected JComponent createControlPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        JPanel schedulePanel = new JPanel(new GridLayout(4,1));	
        JPanel consolePanel = new JPanel(new BorderLayout());
        JPanel loginPanel = new JPanel(new GridLayout(2,2));
        
        // SchedulePanel
        /*
         * CLicking this button will evoke a JDatePicker and JSpinner
         * to allow a user to set a date and time for the server to 
         * restart
         */
        JButton btnScheduleReboot = new JButton("Schedule Reboot");
        btnScheduleReboot.addActionListener(this);
        schedulePanel.add(btnScheduleReboot);
        /*
         * CLicking this button will evoke a JDatePicker and JSpinner
         * to allow a user to set a date and time for the server to 
         * complete an arbitrary command 
         */
        JButton btnScheduleTask = new JButton("Schedule Task");
        btnScheduleTask.addActionListener(this);
        schedulePanel.add(btnScheduleTask);
        
        JTextArea txaTask = new JTextArea();
        schedulePanel.add(txaTask);

        JComponent standInConsole = makeTextPanel("Server console");
        
        // LoginPanel
        JLabel lblUsername = new JLabel("Username");
        JTextField txtUsername = new JTextField();
        JLabel lblPassword = new JLabel("Password");
        JPasswordField txtPassword = new JPasswordField();
        loginPanel.add(lblUsername);
        loginPanel.add(txtUsername);
        loginPanel.add(lblPassword);
        loginPanel.add(txtPassword);
        
        // ConsolePanel
        consolePanel.add(loginPanel, BorderLayout.WEST);
        consolePanel.add(standInConsole, BorderLayout.CENTER);
        
        // MainPanel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 0,
                                                0, 0));
        mainPanel.add(schedulePanel);
        mainPanel.add(consolePanel, BorderLayout.SOUTH);
        return mainPanel;
    }
    
    protected JComponent createButtonsSearch() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));

        JButton button = new JButton("Search");
        button.addActionListener(this);
        panel.add(button);
        JButton button2 = new JButton("Disable");
        button.addActionListener(this);
        panel.add(button2);
        JButton button3 = new JButton("Terminate");
        button.addActionListener(this);
        panel.add(button3);

        button = new JButton("Clear");
        button.addActionListener(this);
        button.setActionCommand("clear");
        panel.add(button);

        panel.setBorder(BorderFactory.createEmptyBorder(0, 0,
                                                0, 0));
        return panel;
    }
    protected JComponent createButtonsMessages() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));

        JButton button = new JButton("Send");
        button.addActionListener(this);
        panel.add(button);

        button = new JButton("Clear");
        button.addActionListener(this);
        button.setActionCommand("clear");
        panel.add(button);

        panel.setBorder(BorderFactory.createEmptyBorder(0, 0,
                                                0, 0));
        return panel;
    }
   
    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        textArea.append(text + newline);
        textField.selectAll();
 
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
    
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ServerGUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Server Control GUI");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add content to the window.
        frame.add(new ServerGUI(), BorderLayout.CENTER);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		createAndShowGUI();
            }
        });
    }
}
