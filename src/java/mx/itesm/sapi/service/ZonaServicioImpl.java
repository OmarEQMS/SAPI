/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.Estado;
import mx.itesm.sapi.bean.EstadoCivil;
import mx.itesm.sapi.bean.Municipio;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author feror
 */
public class ZonaServicioImpl implements ZonaServicio {

    @Override
    public List<Estado> getEstados() {
        
        Connection conn = Conexion.getConnection();
        String sql = "SELECT * FROM estado";
        List<Estado> estados = new ArrayList<>();
        
        try{
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Estado estado;
            
            while(rs.next()){
                
                estado = new Estado();
                
                estado.setIdEstado(rs.getInt("idEstado"));
                estado.setNombre(rs.getString("nombre"));
                
                estados.add(estado);
            
            }
            
            rs.close();
            ps.close();
            conn.close();
                    
            
        }catch(Exception e){
            System.out.println("ERROR GET ESTADOS" + e.getMessage());
        }
        
        return estados;

    }

    @Override
    public List<Municipio> getMunicipios(Estado estado) {
        
        Connection conn = Conexion.getConnection();
        
        //String sql = "SELECT * FROM Municipio WHERE idEstado = 16";
        
      /*  String sql ="SELECT Municipio.idMunicipio,Municipio.nombre AS 'Municipio' "
                + "FROM Municipio WHERE Municipio.idEstado = (SELECT Estado.idEstado FROM    "
                + "Estado WHERE Estado.nombre = '".concat(estado.getNombre()).concat("')");*/
      
      String sql= "SELECT * FROM municipio WHERE idEstado=?";
        
        System.out.println("ID: " + estado.getIdEstado());
       
       
        List<Municipio> municipios= new ArrayList<>();
        
        try{
            
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1,estado.getIdEstado());
            ResultSet rs = ps.executeQuery();

            Municipio municipio;
            
           
            
            while(rs.next()){
                
                municipio = new Municipio();                
                municipio.setIdMunicipio(rs.getInt("idMunicipio"));
                municipio.setIdEstado(rs.getInt("idEstado"));
                municipio.setNombre(rs.getString("nombre"));
                
        
                
                municipios.add(municipio);
                
                System.out.println(municipios);
            }
            
            rs.close();
            ps.close();
            conn.close();
            
         
            
        }catch(Exception e){
            System.out.println("ZonaServicio ERROR".concat(e.getMessage()));
        }
        
        return municipios;
        
    }

    @Override
    public List<EstadoCivil> getEstadoCivil() {
        Connection conn = Conexion.getConnection();
        String sql = "SELECT * FROM estadoCivil";
        List<EstadoCivil> estados = new ArrayList<>();        
        try{            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            EstadoCivil estado;            
            while(rs.next()){                
                estado = new EstadoCivil();                
                estado.setIdEstadoCivil(rs.getInt("idEstadoCivil"));
                estado.setNombre(rs.getString("nombre"));                
                estados.add(estado);            
            }            
            rs.close();
            ps.close();
            conn.close();                    
            
        }catch(Exception e){
            System.out.println("ERROR GET ESTADO CIVIL " + e.getMessage());
        }        
        return estados;
    }

}
