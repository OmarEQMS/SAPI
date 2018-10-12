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
import mx.itesm.sapi.bean.gestionPaciente.OtroMotivo;

/**
 *
 * @author urieldiaz
 */
public class OtroMotivoServicioImpl implements OtroMotivoServicio {

    @Override
    public OtroMotivo mostrarOtroMotivo(int idOtroMotivo) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        OtroMotivo otroMotivo = new OtroMotivo();

        String stProcedure = "";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();

            otroMotivo.setIdOtroMotivo(rs.getInt("idOtroMotivo"));
            otroMotivo.setIdCita(rs.getInt("idCita"));
            otroMotivo.setNombre(rs.getString("nombre"));
            otroMotivo.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            otroMotivo = null;
        }
        return otroMotivo;
    }

    @Override
    public List<OtroMotivo> mostrarOtroMotivo() {
        Connection conn;
        List<OtroMotivo> listotroMotivo = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure = "";

        ResultSet rs;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            OtroMotivo otroMotivo;

            while (rs.next()) {
                otroMotivo = new OtroMotivo();
                otroMotivo.setIdOtroMotivo(rs.getInt("idOtroMotivo"));
                otroMotivo.setIdCita(rs.getInt("idCita"));
                otroMotivo.setNombre(rs.getString("nombre"));
                otroMotivo.setEstatus(rs.getInt("estatus"));

                listotroMotivo.add(otroMotivo);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listotroMotivo = null;
        }
        return listotroMotivo;

    }

    @Override
    public int agregarOtroMotivo(OtroMotivo otroMotivo) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        String stPrcedure = "";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);

            cstmt.setInt(1, otroMotivo.getIdOtroMotivo());
            cstmt.setInt(2, otroMotivo.getIdCita());
            cstmt.setString(3, otroMotivo.getNombre());
            cstmt.setInt(4, otroMotivo.getEstatus());
            

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
    public boolean borradoLogicoOtroMotivo(int idOtroMotivo) {
       Connection conn; 
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito = false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idOtroMotivo);
            
            rs = cstmt.executeQuery();
            rs.next();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch( SQLException ex){
           
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito=false;
        }
        return exito;
    }

    @Override
    public boolean actualizarOtroMotivo(OtroMotivo otroMotivo) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito= false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, otroMotivo.getIdOtroMotivo());
            cstmt.setInt(2, otroMotivo.getIdCita());
            cstmt.setString(3, otroMotivo.getNombre());
            cstmt.setInt(4, otroMotivo.getEstatus() );
            
            
            rs = cstmt.executeQuery();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito=false;
        }
        return exito;

    }

}
