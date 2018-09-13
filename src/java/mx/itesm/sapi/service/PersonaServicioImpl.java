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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.UIManager.getInt;
import mx.itesm.sapi.bean.Persona;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author feror
 */
public class PersonaServicioImpl implements PersonaServicio {

    @Override
    public Persona getPersona(int idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Persona> getPersonas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int savePersona(Persona persona) {
        
       Connection conn = Conexion.getConnection();
       
       
       String sql="INSERT INTO persona (idPersona, nombre, primerApellido, segundoApellido, curp, telefono, correo, ".concat(
                "fechaNaciemiento, idMunicipio,idEstadoCivil,idRol, edad) ")
                  .concat(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
        
       System.out.println(sql); 
       
           
           PreparedStatement ps;
           int id = 0;
           
        try {
            
            
            
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, null);
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApellido1());
            ps.setString(4, persona.getApellido2());
            ps.setString(5, persona.getCurp());
            ps.setString(6, persona.getTelefono());
            ps.setString(7, persona.getCorreo());
            ps.setString(8, persona.getFechaNacimiento());
            ps.setInt(9,persona.getIdMunicipio());
            ps.setInt(10, persona.getIdEstadoCivil());
            ps.setInt(11, persona.getIdRol());
            ps.setInt(12,persona.getEdad());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            rs.next();
            id=rs.getInt(1);
            ps.close();
            //conn.close();
            
            System.out.println(id);
            
            return id;
           
            
        } catch (SQLException ex) {
          
            System.out.println(ex.getMessage());
            return 0;
        }
          
    }

    @Override
    public boolean deletePersona(int idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updatePersona(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
