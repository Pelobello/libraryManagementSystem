/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LMS.Controller;

import LMS.Database.DatabaseConnection;
import LMS.Database.GetDatabaseConnection;
import LMS.Factory.BorrowInterface;
import LMS.Models.BooksModel;
import LMS.Models.BorrowedBooksModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BorrowsController implements BorrowInterface{
private PreparedStatement ps;
    private ResultSet rs;
    GetDatabaseConnection databaseConnection;
    public BorrowsController() {
        databaseConnection = new GetDatabaseConnection();
    }

    @Override
    public void borrowedBooks(BorrowedBooksModel borrowedBooksModel) {
        try {
            String sql ="INSERT INTO borrowed_books_table (MEMBER_ID, MEMBERNAME, BOOKTITLE, BOOK_ISBN)VALUES (?, ?, ?, ?)";
            ps = databaseConnection.prepareStatement(sql);
            
            for (BooksModel  borrowedData: borrowedBooksModel.getListOfBorrowed()) {
                ps.setInt(1, borrowedBooksModel.getID());
                ps.setString(2, borrowedBooksModel.getFullName());
                ps.setString(3, borrowedData.getTitle());
                ps.setString(4,borrowedData.getIsbn());
                
                ps.addBatch();
                
            }
             ps.executeBatch();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    }

    @Override
    public void setIsBorrowed(BorrowedBooksModel borrowedBooksModel) {
        try {
            String sql = "UPDATE books_table SET IS_BORROWED = FALSE WHERE ISBN = ? AND DateDeleted IS NULL";
            ps = databaseConnection.prepareStatement(sql);
            
            for (BooksModel  borrowedData: borrowedBooksModel.getListOfBorrowed()) {
                ps.setString(1, borrowedData.getIsbn());
                
                ps.addBatch();
            }
            ps.executeBatch();
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
        
    }

    @Override
    public void setMemberOrderNumber(BorrowedBooksModel borrowedBooksModel) {
        try {
            String sql = "UPDATE members_table SET BORROWEDLIMIT = BORROWEDLIMIT + ? WHERE MEMBER_ID = ? AND DateDeleted IS NULL";
            ps = databaseConnection.prepareStatement(sql);
            ps.setInt(1, borrowedBooksModel.getNumberOfBooksBorrowed());
            ps.setInt(2, borrowedBooksModel.getID());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    }

    @Override
    public List<BorrowedBooksModel> getAllBorrowedBooks() {
           List<BorrowedBooksModel>list_of_borrowed = new ArrayList<>();
        try {
            String sql = "SELECT * FROM borrowed_books_table WHERE DateDeleted IS NULL";
            ps = databaseConnection.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                BooksModel booksModel = new BooksModel();
                booksModel.setIsbn(rs.getString("BOOK_ISBN"));
                booksModel.setTitle(rs.getString("BOOKTITLE"));
                List<BooksModel>list_of_books = new ArrayList<>();
                list_of_books.add(booksModel);
                BorrowedBooksModel borrowedBooksModel = new BorrowedBooksModel(rs.getString("MEMBERNAME"), rs.getInt("MEMBER_ID"), 
                        list_of_books, rs.getInt("NUMBER_OF_BOOKS"));
                list_of_borrowed.add(borrowedBooksModel);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
     return list_of_borrowed;
    }

    @Override
    public List<BorrowedBooksModel> searchBorrowedBooks(String search) {
       List<BorrowedBooksModel>list_of_borrowed = new ArrayList<>();
        try {
            String sql = "SELECT * FROM borrowed_books_table WHERE DateDeleted IS NULL AND (MEMBER_ID LIKE ? OR MEMBERNAME LIKE ?)";
            ps = databaseConnection.prepareStatement(sql);
            
            ps.setString(1, "%"+search+"%");
            ps.setString(2,"%"+search+"%");
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                BooksModel booksModel = new BooksModel();
                booksModel.setIsbn(rs.getString("BOOK_ISBN"));
                booksModel.setTitle(rs.getString("BOOKTITLE"));
                List<BooksModel>list_of_books = new ArrayList<>();
                list_of_books.add(booksModel);
                BorrowedBooksModel borrowedBooksModel = new BorrowedBooksModel(rs.getString("MEMBERNAME"), rs.getInt("MEMBER_ID"), 
                        list_of_books, rs.getInt("NUMBER_OF_BOOKS"));
                list_of_borrowed.add(borrowedBooksModel);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
     return list_of_borrowed;
    }

    @Override
    public void returnBooks(BorrowedBooksModel borrowedBooksModel) {
        try {
            String sql = "UPDATE borrowed_books_table SET DateDeleted = CURRENT_TIMESTAMP WHERE BOOK_ISBN = ?";
            ps = databaseConnection.prepareStatement(sql);
            for (BooksModel booksModel : borrowedBooksModel.getListOfBorrowed()) {
                 ps.setString(1, booksModel.getIsbn());
            }
           
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    }

    @Override
    public void resetIsBorrowed(BorrowedBooksModel borrowedBooksModel) {
       try {
            String sql = "UPDATE books_table SET IS_BORROWED = TRUE WHERE ISBN = ? AND DateDeleted IS NULL";
            ps = databaseConnection.prepareStatement(sql);
            
            for (BooksModel  borrowedData: borrowedBooksModel.getListOfBorrowed()) {
                ps.setString(1, borrowedData.getIsbn());
                
                ps.addBatch();
            }
            ps.executeBatch();
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
       }

    @Override
    public void resetMemberOrderNumber(BorrowedBooksModel borrowedBooksModel) {
         try {
            String sql = "UPDATE members_table SET BORROWEDLIMIT = BORROWEDLIMIT - ? WHERE MEMBER_ID = ? AND DateDeleted IS NULL";
            ps = databaseConnection.prepareStatement(sql);
            ps.setInt(1, borrowedBooksModel.getNumberOfBooksBorrowed());
            ps.setInt(2, borrowedBooksModel.getID());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    }

  @Override
    public List<BorrowedBooksModel> getBorrowedBookHistory() {
      List<BorrowedBooksModel>list_of_borrowed = new ArrayList<>();
        try {
            String sql = "SELECT * FROM borrowed_books_table WHERE DateDeleted IS NOT NULL";
            ps = databaseConnection.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                BooksModel booksModel = new BooksModel();
                booksModel.setIsbn(rs.getString("BOOK_ISBN"));
                booksModel.setTitle(rs.getString("BOOKTITLE"));
                List<BooksModel>list_of_books = new ArrayList<>();
                list_of_books.add(booksModel);
                BorrowedBooksModel borrowedBooksModel = new BorrowedBooksModel(rs.getString("MEMBERNAME"), rs.getInt("MEMBER_ID"), 
                        list_of_books, rs.getInt("NUMBER_OF_BOOKS"));
                list_of_borrowed.add(borrowedBooksModel);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
     return list_of_borrowed;
    }

    @Override
    public List<BorrowedBooksModel> searchBorrowedBooksHistory(String search) {
       List<BorrowedBooksModel>list_of_borrowed = new ArrayList<>();
        try {
            String sql = "SELECT * FROM borrowed_books_table WHERE DateDeleted IS NOT NULL AND (MEMBER_ID LIKE ? OR MEMBERNAME LIKE ?)";
            ps = databaseConnection.prepareStatement(sql);
            
            ps.setString(1, "%"+search+"%");
            ps.setString(2,"%"+search+"%");
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                BooksModel booksModel = new BooksModel();
                booksModel.setIsbn(rs.getString("BOOK_ISBN"));
                booksModel.setTitle(rs.getString("BOOKTITLE"));
                List<BooksModel>list_of_books = new ArrayList<>();
                list_of_books.add(booksModel);
                BorrowedBooksModel borrowedBooksModel = new BorrowedBooksModel(rs.getString("MEMBERNAME"), rs.getInt("MEMBER_ID"), 
                        list_of_books, rs.getInt("NUMBER_OF_BOOKS"));
                list_of_borrowed.add(borrowedBooksModel);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
     return list_of_borrowed;
    }

   
    
}
