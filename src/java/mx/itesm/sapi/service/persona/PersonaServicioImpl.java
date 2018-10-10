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
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class PersonaServicioImpl implements PersonaServicio {

   

    @Override
    public boolean borradoLogicoPersona(int idPersona) {
          Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        //Call del store procedure
        String stProcedure="borradoLogicoPersona";
        
        
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,idPersona);
            
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            
           return rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            System.out.println("Estoy en el catch de Persona BL");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Persona mostrarPersona(int idPersona) {
       Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        Persona persona = new Persona();
        
        //Call del store procedure
        String stProcedure="mostrarAuditoriaCreacionCuenta";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPersona);
            
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            persona.setIdPersona(rs.getInt("idPersona"));
            persona.setApellido1(rs.getString("apellido1"));            
            persona.setApellido2(rs.getString("apellido2"));
            persona.setCurp(rs.getString("curp"));
            persona.setTelefono(rs.getString("telefono"));            
            persona.setCorreo(rs.getString("correo"));
            persona.setFechaNacimiento(rs.getDate("fechaNacimiento"));
            persona.setIdSexo(rs.getInt("idSexo"));
            persona.setIdTipoSangre(rs.getInt("idTipoSangre"));
            persona.setIdMunicipio(rs.getInt("idMunicipio"));
            persona.setIdEstadoCivil(rs.getInt("idEstadoCivil"));
            persona.setIdDireccion(rs.getInt("idDireccion"));
          //  persona.setImagen(rs.getInputStream("imagen"));
            persona.setEdad(rs.getInt("edad"));
            persona.setEstatus(rs.getInt("estatus"));
            
            
           
            return persona;
        }catch(SQLException ex){
            
            System.out.println("Estoy en el catch de auditoriaCreacionCuenta");
            System.out.println(ex.getMessage());
            return persona;
        }
    }

    @Override
    public List<Persona> mostrarPersona() {
         Connection conn = Conexion.getConnection();
        
        
        List<Persona> personas = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL getPersona()");
            ResultSet rs = cstmt.executeQuery();
            Persona persona;
            
            while(rs.next()){
                
                persona = new Persona();
            persona.setIdPersona(rs.getInt(1));
            persona.setApellido1(rs.getString(2));            
            persona.setApellido2(rs.getString(3));
            persona.setCurp(rs.getString(4));
            persona.setTelefono(rs.getString(5));            
            persona.setCorreo(rs.getString(6));
            persona.setFechaNacimiento(rs.getDate(7));
            persona.setIdSexo(rs.getInt(8));
            persona.setIdTipoSangre(rs.getInt(9));
            persona.setIdMunicipio(rs.getInt(10));
            persona.setIdEstadoCivil(rs.getInt(11));
            persona.setIdDireccion(rs.getInt(12));
          //  persona.setImagen(rs.getInputStream(13));
            persona.setEdad(rs.getInt(14));
            persona.setEstatus(rs.getInt(15));
                
           
                
                personas.add(persona);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(SQLException ex){
            System.out.println("ERROR GET AuditoriaCreacionCuenta" + ex.getMessage());
        }
        
        return personas;
    
    }

    @Override
    public int agregarPersona(Persona persona) {
       Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        int id=0;
        //Aquí va el call del procedure
        String stProcedure="agregarPersona";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            //Aquí van los sets
            //cstmt.setInt(1,citaEmpleado.getIdCitaEmpleado());
    
            
            cstmt.setInt(1,persona.getIdPersona());
            cstmt.setString(2,persona.getApellido1());
            cstmt.setString(3,persona.getApellido2());
            cstmt.setString(4,persona.getCurp());
            cstmt.setString(5,persona.getTelefono());            
            cstmt.setString(6,persona.getCorreo());
            cstmt.setDate(7,persona.getFechaNacimiento());
            cstmt.setInt(8,persona.getIdSexo());
            cstmt.setInt(9,persona.getIdTipoSangre());
            cstmt.setInt(10,persona.getIdMunicipio());
            cstmt.setInt(11,persona.getIdEstadoCivil());
            cstmt.setInt(12,persona.getIdDireccion());
           // cstmt.setInputStream(13,persona.getImagen());
            cstmt.setInt(14,persona.getEdad());
            cstmt.setInt(15,persona.getEstatus());
            
            //Aquí va el registerOutParameter
            //cstmt.registerOutParameter(12,Types.INTEGER);
            
            cstmt.executeUpdate();
            
            ResultSet rs = cstmt.getGeneratedKeys();
            
            rs.next();
            
           id=rs.getInt(1);
           
           cstmt.close();
            
        }catch(SQLException ex){
            
             System.out.println("Estoy en el catch de agregar persona ");
            System.out.println(ex.getMessage());
            
        }
        
        
        return id;
    }

    @Override
    public boolean actualizarPersona(Persona persona) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        //Call del store procedure
        String stProcedure="actualizarPersona";
        
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1,persona.getIdPersona());
            cstmt.setString(2,persona.getApellido1());
            cstmt.setString(3,persona.getApellido2());
            cstmt.setString(4,persona.getCurp());
            cstmt.setString(5,persona.getTelefono());            
            cstmt.setString(6,persona.getCorreo());
            cstmt.setDate(7,persona.getFechaNacimiento());
            cstmt.setInt(8,persona.getIdSexo());
            cstmt.setInt(9,persona.getIdTipoSangre());
            cstmt.setInt(10,persona.getIdMunicipio());
            cstmt.setInt(11,persona.getIdEstadoCivil());
            cstmt.setInt(12,persona.getIdDireccion());
           // cstmt.setInputStream(13,persona.getImagen());
            cstmt.setInt(14,persona.getEdad());
            cstmt.setInt(15,persona.getEstatus());          
            
            
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            
           return rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            System.out.println("Estoy en el catch de actualizarPersona ");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    
    
}
