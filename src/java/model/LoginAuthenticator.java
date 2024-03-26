/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DBConnector;
import dto.userdto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hardik
 */
public class LoginAuthenticator {
    public boolean isLogin(userdto d1)
    {
        String username = d1.getUsername();
        String password = d1.getPassword();
        String tablePassword="";
        String pettype="";
        try
        {
            Statement st = DBConnector.getStatement();
            ResultSet rs = st.executeQuery("SELECT password,pettype from pet where petowner='"+username+"' and password='"+password+"'");
            if(rs.next())
            {
                tablePassword = rs.getString(1);
                pettype=rs.getString(2);
            }
            else
            {
                return false;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        if(username!=null && password!=null && !username.trim().equals("") && password.equals(tablePassword))
        {
            d1.setPettype(pettype);
            return true;
        }
        return false;
    }
}
