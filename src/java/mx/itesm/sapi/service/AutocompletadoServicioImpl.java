/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Estudio;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author feror
 */
public class AutocompletadoServicioImpl implements AutocompletadoServicio{

    @Override
    public List<Estudio> mostrarEstudioRayosX() {
        Connection conn = Conexion.getConnection();
        
        
        List<Estudio> estudios = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL mostrarEstudioRayosX()");
            ResultSet rs = cstmt.executeQuery();
            Estudio estudio;
            
            while(rs.next()){
                
                estudio = new Estudio();
                
                estudio.setIdEstudio(rs.getInt("idEstudio"));
                estudio.setIdCategoriaEstudio(rs.getInt("idCategoriaEstudio"));
                estudio.setNombre(rs.getString("nombre"));
                estudio.setEtatus(rs.getInt("estatus"));
                
                estudios.add(estudio);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return estudios;
    }

    @Override
    public List<Estudio> mostrarEstudioUltrasonido() {
        Connection conn = Conexion.getConnection();
        
        
        List<Estudio> estudios = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL mostrarEstudioUltrasonido()");
            ResultSet rs = cstmt.executeQuery();
            Estudio estudio;
            
            while(rs.next()){
                
                estudio = new Estudio();
                
                estudio.setIdEstudio(rs.getInt("idEstudio"));
                estudio.setIdCategoriaEstudio(rs.getInt("idCategoriaEstudio"));
                estudio.setNombre(rs.getString("nombre"));
                estudio.setEtatus(rs.getInt("estatus"));
                
                estudios.add(estudio);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return estudios;
    }

    @Override
    public List<Estudio> mostrarEstudioProgramas() {
        Connection conn = Conexion.getConnection();
        
        
        List<Estudio> estudios = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL mostrarEstudioProgramas()");
            ResultSet rs = cstmt.executeQuery();
            Estudio estudio;
            
            while(rs.next()){
                
                estudio = new Estudio();
                
                estudio.setIdEstudio(rs.getInt("idEstudio"));
                estudio.setIdCategoriaEstudio(rs.getInt("idCategoriaEstudio"));
                estudio.setNombre(rs.getString("nombre"));
                estudio.setEtatus(rs.getInt("estatus"));
                
                estudios.add(estudio);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return estudios;
    }

    @Override
    public List<Estudio> mostrarEstudioMedicinaNuclear() {
        Connection conn = Conexion.getConnection();
        
        
        List<Estudio> estudios = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL mostrarEstudioMedicinaNuclear()");
            ResultSet rs = cstmt.executeQuery();
            Estudio estudio;
            
            while(rs.next()){
                
                estudio = new Estudio();
                
                estudio.setIdEstudio(rs.getInt("idEstudio"));
                estudio.setIdCategoriaEstudio(rs.getInt("idCategoriaEstudio"));
                estudio.setNombre(rs.getString("nombre"));
                estudio.setEtatus(rs.getInt("estatus"));
                
                estudios.add(estudio);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return estudios;
    }

    @Override
    public List<Estudio> mostrarEstudioValoracion() {
        Connection conn = Conexion.getConnection();
        
        
        List<Estudio> estudios = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL mostrarEstudioValoracion()");
            ResultSet rs = cstmt.executeQuery();
            Estudio estudio;
            
            while(rs.next()){
                
                estudio = new Estudio();
                
                estudio.setIdEstudio(rs.getInt("idEstudio"));
                estudio.setIdCategoriaEstudio(rs.getInt("idCategoriaEstudio"));
                estudio.setNombre(rs.getString("nombre"));
                estudio.setEtatus(rs.getInt("estatus"));
                
                estudios.add(estudio);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return estudios;
    }

    @Override
    public List<Estudio> mostrarEstudioSinCategoria() {
        Connection conn = Conexion.getConnection();
        
        
        List<Estudio> estudios = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL mostrarEstudioSinCategoria()");
            ResultSet rs = cstmt.executeQuery();
            Estudio estudio;
            
            while(rs.next()){
                
                estudio = new Estudio();
                
                estudio.setIdEstudio(rs.getInt("idEstudio"));
                estudio.setIdCategoriaEstudio(rs.getInt("idCategoriaEstudio"));
                estudio.setNombre(rs.getString("nombre"));
                estudio.setEtatus(rs.getInt("estatus"));
                
                estudios.add(estudio);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return estudios;
    }
    
}
