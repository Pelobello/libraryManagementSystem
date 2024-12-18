/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package LMS.Items;

import LMS.Models.BooksModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author USER
 */
public class BorrowedBookItem extends javax.swing.JPanel {

    
    public BooksModel getBooksModel() {
        return booksModel;
    }

  
    public void setBooksModel(BooksModel booksModel) {
        this.booksModel = booksModel;
        if (booksModel.getBookImage()!=null) {
            bookImage.setImage(booksModel.getBookImage().getIcon());
        }else{
            bookImage.setImage(new ImageIcon(getClass().getResource("/LMS/Icons/defaultBookImage.png")));
        }
        lbTitle.setText(booksModel.getTitle());
        lbISBN.setText(booksModel.getIsbn());
    }

   
    public BorrowedBookItem() {
        initComponents();
    }
    private BooksModel booksModel;
    public JButton getRemoveItem(){
       
        return removeItemBtn;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bookImage = new LMS.Swing.PictureBox();
        lbTitle = new javax.swing.JLabel();
        lbISBN = new javax.swing.JLabel();
        removeItemBtn = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setText("Title");

        lbISBN.setText("ISBN");

        removeItemBtn.setBackground(new java.awt.Color(153, 0, 0));
        removeItemBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        removeItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeItemBtn.setText("Remove");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookImage, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbISBN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(removeItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bookImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lbISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(removeItemBtn)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LMS.Swing.PictureBox bookImage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbISBN;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JButton removeItemBtn;
    // End of variables declaration//GEN-END:variables
}
