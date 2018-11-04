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
import mx.itesm.sapi.bean.persona.EstadoCivil;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class EstadoCivilServicioImpl implements EstadoCivilServicio {

    @Override
    public EstadoCivil mostrarEstadoCivil(int idEstadoCivil) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        EstadoCivil estadoCivil = null;

        //Call del store procedure
        String stProcedure = "mostrarEstadoCivil(?)";

        try {
            estadoCivil = new EstadoCivil();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEstadoCivil);

            rs = cstmt.executeQuery();

            rs.next();
            estadoCivil.setIdEstadoCivil(rs.getInt("idEstadoCivil"));
            estadoCivil.setNombre(rs.getString("nombre"));
            estadoCivil.setEstatus(rs.getInt("estatus"));
            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estadoCivil = null;
        }
        return estadoCivil;
    }

    @Override
    public List<EstadoCivil> mostrarEstadoCivil() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        List<EstadoCivil> estadoCiviles = null;

        try {
            estadoCiviles = new ArrayList<>();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL mostrarListaEstadoCivil()");
            rs = cstmt.executeQuery();
            EstadoCivil estadoCivil;

            while (rs.next()) {

                estadoCivil = new EstadoCivil();

                estadoCivil.setIdEstadoCivil(rs.getInt("idEstadoCivil"));
                estadoCivil.setNombre(rs.getString("nombre"));
                estadoCivil.setEstatus(rs.getInt("estatus"));

                estadoCiviles.add(estadoCivil);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }

        return estadoCiviles;
    }

    @Override
    public boolean agregarEstadoCivil(EstadoCivil estadoCivil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarEstadoCivil(EstadoCivil idEstadoCivil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoEstadoCivil(int idEstadoCivil) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        boolean exito = false;

        //Call del store procedure
        String stProcedure = "borradoLogicoEstadoCivil(?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idEstadoCivil);

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
