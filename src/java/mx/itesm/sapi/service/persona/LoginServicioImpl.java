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
import mx.itesm.sapi.bean.persona.Login;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class LoginServicioImpl implements LoginServicio {

    @Override
    public boolean borradoLogicoLogin(int idLogin) {
        Connection conn;
        ResultSet rs;
        boolean exito = false;
        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "borradoLogicoLogin(?)";

        try {
            conn = Conexion.getConnection();

            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idLogin);

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
    public Login mostrarLogin(int idLogin) {
        Connection conn;
        ResultSet rs;

        CallableStatement cstmt;

        Login login = null;

        //Call del store procedure
        String stProcedure = "mostrarLogin(?)";

        try {
            login = new Login();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idLogin);

            rs = cstmt.executeQuery();

            rs.next();
            login.setIdLogin(rs.getInt("idLogin"));
            login.setIdCuenta(rs.getInt("idCuenta"));
            login.setFecha(rs.getDate("fecha"));
            login.setExitoso(rs.getInt("exitoso"));
            login.setEstatus(rs.getInt("estatus"));

            conn.close();
            rs.close();
            cstmt.close();
        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            login = null;

        }
        return login;
    }

    @Override
    public List<Login> mostrarLogin() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        List<Login> logins = null;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("mostrarListaLogin()");
            rs = cstmt.executeQuery();
            logins = new ArrayList<>();
            Login login;

            while (rs.next()) {

                login = new Login();

                login.setIdLogin(rs.getInt("idLogin"));
                login.setIdCuenta(rs.getInt("idCuenta"));
                login.setFecha(rs.getDate("fecha"));
                login.setExitoso(rs.getInt("exitoso"));
                login.setEstatus(rs.getInt("estatus"));

                logins.add(login);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            logins = null;
        }

        return logins;

    }

    @Override
    public int agregarLogin(Login login) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        int id = -1;
        //Aquí va el call del procedure
        String stProcedure = "agregarLogin(?, ?, ?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            //Aquí van los sets
            //cstmt.setInt(1,citaEmpleado.getIdCitaEmpleado());
            cstmt.setInt(1, login.getIdLogin());
            cstmt.setInt(2, login.getIdCuenta());
            cstmt.setDate(3, login.getFecha());
            cstmt.setInt(4, login.getExitoso());
            cstmt.setInt(5, login.getEstatus());

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
    public boolean actualizarLogin(Login login) {
         Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        boolean exito = false;

        //Call del store procedure
        String stProcedure = "actualizarLogin(?, ?, ?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, login.getIdLogin());
            cstmt.setInt(2, login.getIdCuenta());
            cstmt.setDate(3, login.getFecha());
            cstmt.setInt(4, login.getExitoso());
            cstmt.setInt(5, login.getEstatus());

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

}
