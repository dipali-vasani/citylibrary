package edu.njit.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import edu.njit.db.DBManager;

public class AddDocument extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddDocument() {

		getContentPane().setBackground(Color.WHITE);
		// Connect to Database
		DBManager m = DBManager.getInstance();
		m.connect();

		setBounds(100, 100, 500, 550);
		getContentPane().setLayout(null);

		JLabel lblAddReader = new JLabel("Add Document to Database");
		lblAddReader.setBounds(38, 14, 200, 31);
		getContentPane().add(lblAddReader);

		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBook dialog = new AddBook();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		btnAddBook.setBounds(38, 64, 200, 29);
		getContentPane().add(btnAddBook);

		JButton btnAddJournal = new JButton("Add Journal");
		btnAddJournal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddJournal dialog = new AddJournal();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		btnAddJournal.setBounds(38, 114, 200, 29);
		getContentPane().add(btnAddJournal);

		JButton btnAddProc = new JButton("Add Proceedings");
		btnAddProc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProceeding dialog = new AddProceeding();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		btnAddProc.setBounds(38, 164, 200, 29);
		getContentPane().add(btnAddProc);

	}

}
