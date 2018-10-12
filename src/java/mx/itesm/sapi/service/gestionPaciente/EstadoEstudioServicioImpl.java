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
import mx.itesm.sapi.bean.gestionPaciente.EstadoEstudio;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class EstadoEstudioServicioImpl implements EstadoEstudioServicio{

    @Override
    public EstadoEstudio mostrarEstadoEstudio(int idEstadoEstudio) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarEstadoEstudio";
        EstadoEstudio estadoEstudio = null;
     
        try {
            conn = Conexion.getConnection();
            estadoEstudio = new EstadoEstudio();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEstadoEstudio);
                  
            rs = cstmt.executeQuery();
            rs.next();
            estadoEstudio.setIdEstadoEstudio(rs.getInt("idEstadoEstudio"));
            estadoEstudio.setNombre(rs.getString("nombre"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           estadoEstudio = null;
        }   
        return estadoEstudio;
    }

    @Override
    public List<EstadoEstudio> mostrarEstadoEstudio() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarEstadoEstudio";
        List<EstadoEstudio> estadosEstudio = null;
        EstadoEstudio estadoEstudio;

        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            estadosEstudio =  new ArrayList<>();
            
            while(rs.next()){
                estadoEstudio = new EstadoEstudio();
                estadoEstudio.setIdEstadoEstudio(rs.getInt("idEstadoEstudio"));
                estadoEstudio.setNombre(rs.getString("nombre"));

                estadosEstudio.add(estadoEstudio);
            }
		
		conn.close();
		cstmt.close();
		rs.close();

        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estadosEstudio = null;
	}
        return estadosEstudio;
    }

    @Override
    public int agregarEstadoEstudio(EstadoEstudio estadoEstudio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoEstadoEstudio(int idEstadoEstudio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarEstadoEstudio(EstadoEstudio estadoEstudio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
