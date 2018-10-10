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
import mx.itesm.sapi.bean.persona.EstadoCivil;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class EstadoCivilServicioImpl implements EstadoCivilServicio{

    @Override
    public EstadoCivil mostrarEstadoCivil(int idEstadoCivil) {
         Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        EstadoCivil estadoCivil = new EstadoCivil();
        
        //Call del store procedure
        String stProcedure="mostrarEstadoCivil";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEstadoCivil);
            
            ResultSet rs = cstmt.executeQuery();
            
         
            
            rs.next();
            estadoCivil.setIdEstadoCivil(rs.getInt("idEstadoCivil"));
            estadoCivil.setNombre(rs.getString("nombre"));
            estadoCivil.setEstatus(rs.getInt("estatus"));
            
            
           
            return estadoCivil;
        }catch(SQLException ex){
            
            System.out.println("Estoy en el catch de mostrarSexo ");
            System.out.println(ex.getMessage());
            return estadoCivil;
        }
        
    }

    @Override
    public List<EstadoCivil> mostrarEstadoCivil() {
        Connection conn = Conexion.getConnection();
        
        
        List<EstadoCivil> estadoCiviles = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL getEstadoCivil()");
            ResultSet rs = cstmt.executeQuery();
            EstadoCivil estadoCivil;
            
            while(rs.next()){
                
                estadoCivil = new EstadoCivil();
                
            estadoCivil.setIdEstadoCivil(rs.getInt(1));
            estadoCivil.setNombre(rs.getString(2));
            estadoCivil.setEstatus(rs.getInt(3));
                
                estadoCiviles.add(estadoCivil);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(SQLException ex){
            System.out.println("ERROR GET sexos" + ex.getMessage());
        }
        
        return estadoCiviles;
    }

    @Override
    public boolean agregarEstadoCivil(EstadoCivil estadoCivil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarEstadoCivil(EstadoCivil idEstadoCivil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoEstadoCivil(int idEstadoCivil) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        //Call del store procedure
        String stProcedure="borradoLogicoEstadoCivil";
        
        
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,idEstadoCivil);
            
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            
           return rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            System.out.println("Estoy en el catch de borrarEstadoCivil");
            System.out.println(ex.getMessage());
            return false;
        }
    }

   
    
}
