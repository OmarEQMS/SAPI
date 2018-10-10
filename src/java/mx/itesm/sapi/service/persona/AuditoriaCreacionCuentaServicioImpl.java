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
import mx.itesm.sapi.bean.persona.AuditoriaCreacionCuenta;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class AuditoriaCreacionCuentaServicioImpl implements AuditoriaCreacionCuentaServicio {

    @Override
    public int agregarAuditoriaCreacionCuenta(AuditoriaCreacionCuenta auditoriaCreacionCuenta) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        int id = -1;
        //Aquí va el call del procedure
        String stProcedure = "agregarAuditoriaCreacionCuenta(?, ?, ?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            //Aquí van los sets
            //cstmt.setInt(1,citaEmpleado.getIdCitaEmpleado());
            cstmt.setInt(1, auditoriaCreacionCuenta.getIdAuditoriaCreacionCuenta());
            cstmt.setInt(2, auditoriaCreacionCuenta.getIdCuenta());
            cstmt.setDate(3, auditoriaCreacionCuenta.getFecha());

            cstmt.setInt(4, auditoriaCreacionCuenta.getCondiciones());
            cstmt.setInt(5, auditoriaCreacionCuenta.getEstatus());

            //Aquí va el registerOutParameter
            //cstmt.registerOutParameter(12,Types.INTEGER);
            cstmt.executeUpdate();

            rs = cstmt.getGeneratedKeys();

            rs.next();

            id = rs.getInt(1);

            cstmt.close();
            conn.close();
            rs.close();

        } catch (SQLException ex) {

           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id=-1;

        }

        return id;
    }

    @Override
    public boolean actualizarAuditoriaCreacionCuenta(AuditoriaCreacionCuenta auditoriaCreacionCuenta) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        boolean exito = false;

        //Call del store procedure
        String stProcedure = "actualizarAuditoriaCreacionCuenta(?, ?, ?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, auditoriaCreacionCuenta.getIdAuditoriaCreacionCuenta());
            cstmt.setInt(2, auditoriaCreacionCuenta.getIdCuenta());
            cstmt.setDate(3, auditoriaCreacionCuenta.getFecha());

            cstmt.setInt(4, auditoriaCreacionCuenta.getCondiciones());
            cstmt.setInt(5, auditoriaCreacionCuenta.getEstatus());

            rs = cstmt.executeQuery();

            rs.next();

            exito = rs.getBoolean(1);
            conn.close();
            rs.close();
            cstmt.close();

        } catch (SQLException ex) {
          System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;

        }
        return exito;

    }

    @Override
    public boolean borradoLogicoAuditoriaCreacionCuenta(int idAuditoriaCreacionCuenta) {
        Connection conn;
        ResultSet rs;
        boolean exito = false;
        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "borradoLogicoAuditoriaCreacionCuenta(?)";

        try {
            conn = Conexion.getConnection();

            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idAuditoriaCreacionCuenta);

            rs = cstmt.executeQuery();

            rs.next();

            exito = rs.getBoolean(1);
            conn.close();
            rs.close();
            cstmt.close();

        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;

        }
        return exito;
    }

    @Override
    public AuditoriaCreacionCuenta mostrarAuditoriaCreacionCuenta(int idAuditoriaCreacionCuenta) {
        Connection conn;
        ResultSet rs;

        CallableStatement cstmt;

        AuditoriaCreacionCuenta auditoriaCreacionCuenta = null;

        //Call del store procedure
        String stProcedure = "mostrarAuditoriaCreacionCuenta (?)";

        try {
            auditoriaCreacionCuenta = new AuditoriaCreacionCuenta();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idAuditoriaCreacionCuenta);

            rs = cstmt.executeQuery();

            rs.next();
            auditoriaCreacionCuenta.setIdAuditoriaCreacionCuenta(rs.getInt("idAuditoriaCreacionCuenta"));
            auditoriaCreacionCuenta.setIdCuenta(rs.getInt("idCuenta"));
            auditoriaCreacionCuenta.setFecha(rs.getDate("fecha"));

            auditoriaCreacionCuenta.setCondiciones(rs.getInt("condiciones"));
            auditoriaCreacionCuenta.setEstatus(rs.getInt("estatus"));

            conn.close();
            rs.close();
            cstmt.close();
        } catch (SQLException ex) {

         System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            auditoriaCreacionCuenta = null;

        }
        return auditoriaCreacionCuenta;
    }

    @Override
    public List<AuditoriaCreacionCuenta> mostrarAuditoriaCreacionCuenta() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        List<AuditoriaCreacionCuenta> auditoriaCreacionCuentas = null;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("mostrarListaAuditoriaCreacionCuenta()");
            rs = cstmt.executeQuery();
            auditoriaCreacionCuentas= new ArrayList<>();
            AuditoriaCreacionCuenta auditoriaCreacionCuenta;

            while (rs.next()) {

                auditoriaCreacionCuenta = new AuditoriaCreacionCuenta();

               auditoriaCreacionCuenta.setIdAuditoriaCreacionCuenta(rs.getInt("idAuditoriaCreacionCuenta"));
            auditoriaCreacionCuenta.setIdCuenta(rs.getInt("idCuenta"));
            auditoriaCreacionCuenta.setFecha(rs.getDate("fecha"));

            auditoriaCreacionCuenta.setCondiciones(rs.getInt("condiciones"));
            auditoriaCreacionCuenta.setEstatus(rs.getInt("estatus"));

                auditoriaCreacionCuentas.add(auditoriaCreacionCuenta);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            auditoriaCreacionCuentas = null;
        }

        return auditoriaCreacionCuentas;
    }

}
