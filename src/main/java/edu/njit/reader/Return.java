package edu.njit.reader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.njit.components.ComponentUtils;
import edu.njit.db.DBManager;

public class Return extends JDialog {

	private final JPanel contentPanel = ComponentUtils.getJPanel(0, 0, 1352, 582);
	private JTable tableDocBorrowResult;
	private JButton btnReturn;

	/**
	 * Create the dialog.
	 */
	public Return(String cardNumber) {
		setTitle("The City Library");
		DBManager m = DBManager.getInstance();
		String[] columnNames = { "BorrowNo", "ReaderId", "DocId", "CopyNo", "LibId", "BDTime" };
		ArrayList<ArrayList<Object>> borrowResult = new ArrayList<ArrayList<Object>>();
		borrowResult = m.execQuery(
				"SELECT `BORNUMBER`, `READERID`, `DOCID`, `COPYNO`, `LIBID`, `BDTIME`, `RDTIME` FROM `BORROWS` WHERE `READERID` = '"
						+ cardNumber + "';");

		Object[][] array1 = new Object[borrowResult.size()][];

		int j = 0;
		for (int i = 0; i < borrowResult.size(); i++) {
			ArrayList<Object> row = borrowResult.get(i);
			Timestamp b = (Timestamp) row.get(6);
			if (b == null) {
				row.remove(6);
				array1[j] = row.toArray();
				j = j + 1;
			} else {
				continue;
			}
		}

		Object[][] array = new Object[j][];
		for (int i = 0; i < j; i++) {
			array[i] = array1[i];
		}

		List<Integer> list1 = new ArrayList<Integer>();
		for (int i = 0; i < j; i++) {
			list1.add(i);
		}

		if (borrowResult == null || borrowResult.size() <= 0 || array.length == 0) {
			JOptionPane.showMessageDialog(null, "No Borrowed Documents");
		}

		DefaultTableModel tm = new DefaultTableModel(array, columnNames);

		setBounds(100, 100, 1358, 610);
		getContentPane().setLayout(null);
		getContentPane().add(contentPanel);

		JScrollPane scrollPane = ComponentUtils.getJScrollPane(29, 38, 1245, 480);
		contentPanel.add(scrollPane);

		tableDocBorrowResult = new JTable();
		scrollPane.setViewportView(tableDocBorrowResult);
		tableDocBorrowResult.setModel(tm);

		// Return a Book
		btnReturn = ComponentUtils.getJButton(1180, 529, 117, 29, "Return");

		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int rowIndex = tableDocBorrowResult.getSelectedRow();

				if (rowIndex < 0 || rowIndex > list1.size()) {
					JOptionPane.showMessageDialog(null, "Please select a book.");
					return;
				}
				int index = list1.get(rowIndex);

				long time = System.currentTimeMillis();
				Timestamp timestamp = new Timestamp(time);
				Timestamp a = (Timestamp) array[index][5];
				long diff = time - a.getTime();
				double diff1 = (double) diff / 86400000;
				double diff2 = 0;
				if (diff1 > 20) {
					diff1 = diff1 - 20;
					diff2 = Math.ceil(diff1);
					diff2 = diff2 * 20;
				}

				int affectedRows = m.execUpdate("UPDATE BORROWS SET `RDTIME`= '" + timestamp + "' WHERE `BORNUMBER` = '"
						+ array[index][0] + "' AND `READERID` = '" + cardNumber + "';");

				if (diff2 == 0) {
					JOptionPane.showMessageDialog(null, "Return Sucess. Books are returned on time.");
				} else {
					JOptionPane.showMessageDialog(null, "Return Sucess. You are fined " + diff2 + "cents.");
				}
				// remove selected row from the model
				tm.removeRow(rowIndex);
				list1.remove(rowIndex);

			}
		});
		contentPanel.add(btnReturn);
		contentPanel.add(ComponentUtils.getJLabel(29, 10, 117, 16, "Borrowed Books:"));
	}

}
