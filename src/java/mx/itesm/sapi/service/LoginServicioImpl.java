/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mx.itesm.sapi.bean.Cuenta;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author julioguzman
 */
public class LoginServicioImpl implements LoginServicio {
    
    @Override
    public Cuenta verificaCredenciales(Cuenta cuenta){
        
        Connection conn = Conexion.getConnection();
        
        String sql = "SELECT * FROM Cuenta WHERE usuario=? AND password = ? ";
       
        
        try{
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, cuenta.getUsuario());
            ps.setString(2, cuenta.getPassword());
            
            ps.executeQuery();
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            cuenta.setIdCuenta(rs.getInt("idCuenta"));
            cuenta.setIdPersona(rs.getInt("idPersona"));
            //cuenta.setIdRol(rs.getInt("idRol"));
                        
                 
            
        }catch(Exception ex){
            System.out.println("CuentaServicio.verificaUsuario ".concat(ex.getMessage()));
        }
        
        return cuenta;
        
        
    }
    
   @Override
   public void InsertLoginDateTime(Cuenta cuenta){
       
       Connection conn = Conexion.getConnection();
        
        String sql = "INSERT INTO Login (idLogin,fecha,idCuenta) VALUES(?,?,?)";
       
        
        try{
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            
            // 2 .- Obtener fecha
            // 3.- id cuenta
            ps.setString(1,null);
            ps.setDate(2, new Date(cuenta.getLoginDateTime()));
            ps.setInt(3, cuenta.getIdCuenta());
            
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            cuenta.setIdCuenta(rs.getInt(1));
          
            
            rs.close();
            ps.close();
            conn.close();
                 
            System.out.println("si entre");
            
        }catch(Exception ex){
            System.out.println("CuentaServicio.InsertDateTime ".concat(ex.getMessage()));
            System.out.println("no entre");
        }
        
        
        
        
    }
   
   
   
}
