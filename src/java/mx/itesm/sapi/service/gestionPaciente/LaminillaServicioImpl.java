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
import mx.itesm.sapi.util.Conexion;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Laminilla;

/**
 *
 * @author Alexis España
 */
public class LaminillaServicioImpl implements LaminillaServicio {

    
    @Override
    public Laminilla mostrarLaminillaPaciente(int idPaciente){
    
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        Laminilla laminilla = new Laminilla();

        String stProcedure = "mostrarLaminillaPaciente(?)";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();
            rs.next();

            laminilla.setIdLaminilla(rs.getInt("idLaminilla"));
            laminilla.setIdBiopsia(rs.getInt("idBiopsia"));
            laminilla.setNombre(rs.getString("serie"));
            laminilla.setEstatus(rs.getInt("estatus"));
            laminilla.setCantidad(rs.getInt("cantidad"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            laminilla = null;
        }
        return laminilla;
   
    }
    
    @Override
    public Laminilla mostrarLaminilla(int idLaminilla) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        Laminilla laminilla = new Laminilla();

        String stProcedure = "";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();

            laminilla.setIdLaminilla(rs.getInt("idLaminilla"));
            laminilla.setIdBiopsia(rs.getInt("idBiopsia"));
            laminilla.setNombre(rs.getString("serie"));
            laminilla.setEstatus(rs.getInt("estatus"));
            laminilla.setCantidad(rs.getInt("cantidad"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            laminilla = null;
        }
        return laminilla;
    }

    @Override
    public List<Laminilla> mostrarLaminilla() {
        Connection conn;
        List<Laminilla> laminillas = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure = "";

        ResultSet rs;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            Laminilla laminilla;

            while (rs.next()) {
                laminilla = new Laminilla();

                laminilla.setIdLaminilla(rs.getInt("idLaminilla"));
                laminilla.setIdBiopsia(rs.getInt("idBiopsia"));
                laminilla.setNombre(rs.getString("nombre"));
                laminilla.setEstatus(rs.getInt("estatus"));
                laminilla.setCantidad(rs.getInt("cantidad"));

                laminillas.add(laminilla);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            laminillas = null;
        }
        return laminillas;
    }

    @Override
    public int agregarLaminilla(Laminilla laminilla) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        String stPrcedure = "";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);

            cstmt.setInt(1, laminilla.getIdLaminilla());
            cstmt.setInt(2, laminilla.getIdBiopsia());
            cstmt.setString(3, laminilla.getNombre());
            cstmt.setInt(4, laminilla.getEstatus());
            cstmt.setInt(5, laminilla.getCantidad());

            cstmt.executeUpdate();
            rs = cstmt.getGeneratedKeys();
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
    public boolean actualizarLaminilla(Laminilla laminilla) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito = false;
        ResultSet rs;
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, laminilla.getIdLaminilla());
            cstmt.setInt(2, laminilla.getIdBiopsia());
            cstmt.setString(3, laminilla.getNombre());
            cstmt.setInt(4, laminilla.getEstatus());
            cstmt.setInt(5, laminilla.getCantidad());

            rs = cstmt.executeQuery();

            exito = rs.getBoolean(1);

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

    @Override
    public boolean borradoLogicoLaminilla(int idLaminilla) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito = false;
        ResultSet rs;
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idLaminilla);

            rs = cstmt.executeQuery();
            rs.next();

            exito = rs.getBoolean(1);

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;

    }
    
    
}
