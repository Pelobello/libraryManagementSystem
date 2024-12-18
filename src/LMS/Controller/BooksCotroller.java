/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LMS.Controller;

import LMS.Database.GetDatabaseConnection;
import LMS.Factory.BooksInterface;
import LMS.Models.BooksModel;
import LMS.Models.FileImageModel;
import com.mysql.cj.jdbc.Blob;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import net.coobird.thumbnailator.Thumbnails;

/**
 *
 * @author USER
 */
public class BooksCotroller implements BooksInterface{
    private PreparedStatement ps;
    private ResultSet rs;
    GetDatabaseConnection databaseConnection;
    public BooksCotroller() {
        databaseConnection = new GetDatabaseConnection();
    }

    @Override
    public void insertBook(BooksModel booksModel) {
        try {
            String sql = "INSERT INTO books_table (ISBN, TITLE, AUTHOR, IS_BORROWED, BOOK_IMAGE)values(?,?,?,?,?)";
            ps = databaseConnection.prepareStatement(sql);
             ps.setString(1, booksModel.getIsbn());
             ps.setString(2, booksModel.getTitle());
             ps.setString(3, booksModel.getAuthor());
             ps.setBoolean(4, true);
             if (booksModel.getBookImage()!=null) {
                ps.setBytes(5, getByteImage(booksModel.getBookImage().getPath()));
            }else{
                  ps.setBytes(5, null);
             }
             ps.execute();
             System.out.println("Succes");
            
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
    public void updateBook(BooksModel booksModel) {
        try {
            boolean isEditImage = booksModel.getBookImage()!=null;
            String sql = isEditImage ? 
                   "UPDATE books_table SET TITLE = ?,AUTHOR = ?,BOOK_IMAGE = ?, DateUpdated = CURRENT_TIMESTAMP WHERE ISBN = ?":
                   "UPDATE books_table SET TITLE = ?,AUTHOR = ?, DateUpdated = CURRENT_TIMESTAMP WHERE ISBN = ?";
           
                ps = databaseConnection.prepareStatement(sql);
                ps.setString(1, booksModel.getTitle());
                ps.setString(2, booksModel.getAuthor());
                
            if (isEditImage) {
                if (booksModel.getBookImage()!=null) {
                    ps.setBytes(3, getByteImage(booksModel.getBookImage().getPath()));
                }else{
                    ps.setBytes(3, null);
                }
                ps.setString(4, booksModel.getIsbn());
            }else{
                 ps.setString(3, booksModel.getIsbn());
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
    public void deleteBook(BooksModel booksModel) {
        try {
            String sql  = "UPDATE books_table SET DateDeleted = CURRENT_TIMESTAMP WHERE ISBN = ?";
            ps = databaseConnection.prepareStatement(sql);
            
            ps.setString(1, booksModel.getIsbn());
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
    public List<BooksModel> getAllBooks() {
         List<BooksModel>list_of_books = new ArrayList<>();
        
         try {
             String sql = "SELECT * FROM books_table WHERE DateDeleted IS NULL";
             ps = databaseConnection.prepareStatement(sql);
             rs = ps.executeQuery();
             
             while (rs.next()) {   
                 
            Blob blob = (Blob) rs.getBlob("BOOK_IMAGE");
            ImageIcon icon = null;
                
             if (blob != null) {
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                icon = new ImageIcon(imageBytes);
            } else {
                icon = new ImageIcon(getClass().getResource("/LMS/Icons/defaultBookImage.png"));
            }
                FileImageModel fileImageModel = new FileImageModel();
                fileImageModel.setIcon(icon);
                
                BooksModel booksModel = new BooksModel(rs.getString("ISBN"), rs.getString("TITLE"), rs.getString("AUTHOR"), 
                        rs.getBoolean("IS_BORROWED"), fileImageModel);
            list_of_books.add(booksModel);
            
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
       return list_of_books;
    }
     @Override
    public List<BooksModel> searchBooks(String search) {
        List<BooksModel>list_of_books = new ArrayList<>();
        
         try {
             String sql = "SELECT * FROM books_table WHERE DateDeleted IS NULL AND ISBN LIKE ? OR TITLE LIKE ?";
             ps = databaseConnection.prepareStatement(sql);
             ps.setString(1, "%"+search+"%");
             ps.setString(2, "%"+search+"%");
             
             rs = ps.executeQuery();
             
             while (rs.next()) {   
                 
            Blob blob = (Blob) rs.getBlob("BOOK_IMAGE");
            ImageIcon icon = null;
                
             if (blob != null) {
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                icon = new ImageIcon(imageBytes);
            } else {
                icon = new ImageIcon(getClass().getResource("/LMS/Icons/defaultBookImage.png"));
            }
                FileImageModel fileImageModel = new FileImageModel();
                fileImageModel.setIcon(icon);
                
                BooksModel booksModel = new BooksModel(rs.getString("ISBN"), rs.getString("TITLE"), rs.getString("AUTHOR"), 
                        rs.getBoolean("IS_BORROWED"), fileImageModel);
            list_of_books.add(booksModel);
            
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
       return list_of_books;
    }
    
      private byte[] getByteImage(File file) throws IOException {
        BufferedImage image = Thumbnails.of(file)
                .width(500)
                .outputQuality(0.7f)
                .asBufferedImage();
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", out);
            byte[] data = out.toByteArray();
            return data;
        } finally {
            if (out != null) {
                out.close();
            }
        }}

   

   
}
