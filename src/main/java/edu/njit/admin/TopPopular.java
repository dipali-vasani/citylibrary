package edu.njit.admin;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.njit.components.ComponentUtils;
import edu.njit.db.DBManager;

public class TopPopular extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = ComponentUtils.getJPanel(0, 0, 1352, 582);
	private JTable tableTopP;

	/**
	 * Create the dialog.
	 */
	public TopPopular() {

		DBManager m = DBManager.getInstance();

		String[] columnNames = { "Top 10 Popular books of 2019" };
		ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();

		result = m.execQuery(
				"SELECT `DOCID`, COUNT(*) FROM `BORROWS` WHERE YEAR(BDTIME) = 2019 GROUP BY DOCID ORDER BY COUNT(*) DESC LIMIT 10;");

		Object[][] array = new Object[result.size()][];
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Object> row = result.get(i);
			array[i] = row.toArray();
		}

		DefaultTableModel tm = new DefaultTableModel(array, columnNames);

		setBounds(100, 100, 1358, 610);
		getContentPane().setLayout(null);
		getContentPane().add(contentPanel);

		JScrollPane scrollPane = ComponentUtils.getJScrollPane(26, 51, 1308, 480);
		contentPanel.add(scrollPane);

		tableTopP = new JTable();
		scrollPane.setViewportView(tableTopP);
		tableTopP.setModel(tm);
	}
}
