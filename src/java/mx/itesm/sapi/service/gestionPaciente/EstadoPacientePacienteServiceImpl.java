
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class EstadoPacientePacienteServiceImpl implements EstadoPacientePacienteService{

    @Override
    public EstadoPacientePaciente mostrarEstadoPacientePaciente(int idEstadoPacientePaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarEstadoPacientePaciente(?)";
        EstadoPacientePaciente estadoPacientePaciente = null;
     
        try {
            conn = Conexion.getConnection();
            estadoPacientePaciente = new EstadoPacientePaciente();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEstadoPacientePaciente);
                  
            rs = cstmt.executeQuery();
            rs.next();
            estadoPacientePaciente.setIdEstadoPacientePaciente(rs.getInt("idEstadoPacientePaciente"));
            estadoPacientePaciente.setIdEstadoPaciente(rs.getInt("idEstadoPaciente"));
            estadoPacientePaciente.setIdPaciente(rs.getInt("idEstadoPaciente"));
            estadoPacientePaciente.setFecha(rs.getTimestamp("fecha"));
            estadoPacientePaciente.setSegundaOpinion(rs.getInt("segundaOpinion"));
            estadoPacientePaciente.setResultados(rs.getInt("resultados"));
            estadoPacientePaciente.setIdEmpleado(rs.getInt("idEmpleado"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           estadoPacientePaciente = null;
        }   
        return estadoPacientePaciente;
    }

    @Override
    public List<EstadoPacientePaciente> mostrarEstadoPacientePaciente() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarEstadoPacientePaciente()";
        List<EstadoPacientePaciente> listaestadoPacientePacientes = null;
        EstadoPacientePaciente estadoPacientePaciente;

	try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            listaestadoPacientePacientes =  new ArrayList<>();
            
            while(rs.next()){
                estadoPacientePaciente = new EstadoPacientePaciente();

                estadoPacientePaciente.setIdEstadoPacientePaciente(rs.getInt("idEstadoPacientePaciente"));
                estadoPacientePaciente.setIdEstadoPaciente(rs.getInt("idEstadoPaciente"));
                estadoPacientePaciente.setIdPaciente(rs.getInt("idEstadoPaciente"));
                estadoPacientePaciente.setFecha(rs.getTimestamp("fecha"));
                estadoPacientePaciente.setSegundaOpinion(rs.getInt("segundaOpinion"));
                estadoPacientePaciente.setResultados(rs.getInt("resultados"));
                estadoPacientePaciente.setIdEmpleado(rs.getInt("idEmpleado"));

                

                listaestadoPacientePacientes.add(estadoPacientePaciente);
            }
		
		conn.close();
		cstmt.close();
		rs.close();
                
	}catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listaestadoPacientePacientes = null;
	}
        return listaestadoPacientePacientes;
    }

    @Override
    public int agregarEstadoPacientePaciente(EstadoPacientePaciente estadoPacientePaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        String stProcedure = "CALL agregarEstadoPacientePaciente(?,?, ?, ?, ?)";

        int id = -1;
        
	try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, 1);                        
            cstmt.setInt(2, estadoPacientePaciente.getIdPaciente());
            cstmt.setInt(3, estadoPacientePaciente.getSegundaOpinion());
            cstmt.setInt(4, estadoPacientePaciente.getResultados());
            cstmt.setInt(5, 1);
            
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
    public int agregarEstadoPacientePacienteRegistro(int idPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL agregarEstadoPacientePacienteRegistro(?,?,?)";
        int id = -1;
        
	try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, 1);
            cstmt.setInt(2, idPaciente);
            //ME FALTA LA FECHA D:
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            cstmt.setTimestamp(3, timestamp);
            
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
    public boolean borradoLogicoEstadoPacientePaciente(int idEstadoPacientePaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL borradoLogicoEstadoPacientePaciente ";
        boolean exito = false;

        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, idEstadoPacientePaciente);
            
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
    public boolean actualizarEstadoPacientePaciente(EstadoPacientePaciente estadoPacientePaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL actualizarEstadoPacientePaciente";
        boolean exito = false;
        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, estadoPacientePaciente.getIdEstadoPaciente());
            cstmt.setInt(2, estadoPacientePaciente.getIdPaciente());
            cstmt.setTimestamp(3, estadoPacientePaciente.getFecha());
            cstmt.setInt(4, estadoPacientePaciente.getSegundaOpinion());
            cstmt.setInt(5, estadoPacientePaciente.getResultados());
            cstmt.setInt(6, estadoPacientePaciente.getIdEmpleado());
            
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
    public int estadoPrimeraSegundaVez(int idPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL estadoPrimeraSegundaVez(?)";
        int idEstadoPaciente = -1;
        
	try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, idPaciente);
            
            rs = cstmt.executeQuery();
            rs.next();
            
            idEstadoPaciente = rs.getInt(1);
                
            conn.close();
            cstmt.close();
            rs.close();
	}catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            idEstadoPaciente = -1;
	}
        return idEstadoPaciente;
    }

    @Override
    public EstadoPacientePaciente mostrarEstadoPacientePacienteIdPaciente(int idPaciente) {
         Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarEstadoPacientePacienteIdPaciente(?)";
        EstadoPacientePaciente estadoPacientePaciente = null;
     
        try {
            conn = Conexion.getConnection();
            estadoPacientePaciente = new EstadoPacientePaciente();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);
                  
            rs = cstmt.executeQuery();
            rs.next();
            estadoPacientePaciente.setIdEstadoPacientePaciente(rs.getInt("idEstadoPacientePaciente"));
            estadoPacientePaciente.setIdEstadoPaciente(rs.getInt("idEstadoPaciente"));
            estadoPacientePaciente.setIdPaciente(rs.getInt("idEstadoPaciente"));
            estadoPacientePaciente.setFecha(rs.getTimestamp("fecha"));
            estadoPacientePaciente.setSegundaOpinion(rs.getInt("segundaOpinion"));
            estadoPacientePaciente.setResultados(rs.getInt("resultados"));
            estadoPacientePaciente.setIdEmpleado(rs.getInt("idEmpleado"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           estadoPacientePaciente = null;
        }   
        return estadoPacientePaciente;
    }
    
}