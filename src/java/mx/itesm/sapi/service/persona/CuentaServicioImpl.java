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
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class CuentaServicioImpl implements CuentaServicio{


    @Override
    public boolean borradoLogicoCuenta(int idCuenta) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        //Call del store procedure
        String stProcedure="borradoLogicoCuenta";
        
        
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,idCuenta);
            
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            
           return rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            System.out.println("Estoy en el catch de borrarLCuenta");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Cuenta mostrarCuenta(int idCuenta) {
         Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        Cuenta cuenta = new Cuenta();
        
        //Call del store procedure
        String stProcedure="mostrarCuenta";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idCuenta);
            
            ResultSet rs = cstmt.executeQuery();
            
         
            
            rs.next();
            cuenta.setIdCuenta(rs.getInt("idCuenta"));
            cuenta.setIdPersona(rs.getInt("idPersona"));
            cuenta.setIdRol(rs.getInt("idRol"));
            cuenta.setIdEstadoCuenta(rs.getInt("idEstadoCuenta"));
            cuenta.setUsuario(rs.getString("usario"));
            cuenta.setPassword(rs.getString("password"));
            cuenta.setToken(rs.getString("token"));
            cuenta.setEstatus(rs.getInt("estatus"));
            
            
           
            return cuenta;
        }catch(SQLException ex){
            
            System.out.println("Estoy en el catch de mostrarCuenta ");
            System.out.println(ex.getMessage());
            return cuenta;
        }
    
    }

    @Override
    public List<Cuenta> mostrarCuenta() {
        Connection conn = Conexion.getConnection();
        
        
        List<Cuenta> cuentas = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL getCuenta()");
            ResultSet rs = cstmt.executeQuery();
            Cuenta cuenta;
            
            while(rs.next()){
                
                cuenta = new Cuenta();
                
            cuenta.setIdCuenta(rs.getInt(1));
            cuenta.setIdPersona(rs.getInt(2));
            cuenta.setIdRol(rs.getInt(3));
            cuenta.setIdEstadoCuenta(rs.getInt(4));
            cuenta.setUsuario(rs.getString(5));
            cuenta.setPassword(rs.getString(6));
            cuenta.setToken(rs.getString(7));
            cuenta.setEstatus(rs.getInt(8));
                
                cuentas.add(cuenta);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(SQLException ex){
            System.out.println("ERROR GET sexos" + ex.getMessage());
        }
        
        return cuentas;
    }

    @Override
    public int agregarCuenta(Cuenta cuenta) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        int id=0;
        //Aquí va el call del procedure
        String stProcedure="agregarCuenta";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            //Aquí van los sets 
            cstmt.setInt(1,cuenta.getIdCuenta());
            cstmt.setInt(2,cuenta.getIdPersona());
            cstmt.setInt(3,cuenta.getIdRol());
            cstmt.setInt(4,cuenta.getIdEstadoCuenta());
            cstmt.setString(5,cuenta.getUsuario());     
            cstmt.setString(6,cuenta.getPassword());
            cstmt.setString(7,cuenta.getToken());
            cstmt.setInt(8,cuenta.getEstatus());
            
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
    public boolean actualizarCuenta(Cuenta cuenta) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        //Call del store procedure
        String stProcedure="actualizarCuenta";
        
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1,cuenta.getIdCuenta());
            cstmt.setInt(2,cuenta.getIdPersona());
            cstmt.setInt(3,cuenta.getIdRol());
            cstmt.setInt(4,cuenta.getIdEstadoCuenta());
            cstmt.setString(5,cuenta.getUsuario());     
            cstmt.setString(6,cuenta.getPassword());
            cstmt.setString(7,cuenta.getToken());
            cstmt.setInt(8,cuenta.getEstatus());
           
            
            
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            
           return rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            System.out.println("Estoy en el catch de actualizarCuenta ");
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
}
