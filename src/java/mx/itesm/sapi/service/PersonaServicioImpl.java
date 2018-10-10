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
import java.sql.Types;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.UIManager.getInt;
import mx.itesm.sapi.bean.persona.Persona;
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
       
       CallableStatement cstmt;
      /* String sql="INSERT INTO persona (idPersona, nombre, primerApellido, segundoApellido, curp, telefono, correo, ".concat(
                "fechaNaciemiento, idMunicipio,idEstadoCivil,idRol, edad) ")
                  .concat(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");*/
        
       //System.out.println(sql); 
       
           
           //PreparedStatement ps;
           int id = 0;
           
        try {
            
            cstmt = conn.prepareCall("CALL insertaPersona(?,?,?,?,?,?,?,?,?,?,?,?)");
            
            
           
            cstmt.setString(1, persona.getNombre());
            cstmt.setString(2, persona.getApellido1());
            cstmt.setString(3, persona.getApellido2());
            cstmt.setString(4, persona.getCurp());
            cstmt.setString(5, persona.getTelefono());
            cstmt.setString(6, persona.getCorreo());
            cstmt.setString(7, persona.getFechaNacimiento().toString());
            cstmt.setInt(8,persona.getIdMunicipio());
            cstmt.setInt(9, persona.getIdEstadoCivil());
            
            cstmt.setInt(11,persona.getEdad());
            cstmt.registerOutParameter(12,Types.INTEGER);
            
            cstmt.executeUpdate();
            
            ResultSet rs = cstmt.getGeneratedKeys();
            
            rs.next();
            id=rs.getInt(1);
            cstmt.close();
            //conn.close();
            
            System.out.println(id);
            
            return id;
           
            
        } catch (SQLException ex) {
            System.out.println("Estoy en el catch de PersonaServicio");
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
