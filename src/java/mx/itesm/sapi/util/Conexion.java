/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class Conexion {
    
    public static Connection getConnection(){
        
        String cadena = "jdbc:mysql://localhost:3306/sapi?user=root";
        //"jdbc:mysql://localhost:3306/INTtech?useSSL=false","root","root"
        
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection(cadena);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            //log.i();
        }
        return connection;
        
    }
    
    public static void main(String[] args){
        if(getConnection()!=null){
            System.out.println("Se conecto");
        }else{
            System.out.println("No se conecto");
        }
    }
}
