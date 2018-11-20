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
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.CitaEmpleado;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class CitaEmpleadoServicioImpl implements CitaEmpleadoServicio {

    @Override
    public CitaEmpleado mostrarCitaEmpleado(int idCitaEmpleado) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarCitaEmpleado(?)";
        CitaEmpleado citaEmpleado = null;
     
        try {
            conn = Conexion.getConnection();
            citaEmpleado = new CitaEmpleado();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idCitaEmpleado);
                  
            rs = cstmt.executeQuery();
            rs.next();
            citaEmpleado.setIdCitaEmpleado(rs.getInt("idCitaEmpleado"));
            citaEmpleado.setIdCita(rs.getInt("idCita"));
            citaEmpleado.setIdEmpleado(rs.getInt("idEmpleado"));
            citaEmpleado.setMedicoSustituto(rs.getInt("medicoSustituto"));
            citaEmpleado.setAdscritoPresente(rs.getInt("adscridoPresente"));
            citaEmpleado.setIdEmpleadoSustituto(rs.getInt("idEmpleadoSustitutos"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           citaEmpleado = null;
        }   
        return citaEmpleado;
    }

    @Override
    public List<CitaEmpleado> mostrarCitaEmpleado() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarCitaEmpleado()";
        List<CitaEmpleado> citaEmpleados = null;
        CitaEmpleado citaEmpleado;

        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            citaEmpleados =  new ArrayList<>();
            
            while(rs.next()){
                citaEmpleado = new CitaEmpleado();
                
                citaEmpleado.setIdCitaEmpleado(rs.getInt("idCitaEmpleado"));
                citaEmpleado.setIdCita(rs.getInt("idCita"));
                citaEmpleado.setIdEmpleado(rs.getInt("idEmpleado"));
                citaEmpleado.setMedicoSustituto(rs.getInt("medicoSustituto"));
                citaEmpleado.setAdscritoPresente(rs.getInt("adscridoPresente"));
                citaEmpleado.setIdEmpleadoSustituto(rs.getInt("idEmpleadoSustitutos"));

                citaEmpleados.add(citaEmpleado);
            }
		
		conn.close();
		cstmt.close();
		rs.close();

        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            citaEmpleados = null;
	}
        return citaEmpleados;
    }

    @Override
    public int agregarCitaEmpleado(CitaEmpleado citaEmpleado) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL agregarCitaEmpleado(?, ?, ?, ?)";
        int id = -1;

        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,citaEmpleado.getIdCita());
            cstmt.setInt(2,citaEmpleado.getIdEmpleado());
            cstmt.setInt(3,citaEmpleado.getMedicoSustituto());
            cstmt.setInt(4,citaEmpleado.getAdscritoPresente());

            
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
    public boolean borradoLogicoCitaEmpleado(int idCitaEmpleado) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL borradoLogicoCitaEmpleado(?)";
        boolean exito = false;

        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, idCitaEmpleado);
            
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
    public boolean actualizarCitaEmpleado(CitaEmpleado citaEmpleado) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL actualizarCitaEmpleado(?, ?, ?, ?, ?)";
        boolean exito = false;
        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,citaEmpleado.getIdCita());
            cstmt.setInt(2,citaEmpleado.getIdEmpleado());
            cstmt.setInt(3,citaEmpleado.getMedicoSustituto());
            cstmt.setInt(4,citaEmpleado.getAdscritoPresente());
            cstmt.setInt(5,citaEmpleado.getIdEmpleadoSustituto());
            
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
    public CitaEmpleado mostrarCitaEmpleadoIdCita(int idCita) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarCitaEmpleado(?)";
        CitaEmpleado citaEmpleado = null;
     
        try {
            conn = Conexion.getConnection();
            citaEmpleado = new CitaEmpleado();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idCita);
                  
            rs = cstmt.executeQuery();
            rs.next();
            citaEmpleado.setIdCitaEmpleado(rs.getInt("idCitaEmpleado"));
            citaEmpleado.setIdCita(rs.getInt("idCita"));
            citaEmpleado.setIdEmpleado(rs.getInt("idEmpleado"));
            citaEmpleado.setMedicoSustituto(rs.getInt("medicoSustituto"));
            citaEmpleado.setAdscritoPresente(rs.getInt("adscridoPresente"));
            citaEmpleado.setIdEmpleadoSustituto(rs.getInt("idEmpleadoSustitutos"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           citaEmpleado = null;
        }   
        return citaEmpleado;
    }
    
    @Override
    public CitaEmpleado mostrarCitaEmpleadoIdEmpleado(int idEmpleado) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarCitaEmpleadoIdEmpleado(?)";
        CitaEmpleado citaEmpleado = null;
     
        try {
            conn = Conexion.getConnection();
            citaEmpleado = new CitaEmpleado();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEmpleado);
                  
            rs = cstmt.executeQuery();
            rs.next();
            citaEmpleado.setIdCitaEmpleado(rs.getInt("idCitaEmpleado"));
            citaEmpleado.setIdCita(rs.getInt("idCita"));
            citaEmpleado.setIdEmpleado(rs.getInt("idEmpleado"));
            citaEmpleado.setMedicoSustituto(rs.getInt("medicoSustituto"));
            citaEmpleado.setAdscritoPresente(rs.getInt("adscridoPresente"));
            
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           citaEmpleado = null;
        }   
        return citaEmpleado;
    }
    
}
