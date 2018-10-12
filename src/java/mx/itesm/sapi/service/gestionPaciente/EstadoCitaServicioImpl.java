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
import mx.itesm.sapi.bean.gestionPaciente.EstadoCita;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class EstadoCitaServicioImpl implements EstadoCitaServicio {

    @Override
    public EstadoCita mostrarEstadoCita(int idEstadoCita) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarEstadoCita";
        EstadoCita estadoCita = null;
     
        try {
            conn = Conexion.getConnection();
            estadoCita = new EstadoCita();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEstadoCita);
                  
            rs = cstmt.executeQuery();
            rs.next();
            estadoCita.setIdEstadoCita(rs.getInt("idEstadoCita"));
            estadoCita.setNombre(rs.getString("nombre"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           estadoCita = null;
        }   
        return estadoCita;
    }

    @Override
    public List<EstadoCita> mostrarEstadoCita() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarEstadoCita";
        List<EstadoCita> estadosCita = null;
        EstadoCita estadoCita;

        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            estadosCita =  new ArrayList<>();
            
            while(rs.next()){
                estadoCita = new EstadoCita();
                estadoCita.setIdEstadoCita(rs.getInt("idEstadoCita"));
                estadoCita.setNombre(rs.getString("nombre"));

                estadosCita.add(estadoCita);
            }
		
		conn.close();
		cstmt.close();
		rs.close();

        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estadosCita = null;
	}
        return estadosCita;
    }

    @Override
    public int agregarEstadoCita(EstadoCita estadoCita) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoEstadoCita(int idEstadoCita) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarEstadoCita(EstadoCita estadoCita) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
