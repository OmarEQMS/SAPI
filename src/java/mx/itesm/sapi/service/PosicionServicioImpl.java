/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.Posicion;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Admin
 */
public class PosicionServicioImpl implements PosicionServicio {

    @Override
    public int savePosicion(Posicion posicion) {
        
        
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        int id=0;
        //Aquí va el call del procedure
        String sql="";
        
        try{
            
            cstmt = conn.prepareCall(sql);
            
            //Aquí van los sets
            
            //Aquí va el registerOutParameter
            
            cstmt.executeUpdate();
            
            ResultSet rs = cstmt.getGeneratedKeys();
            
            rs.next();
            
            //Obtienes el out del store procedure
            
           id=cstmt.getInt(1);
           
           cstmt.close();
            
        }catch(SQLException ex){
            
             System.out.println("Estoy en el catch de PosicionServicio");
            System.out.println(ex.getMessage());
            
        }
               
        return id;        
        }
    

    @Override
    public List<Posicion> getPosiciones() {
    
         Connection conn = Conexion.getConnection();
        
        
        List<Posicion> posiciones = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("");
            ResultSet rs = cstmt.executeQuery();
            Posicion posicion;
            
            while(rs.next()){
                
                posicion = new Posicion();
                
                posicion.setIdPosicion(rs.getInt(1));
                posicion.setNombre(rs.getString(2));
                
                posiciones.add(posicion);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception e){
            System.out.println("ERROR GET POSICIONES" + e.getMessage());
        }
        
        return posiciones;

    }

    @Override
    public boolean deletePosicion(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existePosicion(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
