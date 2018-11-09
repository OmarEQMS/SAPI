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
import mx.itesm.sapi.bean.gestionPaciente.Her2;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Alexis España
 */
public class Her2ServicioImpl implements Her2Servicio {

    @Override
    public Her2 mostrarHer2(int idTipoHistologico) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        Her2 her2 = new Her2();

        String stProcedure = "";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();

            her2.setIdHer2(rs.getInt("idHer2"));
            her2.setNombre(rs.getString("nombre"));
            her2.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            her2 = null;
        }
        return her2;
    }

    @Override
    public List<Her2> mostrarHer2() {
        Connection conn;
        List<Her2> listHer2 = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure = "CALL mostrarListaHer2()";

        ResultSet rs;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            Her2 her2;

            while (rs.next()) {
                her2 = new Her2();
                her2.setIdHer2(rs.getInt("idHer2"));
                her2.setNombre(rs.getString("nombre"));
                her2.setEstatus(rs.getInt("estatus"));

                listHer2.add(her2);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listHer2 = null;
        }
        return listHer2;
    }
}
