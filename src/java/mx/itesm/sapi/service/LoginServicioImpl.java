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
import java.text.SimpleDateFormat;
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
            cstmt = conn.prepareCall("CALL autenticarPaciente(?,SHA2(?,224))");
            cstmt.setString (1, cuenta.getUsuario());
            cstmt.setString (2, cuenta.getPassword());
            
            ResultSet rs = cstmt.executeQuery();
          
            rs.next();
                                    
            int resultado = rs.getInt("AUTH");
            
            switch(resultado)
            {
                case -1:
                {
                    System.out.println("no existe");
                    break;
                }
                case 0: 
                {
                    System.out.println("no se pudo");
                    break;
                }
                case 1:
                {                                       
                    System.out.println("se pudo ".concat(String.valueOf(rs.getInt("idCuenta"))));                    
                    cuenta.setIdCuenta(rs.getInt("idCuenta"));
                    System.out.println("break;");
                    break;
                }
            }
            
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
         /*   
            //SE OBTIENE VALOR DE 'LoginDateTime'
            cuenta.setLoginDate(rs.getLong(1));
          
            //SE CIERRA CALLABLE STATEMENT, RESULT SET Y CONEXION
            rs.close();
            cstmt.close();
            conn.close();
            
            //VERIFICACION           
            System.out.println(cuenta.getLoginDateTime()); 
            */
            
        }catch(Exception ex){
            System.out.println("CuentaServicio.verificaUsuario ".concat(ex.getMessage()));
        }
    }
   
   
   
}
