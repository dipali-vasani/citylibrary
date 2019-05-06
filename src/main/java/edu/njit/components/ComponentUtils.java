package edu.njit.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ComponentUtils {

	private static final String FONT = "Helvetica";

	public static JLabel getJLabel(int x, int y, int width, int height, String lable) {
		JLabel jLabel = new JLabel(lable);
		jLabel.setBounds(x, y, width, height);
		jLabel.setFont(new Font(FONT, Font.PLAIN, 16));
		jLabel.setForeground(Color.BLACK);
		jLabel.setBackground(Color.GRAY);
		return jLabel;
	}

	public static JButton getJButton(int x, int y, int width, int height, String lable) {
		JButton jButton = new JButton(lable);
		jButton.setBounds(x, y, width, height);
		jButton.setFont(new Font(FONT, Font.PLAIN, 16));
		return jButton;
	}

	public static JTextField getJTextField(int x, int y, int width, int height, int columns) {
		JTextField jTextField = new JTextField();
		jTextField.setBounds(x, y, width, height);
		jTextField.setFont(new Font(FONT, Font.PLAIN, 16));
		jTextField.setColumns(columns);
		return jTextField;
	}

	public static JSeparator getJSeparator(int x, int y, int width, int height) {
		JSeparator seperator = new JSeparator();
		seperator.setBounds(x, y, width, height);
		return seperator;
	}

	public static JFrame getJFrame(int x, int y, int width, int height, String title) {
		JFrame frame = new JFrame(title);
		frame.setFont(new Font(FONT, Font.PLAIN, 16));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(x, y, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		return frame;
	}

	public static JScrollPane getJScrollPane(int x, int y, int width, int height) {
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setBounds(x, y, width, height);
		return jScrollPane;
	}

	public static JPanel getJPanel(int x, int y, int width, int height) {
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(x, y, width, height);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		return contentPanel;
	}

	public static JRadioButton getJRadioButton(int x, int y, int width, int height, String label) {
		JRadioButton jRadioButton = new JRadioButton(label);
		jRadioButton.setBounds(x, y, width, height);
		return jRadioButton;
	}
}
