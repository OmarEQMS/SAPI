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
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.Posicion;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author feror
 */
public class PosicionServicioImpl implements PosicionServicio {

    @Override
    public Posicion mostrarPosicion(int idPosicion) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        Posicion posicion = new Posicion();

        //Call del store procedure
        String stProcedure = "CALL estado(?)";

        try {

            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idPosicion);

            ResultSet rs = cstmt.executeQuery();

            rs.next();
            posicion.setIdPosicion(rs.getInt(1));
            posicion.setNombre(rs.getString(2));
            posicion.setEstatus(rs.getInt(3));

            return posicion;
        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de mostrarPosicion");
            System.out.println(ex.getMessage());
            return posicion;
        }
    }

    @Override
    public List<Posicion> mostrarPosicion() {
        Connection conn = Conexion.getConnection();

        List<Posicion> posiciones = new ArrayList<>();

        try {

            CallableStatement cstmt;
            cstmt = conn.prepareCall("");
            ResultSet rs = cstmt.executeQuery();
            Posicion posicion;

            while (rs.next()) {

                posicion = new Posicion();

                posicion.setIdPosicion(rs.getInt(1));
                posicion.setNombre(rs.getString(2));
                posicion.setEstatus(rs.getInt(3));

                posiciones.add(posicion);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("ERROR GET POSICIONES" + e.getMessage());
        }

        return posiciones;
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
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.Posicion;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author feror
 */
public class PosicionServicioImpl implements PosicionServicio {

    @Override
    public Posicion mostrarPosicion(int idPosicion) {
        Connection conn = Conexion.getConnection();

        CallableStatement cstmt;

        Posicion posicion = new Posicion();

        //Call del store procedure
        String stProcedure = "CALL estado(?)";

        try {

            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idPosicion);

            ResultSet rs = cstmt.executeQuery();

            rs.next();
            posicion.setIdPosicion(rs.getInt(1));
            posicion.setNombre(rs.getString(2));
            posicion.setEstatus(rs.getInt(3));

            return posicion;
        } catch (SQLException ex) {

            System.out.println("Estoy en el catch de mostrarPosicion");
            System.out.println(ex.getMessage());
            return posicion;
        }
    }

    @Override
    public List<Posicion> mostrarPosicion() {
        Connection conn = Conexion.getConnection();

        List<Posicion> posiciones = new ArrayList<>();

        try {

            CallableStatement cstmt;
            cstmt = conn.prepareCall("");
            ResultSet rs = cstmt.executeQuery();
            Posicion posicion;

            while (rs.next()) {

                posicion = new Posicion();

                posicion.setIdPosicion(rs.getInt(1));
                posicion.setNombre(rs.getString(2));
                posicion.setEstatus(rs.getInt(3));

                posiciones.add(posicion);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("ERROR GET POSICIONES" + e.getMessage());
        }

        return posiciones;
    }

}
>>>>>>> Login
