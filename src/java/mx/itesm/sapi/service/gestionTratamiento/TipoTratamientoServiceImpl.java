/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionTratamiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionTratamiento.TipoTratamiento;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Admin
 */
public class TipoTratamientoServiceImpl implements TipoTratamientoService {
    
    @Override
    public int agregarTipoTratamiento(TipoTratamiento tipoTratamiento) {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
                        
        //Id para devolver
        int id = -1;
        
        //Aquí va el call del procedure
        String stProcedure="CALL agregarTipoTratamiento(?,?,?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            //Aquí van los sets
            
            cstmt.setInt(1,tipoTratamiento.getIdTratamiento());
            cstmt.setString(2,tipoTratamiento.getNombre());
            cstmt.setInt(3,tipoTratamiento.getEstatus());
            
            cstmt.executeUpdate();
            
            rs = cstmt.getGeneratedKeys();
            rs.next();
            
            id = cstmt.getInt(1);
           
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            id = -1;
            System.out.println("IdTratamiento: " + tipoTratamiento.getIdTratamiento());
            System.out.println("Nombre: " + tipoTratamiento.getNombre());
            System.out.println("Estatus: " + tipoTratamiento.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return id;
    }

    @Override
    public TipoTratamiento mostrarTipoTratamiento(int idTipoTratamiento) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        TipoTratamiento tipoTratamiento = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarTipoTratamiento(?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            tipoTratamiento = new TipoTratamiento();
            
            cstmt.setInt(1, idTipoTratamiento);
            rs = cstmt.executeQuery();
            
            rs.next();
            tipoTratamiento.setIdTipoTratamiento(rs.getInt(1));
            tipoTratamiento.setIdTratamiento(rs.getInt(2));
            tipoTratamiento.setNombre(rs.getString(3));
            tipoTratamiento.setEstatus(rs.getInt(4));
            
            rs.close();
            cstmt.close();
            conn.close();
           
        }catch(SQLException ex){
            tipoTratamiento = null;
            System.out.println("ID: " + idTipoTratamiento);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return tipoTratamiento;
    }

    @Override
    public List<TipoTratamiento> mostrarTipoTratamiento() {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<TipoTratamiento> tiposTratamiento = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarListaTipoTratamiento(?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            tiposTratamiento = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            TipoTratamiento tipoTratamiento;
            
            while(rs.next()){
                tipoTratamiento = new TipoTratamiento();
                tipoTratamiento.setIdTipoTratamiento(rs.getInt(1));
                tipoTratamiento.setIdTratamiento(rs.getInt(2));
                tipoTratamiento.setNombre(rs.getString(3));
                tipoTratamiento.setEstatus(rs.getInt(4));

                tiposTratamiento.add(tipoTratamiento);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex) {
           tiposTratamiento = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return tiposTratamiento;
    }

    @Override
    public boolean actualizarTipoTratamiento(TipoTratamiento tipoTratamiento) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        boolean exito = false;
        
        //Call del store procedure
        String stProcedure="CALL actualizarTipoTratamiento(?,?,?,?)";
        
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, tipoTratamiento.getIdTipoTratamiento());
            cstmt.setInt(2, tipoTratamiento.getIdTratamiento());
            cstmt.setString(3, tipoTratamiento.getNombre());
            cstmt.setInt(4, tipoTratamiento.getEstatus());
            
            rs = cstmt.executeQuery();
            
            rs.next();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            exito = false;
            System.out.println("IdTipoTratamiento: " + tipoTratamiento.getIdTipoTratamiento());
            System.out.println("IdTratamiento: " + tipoTratamiento.getIdTratamiento());
            System.out.println("Nombre: " + tipoTratamiento.getNombre());
            System.out.println("Estatus: " + tipoTratamiento.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }

    @Override
    public boolean borradoLogicoTipoTratamiento(int idTipoTratamiento) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        boolean exito = false;
        
        //Call del store procedure
        String stProcedure="CALL borradoLogicoTipoTratamiento(?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, idTipoTratamiento);
            
            rs = cstmt.executeQuery();
            
            rs.next();
            
           exito = rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            exito = false;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }    
}
