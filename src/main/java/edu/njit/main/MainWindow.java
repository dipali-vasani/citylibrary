package edu.njit.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import edu.njit.admin.Admin;
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

		frameCityLibrary = new JFrame();
		frameCityLibrary.setTitle("THE CITY LIBRARY");
		frameCityLibrary.getContentPane().setBackground(Color.WHITE);
		frameCityLibrary.getContentPane().setForeground(Color.WHITE);
		frameCityLibrary.setBounds(100, 100, 450, 300);
		frameCityLibrary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCityLibrary.getContentPane().setLayout(null);

		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(38, 69, 90, 16);
		frameCityLibrary.getContentPane().add(lblCardNumber);

		cardNumber = new JTextField();
		cardNumber.setBounds(125, 64, 130, 26);
		frameCityLibrary.getContentPane().add(cardNumber);
		cardNumber.setColumns(10);

		JButton btnReaderLogin = new JButton("Login");
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
		btnReaderLogin.setBounds(280, 64, 149, 29);
		frameCityLibrary.getContentPane().add(btnReaderLogin);

		JLabel lblCityLibrary = new JLabel("Reader Functions");
		lblCityLibrary.setForeground(Color.BLACK);
		lblCityLibrary.setBackground(Color.GRAY);
		lblCityLibrary.setBounds(38, 36, 71, 16);
		frameCityLibrary.getContentPane().add(lblCityLibrary);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 119, 438, 16);
		frameCityLibrary.getContentPane().add(separator);

		JLabel lblCityLibrary1 = new JLabel("Administrative Functions");
		lblCityLibrary1.setForeground(Color.BLACK);
		lblCityLibrary1.setBackground(Color.GRAY);
		lblCityLibrary1.setBounds(38, 151, 71, 16);
		frameCityLibrary.getContentPane().add(lblCityLibrary1);

		JLabel lblAdminID = new JLabel("ID");
		lblAdminID.setBounds(38, 179, 90, 16);
		frameCityLibrary.getContentPane().add(lblAdminID);

		JTextField txtAdminID = new JTextField();
		txtAdminID.setBounds(125, 174, 130, 26);
		frameCityLibrary.getContentPane().add(txtAdminID);
		txtAdminID.setColumns(10);

		JLabel lblAdminPwd = new JLabel("Password");
		lblAdminPwd.setBounds(38, 217, 90, 16);
		frameCityLibrary.getContentPane().add(lblAdminPwd);

		JTextField txtAdminPwd = new JTextField();
		txtAdminPwd.setBounds(125, 207, 130, 26);
		frameCityLibrary.getContentPane().add(txtAdminPwd);
		txtAdminPwd.setColumns(10);

		JButton btnAdminLogin = new JButton("Login");
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
		btnAdminLogin.setBounds(280, 207, 149, 29);
		frameCityLibrary.getContentPane().add(btnAdminLogin);
	}

}
