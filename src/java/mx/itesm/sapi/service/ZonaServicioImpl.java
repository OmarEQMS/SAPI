/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.CodigoPostal;
import mx.itesm.sapi.bean.Estado;
import mx.itesm.sapi.bean.EstadoCivil;
import mx.itesm.sapi.bean.Municipio;
import mx.itesm.sapi.util.Conexion;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author feror
 */
public class ZonaServicioImpl implements ZonaServicio {

    @Override
    public List<Estado> getEstados() {
        
        Connection conn = Conexion.getConnection();
        
        
        List<Estado> estados = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL getEstados()");
            ResultSet rs = cstmt.executeQuery();
            Estado estado;
            
            while(rs.next()){
                
                estado = new Estado();
                
                estado.setIdEstado(rs.getInt("idEstado"));
                estado.setNombre(rs.getString("nombre"));
                
                estados.add(estado);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception e){
            System.out.println("ERROR GET ESTADOS" + e.getMessage());
        }
        
        return estados;

    }

    @Override
    public List<Municipio> getMunicipios(Estado estado) {
        
        Connection conn = Conexion.getConnection();
        
        
        List<Municipio> municipios= new ArrayList<>();
        
        try{
            
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL buscaMunicipio(?)");
            
            cstmt.setInt(1,estado.getIdEstado());
            ResultSet rs = cstmt.executeQuery();

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
            cstmt.close();
            conn.close();
            
         
            
        }catch(Exception e){
            System.out.println("ZonaServicio ERROR".concat(e.getMessage()));
        }
        
        return municipios;
        
    }

    @Override
    public List<EstadoCivil> getEstadoCivil() {
        Connection conn = Conexion.getConnection();
         List<EstadoCivil> estados = new ArrayList<>(); 
        try{            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL getEstadoCivil()");
             
            
            ResultSet rs = cstmt.executeQuery();
            EstadoCivil estado;            
            while(rs.next()){                
                estado = new EstadoCivil();                
                estado.setIdEstadoCivil(rs.getInt("idEstadoCivil"));
                estado.setNombre(rs.getString("nombre"));                
                estados.add(estado);            
            }            
            rs.close();
            cstmt.close();
            conn.close();                    
            
        }catch(Exception e){
            System.out.println("ERROR GET ESTADO CIVIL " + e.getMessage());
        }        
        return estados;
    }
    
    @Override
    public List<String> getEstadoyMunicipio(CodigoPostal codigoPostal){
        Connection conn = Conexion.getConnection();
        
        List<String> EstadoyMunicipio = new ArrayList<>();
        try{
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL getEstadoMunicipio(?)");
            cstmt.setString(1, codigoPostal.getNumero());
            ResultSet rs = cstmt.executeQuery();
            rs.next(); 
            
            //RECUPERACION
            String idEstado = rs.getString("idEstado");
	    String nombreEstado = rs.getString("nombreEstado");
            String idMunicipio = rs.getString("idMunicipio");
	    String nombreMunicipio = rs.getString("nombreMunicipio"); 
            
            EstadoyMunicipio.add(idEstado);
            EstadoyMunicipio.add(nombreEstado);
            EstadoyMunicipio.add(idMunicipio);
            EstadoyMunicipio.add(nombreMunicipio);
            
            rs.close();
            cstmt.close();
            conn.close();
            return EstadoyMunicipio;
            
        }catch(Exception ex){
                
            System.out.println("ESTOY EN EL CATCH DE EDOYMUN");
            Logger.getLogger(ZonaServicio.class.getName()).log(Level.SEVERE, null, ex);
            return EstadoyMunicipio;
        }
        
    }

}
