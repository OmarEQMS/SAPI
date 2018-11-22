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
import mx.itesm.sapi.bean.gestionPaciente.ComentarioCita;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class ComentarioCitaServicioImpl implements ComentarioCitaServicio {

    @Override
    public ComentarioCita mostrarComentarioCita(int idComentarioCita) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarComentarioCita(?)";
        ComentarioCita comentarioCita = null;

        try {
            conn = Conexion.getConnection();
            comentarioCita = new ComentarioCita();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idComentarioCita);

            rs = cstmt.executeQuery();
            rs.next();
            comentarioCita.setIdComentarioCita(rs.getInt("idComentarioCita"));
            comentarioCita.setComentarioIncidencia(rs.getString("comentarioIncidencia"));
            comentarioCita.setIdCita(rs.getInt("idCita"));
            comentarioCita.setNavegadora(rs.getInt("navegadora"));
            comentarioCita.setEstatus(rs.getInt("estatus"));
            comentarioCita.setComentarioMedico("comentarioMedico");

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            comentarioCita = null;
        }
        return comentarioCita;
    }
    
    @Override
    public ComentarioCita mostrarComentarioCitaIdCita(int idComentarioCita) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarComentarioCitaIdCita(?)";
        ComentarioCita comentarioCita = null;

        try {
            conn = Conexion.getConnection();
            comentarioCita = new ComentarioCita();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idComentarioCita);

            rs = cstmt.executeQuery();
            rs.next();
            comentarioCita.setIdComentarioCita(rs.getInt("idComentarioCita"));
            comentarioCita.setComentarioIncidencia(rs.getString("comentarioIncidencia"));
            comentarioCita.setIdCita(rs.getInt("idCita"));
            comentarioCita.setNavegadora(rs.getInt("navegadora"));
            comentarioCita.setEstatus(rs.getInt("estatus"));
            comentarioCita.setComentarioMedico("comentarioMedico");
            

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            comentarioCita = null;
        }
        return comentarioCita;
    }

    @Override
    public List<ComentarioCita> mostrarComentarioCita() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarListaComentarioCita()";
        List<ComentarioCita> comentarioCitas = null;
        ComentarioCita comentarioCita;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            comentarioCitas = new ArrayList<>();

            while (rs.next()) {
                comentarioCita = new ComentarioCita();

                comentarioCita.setIdComentarioCita(rs.getInt("idComentarioCita"));
                comentarioCita.setComentarioIncidencia(rs.getString("comentarioIncidencia"));
                comentarioCita.setIdCita(rs.getInt("idCita"));
                comentarioCita.setNavegadora(rs.getInt("navegadora"));
                comentarioCita.setEstatus(rs.getInt("estatus"));
                comentarioCita.setComentarioMedico("comentarioMedico");

                comentarioCitas.add(comentarioCita);
            }

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            comentarioCitas = null;
        }
        return comentarioCitas;
    }

    @Override
    public int agregarComentarioCita(ComentarioCita comentarioCita) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL agregarComentarioCita(?,?,?,?)";
        int id = -1;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setString(1, comentarioCita.getComentarioIncidencia());
            cstmt.setInt(2, comentarioCita.getIdCita());
            cstmt.setInt(3, comentarioCita.getNavegadora());
            cstmt.setString(4, comentarioCita.getComentarioMedico());

            rs = cstmt.executeQuery();
            rs.next();

            id = rs.getInt(1);

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
        }
        return id;
    }

    @Override
    public boolean borradoLogicoComentarioCita(int idComentarioCita) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL borradoLogicoComentarioCita(?)";
        boolean exito = false;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idComentarioCita);

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
    public boolean actualizarComentarioCita(ComentarioCita comentarioCita) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL actualizarComentarioCita(?,?,?, ?,?)";
        boolean exito = false;
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

           cstmt.setInt(1, comentarioCita.getIdComentarioCita());

           cstmt.setString(2, comentarioCita.getComentarioIncidencia());
            cstmt.setInt(3, comentarioCita.getIdCita());
            cstmt.setInt(4, comentarioCita.getNavegadora());
            cstmt.setString(5, comentarioCita.getComentarioMedico());

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

    

}
