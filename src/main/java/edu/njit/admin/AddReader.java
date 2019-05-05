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

		JLabel lblAddReader = new JLabel("Add Reader to Database");
		lblAddReader.setBounds(74, 78, 200, 31);
		getContentPane().add(lblAddReader);

		JLabel lblReaderID = new JLabel("ID");
		lblReaderID.setBounds(38, 149, 90, 16);
		getContentPane().add(lblReaderID);

		JTextField txtReaderID = new JTextField();
		txtReaderID.setBounds(125, 149, 130, 26);
		getContentPane().add(txtReaderID);
		txtReaderID.setColumns(10);

		JLabel lblReaderType = new JLabel("TYPE");
		lblReaderType.setBounds(38, 179, 90, 16);
		getContentPane().add(lblReaderType);

		JTextField txtReaderType = new JTextField();
		txtReaderType.setBounds(125, 179, 130, 26);
		getContentPane().add(txtReaderType);
		txtReaderType.setColumns(10);

		JLabel lblReaderName = new JLabel("NAME");
		lblReaderName.setBounds(38, 229, 90, 16);
		getContentPane().add(lblReaderName);

		JTextField txtReaderName = new JTextField();
		txtReaderName.setBounds(125, 229, 130, 26);
		getContentPane().add(txtReaderName);
		txtReaderName.setColumns(10);

		JLabel lblReaderAdd = new JLabel("ADDRESS");
		lblReaderAdd.setBounds(38, 269, 90, 16);
		getContentPane().add(lblReaderAdd);

		JTextField txtReaderAdd = new JTextField();
		txtReaderAdd.setBounds(125, 269, 130, 26);
		getContentPane().add(txtReaderAdd);
		txtReaderAdd.setColumns(20);

		JButton btnAddReader = new JButton("Add Reader");
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
		btnAddReader.setBounds(280, 179, 149, 29);
		getContentPane().add(btnAddReader);
	}

}
