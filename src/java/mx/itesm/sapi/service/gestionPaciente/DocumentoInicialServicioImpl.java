/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicial;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicialVista;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class DocumentoInicialServicioImpl implements DocumentoInicialServicio{

    @Override
    public DocumentoInicial mostrarDocumentoInicial(int idDocumentoInicial) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarDocumentoInicial(?)";
        DocumentoInicial documentoInicial = null;
     
        try {
            conn = Conexion.getConnection();
            documentoInicial = new DocumentoInicial();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idDocumentoInicial);
                  
            rs = cstmt.executeQuery();
            rs.next();
            documentoInicial.setIdDocumentoInicial(rs.getInt("idDocumentoInicial"));
            documentoInicial.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
            documentoInicial.setIdPaciente(rs.getInt("idPaciente"));
            documentoInicial.setArchivo(rs.getBinaryStream("archivo"));
            documentoInicial.setComentario(rs.getString("comentario"));
            documentoInicial.setAprobado(rs.getInt("aprobado"));
            documentoInicial.setTipo(rs.getString("tipo"));
            documentoInicial.setNombre(rs.getString("nombre"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           documentoInicial = null;
        }   
        return documentoInicial;
    }

    @Override
    public List<DocumentoInicial> mostrarDocumentoInicial() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarDocumentoInicial()";
        List<DocumentoInicial> documentosIniciales = null;
        DocumentoInicial documentoInicial;

        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            documentosIniciales =  new ArrayList<>();
            
            while(rs.next()){
                documentoInicial = new DocumentoInicial();
                documentoInicial.setIdDocumentoInicial(rs.getInt("idDocumentoInicial"));
                documentoInicial.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
                documentoInicial.setIdPaciente(rs.getInt("idPaciente"));
                documentoInicial.setArchivo(rs.getBinaryStream("archivo"));
                documentoInicial.setComentario(rs.getString("comentario"));
                documentoInicial.setAprobado(rs.getInt("aprobado"));

                documentosIniciales.add(documentoInicial);
            }
		
		conn.close();
		cstmt.close();
		rs.close();

        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            documentosIniciales = null;
	}
        return documentosIniciales;
    }

    @Override
    public int agregarDocumentoInicial(DocumentoInicial documentoInicial) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL agregarDocumentoInicial(?, ?, ?, ?, ?)";
        int id = -1;

        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,documentoInicial.getIdTipoDocumento());
            cstmt.setInt(2,documentoInicial.getIdPaciente());
            cstmt.setBinaryStream(3,documentoInicial.getArchivo());
            cstmt.setString(4,documentoInicial.getComentario());
            cstmt.setInt(5,documentoInicial.getAprobado());
            
            rs = cstmt.executeQuery();
            rs.next();
            
            id = rs.getInt(1);
                
            conn.close();
            cstmt.close();
            rs.close();

        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
        }
        return id;
    }

    @Override
    public boolean borradoLogicoDocumentoInicial(int idDocumentoInicial) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL borradoLogicoDocumentoInicial(?)";
        boolean exito = false;

        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, idDocumentoInicial);
            
            rs = cstmt.executeQuery();
            rs.next();
            exito  = rs.getBoolean(1);
            
            rs.close();
            conn.close();
            cstmt.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

    @Override
    public boolean actualizarDocumentoInicial(DocumentoInicial documentoInicial) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL actualizarDocumentoInicial(?, ?, ?, ?, ?)";
        boolean exito = false;
        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,documentoInicial.getIdTipoDocumento());
            cstmt.setInt(2,documentoInicial.getIdPaciente());
            cstmt.setBinaryStream(3,documentoInicial.getArchivo());
            cstmt.setString(4,documentoInicial.getComentario());
            cstmt.setInt(5,documentoInicial.getAprobado());
            
            rs = cstmt.executeQuery();
            rs.next();
            exito = rs.getBoolean(1);
            
            rs.close();
            conn.close();
            cstmt.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

    @Override
    public int agregarDocumentoInicialPreconsulta(DocumentoInicial documentoInicial) {                                        
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        String stProcedure = "CALL agregarDocumentoInicialPreconsulta(?,?,?,?,?,?);";

        int id;

        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,documentoInicial.getIdTipoDocumento());
            cstmt.setInt(2,documentoInicial.getIdPaciente());            
            cstmt.setBinaryStream(3,documentoInicial.getArchivo());
            cstmt.setString(4,documentoInicial.getTipo());
            cstmt.setInt(5,documentoInicial.getTamano());
            cstmt.setString(6, documentoInicial.getNombre());            
                     
            
            rs = cstmt.executeQuery();
            rs.next();
            
            id = rs.getInt(1);
                
            conn.close();
            cstmt.close();
            rs.close();

        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
        }
        return id;
                
    }

    @Override
    public DocumentoInicial mostrarDocumentoInicialIdPaciente(int idPaciente) {
    Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarDocumentoInicial(?)";
        DocumentoInicial documentoInicial = null;
     
        try {
            conn = Conexion.getConnection();
            documentoInicial = new DocumentoInicial();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);
                  
            rs = cstmt.executeQuery();
            rs.next();
            documentoInicial.setIdDocumentoInicial(rs.getInt("idDocumentoInicial"));
            documentoInicial.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
            documentoInicial.setIdPaciente(rs.getInt("idPaciente"));
                documentoInicial.setArchivo(rs.getBinaryStream("archivo"));
            documentoInicial.setComentario(rs.getString("comentario"));
            documentoInicial.setAprobado(rs.getInt("aprobado"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           documentoInicial = null;
        }   
        return documentoInicial;   
    }

    @Override
    public DocumentoInicialVista mostrarDocumentoInicialVista(int idDocumentoInicialVista,int idPaciente, int siguiente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarDocumentoInicialVerDocumento(?,?,?)";
        DocumentoInicialVista documentoInicial = null;
     
        try {
            conn = Conexion.getConnection();
            documentoInicial = new DocumentoInicialVista();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idDocumentoInicialVista);
            cstmt.setInt(2, idPaciente);
            cstmt.setInt(3, siguiente);
                  
            rs = cstmt.executeQuery();
            rs.next();
            documentoInicial.setIdDocumentoInicial(rs.getInt("idDocumentoInicial"));
            documentoInicial.setTipoDocumento(rs.getString("TipoDocumento"));
            documentoInicial.setTipoArchivo(rs.getString("tipo"));  
            documentoInicial.setNombreDocumento(rs.getString("nombre"));
            documentoInicial.setArchivo(rs.getBinaryStream("archivo"));
            documentoInicial.setAprobado(rs.getInt("aprobado"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           documentoInicial = null;
        }   
        return documentoInicial;   
    }

    @Override
    public boolean agregarAprobacionDocumento(int idDocumentoInicial) {
                               
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL agregarAprobacionDocumento(?)";
        boolean respuesta = false;
     
        try {
            conn = Conexion.getConnection();
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idDocumentoInicial);
            
                  
            rs = cstmt.executeQuery();
            rs.next();
            respuesta = (rs.getInt("CAMBIO") == 1);
           
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           respuesta = false;
        }   
        return respuesta;   
    }

    @Override
    public boolean agregarRechazoDocumento(int idDocumentoInicial,String comentario) {
                                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL agregarRechazoDocumento(?,?)";
        boolean respuesta = false;
     
        try {
            conn = Conexion.getConnection();
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idDocumentoInicial);
            cstmt.setString(2, comentario);
            
                  
            rs = cstmt.executeQuery();
            rs.next();
            respuesta = (rs.getInt("CAMBIO") == 0);
           
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           respuesta = false;
        }   
        return respuesta;   
        
        
    }
    
}
