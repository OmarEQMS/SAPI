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
        

        String cadena = "jdbc:mysql://127.0.0.1:8889/sapi?user=root&password=root&useSSL=false";       
        //"jdbc:mysql://localhost:3306/INTtech?useSSL=false","root","root"
        //String cadena = "jdbc:mysql://35.188.165.217:3306/sapi?user=raiZsithNamCo0nr&password=aMkig-SFHAnnha-djhafi-owhbf071-3hdnsmvh34-nd8174n-cmu7nf—2-4-5.tjf.2.4.5.ouwnnvSnGgDGAMg&useSSL=false";       
        
        
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection(cadena);
        }catch(Exception ex){
            System.out.println("Error");
            System.out.println(ex.getMessage());
            //log.i();ñ
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
