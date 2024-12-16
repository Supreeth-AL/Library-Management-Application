package com.lib.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Model {
	// user registration and login
	private String userid;
	private String name;
	private String email;
	private String phoneno;
	private String password;

	// all available book in library
	private String bookid;
	private String bname;
	private String author;
	private String rcopies;

	// all available staff in library
	private String Staffid;
	private String sname;
	private String semail;
	private String saddress;
	private String sphoneno;

//  borrowhistory in library
	private String borBookId;
	private String borBookname;
	private String borAuthor;
	private String borHistory;

	// global variable
	private Connection con;
	private PreparedStatement pstmt;

	// Getters and Setters

	public String getBorBookId() {
		return borBookId;
	}

	public void setBorBookId(String borBookId) {
		this.borBookId = borBookId;
	}

	public String getBorBookname() {
		return borBookname;
	}

	public void setBorBookname(String borBookname) {
		this.borBookname = borBookname;
	}

	public String getBorAuthor() {
		return borAuthor;
	}

	public void setBorAuthor(String borAuthor) {
		this.borAuthor = borAuthor;
	}

	public String getBorHistory() {
		return borHistory;
	}

	public void setBorHistory(String borHistory) {
		this.borHistory = borHistory;
	}

	public String getStaffid() {
		return Staffid;
	}

	public void setStaffid(String staffid) {
		Staffid = staffid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public String getSphoneno() {
		return sphoneno;
	}

	public void setSphoneno(String sphoneno) {
		this.sphoneno = sphoneno;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCopies() {
		return rcopies;
	}

	public void setCopies(String copies) {
		this.rcopies = copies;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Constructor for establishing the connection
	public Model() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagement", "root", "root");
		System.out.println("Driver loaded and connection established to LibraryManagement");
	}

	// Method for user registration
	public boolean Registration() throws SQLException {
		String s = "insert into library values(?,?,?,?,?)";
		pstmt = con.prepareStatement(s);
		pstmt.setString(1, userid);
		pstmt.setString(2, name);
		pstmt.setString(3, email);
		pstmt.setString(4, phoneno);
		pstmt.setString(5, password);
		int x = pstmt.executeUpdate();
		return x > 0;
	}

// Method for user login
	public boolean Login() throws SQLException {
		String s = "select * from library where userid = ? and password = ?";
		pstmt = con.prepareStatement(s);
		pstmt.setString(1, userid);
		pstmt.setString(2, password);
		ResultSet res = pstmt.executeQuery();
		return res.next();
	}

// Method to fetch all books from the database
	public List<Model> getAllBooks() throws Exception {
		String query = "SELECT * FROM book";
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery(query);
		System.out.println("availabelbook");
		List<Model> books = new ArrayList<>();

		while (res.next()) {
			Model book = new Model();
			book.setBookid(res.getString("bookid"));
			book.setBname(res.getString("bname"));
			book.setAuthor(res.getString("author"));
			book.setCopies(res.getString("rcopies"));


			books.add(book);
		}
		return books;
	}

// Method to fetch all Staff from the database
	public List<Model> getAllstaffs() throws Exception {
		String query = "SELECT * FROM Staff";
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery(query);
		System.out.println("availabelStaff");
		List<Model> staffs = new ArrayList<>();
		while (res.next()) {
			Model staff = new Model();
			staff.setStaffid(res.getString("staffid"));
			staff.setSname(res.getString("sname"));
			staff.setSemail(res.getString("semail"));
			staff.setSaddress(res.getString("saddress"));
			staff.setSphoneno(res.getString("sphoneno"));

			staffs.add(staff);
		}
		return staffs;
	}

// for booksearch
	public List<Model> Booksearch(String bname, String author) throws Exception {
	    String s = "SELECT bookid, bname, author FROM book WHERE bname LIKE ? OR author LIKE ?";
	    pstmt = con.prepareStatement(s);
	    pstmt.setString(1, "%" + bname + "%");
	    pstmt.setString(2, "%" + author + "%");
	    ResultSet res = pstmt.executeQuery();
	    List<Model> bsearch = new ArrayList<>();

	    while (res.next()) {
	        Model bsearch1 = new Model();
	        bsearch1.setBookid(res.getString("bookid"));
	        bsearch1.setBname(res.getString("bname"));
	        bsearch1.setAuthor(res.getString("author"));
	        bsearch.add(bsearch1);
	    }

	    return bsearch;
	}



	// Fetch book details
	public LinkedList<String> fetchBookDetails(String bookId) throws Exception {
		LinkedList<String> bookDetails = new LinkedList<>();
		String fetchQuery = "SELECT bookid, bname, author FROM book WHERE bookid = ?";

		try (PreparedStatement fetchStmt = con.prepareStatement(fetchQuery)) {

			fetchStmt.setString(1, bookId);
			ResultSet resultSet = fetchStmt.executeQuery();

			if (resultSet.next()) {
				bookDetails.add(resultSet.getString("bookid"));
				bookDetails.add(resultSet.getString("bname"));
				bookDetails.add(resultSet.getString("author"));
			}
		}
		return bookDetails;
	}


	// for inserting book details and with local date
	public boolean addBookToHistory(String bookId, String bookName, String author) throws Exception {
		String insertQuery = "INSERT INTO borrowhistory (borBookId, borBookname, borAuthor, borHistory) VALUES (?, ?, ?, ?)";

		try (PreparedStatement insertStmt = con.prepareStatement(insertQuery)) {

			insertStmt.setString(1, bookId);
			insertStmt.setString(2, bookName);
			insertStmt.setString(3, author);
			insertStmt.setString(4, LocalDate.now().toString());

			int rowsInserted = insertStmt.executeUpdate();
			if (rowsInserted > 0) {
				String s = "Update Book set rcopies = rcopies -1 where BookId = ?";
				pstmt = con.prepareStatement(s);
				pstmt.setString(1, bookId);
				int x = pstmt.executeUpdate();
				if (x > 0) {
					return true;
				} else {
					return false;
				}
			}
			return false;
		}
	}

	//removing book from borrow history
	public boolean RemoveBook(String borBookId) throws SQLException {
		String s = "DELETE FROM borrowhistory WHERE borBookId = ?";

		try {
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, borBookId);
			int x = pstmt.executeUpdate();
			if (x > 0) {
				String s1 = "Update book set rcopies = rcopies +1 where BookId = ?";
				pstmt = con.prepareStatement(s1);
				pstmt.setString(1, borBookId);
				int x1 = pstmt.executeUpdate();
				if (x1 > 0) {
					System.out.println("Record deleted successfully.");
					return true;
				} else {
					return false;
				}

			} else {
				System.out.println("No record found with the given Book ID.");
			}
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return false;
	}

	// fetching all details from borrow history
	public List<Model> BorrowHistory() throws Exception {
		String query = "SELECT borBookId, borBookname, borAuthor, DATE_FORMAT(borHistory, '%d/%m/%y') AS formatted_date FROM borrowhistory";
		Statement stmt = null;
		ResultSet res = null;
		List<Model> borrowhistorys = new ArrayList<>();

		try {
			stmt = con.createStatement();
			res = stmt.executeQuery(query);
			System.out.println("Executing borrow history query...");

			while (res.next()) {
				Model borrowhistory = new Model();
				borrowhistory.setBorBookId(res.getString("borBookId"));
				borrowhistory.setBorBookname(res.getString("borBookname"));
				borrowhistory.setBorAuthor(res.getString("borAuthor"));
				borrowhistory.setBorHistory(res.getString("formatted_date"));

				borrowhistorys.add(borrowhistory);
			}
		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return borrowhistorys;
	}

	//add a book to library
	public boolean AddBookLibrary() throws SQLException {
		String s = "INSERT INTO Book (bookid, bname, author, rcopies) VALUES (?, ?, ?, ?)";
		pstmt = con.prepareStatement(s);
		pstmt.setString(1, bookid);
		pstmt.setString(2, bname);
		pstmt.setString(3, author);
		pstmt.setString(4, rcopies);
		int x = pstmt.executeUpdate();
		if (x > 0) {
			return true;
		}
		return false;
	}


	//delete a book from library
	public boolean DeleteBookLibrary() throws SQLException {
		String s = "DELETE FROM book WHERE BookId = ?";
		pstmt = con.prepareStatement(s);
		pstmt.setString(1, bookid);
		int x = pstmt.executeUpdate();
		if (x > 0) {
			return true;
		}
		return false;
	}

	// add a staff details to library
	public boolean AddStaffDetails() throws SQLException {
		String s = "insert into staff (staffid , sname, semail, saddress, sphoneno) values (?, ?, ?, ?, ?)";
		pstmt = con.prepareStatement(s);
		pstmt.setString(1, Staffid);
		pstmt.setString(2, sname);
		pstmt.setString(3, semail);
		pstmt.setString(4, saddress);
		pstmt.setString(5, sphoneno);
		int x = pstmt.executeUpdate();
		if (x > 0) {
			return true;
		}
		return false;
	}

	//delete a staff details from library
	public boolean DeleteStaffLibrary() throws SQLException {
	    String s = "DELETE FROM Staff WHERE staffid = ?";
	    pstmt = con.prepareStatement(s);
	    pstmt.setString(1, Staffid);
	    int x = pstmt.executeUpdate();
	    return x > 0;
	}

	// checking the book if it is already there
	public boolean isBookInHistory(String bookId) throws Exception {
		String query = "SELECT COUNT(*) FROM borrowhistory WHERE borBookId = ?";
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, bookId);
		ResultSet resultSet = pstmt.executeQuery();

		if (resultSet.next() && resultSet.getInt(1) > 0) {
			return true;
		}
		return false;
	}


}
