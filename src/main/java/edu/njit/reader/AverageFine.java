package edu.njit.reader;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.njit.components.ComponentUtils;
import edu.njit.db.DBManager;

public class AverageFine extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = ComponentUtils.getJPanel(0, 0, 1352, 582);
	private JTable tableAverageFine;

	/**
	 * Create the dialog.
	 * 
	 * @throws ParseException
	 */
	public AverageFine() throws ParseException {
		setTitle("The City Library");

		DBManager m = DBManager.getInstance();

		String[] columnNames = { "ReaderId", "AVERAGE Fine(cents)" };
		ArrayList<ArrayList<Object>> result1 = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> row = new ArrayList<Object>();
		result1 = m.execQuery("SELECT DISTINCT READERID FROM BORROWS ;");

		Object[][] array = new Object[result1.size()][2];
		for (int i = 0; i < result1.size(); i++) {
			row.add(result1.get(i).toString().replaceAll("\\[", "").replaceAll("\\]", ""));
			array[i][0] = String.valueOf(result1.get(i)).replaceAll("\\[", "").replaceAll("\\]", "");
		}

		ArrayList<ArrayList<Object>> result2 = new ArrayList<ArrayList<Object>>();
		double avg = 0;
		double avfn = 0;
		for (int i = 0; i < result1.size(); i++) {
			avg = 0;
			avfn = 0;
			result2 = m.execQuery("SELECT BDTIME, RDTIME FROM `BORROWS` WHERE READERID ='" + array[i][0] + "' ;");
			for (int j = 0; j < result2.size(); j++) {
				ArrayList<Object> row1 = result2.get(j);
				Timestamp a = (Timestamp) row1.get(0);
				Timestamp b = (Timestamp) row1.get(1);
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
					avg = avg + 20 * diff2;
					System.out.println(result2.size());

				} else {
					row.add(0.0);
				}
				avfn = avg / result2.size();
				array[i][1] = String.valueOf(avfn);
			}

		}

		DefaultTableModel tm = new DefaultTableModel(array, columnNames);

		setBounds(100, 100, 1358, 610);
		getContentPane().setLayout(null);
		getContentPane().add(contentPanel);

		JScrollPane scrollPane = ComponentUtils.getJScrollPane(6, 51, 1308, 480);
		contentPanel.add(scrollPane);

		tableAverageFine = new JTable();
		scrollPane.setViewportView(tableAverageFine);
		tableAverageFine.setModel(tm);

	}

}
