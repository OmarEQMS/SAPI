/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.persona.EstadoCuenta;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class EstadoCuentaServicioImpl implements EstadoCuentaServicio {

    @Override
    public boolean borradoLogicoEstadoCuenta(int idEstadoCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EstadoCuenta mostrarEstadoCuenta(int idEstadoCuenta) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        EstadoCuenta estadoCuenta = null;

        //Call del store procedure
        String stProcedure = "mostrarEstadoCuenta(?)";

        try {
            estadoCuenta = new EstadoCuenta();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEstadoCuenta);

            rs = cstmt.executeQuery();

            rs.next();
            estadoCuenta.setIdEstadoCuenta(rs.getInt("idEstadoCuenta"));
            estadoCuenta.setNombre(rs.getString("nombre"));
            estadoCuenta.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estadoCuenta = null;
        }
        return estadoCuenta;
    }

    @Override
    public List<EstadoCuenta> mostrarEstadoCuenta() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        List<EstadoCuenta> estadoCuentas = null;

        try {
            estadoCuentas = new ArrayList<>();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("mostrarListaEstadoCuenta()");
            rs = cstmt.executeQuery();
            EstadoCuenta estadoCuenta;

            while (rs.next()) {

                estadoCuenta = new EstadoCuenta();

                estadoCuenta.setIdEstadoCuenta(rs.getInt("idEstadoCuenta"));
                estadoCuenta.setNombre(rs.getString("nombre"));
                estadoCuenta.setEstatus(rs.getInt("estatus"));

                estadoCuentas.add(estadoCuenta);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estadoCuentas = null;
        }

        return estadoCuentas;
    }

    @Override
    public int agregarEstadoCuenta(EstadoCuenta estadoCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarEstadoCuenta(EstadoCuenta estadoCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
