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
import mx.itesm.sapi.bean.gestionPaciente.TorreNueva;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Alex
 */
public class TorreNuevaServicioImpl implements TorreNuevaServicio {

    @Override
    public TorreNueva mostrarTorreNueva(int idTorreNueva) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        TorreNueva torreNueva = new TorreNueva();

        String stProcedure = "";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();

            torreNueva.setIdTorreNueva(rs.getInt("idTorreNueva"));
            torreNueva.setNombre(rs.getInt("nombre"));
            torreNueva.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            torreNueva = null;
        }
        return torreNueva;
    }

    @Override
    public List<TorreNueva> mostrarTorreNueva() {
        Connection conn;
        List<TorreNueva> listtorreNueva = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure = "";

        ResultSet rs;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            TorreNueva torreNueva;

            while (rs.next()) {
                torreNueva = new TorreNueva();
                torreNueva.setIdTorreNueva(rs.getInt("idTorreNueva"));
                torreNueva.setNombre(rs.getInt("nombre"));
                torreNueva.setEstatus(rs.getInt("estatus"));

                listtorreNueva.add(torreNueva);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listtorreNueva = null;
        }
        return listtorreNueva;
    }
    
}
