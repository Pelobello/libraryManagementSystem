/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package LMS.Forms.Popup;

import LMS.Models.MembersModel;
import com.formdev.flatlaf.FlatClientProperties;
import raven.modal.Toast;

/**
 *
 * @author USER
 */
public class ModifyMembers extends javax.swing.JPanel {

 
    public MembersModel getMembersModel() {
        
       
        int memberID = Integer.parseInt(memberID_Field.getText().toUpperCase()); 
        if (memberID_Field.getText().isEmpty()||nameField.getText().isEmpty()||lastNameField.getText().isEmpty()) {
            return null;
        }else{
         return new MembersModel(memberID, nameField.getText().toUpperCase(), lastNameField.getText().toUpperCase(),0);     
        }
 
    }

    public void setMembersModel(MembersModel membersModel) {
        this.membersModel = membersModel;
        String memberIDToStr = Integer.toString(membersModel.getMemberID());
        
        memberID_Field.setText(memberIDToStr);
        memberID_Field.setEditable(false);
        nameField.setText(membersModel.getFirstName());
        lastNameField.setText(membersModel.getLastName());
    }

    
    public ModifyMembers() {
        initComponents();
        init();
    }
    private void init(){
        memberID_Field.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ID");
        nameField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "First name");
        lastNameField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Last name");
        
    }
   
    private MembersModel membersModel;

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        memberID_Field = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();

        memberID_Field.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        memberID_Field.setForeground(new java.awt.Color(51, 51, 51));

        nameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameField.setForeground(new java.awt.Color(51, 51, 51));

        lastNameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lastNameField.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(memberID_Field)
                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(memberID_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField memberID_Field;
    private javax.swing.JTextField nameField;
    // End of variables declaration//GEN-END:variables
}
