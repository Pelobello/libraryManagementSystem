/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package LMS.Forms.Popup;

import LMS.Models.BooksModel;
import LMS.Models.FileImageModel;
import com.formdev.flatlaf.FlatClientProperties;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import jnafilechooser.api.JnaFileChooser;


public class ModifyBooks extends javax.swing.JPanel {

   
   

     private FileImageModel fileImageModel;
     private BooksModel booksModel;
    public ModifyBooks() {
        initComponents();
        init();
    }

   private void init(){
       titleField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Title");
        authorField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Author");
         isbnField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ISBN");
   }
    public BooksModel getBooksModel() {
        return new BooksModel(isbnField.getText(), titleField.getText(), authorField.getText(), true, fileImageModel);
    }

    public void setBooksModel(BooksModel booksModel) {
        this.booksModel = booksModel;
        titleField.setText(booksModel.getTitle());
        authorField.setText(booksModel.getAuthor());
        isbnField.setText(booksModel.getIsbn());
        if (booksModel.getBookImage()!=null) {
            bookImage.setImage(booksModel.getBookImage().getIcon());
        }else{
            bookImage.setImage(new ImageIcon(getClass().getResource("/LMS/Icons/defaultBookImage.png")));
        }
    }
    public boolean fieldData(){
        if (titleField.equals("")||authorField.getText().equals("")||isbnField.equals("")) {
            return false;
        }else{
            return true;
        }
    }
    public void disableIsbnField(){
        isbnField.setEditable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bookImage = new LMS.Swing.PictureBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        authorField = new javax.swing.JTextField();
        isbnField = new javax.swing.JTextField();

        bookImage.setImage(new javax.swing.ImageIcon(getClass().getResource("/LMS/Icons/defaultBookImage.png"))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Browse");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Clear");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookImage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleField)
                    .addComponent(authorField)
                    .addComponent(isbnField))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(authorField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isbnField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
         JnaFileChooser ch = new JnaFileChooser();
     ch.addFilter("image", "png","jpg");
     boolean act = ch.showOpenDialog(SwingUtilities.getWindowAncestor(this));
        if (act) {
            File file = ch.getSelectedFile();
            bookImage.setImage(new ImageIcon(file.getAbsolutePath()));
            fileImageModel = new FileImageModel(file);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       bookImage.setImage(new ImageIcon(getClass().getResource("/LMS/Icons/defaultBookImage.png")));
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorField;
    private LMS.Swing.PictureBox bookImage;
    private javax.swing.JTextField isbnField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField titleField;
    // End of variables declaration//GEN-END:variables
}
