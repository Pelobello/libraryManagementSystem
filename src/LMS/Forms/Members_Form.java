/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package LMS.Forms;

import LMS.Factory.LibraryFactory;
import LMS.Factory.MembersInterface;
import LMS.Forms.Popup.ModifyBooks;
import LMS.Forms.Popup.ModifyMembers;
import LMS.Models.BooksModel;
import LMS.Models.MembersModel;
import LMS.Table.CheckBoxTableHeaderRenderer;
import LMS.Table.TableHeaderAlignment;
import com.formdev.flatlaf.FlatClientProperties;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import raven.modal.ModalDialog;
import raven.modal.Toast;
import raven.modal.component.SimpleModalBorder;
import raven.modal.option.Location;
import raven.modal.option.Option;

public class Members_Form extends javax.swing.JPanel {

   private LibraryFactory libraryFactory = new LibraryFactory();
   private MembersInterface membersController = libraryFactory.createMembersController();
    public Members_Form() {
        initComponents();
        init();
    }

    private void init(){
        searchField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search member");
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);
         membersTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        membersTable.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:70;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");

        membersTable.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(membersTable));
        loadMembersInfo();
    }
    private void loadMembersInfo(){
        
        try {
            DefaultTableModel model = (DefaultTableModel)membersTable.getModel();
            if (membersTable.isEditing()) {
                membersTable.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<MembersModel> list = membersController.getAllMembers();
            
            for (MembersModel membersModel : list) {
                model.addRow(membersModel.ToObject());
            }
        } catch (Exception e) {
        }
    }
     private void searchMembersInfo(){
        
        try {
            DefaultTableModel model = (DefaultTableModel)membersTable.getModel();
            if (membersTable.isEditing()) {
                membersTable.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<MembersModel> list = membersController.searchMembers(searchField.getText());
            
            for (MembersModel membersModel : list) {
                model.addRow(membersModel.ToObject());
            }
        } catch (Exception e) {
        }
    }
    private List<MembersModel>getSelectedInfo(){
        List<MembersModel>list = new ArrayList<>();
        for (int i = 0; i <membersTable.getRowCount(); i++) {
            if ((boolean)membersTable.getValueAt(i, 0)) {
                MembersModel data = (MembersModel)membersTable.getValueAt(i, 1);
                list.add(data);
                
            }
            
        }
        return list;
    }
    
    private void addMember(){
       ModifyMembers modifyMembers = new ModifyMembers();
       Option option = ModalDialog.createOption();
       SimpleModalBorder.Option[] options = new SimpleModalBorder.Option[]{new SimpleModalBorder.Option("Add", SimpleModalBorder.YES_OPTION)
                  ,new SimpleModalBorder.Option("Cancel", SimpleModalBorder.CANCEL_OPTION)};
       option.getLayoutOption().setSize(299, 300)
                .setLocation(Location.CENTER, Location.CENTER)
                .setAnimateDistance(0.9f, 0); 
       
       ModalDialog.showModal(this, new SimpleModalBorder(modifyMembers, "Add member", 
               options,
               (controller, action) -> {
                   if (action == SimpleModalBorder.YES_OPTION) {
                       try {
                           List<MembersModel>getMembersInfo = membersController.getAllMembers();
                            if (modifyMembers.getMembersModel()!=null) {
                                
                                for (MembersModel membersModel : getMembersInfo) {
                                    if (membersModel.getMemberID()==modifyMembers.getMembersModel().getMemberID()) {
                                        Toast.show(this, Toast.Type.INFO,"Member's already Exist!");
                                        controller.consume();
                                        return;
                                    }
                                }
                            membersController.addMembers(modifyMembers.getMembersModel());
                            Toast.show(this, Toast.Type.INFO, "Succesfully added");
                            loadMembersInfo();
                       }else{
                            Toast.show(this, Toast.Type.WARNING, "Invalid input! please try again");
                            controller.consume();
                       }
                       } catch (NumberFormatException e) {
                           Toast.show(this, Toast.Type.WARNING, "Invalid id");
                           controller.consume();
                       }
          
                   }
           
           
                 }),option);      
    }   
      private void ModifyMember(MembersModel membersModel){
        ModifyMembers modifyMembers = new ModifyMembers();
                      modifyMembers.setMembersModel(membersModel);
       Option option = ModalDialog.createOption();
      SimpleModalBorder.Option[] options = new SimpleModalBorder.Option[]{new SimpleModalBorder.Option("Edit", SimpleModalBorder.YES_OPTION)
                  ,new SimpleModalBorder.Option("Delete", SimpleModalBorder.NO_OPTION)};
       option.getLayoutOption().setSize(299, 300)
                .setLocation(Location.CENTER, Location.CENTER)
                .setAnimateDistance(0.9f, 0); 
       
       ModalDialog.showModal(this, new SimpleModalBorder(modifyMembers, "Modify Member's information", 
               options,
               (controller, action) -> {
                   if (action==SimpleModalBorder.NO_OPTION) {
                       membersController.deleteMembersInfo(modifyMembers.getMembersModel());
                       Toast.show(this, Toast.Type.INFO, modifyMembers.getMembersModel().getFirstName()+" has been removed");
                   }else if (action==SimpleModalBorder.YES_OPTION) {
                       membersController.updateMembersInfo(modifyMembers.getMembersModel());
                        Toast.show(this, Toast.Type.INFO, "Sucesfully edited");        
                       
                   }
                    loadMembersInfo();

                 }),option);
        
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        membersTable = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        membersTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        membersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { Boolean.valueOf(false), null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Select", "ID", "Last Name", "First Name", "Total Borrowed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(membersTable);
        if (membersTable.getColumnModel().getColumnCount() > 0) {
            membersTable.getColumnModel().getColumn(0).setMinWidth(45);
            membersTable.getColumnModel().getColumn(0).setPreferredWidth(45);
            membersTable.getColumnModel().getColumn(0).setMaxWidth(45);
        }

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchFieldKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("Add Member");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 102));
        jButton2.setText("Modify");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
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
     addMember();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      List<MembersModel>list = getSelectedInfo();
        if (!list.isEmpty()) {
            if (list.size()==1) {
                for (MembersModel membersModel : list) {
                      ModifyMember(membersModel);
                }
              
            }else{
               Toast.show(this, Toast.Type.WARNING, "Please select only one member to edit!");
            }
        }else{
              Toast.show(this, Toast.Type.WARNING, "Please select member to edit!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyTyped
     searchMembersInfo();
    }//GEN-LAST:event_searchFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable membersTable;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
