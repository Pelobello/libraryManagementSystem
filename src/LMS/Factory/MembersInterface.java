/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LMS.Factory;

import LMS.Models.MembersModel;
import java.util.List;


public interface MembersInterface {
    void addMembers(MembersModel membersModel);
    void updateMembersInfo(MembersModel membersModel);
    void deleteMembersInfo(MembersModel membersModel);
    List<MembersModel> getAllMembers();
    List<MembersModel> searchMembers(String search);
    List<MembersModel> searchMemberBorrower(String search);
    

}
