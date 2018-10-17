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
import mx.itesm.sapi.bean.gestionTratamiento.FarmacoTipoTratamiento;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Admin
 */
public class FarmacoTipoTratamientoServiceImpl implements FarmacoTipoTratamientoService {

    @Override
    public int agregarFarmacoTipoTratamiento(FarmacoTipoTratamiento farmacoTipoTratamiento) {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
                        
        //Id para devolver
        int id = -1;
        
        //Aquí va el call del procedure
        String stProcedure="CALL agregarFarmacoTipoTratamiento(?,?,?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            //Aquí van los sets
            
            cstmt.setInt(1,farmacoTipoTratamiento.getIdFarmaco());
            cstmt.setInt(2,farmacoTipoTratamiento.getIdTipoTratamiento());
            cstmt.setInt(3, farmacoTipoTratamiento.getEstatus());
            
            cstmt.executeUpdate();
            
            rs = cstmt.getGeneratedKeys();
            rs.next();
            
            id = cstmt.getInt(1);
           
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            id = -1;
            System.out.println("IdFarmaco: " + farmacoTipoTratamiento.getIdFarmaco());
            System.out.println("IdTipoTratamiento: " + farmacoTipoTratamiento.getIdTipoTratamiento());
            System.out.println("Estatus: " + farmacoTipoTratamiento.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return id;
    }

    @Override
    public FarmacoTipoTratamiento mostrarFarmacoTipoTratamiento(int idFarmacoTipoTratamiento) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        FarmacoTipoTratamiento farmacoTipoTratamiento = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarFarmacoTipoTratamiento(?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            farmacoTipoTratamiento = new FarmacoTipoTratamiento();
            
            cstmt.setInt(1, idFarmacoTipoTratamiento);
            rs = cstmt.executeQuery();
            
            rs.next();
            farmacoTipoTratamiento.setIdFarmacoTipoTratamiento(rs.getInt(1));
            farmacoTipoTratamiento.setIdFarmaco(rs.getInt(2));
            farmacoTipoTratamiento.setIdTipoTratamiento(rs.getInt(3));
            farmacoTipoTratamiento.setEstatus(rs.getInt(4));
            
            rs.close();
            cstmt.close();
            conn.close();
           
        }catch(SQLException ex){
            farmacoTipoTratamiento = null;
            System.out.println("ID: " + idFarmacoTipoTratamiento);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return farmacoTipoTratamiento;
    }

    @Override
    public List<FarmacoTipoTratamiento> mostrarFarmacoTipoTratamiento() {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<FarmacoTipoTratamiento> farmacosTipoTratamiento = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarListaFarmacoTipoTratamiento()";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            farmacosTipoTratamiento = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            FarmacoTipoTratamiento farmacoTipoTratamiento;
            
            while(rs.next()){
                farmacoTipoTratamiento = new FarmacoTipoTratamiento();
                farmacoTipoTratamiento.setIdFarmacoTipoTratamiento(rs.getInt(1));
                farmacoTipoTratamiento.setIdFarmaco(rs.getInt(2));
                farmacoTipoTratamiento.setIdTipoTratamiento(rs.getInt(3));
                farmacoTipoTratamiento.setEstatus(rs.getInt(4));

                farmacosTipoTratamiento.add(farmacoTipoTratamiento);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex) {
           farmacosTipoTratamiento = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return farmacosTipoTratamiento;
    }

    @Override
    public boolean actualizarFarmacoTipoTratamiento(FarmacoTipoTratamiento farmacoTipoTratamiento) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        boolean exito = false;
        
        //Call del store procedure
        String stProcedure="CALL actualizarFarmacoTipoTratamiento(?,?,?,?)";
        
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, farmacoTipoTratamiento.getIdFarmacoTipoTratamiento());
            cstmt.setInt(2, farmacoTipoTratamiento.getIdFarmaco());
            cstmt.setInt(3,farmacoTipoTratamiento.getIdTipoTratamiento());
            cstmt.setInt(4, farmacoTipoTratamiento.getEstatus());
            
            rs = cstmt.executeQuery();
            
            rs.next();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            exito = false;
            System.out.println("IdFarmacoTipoTratamiento: " + farmacoTipoTratamiento.getIdFarmacoTipoTratamiento());
            System.out.println("IdFarmaco: " + farmacoTipoTratamiento.getIdFarmaco());
            System.out.println("IdTipoTratamiento: " + farmacoTipoTratamiento.getIdTipoTratamiento());
            System.out.println("Estatus: " + farmacoTipoTratamiento.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }

    @Override
    public boolean borradoLogicoFarmacoTipoTratamiento(int idFarmacoTipoTratamiento) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        boolean exito = false;
        
        //Call del store procedure
        String stProcedure="CALL borradoLogicoFarmacoTipoTratamiento(?,?,?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, idFarmacoTipoTratamiento);
            
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
