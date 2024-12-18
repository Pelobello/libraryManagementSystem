/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package LMS.Forms;

import LMS.Factory.BorrowInterface;
import LMS.Factory.LibraryFactory;
import LMS.Models.BorrowedBooksModel;
import LMS.Models.MembersModel;
import LMS.Table.TableHeaderAlignment;
import com.formdev.flatlaf.FlatClientProperties;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import raven.modal.Toast;

public class History_Forms extends javax.swing.JPanel {
    
    private LibraryFactory libraryFactory = new LibraryFactory();
    private BorrowInterface borrowInterface = libraryFactory.createBorrowedBooks();
    public History_Forms() {
        initComponents();
        init();
    }

   private void init(){
       searchOrderField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search renters");
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);
         borrowedBooksTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        borrowedBooksTable.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:70;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");

        borrowedBooksTable.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(borrowedBooksTable));
        loadBorrowedBooks();
   }
    private void loadBorrowedBooks(){
        
        try {
            DefaultTableModel model = (DefaultTableModel)borrowedBooksTable.getModel();
            if (borrowedBooksTable.isEditing()) {
                borrowedBooksTable.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<BorrowedBooksModel> list = borrowInterface.getBorrowedBookHistory();
            
            for (BorrowedBooksModel borrowedBooksModel : list) {
                model.addRow(borrowedBooksModel.ToObjectHistory());
            }
        } catch (Exception e) {
        }
    }
     private void searchBorrowedBooks(){
        
        try {
            DefaultTableModel model = (DefaultTableModel)borrowedBooksTable.getModel();
            if (borrowedBooksTable.isEditing()) {
                borrowedBooksTable.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<BorrowedBooksModel> list = borrowInterface.searchBorrowedBooksHistory(searchOrderField.getText());
            
            for (BorrowedBooksModel borrowedBooksModel : list) {
                model.addRow(borrowedBooksModel.ToObjectHistory());
            }
        } catch (Exception e) {
        }
    }
      private List<BorrowedBooksModel>getSelectedInfo(){
        List<BorrowedBooksModel>list = new ArrayList<>();
        for (int i = 0; i <borrowedBooksTable.getRowCount(); i++) {
            if ((boolean)borrowedBooksTable.getValueAt(i, 0)) {
                BorrowedBooksModel data = (BorrowedBooksModel)borrowedBooksTable.getValueAt(i, 1);
                list.add(data);
                
            }
            
        }
        return list;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        borrowedBooksTable = new javax.swing.JTable();
        searchOrderField = new javax.swing.JTextField();

        borrowedBooksTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        borrowedBooksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Member ID#", "Borrower", "Book Title", "ISBN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(borrowedBooksTable);
        if (borrowedBooksTable.getColumnModel().getColumnCount() > 0) {
            borrowedBooksTable.getColumnModel().getColumn(0).setMinWidth(80);
            borrowedBooksTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            borrowedBooksTable.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        searchOrderField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchOrderField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchOrderFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1348, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchOrderField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchOrderField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
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

    private void searchOrderFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchOrderFieldKeyTyped
       searchBorrowedBooks();
    }//GEN-LAST:event_searchOrderFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable borrowedBooksTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchOrderField;
    // End of variables declaration//GEN-END:variables
}
