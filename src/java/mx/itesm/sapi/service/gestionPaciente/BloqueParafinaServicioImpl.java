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
import mx.itesm.sapi.bean.gestionPaciente.BloqueParafina;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class BloqueParafinaServicioImpl implements BloqueParafinaServicio {

    @Override
    public BloqueParafina mostrarBloqueParafina(int idBloqueParafina) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarBloqueParafina";
        BloqueParafina bloqueParafina = null;

        try {
            conn = Conexion.getConnection();
            bloqueParafina = new BloqueParafina();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idBloqueParafina);

            rs = cstmt.executeQuery();
            rs.next();

            bloqueParafina.setIdBloqueParafina(rs.getInt("idBloqueParafina"));
            bloqueParafina.setIdBiopsia(rs.getInt("idBiopsia"));
            bloqueParafina.setSerie(rs.getString("serie"));
            bloqueParafina.setEstatus(rs.getInt("estatus"));
            bloqueParafina.setCantidad(rs.getInt("cantidad"));

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            bloqueParafina = null;
        }
        return bloqueParafina;
    }

    @Override
    public List<BloqueParafina> mostrarBloqueParafina() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarBloqueParafina";
        List<BloqueParafina> bloqueParafinas = null;
        BloqueParafina bloqueParafina;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            bloqueParafinas = new ArrayList<>();

            while (rs.next()) {
                bloqueParafina = new BloqueParafina();

                bloqueParafina.setIdBloqueParafina(rs.getInt("idBloqueParafina"));
                bloqueParafina.setIdBiopsia(rs.getInt("idBiopsia"));
                bloqueParafina.setSerie(rs.getString("serie"));
                bloqueParafina.setEstatus(rs.getInt("estatus"));
                bloqueParafina.setCantidad(rs.getInt("cantidad"));

                bloqueParafinas.add(bloqueParafina);
            }

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            bloqueParafinas = null;
        }
        return bloqueParafinas;
    }

    @Override
    public int agregarBloqueParafina(BloqueParafina bloqueParafina) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CaLL agregarBloqueParafina";
        int id = -1;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, bloqueParafina.getIdBloqueParafina());
            cstmt.setInt(2, bloqueParafina.getIdBiopsia());
            cstmt.setString(3, bloqueParafina.getSerie());
            cstmt.setInt(4, bloqueParafina.getEstatus());
            cstmt.setInt(5, bloqueParafina.getCantidad());

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
    public boolean borradoLogicoBloqueParafina(int idBloqueParafina) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL borradoLogicoParafina";
        boolean exito = false;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idBloqueParafina);

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
    public boolean actualizarBloqueParafina(BloqueParafina bloqueParafina) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL actualizarBloqueParafina";
        boolean exito = false;
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, bloqueParafina.getIdBloqueParafina());
            cstmt.setInt(2, bloqueParafina.getIdBiopsia());
            cstmt.setString(3, bloqueParafina.getSerie());
            cstmt.setInt(4, bloqueParafina.getEstatus());
            cstmt.setInt(5, bloqueParafina.getCantidad());

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
