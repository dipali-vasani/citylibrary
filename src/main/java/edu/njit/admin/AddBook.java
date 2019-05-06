package edu.njit.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.njit.components.ComponentUtils;
import edu.njit.db.DBManager;

public class AddBook extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddBook() {

		getContentPane().setBackground(Color.WHITE);
		// Connect to Database
		DBManager m = DBManager.getInstance();
		m.connect();

		setBounds(100, 100, 500, 550);
		getContentPane().setLayout(null);

		JLabel lblAddBook = ComponentUtils.getJLabel(74, 78, 200, 31, "Add Book to Database");
		getContentPane().add(lblAddBook);

		JLabel lblBookID = ComponentUtils.getJLabel(38, 149, 90, 16, "ID");
		getContentPane().add(lblBookID);

		JTextField txtBookID = ComponentUtils.getJTextField(125, 149, 130, 26, 10);
		getContentPane().add(txtBookID);

		JLabel lblISBN = ComponentUtils.getJLabel(38, 179, 90, 16, "ISBN");
		getContentPane().add(lblISBN);

		JTextField txtISBN = ComponentUtils.getJTextField(125, 179, 130, 26, 10);
		getContentPane().add(txtISBN);

		JLabel lblTitle = ComponentUtils.getJLabel(38, 229, 90, 16, "NAME");
		getContentPane().add(lblTitle);

		JTextField txtTitle = ComponentUtils.getJTextField(125, 229, 130, 26, 10);
		getContentPane().add(txtTitle);

		JLabel lblPDate = ComponentUtils.getJLabel(38, 269, 90, 16, "PDATE");
		getContentPane().add(lblPDate);

		JTextField txtPDate = ComponentUtils.getJTextField(125, 269, 130, 26, 10);
		getContentPane().add(txtPDate);

		JLabel lblPID = ComponentUtils.getJLabel(38, 309, 90, 16, "PID");
		getContentPane().add(lblPID);

		JTextField txtPID = ComponentUtils.getJTextField(125, 309, 130, 26, 10);
		getContentPane().add(txtPID);

		JLabel lblLID = ComponentUtils.getJLabel(38, 359, 90, 16, "BRANCHNO");
		getContentPane().add(lblLID);

		JTextField txtLID = ComponentUtils.getJTextField(125, 359, 130, 26, 10);
		getContentPane().add(txtLID);

		JLabel lblPos = ComponentUtils.getJLabel(38, 409, 90, 16, "POSITION");
		getContentPane().add(lblPos);

		JTextField txtPos = ComponentUtils.getJTextField(125, 409, 130, 26, 10);
		getContentPane().add(txtPos);

		JButton btnAddBook = ComponentUtils.getJButton(280, 179, 149, 29, "Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtBookID.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please type ID");
					return;
				}
				if (txtISBN.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please specify ISBN");
					return;
				}
				if (txtTitle.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please specify name");
					return;
				}
				if (txtLID.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please specify Branch");
					return;
				}

				String id = txtBookID.getText();
				String lid = txtLID.getText();
				String pid = txtPID.getText();
				// String ty = txtReaderType.getText();
				// String nm = txtReaderName.getText();
				// String ad = txtReaderAdd.getText();

				ArrayList<ArrayList<Object>> resultl = m
						.execQuery("SELECT * FROM `BRANCH` WHERE LIBID = '" + txtLID.getText() + "';");
				if (resultl.size() == 0) {

					JOptionPane.showMessageDialog(null, "No BRANCH  WITH THIS ID. CANNOT INSERT");

				}
				ArrayList<ArrayList<Object>> resultp = m
						.execQuery("SELECT * FROM `PUBLISHER` WHERE PUBLISHERID = '" + txtPID.getText() + "';");
				if (resultp.size() == 0) {

					JOptionPane.showMessageDialog(null, "No PUBLISHER  WITH THIS ID. CANNOT INSERT");

				}
				ArrayList<ArrayList<Object>> result = m
						.execQuery("SELECT * FROM `DOCUMENT` WHERE DOCID = '" + txtBookID.getText() + "';");
				if (result.size() == 0) {

					int afr1 = m.execUpdate("INSERT INTO DOCUMENT (DOCID, TITLE, PDATE, PUBLISHERID) " + "VALUES ('"
							+ id + "','" + txtTitle.getText() + "','" + txtPDate.getText() + "','" + pid + "')");
					int afr2 = m.execUpdate(
							"INSERT INTO BOOK (DOCID, ISBN) " + "VALUES ('" + id + "','" + txtISBN.getText() + "')");

					JOptionPane.showMessageDialog(null, "A new book inserted to document table andbook table.");

				}

				ArrayList<ArrayList<Object>> result1 = m
						.execQuery("SELECT * FROM `COPY` WHERE DOCID = '" + txtBookID.getText() + "';");
				Integer r = result1.size() + 1;
				int afr3 = m.execUpdate("INSERT INTO COPY (DOCID, COPYNO, LIBID, POSITION) " + "VALUES (" + id + "," + r
						+ ",'" + lid + "','" + txtPos.getText() + "')");

				JOptionPane.showMessageDialog(null, "1 book inserted into COPY Table");
			}
		});
		getContentPane().add(btnAddBook);

	}

}
