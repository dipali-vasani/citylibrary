package com.main.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.main.db.Connect2Mysql;

public class AdminModule extends Connect2Mysql {
	private Connection conn;
	private Statement stmt;

	private void initDB() {
		conn = Connect();
		stmt = createStatement();
	}

	public AdminModule() {
		initDB();
	}

	public void addDocumentCopy() throws SQLException {
		Scanner scBook = new Scanner(System.in);
		System.out.println("Enter a Document ID you want to give for the book");
		String bookDocId = scBook.nextLine();
		System.out.println("Enter the number of copies you want to add");
		int numcopies = Integer.parseInt(scBook.nextLine());
		System.out.println("Enter the Library ID you want to add it into");
		String libId = scBook.nextLine();
		System.out.println("Enter the position you want to place the copy");
		String pos = scBook.nextLine();
		String sqlcopynum = "UPDATE COPY SET COPYNO = COPYNO+" + numcopies + " WHERE DocId = " + bookDocId
				+ " AND LibId = " + libId + " AND Position = " + "\'" + pos + "\'";
		stmt.executeUpdate(sqlcopynum);
		scBook.close();
		System.out.println(sqlcopynum);
	}

	public void searchDocumentCopy() {

	}

	public void addReader() {

	}

	public void printBranchInfo() throws SQLException {
		String sql = "SELECT DISTINCT LibId, Name, Location FROM BRANCH";
		ResultSet rs = stmt.executeQuery(sql);
		// STEP 5: Extract data from result set
		while (rs.next()) {
			// Retrieve by column name
			int id = rs.getInt("LibId");
			String Libname = rs.getString("Name");
			String location = rs.getString("Location");
			// Display values
			System.out.print("Library ID: " + id);
			System.out.print(",   Library name: " + Libname);
			System.out.println(",   Location: " + location);
		}
	}

	public void printTopBorrowersByBranch() {

	}

	public void printTopBorrowedBooksByBranch() {

	}

	public void printMostPopularBooksOfYear() throws SQLException {
		String sql = "SELECT COUNT(DISTINCT b.DocId) AS DocCount,  d.Title FROM BORROWS b, DOCUMENT d ORDER BY DocCount DESC";
		ResultSet rs3 = stmt.executeQuery(sql);
		while (rs3.next()) {
			// Retrieve by column name
			int DocCount = rs3.getInt("DocCount");
			String DTitle = rs3.getString("Title");
			// Display values
			System.out.print(" Number of times document was borrowed : " + DocCount);
			System.out.println(",   Title of the document borrowed: " + DTitle);
		}
	}

	public void averageFinePerReader() {

	}

}
