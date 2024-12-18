
package LMS.Forms;

import LMS.Factory.BooksInterface;
import LMS.Factory.BorrowInterface;
import LMS.Factory.LibraryFactory;
import LMS.Factory.MembersInterface;
import LMS.Forms.Popup.ModifyBooks;
import LMS.Items.BookItem;
import LMS.Items.BorrowedBookItem;
import LMS.Models.BooksModel;
import LMS.Models.BorrowedBooksModel;
import LMS.Models.FileImageModel;
import LMS.Models.MembersModel;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import raven.modal.ModalDialog;
import raven.modal.Toast;
import raven.modal.component.SimpleModalBorder;
import raven.modal.demo.layout.ResponsiveLayout;
import raven.modal.demo.simple.SimpleMessageModal;
import raven.modal.listener.ModalCallback;
import raven.modal.listener.ModalController;
import raven.modal.option.Location;
import raven.modal.option.Option;


public class Books_Form extends javax.swing.JPanel {

   private LibraryFactory libraryFactory = new LibraryFactory();
   private BooksInterface booksInterface = libraryFactory.createBooksController(); 
   private MembersInterface membersInterface = libraryFactory.createMembersController();
   private BorrowInterface borrowInterface = libraryFactory.createBorrowedBooks();
   
   private List<BooksModel>orderList = new ArrayList<>();
    public Books_Form() {
        initComponents();
        init();
     
         populateBooks();
    }
    private void init(){
         jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);
        searchField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search Boooks");
        idField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search ID");
        
          ResponsiveLayout booksLayout = new ResponsiveLayout(ResponsiveLayout.JustifyContent.FIT_CONTENT, 
                new Dimension(-1, -1), 2, 2);
        ResponsiveLayout orderPanelLayout = new ResponsiveLayout(ResponsiveLayout.JustifyContent.FIT_CONTENT, 
                new Dimension(-1, -1), 2, 2);
       
        orderPanelLayout.setColumn(1);
        orderPanelLayout.setSize(new Dimension(269, 114));
       booksLayout.setSize(new Dimension(295, 361));
       booksLayout.setColumn(3);
        booksPanel.setLayout(booksLayout);
        orderPanel.setLayout(orderPanelLayout);
    }
    
    private void addBook(BooksModel data){
        BookItem bookItem = new BookItem();
        bookItem.setBookInformation(data);
        
        bookItem.getEditBtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editBook(data);
            }
        
        });
        bookItem.getBorrowBtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 if (!data.isIsBorrowed()) {
                 System.out.println("unavailable");
                 return;
             }
 
             for (BooksModel booksModel : orderList) {
                 if (data.getIsbn() == booksModel.getIsbn()) {
                      Toast.show(jPanel1, Toast.Type.WARNING, "is already in the cart");
                    
                     return;
                 }
             }
             int orderLim = Integer.parseInt(lbOrderLimit.getText());
             int maxAllowable = 3 - orderLim; 

          
             if (lbVerifier.getText().equals("Unverified")) {
                 Toast.show(jPanel1, Toast.Type.WARNING, "Unverified!");
                 System.out.println("Unverified!");
                 return;
             }
   
             if (orderList.size() >= maxAllowable) {
                 Toast.show(jPanel1, Toast.Type.WARNING, "Reached the order limit!");
                
                 return;
             }

             orderList.add(data);
             populateOrderBooks();
             Toast.show(jPanel1, Toast.Type.SUCCESS, "Book added successfully!");
           

            }
        
        });
        booksPanel.add(bookItem);
        repaint();
        revalidate();
        
    }
    private void orderBooks(BooksModel data){
        BorrowedBookItem borrowedBookItem = new BorrowedBookItem();
        borrowedBookItem.setBooksModel(data);
        
        borrowedBookItem.getRemoveItem().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                orderList.remove(data);
                populateOrderBooks();
                repaint();
                revalidate();
            }
        });
        orderPanel.add(borrowedBookItem);
        repaint();
        revalidate();
        
    }
    private void populateOrderBooks(){
        orderPanel.removeAll();
        for (BooksModel booksModel : orderList) {
            orderBooks(booksModel);
        }
    }
    private void populateBooks(){
        booksPanel.removeAll();
        List<BooksModel>list_of_books =   booksInterface.getAllBooks();
        
        for (BooksModel list_of_book : list_of_books) {
            addBook(list_of_book);
        }
   
    }
     private void searchBook(){
        booksPanel.removeAll();
        List<BooksModel>list_of_books =   booksInterface.searchBooks(searchField.getText());
        
        for (BooksModel list_of_book : list_of_books) {
            addBook(list_of_book);
        }
   
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        idField = new javax.swing.JTextField();
        lbVerifier = new javax.swing.JLabel();
        lbOrderLimit = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderPanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        lbID = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        booksPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        idField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        lbVerifier.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbVerifier.setForeground(new java.awt.Color(0, 102, 102));
        lbVerifier.setText("Unverified");

        lbOrderLimit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbOrderLimit.setForeground(new java.awt.Color(0, 102, 102));
        lbOrderLimit.setText("0");

        javax.swing.GroupLayout orderPanelLayout = new javax.swing.GroupLayout(orderPanel);
        orderPanel.setLayout(orderPanelLayout);
        orderPanelLayout.setHorizontalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        orderPanelLayout.setVerticalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(orderPanel);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 102));
        jButton2.setText("Borrow");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbID.setForeground(new java.awt.Color(0, 102, 102));
        lbID.setText("123456");

        lbName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(0, 102, 102));
        lbName.setText("Full Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idField)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbVerifier, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbOrderLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 150, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbVerifier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)))
                    .addComponent(lbOrderLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout booksPanelLayout = new javax.swing.GroupLayout(booksPanel);
        booksPanel.setLayout(booksPanelLayout);
        booksPanelLayout.setHorizontalGroup(
            booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1056, Short.MAX_VALUE)
        );
        booksPanelLayout.setVerticalGroup(
            booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(booksPanel);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("Add a book");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       insertbook();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyTyped
     searchBook();
    }//GEN-LAST:event_searchFieldKeyTyped

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        List<MembersModel>list_of_members = membersInterface.searchMemberBorrower(idField.getText());
        if (list_of_members==null||list_of_members.isEmpty()) {
            System.out.println("null");
          
            setMembersDetailsToDefault();
        }else{
           for (MembersModel list_of_member : list_of_members) {
               
                    String borrowedLimTosTR = Integer.toString(list_of_member.getBorrowedLimit());
                    String idTosTR = Integer.toString(list_of_member.getMemberID());
                    lbVerifier.setText("Verified");
                    lbOrderLimit.setText(borrowedLimTosTR);
                    lbID.setText(idTosTR);
                    lbName.setText(list_of_member.getLastName() +", "+list_of_member.getFirstName());  
              
            }   
        }
      
        
         
           
        
        
    }//GEN-LAST:event_idFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      borrowedBooks();
    }//GEN-LAST:event_jButton2ActionPerformed
    private void setMembersDetailsToDefault(){
        lbVerifier.setText("Unverified");
        lbID.setText("123456");
        lbName.setText("Full name");
        lbOrderLimit.setText("0");
    }
    private void borrowedBooks(){
        int idToStr = Integer.parseInt(lbID.getText());
        if (lbID.getText().equals("ID")||orderList.isEmpty()) {
            return;
        }else{
            BorrowedBooksModel borrowedBooksModel = new BorrowedBooksModel(lbName.getText(), idToStr, orderList, orderList.size());
            borrowInterface.borrowedBooks(borrowedBooksModel);
            borrowInterface.setIsBorrowed(borrowedBooksModel);
            borrowInterface.setMemberOrderNumber(borrowedBooksModel);
            Toast.show(this, Toast.Type.INFO, "Succes borrowed");
            orderList.clear();
            setMembersDetailsToDefault();
            populateOrderBooks();
            populateBooks();

            repaint();
            revalidate(); 
        }
       
        
    }
    private void insertbook(){
        ModifyBooks book_forms = new ModifyBooks();
       Option option = ModalDialog.createOption();
      SimpleModalBorder.Option[] options = new SimpleModalBorder.Option[]{new SimpleModalBorder.Option("Add", SimpleModalBorder.YES_OPTION)
                  ,new SimpleModalBorder.Option("Cancel", SimpleModalBorder.CANCEL_OPTION)};
       option.getLayoutOption().setSize(300, 500)
                .setLocation(Location.CENTER, Location.CENTER)
                .setAnimateDistance(0.9f, 0); 
       
       ModalDialog.showModal(this, new SimpleModalBorder(book_forms, "Add Book", 
               options,
               (controller, action) -> {
                   if (action == SimpleModalBorder.YES_OPTION) {
                   List<BooksModel>list_of_books =   booksInterface.getAllBooks();
                       if (book_forms.fieldData()) {
                           
                           for (BooksModel list_of_book : list_of_books) {
                               if (list_of_book.getIsbn().equals(book_forms.getBooksModel().getIsbn())) {
                                   Toast.show(this, Toast.Type.WARNING, "This Book already exists!");
                                   controller.consume();
                                   return;
                               }   
                           }
                            booksInterface.insertBook(book_forms.getBooksModel()); 
                                   populateBooks();
                             
                       }else{
                           Toast.show(this, Toast.Type.WARNING, "Please fill out all fields!");
                           controller.consume();
                       }
                   }
           
           
                 }),option);
    }
    private void editBook(BooksModel booksModel){
      
        ModifyBooks book_forms = new ModifyBooks();
                    book_forms.disableIsbnField();
                    book_forms.setBooksModel(booksModel);
       Option option = ModalDialog.createOption();
      SimpleModalBorder.Option[] options = new SimpleModalBorder.Option[]{new SimpleModalBorder.Option("Update", SimpleModalBorder.YES_OPTION)
                  ,new SimpleModalBorder.Option("Delete", SimpleModalBorder.CANCEL_OPTION)};
       option.getLayoutOption().setSize(300, 500)
                .setLocation(Location.CENTER, Location.CENTER)
                .setAnimateDistance(0.9f, 0); 
       
       ModalDialog.showModal(this, new SimpleModalBorder(book_forms, "Add a book", 
               options,
               (controller, action) -> {
                   if (action == SimpleModalBorder.CANCEL_OPTION) {
                       //Delete the Book
                          ModalDialog.showModal(this, new SimpleMessageModal(SimpleMessageModal.Type.WARNING, "Are you sure you want to Delete this book?"
                                , "Delete Info", SimpleModalBorder.YES_OPTION, new ModalCallback() {
                            @Override
                            public void action(ModalController mc, int i) {
                                if (i == SimpleModalBorder.YES_OPTION) {
                                  booksInterface.deleteBook(booksModel);
                                  populateBooks();                              
                                }          
                            }
                          
                         }));    
       
                   }else if (action == SimpleModalBorder.YES_OPTION) {
                         //Update the Book
                     booksInterface.updateBook(book_forms.getBooksModel());
                     Toast.show(this, Toast.Type.SUCCESS, "Succesfully Updated");
                     populateBooks();
                   }
{
                   
                     
                       
                   }

                 }),option);
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel booksPanel;
    private javax.swing.JTextField idField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbOrderLimit;
    private javax.swing.JLabel lbVerifier;
    private javax.swing.JPanel orderPanel;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
