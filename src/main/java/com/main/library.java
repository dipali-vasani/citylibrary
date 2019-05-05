package com.main;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Code reference for GUI [ java swing]  : http://www3.ntu.edu.sg/home/ehchua/programming/java/j4a_gui.html
 *                            http://www.tutorialspoint.com/swing/swing_jframe.html
 * Code Reference for database [jdbc ] : Stackoverflow.com
 *                               https://docs.oracle.com/javase/tutorial/jdbc/basics/
 */

public class library extends JFrame {

	private JFrame mainFrame;
	private JFrame initFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private JPanel initPanel;
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:MySQL://192.168.1.197:3306/Library";
	private static final String username = "CS631";
	private static final String password = "002631S";
	private static int flag = 0;
	static Connection db;
	static library swingControlDemo;

	public library() {

		initGUI();

	}

	public static void main(String[] args) throws Exception {
		Class.forName(driver);
		db = DriverManager.getConnection(url, username, password);
		swingControlDemo = new library();
		swingControlDemo.showMainMenu();

		/*
		 * else if (result == 2) { swingControlDemo.showAdminMenu(); } else if (result
		 * == 3) { swingControlDemo.showReaderMenu(); }
		 */
	}

	private void initGUI() {
		/*
		 * start the Init Menu window
		 */
		initFrame = new JFrame("welcome page");
		initFrame.setSize(400, 400);
		initFrame.setLayout(new GridLayout(3, 1));
		initFrame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent windowEvent) {
				swingControlDemo.prepareGUI();
				if (flag == 0) {
					System.out.println(" username/password is wrong");
					System.exit(0);

				}
				if (flag == 1) {
					System.out.println(" options are not proper");
					System.exit(0);

				}
				if (flag == 3) {
					swingControlDemo.showAdminMenu();
				}
				if (flag == 2) {
					swingControlDemo.showReaderMenu();
				}

			}
		});
		/*
		 * Adding all required parts
		 */
		initPanel = new JPanel();
		initPanel.setLayout(new FlowLayout());
		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setSize(350, 100);
		initPanel = new JPanel();
		initPanel.setLayout(new FlowLayout());
		initFrame.add(initPanel);
		initFrame.add(headerLabel);
		initFrame.add(initPanel);
		initFrame.add(statusLabel);
		initFrame.setVisible(true);
	}

	private void prepareGUI() {
		/*
		 * This one launches the window
		 */
		// =====================================

		mainFrame = new JFrame("Welcome READER/Admin Menu");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setSize(350, 100);
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}

	public void showMainMenu() {
		final Map<String, String> unamepass;
		unamepass = new HashMap<String, String>();
		/*
		 * Only two user exists ,
		 */
		unamepass.put("ritu", "abc");
		unamepass.put("kitu", "xyz");

		headerLabel.setText("WELCOME to Library");
		JLabel namelabel = new JLabel("username: ", JLabel.RIGHT);
		JLabel namelabel1 = new JLabel("password: ");
		JLabel namelabel2 = new JLabel("read/Admin");

		// System.out.println(" 9999999");
		final JTextField adduname = new JTextField(6);
		final JTextField addpass = new JTextField(6);
		final JTextField choice = new JTextField(6);

		JButton insertcommands = new JButton("execute Command");

		insertcommands.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = adduname.getText();
				String pass = addpass.getText();
				String mychoice = choice.getText();
				String data = "";

				if (unamepass.containsKey(uname)) {
					// System.out.println(uname+pass);
					String val = unamepass.get(uname);
					if (val.equals(pass)) {
						flag = 1;
					} else {
						System.out.println("username password does not match, close window");
						flag = 0;
					}
				}
				if (flag == 1) {
					System.out.println("username password matches, close window");
					if (mychoice.equals("R"))
						flag = 2;
					if (mychoice.equals("A"))
						flag = 3;
				}

			}
		});

		initPanel.add(namelabel);
		initPanel.add(adduname);
		initPanel.add(namelabel1);
		initPanel.add(addpass);
		initPanel.add(namelabel2);
		initPanel.add(choice);
		initPanel.add(insertcommands);
		initFrame.setVisible(true);

	}

	public void showAdminMenu() {
		headerLabel.setText("Administrative Menu");
		JLabel namelabel = new JLabel("add document: ", JLabel.RIGHT);
		JLabel namelabel1 = new JLabel("searchdoc: ");
		JLabel namelabel2 = new JLabel("addread: ");
		final JTextField adddocument = new JTextField(6);
		final JTextField searchdocument = new JTextField(6);
		final JTextField addread = new JTextField(6);
		JButton insertcommands = new JButton("execute Command");

		insertcommands.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "";
				if (!adddocument.getText().isEmpty()) {

					try {
						String key = "'" + adddocument.getText() + "999'";
						System.out.println(query);
						query = "INSERT INTO DOCUMENT (DOCID, TITLE, PDATE, PUBLISHERID) VALUES (" + key
								+ " , 'ENGLISH','2016-01-11 ','P1010')";
						Statement stmt = db.createStatement();
						stmt.execute(query);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				// to be written
				if (!searchdocument.getText().isEmpty()) {
					try {
						String docid = "'" + searchdocument.getText() + "'";
						query = "SELECT R.DOCID, R.RESNUMBER FROM RESERVES R WHERE R.DOCID = " + docid
								+ " UNION SELECT B.DOCID, B.BORNUMBER FROM BORROWS B WHERE B.DOCID =" + docid;
						Statement stmt = db.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						String data = "";
						try {
							while (rs.next()) {
								String docid1 = rs.getString("DOCID");
								int resnumber = rs.getInt("RESNUMBER");
								// int bornumber = rs.getInt("BORNUMBER");
								data += docid1 + '\t' + String.valueOf(resnumber) + '\n';
								statusLabel.setText(data);
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						System.out.println(data);
						statusLabel.setText(data);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if (!addread.getText().isEmpty()) {
					try {
						String key = "'" + adddocument.getText() + "RID9999'";
						System.out.println(query);
						query = "INSERT INTO READER (READERID, RTYPE,RNAME, ADDRESS) VALUES (" + key
								+ " , 'STAFF', 'ALEX', 'MUMBAI')";
						Statement stmt = db.createStatement();
						ResultSet rs = stmt.executeQuery(query);

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}

		});

		JButton PrintBranchInfo = new JButton("Print Branch Info");
		PrintBranchInfo.addActionListener(new ActionListener() {
			ResultSet rs;

			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = db.createStatement();
					rs = stmt.executeQuery("SELECT LNAME, LLOCATION FROM BRANCH");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				String data = "";
				try {
					while (rs.next()) {
						String lname = rs.getString("LNAME");
						String location = rs.getString("LLOCATION");
						data += lname + " " + location + '\n';
						// statusLabel.setText(data);
						// System.out.println(data);
						// String data = "document to add " + adddocument.getText();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println(data);
				statusLabel.setText(data);
			}
		});

		JButton Top10borrowersBooks = new JButton("Top 10 Borrowers");
		Top10borrowersBooks.addActionListener(new ActionListener() {

			ResultSet rs;

			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = db.createStatement();
					rs = stmt.executeQuery("select count(b.docid) as doccount, b.readerid  from borrows b, book book "
							+ " where b.LIBID =  'L1011' and b.docid=book.docid  group by b.readerid"
							+ " order by count(b.docid) desc limit 10");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				String data = "";
				try {
					while (rs.next()) {

						String readerid = rs.getString("READERID");
						int countdoc = rs.getInt("doccount");
						data += "  " + readerid + "  " + String.valueOf(countdoc) + '\n';
						statusLabel.setText(data);
						System.out.println(data);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				statusLabel.setText(data);
			}
		});
		/*
		 * We here keep libid hard coded as L1011
		 */
		JButton Top10borrowedBooks = new JButton("Top 10 borrowed Books");
		Top10borrowedBooks.addActionListener(new ActionListener() {
			ResultSet rs;

			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = db.createStatement();
					rs = stmt.executeQuery("select  b.docid, count(b.readerid) as doccount "
							+ " from borrows b, book book where b.LIBID =  'L1011' and book.docid "
							+ "= b.docid  group by b.docid order by count(b.readerid) desc limit 10");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				String data = "";
				try {
					while (rs.next()) {

						String readerid = rs.getString("docid");
						int countdoc = rs.getInt("doccount");
						data += "  " + readerid + "  " + String.valueOf(countdoc) + '\n';
						statusLabel.setText(data);
						// System.out.println(data);
						// String data = "document to add " + adddocument.getText();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(data);
				statusLabel.setText(data);
			}
		});

		JButton Top10PopularBooks = new JButton("Print popular Books");
		Top10PopularBooks.addActionListener(new ActionListener() {
			ResultSet rs;

			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = db.createStatement();
					rs = stmt.executeQuery("select  b.docid, count(b.readerid)  from borrows b,"
							+ " book book where book.docid = b.docid  group by b.docid order"
							+ " by count(b.readerid) desc limit 10");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				String data = "";
				try {
					while (rs.next()) {

						String readerid = rs.getString("docid");
						int countdoc = rs.getInt("count(b.readerid)");
						data += "  " + readerid + "  " + String.valueOf(countdoc) + '\n';
						statusLabel.setText(data);
						// System.out.println(data);
						// String data = "document to add " + adddocument.getText();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println(data);
				statusLabel.setText(data);
			}

		});
		JButton AvgFine = new JButton("Average Fine");
		AvgFine.addActionListener(new ActionListener() {
			ResultSet rs;

			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select T.readerid,avg(T.fine)  as avfine from (select readerid,case when "
							+ " timestampdiff(day,BDTIME,now()) > 20 THEN"
							+ " timestampdiff(day,RDTIME,now())  * .20 ELSE 0 END AS fine  from borrows ) As T  group by T.readerid";
					Statement stmt = db.createStatement();
					rs = stmt.executeQuery(query);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				String data = "";
				try {
					while (rs.next()) {

						String readerid = rs.getString("readerid");
						double countdoc = rs.getDouble("avfine");
						data += "  " + readerid + "  " + String.valueOf(countdoc) + '\n';
						statusLabel.setText(data);
						// System.out.println(data);
						// String data = "document to add " + adddocument.getText();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println(data);
				statusLabel.setText(data);
			}

		});
		controlPanel.add(namelabel);
		controlPanel.add(adddocument);
		controlPanel.add(namelabel1);
		controlPanel.add(searchdocument);
		controlPanel.add(namelabel2);
		controlPanel.add(addread);
		controlPanel.add(insertcommands);
		controlPanel.add(PrintBranchInfo);
		controlPanel.add(Top10borrowersBooks);
		controlPanel.add(Top10borrowedBooks);
		controlPanel.add(Top10PopularBooks);
		controlPanel.add(AvgFine);
		controlPanel.add(insertcommands);
		mainFrame.setVisible(true);

	}

	public void showReaderMenu() {
		headerLabel.setText("Reader Menu");
		JLabel namelabel = new JLabel("search document: ", JLabel.RIGHT);
		JLabel namelabel1 = new JLabel("doc checkout: ");
		JLabel namelabel2 = new JLabel("doc return ");
		JLabel namelabel3 = new JLabel("doc reserve ");

		final JTextField searchdoc = new JTextField(6);
		final JTextField doccheckout = new JTextField(6);
		final JTextField docreturn = new JTextField(6);
		final JTextField docreserve = new JTextField(6);
		JButton insertcommands = new JButton("execute Command");

		insertcommands.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "";
				/*
				 * for Query 1: Search document by ID / title / publisher name sample O/p
				 * 
				 */
				if (!searchdoc.getText().isEmpty()) {
					try {
						String docid = "'" + searchdoc.getText() + "'";
						query = "SELECT DOC.DOCID, DOC.TITLE,DOC.PDATE, PUB.PUBNAME FROM PUBLISHER AS PUB, DOCUMENT AS DOC WHERE PUB.PUBLISHERID = DOC.PUBLISHERID AND PUB.PUBNAME="
								+ docid
								+ "UNION SELECT DOC.DOCID, DOC.TITLE,DOC.PDATE, PUB.PUBNAME FROM DOCUMENT AS DOC, PUBLISHER AS PUB WHERE PUB.PUBLISHERID = DOC.PUBLISHERID AND ( DOCID ="
								+ docid + "  or " + "title =" + docid + ")";
						Statement stmt = db.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						String data = "";
						try {
							while (rs.next()) {
								String docid1 = rs.getString("DOCID");
								String title = rs.getString("TITLE");
								String pdate = rs.getString("PDATE");
								String pubname = rs.getString("PUBNAME");
								data += docid1 + " " + title + " " + pdate + " " + pubname + '\n';
								statusLabel.setText(data);
								// System.out.println(data);
								// String data = "document to add " + adddocument.getText();
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						System.out.println(data);
						statusLabel.setText(data);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
				if (!doccheckout.getText().isEmpty()) {
					/*
					 * Query 2 . Insert based on readerID , we assume readerid is constant READERID
					 * = RED51 Insert DOCID : D2020
					 */
					try {
						String key = doccheckout.getText();

						query = "INSERT  INTO  BORROWS (READERID, DOCID, COPYNO, LIBID, BDTIME, RDTIME) VALUES ('RED51', '"
								+ key + "', 1, 'L1011', '2016-03-25 10:45:23','2016-03-25 11:32:56')";
						System.out.println(query);
						Statement stmt = db.createStatement();
						stmt.executeQuery(query);

					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
				if (!docreserve.getText().isEmpty()) {
					/*
					 * Will work for doc = DB2026READERID is hardcoded READERID = RED51
					 * 
					 */
					try {
						String key = docreserve.getText();
						query = "INSERT INTO RESERVES (READERID, DOCID, COPYNO, LIBID, DTIME) VALUES ('RED51', '" + key
								+ "', 1, 'L1011', '2016-11-23 11:45:10')";
						System.out.println(query);
						Statement stmt = db.createStatement();
						stmt.executeQuery(query);

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if (!docreturn.getText().isEmpty()) {
					/*
					 * Document return status , returns for document d2020 shows docid and return
					 * time
					 */
					try {
						String docid = "'" + docreturn.getText() + "'";
						query = "SELECT DOCID, RDTIME FROM BORROWS WHERE DOCID=" + docid;
						// System.out.println(query);
						Statement stmt = db.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						String data = "";
						try {
							while (rs.next()) {
								String docid1 = rs.getString("DOCID");
								String title = rs.getString("RDTIME");
								data += " " + docid1 + "  " + title + '\n';
								statusLabel.setText(data);
								// System.out.println(data);
								// String data = "document to add " + adddocument.getText();
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						System.out.println(data);
						statusLabel.setText(data);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
			}
		});
		/*
		 * This button is to display the status ==> what it returns ?
		 */
		JButton PrintDocreserve = new JButton("Print Document reserve ");
		PrintDocreserve.addActionListener(new ActionListener() {
			ResultSet rs;

			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = db.createStatement();
					rs = stmt.executeQuery(
							"SELECT R.READERID, R.RESNUMBER AS RESNUMBER_BORNUMBER, R.DOCID, R.DTIME, B.BDTIME FROM RESERVES R  , borrows B WHERE R.READERID = 'RED51' OR B.READERID= 'RED51'");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				String data = "";
				try {
					while (rs.next()) {
						String lname = rs.getString("READERID");
						String dtime = rs.getString("DTIME");
						String bdtime = rs.getString("BDTIME");
						data += lname + " " + dtime + " " + bdtime + '\n';
						statusLabel.setText(data);
						// System.out.println(data);
						// String data = "document to add " + adddocument.getText();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println(data);
				statusLabel.setText(data);
			}
		});
		/*
		 * This operation for publish List , Question 4 for READER MENU
		 */
		JButton publishlist = new JButton("publish list");
		publishlist.addActionListener(new ActionListener() {

			ResultSet rs;

			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = db.createStatement();
					rs = stmt.executeQuery(
							"SELECT D.DOCID, D.TITLE FROM DOCUMENT D, PUBLISHER P WHERE D.PUBLISHERID=P.PUBLISHERID AND P.PUBNAME='PEARSON';");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				String data = "";
				try {
					while (rs.next()) {
						String lname = rs.getString("DOCID");
						String readerid = rs.getString("TITLE");
						data += lname + " " + readerid + " " + '\n';
						statusLabel.setText(data);
						// System.out.println(data);
						// String data = "document to add " + adddocument.getText();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(data);
				statusLabel.setText(data);
			}
		});
		/*
		 * Calculate fine based on current data from borrowers table
		 */
		JButton calcfine = new JButton("calculate fine");
		calcfine.addActionListener(new ActionListener() {

			ResultSet rs;

			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = db.createStatement();
					rs = stmt.executeQuery("select readerid, case " + " when  timestampdiff(day,BDTIME,now()) > 20 "
							+ " THEN timestampdiff(day,RDTIME,now())  * .20 " + " ELSE 0 " + "END AS fine "
							+ "from borrows");

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				String data = "";
				try {
					while (rs.next()) {
						String lname = rs.getString("readerid");
						double readerid = rs.getDouble("fine");
						data += "  " + lname + " " + String.valueOf(readerid) + " " + '\n';
						statusLabel.setText(data);
						// System.out.println(data);
						// String data = "document to add " + adddocument.getText();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println(data);
				statusLabel.setText(data);
			}
		});
		/*
		 * Adding all button, texts to panel window
		 */
		controlPanel.add(namelabel);
		controlPanel.add(searchdoc);
		controlPanel.add(namelabel1);
		controlPanel.add(doccheckout);
		controlPanel.add(namelabel2);
		controlPanel.add(docreturn);
		controlPanel.add(namelabel3);
		controlPanel.add(docreserve);
		controlPanel.add(publishlist);
		controlPanel.add(PrintDocreserve);
		controlPanel.add(calcfine);
		controlPanel.add(insertcommands);
		mainFrame.setVisible(true);

	}

}