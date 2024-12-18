/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LMS.Models;

import java.util.ArrayList;
import java.util.List;


public class MembersModel {

   
    public int getBorrowedLimit() {
        return borrowedLimit;
    }

    public void setBorrowedLimit(int borrowedLimit) {
        this.borrowedLimit = borrowedLimit;
    }


    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MembersModel(int memberID, String firstName, String lastName, int borrowedLimit) {
        this.memberID = memberID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.borrowedLimit = borrowedLimit;
    }

    public MembersModel() {
    }
    private int memberID;
    private String firstName;
    private String lastName;
    private int borrowedLimit;
    
    public Object[]ToObject(){
        return new Object[]{false,this,firstName,lastName,borrowedLimit};
    }

    @Override
    public String toString() {
        String idToStr = Integer.toString(memberID);
        return idToStr;
    }
    
    
}
