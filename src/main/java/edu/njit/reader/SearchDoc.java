package edu.njit.reader;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.njit.admin.AdminSearchDoc;
import edu.njit.db.DBManager;

public class SearchDoc extends JDialog {

	private JTextField txtDocID;
	private JTextField txtCopyNo;
	private JTextField txtLID;

	public static void main(String[] args) {
		try {
			SearchDoc dialog = new SearchDoc();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SearchDoc() {

		getContentPane().setBackground(Color.WHITE);
		// Connect to Database
		DBManager m = DBManager.getInstance();
		m.connect();

		setBounds(100, 100, 500, 550);
		getContentPane().setLayout(null);

		JLabel lblSearchDoc = new JLabel("Search Status of Documents");
		lblSearchDoc.setBounds(74, 78, 200, 31);
		getContentPane().add(lblSearchDoc);

		JLabel lblDocID = new JLabel("DOCID");
		lblDocID.setBounds(38, 149, 90, 16);
		getContentPane().add(lblDocID);

		txtDocID = new JTextField();
		txtDocID.setBounds(125, 149, 130, 26);
		getContentPane().add(txtDocID);
		txtDocID.setColumns(10);

		JLabel lblCopyNo = new JLabel("COPY NO.");
		lblCopyNo.setBounds(38, 179, 90, 16);
		getContentPane().add(lblCopyNo);

		txtCopyNo = new JTextField();
		txtCopyNo.setBounds(125, 179, 130, 26);
		getContentPane().add(txtCopyNo);
		txtCopyNo.setColumns(10);

		JLabel lblLID = new JLabel("LIBRARYID");
		lblLID.setBounds(38, 229, 90, 16);
		getContentPane().add(lblLID);

		txtLID = new JTextField();
		txtLID.setBounds(125, 229, 130, 26);
		getContentPane().add(txtLID);
		txtLID.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtDocID.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Enter DOCID");
					return;
				}
				if (txtCopyNo.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Enter COPYNO");
					return;
				}
				if (txtLID.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Enter LIBRARYID");
					return;
				}

				AdminSearchDoc dialog = new AdminSearchDoc(txtDocID.getText(), txtCopyNo.getText(), txtLID.getText());
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});

		btnSearch.setBounds(280, 70, 100, 29);
		getContentPane().add(btnSearch);

	}

}