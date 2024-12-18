/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LMS.Models;

import java.util.List;

/**
 *
 * @author USER
 */
public class BorrowedBooksModel {

  
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<BooksModel> getListOfBorrowed() {
        return listOfBorrowed;
    }

    public void setListOfBorrowed(List<BooksModel> listOfBorrowed) {
        this.listOfBorrowed = listOfBorrowed;
    }

    public int getNumberOfBooksBorrowed() {
        return numberOfBooksBorrowed;
    }

    public void setNumberOfBooksBorrowed(int numberOfBooksBorrowed) {
        this.numberOfBooksBorrowed = numberOfBooksBorrowed;
    }

    public BorrowedBooksModel(String fullName, int ID, List<BooksModel> listOfBorrowed, int numberOfBooksBorrowed) {
        this.fullName = fullName;
        this.ID = ID;
        this.listOfBorrowed = listOfBorrowed;
        this.numberOfBooksBorrowed = numberOfBooksBorrowed;
    }

    public BorrowedBooksModel() {
    }
  
    
    private String fullName;
    private int ID;
    private List<BooksModel>listOfBorrowed;
    private int numberOfBooksBorrowed;
            
    public Object[]ToObject(){
        for (BooksModel booksModel : listOfBorrowed) {
             return new Object[] {false,this,fullName,booksModel.getTitle(),booksModel.getIsbn()};
        }
        return null;
       
    }
    public Object[]ToObjectHistory(){
        for (BooksModel booksModel : listOfBorrowed) {
             return new Object[] {this,fullName,booksModel.getTitle(),booksModel.getIsbn()};
        }
        return null;
       
    }

    @Override
    public String toString() {
        String idStr = Integer.toString(ID);
        return idStr; 
    }
    
}
