package edu.njit.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import edu.njit.components.ComponentUtils;
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

		getContentPane().add(ComponentUtils.getJLabel(38, 14, 200, 31, "Add Document to Database"));

		JButton btnAddBook = ComponentUtils.getJButton(38, 64, 200, 29, "Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBook dialog = new AddBook();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		getContentPane().add(btnAddBook);

		JButton btnAddJournal = ComponentUtils.getJButton(38, 114, 200, 29, "Add Journal");
		btnAddJournal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddJournal dialog = new AddJournal();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		getContentPane().add(btnAddJournal);

		JButton btnAddProc = ComponentUtils.getJButton(38, 164, 200, 29, "Add Proceedings");
		btnAddProc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProceeding dialog = new AddProceeding();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		getContentPane().add(btnAddProc);
	}
}
