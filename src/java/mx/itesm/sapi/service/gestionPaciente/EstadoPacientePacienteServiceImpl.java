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
import mx.itesm.sapi.bean.moduloGestionPaciente.EstadoPacientePaciente;
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
        String stProcedure = "---";
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
        String stProcedure = "---";
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
        String stProcedure = "CALL agregarEstadoPacienteRegistro(?,?)";
        int id = -1;
        
	try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
          
            cstmt.setInt(1, estadoPacientePaciente.getIdPaciente());
            cstmt.setInt(2, 0);
           /* cstmt.setTimestamp(1, estadoPacientePaciente.getFecha());
            cstmt.setInt(1, estadoPacientePaciente.getSegundaOpinion());
            cstmt.setInt(1, estadoPacientePaciente.getResultados());
            */
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarEstadoPacientePaciente(EstadoPacientePaciente EstadoPacientePaciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
