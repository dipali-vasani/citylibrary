package edu.njit.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

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

		setBounds(100, 100, 742, 386);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("The City Library");
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(202, 24, 181, 50);
		getContentPane().add(lblNewLabel);

		JLabel lblAdminId = new JLabel("ADMIN");
		lblAdminId.setBounds(16, 6, 61, 16);
		getContentPane().add(lblAdminId);

		JButton btnAddReader = new JButton("Add Reader");
		btnAddReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddReader dialog = new AddReader();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		btnAddReader.setBounds(38, 64, 150, 29);
		getContentPane().add(btnAddReader);

		JButton btnAddDocument = new JButton("Add Document");
		btnAddDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDocument dialog = new AddDocument();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		btnAddDocument.setBounds(200, 64, 150, 29);
		getContentPane().add(btnAddDocument);

		JButton btnSearchDoc = new JButton("Search Document");
		btnSearchDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchDoc dialog = new SearchDoc();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		btnSearchDoc.setBounds(38, 124, 150, 29);
		getContentPane().add(btnSearchDoc);

		JButton btnBranchInfo = new JButton("Branch Info");
		btnBranchInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BranchInfo dialog = new BranchInfo();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		btnBranchInfo.setBounds(200, 124, 150, 29);
		getContentPane().add(btnBranchInfo);

		JButton btnTopR = new JButton("Top 10 most frequent borrowers in a branch");
		btnTopR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TopReaders dialog = new TopReaders();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		btnTopR.setBounds(38, 184, 400, 29);
		getContentPane().add(btnTopR);

		JButton btnTopB = new JButton("Top 10 most borrowed books in a branch");
		btnTopB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TopBooks dialog = new TopBooks();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		btnTopB.setBounds(38, 244, 400, 29);
		getContentPane().add(btnTopB);

		JButton btnTopP = new JButton("10 most popular books of the year");
		btnTopP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TopPopular dialog = new TopPopular();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		btnTopP.setBounds(38, 304, 400, 29);
		getContentPane().add(btnTopP);

		JButton btnAvFn = new JButton("Average Fine per reader");
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
		btnAvFn.setBounds(38, 364, 400, 29);
		getContentPane().add(btnAvFn);
	}
}
