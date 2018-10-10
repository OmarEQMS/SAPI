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
import mx.itesm.sapi.bean.persona.Sexo;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class SexoServiciosImpl implements SexoServicio{

    @Override
    public Sexo mostrarSexo(int idSexo) {
         Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        Sexo sexo = new Sexo();
        
        //Call del store procedure
        String stProcedure="mostrarSexo";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idSexo);
            
            ResultSet rs = cstmt.executeQuery();
            
         
            
            rs.next();
            sexo.setIdSexo(rs.getInt("idSexo"));
            sexo.setNombre(rs.getString("nombre"));
            sexo.setEstatus(rs.getInt("estatus"));
            
            
           
            return sexo;
        }catch(SQLException ex){
            
            System.out.println("Estoy en el catch de mostrarSexo ");
            System.out.println(ex.getMessage());
            return sexo;
        }
    }

    @Override
    public List<Sexo> mostrarSexo() {
        Connection conn = Conexion.getConnection();
        
        
        List<Sexo> sexos = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL getSexo()");
            ResultSet rs = cstmt.executeQuery();
            Sexo sexo;
            
            while(rs.next()){
                
                sexo = new Sexo();
                
            sexo.setIdSexo(rs.getInt(1));
            sexo.setNombre(rs.getString(2));
            sexo.setEstatus(rs.getInt(3));
                
                sexos.add(sexo);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(SQLException ex){
            System.out.println("ERROR GET sexos" + ex.getMessage());
        }
        
        return sexos;
    }
    

    @Override
    public int agregarSexo(Sexo sexo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarSexo(Sexo sexo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrarLogicoSexo(int idSexo) {
         Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        //Call del store procedure
        String stProcedure="borradoLogicoSexo";
        
        
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,idSexo);
            
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            
           return rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            System.out.println("Estoy en el catch de borrarSexo");
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
}
