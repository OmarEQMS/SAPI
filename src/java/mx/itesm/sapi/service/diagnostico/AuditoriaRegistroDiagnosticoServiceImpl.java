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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.diagnostico.AuditoriaRegistroDiagnostico;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Diego Montoya
 */
public class AuditoriaRegistroDiagnosticoServiceImpl implements AuditoriaRegistroDiagnosticoService {

    @Override
    public int agregarAuditoriaRegistroDiagnostico(AuditoriaRegistroDiagnostico auditoriaRegistroDiagnostico) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        int id = -1;
        
        //Aquí va el call del procedure
        String stProcedure="CALL agregarAuditoriaRegistroDiagnostico(?, ?, ?, ?)";
        
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, auditoriaRegistroDiagnostico.getIdAuditoriaRegistroDiagnostico());
            cstmt.setInt(2, auditoriaRegistroDiagnostico.getIdRegistroDiagnostico());
            cstmt.setInt(3, auditoriaRegistroDiagnostico.getIdEmpleado());
            cstmt.setInt(4, auditoriaRegistroDiagnostico.getEstatus());
            
            cstmt.executeQuery();
            
            rs = cstmt.getGeneratedKeys();
            rs.next();
            
            id = rs.getInt(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            id = -1;
            System.out.println("IdAuditoriaRegistroDiagnostico: " + auditoriaRegistroDiagnostico.getIdAuditoriaRegistroDiagnostico());
            System.out.println("IdRegistroDiagnostico: " + auditoriaRegistroDiagnostico.getIdRegistroDiagnostico());
            System.out.println("IdEmpleado: " + auditoriaRegistroDiagnostico.getIdEmpleado());
            System.out.println("Estatus: " + auditoriaRegistroDiagnostico.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return id;
    }
    
    @Override
    public AuditoriaRegistroDiagnostico mostrarAuditoriaRegistroDiagnostico(int idAuditoriaRegistroDiagnostico) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        AuditoriaRegistroDiagnostico auditoriaRegistroDiagnostico = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarAuditoriaRegistroDiagnostico(?)";
        
        try {    
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            auditoriaRegistroDiagnostico = new AuditoriaRegistroDiagnostico();
                    
            cstmt.setInt(1, idAuditoriaRegistroDiagnostico);
            rs = cstmt.executeQuery();
            
            // Asignación de valores devuletos a auditoriaRegistroDiagnostico
            rs.next();
            auditoriaRegistroDiagnostico.setIdAuditoriaRegistroDiagnostico(rs.getInt("idAuditoriaRegistroDiagnostico"));
            auditoriaRegistroDiagnostico.setIdRegistroDiagnostico(rs.getInt("idRegistroDiagnostico"));
            auditoriaRegistroDiagnostico.setIdEmpleado(rs.getInt("idEmpleado"));
            auditoriaRegistroDiagnostico.setFecha(rs.getDate("fecha"));
            auditoriaRegistroDiagnostico.setEstatus(rs.getInt("estatus"));
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            auditoriaRegistroDiagnostico = null;
            System.out.println("ID: " + idAuditoriaRegistroDiagnostico);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return auditoriaRegistroDiagnostico;
    }

    @Override
    public List<AuditoriaRegistroDiagnostico> mostrarAuditoriaRegistroDiagnostico() {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<AuditoriaRegistroDiagnostico> auditoriasRegistroDiagnostico = null;
        
        //Call del store procedure
        String stProcedure="CALL mostrarAuditoriaRegistroDiagnostico()";
        
        try{
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            auditoriasRegistroDiagnostico = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            AuditoriaRegistroDiagnostico auditoriaRegistroDiagnostico;
            
            while(rs.next()){
                
                auditoriaRegistroDiagnostico = new AuditoriaRegistroDiagnostico();
                auditoriaRegistroDiagnostico.setIdAuditoriaRegistroDiagnostico(rs.getInt(1));
                auditoriaRegistroDiagnostico.setIdRegistroDiagnostico(rs.getInt(2));
                auditoriaRegistroDiagnostico.setIdEmpleado(rs.getInt(3));
                auditoriaRegistroDiagnostico.setFecha(rs.getDate(4));
                auditoriaRegistroDiagnostico.setEstatus(rs.getInt(5));;
                
                auditoriasRegistroDiagnostico.add(auditoriaRegistroDiagnostico);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(Exception ex){
            auditoriasRegistroDiagnostico = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return auditoriasRegistroDiagnostico;
    }

    @Override
    public boolean actualizarAuditoriaRegistroDiagnostico(AuditoriaRegistroDiagnostico auditoriaRegistroDiagnostico) {
 
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
     
        boolean exito = false;
        
        //Aquí va el call del procedure
        String stProcedure="CALL actualizarAuditoriaRegistroDiagnostico(?, ?, ?, ?)";
        
        try {
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, auditoriaRegistroDiagnostico.getIdAuditoriaRegistroDiagnostico());
            cstmt.setInt(2, auditoriaRegistroDiagnostico.getIdRegistroDiagnostico());
            cstmt.setInt(3, auditoriaRegistroDiagnostico.getIdEmpleado());
            cstmt.setInt(4, auditoriaRegistroDiagnostico.getEstatus());
            
            rs = cstmt.executeQuery();
            
            rs.next();
            
            exito = rs.getBoolean(1); 
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            exito = false;
            System.out.println("IdAuditoriaRegistroDiagnostico: " + auditoriaRegistroDiagnostico.getIdAuditoriaRegistroDiagnostico());
            System.out.println("IdRegistroDiagnostico: " + auditoriaRegistroDiagnostico.getIdRegistroDiagnostico());
            System.out.println("IdEmpleado: " + auditoriaRegistroDiagnostico.getIdEmpleado());
            System.out.println("Estatus: " + auditoriaRegistroDiagnostico.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }

    @Override
    public boolean borradoLogicoAuditoriaRegistroDiagnostico(int idAuditoriaRegistroDiagnostico) {
  
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        boolean exito = false;
        
        //Call del store procedure
        String stProcedure="CALL borradoLogicoAuditoriaRegistroDiagnostico(?)";
        
        try{
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,idAuditoriaRegistroDiagnostico);
            
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
    public AuditoriaRegistroDiagnostico mostrarAuditoriaRegistroDiagnosticoIdRegistro(int idRegistro) {
     Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        AuditoriaRegistroDiagnostico auditoriaRegistroDiagnostico = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarAuditoriaRegistroDiagnosticoIdRegistro(?)";
        
        try {    
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            auditoriaRegistroDiagnostico = new AuditoriaRegistroDiagnostico();
                    
            cstmt.setInt(1, idRegistro);
            rs = cstmt.executeQuery();
            
            // Asignación de valores devuletos a auditoriaRegistroDiagnostico
            rs.next();
            auditoriaRegistroDiagnostico.setIdAuditoriaRegistroDiagnostico(rs.getInt("idAuditoriaRegistroDiagnostico"));
            auditoriaRegistroDiagnostico.setIdRegistroDiagnostico(rs.getInt("idRegistroDiagnostico"));
            auditoriaRegistroDiagnostico.setIdEmpleado(rs.getInt("idEmpleado"));
            auditoriaRegistroDiagnostico.setFecha(rs.getDate("fecha"));
            auditoriaRegistroDiagnostico.setEstatus(rs.getInt("estatus"));
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            auditoriaRegistroDiagnostico = null;
            System.out.println("ID: " + idRegistro);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return auditoriaRegistroDiagnostico;
    }

}
