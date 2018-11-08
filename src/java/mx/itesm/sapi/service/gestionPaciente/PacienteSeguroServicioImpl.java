/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.Connection;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.util.Conexion;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.PacienteSeguro;

/**
 *
 * @author Alexis España
 */
public class PacienteSeguroServicioImpl implements PacienteSeguroServicio {

    @Override
    public PacienteSeguro mostrarPacienteSeguro(int idPacienteSeguro) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        PacienteSeguro pacienteSeguro = new PacienteSeguro();

        String stProcedure = "CALL mostrarPacienteSeguro(?)";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPacienteSeguro);
            rs = cstmt.executeQuery();
            rs.next();

            pacienteSeguro.setIdPacienteSeguro(rs.getInt("idPacienteSeguro"));
            pacienteSeguro.setIdPaciente(rs.getInt("idPaciente"));
            pacienteSeguro.setIdSeguro(rs.getInt("idSeguro"));
            pacienteSeguro.setNoSeguro(rs.getString("noSeguro"));
            pacienteSeguro.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacienteSeguro = null;
        }
        return pacienteSeguro;
    }

    @Override
    public List<PacienteSeguro> mostrarPacienteSeguro() {
        Connection conn;
        CallableStatement cstmt;
        List<PacienteSeguro> listPacienteSeguro = null;
        String stProcedure = "CALL mostrarPacienteSeguro()";
        PacienteSeguro pacienteSeguro;

        ResultSet rs;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            listPacienteSeguro = new ArrayList<>();

            while (rs.next()) {
                pacienteSeguro = new PacienteSeguro();
                pacienteSeguro.setIdPacienteSeguro(rs.getInt("idPacienteSeguro"));
                pacienteSeguro.setIdPaciente(rs.getInt("idPaciente"));
                pacienteSeguro.setIdSeguro(rs.getInt("idSeguro"));
                pacienteSeguro.setNoSeguro(rs.getString("noSeguro"));
                pacienteSeguro.setEstatus(rs.getInt("estatus"));

                listPacienteSeguro.add(pacienteSeguro);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listPacienteSeguro = null;
        }
        return listPacienteSeguro;
    }

    @Override
    public int agregarPacienteSeguro(PacienteSeguro pacienteSeguro) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        String stPrcedure = "CALL agregarPacienteSeguro(?,?,?)";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);

            cstmt.setInt(1, pacienteSeguro.getIdPacienteSeguro());
            cstmt.setInt(2, pacienteSeguro.getIdPaciente());
            cstmt.setInt(3, pacienteSeguro.getIdSeguro());
            cstmt.setString(4, pacienteSeguro.getNoSeguro());
            cstmt.setInt(5, pacienteSeguro.getEstatus());
            

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
    public boolean actualizarPacienteSeguro(PacienteSeguro pacienteSeguro) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "CALL actualizarPacienteSeguro(?,?,?)";
        boolean exito = false;
        ResultSet rs;
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, pacienteSeguro.getIdPacienteSeguro());
            cstmt.setInt(2, pacienteSeguro.getIdPaciente());
            cstmt.setInt(3, pacienteSeguro.getIdSeguro());
            cstmt.setString(4, pacienteSeguro.getNoSeguro());
            cstmt.setInt(5, pacienteSeguro.getEstatus());

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
    public boolean borradoLogicoPacienteSeguro(int idPacienteSeguro) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "CALL borradoLogicoPacienteSeguro(?)";
        boolean exito = false;
        ResultSet rs;
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPacienteSeguro);

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
    public PacienteSeguro mostrarPacienteSeguroIdPaciente(int idPaciente) {
    Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        PacienteSeguro pacienteSeguro = new PacienteSeguro();

        String stProcedure = "CALL mostrarPacienteSeguroIdPaciente(?)";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();
            rs.next();

            pacienteSeguro.setIdPacienteSeguro(rs.getInt("idPacienteSeguro"));
            pacienteSeguro.setIdPaciente(rs.getInt("idPaciente"));
            pacienteSeguro.setIdSeguro(rs.getInt("idSeguro"));
            pacienteSeguro.setNoSeguro(rs.getString("noSeguro"));
            pacienteSeguro.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacienteSeguro = null;
        }
        return pacienteSeguro;
    }

    @Override
    public List<PacienteSeguro> mostrarPacienteSeguroIdEspecifico(int idPaciente) {
     Connection conn;
        CallableStatement cstmt;
        List<PacienteSeguro> listPacienteSeguro = null;
        String stProcedure = "CALL mostrarPacienteSeguro()";
        PacienteSeguro pacienteSeguro;

        ResultSet rs;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
             cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();
            listPacienteSeguro = new ArrayList<>();

            while (rs.next()) {
                pacienteSeguro = new PacienteSeguro();
                pacienteSeguro.setIdPacienteSeguro(rs.getInt("idPacienteSeguro"));
                pacienteSeguro.setIdPaciente(rs.getInt("idPaciente"));
                pacienteSeguro.setIdSeguro(rs.getInt("idSeguro"));
                pacienteSeguro.setNoSeguro(rs.getString("noSeguro"));
                pacienteSeguro.setEstatus(rs.getInt("estatus"));

                listPacienteSeguro.add(pacienteSeguro);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listPacienteSeguro = null;
        }
        return listPacienteSeguro;}

}
