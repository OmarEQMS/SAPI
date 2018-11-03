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
import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author urieldiaz
 */
public class PacienteServicioImpl implements PacienteServicio{

    
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
        String stPrcedure="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);
            
            cstmt.setInt(1, paciente.getIdPaciente());
            cstmt.setInt(2, paciente.getIdCuenta());
            cstmt.setInt(3, paciente.getIdEscolaridad());
            cstmt.setString(4, paciente.getPrz());
            cstmt.setString(5, paciente.getExpediente());
            cstmt.setDouble(6, paciente.getPeso() );
            cstmt.setDouble(7, paciente.getAltura());
            cstmt.setInt(8, paciente.getPosMenopausia());
            cstmt.setInt(9, paciente.getEstatus());
            
            cstmt.executeQuery();
            rs = cstmt.getGeneratedKeys();
            rs.next();
            id=rs.getInt(1);
            
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
        boolean exito= false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall("CALL actualizarPaciente(?,?,?,?,?,?,?,?)");
            
            cstmt.setInt(1, paciente.getIdPaciente());
            cstmt.setInt(2, paciente.getIdCuenta());
            cstmt.setInt(3, 1);
            cstmt.setString(4, paciente.getPrz());
            cstmt.setString(5, paciente.getExpediente());
            cstmt.setDouble(6, paciente.getPeso() );
            cstmt.setDouble(7, paciente.getAltura());
            cstmt.setInt(8, paciente.getPosMenopausia());
            //cstmt.setInt(9, paciente.getEstatus());
            
            rs = cstmt.executeQuery();
            
            rs.next();
            
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
    public Paciente mostrarPacientePotencial(int idCuenta) {
        Connection conn; 
        CallableStatement cstmt = null;
        ResultSet rs;
        
        Paciente paciente = new Paciente();
        
        String stProcedure = "CALL mostrarPacientePorCuenta(?)";
        
        
        try{
            conn = Conexion.getConnection();            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idCuenta);
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
    public DatosPacienteDocumentoInicial mostrarDatosPacienteDocumentoInicial(int idPaciente) {
        Connection conn; 
        ResultSet rs;
        CallableStatement cstmt;
        DatosPacienteDocumentoInicial datosPacienteDocumentoInicial  = new DatosPacienteDocumentoInicial();
        
        String stPrcedure="CALL mostrarDatosPacienteDocumentoInicial(?)";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);                      
            cstmt.setInt(1, idPaciente);           
            
            rs = cstmt.executeQuery();
            rs.next();
            
            datosPacienteDocumentoInicial.setIdPaciente(rs.getInt(1)); 
            datosPacienteDocumentoInicial.setIdCuenta(rs.getInt(2));
            datosPacienteDocumentoInicial.setIdPersona(rs.getInt(3));
            datosPacienteDocumentoInicial.setNombre(rs.getString("nombre"));
            datosPacienteDocumentoInicial.setPrimerApellido(rs.getString("primerApellido"));
            datosPacienteDocumentoInicial.setSegundoApellido(rs.getString("segundoApellido"));
                                                       
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            
            System.out.println("PacienteServiceImpl mostrarDatosPacienteDocumentoInicial ".concat(ex.getMessage()));            
        }         
        return datosPacienteDocumentoInicial;
    }    
    
}
