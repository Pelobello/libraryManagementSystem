/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LMS.Factory;

import LMS.Controller.BooksCotroller;
import LMS.Controller.BorrowsController;
import LMS.Controller.MembersController;

/**
 *
 * @author USER
 */
public class LibraryFactory {
   public BooksInterface createBooksController(){
       return new BooksCotroller();
   }
   public MembersInterface createMembersController(){
       return new MembersController();
   }
   public BorrowInterface createBorrowedBooks(){
       return new BorrowsController();
   }
}
