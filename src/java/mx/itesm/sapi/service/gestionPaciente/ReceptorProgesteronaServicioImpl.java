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
import mx.itesm.sapi.bean.gestionPaciente.ReceptorProgesterona;

/**
 *
 * @author Uriel Díaz & Alexis España
 */
public class ReceptorProgesteronaServicioImpl implements ReceptorProgesteronaServicio{

    @Override
    public ReceptorProgesterona mostrarReceptorProgesterona(int idReceptorProgesterona) {
       Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        
        ReceptorProgesterona receptorProgesterona = new ReceptorProgesterona();
        
        String stProcedure ="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();
            
            receptorProgesterona.setIdReceptorProgesterona(rs.getInt("idReceptorProgesterona"));
            receptorProgesterona.setNombre(rs.getString("nombre"));
            receptorProgesterona.setEstatus(rs.getInt("estatus"));
            
        
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            receptorProgesterona= null;
        }
        return receptorProgesterona;
    }

    @Override
    public List<ReceptorProgesterona> mostrarAllReceptorProgesterona() {
        Connection conn;
        List<ReceptorProgesterona> listReceptorProgesterona = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure="";
        
        ResultSet rs;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            ReceptorProgesterona receptorProgesterona;
            
            while(rs.next()){
                receptorProgesterona = new ReceptorProgesterona();
                receptorProgesterona.setIdReceptorProgesterona(rs.getInt("idReceptorProgesterona"));
                receptorProgesterona.setNombre(rs.getString("nombre"));
                receptorProgesterona.setEstatus(rs.getInt("estatus"));
                
                
                listReceptorProgesterona.add(receptorProgesterona);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listReceptorProgesterona = null;
        }
        return listReceptorProgesterona;
        
    }

    @Override
    public int agregarReceptorProgesterona(ReceptorProgesterona receptorProgesterona) {
       Connection conn; 
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        String stPrcedure="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);
            
            cstmt.setInt(1, receptorProgesterona.getIdReceptorProgesterona());
            cstmt.setString(2, receptorProgesterona.getNombre());
            cstmt.setInt(3, receptorProgesterona.getEstatus());
           
            
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
    public boolean actualizarReceptorProgesterona(ReceptorProgesterona receptorProgesterona) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito= false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, receptorProgesterona.getIdReceptorProgesterona());
            cstmt.setString(2, receptorProgesterona.getNombre());
            cstmt.setInt(3, receptorProgesterona.getEstatus());
            
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
    public boolean borradoLogicoReceptorProgesterona(int idReceptorProgesterona) {
        Connection conn; 
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito = false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idReceptorProgesterona);
            
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
