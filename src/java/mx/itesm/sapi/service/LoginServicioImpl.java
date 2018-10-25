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
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author julioguzman
 * 
 */
public class LoginServicioImpl implements LoginServicio {
    
    @Override
    public Cuenta verificaCredenciales(Cuenta cuenta){
        
         Connection conn = Conexion.getConnection();               
         CallableStatement cstmt;

        try{
            cstmt = conn.prepareCall("CALL autenticarPaciente(?,?)");
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
                    
                    cuenta.setIdRol(rs.getInt("idRol"));
                    cuenta.setUsuario(rs.getString("usuario"));
                    cuenta.setIdCuenta(rs.getInt("idCuenta"));
                    cuenta.setIdPersona(rs.getInt("idPersona"));
                    
                    //No se recibe un token, con excepción que se haya usado para iniciar sesión
                    try{
                        cuenta.setToken(rs.getString("token"));
                    }catch(Exception ex)
                    {                        
                        System.out.println("No token");                        
                    }
                    System.out.println("break;");
                    break;
                }
            }
            
        }catch(Exception ex){
            System.out.println("LoginServicioImpl.verificaUsuario ".concat(ex.getLocalizedMessage()));
        }
        
        return cuenta;                
    }
    
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
<<<<<<< HEAD
            //cuenta.setLoginDateTime(rs.getLong(1));
=======
            cuenta.setLoginDate(rs.getLong(1));
>>>>>>> Login
          
            //SE CIERRA CALLABLE STATEMENT, RESULT SET Y CONEXION
            rs.close();
            cstmt.close();
            conn.close();
            
            //VERIFICACION           
<<<<<<< HEAD
            //System.out.println(cuenta.getLoginDateTime()); 
=======
            System.out.println(cuenta.getLoginDateTime()); 
            */
            
        }catch(Exception ex){
            System.out.println("CuentaServicio.verificaUsuario ".concat(ex.getMessage()));
        }
    }         
       
}
