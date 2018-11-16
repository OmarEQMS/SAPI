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
import mx.itesm.sapi.bean.gestionPaciente.Biopsia;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class BiopsiaServicioImpl implements BiopsiaServicio {

    @Override
    public Biopsia mostrarBiopsia(int idBiopsia) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarBiopsia(?)";
        Biopsia biopsia = null;

        try {
            conn = Conexion.getConnection();
            biopsia = new Biopsia();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idBiopsia);

            rs = cstmt.executeQuery();
            rs.next();
            biopsia.setIdBiopsia(rs.getInt("idBiopsia"));
            biopsia.setIdPaciente(rs.getInt("idPaciente"));
            biopsia.setIdLugarDelCuerpo(rs.getInt("idLugarDelCuerpo"));
            biopsia.setIdHer2(rs.getInt("idHer2"));
            biopsia.setIdReceptorProgesterona(rs.getInt("idReceptorProgesterona"));
            biopsia.setIdReceptorEstrogeno(rs.getInt("idReceptorEstrogeno"));
            biopsia.setIdFish(rs.getInt("idFish"));
            biopsia.setIdKi67(rs.getInt("idKi67"));
            biopsia.setIdTipoHistologico(rs.getInt("idTipoHistologico"));
            biopsia.setIdGradoHistologico(rs.getInt("idGradoHistologico"));
            biopsia.setLaminillas(rs.getInt("laminillas"));
            biopsia.setBloques(rs.getInt("bloques"));
            biopsia.setPrevia(rs.getInt("previa"));
            biopsia.setEstatus(rs.getInt("estatus"));
            biopsia.setIdTipoBiopsia(rs.getInt("idTipoBiopsia"));

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            biopsia = null;
        }
        return biopsia;
    }

    @Override
    public List<Biopsia> mostrarAllBiopsia() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarListaBiopsia()";
        List<Biopsia> biopsias = null;
        Biopsia biopsia;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            biopsias = new ArrayList<>();

            while (rs.next()) {
                biopsia = new Biopsia();
                biopsia.setIdBiopsia(rs.getInt("idBiopsia"));
                biopsia.setIdPaciente(rs.getInt("idPaciente"));
                biopsia.setIdLugarDelCuerpo(rs.getInt("idLugarDelCuerpo"));
                biopsia.setIdHer2(rs.getInt("idHer2"));
                biopsia.setIdReceptorProgesterona(rs.getInt("idReceptorProgesterona"));
                biopsia.setIdReceptorEstrogeno(rs.getInt("idReceptorEstrogeno"));
                biopsia.setIdFish(rs.getInt("idFish"));
                biopsia.setIdKi67(rs.getInt("idKi67"));
                biopsia.setIdTipoHistologico(rs.getInt("idTipoHistologico"));
                biopsia.setIdGradoHistologico(rs.getInt("idGradoHistologico"));
                biopsia.setLaminillas(rs.getInt("laminillas"));
                biopsia.setBloques(rs.getInt("bloques"));
                biopsia.setPrevia(rs.getInt("previa"));
                biopsia.setEstatus(rs.getInt("estatus"));
                biopsia.setIdTipoBiopsia(rs.getInt("idTipoBiopsia"));

                biopsias.add(biopsia);
            }

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            biopsias = null;
        }
        return biopsias;
    }

    @Override
    public int agregarBiopsia(Biopsia biopsia) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL agregarBiopsia(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int id = -1;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, biopsia.getIdPaciente());
            cstmt.setInt(2, biopsia.getIdLugarDelCuerpo());
            cstmt.setInt(3, biopsia.getIdHer2());
            cstmt.setInt(4, biopsia.getIdReceptorProgesterona());
            cstmt.setInt(5, biopsia.getIdReceptorEstrogeno());
            cstmt.setInt(6, biopsia.getIdFish());
            cstmt.setInt(7, biopsia.getIdKi67());
            cstmt.setInt(8, biopsia.getIdTipoHistologico());
            cstmt.setInt(9, biopsia.getIdGradoHistologico());
            cstmt.setInt(10, biopsia.getLaminillas());
            cstmt.setInt(11, biopsia.getBloques());
            cstmt.setInt(12, biopsia.getPrevia());
            cstmt.setInt(13, biopsia.getEstatus());
            cstmt.setInt(14, biopsia.getIdTipoBiopsia());

            rs = cstmt.executeQuery();
            rs.next();
            id = rs.getInt(1);

            conn.close();
            cstmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
        }
        return id;
    }

    @Override
    public boolean borradoLogicoBiopsia(int idBiopsia) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL borradoLogicoBiopsia(?)";
        boolean exito = false;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idBiopsia);

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
    public boolean actualizarBiopsia(Biopsia biopsia) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL actualizarBiopsia(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        boolean exito = false;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, biopsia.getIdPaciente());
            cstmt.setInt(2, biopsia.getIdLugarDelCuerpo());
            cstmt.setInt(3, biopsia.getIdHer2());
            cstmt.setInt(4, biopsia.getIdReceptorProgesterona());
            cstmt.setInt(5, biopsia.getIdReceptorEstrogeno());
            cstmt.setInt(6, biopsia.getIdFish());
            cstmt.setInt(7, biopsia.getIdKi67());
            cstmt.setInt(8, biopsia.getIdTipoHistologico());
            cstmt.setInt(9, biopsia.getIdGradoHistologico());
            cstmt.setInt(10, biopsia.getLaminillas());
            cstmt.setInt(11, biopsia.getBloques());
            cstmt.setInt(12, biopsia.getPrevia());
            cstmt.setInt(13, biopsia.getEstatus());
            cstmt.setInt(14, biopsia.getIdTipoBiopsia());

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
    public Biopsia mostrarBiopsiaIdPaciente(int idPaciente) {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarBiopsiaIdPaciente(?)";
        Biopsia biopsia = null;

        try {
            conn = Conexion.getConnection();
            biopsia = new Biopsia();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);

            rs = cstmt.executeQuery();
            rs.next();
            biopsia.setIdBiopsia(rs.getInt("idBiopsia"));
            biopsia.setIdPaciente(rs.getInt("idPaciente"));
            biopsia.setIdLugarDelCuerpo(rs.getInt("idLugarDelCuerpo"));
            biopsia.setIdHer2(rs.getInt("idHer2"));
            biopsia.setIdReceptorProgesterona(rs.getInt("idReceptorProgesterona"));
            biopsia.setIdReceptorEstrogeno(rs.getInt("idReceptorEstrogeno"));
            biopsia.setIdFish(rs.getInt("idFish"));
            biopsia.setIdKi67(rs.getInt("idKi67"));
            biopsia.setIdTipoHistologico(rs.getInt("idTipoHistologico"));
            biopsia.setIdGradoHistologico(rs.getInt("idGradoHistologico"));
            biopsia.setLaminillas(rs.getInt("laminillas"));
            biopsia.setBloques(rs.getInt("bloques"));
            biopsia.setPrevia(rs.getInt("previa"));
            biopsia.setEstatus(rs.getInt("estatus"));
            biopsia.setIdTipoBiopsia(rs.getInt("idTipoBiopsia"));

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            biopsia = null;
        }
        return biopsia;
    }
    
    @Override
    public Biopsia mostrarBiopsiaPreviaPaciente(int idPaciente, int previo) {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarBiopsiaPreviaPaciente(?)";
        Biopsia biopsia = null;

        try {
            conn = Conexion.getConnection();
            biopsia = new Biopsia();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);

            rs = cstmt.executeQuery();
            rs.next();
            biopsia.setIdBiopsia(rs.getInt("idBiopsia"));
            biopsia.setIdPaciente(rs.getInt("idPaciente"));
            biopsia.setIdLugarDelCuerpo(rs.getInt("idLugarDelCuerpo"));
            biopsia.setIdHer2(rs.getInt("idHer2"));
            biopsia.setIdReceptorProgesterona(rs.getInt("idReceptorProgesterona"));
            biopsia.setIdReceptorEstrogeno(rs.getInt("idReceptorEstrogeno"));
            biopsia.setIdFish(rs.getInt("idFish"));
            biopsia.setIdKi67(rs.getInt("idKi67"));
            biopsia.setIdTipoHistologico(rs.getInt("idTipoHistologico"));
            biopsia.setIdGradoHistologico(rs.getInt("idGradoHistologico"));
            biopsia.setLaminillas(rs.getInt("laminillas"));
            biopsia.setBloques(rs.getInt("bloques"));
            biopsia.setPrevia(rs.getInt("previa"));
            biopsia.setEstatus(rs.getInt("estatus"));
            biopsia.setIdTipoBiopsia(rs.getInt("idTipoBiopsia"));

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            biopsia = null;
        }
        return biopsia;
    }

    @Override
    public List<Biopsia> mostrarAllBiopsiaIdEspecifico(int idPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarAllBiopsiaIdEspecifico(?)";
        List<Biopsia> biopsias = null;
        Biopsia biopsia;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();
            biopsias = new ArrayList<>();

            while (rs.next()) {
                biopsia = new Biopsia();
                biopsia.setIdBiopsia(rs.getInt("idBiopsia"));
                biopsia.setIdPaciente(rs.getInt("idPaciente"));
                biopsia.setIdLugarDelCuerpo(rs.getInt("idLugarDelCuerpo"));
                biopsia.setIdHer2(rs.getInt("idHer2"));
                biopsia.setIdReceptorProgesterona(rs.getInt("idReceptorProgesterona"));
                biopsia.setIdReceptorEstrogeno(rs.getInt("idReceptorEstrogeno"));
                biopsia.setIdFish(rs.getInt("idFish"));
                biopsia.setIdKi67(rs.getInt("idKi67"));
                biopsia.setIdTipoHistologico(rs.getInt("idTipoHistologico"));
                biopsia.setIdGradoHistologico(rs.getInt("idGradoHistologico"));
                biopsia.setLaminillas(rs.getInt("laminillas"));
                biopsia.setBloques(rs.getInt("bloques"));
                biopsia.setPrevia(rs.getInt("previa"));
                biopsia.setEstatus(rs.getInt("estatus"));
                biopsia.setIdTipoBiopsia(rs.getInt("idTipoBiopsia"));

                biopsias.add(biopsia);
            }

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            biopsias = null;
        }
        return biopsias;
    }

}
