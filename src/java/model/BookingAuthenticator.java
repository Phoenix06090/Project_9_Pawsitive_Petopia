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
public class BookingAuthenticator {
    public boolean isBooked(String name,String password,String service)
    {
        try{
            Statement st = DBConnector.getStatement();
        
            String query = "INSERT INTO bookedservice(`name`,`password`,`service`) VALUES('"+name+"','"+password+"','"+service+"')";
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
               return false;
    }
}
