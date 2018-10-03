/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author julioguzman
 */
public class LoginServicioImpl implements LoginServicio {
    
    @Override
    public Cuenta verificaCredenciales(Cuenta cuenta){
        
        Connection conn = Conexion.getConnection();
        
       
         CallableStatement cstmt;

        try{
            cstmt = conn.prepareCall("CALL Login(?,?)");
            cstmt.setString (1, cuenta.getUsuario());
            cstmt.setString (2, cuenta.getPassword());
            
            ResultSet rs = cstmt.executeQuery();
          
            rs.next();
            
            cuenta.setIdCuenta(rs.getInt("idCuenta"));
            cuenta.setIdPersona(rs.getInt("idPersona"));
            //cuenta.setIdRol(rs.getInt("idRol"));
                        
             System.out.println(cuenta.getIdCuenta()); 
             System.out.println(cuenta.getIdPersona());
            
        }catch(Exception ex){
            System.out.println("CuentaServicio.verificaUsuario ".concat(ex.getMessage()));
        }
        
        return cuenta;
        
        
    }
    
   @Override
   public void InsertLoginDateTime(Cuenta cuenta){
       
        //SE CREA CONEXION
        Connection conn = Conexion.getConnection();
        
        //SE CREA CALLABLE STATEMENT
        CallableStatement cstmt;

        try{
            //SE PREPARA LA LLAMADA A 'InsertLoginDateTime(out fecha, in idCuenta)
            cstmt = conn.prepareCall("CALL InsertLoginDateTime(?,?)");
            
            //SE PASAN VALORES DEL PREPARED CALL
            cstmt.setString(1, "");
            cstmt.setInt(2, cuenta.getIdCuenta());
            
            //SE EJECUTA Y SE DEVUELVEN LOS VALORES DENTRO DEL RESULT SET
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            
            //SE OBTIENE VALOR DE 'LoginDateTime'
            cuenta.setLoginDateTime(rs.getLong(1));
          
            //SE CIERRA CALLABLE STATEMENT, RESULT SET Y CONEXION
            rs.close();
            cstmt.close();
            conn.close();
            
            //VERIFICACION           
            System.out.println(cuenta.getLoginDateTime()); 
            
        }catch(Exception ex){
            System.out.println("CuentaServicio.verificaUsuario ".concat(ex.getMessage()));
        }
    }
   
   
   
}
