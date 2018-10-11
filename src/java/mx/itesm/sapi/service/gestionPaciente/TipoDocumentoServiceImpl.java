/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.Connection;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.util.Conexion;
import mx.itesm.sapi.bean.gestionPaciente.TipoDocumento;


/**
 *
 * @author urieldiaz
 */
public class TipoDocumentoServiceImpl implements TipoDocumentoService{

    @Override
    public TipoDocumento mostrarTipoDocumento(int idTipoDocumento) {
        Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        
        TipoDocumento tipoDocumento = new TipoDocumento();
        
        String stProcedure ="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();
            
            tipoDocumento.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
            tipoDocumento.setNombre(rs.getString("nombre"));
            tipoDocumento.setEstatus(rs.getInt("estatus"));
            
        
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            tipoDocumento= null;
        }
        return tipoDocumento;
    }

    @Override
    public List<TipoDocumento> mostrarAllTipoDocumento() {
        Connection conn;
        List<TipoDocumento> tipoDocumentos = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure="";
        
        ResultSet rs;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            TipoDocumento tipoDocumento;
            
            while(rs.next()){
                tipoDocumento = new TipoDocumento();
                tipoDocumento.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
                tipoDocumento.setNombre(rs.getString("nombre"));
                tipoDocumento.setEstatus(rs.getInt("estatus"));
                
                tipoDocumentos.add(tipoDocumento);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            tipoDocumentos = null;
        }
        return tipoDocumentos;
    }

    @Override
    public int agregarTipoDocumento(TipoDocumento tipoDocumento) {
        Connection conn; 
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        String stPrcedure="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);
            
            cstmt.setInt(1, tipoDocumento.getIdTipoDocumento());
            cstmt.setString(2, tipoDocumento.getNombre());
            cstmt.setInt(3, tipoDocumento.getEstatus());
           
            
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
    public boolean actualizarTipoDocumento(TipoDocumento tipoDocumento) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito= false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, tipoDocumento.getIdTipoDocumento());
            cstmt.setString(2, tipoDocumento.getNombre());
            cstmt.setInt(3, tipoDocumento.getEstatus());
            
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

    @Override
    public boolean borradoLogicoTipoDocumento(int idTipoDocumento) {
        Connection conn; 
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito = false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idTipoDocumento);
            
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
    
}
