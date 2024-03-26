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
public class RegistrationAuthenticator {
    public boolean isRegitser(String petowner,String password,String ConfirmPassword,String pettype,String petname,String petage,String vaccinecount,String phone,String city,String location,String mailid)
    {
        int x=password.compareTo(ConfirmPassword);
        if (x==0)
        {
            try{
            Statement st = DBConnector.getStatement();
        
            String query = "INSERT INTO pet(`petowner`,`password`,`pettype`,`petname`,`petage`,`vaccinecount`,`phone`,`city`,`location`,`mailid`) VALUES('"+petowner+"','"+password+"','"+pettype+"','"+petname+"','"+petage+"','"+vaccinecount+"','"+phone+"','"+city+"','"+location+"','"+mailid+"')";
            System.out.println("Query = "+query);        
            
            int i = st.executeUpdate(query);

            if(i>0)
                {
                    System.out.println(i+" Record Inserted...");
                    return true;
                }
            else
                {
                 System.out.println("Record Insertion Failed..");
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
