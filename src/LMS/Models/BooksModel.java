/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LMS.Models;


public class BooksModel {

  
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public FileImageModel getBookImage() {
        return bookImage;
    }

    public void setBookImage(FileImageModel bookImage) {
        this.bookImage = bookImage;
    }

    public BooksModel(String isbn, String title, String author, boolean isBorrowed, FileImageModel bookImage) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
        this.bookImage = bookImage;
    }
    public BooksModel() {
    }
    private String isbn;
    private String title;
    private String author;
    private boolean isBorrowed;
    private FileImageModel bookImage;
}
