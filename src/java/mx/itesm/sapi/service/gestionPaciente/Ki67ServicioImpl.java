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
import mx.itesm.sapi.bean.gestionPaciente.Ki67;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Alexis España
 */
public class Ki67ServicioImpl implements Ki67Servicio {

    @Override
    public Ki67 mostrarKi67(int idKi67) {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        Ki67 ki67 = new Ki67();

        String stProcedure = "";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();

            ki67.setIdKi67(rs.getInt("ki67"));
            ki67.setNombre(rs.getString("nombre"));
            ki67.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            ki67 = null;
        }
        return ki67;
    }

    @Override
    public List<Ki67> mostrarKi67() {
        Connection conn;
        List<Ki67> listKi67 = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure = "";

        ResultSet rs;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            Ki67 ki67;

            while (rs.next()) {
                ki67 = new Ki67();
                ki67.setIdKi67(rs.getInt("idKi67"));
                ki67.setNombre(rs.getString("nombre"));
                ki67.setEstatus(rs.getInt("estatus"));

                listKi67.add(ki67);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listKi67 = null;
        }
        return listKi67;
    }

    @Override
    public Ki67 mostrarKi67Nombre(int nombre) {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        Ki67 ki67 = null;

        String stProcedure = "CALL mostrarKi67Nombre(?)";
        try {
            conn = Conexion.getConnection();
            ki67 = new Ki67();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, nombre);

            rs = cstmt.executeQuery();
            rs.next();

            ki67.setIdKi67(rs.getInt("idKi67"));
            ki67.setNombre(rs.getString("nombre"));
            ki67.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            ki67 = null;
        }
        return ki67;
    }

}
