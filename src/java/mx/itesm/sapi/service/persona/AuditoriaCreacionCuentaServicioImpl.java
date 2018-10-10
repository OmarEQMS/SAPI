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
import mx.itesm.sapi.bean.persona.AuditoriaCreacionCuenta;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class AuditoriaCreacionCuentaServicioImpl implements AuditoriaCreacionCuentaServicio{

  

    @Override
    public int agregarAuditoriaCreacionCuenta(AuditoriaCreacionCuenta auditoriaCreacionCuenta) {
         Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        int id=0;
        //Aquí va el call del procedure
        String stProcedure="agregarAuditoriaCreacionCuenta";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            //Aquí van los sets
            //cstmt.setInt(1,citaEmpleado.getIdCitaEmpleado());
            
            cstmt.setInt(1,auditoriaCreacionCuenta.getIdAuditoriaCreacionCuenta());
            cstmt.setInt(2,auditoriaCreacionCuenta.getIdCuenta());
            cstmt.setDate(3,auditoriaCreacionCuenta.getFecha());
           
            cstmt.setInt(4,auditoriaCreacionCuenta.getCondiciones());
            cstmt.setInt(5,auditoriaCreacionCuenta.getEstatus());
            
            //Aquí va el registerOutParameter
            //cstmt.registerOutParameter(12,Types.INTEGER);
            
            cstmt.executeUpdate();
            
            ResultSet rs = cstmt.getGeneratedKeys();
            
            rs.next();
            
           id=rs.getInt(1);
           
           cstmt.close();
            
        }catch(SQLException ex){
            
             System.out.println("Estoy en el catch de agregar AuditoriaCreacionCuenta ");
            System.out.println(ex.getMessage());
            
        }
        
        
        return id;
    }

    @Override
    public boolean actualizarAuditoriaCreacionCuenta(AuditoriaCreacionCuenta auditoriaCreacionCuenta) {
         Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        //Call del store procedure
        String stProcedure="actualizarAuditoriaCreacionCuenta";
        
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1,auditoriaCreacionCuenta.getIdAuditoriaCreacionCuenta());
            cstmt.setInt(2,auditoriaCreacionCuenta.getIdCuenta());
            cstmt.setDate(3,auditoriaCreacionCuenta.getFecha());
           
            cstmt.setInt(4,auditoriaCreacionCuenta.getCondiciones());
            cstmt.setInt(5,auditoriaCreacionCuenta.getEstatus());
           
            
            
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            
           return rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            System.out.println("Estoy en el catch de actualizarAuditoriaCreacionCuenta ");
            System.out.println(ex.getMessage());
            return false;
        }
            
    
    }

    @Override
    public boolean borradoLogicoAuditoriaCreacionCuenta(int idAuditoriaCreacionCuenta) {
         Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        //Call del store procedure
        String stProcedure="borradoLogicoAuditoriaCreacionCuenta";
        
        
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,idAuditoriaCreacionCuenta);
            
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            
           return rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            System.out.println("Estoy en el catch de auditoriaCreacionCuenta");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public AuditoriaCreacionCuenta mostrarAuditoriaCreacionCuenta(int idAuditoriaCreacionCuenta) {
         Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        AuditoriaCreacionCuenta auditoriaCreacionCuenta = new AuditoriaCreacionCuenta();
        
        //Call del store procedure
        String stProcedure="mostrarAuditoriaCreacionCuenta";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idAuditoriaCreacionCuenta);
            
            ResultSet rs = cstmt.executeQuery();
            
         
            
            rs.next();
            auditoriaCreacionCuenta.setIdAuditoriaCreacionCuenta(rs.getInt("idAuditoriaCreacionCuenta"));
            auditoriaCreacionCuenta.setIdCuenta(rs.getInt("idCuenta"));
            auditoriaCreacionCuenta.setFecha(rs.getDate("fecha"));
            
            auditoriaCreacionCuenta.setCondiciones(rs.getInt("condiciones"));
            auditoriaCreacionCuenta.setEstatus(rs.getInt("estatus"));
            
            
           
            return auditoriaCreacionCuenta;
        }catch(SQLException ex){
            
            System.out.println("Estoy en el catch de auditoriaCreacionCuenta");
            System.out.println(ex.getMessage());
            return auditoriaCreacionCuenta;
        }
    }

    @Override
    public List<AuditoriaCreacionCuenta> mostrarAuditoriaCreacionCuenta() {
         Connection conn = Conexion.getConnection();
        
        
        List<AuditoriaCreacionCuenta> auditoriaCreacionCuentas = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL getAuditoriaCreacionCuenta()");
            ResultSet rs = cstmt.executeQuery();
            AuditoriaCreacionCuenta auditoriaCreacionCuenta;
            
            while(rs.next()){
                
                auditoriaCreacionCuenta = new AuditoriaCreacionCuenta();
                
                auditoriaCreacionCuenta.setIdAuditoriaCreacionCuenta(rs.getInt(1));
            auditoriaCreacionCuenta.setIdCuenta(rs.getInt(2));
            auditoriaCreacionCuenta.setFecha(rs.getDate(3));
          
            auditoriaCreacionCuenta.setCondiciones(rs.getInt(4));
            auditoriaCreacionCuenta.setEstatus(rs.getInt(5));
                
                auditoriaCreacionCuentas.add(auditoriaCreacionCuenta);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(SQLException ex){
            System.out.println("ERROR GET AuditoriaCreacionCuenta" + ex.getMessage());
        }
        
        return auditoriaCreacionCuentas;
    }
    
}


