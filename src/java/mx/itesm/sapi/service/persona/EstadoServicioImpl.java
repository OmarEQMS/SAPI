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
import mx.itesm.sapi.bean.persona.Estado;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class EstadoServicioImpl implements EstadoServicio {

    @Override
    public boolean borradoLogicoEstado(int idEstado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado mostrarEstado(int idEstado) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        Estado estado = null;

        //Call del store procedure
        String stProcedure = "mostrarEstado(?)";

        try {
            estado = new Estado();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEstado);

            rs = cstmt.executeQuery();

            rs.next();
            estado.setIdEstado(rs.getInt("idEstado"));
            estado.setNombre(rs.getString("nombre"));
            estado.setEstatus(rs.getInt("estatus"));
            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estado = null;
        }
        return estado;
    }

    @Override
    public List<Estado> mostrarEstado() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        List<Estado> estados = null;

        try {
            estados = new ArrayList<>();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL mostrarListaEstado()");
            rs = cstmt.executeQuery();
            Estado estado;

            while (rs.next()) {

                estado = new Estado();

                estado.setIdEstado(rs.getInt("idEstado"));
                estado.setNombre(rs.getString("nombre"));
                estado.setEstatus(rs.getInt("estatus"));

                estados.add(estado);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estados = null;
        }

        return estados;
    }

    @Override
    public int agregarEstado(Estado estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarEstado(Estado estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
