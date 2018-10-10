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
import mx.itesm.sapi.bean.persona.Estado;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class EstadoServicioImpl implements EstadoServicio{

   

    @Override
    public boolean borradoLogicoEstado(int idEstado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado mostrarEstado(int idEstado) {
         Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        Estado estado = new Estado();
        
        //Call del store procedure
        String stProcedure="mostrarEstado";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEstado);
            
            ResultSet rs = cstmt.executeQuery();
            
         
            
            rs.next();
            estado.setIdEstado(rs.getInt("idEstado"));
            estado.setNombre(rs.getString("nombre"));
            estado.setEstatus(rs.getInt("estatus"));
            
            
           
            return estado;
        }catch(SQLException ex){
            
            System.out.println("Estoy en el catch de mostrarEstado ");
            System.out.println(ex.getMessage());
            return estado;
        }
    }

    @Override
    public List<Estado> mostrarEstado() {
       Connection conn = Conexion.getConnection();
        
        
        List<Estado> estados = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL getEstado()");
            ResultSet rs = cstmt.executeQuery();
            Estado estado;
            
            while(rs.next()){
                
                estado = new Estado();
                
            estado.setIdEstado(rs.getInt(1));
            estado.setNombre(rs.getString(2));
            estado.setEstatus(rs.getInt(3));
                
                estados.add(estado);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(SQLException ex){
            System.out.println("ERROR GET estados" + ex.getMessage());
        }
        
        return estados;
    }

    @Override
    public int agregarEstado(Estado estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarEstado(Estado estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
