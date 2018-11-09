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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.itesm.sapi.bean.persona.InformacionGeneralPersona;
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
                persona.setNombre(rs.getString("nombre"));
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
        String stProcedure = "CALL agregarPersona(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            /*IN in_nombre VARCHAR (255), IN in_estatus TINYINT, IN in_primerApellido VARCHAR (127), IN in_segundoApellido VARCHAR (127),
    IN in_curp VARCHAR (18), IN in_telefono VARCHAR (15), IN in_correo VARCHAR (127),IN in_fechaNacimiento DATE,
    IN in_idSexo INT, IN in_idTipoSangre INT, IN in_idMunicipio INT, IN in_idEstadoCivil INT, IN in_idDireccion INT,
    IN in_imagen MEDIUMBLOB, IN in_edad INT*/
            //Aquí van los sets
            //cstmt.setInt(1,citaEmpleado.getIdCitaEmpleado());

            cstmt.setString(1, persona.getNombre());
            cstmt.setString(2, persona.getPrimerApellido());
            cstmt.setString(3, persona.getSegundoApellido());
            cstmt.setString(4, persona.getCurp());
            cstmt.setString(5, persona.getTelefono());
            cstmt.setString(6, persona.getCorreo());

            cstmt.setDate(7, persona.getFechaNacimiento());
            cstmt.setInt(8, 1);
            cstmt.setInt(9, 1);
            cstmt.setInt(10, persona.getIdMunicipio());
            cstmt.setInt(11, persona.getIdEstadoCivil());
            cstmt.setInt(12, persona.getIdDireccion());

            cstmt.setInt(13, persona.getEdad());

            //Aquí va el registerOutParameter
            //cstmt.registerOutParameter(12,Types.INTEGER);
            rs = cstmt.executeQuery();
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

    @Override
    public boolean existsCurp(String curp) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        try {

            cstmt = conn.prepareCall("CALL existeCurp(?,?)");
            cstmt.setString(1, curp);
            cstmt.registerOutParameter(2, Types.BOOLEAN);

            cstmt.execute();
            System.out.println(cstmt.getBoolean(2));
            return cstmt.getBoolean(2);

        } catch (SQLException ex) {

            Logger.getLogger(CuentaServicioImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean actualizarSexoPersona(int idPersona, int idSexo) {
         Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        boolean exito;

        //Call del store procedure
        String stProcedure = "CALL actualizarSexo(?,?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPersona);
            cstmt.setInt(2, idSexo);
                        
            rs = cstmt.executeQuery();

            rs.next();

            exito = rs.getInt(1) == idSexo;

            System.out.println("Exito ".concat(String.valueOf(exito)));
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

    @Override
    public List<Persona> mostrarMedicos() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        List<Persona> personas = null;

        try {
            personas = new ArrayList<>();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL mostrarListaMedicos()");
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
                persona.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                persona.setIdSexo(rs.getInt("idSexo"));
                persona.setIdTipoSangre(rs.getInt("idTipoSangre"));
                persona.setIdMunicipio(rs.getInt("idMunicipio"));
                persona.setIdEstadoCivil(rs.getInt("idEstadoCivil"));
                persona.setIdDireccion(rs.getInt("idDireccion"));
                persona.setEdad(rs.getInt("edad"));
                persona.setEstatus(rs.getInt("estatus"));

                personas.add(persona);
                
                System.out.println("personaId: " + persona.getIdPersona());

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
    public Persona mostrarPersonaPorIdPaciente(int idPaciente) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        Persona persona = null;

        //Call del store procedure
        String stProcedure = "CALL mostrarPersonaPorIdPaciente(?)";

        try {
            persona = new Persona();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);

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
        } catch (Exception ex) {
            System.out.println("PersonaServicioImpl mostrarPersona");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }

        return persona;

    }
    
    @Override
    public InformacionGeneralPersona mostrarInformacionGeneralPersona(int idPaciente) {
        
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        InformacionGeneralPersona informacion = null;
        
        try {
            informacion = new InformacionGeneralPersona();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL mostrarInformacionGeneral(?)");
            cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();
            
            rs.next();
                
                informacion.setNombre(rs.getString("nombre"));
                informacion.setCurp(rs.getString("curp"));
                informacion.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                informacion.setPrimerApellido(rs.getString("primerApellido"));
                informacion.setSegundoApellido(rs.getString("segundoApellido"));
                informacion.setUsuario(rs.getString("usuario"));
                informacion.setIdEstadoCivil(rs.getInt("idEstadoCivil"));
                informacion.setColonia(rs.getString("colonia"));
                informacion.setCalle(rs.getString("calle"));
                informacion.setNoInt(rs.getString("noInterior"));
                informacion.setNoExt(rs.getString("noExterior"));
                informacion.setIdEstado(rs.getInt("idEstado"));
                informacion.setIdMunicipio(rs.getInt("idMunicipio"));
                informacion.setTelefono(rs.getString("telefono"));
                informacion.setCorreo(rs.getString("correo"));

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            
            System.out.println("PersonaServicioImpl mostrarInformacionGeneral");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            informacion = null;
        }

        return informacion;        
    }
    
    @Override
    public boolean actualizarInformacionGeneralPersona(int idPaciente, InformacionGeneralPersona persona){
        
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        boolean exito = false;
        
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL actualizarInformacionGeneral(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            cstmt.setInt(1, idPaciente);
            cstmt.setString(2, persona.getNombre());
            cstmt.setString(3, persona.getPrimerApellido());
            cstmt.setString(4, persona.getSegundoApellido());
            cstmt.setString(5, persona.getCurp());
            cstmt.setDate(6, persona.getFechaNacimiento());
            cstmt.setString(7, persona.getUsuario());
            cstmt.setInt(8, persona.getIdEstadoCivil());
            cstmt.setString(9, persona.getCalle());
            cstmt.setString(10, persona.getNoInt());
            cstmt.setString(11, persona.getNoExt());
            cstmt.setInt(12, persona.getIdEstado());
            cstmt.setInt(13, persona.getIdMunicipio());
            cstmt.setString(14, persona.getTelefono());
            cstmt.setString(15, persona.getCorreo());
            cstmt.setString(16, persona.getColonia());
            
            rs = cstmt.executeQuery();
            
            rs.next();
                
            int idPacienteReg = rs.getInt("idPaciente");
            
            if(idPacienteReg == idPaciente)
                exito = true;

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            
            System.out.println("PersonaServicioImpl mostrarInformacionGeneral");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }

        return exito;        
    }
}
