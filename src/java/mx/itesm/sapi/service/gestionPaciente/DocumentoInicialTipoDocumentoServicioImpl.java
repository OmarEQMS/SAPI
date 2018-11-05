/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicialTipoDocumento;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Admin
 */
public class DocumentoInicialTipoDocumentoServicioImpl implements DocumentoInicialTipoDocumentoServicio {

    @Override
    public List<DocumentoInicialTipoDocumento> mostrarDocumentoInicialTipoDocumento(int idPaciente) {
         Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        List<DocumentoInicialTipoDocumento> documentoInicialTipoDocumentos = null;

        //Call del stored procedure
        String stProcedure = "CALL mostrarDocumentoInicialTipoDocumento(?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            documentoInicialTipoDocumentos = new ArrayList<>();

            cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();
            DocumentoInicialTipoDocumento documentoInicialTipoDocumento;

            while (rs.next()) {
                documentoInicialTipoDocumento = new DocumentoInicialTipoDocumento();
                documentoInicialTipoDocumento.setIdDocumentoInicial(rs.getInt("idDocumentoInicial"));
                documentoInicialTipoDocumento.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
                documentoInicialTipoDocumento.setIdPaciente(rs.getInt("idPaciente"));
                documentoInicialTipoDocumento.setNombreDocumento(rs.getString("nombreDocumento"));
                documentoInicialTipoDocumento.setNombreTipo(rs.getString("nombreTipo"));
                documentoInicialTipoDocumento.setComentario(rs.getString("comentario"));
                documentoInicialTipoDocumento.setArchivo(rs.getBinaryStream("archivo"));
                documentoInicialTipoDocumento.setAprobado(rs.getInt("aprobado"));
               
                
                documentoInicialTipoDocumentos.add(documentoInicialTipoDocumento);
            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            documentoInicialTipoDocumentos = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return documentoInicialTipoDocumentos;
    }
    

   
 @Override
    public DocumentoInicialTipoDocumento descargarArchivo(int idArchivo) {
         Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        DocumentoInicialTipoDocumento documentoInicialTipoDocumento = null;

        //Call del stored procedure
        String stProcedure = "CALL descargarArchivo(?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
           

            cstmt.setInt(1, idArchivo);
            rs = cstmt.executeQuery();

            while (rs.next()) {
                documentoInicialTipoDocumento = new DocumentoInicialTipoDocumento();
                documentoInicialTipoDocumento.setIdDocumentoInicial(rs.getInt("idDocumentoInicial"));
                documentoInicialTipoDocumento.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
                documentoInicialTipoDocumento.setIdPaciente(rs.getInt("idPaciente"));
                documentoInicialTipoDocumento.setNombreDocumento(rs.getString("nombreDocumento"));
                documentoInicialTipoDocumento.setNombreTipo(rs.getString("nombreTipo"));
                documentoInicialTipoDocumento.setComentario(rs.getString("comentario"));
                documentoInicialTipoDocumento.setArchivo(rs.getBinaryStream("archivo"));
                documentoInicialTipoDocumento.setAprobado(rs.getInt("aprobado"));
              
            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            documentoInicialTipoDocumento = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return documentoInicialTipoDocumento;
    }
    
    
}
