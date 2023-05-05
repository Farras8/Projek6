/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ivanderlibrary;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author mfarr
 */
public class ConnectionDB {
    
    static Connection cn = null;
    
    public static Connection getConnection(){
        try {   
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/dbperpus","root","");
        }catch(Exception e){
            e.printStackTrace();
        }
        return cn;
    }
}
