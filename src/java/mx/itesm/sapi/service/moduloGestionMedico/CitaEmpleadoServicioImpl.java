<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.moduloGestionMedico;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.CitaEmpleado;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author feror
 */
public class CitaEmpleadoServicioImpl implements CitaEmpleadoServicio {

    @Override
    public int agregarCitaEmpleado(CitaEmpleado citaEmpleado) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        int id = -1;
        //Aquí va el call del procedure
        String stProcedure = "-------";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            //Aquí van los sets
            //cstmt.setInt(1,citaEmpleado.getIdCitaEmpleado());
            cstmt.setInt(1, citaEmpleado.getIdCita());
            cstmt.setInt(2, citaEmpleado.getIdEmpleado());
            cstmt.setInt(3, citaEmpleado.getEstatus());

            //Aquí va el registerOutParameter
            //cstmt.registerOutParameter(12,Types.INTEGER);
            cstmt.executeUpdate();

            rs = cstmt.getGeneratedKeys();

            rs.next();

            id = rs.getInt(1);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            id = -1;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));

        }

        return id;

    }

    @Override
    public CitaEmpleado mostrarCitaEmpleado(int idCitaEmpleado) {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        CitaEmpleado citaEmpleado = new CitaEmpleado();

        //Call del store procedure
        String stProcedure = "-----";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idCitaEmpleado);
            rs = cstmt.executeQuery();

            rs.next();
            citaEmpleado.setIdCitaEmpleado(rs.getInt("idCitaEmpleado"));
            citaEmpleado.setIdCita(rs.getInt("idCita"));
            citaEmpleado.setIdEmpleado(rs.getInt("idEmpleado"));
            citaEmpleado.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {

            System.out.println(this.getClass().toString()
                    .concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            citaEmpleado = null;
        }
        return citaEmpleado;
    }

    @Override
    public List<CitaEmpleado> mostrarCitasEmpleados() {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        List<CitaEmpleado> citasEmpleados = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL -----");
            rs = cstmt.executeQuery();
            CitaEmpleado citaEmpleado;

            while (rs.next()) {

                citaEmpleado = new CitaEmpleado();

                citaEmpleado.setIdCitaEmpleado(rs.getInt("idCitaEmpleado"));
                citaEmpleado.setIdCita(rs.getInt("idCita"));
                citaEmpleado.setIdEmpleado(rs.getInt("idEmpleado"));
                citaEmpleado.setEstatus(rs.getInt("estatus"));

                citasEmpleados.add(citaEmpleado);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (Exception ex) {

            System.out.println(this.getClass().toString()
                    .concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            citasEmpleados = null;
        }

        return citasEmpleados;
    }

    @Override
    public boolean borradoLogicoCitaEmpleado(int idCitaEmpleado) {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        //Call del store procedure
        String stProcedure = "";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idCitaEmpleado);

            rs = cstmt.executeQuery();

            rs.next();

            return rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString()
                    .concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            return false;
        }

    }

    @Override
    public boolean actualizarCitaEmpleado(CitaEmpleado citaEmpleado) {

        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "";

        try {

            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, citaEmpleado.getIdCitaEmpleado());
            cstmt.setInt(2, citaEmpleado.getIdCita());
            cstmt.setInt(3, citaEmpleado.getIdEmpleado());
            cstmt.setInt(4, citaEmpleado.getEstatus());

            ResultSet rs = cstmt.executeQuery();

            rs.next();

            return rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString()
                    .concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            return false;
        }

    }

}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.moduloGestionMedico;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.CitaEmpleado;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author feror
 */
public class CitaEmpleadoServicioImpl implements CitaEmpleadoServicio {

    @Override
    public int agregarCitaEmpleado(CitaEmpleado citaEmpleado) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        int id = 0;
        //Aquí va el call del procedure
        String stProcedure = "-------";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            //Aquí van los sets
            //cstmt.setInt(1,citaEmpleado.getIdCitaEmpleado());
            cstmt.setInt(1, citaEmpleado.getIdCita());
            cstmt.setInt(2, citaEmpleado.getIdEmpleado());
            cstmt.setInt(3, citaEmpleado.getEstatus());

            //Aquí va el registerOutParameter
            //cstmt.registerOutParameter(12,Types.INTEGER);
            cstmt.executeUpdate();

            rs = cstmt.getGeneratedKeys();

            rs.next();

            id = rs.getInt(1);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de CitaEmpleadoServicio");
            System.out.println(ex.getMessage());

        }

        return id;

    }

    @Override
    public CitaEmpleado mostrarCitaEmpleado(int idCitaEmpleado) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        CitaEmpleado citaEmpleado = new CitaEmpleado();

        //Call del store procedure
        String stProcedure = "-----";

        try {

            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idCitaEmpleado);
            ResultSet rs = cstmt.executeQuery();

            rs.next();
            citaEmpleado.setIdCitaEmpleado(rs.getInt("idCitaEmpleado"));
            citaEmpleado.setIdCita(rs.getInt("idCita"));
            citaEmpleado.setIdEmpleado(rs.getInt("idEmpleado"));
            citaEmpleado.setEstatus(rs.getInt("estatus"));

            return citaEmpleado;
        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de CitaEmpleadoServicio");
            System.out.println(ex.getMessage());
            return citaEmpleado;
        }
    }

    @Override
    public List<CitaEmpleado> mostrarCitasEmpleados() {
        Connection conn = Conexion.getConnection();

        List<CitaEmpleado> citasEmpleados = new ArrayList<>();
        CallableStatement cstmt;

        try {

            cstmt = conn.prepareCall("CALL -----");
            ResultSet rs = cstmt.executeQuery();
            CitaEmpleado citaEmpleado;

            while (rs.next()) {

                citaEmpleado = new CitaEmpleado();

                citaEmpleado.setIdCitaEmpleado(rs.getInt("idCitaEmpleado"));
                citaEmpleado.setIdCita(rs.getInt("idCita"));
                citaEmpleado.setIdEmpleado(rs.getInt("idEmpleado"));
                citaEmpleado.setEstatus(rs.getInt("estatus"));

                citasEmpleados.add(citaEmpleado);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("ERROR GET ESTADOS" + e.getMessage());
        }

        return citasEmpleados;
    }

    @Override
    public boolean borradoLogicoCitaEmpleado(int idCitaEmpleado) {

        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "";

        try {

            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idCitaEmpleado);

            ResultSet rs = cstmt.executeQuery();

            rs.next();

            return rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println("Estoy en el catch de CitaEmpleado");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizarCitaEmpleado(CitaEmpleado citaEmpleado) {

        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "";

        try {

            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, citaEmpleado.getIdCitaEmpleado());
            cstmt.setInt(2, citaEmpleado.getIdCita());
            cstmt.setInt(3, citaEmpleado.getIdEmpleado());
            cstmt.setInt(4, citaEmpleado.getEstatus());

            ResultSet rs = cstmt.executeQuery();

            rs.next();

            return rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println("Estoy en el catch de actualizarCitaEmpleado");
            System.out.println(ex.getMessage());
            return false;
        }

    }

}
>>>>>>> Login
