package com.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.main.admin.AdminModule;
import com.main.reader.ReaderModule;

public class Main {
	public static void main(String[] args) {
		try {
			System.out.println("Please select menu options and press enter");
			System.out.println("1) Reader Functions");
			System.out.println("2) Administrative Functions");
			System.out.println("3) Quit");
			// Take choice
			Scanner sc = new Scanner(System.in);
			int i = sc.nextInt();
			switch (i) {
			case 1:
				readerFunctions();
				break;

			case 2:
				adminFunctions();
				break;

			case 3:
				quit();
				break;

			default:
				System.out.println("Invalid option!!");
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void readerFunctions() throws SQLException, ParseException {
		ReaderModule module = new ReaderModule();
		System.out.println("Hi, please enter your Card Number");
		Scanner sc = new Scanner(System.in);
		String readerId = sc.nextLine();
		System.out.println("Hello user " + readerId + ", select the action you want to perform and press enter");
		System.out.println("1) Search Document by ID, title or publisher name");
		System.out.println("2) Document checkout");
		System.out.println("3) Document return");
		System.out.println("4) Document reserve");
		System.out.println("5) Compute fine for a document copy borrowed by reader based on current date");
		System.out.println("6) Print list of documents reserved by a reader and their status");
		System.out.println("7) Print the document id and document titles of docuements published by a publisher");
		System.out.println("8) Quit");
		Scanner sc1 = new Scanner(System.in);
		int i = sc1.nextInt();
		switch (i) {
		case 1:
			module.searchDocument();
			break;
		case 2:
			module.documentCheckout();
			break;
		case 3:
			module.documentReturn();
			break;
		case 4:
			module.documentReserve(readerId);
			break;
		case 5:
			Scanner sc2 = new Scanner(System.in);
			System.out.println("Enter Borrow number");
			int bnum = sc2.nextInt();
			module.computeFine(bnum);
			sc2.close();
			break;
		case 6:
			module.printListDocuments();
			break;
		case 7:
			module.printDocDetailsByPublisher();
			break;
		case 8:
			quit();
			break;
		default:
			System.out.println("Invalid option!!");
		}
		sc.close();
		sc1.close();
	}

	private static void adminFunctions() throws SQLException {
		AdminModule module = new AdminModule();
		System.out.println("Hi, please enter your ID");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		System.out.println("please enter your password");
		String password = sc.nextLine();
		System.out.println("Hello user " + id + ", select the action you want to perform and press enter");
		System.out.println("1) Add a document copy");
		System.out.println("2) Search document copy and check its status");
		System.out.println("3) Add new reader");
		System.out.println("4) Print branch information(name and location)");
		System.out.println(
				"5) Print top 10 most frequent borrowers in a branch and the number of books each has borrowed");
		System.out.println("6) Print top 10 most borrowed books in a branch");
		System.out.println("7) Print top 10 most popular books of the year");
		System.out.println("8) Find the average fine paid per reader");
		System.out.println("9) Quit");
		Scanner sc1 = new Scanner(System.in);
		int i = sc1.nextInt();
		switch (i) {
		case 1:
			module.addDocumentCopy();
			break;
		case 2:
			module.searchDocumentCopy();
			break;
		case 3:
			module.addReader();
			break;
		case 4:
			module.printBranchInfo();
			break;
		case 5:
			module.printTopBorrowersByBranch();
			break;
		case 6:
			module.printTopBorrowedBooksByBranch();
			break;
		case 7:
			module.printMostPopularBooksOfYear();
			break;
		case 8:
			module.averageFinePerReader();
			break;
		case 9:
			quit();
			break;
		default:
			System.out.println("Invalid option!!");
		}
		sc.close();
		sc1.close();
	}

	private static void quit() {
		System.exit(0);
	}
}
