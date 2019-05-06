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
import edu.njit.components.ComponentUtils;
import edu.njit.db.DBManager;

public class SearchDoc extends JDialog {

	private JTextField txtDocID;
	private JTextField txtCopyNo;
	private JTextField txtLID;

	public SearchDoc() {

		getContentPane().setBackground(Color.WHITE);
		// Connect to Database
		DBManager m = DBManager.getInstance();
		m.connect();

		setBounds(100, 100, 500, 550);
		getContentPane().setLayout(null);

		JLabel lblSearchDoc = ComponentUtils.getJLabel(74, 78, 300, 31, "Search Status of Documents");
		getContentPane().add(lblSearchDoc);

		JLabel lblDocID = ComponentUtils.getJLabel(38, 149, 90, 16, "DOCID");
		getContentPane().add(lblDocID);

		txtDocID = ComponentUtils.getJTextField(125, 149, 130, 26, 10);
		getContentPane().add(txtDocID);

		JLabel lblCopyNo = ComponentUtils.getJLabel(38, 179, 90, 16, "COPY NO.");
		getContentPane().add(lblCopyNo);

		txtCopyNo = ComponentUtils.getJTextField(125, 179, 130, 26, 10);
		getContentPane().add(txtCopyNo);

		JLabel lblLID = ComponentUtils.getJLabel(38, 229, 90, 16, "LIBRARYID");
		getContentPane().add(lblLID);

		txtLID = ComponentUtils.getJTextField(125, 229, 130, 26, 10);
		getContentPane().add(txtLID);

		JButton btnSearch = ComponentUtils.getJButton(280, 70, 100, 29, "Search");
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
		getContentPane().add(btnSearch);
	}
}