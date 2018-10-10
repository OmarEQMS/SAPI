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
import mx.itesm.sapi.bean.persona.EstadoCuenta;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class EstadoCuentaServicioImpl implements EstadoCuentaServicio{


    @Override
    public boolean borradoLogicoEstadoCuenta(int idEstadoCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EstadoCuenta mostrarEstadoCuenta(int idEstadoCuenta) {
         Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        EstadoCuenta estadoCuenta = new EstadoCuenta();
        
        //Call del store procedure
        String stProcedure="mostrarEstadoCuenta";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEstadoCuenta);
            
            ResultSet rs = cstmt.executeQuery();
            
         
            
            rs.next();
            estadoCuenta.setIdEstadoCuenta(rs.getInt("idEstadoCuenta"));
            estadoCuenta.setNombre(rs.getString("nombre"));
            estadoCuenta.setEstatus(rs.getInt("estatus"));
            
            
           
            return estadoCuenta;
        }catch(SQLException ex){
            
            System.out.println("Estoy en el catch de mostrarEstadoCuenta ");
            System.out.println(ex.getMessage());
            return estadoCuenta;
        }
    
    }

    @Override
    public List<EstadoCuenta> mostrarEstadoCuenta() {
       Connection conn = Conexion.getConnection();
        
        
        List<EstadoCuenta> estadoCuentas = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL getEstadoCuenta()");
            ResultSet rs = cstmt.executeQuery();
            EstadoCuenta estadoCuenta;
            
            while(rs.next()){
                
                estadoCuenta = new EstadoCuenta();
                
            estadoCuenta.setIdEstadoCuenta(rs.getInt(1));
            estadoCuenta.setNombre(rs.getString(2));
            estadoCuenta.setEstatus(rs.getInt(3));
                
                estadoCuentas.add(estadoCuenta);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(SQLException ex){
            System.out.println("ERROR GET estadoCuentas" + ex.getMessage());
        }
        
        return estadoCuentas;
    }

    @Override
    public int agregarEstadoCuenta(EstadoCuenta estadoCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarEstadoCuenta(EstadoCuenta estadoCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
