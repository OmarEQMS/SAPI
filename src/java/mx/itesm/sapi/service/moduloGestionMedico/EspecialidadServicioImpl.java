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
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Fernanda Orduña & Pablo Lugo
 */
public class EspecialidadServicioImpl implements EspecialidadServicio{

    @Override
    public Especialidad mostrarEspecialidad(int idEspecialidad) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        Especialidad especialidad = new Especialidad();
        
        //Call del store procedure
        String stProcedure="CALL mostrarEspecialidad(?)";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, idEspecialidad);

            ResultSet rs = cstmt.executeQuery();
            
         
            
            rs.next();
            
            especialidad.setIdEspecialidad(rs.getInt("idEspecialidad"));
            especialidad.setNombre(rs.getString("nombre"));
            especialidad.setSubEspecialidad(rs.getInt("subEspecialidad"));
            especialidad.setEstatus(rs.getInt("estatus"));
            
            
            
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
            
            
            cstmt = conn.prepareCall("CALL mostrarEspecialidades()");
            ResultSet rs = cstmt.executeQuery();
            Especialidad especialidad;
            
            while(rs.next()){
                
                especialidad = new Especialidad();
                
                especialidad.setIdEspecialidad(rs.getInt(1));
                especialidad.setNombre(rs.getString(2));
                especialidad.setSubEspecialidad(rs.getInt(3));
                especialidad.setEstatus(rs.getInt(4));
                
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

    @Override
    public Especialidad mostrarEspecialidadPorNombre(String especialidad) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        Especialidad especialiadInterna = null;

        //Call del store procedure
        String stProcedure = "CALL mostrarEspecialidadPorNombre(?)";

        try {
            especialiadInterna = new Especialidad();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setString(1, especialidad);

            rs = cstmt.executeQuery();

            rs.next();
            especialiadInterna.setIdEspecialidad(rs.getInt(1));
            especialiadInterna.setNombre(rs.getString(2));
            especialiadInterna.setSubEspecialidad(rs.getInt(3));
            especialiadInterna.setEstatus(rs.getInt(4));

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println("PersonaServicioImpl mostrarPersona");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));            
        }
        return especialiadInterna;
    }
    
}
