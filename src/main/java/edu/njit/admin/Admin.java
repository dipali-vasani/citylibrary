package edu.njit.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;

import edu.njit.components.ComponentUtils;
import edu.njit.db.DBManager;
import edu.njit.reader.AverageFine;
import edu.njit.reader.BranchInfo;
import edu.njit.reader.SearchDoc;

public class Admin extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public Admin() {

		getContentPane().setBackground(Color.WHITE);
		// Connect to Database
		DBManager m = DBManager.getInstance();
		m.connect();

		setBounds(100, 100, 742, 500);
		getContentPane().setLayout(null);

		getContentPane().add(ComponentUtils.getJLabel(202, 24, 181, 50, "The City Library"));

		getContentPane().add(ComponentUtils.getJLabel(16, 6, 61, 16, "ADMIN"));

		JButton btnAddReader = ComponentUtils.getJButton(38, 64, 150, 29, "Add Reader");
		btnAddReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddReader dialog = new AddReader();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		getContentPane().add(btnAddReader);

		JButton btnAddDocument = ComponentUtils.getJButton(200, 64, 150, 29, "Add Document");
		btnAddDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDocument dialog = new AddDocument();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		getContentPane().add(btnAddDocument);

		JButton btnSearchDoc = ComponentUtils.getJButton(38, 124, 150, 29, "Search Doc");
		btnSearchDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchDoc dialog = new SearchDoc();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		getContentPane().add(btnSearchDoc);

		JButton btnBranchInfo = ComponentUtils.getJButton(200, 124, 150, 29, "Branch Info");
		btnBranchInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BranchInfo dialog = new BranchInfo();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		getContentPane().add(btnBranchInfo);

		JButton btnTopR = ComponentUtils.getJButton(38, 184, 400, 29, "Top 10 most frequent borrowers in a branch");
		btnTopR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TopReaders dialog = new TopReaders();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		getContentPane().add(btnTopR);

		JButton btnTopB = ComponentUtils.getJButton(38, 244, 400, 29, "Top 10 most borrowed books in a branch");
		btnTopB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TopBooks dialog = new TopBooks();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		getContentPane().add(btnTopB);

		JButton btnTopP = ComponentUtils.getJButton(38, 304, 400, 29, "10 most popular books of the year");
		btnTopP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TopPopular dialog = new TopPopular();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		getContentPane().add(btnTopP);

		JButton btnAvFn = ComponentUtils.getJButton(38, 364, 400, 29, "Average Fine per reader");
		btnAvFn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AverageFine dialog = null;
				try {
					dialog = new AverageFine();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		getContentPane().add(btnAvFn);
	}
}
