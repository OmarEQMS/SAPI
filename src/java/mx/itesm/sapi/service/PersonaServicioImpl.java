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
import mx.itesm.sapi.bean.Persona;
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
        String stProcedure = "borradoLogicoPersona(?)";

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
        String stProcedure = "mostrarAuditoriaCreacionCuenta(?)";

        try {
            persona = new Persona();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPersona);

            rs = cstmt.executeQuery();

            rs.next();
            persona.setIdPersona(rs.getInt("idPersona"));
            persona.setPrimerApellido(rs.getString("apellido1"));
            persona.setSegundoApellido(rs.getString("apellido2"));
            persona.setCurp(rs.getString("curp"));
            persona.setTelefono(rs.getString("telefono"));
            persona.setCorreo(rs.getString("correo"));
            persona.setFechaNacimiento(rs.getTimestamp("fechaNacimiento"));
            persona.setIdSexo(rs.getInt("idSexo"));
            persona.setIdTipoSangre(rs.getInt("idTipoSangre"));
            persona.setIdMunicipio(rs.getInt("idMunicipio"));
            persona.setIdEstadoCivil(rs.getInt("idEstadoCivil"));
            persona.setIdDireccion(rs.getInt("idDireccion"));
            //  persona.setImagen(rs.getInputStream("imagen"));
            persona.setEdad(rs.getInt("edad"));
            persona.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            persona = null;
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
            cstmt = conn.prepareCall("mostrarListaPersona()");
            rs = cstmt.executeQuery();
            Persona persona;

            while (rs.next()) {

                persona = new Persona();
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setPrimerApellido(rs.getString("primerApellido"));
                persona.setSegundoApellido(rs.getString("segundoApellido"));
                persona.setCurp(rs.getString("curp"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setCorreo(rs.getString("correo"));
                persona.setFechaNacimiento(rs.getTimestamp("fechaNacimiento"));
                persona.setIdSexo(rs.getInt("idSexo"));
                persona.setIdTipoSangre(rs.getInt("idTipoSangre"));
                persona.setIdMunicipio(rs.getInt("idMunicipio"));
                persona.setIdEstadoCivil(rs.getInt("idEstadoCivil"));
                persona.setIdDireccion(rs.getInt("idDireccion"));
                persona.setImagen(rs.getBinaryStream("imagen"));
                persona.setEdad(rs.getInt("edad"));
                persona.setEstatus(rs.getInt("estatus"));

                personas.add(persona);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
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
        String stProcedure = "insertaPersona(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            //Aquí van los sets
            //cstmt.setInt(1,citaEmpleado.getIdCitaEmpleado());
            cstmt.setInt(1, persona.getIdPersona());
            cstmt.setString(2, persona.getPrimerApellido());
            cstmt.setString(3, persona.getSegundoApellido());
            cstmt.setString(4, persona.getCurp());
            cstmt.setString(5, persona.getTelefono());
            cstmt.setString(6, persona.getCorreo());
            cstmt.setTimestamp(7, persona.getFechaNacimiento());
            cstmt.setInt(8, persona.getIdSexo());
            cstmt.setInt(9, persona.getIdTipoSangre());
            cstmt.setInt(10, persona.getIdMunicipio());
            cstmt.setInt(11, persona.getIdEstadoCivil());
            cstmt.setInt(12, persona.getIdDireccion());
             cstmt.setBinaryStream(13,persona.getImagen());
            cstmt.setInt(14, persona.getEdad());
            cstmt.setInt(15, persona.getEstatus());

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
        String stProcedure = "actualizarPersona(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, persona.getIdPersona());
            cstmt.setString(2, persona.getPrimerApellido());
            cstmt.setString(3, persona.getSegundoApellido());
            cstmt.setString(4, persona.getCurp());
            cstmt.setString(5, persona.getTelefono());
            cstmt.setString(6, persona.getCorreo());
            cstmt.setTimestamp(7, persona.getFechaNacimiento());
            cstmt.setInt(8, persona.getIdSexo());
            cstmt.setInt(9, persona.getIdTipoSangre());
            cstmt.setInt(10, persona.getIdMunicipio());
            cstmt.setInt(11, persona.getIdEstadoCivil());
            cstmt.setInt(12, persona.getIdDireccion());
            // cstmt.setInputStream(13,persona.getImagen());
            cstmt.setInt(14, persona.getEdad());
            cstmt.setInt(15, persona.getEstatus());

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
