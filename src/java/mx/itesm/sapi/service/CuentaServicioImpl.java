/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.itesm.sapi.bean.Cuenta;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Admin
 */
public class CuentaServicioImpl implements CuentaServicio {

    @Override
    public Cuenta getCuenta(int idCuenta) {
       
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
       
    }

    @Override
    public List<Cuenta> getCuenta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveCuenta(Cuenta cuenta) {
    
         Connection conn = Conexion.getConnection();
         CallableStatement cstmt;
         
     
        try {
            
            cstmt = conn.prepareCall("CALL insertaCuenta(?,?,?,?,?)");
            
            
            cstmt.setString(1, cuenta.getUsuario());
            cstmt.setString(2, cuenta.getPassword());
            cstmt.setString(3,"abc");
            cstmt.setInt(4, cuenta.getIdPersona());
            cstmt.registerOutParameter(5,Types.INTEGER);
            
            
            return !cstmt.execute();   
            
        } catch (SQLException ex) {
            System.out.println("La contraseña de cuenta es: "+cuenta.getPassword());
            System.out.println("El nombre de usuario es: "+cuenta.getUsuario());
            System.out.println("ID: "+cuenta.getIdPersona());
            ex.printStackTrace();
            System.out.println("Estoy en el cath de saveCuenta");
            return false;
        }
          
          
        
    
    }

    @Override
    public boolean deleteCuenta(int idCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCuenta(Cuenta cuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public boolean existsUsuario(String usuario) {

        
        Connection conn = Conexion.getConnection();
       
        
        CallableStatement cstmt;
       
        try {
            
            
            cstmt = conn.prepareCall("CALL existeUsuario(?,?)");
            cstmt.setString (1, usuario); 
            cstmt.registerOutParameter(2,Types.BOOLEAN);
            
            cstmt.execute();
            return cstmt.getBoolean(2);
            
        } catch (SQLException ex) {
           
            Logger.getLogger(CuentaServicioImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
            }
    
}
