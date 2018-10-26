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
import mx.itesm.sapi.bean.gestionTratamiento.TipoTratamiento;
import mx.itesm.sapi.bean.gestionTratamiento.TratamientoPaciente;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Admin
 */
public class TratamientoPacienteServiceImpl implements TratamientoPacienteService {
    
    @Override
    public int agregarTratamientoPaciente(TratamientoPaciente tratamientoPaciente) {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
                        
        //Id para devolver
        int id = -1;
        
        //Aquí va el call del procedure
        String stProcedure="CALL agregarTratamientoPaciente(?,?,?,?,?,?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            //Aquí van los sets
            
            cstmt.setInt(1,tratamientoPaciente.getIdTipoTratamiento());
            cstmt.setInt(2,tratamientoPaciente.getIdPaciente());
            cstmt.setDate(3,tratamientoPaciente.getFechaInicio());
            cstmt.setDate(4,tratamientoPaciente.getFechaFin());
            cstmt.setBoolean(5,tratamientoPaciente.getRecurrente());
            cstmt.setBoolean(6, tratamientoPaciente.getPrevioCirugia());
            //cstmt.setInt(7, tratamientoPaciente.getEstatus());
            
           rs = cstmt.executeQuery();
            rs.next();
            id = rs.getInt(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            id = -1;
            System.out.println("IdPaciente: " + tratamientoPaciente.getIdPaciente());
            System.out.println("IdTipoTratamiento: " + tratamientoPaciente.getIdTipoTratamiento());
            System.out.println("FechaInicio: " + tratamientoPaciente.getFechaInicio());
            System.out.println("FechaFin: " + tratamientoPaciente.getFechaFin());
            System.out.println("Recurrente: " + tratamientoPaciente.getRecurrente());
            System.out.println("PrevioCirugia: " + tratamientoPaciente.getPrevioCirugia());
            System.out.println("Estatus: " + tratamientoPaciente.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return id;
    }

    @Override
    public TratamientoPaciente mostrarTratamientoPaciente(int idTratamientoPaciente) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        TratamientoPaciente tratamientoPaciente = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarTratamientoPaciente(?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            tratamientoPaciente = new TratamientoPaciente();
            
            cstmt.setInt(1, idTratamientoPaciente);
            rs = cstmt.executeQuery();
            
            rs.next();
            tratamientoPaciente.setIdTratamientoPaciente(rs.getInt(1));
            tratamientoPaciente.setIdTipoTratamiento(rs.getInt(2));
            tratamientoPaciente.setIdPaciente(rs.getInt(3));
            tratamientoPaciente.setFechaInicio(rs.getDate(4));
            tratamientoPaciente.setFechaFin(rs.getDate(5));
            tratamientoPaciente.setRecurrente(rs.getBoolean(6));
            tratamientoPaciente.setPrevioCirugia(rs.getBoolean(7));
            tratamientoPaciente.setEstatus(rs.getInt(8));
            
            rs.close();
            cstmt.close();
            conn.close();
           
        }catch(SQLException ex){
            tratamientoPaciente = null;
            System.out.println("ID: " + idTratamientoPaciente);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return tratamientoPaciente;
    }

    @Override
    public List<TratamientoPaciente> mostrarTratamientoPaciente() {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<TratamientoPaciente> tratamientosPaciente = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarListaTratamientoPaciente()";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            tratamientosPaciente = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            TratamientoPaciente tratamientoPaciente;
            
            while(rs.next()){
                tratamientoPaciente = new TratamientoPaciente();
            tratamientoPaciente.setIdTratamientoPaciente(rs.getInt(1));
            tratamientoPaciente.setIdTipoTratamiento(rs.getInt(2));
            tratamientoPaciente.setIdPaciente(rs.getInt(3));
            tratamientoPaciente.setFechaInicio(rs.getDate(4));
            tratamientoPaciente.setFechaFin(rs.getDate(5));
            tratamientoPaciente.setRecurrente(rs.getBoolean(6));
            tratamientoPaciente.setPrevioCirugia(rs.getBoolean(7));
            tratamientoPaciente.setEstatus(rs.getInt(8));

                tratamientosPaciente.add(tratamientoPaciente);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex) {
           tratamientosPaciente = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return tratamientosPaciente;
    }
    
    

    @Override
    public boolean actualizarTratamientoPaciente(TratamientoPaciente tratamientoPaciente) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        boolean exito = false;
        
        //Call del store procedure
        String stProcedure="CALL actualizarTratamientoPaciente(?,?,?,?,?,?,?)";
        
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, tratamientoPaciente.getIdTratamientoPaciente());
            cstmt.setInt(2, tratamientoPaciente.getIdPaciente());
            cstmt.setInt(3,tratamientoPaciente.getIdTipoTratamiento());
            cstmt.setDate(4, tratamientoPaciente.getFechaInicio());
            cstmt.setDate(5, tratamientoPaciente.getFechaFin());
            cstmt.setBoolean(6, tratamientoPaciente.getRecurrente());
            cstmt.setBoolean(7, tratamientoPaciente.getPrevioCirugia());
            //cstmt.setInt(8, tratamientoPaciente.getEstatus());
            
            rs = cstmt.executeQuery();
            
            rs.next();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            exito = false;
            System.out.println("IdTratamientoPaciente: " + tratamientoPaciente.getIdTratamientoPaciente());
            System.out.println("IdPaciente: " + tratamientoPaciente.getIdPaciente());
            System.out.println("IdTipoTratamiento: " + tratamientoPaciente.getIdTipoTratamiento());
            System.out.println("FechaInicio: " + tratamientoPaciente.getFechaInicio());
            System.out.println("FechaFin: " + tratamientoPaciente.getFechaFin());
            System.out.println("Recurrente: " + tratamientoPaciente.getRecurrente());
            System.out.println("PrevioCirugia: " + tratamientoPaciente.getPrevioCirugia());
            System.out.println("Estatus: " + tratamientoPaciente.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }

    @Override
    public boolean borradoLogicoTratamientoPaciente(int idTratamientoPaciente) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        boolean exito = false;
        
        //Call del store procedure
        String stProcedure="CALL borradoLogicoTratamientoPaciente(?,?,?,?,?,?,?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, idTratamientoPaciente);
            
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
}

    

