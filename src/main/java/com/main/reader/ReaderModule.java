package com.main.reader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.main.db.Connect2Mysql;

public class ReaderModule extends Connect2Mysql {
	private Connection conn;
	private Statement stmt;

	private void initDB() {
		conn = Connect();
		stmt = createStatement();
	}

	public ReaderModule() {
		initDB();
	}

	public void searchDocument() {

	}

	public void documentCheckout() {

	}

	public void documentReturn() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Borrow number");
			int bnum = sc.nextInt();
			computeFine(bnum);
			String qry1 = "DELETE FROM BORROWS WHERE BORNUMBER =" + bnum;
			Statement stmt2 = conn.createStatement();
			stmt2.executeUpdate(qry1);
			stmt2.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void documentReserve(String readerId) throws SQLException {
		System.out.println("Enter the Document ID you want to reserve");
		Scanner sc = new Scanner(System.in);
		int DocId = sc.nextInt();
		System.out.println("Enter the library ID of the library you want to make your reservation in : ");
		Scanner sc1 = new Scanner(System.in);
		int LibId = sc1.nextInt();
		int newResNum = 0;
		int CopyNum = 0;
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = "\'" + sdf.format(dt) + "\'";
		String sql = "SELECT MAX(ResNumber) as mxres FROM RESERVATION";
		ResultSet rs3 = stmt.executeQuery(sql);
		while (rs3.next()) {
			// Retrieve by column name
			int resNum = rs3.getInt("mxres");
			newResNum = resNum + 1;
			// System.out.println("Reservation number is : " +resNum);
		}
		Statement stmt2 = conn.createStatement();
		String qry = " SELECT c.Copy_No FROM COPY c WHERE c.DocId=" + DocId + " AND c.LibId=" + LibId;
		System.out.println(qry);
		ResultSet rs4 = stmt2.executeQuery(qry);
		while (rs4.next()) {
			CopyNum = rs4.getInt("Copy_No");
		}
		if (CopyNum == 0) {
			System.out.println("The Document is not available, Do you want to add the document in your waitlist? ");
			System.out.println("1. Yes");
			System.out.println("2. No");
			Scanner sc2 = new Scanner(System.in);
			int a = sc2.nextInt();
			switch (a) {
			case 1:
				String sql3 = "INSERT INTO RESERVATION VALUES (" + newResNum + "," + currentTime + "," + DocId + ","
						+ LibId + "," + CopyNum + "," + readerId + ", \'Waitlist\')";
				System.out.println(sql3);
				Statement stmt4 = conn.createStatement();
				stmt4.executeUpdate(sql3);
				java.lang.System.exit(0);
				break;
			case 2:
				java.lang.System.exit(0);
				break;
			default:
				System.out.println("Invalid Option");
				java.lang.System.exit(0);
				break;
			}
			sc2.close();
		} else {
			String sql1 = "INSERT INTO RESERVATION VALUES (" + newResNum + "," + currentTime + "," + DocId + "," + LibId
					+ "," + CopyNum + "," + readerId + ", \'Pending\')";
			stmt.executeUpdate(sql1);
			System.out.println(sql1);
			CloseConnection();
		}
		sc.close();
		sc1.close();

	}

	public void computeFine(int bnum) throws SQLException, ParseException {
		java.util.Date dt = new java.util.Date();
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// dd/MM/yyyy
		String strDate = sdfDate.format(dt);
		SimpleDateFormat sdf1 = new SimpleDateFormat();
		sdf1.applyPattern("yyyy-dd-mm HH:mm:ss.SS");
		Date date = sdf1.parse(strDate);
		String qry = "SELECT RDTIME from BORROWS WHERE BORNUMBER =" + bnum;
		ResultSet rs = stmt.executeQuery(qry);
		Date retdt = null;
		System.out.println("Currect:" + dt);
		while (rs.next()) {
			retdt = rs.getTimestamp("RDateTime");

		}
		System.out.println("RDateTime:" + retdt);
		long diff = date.getTime() - retdt.getTime();
		double fine = 0;
		System.out.println("mili seconds:" + diff);
		if (diff < 0) {
			System.out.println("The Document is returned within the deadline");
		} else {
			double days = (diff / (1000 * 60 * 60 * 24));
			System.out.println("days" + days);
			int round = (int) Math.ceil(days);
			System.out.println("day" + round);
			fine = days * 0.3;
			System.out.println("Fine is $" + fine);
		}
	}

	public void printListDocuments() {

	}

	public void printDocDetailsByPublisher() {

	}

}
