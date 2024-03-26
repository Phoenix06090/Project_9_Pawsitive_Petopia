/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DBConnector;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hardik
 */
public class UpdateAuthenticator {

    public boolean isUpdate(String petowner,String password,String ConfirmPassword,String pettype,String petname,String petage,String vaccinecount,String phone,String city,String location,String mailid,String username,String loginpassword)
    {
        int x=password.compareTo(ConfirmPassword);
        if (x==0)
        {
            try{
            Statement st = DBConnector.getStatement();
            
            String query = "UPDATE pet SET petowner='"+petowner+"',password='"+password+"',pettype='"+pettype+"',petname='"+petname+"',petage='"+petage+"',vaccinecount='"+vaccinecount+"',phone='"+phone+"',city='"+city+"',location='"+location+"',mailid='"+mailid+"' where  petowner ='"+username+"' and password ='"+loginpassword+"' ";
            System.out.println("Query = "+query);        
            
            int i = st.executeUpdate(query);

            if(i>0)
                {
                    System.out.println(i+" Record Updated...");
                    return true;
                }
            else
                {
                 System.out.println("Record Updation Failed..");
                 return false;
                }
            }
            
            catch(SQLException e)
                {
                    System.out.println(e);
                }
        }   
            return false;
    }
}
