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
import mx.itesm.sapi.bean.diagnostico.RegistroDiagnostico;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Diego
 */
public class RegistroDiagnosticoServiceImpl implements RegistroDiagnosticoService{

    @Override
    public int agregarRegistroDiagnostico(RegistroDiagnostico registroDiagnostico) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        int id = -1;
        //Aquí va el call del procedure

        
        try {
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL agregarRegistroDiagnostico(?,?,?,?,?)");
            
            //cstmt.setInt(1, registroDiagnostico.getIdRegistroDiagnostico());
            cstmt.setDate(1, registroDiagnostico.getFecha());
            cstmt.setInt(2, registroDiagnostico.getPrevioDiagnostico());
            cstmt.setInt(3, registroDiagnostico.getIdPaciente());
            cstmt.setInt(4, registroDiagnostico.getIdEtapaClinica());
            cstmt.setInt(5, 0);
           // cstmt.setInt(6, registroDiagnostico.getEstatus());
           
             cstmt.executeQuery();
            rs = cstmt.getGeneratedKeys();
            rs.next();
            id=rs.getInt(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            id = -1;
            System.out.println("IdRegistroDiagnostico: " + registroDiagnostico.getIdRegistroDiagnostico());
            System.out.println("Fecha: " + registroDiagnostico.getFecha());
            System.out.println("PrevioDiagnostico: " + registroDiagnostico.getPrevioDiagnostico());
            System.out.println("IdPaciente: " + registroDiagnostico.getIdPaciente());
            System.out.println("IdRegistroTNM: " + registroDiagnostico.getIdRegistroTNM());
            System.out.println("Estatus: " + registroDiagnostico.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return id;
    }

    @Override
    public RegistroDiagnostico mostrarRegistroDiagnostico(int idRegistroDiagnostico) {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        RegistroDiagnostico registroDiagnostico = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarRegistroDiagnostico(?)";
        
        try {    
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            registroDiagnostico = new RegistroDiagnostico();
            
            cstmt.setInt(1, idRegistroDiagnostico);
            rs = cstmt.executeQuery();
            
            // Asignación de valores devuletos a registroDiagnostico
            rs.next();
            registroDiagnostico.setIdRegistroDiagnostico(rs.getInt("idRegistroDiagnostico"));
            registroDiagnostico.setFecha(rs.getDate("fecha"));
            registroDiagnostico.setPrevioDiagnostico(rs.getInt("previoDiagnostico"));
            registroDiagnostico.setIdEtapaClinica(rs.getInt("idEtapaClinica"));
            registroDiagnostico.setIdPaciente(rs.getInt("idPaciente"));
            registroDiagnostico.setIdRegistroTNM(rs.getInt("idRegistroTNM"));
            registroDiagnostico.setEstatus(rs.getInt("estatus"));
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            registroDiagnostico = null;
            System.out.println("ID: " + idRegistroDiagnostico);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return registroDiagnostico;
    }

    @Override
    public List<RegistroDiagnostico> mostrarRegistroDiagnostico() {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<RegistroDiagnostico> registrosDiagnostico = null;
        
        //Call del store procedure
        String stProcedure="CALL mostrarRegistroDiagnostico()";
        
        try{
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            registrosDiagnostico = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            RegistroDiagnostico registroDiagnostico;
            
            while(rs.next()){
                
                registroDiagnostico = new RegistroDiagnostico();
                registroDiagnostico.setIdRegistroDiagnostico(rs.getInt(1));
                registroDiagnostico.setFecha(rs.getDate(2));
                registroDiagnostico.setPrevioDiagnostico(rs.getInt(3));
                registroDiagnostico.setIdPaciente(rs.getInt(4));
                registroDiagnostico.setIdRegistroDiagnostico(rs.getInt(5));
                registroDiagnostico.setIdRegistroTNM(rs.getInt(6));
                registroDiagnostico.setEstatus(rs.getInt(7));
                
                registrosDiagnostico.add(registroDiagnostico);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                                
        }catch(Exception ex){
            registrosDiagnostico = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return registrosDiagnostico;
    }

    @Override
    public boolean actualizarRegistroDiagnostico(RegistroDiagnostico registroDiagnostico) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
     
        boolean exito = false;
        
        //Aquí va el call del procedure
        String stProcedure="CALL actualizarRegistroDiagnostico(?,?,?,?,?,?)";
        
        try {
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, registroDiagnostico.getIdRegistroDiagnostico());
            cstmt.setDate(2, registroDiagnostico.getFecha());
            cstmt.setInt(3, registroDiagnostico.getPrevioDiagnostico());
            cstmt.setInt(4, registroDiagnostico.getIdPaciente());
            cstmt.setInt(5, registroDiagnostico.getIdEtapaClinica());
            cstmt.setInt(6, 0);
           // cstmt.setInt(7, registroDiagnostico.getEstatus());
           
        
            rs = cstmt.executeQuery();
            
            rs.next();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            exito = false;
            System.out.println("IdRegistroDiagnostico: " + registroDiagnostico.getIdRegistroDiagnostico());
            System.out.println("Fecha: " + registroDiagnostico.getFecha());
            System.out.println("PrevioDiagnostico: " + registroDiagnostico.getPrevioDiagnostico());
            System.out.println("IdPaciente: " + registroDiagnostico.getIdPaciente());
            System.out.println("IdRegistroDiagnostico: " + registroDiagnostico.getIdRegistroDiagnostico());
            System.out.println("IdRegistroTNM: " + registroDiagnostico.getIdRegistroTNM());
            System.out.println("Estatus: " + registroDiagnostico.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }

    @Override
    public boolean borradoLogicoRegistroDiagnostico(int idRegistroDiagnostico) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        boolean exito = false;
                
        //Call del store procedure
        String stProcedure="CALL borradoLogicoRegistroDiagnostico(?)";
        
        try{
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,idRegistroDiagnostico);
            
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

    @Override
    public RegistroDiagnostico mostrarRegistroDiagnosticoPaciente(int idPaciente) {

         Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        RegistroDiagnostico registroDiagnostico = null;
        
        //Call del stored procedure

        
        try {    
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL mostrarRegistroDiagnosticoPaciente(?)");
            registroDiagnostico = new RegistroDiagnostico();
            
            cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();
            
            // Asignación de valores devuletos a registroDiagnostico
            rs.next();
            registroDiagnostico.setIdRegistroDiagnostico(rs.getInt("idRegistroDiagnostico"));
            registroDiagnostico.setFecha(rs.getDate("fecha"));
            registroDiagnostico.setPrevioDiagnostico(rs.getInt("previoDiagnostico"));
            registroDiagnostico.setIdPaciente(rs.getInt("idPaciente"));
            registroDiagnostico.setIdEtapaClinica(rs.getInt("idEtapaClinica"));
            registroDiagnostico.setIdRegistroTNM(rs.getInt("idRegistroTNM"));
            registroDiagnostico.setEstatus(rs.getInt("estatus"));
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            registroDiagnostico = null;
            System.out.println("ID: " + idPaciente);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return registroDiagnostico;
    }

   
    @Override
    public List<RegistroDiagnostico> mostrarRegistroDiagnosticoIdEspecifico(int idPaciente) {
     Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<RegistroDiagnostico> registrosDiagnostico = null;
        
        //Call del store procedure
        String stProcedure="CALL mostrarRegistroDiagnosticoPaciente(?)";
        
        try{
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            registrosDiagnostico = new ArrayList<>();
            cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();
            RegistroDiagnostico registroDiagnostico;
            
            while(rs.next()){
                
                registroDiagnostico = new RegistroDiagnostico();
                registroDiagnostico.setIdRegistroDiagnostico(rs.getInt(1));
                registroDiagnostico.setFecha(rs.getDate(2));
                registroDiagnostico.setPrevioDiagnostico(rs.getInt(3));
                registroDiagnostico.setIdPaciente(rs.getInt(4));
                registroDiagnostico.setIdRegistroDiagnostico(rs.getInt(5));
                registroDiagnostico.setIdRegistroTNM(rs.getInt(6));
                registroDiagnostico.setEstatus(rs.getInt(7));
                
                registrosDiagnostico.add(registroDiagnostico);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                                
        }catch(Exception ex){
            registrosDiagnostico = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return registrosDiagnostico;
    }

}
