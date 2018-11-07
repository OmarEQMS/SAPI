/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.diagnostico;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.diagnostico.EstadiajeTNM;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Diego
 */
public class EstadiajeTNMServiceImpl implements EstadiajeTNMService{

    @Override
    public int agregarEstadiajeTNM(EstadiajeTNM estadiajeTNM) {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        int id = -1;
        
        //Aquí va el call del procedure
        String stProcedure="CALL agregarEstadiajeTNM(?, ?, ?, ?, ? ,?)";
        
        try {
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            
            cstmt.setInt(1, estadiajeTNM.getIdTCodificado());
            cstmt.setInt(2, estadiajeTNM.getIdNCodificado());
            cstmt.setInt(3, estadiajeTNM.getIdMCodificado());
            cstmt.setDouble(4, estadiajeTNM.gettClinico());
            cstmt.setDouble(5, estadiajeTNM.gettImagen());
            cstmt.setInt(6, estadiajeTNM.getMetastasis());
            
            
            cstmt.executeQuery();
            
            rs = cstmt.getGeneratedKeys();
            rs.next();
            
            id = rs.getInt(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            id = -1;
            System.out.println("IdRegistroTNM: " + estadiajeTNM.getIdRegistroTNM());
            System.out.println("IdTCodificado: " + estadiajeTNM.getIdTCodificado());
            System.out.println("IdNCodificado: " + estadiajeTNM.getIdNCodificado());
            System.out.println("IdMCodificado: " + estadiajeTNM.getIdMCodificado());
            System.out.println("tClinico: " + estadiajeTNM.gettClinico());
            System.out.println("tImagen: " + estadiajeTNM.gettImagen());
            System.out.println("Metastasis: " + estadiajeTNM.getMetastasis());
            System.out.println("Estatus: " + estadiajeTNM.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return id;
    }

    @Override
    public EstadiajeTNM mostrarEstadiajeTNM(int idRegistroTNM) {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        EstadiajeTNM estadiajeTNM = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarEstadiajeTNM(?)";
        
        try {    
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            estadiajeTNM = new EstadiajeTNM();
            
            cstmt.setInt(1, idRegistroTNM);
            rs = cstmt.executeQuery();
            
            // Asignación de valores devuletos a estadiajeTNM
            rs.next();
            estadiajeTNM.setIdRegistroTNM(rs.getInt("idAuditoriaRegistroDiagnostico"));
            estadiajeTNM.setIdTCodificado(rs.getInt("idTCodificado"));
            estadiajeTNM.setIdNCodificado(rs.getInt("idNCodificado"));
            estadiajeTNM.setIdMCodificado(rs.getInt("idMCodificado"));
            estadiajeTNM.settClinico(rs.getDouble("tClinico"));
            estadiajeTNM.settImagen(rs.getDouble("tImagen"));
            estadiajeTNM.setMetastasis(rs.getInt("Metastasis"));
            estadiajeTNM.setEstatus(rs.getInt("estatus"));
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            estadiajeTNM = null;
            System.out.println("ID: " + idRegistroTNM);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return estadiajeTNM;
    }

    @Override
    public List<EstadiajeTNM> mostrarEstadiajeTNM() {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<EstadiajeTNM> estadiajesTNM = null;
        
        //Call del store procedure
        String stProcedure="CALL mostrarListaEstadiajeTNM()";
        
        try{
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            estadiajesTNM = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            EstadiajeTNM estadiajeTNM;
            
            while(rs.next()){
                
                estadiajeTNM = new EstadiajeTNM();
                estadiajeTNM.setIdRegistroTNM(rs.getInt(1));
                estadiajeTNM.setIdTCodificado(rs.getInt(2));
                estadiajeTNM.setIdNCodificado(rs.getInt(3));
                estadiajeTNM.setIdMCodificado(rs.getInt(4));
                estadiajeTNM.settClinico(rs.getDouble(5));
                estadiajeTNM.settImagen(rs.getDouble(6));
                estadiajeTNM.setMetastasis(rs.getInt(7));
                estadiajeTNM.setEstatus(rs.getInt(8));;
                
                estadiajesTNM.add(estadiajeTNM);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(Exception ex){
            estadiajesTNM = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return estadiajesTNM;
    }

    @Override
    public boolean actualizarEstadiajeTNM(EstadiajeTNM estadiajeTNM) {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
     
        boolean exito = false;
        
        //Aquí va el call del procedure
        String stProcedure="CALL actualizarEstadiajeTNM(?, ?, ?, ?, ? ,?)";
        
        try {
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, estadiajeTNM.getIdRegistroTNM());
            cstmt.setInt(2, estadiajeTNM.getIdTCodificado());
            cstmt.setInt(3, estadiajeTNM.getIdNCodificado());
            cstmt.setInt(4, estadiajeTNM.getIdMCodificado());
            cstmt.setDouble(5, estadiajeTNM.gettClinico());
            cstmt.setDouble(6, estadiajeTNM.gettImagen());
            cstmt.setInt(7, estadiajeTNM.getMetastasis());
            cstmt.setInt(8, estadiajeTNM.getEstatus());
            
            rs = cstmt.executeQuery();
            
            rs.next();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            exito = false;
            System.out.println("idRegistroTNM: " + estadiajeTNM.getIdRegistroTNM());
            System.out.println("idTCodificado: " + estadiajeTNM.getIdTCodificado());
            System.out.println("idNCodificado: " + estadiajeTNM.getIdNCodificado());
            System.out.println("idMCodificado: " + estadiajeTNM.getIdMCodificado());
            System.out.println("tClinico: " + estadiajeTNM.gettClinico());
            System.out.println("tImagen: " + estadiajeTNM.gettImagen());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }

    @Override
    public boolean borradoLogicoEstadiajeTNM(int idRegistroTNM) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        boolean exito = false;
        
        //Call del store procedure
        String stProcedure="CALL borradoLogicoEstadiajeTNM(?)";
        
        try{
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,idRegistroTNM);
            
            rs = cstmt.executeQuery();
            
            rs.next();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            exito = false;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }

}
