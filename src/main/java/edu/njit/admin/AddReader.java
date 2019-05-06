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

public class AddReader extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddReader() {

		getContentPane().setBackground(Color.WHITE);
		// Connect to Database
		DBManager m = DBManager.getInstance();
		m.connect();

		setBounds(100, 100, 1000, 550);
		getContentPane().setLayout(null);

		JLabel lblAddReader = ComponentUtils.getJLabel(74, 78, 200, 31, "Add Reader to Database");
		getContentPane().add(lblAddReader);

		JLabel lblReaderID = ComponentUtils.getJLabel(38, 149, 90, 16, "ID");
		getContentPane().add(lblReaderID);

		JTextField txtReaderID = ComponentUtils.getJTextField(125, 149, 130, 26, 10);
		getContentPane().add(txtReaderID);

		JLabel lblReaderType = ComponentUtils.getJLabel(38, 179, 90, 16, "TYPE");
		getContentPane().add(lblReaderType);

		JTextField txtReaderType = ComponentUtils.getJTextField(125, 179, 130, 26, 10);
		getContentPane().add(txtReaderType);

		JLabel lblReaderName = ComponentUtils.getJLabel(38, 229, 90, 16, "NAME");
		getContentPane().add(lblReaderName);

		JTextField txtReaderName = ComponentUtils.getJTextField(125, 229, 130, 26, 10);
		getContentPane().add(txtReaderName);

		JLabel lblReaderAdd = ComponentUtils.getJLabel(38, 269, 90, 16, "ADDRESS");
		getContentPane().add(lblReaderAdd);

		JTextField txtReaderAdd = ComponentUtils.getJTextField(125, 269, 130, 26, 20);
		getContentPane().add(txtReaderAdd);

		JButton btnAddReader = ComponentUtils.getJButton(280, 179, 149, 29, "Add Reader");
		btnAddReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtReaderID.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please type ID");
					return;
				}
				if (txtReaderType.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please specify type");
					return;
				}
				if (txtReaderName.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please specify name");
					return;
				}
				if (txtReaderAdd.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please specify address");
					return;
				}

				String id = txtReaderID.getText();

				ArrayList<ArrayList<Object>> resultl = m
						.execQuery("SELECT * FROM `READER` WHERE READERID = '" + txtReaderID.getText() + "';");
				if (resultl.size() != 0) {

					JOptionPane.showMessageDialog(null, "Reader already exists. CANNOT INSERT");

				}

				int afr = m.execUpdate("INSERT INTO READER (READERID, RTYPE, RNAME, ADDRESS) " + "VALUES ('" + id
						+ "','" + txtReaderType.getText() + "','" + txtReaderName.getText() + "','"
						+ txtReaderAdd.getText() + ",')");
				if (afr > 0) {
					JOptionPane.showMessageDialog(null, "1 reader inserted to database");
				}
			}

		});
		getContentPane().add(btnAddReader);
	}

}
