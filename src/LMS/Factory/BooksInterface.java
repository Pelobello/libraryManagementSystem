/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LMS.Factory;

import LMS.Models.BooksModel;
import java.awt.Component;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public interface BooksInterface {
    void insertBook(BooksModel booksModel);
      void updateBook(BooksModel booksModel);
        void deleteBook(BooksModel booksModel);
        List<BooksModel>getAllBooks();
        List<BooksModel>searchBooks(String search);
    
}
