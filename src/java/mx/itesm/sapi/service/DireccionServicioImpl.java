/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.Direccion;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class DireccionServicioImpl implements DireccionServicio {

    @Override
    public Direccion mostrarDireccion(int idDireccion) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        Direccion direccion = null;

        //Call del store procedure
        String stProcedure = "mostrarDireccion(?)";

        try {
            direccion = new Direccion();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idDireccion);

            rs = cstmt.executeQuery();

            rs.next();
            direccion.setIdDireccion(rs.getInt("idDireccion"));
            direccion.setCalle(rs.getString("calle"));
            direccion.setNoInterior(rs.getString("noInterior"));
            direccion.setNoExterior(rs.getString("noExterior"));
            direccion.setColonia(rs.getString("colonia"));
            direccion.setEstatus(rs.getInt("estatus"));
            conn.close();
            rs.close();
            cstmt.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            direccion = null;
        }
        return direccion;
    }

    @Override
    public List<Direccion> mostrarDireccion() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        List<Direccion> direcciones = null;

        try {
            direcciones = new ArrayList<>();
            conn = Conexion.getConnection();

            cstmt = conn.prepareCall("mostrarListaDireccion()");
            rs = cstmt.executeQuery();
            Direccion direccion;

            while (rs.next()) {

                direccion = new Direccion();
                direccion.setIdDireccion(rs.getInt("idDireccion"));
                direccion.setCalle(rs.getString("calle"));
                direccion.setNoInterior(rs.getString("noInterior"));
                direccion.setNoExterior(rs.getString("noExterior"));
                direccion.setColonia(rs.getString("colonia"));
                direccion.setEstatus(rs.getInt("estatus"));
                direcciones.add(direccion);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            direcciones = null;
        }

        return direcciones;

    }

    @Override
    public int agregarDireccion(Direccion direccion) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        int id = -1;
        //Aquí va el call del procedure
        String stProcedure = "insertaDireccion(?, ?, ?, ?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            //Aquí van los sets
            //cstmt.setInt(1,citaEmpleado.getIdCitaEmpleado());
            cstmt.setInt(1, direccion.getIdDireccion());
            cstmt.setString(2, direccion.getCalle());
            cstmt.setString(3, direccion.getNoInterior());
            cstmt.setString(4, direccion.getNoExterior());
            cstmt.setString(5, direccion.getColonia());
            cstmt.setInt(6, direccion.getEstatus());

            //Aquí va el registerOutParameter
            //cstmt.registerOutParameter(12,Types.INTEGER);
            cstmt.executeUpdate();

            rs = cstmt.getGeneratedKeys();

            rs.next();

            id = rs.getInt(1);

            conn.close();
            rs.close();
            cstmt.close();
        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;

        }

        return id;
    }

    @Override
    public boolean actualizarDireccion(Direccion direccion) {
        boolean exito = false;
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "actualizarDireccion(?, ?, ?, ?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, direccion.getIdDireccion());
            cstmt.setString(2, direccion.getCalle());
            cstmt.setString(3, direccion.getNoInterior());
            cstmt.setString(4, direccion.getNoExterior());
            cstmt.setString(5, direccion.getColonia());
            cstmt.setInt(6, direccion.getEstatus());

            rs = cstmt.executeQuery();

            rs.next();
            conn.close();
            rs.close();
            cstmt.close();
            exito = rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

    @Override
    public boolean borradoLogicoDireccion(int idDireccion) {
        boolean exito = false;
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "borradoLogicoDireccion(?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idDireccion);

            rs = cstmt.executeQuery();

            rs.next();
            conn.close();
            rs.close();
            cstmt.close();
            exito = rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

}
