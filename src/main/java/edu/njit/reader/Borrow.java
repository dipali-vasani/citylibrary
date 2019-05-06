package edu.njit.reader;

import java.awt.Label;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.njit.components.ComponentUtils;
import edu.njit.db.DBManager;

public class Borrow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = ComponentUtils.getJPanel(0, 0, 1352, 582);
	private JTable tableDocBorrowResult;

	/**
	 * Create the dialog.
	 */
	public Borrow(String cardNumber) {
		setTitle("The City Library");

		DBManager m = DBManager.getInstance();

		String[] columnNames = { "BorrowNo", "ReaderId", "DocId", "CopyNo", "LibId", "BDTime", "RDTime",
				"Fine(cents)" };
		ArrayList<ArrayList<Object>> borrowResult = new ArrayList<ArrayList<Object>>();

		borrowResult = m.execQuery(
				"SELECT `BORNUMBER`, `READERID`, `DOCID`, `COPYNO`, `LIBID`, `BDTIME`, `RDTIME` FROM `BORROWS` WHERE `READERID` = '"
						+ cardNumber + "';");

		Object[][] array = new Object[borrowResult.size() + 1][];
		double count = 0;
		for (int i = 0; i < borrowResult.size(); i++) {
			ArrayList<Object> row = borrowResult.get(i);
			Timestamp a = (Timestamp) row.get(5);
			Timestamp b = (Timestamp) row.get(6);
			long diff = 0;
			if (b == null) {
				long b2 = System.currentTimeMillis();
				diff = b2 - a.getTime();
			} else {
				diff = b.getTime() - a.getTime();
			}
			double diff1 = (double) diff / 86400000;
			if (diff1 > 20) {
				diff1 = diff1 - 20;
				double diff2 = Math.ceil(diff1);
				row.add(20 * diff2);
				count = count + 20 * diff2;
			} else {
				row.add(0.0);
			}
			array[i] = row.toArray();
		}
		List<String> list1 = new ArrayList<String>();
		for (int i = 0; i < 7; i++) {
			list1.add("");
		}
		DecimalFormat df = new DecimalFormat(".##");
		count = count / borrowResult.size();
		String result = df.format(count);
		list1.add("Average: " + result);

		array[borrowResult.size()] = list1.toArray();

		if (borrowResult == null || borrowResult.size() <= 0) {
			JOptionPane.showMessageDialog(null, "No Borrowed Documents");
		}

		DefaultTableModel tm = new DefaultTableModel(array, columnNames);

		setBounds(100, 100, 1358, 610);
		getContentPane().setLayout(null);
		getContentPane().add(contentPanel);

		JScrollPane scrollPane = ComponentUtils.getJScrollPane(16, 51, 1240, 444);
		contentPanel.add(scrollPane);

		tableDocBorrowResult = new JTable();
		scrollPane.setViewportView(tableDocBorrowResult);
		tableDocBorrowResult.setModel(tm);

		Label label = new Label("Borrowed Books:");
		label.setBounds(6, 10, 187, 35);
		contentPanel.add(label);

	}
}
