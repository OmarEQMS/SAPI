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
import mx.itesm.sapi.util.Conexion;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.OtroEstudio;

/**
 *
 * @author Alex
 */
public class OtroEstudioServicioImpl implements OtroEstudioServicio {

    @Override
    public OtroEstudio mostrarOtroEstudio(int idOtroEstudio) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        OtroEstudio otroEstudio = new OtroEstudio();

        String stProcedure = "CALL mostrarOtroEstudio(?)";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idOtroEstudio);
            rs = cstmt.executeQuery();
            rs.next();

            otroEstudio.setIdOtroEstudio(rs.getInt("idOtroEstudio"));
            otroEstudio.setIdEstudio(rs.getInt("idEstudio"));
            otroEstudio.setNombre(rs.getString("nombre"));
            otroEstudio.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            otroEstudio = null;
        }
        return otroEstudio;
    }

    @Override
    public List<OtroEstudio> mostrarOtroEstudio() {
        Connection conn;
        List<OtroEstudio> pacientes = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure = "CALL mostrarListaOtroEstudio()";

        ResultSet rs;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            OtroEstudio otroEstudio;

            while (rs.next()) {
                otroEstudio = new OtroEstudio();
                otroEstudio.setIdOtroEstudio(rs.getInt("idOtroEstudio"));
                otroEstudio.setIdEstudio(rs.getInt("idEstudio"));
                otroEstudio.setNombre(rs.getString("nombre"));
                otroEstudio.setEstatus(rs.getInt("estatus"));

                pacientes.add(otroEstudio);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacientes = null;
        }
        return pacientes;
    }

    @Override
    public int agregarOtroEstudio(OtroEstudio otroEstudio) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        String stPrcedure = "CALL agregarOtroEstudio(?, ?, ?, ?)";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);

            cstmt.setInt(1, otroEstudio.getIdOtroEstudio());
            cstmt.setInt(2, otroEstudio.getIdEstudio());
            cstmt.setString(3, otroEstudio.getNombre());
            cstmt.setInt(4, otroEstudio.getEstatus());
            

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
    public boolean actualizarOtroEstudio(OtroEstudio otroEstudio) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "CALL actualizarOtroEstudio(?, ?, ? , ?)";
        boolean exito = false;
        ResultSet rs;
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, otroEstudio.getIdOtroEstudio());
            cstmt.setInt(2, otroEstudio.getIdEstudio());
            cstmt.setString(3, otroEstudio.getNombre());
            cstmt.setInt(4, otroEstudio.getEstatus());

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
    public boolean borradoLogicoOtroEstudio(int idOtroEstudio) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "CALL borradoLogicoOtroEstudio(?)";
        boolean exito = false;
        ResultSet rs;
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idOtroEstudio);

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

}
