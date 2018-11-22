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
import mx.itesm.sapi.bean.moduloGestionMedico.Empleado;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Fernanda Orduña & Pablo Lugo
 */
public class EmpleadoServicioImpl implements EmpleadoServicio {

    
    @Override
    public int agregarEmpleado(Empleado empleado) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        int id = 0;
        //Aquí va el call del procedure
        String stProcedure = "CALL agregarEmpleado(?,?,?)";

        try {

            cstmt = conn.prepareCall(stProcedure);

            //Aquí van los sets
            //cstmt.setInt(1,empleado.getIdEmpleado());
            cstmt.setInt(1, empleado.getIdDepartamentoDepartamentoInterno());
            cstmt.setString(2, empleado.getNoEmpleado());
            cstmt.setInt(3, empleado.getIdCuenta());

            //Aquí va el registerOutParameter
            //cstmt.registerOutParameter(12,Types.INTEGER);            

            ResultSet rs = cstmt.executeQuery();
            rs.next();
            id = rs.getInt(1);

            cstmt.close();

        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de agregarEmpleado");
            System.out.println(ex.getMessage());

        }

        return id;
    }
    
    @Override
    public Empleado mostrarEmpleado(int idEmpleado) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        Empleado empleado = new Empleado();

        //Call del store procedure
        String stProcedure = "-----";

        try {

            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEmpleado);
            ResultSet rs = cstmt.executeQuery();

            rs.next();
            empleado.setIdEmpleado(rs.getInt(1));
            empleado.setIdDepartamentoDepartamentoInterno(rs.getInt(2));
            empleado.setNoEmpleado(rs.getString(3));
            empleado.setEstatus(rs.getInt(4));

            return empleado;
        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de mostrarEmpleado");
            System.out.println(ex.getMessage());
            return empleado;
        }
    }
    
    
    @Override
    public Empleado mostrarEmpleadoCuenta(int idCuenta) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        Empleado empleado = new Empleado();

        //Call del store procedure
        String stProcedure = "CALL mostrarEmpleadoCuenta(?)";

        try {

            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idCuenta);
            ResultSet rs = cstmt.executeQuery();

            rs.next();
            empleado.setIdEmpleado(rs.getInt(1));
            empleado.setIdDepartamentoDepartamentoInterno(rs.getInt(2));
            empleado.setNoEmpleado(rs.getString(3));
            empleado.setEstatus(rs.getInt(4));
            empleado.setIdCuenta(rs.getInt(5));

            return empleado;
        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de mostrarEmpleado");
            System.out.println(ex.getMessage());
            return empleado;
        }
    }

    @Override
    public List<Empleado> mostrarEmpleado() {
        Connection conn = Conexion.getConnection();

        List<Empleado> empleados = new ArrayList<>();
        CallableStatement cstmt;

        try {

            cstmt = conn.prepareCall("CALL -----");
            ResultSet rs = cstmt.executeQuery();
            Empleado empleado;

            while (rs.next()) {

                empleado = new Empleado();

                empleado.setIdEmpleado(rs.getInt(1));
                empleado.setIdDepartamentoDepartamentoInterno(rs.getInt(2));
                empleado.setNoEmpleado(rs.getString(3));
                empleado.setEstatus(rs.getInt(4));

                empleados.add(empleado);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Estoy en el catch de mostrarEmpleado");
        }

        return empleados;
    }
    
    

    

    @Override
    public boolean borradoLogicoEmpleado(int idEmpleado) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "";

        try {

            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idEmpleado);

            ResultSet rs = cstmt.executeQuery();

            rs.next();

            return rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println("Estoy en el catch de borradoLogicoEmpleado");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizarEmpleado(Empleado empleado) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "";

        try {

            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1,empleado.getIdEmpleado());
            cstmt.setInt(2, empleado.getIdDepartamentoDepartamentoInterno());
            cstmt.setString(3, empleado.getNoEmpleado());
            cstmt.setInt(4, empleado.getEstatus());
            
            ResultSet rs = cstmt.executeQuery();

            rs.next();

            return rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println("Estoy en el catch de actualizarEmpleado");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Empleado mostrarEmpleadoPersona(int idPersona) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        Empleado empleado = new Empleado();

        //Call del store procedure
        String stProcedure = "CALL mostrarEmpleadoPersona(?)";

        try {

            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPersona);
            ResultSet rs = cstmt.executeQuery();

            rs.next();
            empleado.setIdEmpleado(rs.getInt(1));
            empleado.setIdDepartamentoDepartamentoInterno(rs.getInt(2));
            empleado.setNoEmpleado(rs.getString(3));
            empleado.setEstatus(rs.getInt(4));
            empleado.setIdCuenta(rs.getInt(5));

            return empleado;
        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de mostrarEmpleado");
            System.out.println(ex.getMessage());
            return empleado;
        }
    }
    
    

}