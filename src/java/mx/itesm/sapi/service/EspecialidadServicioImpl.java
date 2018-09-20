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
import mx.itesm.sapi.bean.Especialidad;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Admin
 */
public class EspecialidadServicioImpl implements EspecialidadServicio {

    @Override
    public Especialidad getEspecilidades(int idEspecialidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Especialidad> getEspecialidades() {
         Connection conn = Conexion.getConnection();
        
        
        List<Especialidad> especialidades = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("");
            ResultSet rs = cstmt.executeQuery();
            Especialidad especialidad;
            
            while(rs.next()){
                
                especialidad = new Especialidad();
                
                especialidad.setIdEspecialidad(rs.getInt(1));
                especialidad.setNombre(rs.getString(2));
                
                especialidades.add(especialidad);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception e){
            System.out.println("ERROR GET ESPECIALIDAD" + e.getMessage());
        }
        
        return especialidades;

    }

    @Override
    public int saveEspecialidad(Especialidad especialidad) {
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
            
           id=cstmt.getInt(1);
           
           cstmt.close();
            
        }catch(SQLException ex){
            
             System.out.println("Estoy en el catch de EspecialidadServicio");
            System.out.println(ex.getMessage());
            
        }
               
        return id;        
        }
    

    @Override
    public boolean deleteEspecialidad(int idEspecialidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existsEspecialidad(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
