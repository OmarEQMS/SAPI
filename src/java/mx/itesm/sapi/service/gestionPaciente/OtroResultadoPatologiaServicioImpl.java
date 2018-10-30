/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.OtroResultadoPatologia;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class OtroResultadoPatologiaServicioImpl implements OtroResultadoPatologiaServicio {

    @Override
    public OtroResultadoPatologia mostrarOtroResultadoPatologia(int idOtroResultadoPatologia) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarOtroResultadoPatologia(?)";
        OtroResultadoPatologia otroResultadoPatologia = null;

        try {
            conn = Conexion.getConnection();
            otroResultadoPatologia = new OtroResultadoPatologia();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idOtroResultadoPatologia);

            rs = cstmt.executeQuery();
            rs.next();

            otroResultadoPatologia.setIdOtroResultadoPatologia(rs.getInt("idOtroResultadoPatologia"));
            otroResultadoPatologia.setIdBiopsia(rs.getInt("idBiopsia"));
            otroResultadoPatologia.setNombre(rs.getString("nombre"));

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            otroResultadoPatologia = null;
        }
        return otroResultadoPatologia;
    }

    @Override
    public List<OtroResultadoPatologia> mostrarOtroResultadoPatologia() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarOtroResultadoPatologia";
        List<OtroResultadoPatologia> otroResultadoPatologias = null;
        OtroResultadoPatologia otroResultadoPatologia;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            otroResultadoPatologias = new ArrayList<>();

            while (rs.next()) {
                otroResultadoPatologia = new OtroResultadoPatologia();
                otroResultadoPatologia.setIdOtroResultadoPatologia(rs.getInt("idOtroResultadoPatologia"));
                otroResultadoPatologia.setIdBiopsia(rs.getInt("idBiopsia"));
                otroResultadoPatologia.setNombre(rs.getString("nombre"));

                otroResultadoPatologias.add(otroResultadoPatologia);
            }

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            otroResultadoPatologias = null;
        }
        return otroResultadoPatologias;
    }

    @Override
    public int agregarOtroResultadoPatologia(OtroResultadoPatologia otroResultadoPatologia) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        int id = -1;
        //Aquí va el call del procedure
        String stProcedure = "CALL agregarOtroResultadoPatologia(?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, otroResultadoPatologia.getIdOtroResultadoPatologia());
            cstmt.setInt(2, otroResultadoPatologia.getIdBiopsia());
            cstmt.setString(3, otroResultadoPatologia.getNombre());

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
    public boolean borradoLogicoOtroResultadoPatologia(int idOtroResultadoPatologia) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL borradoLogicoOtroResultadoPatologia(?)";
        boolean exito = false;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idOtroResultadoPatologia);

            rs = cstmt.executeQuery();
            rs.next();
            exito = rs.getBoolean(1);

            rs.close();
            conn.close();
            cstmt.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

    @Override
    public boolean actualizarOtroResultadoPatologia(OtroResultadoPatologia otroResultadoPatologia) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        boolean exito = false;

        //Call del store procedure
        String stProcedure = "actualizarOtroResultadoPatologia(?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, otroResultadoPatologia.getIdOtroResultadoPatologia());
            cstmt.setInt(2, otroResultadoPatologia.getIdBiopsia());
            cstmt.setString(3, otroResultadoPatologia.getNombre());

            rs = cstmt.executeQuery();

            rs.next();

            exito = rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;

    }

}
