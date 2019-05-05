package edu.njit.admin;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.njit.db.DBManager;
import edu.njit.reader.Borrow;

public class TopBooks extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableTopB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DBManager m = DBManager.getInstance();
			m.connect();
			Borrow dialog = new Borrow("1");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TopBooks() {

		DBManager m = DBManager.getInstance();

		String[] columnNames = { "DOCID", "LIBID", "BRANCHNAME","No. of BORROWS" };
		ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();

		result = m.execQuery(
				"SELECT `DOCID`, `LIBID`, (SELECT LNAME from `BRANCH` where LIBID = B.LIBID) AS BRANCHNAME, COUNT(*) FROM `BORROWS` B GROUP BY DOCID, LIBID ORDER BY COUNT(*) DESC LIMIT 10;");
		Object[][] array = new Object[result.size()][];
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Object> row = result.get(i);
			array[i] = row.toArray();
		}

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

		tableTopB = new JTable();
		scrollPane.setViewportView(tableTopB);
		tableTopB.setModel(tm);

	}

}
