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
import mx.itesm.sapi.bean.persona.Direccion;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class DireccionServicioImpl implements DireccionServicio {

    @Override
    public Direccion mostrarDireccion(int idDireccion) {
         Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        Direccion direccion = new Direccion();
        
        //Call del store procedure
        String stProcedure="mostrarDireccion";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idDireccion);
            
            ResultSet rs = cstmt.executeQuery();
            
         
            
            rs.next();
            direccion.setIdDireccion(rs.getInt("idDireccion"));
            direccion.setCalle(rs.getString("calle"));
            direccion.setNoInterior(rs.getString("noInterior")); 
            direccion.setNoExterior(rs.getString("noExterior"));            
            direccion.setColonia(rs.getString("colonia"));
            direccion.setEstatus(rs.getInt("estatus"));
            
            
           
            return direccion;
        }catch(SQLException ex){
            
            System.out.println("Estoy en el catch de mostrarDireccion");
            System.out.println(ex.getMessage());
            return direccion;
        }
    }

    @Override
    public List<Direccion> mostrarDireccion() {
        Connection conn = Conexion.getConnection();
        
        
        List<Direccion> direcciones = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL getDireccion()");
            ResultSet rs = cstmt.executeQuery();
            Direccion direccion;
            
            while(rs.next()){
                
                direccion = new Direccion();
                
            direccion.setIdDireccion(rs.getInt(1));
            direccion.setCalle(rs.getString(2));
            direccion.setNoInterior(rs.getString(3));            
            direccion.setNoExterior(rs.getString(4));
            direccion.setColonia(rs.getString(5));
            direccion.setEstatus(rs.getInt(6));
                
                direcciones.add(direccion);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(SQLException ex){
            System.out.println("ERROR GET direcciones" + ex.getMessage());
        }
        
        return direcciones;
    
    }

    @Override
    public int agregarDireccion(Direccion direccion) {
         Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        int id=0;
        //Aquí va el call del procedure
        String stProcedure="agregarDireccion";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            //Aquí van los sets
            //cstmt.setInt(1,citaEmpleado.getIdCitaEmpleado());

            
            cstmt.setInt(1,direccion.getIdDireccion());
            cstmt.setString(2,direccion.getCalle());
            cstmt.setString(3,direccion.getNoInterior());
            cstmt.setString(4,direccion.getNoExterior());    
            cstmt.setString(5,direccion.getColonia());
            cstmt.setInt(6,direccion.getEstatus());
            
            //Aquí va el registerOutParameter
            //cstmt.registerOutParameter(12,Types.INTEGER);
            
            cstmt.executeUpdate();
            
            ResultSet rs = cstmt.getGeneratedKeys();
            
            rs.next();
            
           id=rs.getInt(1);
           
           cstmt.close();
            
        }catch(SQLException ex){
            
             System.out.println("Estoy en el catch de agregar direccion ");
            System.out.println(ex.getMessage());
            
        }
        
        
        return id;
    }

    @Override
    public boolean actualizarDireccion(Direccion direccion) {
       Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        //Call del store procedure
        String stProcedure="actualizarDireccion";
        
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1,direccion.getIdDireccion());
            cstmt.setString(2,direccion.getCalle());
            cstmt.setString(3,direccion.getNoInterior());
            cstmt.setString(4,direccion.getNoExterior());    
            cstmt.setString(5,direccion.getColonia());
            cstmt.setInt(6,direccion.getEstatus());
           
            
            
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            
           return rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            System.out.println("Estoy en el catch de actualizarDireccion ");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean borradoLogicoDireccion(int idDireccion) {
         Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        //Call del store procedure
        String stProcedure="borradoLogicoDireccion";
        
        
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,idDireccion);
            
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            
           return rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            System.out.println("Estoy en el catch de borradoLogicoDireccion");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    

}
