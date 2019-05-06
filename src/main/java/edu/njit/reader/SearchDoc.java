package edu.njit.reader;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
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

		getContentPane().add(ComponentUtils.getJLabel(74, 78, 300, 31, "Search Status of Documents"));

		getContentPane().add(ComponentUtils.getJLabel(38, 149, 90, 16, "DOCID"));

		txtDocID = ComponentUtils.getJTextField(125, 149, 130, 26, 10);
		getContentPane().add(txtDocID);

		getContentPane().add(ComponentUtils.getJLabel(38, 179, 90, 16, "COPY NO."));

		txtCopyNo = ComponentUtils.getJTextField(125, 179, 130, 26, 10);
		getContentPane().add(txtCopyNo);

		getContentPane().add(ComponentUtils.getJLabel(38, 229, 90, 16, "LIBRARYID"));

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