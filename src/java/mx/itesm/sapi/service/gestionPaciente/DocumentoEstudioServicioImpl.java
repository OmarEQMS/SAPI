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
import mx.itesm.sapi.bean.gestionPaciente.DocumentoEstudio;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class DocumentoEstudioServicioImpl implements DocumentoEstudioServicio {

    @Override
    public DocumentoEstudio mostrarDocumentoEstudio(int idDocumentoEstudio) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarDocumentoEstudio(?)";
        DocumentoEstudio documentoEstudio = null;

        try {
            conn = Conexion.getConnection();
            documentoEstudio = new DocumentoEstudio();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idDocumentoEstudio);

            rs = cstmt.executeQuery();
            rs.next();

            documentoEstudio.setIdDocumentoEstudio(rs.getInt("idDocumentoEstudio"));
            documentoEstudio.setIdEstudio(rs.getInt("idEstudio"));
            documentoEstudio.setIdEstadoEstudio(rs.getInt("idEstadoEstudio"));
            documentoEstudio.setIdPaciente(rs.getInt("idPaciente"));
            documentoEstudio.setIdBirads(rs.getInt("idBirads"));
            documentoEstudio.setArchivo(rs.getBytes("archivo"));
            documentoEstudio.setPrevio(rs.getInt("previo"));
            documentoEstudio.setFechaEstudioPrevio(rs.getDate("fechEstudioPrevio"));

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            documentoEstudio = null;
        }
        return documentoEstudio;
    }

    @Override
    public List<DocumentoEstudio> mostrarDocumentoEstudio() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarDocumentoEstudio()";
        List<DocumentoEstudio> documentoEstudios = null;
        DocumentoEstudio documentoEstudio;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            documentoEstudios = new ArrayList<>();

            while (rs.next()) {
                documentoEstudio = new DocumentoEstudio();

                documentoEstudio.setIdDocumentoEstudio(rs.getInt("idDocumentoEstudio"));
                documentoEstudio.setIdEstudio(rs.getInt("idEstudio"));
                documentoEstudio.setIdEstadoEstudio(rs.getInt("idEstadoEstudio"));
                documentoEstudio.setIdPaciente(rs.getInt("idPaciente"));
                documentoEstudio.setIdBirads(rs.getInt("idBirads"));
                documentoEstudio.setArchivo(rs.getBytes("archivo"));
                documentoEstudio.setPrevio(rs.getInt("previo"));
                documentoEstudio.setFechaEstudioPrevio(rs.getDate("fechEstudioPrevio"));

                documentoEstudios.add(documentoEstudio);
            }

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            documentoEstudios = null;
        }
        return documentoEstudios;
    }

    @Override
    public int agregarDocumentoEstudio(DocumentoEstudio documentoEstudio) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL agregarDocumentoEstudio(?,?,?,?,?,?,?)";
        int id = -1;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, documentoEstudio.getIdEstudio());
            cstmt.setInt(2, documentoEstudio.getIdEstadoEstudio());
            cstmt.setInt(3, documentoEstudio.getIdPaciente());
            cstmt.setInt(4, documentoEstudio.getIdBirads());
            cstmt.setBytes(5, documentoEstudio.getArchivo());
            cstmt.setInt(6, documentoEstudio.getPrevio());
            cstmt.setDate(7, documentoEstudio.getFechaEstudioPrevio());

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
    public boolean borradoLogicoDocumentoEstudio(int idDocumentoEstudio) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL borradoLogicoDocumentoEstudio(?)";
        boolean exito = false;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idDocumentoEstudio);

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
    public boolean actualizarDocumentoEstudio(DocumentoEstudio documentoEstudio) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL actualizarDocumentoEstudio(?,?,?,?,?,?,?)";
        boolean exito = false;
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, documentoEstudio.getIdEstudio());
            cstmt.setInt(2, documentoEstudio.getIdEstadoEstudio());
            cstmt.setInt(3, documentoEstudio.getIdPaciente());
            cstmt.setInt(4, documentoEstudio.getIdBirads());
            cstmt.setBytes(5, documentoEstudio.getArchivo());
            cstmt.setInt(6, documentoEstudio.getPrevio());
            cstmt.setDate(7, documentoEstudio.getFechaEstudioPrevio());

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
    public DocumentoEstudio mostrarDocumentoEstudioIdPaciente(int idPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarDocumentoEstudioIdPaciente(?)";
        DocumentoEstudio documentoEstudio = null;

        try {
            conn = Conexion.getConnection();
            documentoEstudio = new DocumentoEstudio();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);

            rs = cstmt.executeQuery();
            rs.next();

            documentoEstudio.setIdDocumentoEstudio(rs.getInt("idDocumentoEstudio"));
            documentoEstudio.setIdEstudio(rs.getInt("idEstudio"));
            documentoEstudio.setIdEstadoEstudio(rs.getInt("idEstadoEstudio"));
            documentoEstudio.setIdPaciente(rs.getInt("idPaciente"));
            documentoEstudio.setIdBirads(rs.getInt("idBirads"));
            documentoEstudio.setArchivo(rs.getBytes("archivo"));
            documentoEstudio.setPrevio(rs.getInt("previo"));
            documentoEstudio.setFechaEstudioPrevio(rs.getDate("fechEstudioPrevio"));

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            documentoEstudio = null;
        }
        return documentoEstudio;
    }

    @Override
    public List<DocumentoEstudio> mostrarDocumentoEstudioIdEspecifico(int idPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarDocumentoEstudioIdEspecifico(?)";
        List<DocumentoEstudio> documentoEstudios = null;
        DocumentoEstudio documentoEstudio;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();
            documentoEstudios = new ArrayList<>();

            while (rs.next()) {
                documentoEstudio = new DocumentoEstudio();

                documentoEstudio.setIdDocumentoEstudio(rs.getInt("idDocumentoEstudio"));
                documentoEstudio.setIdEstudio(rs.getInt("idEstudio"));
                documentoEstudio.setIdEstadoEstudio(rs.getInt("idEstadoEstudio"));
                documentoEstudio.setIdPaciente(rs.getInt("idPaciente"));
                documentoEstudio.setIdBirads(rs.getInt("idBirads"));
                documentoEstudio.setArchivo(rs.getBytes("archivo"));
                documentoEstudio.setPrevio(rs.getInt("previo"));
                documentoEstudio.setFechaEstudioPrevio(rs.getDate("fechEstudioPrevio"));

                documentoEstudios.add(documentoEstudio);
            }

            conn.close();
            cstmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            documentoEstudios = null;
        }
        return documentoEstudios;
    }

}
