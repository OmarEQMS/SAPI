/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mx.itesm.sapi.util.Conexion;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.ProgramaPaciente;

/**
 *
 * @author urieldiaz
 */
public class ProgramaPacienteServicioImpl implements ProgramaPacienteServicio {

    @Override
    public ProgramaPaciente mostrarProgramaPaciente(int idProgramaPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        ProgramaPaciente programaPaciente = new ProgramaPaciente();

        String stProcedure = "CALL mostrarProgramaPaciente(?)";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idProgramaPaciente);
            rs = cstmt.executeQuery();
            rs.next();

            programaPaciente.setIdProgramaPaciente(rs.getInt("idProgramaPaciente"));
            programaPaciente.setIdPrograma(rs.getInt("idPrograma"));
            programaPaciente.setIdPaciente(rs.getInt("idPaciente"));
            programaPaciente.setInicio(rs.getTimestamp("inicio"));
            programaPaciente.setFin(rs.getTimestamp("fin"));
            programaPaciente.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            programaPaciente = null;
        }
        return programaPaciente;
    }

    @Override
    public List<ProgramaPaciente> mostrarProgramaPaciente() {
        Connection conn;
        List<ProgramaPaciente> listProgramaPaciente = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure = "CALL mostrarProgramaPaciente()";

        ResultSet rs;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            rs = cstmt.executeQuery();
            ProgramaPaciente programaPaciente;

            while (rs.next()) {
                programaPaciente = new ProgramaPaciente();
                programaPaciente.setIdProgramaPaciente(rs.getInt("idProgramaPaciente"));
                programaPaciente.setIdPrograma(rs.getInt("idPrograma"));
                programaPaciente.setIdPaciente(rs.getInt("idPaciente"));
                programaPaciente.setInicio(rs.getTimestamp("inicio"));
                programaPaciente.setFin(rs.getTimestamp("fin"));
                programaPaciente.setEstatus(rs.getInt("estatus"));

                listProgramaPaciente.add(programaPaciente);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listProgramaPaciente = null;
        }
        return listProgramaPaciente;
    }

    @Override
    public int agregarProgramaPaciente(ProgramaPaciente programaPaciente) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        String stPrcedure = "CALL agregarProgramaPaciente(?, ?, ?, ?)";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);

            cstmt.setInt(1, programaPaciente.getIdPrograma());
            cstmt.setInt(2, programaPaciente.getIdPaciente());
            cstmt.setTimestamp(3, programaPaciente.getInicio());
            cstmt.setTimestamp(4, programaPaciente.getFin());

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
    public boolean borradoLogicoProgramaPaciente(int idProgramaAtencion) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "CALL borradoLogicoProgramaPaciente(?)";
        boolean exito = false;
        ResultSet rs;
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idProgramaAtencion);

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
    public boolean actualizarProgramaPaciente(ProgramaPaciente programaPaciente) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "CALL actualizarProgramaPaciente(?, ?, ?, ?)";
        boolean exito = false;
        ResultSet rs;
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, programaPaciente.getIdPrograma());
            cstmt.setInt(2, programaPaciente.getIdPaciente());
            cstmt.setTimestamp(3, programaPaciente.getInicio());
            cstmt.setTimestamp(4, programaPaciente.getFin());

            rs = cstmt.executeQuery();

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
    public ProgramaPaciente mostrarProgramaPacienteIdPaciente(int idPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        ProgramaPaciente programaPaciente = new ProgramaPaciente();

        String stProcedure = "CALL mostrarProgramaPacienteIdPaciente(?)";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);

            rs = cstmt.executeQuery();
            rs.next();

            programaPaciente.setIdProgramaPaciente(rs.getInt("idProgramaPaciente"));
            programaPaciente.setIdPrograma(rs.getInt("idPrograma"));
            programaPaciente.setIdPaciente(rs.getInt("idPaciente"));
            programaPaciente.setInicio(rs.getTimestamp("inicio"));
            programaPaciente.setFin(rs.getTimestamp("fin"));
            programaPaciente.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            programaPaciente = null;
        }
        return programaPaciente;
    }

    @Override
    public List<ProgramaPaciente> mostrarProgramaPacienteSeguroIdEspecifico(int idPaciente) {
        Connection conn;
        List<ProgramaPaciente> listProgramaPaciente = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure = "CALL mostrarProgramaPacienteIdPaciente(?)";

        ResultSet rs;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();
            ProgramaPaciente programaPaciente;

            while (rs.next()) {
                programaPaciente = new ProgramaPaciente();
                programaPaciente.setIdProgramaPaciente(rs.getInt("idProgramaPaciente"));
                programaPaciente.setIdPrograma(rs.getInt("idPrograma"));
                programaPaciente.setIdPaciente(rs.getInt("idPaciente"));
                programaPaciente.setInicio(rs.getTimestamp("inicio"));
                programaPaciente.setFin(rs.getTimestamp("fin"));
                programaPaciente.setEstatus(rs.getInt("estatus"));

                listProgramaPaciente.add(programaPaciente);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listProgramaPaciente = null;
        }
        return listProgramaPaciente;
    }
}
