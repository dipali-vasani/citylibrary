package edu.njit.admin;

import java.awt.Color;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.njit.db.DBManager;
import edu.njit.reader.SearchDoc;

public class AdminSearchDoc extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTable tableDocStatusResult;

	public static void main(String[] args) {
		try {
			SearchDoc dialog = new SearchDoc();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AdminSearchDoc(String docid, String copyno, String lid) {

		getContentPane().setBackground(Color.WHITE);
		// Connect to Database
		DBManager m = DBManager.getInstance();
		m.connect();

		setBounds(100, 100, 500, 550);
		getContentPane().setLayout(null);

		String[] columnNames = { "DOCID", "COPYNO", "LIBID", "STATUS" };
		String status = "NULL";
		ArrayList<ArrayList<Object>> result = m.execQuery("SELECT * FROM `COPY` WHERE DOCID = '" + docid
				+ "' AND COPYNO = " + copyno + " AND LIBID = '" + lid + "';");
		if (result.size() == 0) {
			status = "does not exists";
		} else {

			ArrayList<ArrayList<Object>> result1 = m.execQuery("SELECT * FROM `BORROWS` WHERE DOCID = '" + docid
					+ "' AND COPYNO = " + copyno + " AND LIBID = '" + lid + "';");
			ArrayList<ArrayList<Object>> result2 = m.execQuery("SELECT * FROM `RESERVES` WHERE DOCID = '" + docid
					+ "' AND COPYNO = " + copyno + " AND LIBID = '" + lid + "';");
			Timestamp a = null;
			if (result1.size() != 0) {
				ArrayList<Object> row = result1.get(1);
				a = (Timestamp) row.get(6);
			}
			if (a == null) {
				status = "borrowed";
			} else if (result2.size() != 0) {
				status = "borrowed and reserved";
			} else {
				status = "on shelf";
			}

		}

		String[][] array = new String[1][4];

		array[0][0] = docid;
		array[0][1] = copyno;
		array[0][2] = lid;
		array[0][3] = status;

		DefaultTableModel tm = new DefaultTableModel(array, columnNames);

		setBounds(100, 100, 1358, 610);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 1352, 582);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 51, 1308, 480);
		contentPanel.add(scrollPane);

		tableDocStatusResult = new JTable();
		scrollPane.setViewportView(tableDocStatusResult);
		tableDocStatusResult.setModel(tm);

	}
}
