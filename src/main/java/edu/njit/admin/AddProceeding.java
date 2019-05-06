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

public class AddProceeding extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddProceeding() {

		getContentPane().setBackground(Color.WHITE);
		// Connect to Database
		DBManager m = DBManager.getInstance();
		m.connect();

		setBounds(100, 100, 500, 1000);
		getContentPane().setLayout(null);

		getContentPane().add(ComponentUtils.getJLabel(74, 78, 250, 31, "Add Proceedings to Database"));

		getContentPane().add(ComponentUtils.getJLabel(38, 149, 90, 16, "ID"));

		JTextField txtProcID = ComponentUtils.getJTextField(125, 149, 130, 26, 10);
		getContentPane().add(txtProcID);

		getContentPane().add(ComponentUtils.getJLabel(38, 229, 90, 16, "NAME"));

		JTextField txtTitle = ComponentUtils.getJTextField(125, 229, 130, 26, 10);
		getContentPane().add(txtTitle);

		getContentPane().add(ComponentUtils.getJLabel(38, 269, 90, 16, "CON DATE"));

		JTextField txtCName = ComponentUtils.getJTextField(125, 269, 130, 26, 10);
		getContentPane().add(txtCName);

		getContentPane().add(ComponentUtils.getJLabel(38, 309, 90, 16, "CON LOC"));

		JTextField txtCLoc = ComponentUtils.getJTextField(125, 309, 130, 26, 10);
		getContentPane().add(txtCLoc);

		getContentPane().add(ComponentUtils.getJLabel(38, 369, 90, 16, "EDITORID"));

		JTextField txtEID = ComponentUtils.getJTextField(125, 369, 130, 26, 10);
		getContentPane().add(txtEID);

		getContentPane().add(ComponentUtils.getJLabel(38, 409, 90, 16, "PDATE"));

		JTextField txtPDate = ComponentUtils.getJTextField(125, 409, 130, 26, 10);
		getContentPane().add(txtPDate);

		getContentPane().add(ComponentUtils.getJLabel(38, 469, 90, 16, "PID"));

		JTextField txtPID = ComponentUtils.getJTextField(125, 469, 130, 26, 10);
		getContentPane().add(txtPID);

		getContentPane().add(ComponentUtils.getJLabel(38, 509, 90, 16, "BRANCHNO"));

		JTextField txtLID = ComponentUtils.getJTextField(125, 509, 130, 26, 10);
		getContentPane().add(txtLID);

		getContentPane().add(ComponentUtils.getJLabel(38, 569, 90, 16, "POSITION"));

		JTextField txtPos = ComponentUtils.getJTextField(125, 569, 130, 26, 10);
		getContentPane().add(txtPos);

		JButton btnAddProc = ComponentUtils.getJButton(280, 179, 149, 29, "Add Proceedings");
		btnAddProc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtProcID.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please type ID");
					return;
				}
				if (txtEID.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please specify Editor ID");
					return;
				}
				if (txtLID.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please specify Branch");
					return;
				}

				String id = txtProcID.getText();
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

				ArrayList<ArrayList<Object>> result = m
						.execQuery("SELECT * FROM `DOCUMENT` WHERE DOCID = '" + txtProcID.getText() + "';");
				if (result.size() == 0) {

					m.execUpdate("INSERT INTO DOCUMENT (DOCID, TITLE, PDATE, PUBLISHERID) " + "VALUES ('" + id + "','"
							+ txtTitle.getText() + "','" + txtPDate.getText() + "','" + pid + "')");
					m.execUpdate("INSERT INTO PROCEEDINGS (DOCID, CDATE, CLOCATION, CEDITOR) " + "VALUES ('" + id
							+ "','" + txtCName.getText() + "','" + txtCLoc.getText() + "','" + eid + "')");
					JOptionPane.showMessageDialog(null, "new procedding inserted into database");
				}

				ArrayList<ArrayList<Object>> result1 = m
						.execQuery("SELECT * FROM `COPY` WHERE DOCID = '" + txtProcID.getText() + "';");
				Integer r = result1.size() + 1;
				m.execUpdate("INSERT INTO COPY (DOCID, COPYNO, LIBID, POSITION) " + "VALUES ('" + id + "'," + r + ",'"
						+ lid + "','" + txtPos.getText() + "')");
				JOptionPane.showMessageDialog(null, "1 proc inserted into COPY Table");
			}
		});
		getContentPane().add(btnAddProc);

	}

}
