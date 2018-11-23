/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.calendario.MCalendarioNavegadora;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class MCalendarioNavegadoraServicioImpl implements MCalendarioNavegadoraServicio {

    @Override
    public int agregarCitaPaciente(MCalendarioNavegadora mCalendarioNavegadora) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        int id = -1;

        String stProcedure = "CALL agregarCitaPacienteR(?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, mCalendarioNavegadora.getIdPaciente());
            cstmt.setDate(2, mCalendarioNavegadora.getFechaCita());

            System.out.println("MENSAJE: ".concat(cstmt.toString()));

            rs = cstmt.executeQuery();
            rs.next();
            id = rs.getInt(1);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;

        }

        return id;
    }

    @Override
    public List<MCalendarioNavegadora> mostrarPcientesParaCita() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        List<MCalendarioNavegadora> pacientes = null;

        try {
            pacientes = new ArrayList<>();
            conn = Conexion.getConnection();

            cstmt = conn.prepareCall("CALL mostrarPacientesResultados()");
            rs = cstmt.executeQuery();
            MCalendarioNavegadora mCalendarioNavegadora;

            while (rs.next()) {

                mCalendarioNavegadora = new MCalendarioNavegadora();
                mCalendarioNavegadora.setIdPaciente(rs.getInt("idPaciente"));
                mCalendarioNavegadora.setNombre(rs.getString("nombre"));
                mCalendarioNavegadora.setPrimerApellido(rs.getString("primerApellido"));
                mCalendarioNavegadora.setSegundoApellido(rs.getString("segundoApellido"));
                pacientes.add(mCalendarioNavegadora);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacientes = null;
        }

        return pacientes;
    }

    @Override
    public List<MCalendarioNavegadora> mostrarCitasDePacientes() {
         Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        List<MCalendarioNavegadora> citas = null;

        try {
            citas = new ArrayList<>();
            conn = Conexion.getConnection();

            cstmt = conn.prepareCall("CALL mostrarCitasPacienteR()");
            rs = cstmt.executeQuery();
            MCalendarioNavegadora mCalendarioNavegadora;

            while (rs.next()) {

                mCalendarioNavegadora = new MCalendarioNavegadora();
                mCalendarioNavegadora.setIdPaciente(rs.getInt("idPaciente"));
                mCalendarioNavegadora.setNombre(rs.getString("nombre"));
                mCalendarioNavegadora.setPrimerApellido(rs.getString("primerApellido"));
                mCalendarioNavegadora.setSegundoApellido(rs.getString("segundoApellido"));
                mCalendarioNavegadora.setFechaCita(rs.getDate("fechaReal"));
                citas.add(mCalendarioNavegadora);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            citas = null;
        }

        return citas;
    }

}
