package edu.njit.reader;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import edu.njit.components.ComponentUtils;
import edu.njit.db.DBManager;

public class Reader extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6033727127508664388L;
	private JTextField txtDocSearch;
	private JRadioButton radioButtonTitle;
	private JRadioButton radioButtonPublisher;

	/**
	 * Create the frame.
	 */
	public Reader(String cardNumber) {
		setTitle("The City Library");

		getContentPane().setBackground(Color.WHITE);
		// Connect to Database
		DBManager m = DBManager.getInstance();
		m.connect();

		setBounds(100, 100, 780, 500);
		getContentPane().setLayout(null);

		txtDocSearch = ComponentUtils.getJTextField(28, 91, 379, 26, 10);
		getContentPane().add(txtDocSearch);

		getContentPane().add(ComponentUtils.getJLabel(226, 30, 150, 50, "The City Library"));

		getContentPane().add(ComponentUtils.getJLabel(16, 6, 400, 16, "READER ID: " + cardNumber + ""));

		// Radio Button
		JRadioButton radioButtonDocId = ComponentUtils.getJRadioButton(39, 129, 124, 23, "Document Id");
		radioButtonDocId.setSelected(true);
		getContentPane().add(radioButtonDocId);

		radioButtonTitle = ComponentUtils.getJRadioButton(195, 129, 68, 23, "Title");
		getContentPane().add(radioButtonTitle);

		radioButtonPublisher = ComponentUtils.getJRadioButton(287, 129, 95, 23, "Publisher");
		getContentPane().add(radioButtonPublisher);

		ButtonGroup bG = new ButtonGroup();
		bG.add(radioButtonDocId);
		bG.add(radioButtonTitle);
		bG.add(radioButtonPublisher);

		// Search Button
		JButton btnSearch = ComponentUtils.getJButton(425, 91, 117, 29, "Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtDocSearch.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Enter a valid value");
					return;
				}

				int searchType;
				if (radioButtonTitle.isSelected()) {
					searchType = SearchResult.SEARCH_TYPE_TITLE;

				} else if (radioButtonPublisher.isSelected()) {
					searchType = SearchResult.SEARCH_TYPE_PUBLISHER;
				} else {
					searchType = SearchResult.SEARCH_TYPE_ID;
				}
				SearchResult dialog = new SearchResult(txtDocSearch.getText(), searchType, cardNumber);
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});

		getContentPane().add(btnSearch);

		getContentPane().add(ComponentUtils.getJSeparator(46, 197, 1, 12));

		getContentPane().add(ComponentUtils.getJSeparator(6, 197, 536, -60));

		getContentPane().add(ComponentUtils.getJSeparator(0, 223, 572, 16));

		getContentPane().add(ComponentUtils.getJLabel(28, 251, 150, 16, "Reader Profile"));

		JButton btnNewButtonBorrow = ComponentUtils.getJButton(28, 286, 150, 29, "Borrowed Books");
		getContentPane().add(btnNewButtonBorrow);

		JButton btnNewButtonReserve = ComponentUtils.getJButton(208, 286, 150, 29, "Reserved Books");
		getContentPane().add(btnNewButtonReserve);

		JButton btnNewButtonReturn = ComponentUtils.getJButton(388, 286, 114, 29, "Return");
		getContentPane().add(btnNewButtonReturn);

		JButton btnNewButtonFine = ComponentUtils.getJButton(532, 286, 114, 29, "Fine");
		getContentPane().add(btnNewButtonFine);

		btnNewButtonReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Return dialog = new Return(cardNumber);
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		btnNewButtonReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reserve dialog = new Reserve(cardNumber);
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		btnNewButtonBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrow dialog = new Borrow(cardNumber);
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});

		btnNewButtonFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocumentFinePerReader dialog = new DocumentFinePerReader(cardNumber);
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
	}
}
