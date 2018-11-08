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
import mx.itesm.sapi.bean.gestionPaciente.TipoBiopsia;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class TipoBiopsiaServicioImpl implements TipoBiopsiaServicio {

    @Override
    public TipoBiopsia mostrarTipoBiopsia(int idBiopsia) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        TipoBiopsia tipoBiopsia = new TipoBiopsia();

        String stProcedure = "CALL mostrarTipoBiopsia(?)";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idBiopsia);
            rs = cstmt.executeQuery();
            rs.next();

            tipoBiopsia.setIdTipoBiopsia(rs.getInt("idTipoBiopsia"));
            tipoBiopsia.setNombre(rs.getString("nombre"));
            tipoBiopsia.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            tipoBiopsia = null;
        }
        return tipoBiopsia;
    }

    @Override
    public List<TipoBiopsia> mostrarListaTipoBiopsia() {
        Connection conn;
        List<TipoBiopsia> tipos = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure = "CALL mostrarListaTipoBiopsia()";

        ResultSet rs;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            TipoBiopsia tipoBiopsia;

            while (rs.next()) {
                tipoBiopsia = new TipoBiopsia();
                tipoBiopsia.setIdTipoBiopsia(rs.getInt("idTipoBiopsia"));
                tipoBiopsia.setNombre(rs.getString("nombre"));
                tipoBiopsia.setEstatus(rs.getInt("estatus"));

                tipos.add(tipoBiopsia);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            tipos = null;
        }
        return tipos;
    }

}
