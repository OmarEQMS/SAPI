/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.Connection;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mx.itesm.sapi.bean.gestionPaciente.DatosPacienteDocumentoInicial;
import mx.itesm.sapi.bean.moduloGestionPaciente.Paciente;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author urieldiaz
 */
public class PacienteServiceImpl implements PacienteService{

    
    @Override
    public Paciente mostrarPaciente(int idPaciente) {
        Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        
        Paciente paciente = new Paciente();
        
        String stProcedure ="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();
            
            paciente.setIdPaciente(rs.getInt("idPaciente"));
            paciente.setIdCuenta(rs.getInt("idCuenta"));
            paciente.setIdEscolaridad(rs.getInt("idEscolaridad"));
            paciente.setPrz(rs.getString("prz"));
            paciente.setExpediente(rs.getString("expediente"));
            paciente.setPeso(rs.getDouble("peso"));
            paciente.setAltura(rs.getDouble("altura"));
            paciente.setPosMenopausia(rs.getInt("posMenopausia"));
            paciente.setEstatus(rs.getInt("estatus"));
        
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            paciente= null;
        }
        return paciente;
    }

    @Override
    public Paciente mostrarPaciente(String przPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        Paciente paciente = new Paciente();
        
        String stProcedure ="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();
            
            paciente.setIdPaciente(rs.getInt("idPaciente"));
            paciente.setIdCuenta(rs.getInt("idCuenta"));
            paciente.setIdEscolaridad(rs.getInt("idEscolaridad"));
            paciente.setPrz(rs.getString("prz"));
            paciente.setExpediente(rs.getString("expediente"));
            paciente.setPeso(rs.getDouble("peso"));
            paciente.setAltura(rs.getDouble("altura"));
            paciente.setPosMenopausia(rs.getInt("posMenopausia"));
            paciente.setEstatus(rs.getInt("estatus"));
        
            
            rs.close();
            cstmt.close();
            conn.close();
            
            
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            paciente = null;
        }
        return paciente;
    }

    @Override
    public List<Paciente> mostrarPaciente() {
        Connection conn;
        List<Paciente> pacientes = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure="";
        
        ResultSet rs;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            Paciente paciente;
            
            while(rs.next()){
                paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setIdCuenta(rs.getInt("idCuenta"));
                paciente.setIdEscolaridad(rs.getInt("idEscolaridad"));
                paciente.setPrz(rs.getString("prz"));
                paciente.setExpediente(rs.getString("expediente"));
                paciente.setPeso(rs.getDouble("peso"));
                paciente.setAltura(rs.getDouble("altura"));
                paciente.setPosMenopausia(rs.getInt("posMenopausia"));
                paciente.setEstatus(rs.getInt("estatus"));
                
                pacientes.add(paciente);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacientes = null;
        }
        return pacientes;
    }

    @Override
    public int agregarPaciente(Paciente paciente) {
        Connection conn; 
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        
        String stPrcedure="CALL agregarPaciente(?,?,?,?,?,?,?)";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);
            
          
            cstmt.setInt(1, paciente.getIdCuenta());
            cstmt.setInt(2, 1);
            cstmt.setString(3, paciente.getPrz());
            cstmt.setString(4, paciente.getExpediente());
            cstmt.setDouble(5, paciente.getPeso() );
            cstmt.setDouble(6, paciente.getAltura());
            cstmt.setInt(7, paciente.getPosMenopausia());
            
            
            rs = cstmt.executeQuery();
            rs.next();
            id = rs.getInt(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
        }
        
        return id;
    }

    @Override
    public boolean actualizarPaciente(Paciente paciente) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito= false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, paciente.getIdPaciente());
            cstmt.setInt(2, paciente.getIdCuenta());
            cstmt.setInt(3, paciente.getIdEscolaridad());
            cstmt.setString(4, paciente.getPrz());
            cstmt.setString(5, paciente.getExpediente());
            cstmt.setDouble(6, paciente.getPeso() );
            cstmt.setDouble(7, paciente.getAltura());
            cstmt.setInt(8, paciente.getPosMenopausia());
            cstmt.setInt(9, paciente.getEstatus());
            
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

    @Override
    public boolean borradoLogicoPaciente(int idPaciente) {
        Connection conn; 
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito = false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);
            
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
    public int agregarPacienteRegistro(int idCuenta) {
        Connection conn; 
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        
        String stPrcedure="CALL agregarPacienteRegistro(?)";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);
                      
            cstmt.setInt(1, idCuenta);

             rs = cstmt.executeQuery();
            rs.next();
            id = rs.getInt(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
        }
        
        return id;   
    }
   
}
