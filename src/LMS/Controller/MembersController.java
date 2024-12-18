/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LMS.Controller;

import LMS.Database.GetDatabaseConnection;
import LMS.Factory.MembersInterface;
import LMS.Models.MembersModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MembersController implements MembersInterface{

    private PreparedStatement ps;
    private ResultSet rs;
    GetDatabaseConnection databaseConnection;
    public MembersController() {
        databaseConnection = new GetDatabaseConnection();
    }

    @Override
    public void addMembers(MembersModel membersModel) {
        try {
            String sql ="INSERT INTO members_table (MEMBER_ID, NAME, LASTNAME) VALUES (?,?,?)";
            ps = databaseConnection.prepareStatement(sql);
            ps.setInt(1, membersModel.getMemberID());
            ps.setString(2, membersModel.getFirstName());
            ps.setString(3, membersModel.getLastName());
            
            ps.execute();
            System.out.println("Member added Succesfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    }

    @Override
    public void updateMembersInfo(MembersModel membersModel) {
        
        try {
            String sql = "UPDATE members_table SET NAME = ?, LASTNAME = ?, DateUpdated = CURRENT_TIMESTAMP WHERE MEMBER_ID = ? ";
            ps = databaseConnection.prepareStatement(sql);
            ps.setString(1, membersModel.getFirstName());
            ps.setString(2, membersModel.getLastName());
            ps.setInt(3, membersModel.getMemberID());
            
            ps.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    }

    @Override
    public void deleteMembersInfo(MembersModel membersModel) {
        try {
           String sql = "UPDATE members_table SET DateDeleted = CURRENT_TIMESTAMP WHERE MEMBER_ID = ?"; 
           ps = databaseConnection.prepareStatement(sql);
           ps.setInt(1, membersModel.getMemberID());
           ps.executeUpdate();
            System.out.println("Member Succesfully Deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    }

    @Override
    public List<MembersModel> getAllMembers() {
        List<MembersModel>list_of_members = new ArrayList<>();
        try {
            String sql = "SELECT * FROM members_table WHERE DateDeleted is null";
            ps = databaseConnection.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                MembersModel membersModel = new MembersModel(rs.getInt("MEMBER_ID"),
                                                             rs.getString("NAME"),
                                                             rs.getString("LASTNAME"),
                                                  rs.getInt("BORROWEDLIMIT"));
                
                list_of_members.add(membersModel);
     
            }      
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
       return list_of_members;
    }

    @Override
    public List<MembersModel> searchMembers(String search) {
         List<MembersModel>list_of_members = new ArrayList<>();
        try {
            String sql = "SELECT * FROM members_table WHERE DateDeleted is null AND (MEMBER_ID LIKE ? OR LASTNAME LIKE ?)";
            ps = databaseConnection.prepareStatement(sql);
          
            ps.setString(1,  "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                MembersModel membersModel = new MembersModel(rs.getInt("MEMBER_ID"),
                                                             rs.getString("NAME"),
                                                             rs.getString("LASTNAME"),
                                                  rs.getInt("BORROWEDLIMIT"));
                
                list_of_members.add(membersModel);          
            }       
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
       return list_of_members;
    
    }

    @Override
    public List<MembersModel> searchMemberBorrower(String search) {
       List<MembersModel>list_of_members = new ArrayList<>();
        try {
            String sql = "SELECT * FROM members_table WHERE DateDeleted is null AND MEMBER_ID = ?";
            ps = databaseConnection.prepareStatement(sql);
          
            ps.setString(1,search);
           
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                MembersModel membersModel = new MembersModel(rs.getInt("MEMBER_ID"),
                                                             rs.getString("NAME"),
                                                             rs.getString("LASTNAME"),
                                                  rs.getInt("BORROWEDLIMIT"));
                
               
                  list_of_members.add(membersModel);
            }       
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
       return list_of_members;
    }

}
