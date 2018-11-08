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
import mx.itesm.sapi.bean.gestionPaciente.ReceptorEstrogeno;

/**
 *
 * @author Uriel Díaz
 */
public class ReceptorEstrogenoServicioImpl implements ReceptorEstrogenoServicio{

    @Override
    public ReceptorEstrogeno mostrarReceptorEstrogeno(int idReceptorEstrogeno) {
        Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        
        ReceptorEstrogeno receptorEstrogeno = new ReceptorEstrogeno();
        
        String stProcedure ="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();
            
            receptorEstrogeno.setIdReceptorEstrogeno(rs.getInt("idReceptorEstrogeno"));
            receptorEstrogeno.setNombre(rs.getString("nombre"));
            receptorEstrogeno.setEstatus(rs.getInt("estatus"));
            
        
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            receptorEstrogeno = null;
        }
        return receptorEstrogeno;
        
        
    }

    @Override
    public List<ReceptorEstrogeno> mostrarReceptorEstrogeno() {
        Connection conn;
        List<ReceptorEstrogeno> listReceptorEstrogeno = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure="";
        
        ResultSet rs;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            ReceptorEstrogeno receptorEstrogeno;
            
            while(rs.next()){
                receptorEstrogeno = new ReceptorEstrogeno();
                receptorEstrogeno.setIdReceptorEstrogeno(rs.getInt("idReceptorEstrogeno"));
                receptorEstrogeno.setNombre(rs.getString("nombre"));
                receptorEstrogeno.setEstatus(rs.getInt("estatus"));
                
                
                listReceptorEstrogeno.add(receptorEstrogeno);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listReceptorEstrogeno = null;
        }
        return listReceptorEstrogeno;
        
    }

    @Override
    public int agregarReceptorEstrogeno(ReceptorEstrogeno receptorEstrogeno) {
         Connection conn; 
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        String stPrcedure="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);
            
            cstmt.setInt(1, receptorEstrogeno.getIdReceptorEstrogeno());
            cstmt.setString(2, receptorEstrogeno.getNombre());
            cstmt.setInt(3, receptorEstrogeno.getEstatus());
           
            
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
    public boolean borradoLogicoReceptorEstrogeno(int idReceptorEstrogeno) {
       
        Connection conn; 
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito = false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idReceptorEstrogeno);
            
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
    public boolean actualizarReceptorEstrogeno(ReceptorEstrogeno receptorEstrogeno) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito= false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, receptorEstrogeno.getIdReceptorEstrogeno());
            cstmt.setString(2, receptorEstrogeno.getNombre());
            cstmt.setInt(3, receptorEstrogeno.getEstatus());
         
            
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
