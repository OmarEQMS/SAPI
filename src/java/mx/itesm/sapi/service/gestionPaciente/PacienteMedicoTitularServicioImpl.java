/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.PacienteMedicoTitular;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel Guitierrez
 */
public class PacienteMedicoTitularServicioImpl implements PacienteMedicoTitularServicio {

    @Override
    public PacienteMedicoTitular mostrarPacienteMedicoTitular(int idPacienteMedicoTitular) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        PacienteMedicoTitular pacienteMedicoTitular = null;

        //Call del store procedure
        String stProcedure = "mostrarPacienteMedicoTitular(?)";

        try {
            pacienteMedicoTitular = new PacienteMedicoTitular();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPacienteMedicoTitular);

            rs = cstmt.executeQuery();

            rs.next();

            pacienteMedicoTitular.setIdPacienteMedicoTitular(rs.getInt("idPacienteMedicoTitular"));
            pacienteMedicoTitular.setIdPaciente(rs.getInt("idPaciente"));
            pacienteMedicoTitular.setIdEmpleado(rs.getInt("idEmpleado"));
            pacienteMedicoTitular.setInicio(rs.getDate("inicio"));
            pacienteMedicoTitular.setFin(rs.getDate("fin"));
            pacienteMedicoTitular.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacienteMedicoTitular = null;
        }
        return pacienteMedicoTitular;

    }

    @Override
    public List<PacienteMedicoTitular> mostrarPacienteMedicoTitular() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        List<PacienteMedicoTitular> pacienteMedicoTitulars = null;

        try {
            pacienteMedicoTitulars = new ArrayList<>();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("mostrarListapacienteMedicoTitular()");
            rs = cstmt.executeQuery();
            PacienteMedicoTitular pacienteMedicoTitular;

            while (rs.next()) {

                pacienteMedicoTitular = new PacienteMedicoTitular();
                pacienteMedicoTitular.setIdPacienteMedicoTitular(rs.getInt("idPacienteMedicoTitular"));
                pacienteMedicoTitular.setIdPaciente(rs.getInt("idPaciente"));
                pacienteMedicoTitular.setIdEmpleado(rs.getInt("idEmpleado"));
                pacienteMedicoTitular.setInicio(rs.getDate("inicio"));
                pacienteMedicoTitular.setFin(rs.getDate("fin"));
                pacienteMedicoTitular.setEstatus(rs.getInt("estatus"));

                pacienteMedicoTitulars.add(pacienteMedicoTitular);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacienteMedicoTitulars = null;
        }

        return pacienteMedicoTitulars;
    }

    @Override
    public int agregarPacienteMedicoTitular(PacienteMedicoTitular pacienteMedicoTitular) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        int id = -1;
        //Aquí va el call del procedure
        String stProcedure = "CALL agregarPacienteMedicoTitular(?, ?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, pacienteMedicoTitular.getIdPaciente());
            cstmt.setInt(2, pacienteMedicoTitular.getIdEmpleado());
            cstmt.setDate(3, pacienteMedicoTitular.getInicio());
            cstmt.setDate(4, pacienteMedicoTitular.getFin());

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
    public boolean actualizarPacienteMedicoTitular(PacienteMedicoTitular pacienteMedicoTitular) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        boolean exito = false;

        //Call del store procedure
        String stProcedure = "actualizarpacienteMedicoTitular(?, ?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, pacienteMedicoTitular.getIdPacienteMedicoTitular());
            cstmt.setInt(2, pacienteMedicoTitular.getIdPaciente());
            cstmt.setInt(3, pacienteMedicoTitular.getIdEmpleado());
            cstmt.setDate(4, pacienteMedicoTitular.getInicio());
            cstmt.setDate(5, pacienteMedicoTitular.getFin());
            cstmt.setInt(6, pacienteMedicoTitular.getEstatus());

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
    public boolean borradoLogicoPacienteMedicoTitular(int idPacienteMedicoTitular) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL borradoLogicoCita(?)";
        boolean exito = false;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idPacienteMedicoTitular);

            rs = cstmt.executeQuery();
            rs.next();
            exito = rs.getBoolean(1);

            rs.close();
            conn.close();
            cstmt.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

    @Override
    public PacienteMedicoTitular mostrarPacienteMedicoTitularIdPaciente(int idPaciente) {
         Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        PacienteMedicoTitular pacienteMedicoTitular = null;

        //Call del store procedure
        String stProcedure = "CALL mostrarPacienteMedicoTitularIdPaciente(?)";

        try {
            pacienteMedicoTitular = new PacienteMedicoTitular();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);

            rs = cstmt.executeQuery();

            rs.next();

            pacienteMedicoTitular.setIdPacienteMedicoTitular(rs.getInt("idPacienteMedicoTitular"));
            pacienteMedicoTitular.setIdPaciente(rs.getInt("idPaciente"));
            pacienteMedicoTitular.setIdEmpleado(rs.getInt("idEmpleado"));
            pacienteMedicoTitular.setInicio(rs.getDate("inicio"));
            pacienteMedicoTitular.setFin(rs.getDate("fin"));
            pacienteMedicoTitular.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacienteMedicoTitular = null;
        }
        return pacienteMedicoTitular;
    }
    
    @Override
    public PacienteMedicoTitular mostrarPacienteMedicoTitularIdPacientePosicion(int idPaciente, int idPosicion) {
         Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        PacienteMedicoTitular pacienteMedicoTitular = null;

        //Call del store procedure
        String stProcedure = "CALL mostrarPacienteMedicoTitularIdPacientePosicion(?, ?)";

        try {
            pacienteMedicoTitular = new PacienteMedicoTitular();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);
            cstmt.setInt(2, idPosicion);

            rs = cstmt.executeQuery();

            rs.next();

            pacienteMedicoTitular.setIdPacienteMedicoTitular(rs.getInt("idPacienteMedicoTitular"));
            pacienteMedicoTitular.setIdPaciente(rs.getInt("idPaciente"));
            pacienteMedicoTitular.setIdEmpleado(rs.getInt("idEmpleado"));
            pacienteMedicoTitular.setInicio(rs.getDate("inicio"));
            pacienteMedicoTitular.setFin(rs.getDate("fin"));
            pacienteMedicoTitular.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacienteMedicoTitular = null;
        }
        return pacienteMedicoTitular;
    }
}
