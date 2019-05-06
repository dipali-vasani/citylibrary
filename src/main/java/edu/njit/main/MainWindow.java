package edu.njit.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.njit.admin.Admin;
import edu.njit.components.ComponentUtils;
import edu.njit.db.DBManager;
import edu.njit.reader.Reader;

public class MainWindow {

	private JFrame frameCityLibrary;
	private JTextField cardNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frameCityLibrary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Initialize MySQL connection
		DBManager m = DBManager.getInstance();
		if (!m.connect()) {
			JOptionPane.showMessageDialog(null, "Could not connect to database");
			System.exit(1);
		}

		frameCityLibrary = ComponentUtils.getJFrame(100, 100, 450, 300, "THE CITY LIBRARY");

		frameCityLibrary.getContentPane().add(ComponentUtils.getJLabel(38, 69, 90, 16, "Card No"));

		cardNumber = ComponentUtils.getJTextField(125, 64, 130, 26, 10);
		frameCityLibrary.getContentPane().add(cardNumber);

		JButton btnReaderLogin = ComponentUtils.getJButton(280, 64, 149, 29, "Login");
		btnReaderLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cardNumber.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please enter card number");
					return;
				}

				ArrayList<ArrayList<Object>> result = m.execQuery(
						"SELECT `READERID`, `RTYPE` FROM `READER` WHERE `READERID` = '" + cardNumber.getText() + "';");
				if (result == null || result.size() != 1) {
					JOptionPane.showMessageDialog(null, "Invalid card number");
				} else {
					Reader dialog = new Reader(cardNumber.getText());
					dialog.setModal(true);
					dialog.setVisible(true);
				}
			}
		});
		frameCityLibrary.getContentPane().add(btnReaderLogin);

		frameCityLibrary.getContentPane().add(ComponentUtils.getJLabel(38, 36, 300, 16, "Reader Functions"));

		frameCityLibrary.getContentPane().add(ComponentUtils.getJSeparator(6, 119, 438, 16));

		frameCityLibrary.getContentPane().add(ComponentUtils.getJLabel(38, 151, 300, 16, "Administrative Functions"));

		frameCityLibrary.getContentPane().add(ComponentUtils.getJLabel(38, 179, 90, 16, "ID"));

		JTextField txtAdminID = ComponentUtils.getJTextField(125, 174, 130, 26, 10);
		frameCityLibrary.getContentPane().add(txtAdminID);

		frameCityLibrary.getContentPane().add(ComponentUtils.getJLabel(38, 217, 90, 16, "Password"));

		JTextField txtAdminPwd = ComponentUtils.getJTextField(125, 207, 130, 26, 10);
		frameCityLibrary.getContentPane().add(txtAdminPwd);

		JButton btnAdminLogin = ComponentUtils.getJButton(280, 207, 149, 29, "Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtAdminID.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please enter ID");
					return;
				}
				if (txtAdminPwd.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please enter Password");
					return;
				}

				ArrayList<ArrayList<Object>> result = m
						.execQuery("SELECT `loginID`, `password` FROM `ADMIN` WHERE loginID = '" + txtAdminID.getText()
								+ "' AND password = '" + txtAdminPwd.getText() + "';");
				if (result == null || result.size() != 1) {
					System.out.println(result.size());
					JOptionPane.showMessageDialog(null, "Invalid ID or password");
				} else {
					Admin dialog = new Admin();
					dialog.setModal(true);
					dialog.setVisible(true);
				}
			}

		});
		frameCityLibrary.getContentPane().add(btnAdminLogin);
	}

}
