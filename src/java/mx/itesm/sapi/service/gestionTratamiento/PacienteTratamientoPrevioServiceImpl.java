/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionTratamiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionTratamiento.PacienteTratamientoPrevio;
import mx.itesm.sapi.util.Conexion;
import mx.itesm.sapi.service.gestionTratamiento.PacienteTratamientoPrevioService;

/**
 *
 * @author Admin
 */
public class PacienteTratamientoPrevioServiceImpl implements PacienteTratamientoPrevioService {

    @Override
    public int agregarPacienteTratamientoPrevio(PacienteTratamientoPrevio pacienteTratamientoPrevio) {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        //Id para devolver
        int id = -1;

        //Aquí va el call del procedure
        String stProcedure = "CALL agregarPacienteTratamientoPrevio(?,?,?,?,?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            //Aquí van los sets
            cstmt.setInt(1, pacienteTratamientoPrevio.getIdPaciente());
            cstmt.setInt(2, pacienteTratamientoPrevio.getIdTipoTratamiento());
            cstmt.setTimestamp(3, pacienteTratamientoPrevio.getFecha());
            cstmt.setString(4, pacienteTratamientoPrevio.getComentarios());
            cstmt.setInt(5, pacienteTratamientoPrevio.getEstatus());

            cstmt.executeUpdate();

            rs = cstmt.getGeneratedKeys();
            rs.next();

            id = cstmt.getInt(1);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            id = -1;
            System.out.println("IdPaciente: " + pacienteTratamientoPrevio.getIdPaciente());
            System.out.println("IdTipoTratamiento: " + pacienteTratamientoPrevio.getIdTipoTratamiento());
            System.out.println("Fecha: " + pacienteTratamientoPrevio.getFecha());
            System.out.println("Comentarios: " + pacienteTratamientoPrevio.getComentarios());
            System.out.println("Estatus: " + pacienteTratamientoPrevio.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return id;
    }

    @Override
    public PacienteTratamientoPrevio mostrarPacienteTratamientoPrevio(int idPacienteTratamientoPrevio) {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        PacienteTratamientoPrevio pacienteTratamientoPrevio = null;

        //Call del stored procedure
        String stProcedure = "CALL mostrarPacienteTratamientoPrevio(?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            pacienteTratamientoPrevio = new PacienteTratamientoPrevio();

            cstmt.setInt(1, idPacienteTratamientoPrevio);
            rs = cstmt.executeQuery();

            rs.next();
            pacienteTratamientoPrevio.setIdPacienteTratamientoPrevio(rs.getInt(1));
            pacienteTratamientoPrevio.setIdPaciente(rs.getInt(2));
            pacienteTratamientoPrevio.setIdTipoTratamiento(rs.getInt(3));
            pacienteTratamientoPrevio.setFecha(rs.getTimestamp(4));
            pacienteTratamientoPrevio.setComentarios(rs.getString(5));
            pacienteTratamientoPrevio.setEstatus(rs.getInt(6));

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            pacienteTratamientoPrevio = null;
            System.out.println("ID: " + idPacienteTratamientoPrevio);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return pacienteTratamientoPrevio;
    }

    @Override
    public List<PacienteTratamientoPrevio> mostrarPacienteTratamientoPrevio() {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        List<PacienteTratamientoPrevio> pacientesTratamientoPrevio = null;

        //Call del stored procedure
        String stProcedure = "CALL mostarListaPacienteTratamientoPrevio()";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            pacientesTratamientoPrevio = new ArrayList<>();

            rs = cstmt.executeQuery();
            PacienteTratamientoPrevio pacienteTratamientoPrevio;

            while (rs.next()) {
                pacienteTratamientoPrevio = new PacienteTratamientoPrevio();
                pacienteTratamientoPrevio.setIdPacienteTratamientoPrevio(rs.getInt(1));
                pacienteTratamientoPrevio.setIdPaciente(rs.getInt(2));
                pacienteTratamientoPrevio.setIdTipoTratamiento(rs.getInt(3));
                pacienteTratamientoPrevio.setFecha(rs.getTimestamp(4));
                pacienteTratamientoPrevio.setComentarios(rs.getString(5));
                pacienteTratamientoPrevio.setEstatus(rs.getInt(6));

                pacientesTratamientoPrevio.add(pacienteTratamientoPrevio);
            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            pacientesTratamientoPrevio = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return pacientesTratamientoPrevio;
    }

    @Override
    public boolean actualizarPacienteTratamientoPrevio(PacienteTratamientoPrevio pacienteTratamientoPrevio) {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        boolean exito = false;

        //Call del store procedure
        String stProcedure = "CALL actualizarPacienteTratamientoPrevio(?,?,?,?,?,?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, pacienteTratamientoPrevio.getIdPacienteTratamientoPrevio());
            cstmt.setInt(2, pacienteTratamientoPrevio.getIdPaciente());
            cstmt.setInt(3, pacienteTratamientoPrevio.getIdTipoTratamiento());
            cstmt.setTimestamp(4, pacienteTratamientoPrevio.getFecha());
            cstmt.setString(5, pacienteTratamientoPrevio.getComentarios());
            cstmt.setInt(6, pacienteTratamientoPrevio.getEstatus());

            rs = cstmt.executeQuery();

            rs.next();

            exito = rs.getBoolean(1);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            exito = false;
            System.out.println("IdPacienteTratamientoPrevio: " + pacienteTratamientoPrevio.getIdPacienteTratamientoPrevio());
            System.out.println("IdPaciente: " + pacienteTratamientoPrevio.getIdPaciente());
            System.out.println("IdTipoTratamiento: " + pacienteTratamientoPrevio.getIdTipoTratamiento());
            System.out.println("Fecha: " + pacienteTratamientoPrevio.getFecha());
            System.out.println("Comentarios: " + pacienteTratamientoPrevio.getComentarios());
            System.out.println("Estatus: " + pacienteTratamientoPrevio.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }

    @Override
    public boolean borradoLogicoPacienteTratamientoPrevio(int idPacienteTratamientoPrevio) {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        boolean exito = false;

        //Call del store procedure
        String stProcedure = "CALL borradoLogicoPacienteTratamientoPrevio(?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idPacienteTratamientoPrevio);

            rs = cstmt.executeQuery();

            rs.next();

            exito = rs.getBoolean(1);

        } catch (SQLException ex) {
            exito = false;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }

    @Override
    public PacienteTratamientoPrevio mostrarPacienteTratamientoPrevioIdPaciente(int idPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        PacienteTratamientoPrevio pacienteTratamientoPrevio = null;

        //Call del stored procedure
        String stProcedure = "CALL mostrarPacienteTratamientoPrevioIdPaciente(?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            pacienteTratamientoPrevio = new PacienteTratamientoPrevio();

            cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();

            rs.next();
            pacienteTratamientoPrevio.setIdPacienteTratamientoPrevio(rs.getInt(1));
            pacienteTratamientoPrevio.setIdPaciente(rs.getInt(2));
            pacienteTratamientoPrevio.setIdTipoTratamiento(rs.getInt(3));
            pacienteTratamientoPrevio.setFecha(rs.getTimestamp(4));
            pacienteTratamientoPrevio.setComentarios(rs.getString(5));
            pacienteTratamientoPrevio.setEstatus(rs.getInt(6));

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            pacienteTratamientoPrevio = null;

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return pacienteTratamientoPrevio;
    }

    @Override
    public List<PacienteTratamientoPrevio> mostrarPacienteTratamientoPrevioIdEspecifico(int idPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        List<PacienteTratamientoPrevio> pacientesTratamientoPrevio = null;

        //Call del stored procedure
        String stProcedure = "CALL mostrarPacienteTratamientoPrevioIdEspecifico(?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            pacientesTratamientoPrevio = new ArrayList<>();
            cstmt.setInt(1, idPaciente);

            rs = cstmt.executeQuery();
            PacienteTratamientoPrevio pacienteTratamientoPrevio;

            while (rs.next()) {
                pacienteTratamientoPrevio = new PacienteTratamientoPrevio();
                pacienteTratamientoPrevio.setIdPacienteTratamientoPrevio(rs.getInt(1));
                pacienteTratamientoPrevio.setIdPaciente(rs.getInt(2));
                pacienteTratamientoPrevio.setIdTipoTratamiento(rs.getInt(3));
                pacienteTratamientoPrevio.setFecha(rs.getTimestamp(4));
                pacienteTratamientoPrevio.setComentarios(rs.getString(5));
                pacienteTratamientoPrevio.setEstatus(rs.getInt(6));

                pacientesTratamientoPrevio.add(pacienteTratamientoPrevio);
            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            pacientesTratamientoPrevio = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return pacientesTratamientoPrevio;
    }
}
