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
public class LugarDelCuerpoServicioImpl implements LugarDelCuerpoServicio{

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
}
