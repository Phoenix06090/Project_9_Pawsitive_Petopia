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
public class QueryAnsweredAuthenticator{
    public boolean isQueryStatusUpdated(String name ,String email){
         try{
            Statement st = DBConnector.getStatement();
            
            String query = "UPDATE query SET response='1' where  name ='"+name+"' AND email='"+email+"' ";
            System.out.println("Query = "+query);        
            
            int i = st.executeUpdate(query);

            if(i>0)
                {
                    System.out.println(i+" Service Status Updated...");
                    return true;
                }
            else
                {
                 System.out.println("Service Status Updation Failed..");
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
