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
import mx.itesm.sapi.bean.persona.Municipio;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class MunicipioServicioImpl implements MunicipioServicio{

   

    @Override
    public boolean borradoLogicoMunicipio(int idMunicipio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Municipio mostrarMunicipio(int idMunicipio) {
         Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        Municipio municipio = new Municipio();
        
        //Call del store procedure
        String stProcedure="mostrarMunicipio";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idMunicipio);
            
            ResultSet rs = cstmt.executeQuery();
            
         
            
            rs.next();
            municipio.setIdMunicipio(rs.getInt("idMunicipio"));
            municipio.setNombre(rs.getString("nombre"));
             municipio.setIdEstado(rs.getInt("idEstado"));
            municipio.setEstatus(rs.getInt("estatus"));
            
            
           
            return municipio;
        }catch(SQLException ex){
            
            System.out.println("Estoy en el catch de mostrarM municipio.setIdMunicipio(rs.getInt(\"idSexo\")); ");
            System.out.println(ex.getMessage());
            return municipio;
        }
    }

    @Override
    public List<Municipio> mostrarMunicipio() {
        Connection conn = Conexion.getConnection();
        
        
        List<Municipio> municipios = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL getSexo()");
            ResultSet rs = cstmt.executeQuery();
            Municipio municipio;
            
            while(rs.next()){
                
                municipio = new Municipio();
                
            municipio.setIdMunicipio(rs.getInt(1));
            municipio.setNombre(rs.getString(2));
            municipio.setIdMunicipio(rs.getInt(3));
            municipio.setEstatus(rs.getInt(4));
                
                municipios.add(municipio);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(SQLException ex){
            System.out.println("ERROR GET municipios" + ex.getMessage());
        }
        
        return municipios;
    }

    @Override
    public int agregarMunicipio(Municipio municipio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarMunicipio(Municipio municipio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
