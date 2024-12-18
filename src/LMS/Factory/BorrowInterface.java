/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LMS.Factory;

import LMS.Models.BorrowedBooksModel;
import java.util.List;

/**
 *
 * @author USER
 */
public interface BorrowInterface {
    void borrowedBooks(BorrowedBooksModel borrowedBooksModel);
    void setIsBorrowed(BorrowedBooksModel borrowedBooksModel);
    void setMemberOrderNumber(BorrowedBooksModel borrowedBooksModel);
    List<BorrowedBooksModel>getAllBorrowedBooks();
    List<BorrowedBooksModel>searchBorrowedBooks(String search);
    void returnBooks(BorrowedBooksModel borrowedBooksModel);
    void resetIsBorrowed(BorrowedBooksModel borrowedBooksModel);
    void resetMemberOrderNumber(BorrowedBooksModel borrowedBooksModel);
   List<BorrowedBooksModel> getBorrowedBookHistory();
     List<BorrowedBooksModel>searchBorrowedBooksHistory(String search);
     
  
}
