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
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        boolean exito = false;

        //Call del store procedure
        String stProcedure = "CALL borradoLogicoPersona(?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idPersona);

            rs = cstmt.executeQuery();

            rs.next();

            exito = rs.getBoolean(1);
            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

    @Override
    public Persona mostrarPersona(int idPersona) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        Persona persona = null;

        //Call del store procedure
        String stProcedure = "CALL mostrarPersona(?)";

        try {
            persona = new Persona();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPersona);

            rs = cstmt.executeQuery();

            rs.next();
            persona.setNombre(rs.getString("nombre"));
            persona.setIdPersona(rs.getInt("idPersona"));
            persona.setPrimerApellido(rs.getString("primerApellido"));
            persona.setSegundoApellido(rs.getString("segundoApellido"));
            persona.setCurp(rs.getString("curp"));
            persona.setTelefono(rs.getString("telefono"));
            persona.setCorreo(rs.getString("correo"));
            persona.setFechaNacimiento(rs.getDate("fechaNacimiento"));
            persona.setIdSexo(rs.getInt("idSexo"));
            persona.setIdTipoSangre(rs.getInt("idTipoSangre"));
            persona.setIdMunicipio(rs.getInt("idMunicipio"));
            persona.setIdEstadoCivil(rs.getInt("idEstadoCivil"));
            persona.setIdDireccion(rs.getInt("idDireccion"));
            persona.setEdad(rs.getInt("edad"));
            persona.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println("PersonaServicioImpl mostrarPersona");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));            
        }
        return persona;
    }

    @Override
    public List<Persona> mostrarPersona() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        List<Persona> personas = null;

        try {
            personas = new ArrayList<>();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL mostrarListaPersona()");
            rs = cstmt.executeQuery();
            Persona persona;

            while (rs.next()) {

                persona = new Persona();
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setPrimerApellido(rs.getString("primerApellido"));
                persona.setSegundoApellido(rs.getString("segundpApellido"));
                persona.setCurp(rs.getString("curp"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setCorreo(rs.getString("correo"));
                persona.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                persona.setIdSexo(rs.getInt("idSexo"));
                persona.setIdTipoSangre(rs.getInt("idTipoSangre"));
                persona.setIdMunicipio(rs.getInt("idMunicipio"));
                persona.setIdEstadoCivil(rs.getInt("idEstadoCivil"));
                persona.setIdDireccion(rs.getInt("idDireccion"));
                persona.setEdad(rs.getInt("edad"));
                persona.setEstatus(rs.getInt("estatus"));

                personas.add(persona);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            
            System.out.println("PersonaServicioImpl mostrarPersona Lista");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            personas = null;
        }

        return personas;

    }

    @Override
    public int agregarPersona(Persona persona) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        int id = -1;
        //Aquí va el call del procedure
        String stProcedure = "CALL agregarPersona(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            //Aquí van los sets
            //cstmt.setInt(1,citaEmpleado.getIdCitaEmpleado());
            cstmt.setString(1, persona.getPrimerApellido());
            cstmt.setString(2, persona.getSegundoApellido());
            cstmt.setString(3, persona.getCurp());
            cstmt.setString(4, persona.getTelefono());
            cstmt.setString(5, persona.getCorreo());
            cstmt.setDate(6, persona.getFechaNacimiento());
            cstmt.setInt(7, persona.getIdSexo());
            cstmt.setInt(8, persona.getIdTipoSangre());
            cstmt.setInt(9, persona.getIdMunicipio());
            cstmt.setInt(10, persona.getIdEstadoCivil());
            cstmt.setInt(11, persona.getIdDireccion());
            cstmt.setInt(12, persona.getEdad());

            //Aquí va el registerOutParameter
            //cstmt.registerOutParameter(12,Types.INTEGER);
            cstmt.executeUpdate();

            rs = cstmt.getGeneratedKeys();

            rs.next();

            id = rs.getInt(1);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("PersonaServicioImpl Lista mostrarPersona");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;

        }

        return id;
    }

    @Override
    public boolean actualizarPersona(Persona persona) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        boolean exito = false;

        //Call del store procedure
        String stProcedure = "CALL actualizarPersona(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, persona.getIdPersona());
            cstmt.setString(2, persona.getNombre());
            
            cstmt.setString(3, persona.getPrimerApellido());
            cstmt.setString(4, persona.getSegundoApellido());
            cstmt.setString(5, persona.getCurp());
            cstmt.setString(6, persona.getTelefono());
            cstmt.setString(7, persona.getCorreo());
            cstmt.setDate(8, persona.getFechaNacimiento());
            cstmt.setInt(9, persona.getIdSexo());
            cstmt.setInt(10, persona.getIdTipoSangre());
            cstmt.setInt(11, persona.getIdMunicipio());
            cstmt.setInt(12, persona.getIdEstadoCivil());
            cstmt.setInt(13, persona.getIdDireccion());
            cstmt.setInt(14, persona.getEdad());


            rs = cstmt.executeQuery();

            rs.next();

            exito = rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

}
