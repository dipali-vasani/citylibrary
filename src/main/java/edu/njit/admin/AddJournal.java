package edu.njit.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.njit.components.ComponentUtils;
import edu.njit.db.DBManager;

public class AddJournal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddJournal() {

		getContentPane().setBackground(Color.WHITE);
		// Connect to Database
		DBManager m = DBManager.getInstance();
		m.connect();

		setBounds(100, 100, 500, 1000);
		getContentPane().setLayout(null);

		getContentPane().add(ComponentUtils.getJLabel(74, 78, 200, 31, "Add Journal to Database"));

		getContentPane().add(ComponentUtils.getJLabel(38, 149, 90, 16, "ID"));

		JTextField txtJournalID = ComponentUtils.getJTextField(125, 149, 130, 26, 10);
		getContentPane().add(txtJournalID);

		getContentPane().add(ComponentUtils.getJLabel(38, 229, 90, 16, "NAME"));

		JTextField txtTitle = ComponentUtils.getJTextField(125, 229, 130, 26, 10);
		getContentPane().add(txtTitle);

		getContentPane().add(ComponentUtils.getJLabel(38, 269, 90, 16, "VOLUME"));

		JTextField txtVolume = ComponentUtils.getJTextField(125, 269, 130, 26, 10);
		getContentPane().add(txtVolume);

		getContentPane().add(ComponentUtils.getJLabel(38, 309, 90, 16, "ISSUE No."));

		JTextField txtIssue = ComponentUtils.getJTextField(125, 309, 130, 26, 10);
		getContentPane().add(txtIssue);

		getContentPane().add(ComponentUtils.getJLabel(38, 369, 90, 16, "SCOPE"));

		JTextField txtScope = ComponentUtils.getJTextField(125, 369, 130, 26, 10);
		getContentPane().add(txtScope);

		getContentPane().add(ComponentUtils.getJLabel(38, 409, 90, 16, "PDATE"));

		JTextField txtPDate = ComponentUtils.getJTextField(125, 409, 130, 26, 10);
		getContentPane().add(txtPDate);

		getContentPane().add(ComponentUtils.getJLabel(38, 469, 90, 16, "PID"));

		JTextField txtPID = ComponentUtils.getJTextField(125, 469, 130, 26, 10);
		getContentPane().add(txtPID);

		getContentPane().add(ComponentUtils.getJLabel(38, 509, 90, 16, "EDITORID"));

		JTextField txtEID = ComponentUtils.getJTextField(125, 509, 130, 26, 10);
		getContentPane().add(txtEID);

		getContentPane().add(ComponentUtils.getJLabel(38, 569, 90, 16, "BRANCHNO"));

		JTextField txtLID = ComponentUtils.getJTextField(125, 569, 130, 26, 10);
		getContentPane().add(txtLID);

		getContentPane().add(ComponentUtils.getJLabel(38, 609, 90, 16, "POSITION"));

		JTextField txtPos = ComponentUtils.getJTextField(125, 609, 130, 26, 10);
		getContentPane().add(txtPos);

		JButton btnAddJournal = ComponentUtils.getJButton(280, 179, 149, 29, "Add Journal");
		btnAddJournal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtJournalID.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please type ID");
					return;
				}
				if (txtIssue.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please specify Issue NO");
					return;
				}
				if (txtLID.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please specify Branch");
					return;
				}

				String id = txtJournalID.getText();
				String lid = txtLID.getText();
				String pid = txtPID.getText();
				String eid = txtEID.getText();
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
				ArrayList<ArrayList<Object>> resulte = m
						.execQuery("SELECT * FROM `CHIEF_EDITOR` WHERE EDITORID = '" + txtEID.getText() + "';");
				if (resulte.size() == 0) {

					JOptionPane.showMessageDialog(null, "No EDITOR  WITH THIS ID. CANNOT INSERT");

				}
				ArrayList<ArrayList<Object>> result = m
						.execQuery("SELECT * FROM `DOCUMENT` WHERE DOCID = '" + txtJournalID.getText() + "';");
				if (result.size() == 0) {

					m.execUpdate("INSERT INTO DOCUMENT (DOCID, TITLE, PDATE, PUBLISHERID) " + "VALUES ('" + id + "','"
							+ txtTitle.getText() + "','" + txtPDate.getText() + "','" + pid + "')");
					m.execUpdate("INSERT INTO JOURNAL_VOLUME (DOCID, JVOLUME, EDITORID) " + "VALUES ('" + id + "','"
							+ txtVolume.getText() + "','" + eid + "')");
					m.execUpdate("INSERT INTO JOURNAL_ISSUE (DOCID, ISSUENO, SCOPE) " + "VALUES ('" + id + "','"
							+ txtIssue.getText() + "','" + txtScope.getText() + "')");

					JOptionPane.showMessageDialog(null, "New journal issue inserted.");
				}

				ArrayList<ArrayList<Object>> result1 = m
						.execQuery("SELECT * FROM `COPY` WHERE DOCID = '" + txtJournalID.getText() + "';");
				Integer r = result1.size() + 1;
				m.execUpdate("INSERT INTO COPY (DOCID, COPYNO, LIBID, POSITION) " + "VALUES ('" + id + "'," + r + ",'"
						+ lid + "','" + txtPos.getText() + "')");
				JOptionPane.showMessageDialog(null, "1 copy of journal inserted into COPY Table");

			}
		});
		getContentPane().add(btnAddJournal);

	}

}
