/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
         
          String sql="INSERT INTO cuenta (idCuenta, usuario, password, token, idPersona)"
                  .concat(" VALUES (?, ?, ?, ?, ?)");
          
          PreparedStatement ps;
     
        try {
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, null);
            ps.setString(2, cuenta.getUsuario());
            ps.setString(3, cuenta.getPassword());
            ps.setString(4, "");
            ps.setInt(5, cuenta.getIdPersona());
            
            return !ps.execute();   
            
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
       
        String sql= "SELECT usuario FROM cuenta WHERE usuario=?";
       
        try {
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String us = rs.getString(1);
            
            return us.equals(usuario);
            
        } catch (SQLException ex) {
           
            Logger.getLogger(CuentaServicioImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
            }
    
}
