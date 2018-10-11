/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.LugarDelCuerpo;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author urieldiaz
 */
public class LugarDelCuerpoServiceImpl implements LugarDelCuerpoService{

    @Override
    public LugarDelCuerpo mostrarLugarDelCuerpo(int idLugarDelCuerpo) {
        Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        
        LugarDelCuerpo lugarDelCuerpo = new LugarDelCuerpo();
        
        String stProcedure ="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();
            
            lugarDelCuerpo.setIdLugarDelCuerpo(rs.getInt("idLugarDelCuerpo"));
            lugarDelCuerpo.setNombre(rs.getString("nombre"));
            lugarDelCuerpo.setEstatus(rs.getInt("estatus"));
            
        
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            lugarDelCuerpo= null;
        }
        return lugarDelCuerpo;
    }

    @Override
    public LugarDelCuerpo mostrarLugarDelCuerpo(String nombreLugarDelCuerpo) {
         Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        LugarDelCuerpo lugarDelCuerpo = new LugarDelCuerpo();
        
        String stProcedure ="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();
            
            lugarDelCuerpo.setIdLugarDelCuerpo(rs.getInt("idLugarDelCuerpo"));
            lugarDelCuerpo.setNombre(rs.getString("nombre"));
            lugarDelCuerpo.setEstatus(rs.getInt("estatus"));
        
            
            rs.close();
            cstmt.close();
            conn.close();
            
            
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            lugarDelCuerpo = null;
        }
        return lugarDelCuerpo;
    }

    @Override
    public List<LugarDelCuerpo> mostrarLugarDelCuerpo() {
        Connection conn;
        List<LugarDelCuerpo> listaLugarDelCuerpo = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure="";
        
        ResultSet rs;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            LugarDelCuerpo lugarDelCuerpo;
            
            while(rs.next()){
                lugarDelCuerpo = new LugarDelCuerpo();
                lugarDelCuerpo.setIdLugarDelCuerpo(rs.getInt("idLugarDelCuerpo"));
                lugarDelCuerpo.setNombre(rs.getString("nombre"));
                lugarDelCuerpo.setEstatus(rs.getInt("estatus"));
                
                listaLugarDelCuerpo.add(lugarDelCuerpo);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listaLugarDelCuerpo = null;
        }
        return listaLugarDelCuerpo;
    }

    @Override
    public int agregarLugarDelCuerpo(LugarDelCuerpo lugarDelCuerpo) {
        Connection conn; 
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        String stPrcedure="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);
            
            cstmt.setInt(1, lugarDelCuerpo.getIdLugarDelCuerpo());
            cstmt.setString(2, lugarDelCuerpo.getNombre());
            cstmt.setInt(3, lugarDelCuerpo.getEstatus());
            
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
    public boolean actualizarLugarDelCuerpo(LugarDelCuerpo lugarDelCuerpo) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito= false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, lugarDelCuerpo.getIdLugarDelCuerpo());
            cstmt.setString(2, lugarDelCuerpo.getNombre());
            cstmt.setInt(3, lugarDelCuerpo.getEstatus());
            
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
    public boolean borradoLogicoLugarDelCuerpo(int idLugarDelCuerpo) {
        Connection conn; 
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito = false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idLugarDelCuerpo);
            
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
