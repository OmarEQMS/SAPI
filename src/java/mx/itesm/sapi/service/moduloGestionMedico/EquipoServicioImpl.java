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
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.Equipo;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author feror
 */
public class EquipoServicioImpl implements EquipoServicio {

    @Override
    public Equipo mostrarEquipo(int idEquipo) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        Equipo equipo = new Equipo();

        //Call del store procedure
        String stProcedure = "CALL----";

        try {

            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idEquipo);

            ResultSet rs = cstmt.executeQuery();

            rs.next();
            equipo.setIdEquipo(rs.getInt(1));
            equipo.setNombre(rs.getString(2));
            equipo.setEstatus(rs.getInt(3));

            return equipo;
        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de mostrarEquipo");
            System.out.println(ex.getMessage());
            return equipo;
        }
    }

    @Override
    public List<Equipo> mostrarEquipo() {
        Connection conn = Conexion.getConnection();

        List<Equipo> equipos = new ArrayList<>();
        CallableStatement cstmt;

        try {

            cstmt = conn.prepareCall("CALL -----");
            ResultSet rs = cstmt.executeQuery();
            Equipo equipo;

            while (rs.next()) {

                equipo = new Equipo();

                equipo.setIdEquipo(rs.getInt(1));
                equipo.setNombre(rs.getString(2));
                equipo.setEstatus(rs.getInt(3));

                equipos.add(equipo);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Estoy en el catch de mostrarEquipo");
        }

        return equipos;
    }

}
