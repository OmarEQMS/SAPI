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
import mx.itesm.sapi.bean.gestionPaciente.EstadoPaciente;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class EstadoPacienteServiceImpl implements EstadoPacienteService{
    
    
    @Override
    public EstadoPaciente mostrarEstadoPaciente(int idEstadoPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "---";
        EstadoPaciente estadoPaciente = null;

        try {
            conn = Conexion.getConnection();
            estadoPaciente = new EstadoPaciente();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEstadoPaciente);
                  
            rs = cstmt.executeQuery();
            rs.next();
            estadoPaciente.setIdEstadoPaciente(rs.getInt("idEstadoPaciente"));
            estadoPaciente.setNombre(rs.getString("nombre"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           estadoPaciente = null;
        }   
        return estadoPaciente;
    }
    
    @Override
    public List<EstadoPaciente> mostrarEstadoPaciente() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "---";
        List<EstadoPaciente> estadoPacientes = null;
        EstadoPaciente estadoPaciente;

	try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            estadoPacientes =  new ArrayList<>();
            
            while(rs.next()){
                estadoPaciente = new EstadoPaciente();
                estadoPaciente.setIdEstadoPaciente(rs.getInt("idEstadoPaciente"));
                estadoPaciente.setNombre(rs.getString("nombre"));

                estadoPacientes.add(estadoPaciente);
            }
		
		conn.close();
		cstmt.close();
		rs.close();
                
	}catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estadoPacientes = null;
	}
        return estadoPacientes;
    }

    @Override
    public int agregarEstadoPaciente(EstadoPaciente estadoPaciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoEstadoPaciente(int idEstadoPaciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarEstadoPaciente(EstadoPaciente estadoPaciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}