import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryManagement {

    // Add a new book
    public void addBook(String title, String author, String isbn,
                        int totalCopies) {

        String sql = "INSERT INTO books (title, author, isbn, total_copies, available_copies) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, title);
            pst.setString(2, author);
            pst.setString(3, isbn);
            pst.setInt(4, totalCopies);
            pst.setInt(5, totalCopies);

            pst.executeUpdate();
            System.out.println("Book added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    // Display all books
    public void viewBooks() {

        String sql = "SELECT * FROM books";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            System.out.println("\n========== BOOK LIST ==========");

            while (rs.next()) {
                System.out.println("Book ID: " + rs.getInt("book_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("ISBN: " + rs.getString("isbn"));
                System.out.println("Total Copies: " + rs.getInt("total_copies"));
                System.out.println("Available Copies: " + rs.getInt("available_copies"));
                System.out.println("-------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error viewing books: " + e.getMessage());
        }
    }

    // Update book details
    public void updateBook(int bookId, String title, String author,
                           String isbn, int totalCopies) {

        String sql = "UPDATE books SET title=?, author=?, isbn=?, "
                   + "total_copies=?, available_copies=available_copies + (? - total_copies) "
                   + "WHERE book_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, title);
            pst.setString(2, author);
            pst.setString(3, isbn);
            pst.setInt(4, totalCopies);
            pst.setInt(5, totalCopies);
            pst.setInt(6, bookId);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Book updated successfully!");
            } else {
                System.out.println("Book not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating book: " + e.getMessage());
        }
    }

    // Delete a book
    public void deleteBook(int bookId) {

        String sql = "DELETE FROM books WHERE book_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, bookId);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting book: " + e.getMessage());
        }
    }

    // Register a new user
    public void addUser(String name, String email) {

        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, name);
            pst.setString(2, email);

            pst.executeUpdate();
            System.out.println("User registered successfully!");

        } catch (SQLException e) {
            System.out.println("Error registering user: " + e.getMessage());
        }
    }

    // Display all users
    public void viewUsers() {

        String sql = "SELECT * FROM users";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            System.out.println("\n========== USER LIST ==========");

            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt("user_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("-------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error viewing users: " + e.getMessage());
        }
    }
    
    public void borrowBook(int bookId, int userId) {

    String checkBook = "SELECT available_copies FROM books WHERE book_id = ?";

    String updateBook = "UPDATE books SET available_copies = available_copies - 1 "
                      + "WHERE book_id = ? AND available_copies > 0";

    String insertTransaction = "INSERT INTO transactions "
                             + "(book_id, user_id, borrow_date, status) "
                             + "VALUES (?, ?, CURDATE(), 'BORROWED')";

    try (Connection con = DBConnection.getConnection()) {

        con.setAutoCommit(false);

        try {
            int availableCopies = 0;

            try (PreparedStatement pst = con.prepareStatement(checkBook)) {
                pst.setInt(1, bookId);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        availableCopies = rs.getInt("available_copies");
                    } else {
                        System.out.println("Book not found!");
                        con.rollback();
                        return;
                    }
                }
            }

            if (availableCopies <= 0) {
                System.out.println("Book is not available!");
                con.rollback();
                return;
            }

            try (PreparedStatement pst = con.prepareStatement(updateBook)) {
                pst.setInt(1, bookId);
                pst.executeUpdate();
            }

            try (PreparedStatement pst = con.prepareStatement(insertTransaction)) {
                pst.setInt(1, bookId);
                pst.setInt(2, userId);
                pst.executeUpdate();
            }

            con.commit();
            System.out.println("Book borrowed successfully!");

        } catch (SQLException e) {
            con.rollback();
            System.out.println("Borrowing failed: " + e.getMessage());
        }

     } catch (SQLException e) {
        System.out.println("Database error: " + e.getMessage());
     }
     
    }
        
    public void returnBook(int bookId, int userId) {

        String checkTransaction = "SELECT transaction_id FROM transactions "
                            + "WHERE book_id = ? AND user_id = ? "
                            + "AND status = 'BORROWED' LIMIT 1";

        String updateTransaction = "UPDATE transactions "
                             + "SET status = 'RETURNED', return_date = CURDATE() "
                             + "WHERE transaction_id = ?";

        String updateBook = "UPDATE books "
                      + "SET available_copies = available_copies + 1 "
                      + "WHERE book_id = ?";

            try (Connection con = DBConnection.getConnection()) {

                con.setAutoCommit(false);

                    try {
                        int transactionId;

             try (PreparedStatement pst = con.prepareStatement(checkTransaction)) {
                pst.setInt(1, bookId);
                pst.setInt(2, userId);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        transactionId = rs.getInt("transaction_id");
                    } else {
                        System.out.println("No active borrowing record found!");
                        con.rollback();
                        return;
                    }
                }
            }

            try (PreparedStatement pst = con.prepareStatement(updateTransaction)) {
                pst.setInt(1, transactionId);
                pst.executeUpdate();
            }

            try (PreparedStatement pst = con.prepareStatement(updateBook)) {
                pst.setInt(1, bookId);
                pst.executeUpdate();
            }

            con.commit();
            System.out.println("Book returned successfully!");

        } catch (SQLException e) {
            con.rollback();
            System.out.println("Returning failed: " + e.getMessage());
        }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }


}