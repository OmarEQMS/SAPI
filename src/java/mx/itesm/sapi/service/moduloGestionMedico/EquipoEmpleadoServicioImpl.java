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
import mx.itesm.sapi.bean.moduloGestionMedico.EquipoEmpleado;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author feror
 */
public class EquipoEmpleadoServicioImpl implements EquipoEmpleadoServicio {

    @Override
    public int agregarEquipoEmpleado(EquipoEmpleado equipoEmpleado) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        int id = 0;
        //Aquí va el call del procedure
        String stProcedure = "-------";

        try {

            cstmt = conn.prepareCall(stProcedure);

            //Aquí van los sets
            //cstmt.setInt(1,empleado.getIdEmpleado());
            cstmt.setInt(1, equipoEmpleado.getIdEquipo());
            cstmt.setInt(2, equipoEmpleado.getIdEmpleado());
            cstmt.setString(3, equipoEmpleado.getEstatus());

            //Aquí va el registerOutParameter
            //cstmt.registerOutParameter(12,Types.INTEGER);
            cstmt.executeUpdate();

            ResultSet rs = cstmt.getGeneratedKeys();

            rs.next();

            id = rs.getInt(1);

            cstmt.close();

        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de agregarEquipoEmpleado");
            System.out.println(ex.getMessage());

        }

        return id;
    }

    @Override
    public EquipoEmpleado mostrarEquipoEmpleado(int idEquipoEmpleado) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        EquipoEmpleado equipoEmpleado = new EquipoEmpleado();

        //Call del store procedure
        String stProcedure = "-----";

        try {

            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEquipoEmpleado);
            ResultSet rs = cstmt.executeQuery();

            rs.next();
            equipoEmpleado.setIdEquipoEmpleado(rs.getInt(1));
            equipoEmpleado.setIdEquipo(rs.getInt(2));
            equipoEmpleado.setIdEmpleado(rs.getInt(3));
            equipoEmpleado.setEstatus(rs.getString(4));

            return equipoEmpleado;
        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de mostrarEquipoEmpleado");
            System.out.println(ex.getMessage());
            return equipoEmpleado;
        }
    }

    @Override
    public List<EquipoEmpleado> mostrarEquipoEmpleado() {
        Connection conn = Conexion.getConnection();

        List<EquipoEmpleado> equiposEmpleados = new ArrayList<>();
        CallableStatement cstmt;

        try {

            cstmt = conn.prepareCall("CALL -----");
            ResultSet rs = cstmt.executeQuery();
            EquipoEmpleado equipoEmpleado;

            while (rs.next()) {

                equipoEmpleado = new EquipoEmpleado();

                equipoEmpleado.setIdEquipoEmpleado(rs.getInt(1));
                equipoEmpleado.setIdEquipo(rs.getInt(2));
                equipoEmpleado.setIdEmpleado(rs.getInt(3));
                equipoEmpleado.setEstatus(rs.getString(4));

                equiposEmpleados.add(equipoEmpleado);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Estoy en el catch de mostrarEquipoEmpleado");
        }

        return equiposEmpleados;
    }

    @Override
    public boolean borradoLogicoEquipoEmpleado(int idEquipoEmpleado) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "";

        try {

            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idEquipoEmpleado);

            ResultSet rs = cstmt.executeQuery();

            rs.next();

            return rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println("Estoy en el catch de borradoLogicoEquipoEmpleado");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizarEquipoEmpleado(EquipoEmpleado equipoEmpleado) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "";

        try {

            cstmt = conn.prepareCall(stProcedure);

             cstmt.setInt(1,equipoEmpleado.getIdEquipoEmpleado());
            cstmt.setInt(2, equipoEmpleado.getIdEquipo());
            cstmt.setInt(3, equipoEmpleado.getIdEmpleado());
            cstmt.setString(4, equipoEmpleado.getEstatus());
            
            ResultSet rs = cstmt.executeQuery();

            rs.next();

            return rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println("Estoy en el catch de actualizarEquipoEmpleado");
            System.out.println(ex.getMessage());
            return false;
        }
    }

}
