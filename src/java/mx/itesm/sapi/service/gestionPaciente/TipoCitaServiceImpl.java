/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mx.itesm.sapi.util.Conexion;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.TipoCita;

/**
 *
 * @author urieldiaz
 */
public class TipoCitaServiceImpl implements TipoCitaService{

    @Override
    public TipoCita mostrarTipoCita(int idTipoCita) {
         Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        
        TipoCita tipoCita = new TipoCita();
        
        String stProcedure ="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();
            
            tipoCita.setIdTipoCita(rs.getInt("idTipoCita"));
            tipoCita.setNombre(rs.getString("nombre"));
            tipoCita.setEstatus(rs.getInt("estatus"));
            
        
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            tipoCita= null;
        }
        return tipoCita;   
    }

    @Override
    public List<TipoCita> mostrarAllTipoCita() {
        Connection conn;
        List<TipoCita> tipoCitas = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure="";
        
        ResultSet rs;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            TipoCita tipoCita;
            
            while(rs.next()){
                tipoCita = new TipoCita();
                tipoCita.setIdTipoCita(rs.getInt("idTipoCita"));
                tipoCita.setNombre(rs.getString("nombre"));
                tipoCita.setEstatus(rs.getInt("estatus"));
               
                
                tipoCitas.add(tipoCita);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            tipoCitas = null;
        }
        return tipoCitas;
    }

    @Override
    public int agregarTipoCita(TipoCita tipoCita) {
       Connection conn; 
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        String stPrcedure="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);
            
            cstmt.setInt(1, tipoCita.getIdTipoCita());
            cstmt.setString(2, tipoCita.getNombre());
            cstmt.setInt(3, tipoCita.getEstatus());
            
            
            cstmt.executeUpdate();
            rs = cstmt.getGeneratedKeys();
            rs.next();
            id=rs.getInt(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
        }
        
        return id;
    }

    @Override
    public boolean borradoLogicoTipoCita(int idTipoCita) {
        Connection conn; 
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito = false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idTipoCita);
            
            rs = cstmt.executeQuery();
            rs.next();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch( SQLException ex){
           
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito=false;
        }
        return exito;
    }

    @Override
    public boolean actualizarTipoCita(TipoCita tipoCita) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito= false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, tipoCita.getIdTipoCita());
            cstmt.setString(2, tipoCita.getNombre());
            cstmt.setInt(3, tipoCita.getEstatus());
            
            rs = cstmt.executeQuery();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito=false;
        }
        return exito;
    }
    
}
