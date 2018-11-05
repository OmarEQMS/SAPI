/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionTratamiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionTratamiento.AuditoriaTratamientoPaciente;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Admin
 */
public class AuditoriaTratamientoPacienteServiceImpl implements AuditoriaTratamientoPacienteService {

    @Override
    public int agregarAuditoriaTratamientoPaciente(AuditoriaTratamientoPaciente auditoriaTratamientoPaciente) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
                        
        //Id para devolver
        int id = -1;
        
        //Aquí va el call del procedure
        String stProcedure="CALL agregarAuditoriaTratamientoPaciente(?,?,?,?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            //Aquí van los sets
            
            cstmt.setInt(1,auditoriaTratamientoPaciente.getIdTratamientoPaciente());
            cstmt.setInt(2,auditoriaTratamientoPaciente.getIdEmpleado());
            cstmt.setTimestamp(3, auditoriaTratamientoPaciente.getFecha());
            cstmt.setInt(4, auditoriaTratamientoPaciente.getEstatus());
            
            cstmt.executeUpdate();
            
            rs = cstmt.getGeneratedKeys();
            rs.next();
            
            id = cstmt.getInt(1);
           
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            id = -1;
            System.out.println("IdTratamientoPaciente: " + auditoriaTratamientoPaciente.getIdTratamientoPaciente());
            System.out.println("IdEmpleado: " + auditoriaTratamientoPaciente.getIdEmpleado());
            System.out.println("IdFecha: " + auditoriaTratamientoPaciente.getIdEmpleado());
            System.out.println("Estatus: " + auditoriaTratamientoPaciente.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return id;
    }

    @Override
    public AuditoriaTratamientoPaciente mostrarAuditoriaTratamientoPaciente(int idAuditoriaTratamientoPaciente) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        AuditoriaTratamientoPaciente auditoriaTratamientoPaciente = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarAuditoriaTratamientoPaciente(?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            auditoriaTratamientoPaciente = new AuditoriaTratamientoPaciente();
            
            cstmt.setInt(1, idAuditoriaTratamientoPaciente);
            rs = cstmt.executeQuery();
            
            rs.next();
            auditoriaTratamientoPaciente.setIdAuditoriaTratamientoPaciente(rs.getInt(1));
            auditoriaTratamientoPaciente.setIdTratamientoPaciente(rs.getInt(2));
            auditoriaTratamientoPaciente.setIdEmpleado(rs.getInt(3));
            auditoriaTratamientoPaciente.setFecha(rs.getTimestamp(4));
            auditoriaTratamientoPaciente.setEstatus(rs.getInt(5));
            
            rs.close();
            cstmt.close();
            conn.close();
           
        }catch(SQLException ex){
            auditoriaTratamientoPaciente = null;
            System.out.println("ID: " + idAuditoriaTratamientoPaciente);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return auditoriaTratamientoPaciente;
    }

    @Override
    public List<AuditoriaTratamientoPaciente> mostrarAuditoriaTratamientoPaciente() {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<AuditoriaTratamientoPaciente> auditoriasTratamientoPaciente = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarListaPacienteFarmaco()";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            auditoriasTratamientoPaciente = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            AuditoriaTratamientoPaciente auditoriaTratamientoPaciente;
            
            while(rs.next()){
                auditoriaTratamientoPaciente = new AuditoriaTratamientoPaciente();
                auditoriaTratamientoPaciente.setIdAuditoriaTratamientoPaciente(rs.getInt(1));
                auditoriaTratamientoPaciente.setIdTratamientoPaciente(rs.getInt(2));
                auditoriaTratamientoPaciente.setIdEmpleado(rs.getInt(3));
                auditoriaTratamientoPaciente.setFecha(rs.getTimestamp(4));
                auditoriaTratamientoPaciente.setEstatus(rs.getInt(5));

                auditoriasTratamientoPaciente.add(auditoriaTratamientoPaciente);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex) {
           auditoriasTratamientoPaciente = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return auditoriasTratamientoPaciente;
    }

    @Override
    public boolean actualizarAuditoriaTratamientoPaciente(AuditoriaTratamientoPaciente auditoriaTratamientoPaciente) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        boolean exito = false;
        
        //Call del store procedure
        String stProcedure="CALL actualizarAuditoriaTratamientoPaciente(?,?,?,?,?,?)";
        
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, auditoriaTratamientoPaciente.getIdAuditoriaTratamientoPaciente());
            cstmt.setInt(2, auditoriaTratamientoPaciente.getIdTratamientoPaciente());
            cstmt.setInt(3,auditoriaTratamientoPaciente.getIdTratamientoPaciente());
            cstmt.setInt(4,auditoriaTratamientoPaciente.getIdEmpleado());
            cstmt.setTimestamp(5, auditoriaTratamientoPaciente.getFecha());
            cstmt.setInt(6, auditoriaTratamientoPaciente.getEstatus());
            
            rs = cstmt.executeQuery();
            
            rs.next();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            exito = false;
            System.out.println("IdAuditoriaTratamientoPaciente: " + auditoriaTratamientoPaciente.getIdAuditoriaTratamientoPaciente());
            System.out.println("IdTratamientoPaciente: " + auditoriaTratamientoPaciente.getIdTratamientoPaciente());
            System.out.println("IdEmpleado: " + auditoriaTratamientoPaciente.getIdEmpleado());
            System.out.println("IdFecha: " + auditoriaTratamientoPaciente.getIdEmpleado());
            System.out.println("Estatus: " + auditoriaTratamientoPaciente.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }
    
    @Override
    public boolean borradoLogicoAuditoriaTratamientoPaciente(int idAuditoriaTratamientoPaciente) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        boolean exito = false;
        
        //Call del store procedure
        String stProcedure="CALL borradoLogicoAuditoriaTratamientoPaciente(?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, idAuditoriaTratamientoPaciente);
            
            rs = cstmt.executeQuery();
            
            rs.next();
            
           exito = rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            exito = false;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }

    @Override
    public AuditoriaTratamientoPaciente mostrarAuditoriaTratamientoPacienteIdTratamiento(int idTratamiento) {
     Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        AuditoriaTratamientoPaciente auditoriaTratamientoPaciente = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarAuditoriaTratamientoPacienteIdTratamiento(?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            auditoriaTratamientoPaciente = new AuditoriaTratamientoPaciente();
            
            cstmt.setInt(1, idTratamiento);
            rs = cstmt.executeQuery();
            
            rs.next();
            auditoriaTratamientoPaciente.setIdAuditoriaTratamientoPaciente(rs.getInt(1));
            auditoriaTratamientoPaciente.setIdTratamientoPaciente(rs.getInt(2));
            auditoriaTratamientoPaciente.setIdEmpleado(rs.getInt(3));
            auditoriaTratamientoPaciente.setFecha(rs.getTimestamp(4));
            auditoriaTratamientoPaciente.setEstatus(rs.getInt(5));
            
            rs.close();
            cstmt.close();
            conn.close();
           
        }catch(SQLException ex){
            auditoriaTratamientoPaciente = null;
            System.out.println("ID: " + idTratamiento);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return auditoriaTratamientoPaciente;
    }
}
