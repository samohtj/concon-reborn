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

import edu.wright.cs.fa15.ceg3120.concon.common.data.HomeownerAccount;

import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * XXX temp. 
 *
 * @author Corey Miller
 */
public class HomeownerMainPanel extends JTabbedPane {
	private static final long serialVersionUID = 1L;
//	private CreateJobTab createNewJobTab;

	/**
	 * Creates a new instance of <code>HomeownerMainPanel</code>.
	 */
	public HomeownerMainPanel(HomeownerAccount user) {
		setBackground(Color.ORANGE);
		
		MainTab mainTab = new MainTab();
		addTab("Main", null, mainTab, null);

		ProfileTab profileTab = new ProfileTab(user);
		profileTab.buildPane();
		addTab("Profile", null, profileTab, "View and change your profile here");
		setEnabledAt(0, true);
		setBackgroundAt(0, Color.ORANGE);

		JLayeredPane openJobsTab = new OpenJobsTab();
		addTab("Open Jobs", null, openJobsTab, null);

		JPanel createNewJobTab = new CreateJobTab();
		addTab("Create New Job", null, createNewJobTab, null);

		JLayeredPane showContractorTab = new ShowContractorsTab();
		addTab("Show Contractors", null, showContractorTab, null);

		setupPanel();
	}

	/**
	 * XXX temp.
	 */
	private void setupPanel() {

	}
}