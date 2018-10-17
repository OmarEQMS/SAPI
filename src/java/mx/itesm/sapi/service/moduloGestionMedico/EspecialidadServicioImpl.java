/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.moduloGestionMedico;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.Especialidad;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author feror
 */
public class EspecialidadServicioImpl implements EspecialidadServicio{

    @Override
    public Especialidad mostrarEspecialidad(int idEspecialidad) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        Especialidad especialidad = new Especialidad();
        
        //Call del store procedure
        String stProcedure="CALL estado(?)";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, idEspecialidad);

            ResultSet rs = cstmt.executeQuery();
            
         
            
            rs.next();
            
            especialidad.setNombre(rs.getString(1));
            especialidad.setSubEspecialidad(rs.getInt(2));
            especialidad.setEstatus(rs.getInt(3));
            
            
           
            return especialidad;
        }catch(SQLException ex){
            
            System.out.println("Estoy en el catch de mostrarEspecialidad");
            System.out.println(ex.getMessage());
            return especialidad;
        }
    }

    @Override
    public List<Especialidad> mostrarEspecialidad() {
        Connection conn = Conexion.getConnection();
        
        
        List<Especialidad> especialidades = new ArrayList<>();
        CallableStatement cstmt;
        
        try{
            
            
            cstmt = conn.prepareCall("CALL -----");
            ResultSet rs = cstmt.executeQuery();
            Especialidad especialidad;
            
            while(rs.next()){
                
                especialidad = new Especialidad();
                
                 especialidad.setNombre(rs.getString(1));
            especialidad.setSubEspecialidad(rs.getInt(2));
            especialidad.setEstatus(rs.getInt(3));
                
                especialidades.add(especialidad);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception ex){
            System.out.println("Estoy en el catch de mostrarEspecialidad");
            System.out.println(ex.getMessage());
        }
        
        return especialidades;
    }
    
}
