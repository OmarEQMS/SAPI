/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.persona.Rol;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class RolServicioImpl implements RolServicio{


    @Override
    public boolean agregarRol(Rol rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarRol(Rol Rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoRol(int idRol) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        //Call del store procedure
        String stProcedure="borradoLogicoRol";
        
        
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,idRol);
            
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            
           return rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            System.out.println("Estoy en el catch de borrarRol");
            System.out.println(ex.getMessage());
            return false;
        }
    
    }

    @Override
    public Rol mostrarRol(int idRol) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        Rol rol = new Rol();
        
        //Call del store procedure
        String stProcedure="mostrarRol";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idRol);
            
            ResultSet rs = cstmt.executeQuery();
            
         
            
            rs.next();
            rol.setIdRol(rs.getInt("idRol"));
            rol.setNombre(rs.getString("nombre"));
            rol.setEstatus(rs.getInt("estatus"));
            
            
           
            return rol;
        }catch(SQLException ex){
            
            System.out.println("Estoy en el catch de mostrarRol ");
            System.out.println(ex.getMessage());
            return rol;
        }
    }

    @Override
    public List<Rol> mostrarRol() {
         Connection conn = Conexion.getConnection();
        
        
        List<Rol> roles = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL getRol()");
            ResultSet rs = cstmt.executeQuery();
            Rol rol;
            
            while(rs.next()){
                
                rol = new Rol();
                
            rol.setIdRol(rs.getInt(1));
            rol.setNombre(rs.getString(2));
            rol.setEstatus(rs.getInt(3));
                
                roles.add(rol);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(SQLException ex){
            System.out.println("ERROR GET roles" + ex.getMessage());
        }
        
        return roles;
    }
    
    
}
