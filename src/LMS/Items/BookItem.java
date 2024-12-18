/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package LMS.Items;

import LMS.Models.BooksModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author USER
 */
public class BookItem extends javax.swing.JPanel {
    public BookItem() {
        initComponents();
    }
    
 
       public BooksModel getBookInformation() {
        return bookInformation;
    }

    public void setBookInformation(BooksModel bookInformation) {
        this.bookInformation = bookInformation;
        
        if (bookInformation.getBookImage()==null) {
            bookImage.setImage(new ImageIcon(getClass().getResource("/LMS/Icons/defaultBookImage.png")));
        }else{
              bookImage.setImage(bookInformation.getBookImage().getIcon());
        }
      
        lbTitle.setText(bookInformation.getTitle());
        lbAuthor.setText(bookInformation.getAuthor());
        
        if (bookInformation.isIsBorrowed()==true) {
            isBorrowed.setText("Available");
             isBorrowed.setForeground(Color.BLUE);
        }else{
              isBorrowed.setText("Unavailable");
              isBorrowed.setForeground(Color.red);
        }
        
        
    }
    
    public JButton getEditBtn(){
        return editBtn;
    }
    public JButton getBorrowBtn(){
        return borrowBtn;
    }

   private BooksModel bookInformation;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bookImage = new LMS.Swing.PictureBox();
        lbTitle = new javax.swing.JLabel();
        lbAuthor = new javax.swing.JLabel();
        isBorrowed = new javax.swing.JLabel();
        editBtn = new javax.swing.JButton();
        borrowBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setText("Title");

        lbAuthor.setText("Author");

        isBorrowed.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        isBorrowed.setText("Available");

        editBtn.setText("EDIT");
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        borrowBtn.setText("BORROW");
        borrowBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAuthor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(isBorrowed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(borrowBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookImage, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isBorrowed, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editBtn)
                    .addComponent(borrowBtn))
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LMS.Swing.PictureBox bookImage;
    private javax.swing.JButton borrowBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel isBorrowed;
    private javax.swing.JLabel lbAuthor;
    private javax.swing.JLabel lbTitle;
    // End of variables declaration//GEN-END:variables
}
