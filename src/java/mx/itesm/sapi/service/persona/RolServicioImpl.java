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
import mx.itesm.sapi.bean.persona.Rol;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class RolServicioImpl implements RolServicio {

    @Override
    public boolean agregarRol(Rol rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarRol(Rol Rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoRol(int idRol) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        boolean exito;

        //Call del store procedure
        String stProcedure = "borradoLogicoRol(?)";

        try {

            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idRol);

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
    public Rol mostrarRol(int idRol) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        Rol rol = null;

        //Call del store procedure
        String stProcedure = "mostrarRol(?)";

        try {
            rol = new Rol();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idRol);

            rs = cstmt.executeQuery();

            rs.next();
            rol.setIdRol(rs.getInt("idRol"));
            rol.setNombre(rs.getString("nombre"));
            rol.setEstatus(rs.getInt("estatus"));
            conn.close();
            rs.close();
            cstmt.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            rol = null;
        }
        return rol;
    }

    @Override
    public List<Rol> mostrarRol() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        List<Rol> roles = null;

        try {

            roles = new ArrayList<>();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("mostrarListaRol()");
            rs = cstmt.executeQuery();
            Rol rol;

            while (rs.next()) {

                rol = new Rol();

                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombre(rs.getString("nombre"));
                rol.setEstatus(rs.getInt("estatus"));

                roles.add(rol);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            roles = null;
        }

        return roles;
    }

}
