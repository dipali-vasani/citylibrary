package com.main.admin;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.main.db.Connect2Mysql;

public class DocAdd extends Connect2Mysql {
	static Statement stmt = null;

	public void newDocAdd() throws SQLException {
		System.out.println("Select the type of Document you wish to add: ");
		System.out.println("1) Book");
		System.out.println("2) Journal Volume");
		System.out.println("3) Conference proceedings");
		System.out.println("4) Exit");
		Scanner sc3 = new Scanner(System.in);
		int choice = sc3.nextInt();
		switch (choice) {
		case 1:
			Scanner scBook = new Scanner(System.in);
			System.out.println("Enter the ISBN if the book");
			String isbn = scBook.nextLine();
			System.out.println("Enter a Document ID you want to give for the book");
			// int bookDocId = scBook.nextInt();
			int bookDocId = Integer.parseInt(scBook.nextLine());
			System.out.println("Enter the title of the document");
			String docTitle = scBook.nextLine();
			System.out.println("Enter the Author name of the book");
			String authName = scBook.nextLine();
			System.out.println("Enter the authorID");
			int authId = Integer.parseInt(scBook.nextLine());
			System.out.println("Enter the Library ID you want to add it into");
			int libId = Integer.parseInt(scBook.nextLine());
			System.out.println("Enter the number of copies you want to add");
			int numCopies = Integer.parseInt(scBook.nextLine());
			System.out.println("Enter the publisher name of the document");
			String pubName = scBook.nextLine();
			System.out.println("Enter the publisher ID");
			int pubId = Integer.parseInt(scBook.nextLine());
			System.out.println("Enter the published date in YYYY-dd-mm format");
			String pubDate = scBook.nextLine();
			System.out.println("Enter the position you want to place the copy");
			String bookPos = scBook.nextLine();
			System.out.println("Publisher address. just 1 more question to go. Please bear :p");
			String pubAddress = scBook.nextLine();
			System.out.println("Descriptor of the book");
			String Descriptor = scBook.nextLine();
			fillPublisher(pubId, pubName, pubAddress);
			fillAuth(authId, authName);
			fillDoc(bookDocId, docTitle, pubDate, pubId);
			fillDesc(Descriptor, bookDocId);
			fillCopy(bookPos, bookDocId, libId, numCopies);
			break;
		case 2:
			Scanner scJv = new Scanner(System.in);
			System.out.println("Enter a Document ID you want to give for the Journal volume");
			int jvDocId = Integer.parseInt(scJv.nextLine());
			System.out.println("Enter the title of the document");
			String jvdocTitle = scJv.nextLine();
			System.out.println("Enter the Library ID you want to add it into");
			int jvlibId = Integer.parseInt(scJv.nextLine());
			System.out.println("Enter the number of copies you want to add");
			int jvnumCopies = Integer.parseInt(scJv.nextLine());
			System.out.println("Enter the publisher name of the document");
			String jvpubName = scJv.nextLine();
			System.out.println("Enter the publisher ID");
			int jvpubId = Integer.parseInt(scJv.nextLine());
			System.out.println("Enter the published date in YYYY-dd-mm format");
			String jvpubDate = scJv.nextLine();
			System.out.println("Publisher address.");
			String jvpubAddress = scJv.nextLine();
			System.out.println("Descriptor of the Journal Volume");
			String jvDescriptor = scJv.nextLine();
			System.out.println("Enter the volume number");
			int volNum = Integer.parseInt(scJv.nextLine());
			System.out.println("Enter the issue number");
			int issueNo = Integer.parseInt(scJv.nextLine());
			System.out.println("Enter the scope of the volume");
			String volScope = scJv.nextLine();
			System.out.println("Issue editor ID");
			int Ieditor = Integer.parseInt(scJv.nextLine());
			System.out.println("Enter the chief editor ID");
			int cEditorId = Integer.parseInt(scJv.nextLine());
			System.out.println("Enter the chief editor name");
			String CeditorName = scJv.nextLine();
			System.out.println("Enter the position you want to insert the document");
			String jvPos = scJv.nextLine();
			fillPublisher(jvpubId, jvpubName, jvpubAddress);
			fillDoc(jvDocId, jvdocTitle, jvpubDate, jvpubId);
			fillGuestEditor(Ieditor, issueNo);
			fillChiefEditor(CeditorName, cEditorId);
			fillDesc(jvDescriptor, jvDocId);
			fillCopy(jvPos, jvDocId, jvlibId, jvnumCopies);
			break;
		case 3:
			Scanner scConfPro = new Scanner(System.in);
			System.out.println("Enter the date of the conference in YYYY-mm-dd format");
			String confDate = scConfPro.nextLine();
			System.out.println("Enter the location of conference");
			String confLocation = scConfPro.nextLine();
			System.out.println("Enter the name of Editor");
			String ConfEditorName = scConfPro.nextLine();
			System.out.println("Enter a Document ID you want to give for the conference proceedings");
			int confDocId = Integer.parseInt(scConfPro.nextLine());
			System.out.println("Enter the title of the document");
			String confdocTitle = scConfPro.nextLine();
			System.out.println("Enter the Library ID you want to add it into");
			int conflibId = Integer.parseInt(scConfPro.nextLine());
			System.out.println("Enter the number of copies you want to add");
			int confnumCopies = Integer.parseInt(scConfPro.nextLine());
			System.out.println("Enter the publisher name of the document");
			String confpubName = scConfPro.nextLine();
			System.out.println("Enter the publisher ID");
			int confpubId = Integer.parseInt(scConfPro.nextLine());
			System.out.println("Enter the published date in YYYY-dd-mm format");
			String confpubDate = scConfPro.nextLine();
			System.out.println("Enter the position you want to enter the document into");
			String confPos = scConfPro.nextLine();
			System.out.println("Publisher address. just 1 more question to go. Please bear :p");
			String confpubAddress = scConfPro.nextLine();
			System.out.println("Descriptor of the conference proceedings");
			String ConfDescriptor = scConfPro.nextLine();
			fillPublisher(confpubId, confpubName, confpubAddress);
			fillDoc(confDocId, confdocTitle, confpubDate, confpubId);
			fillConf(confDate, confLocation, ConfEditorName, confDocId);
			fillCopy(confPos, confDocId, conflibId, confnumCopies);
			break;
		case 4:
			java.lang.System.exit(0);
			break;
		default:
			System.out.println("Invalid option");
			java.lang.System.exit(0);
		}

	}

	public void fillPublisher(int PubId, String PubName, String PubAddress) throws SQLException {
		String sql = "INSERT INTO PUBLISHER VALUES (" + PubId + ", '" + PubName + "', '" + PubAddress + "')";
		Connect();
		stmt = createStatement();
		stmt.executeUpdate(sql);
		System.out.println(sql);
		CloseConnection();
	}

	public void fillAuth(int authId, String authName) throws SQLException {
		String sql1 = "INSERT INTO AUTHOR VALUES (" + authId + ", '" + authName + "')";
		Connect();
		stmt = createStatement();
		stmt.executeUpdate(sql1);
		System.out.println(sql1);
		CloseConnection();
	}

	public void fillDoc(int docId, String docTitle, String pubDate, int PubId) throws SQLException {
		String sql2 = "INSERT INTO DOCUMENT VALUES (" + docId + ", '" + docTitle + "', '" + pubDate + "', " + PubId
				+ ")";
		Connect();
		stmt = createStatement();
		stmt.executeUpdate(sql2);
		System.out.println(sql2);
		CloseConnection();
	}

	public void fillDesc(String Descriptor, int DocID) throws SQLException {
		String sql3 = "INSERT INTO DES_KEYWORD VALUES ('" + Descriptor + "', " + DocID + ")";
		Connect();
		stmt = createStatement();
		stmt.executeUpdate(sql3);
		System.out.println(sql3);
		CloseConnection();
	}

	public void fillCopy(String pos, int DocId, int LibId, int numCopy) throws SQLException {
		String sql4 = "INSERT INTO COPY VALUES ('" + pos + "', " + DocId + ", " + LibId + ", " + numCopy + ")";
		Connect();
		stmt = createStatement();
		stmt.executeUpdate(sql4);
		System.out.println(sql4);
		CloseConnection();
	}

	public void fillConf(String cdate, String clocation, String ceditor, int docid) throws SQLException {
		String sql5 = "INSERT INTO PROCEEDINGS VALUES ('" + cdate + "', '" + clocation + "', '" + ceditor + "', "
				+ docid + ")";
		Connect();
		stmt = createStatement();
		stmt.executeUpdate(sql5);
		System.out.println(sql5);
		CloseConnection();
	}

	public void fillGuestEditor(int eid, int issueNo) throws SQLException {
		String sql6 = "INSERT INTO GUEST_EDITOR VALUES (" + eid + ", " + issueNo + ")";
		Connect();
		stmt = createStatement();
		stmt.executeUpdate(sql6);
		System.out.println(sql6);
		CloseConnection();
	}

	public void fillChiefEditor(String ename, int eid) throws SQLException {
		String sql7 = "INSERT INTO CHIEF_EDITOR VALUES ('" + ename + "', " + eid + ")";
		Connect();
		stmt = createStatement();
		stmt.executeUpdate(sql7);
		System.out.println(sql7);
		CloseConnection();
	}
}
