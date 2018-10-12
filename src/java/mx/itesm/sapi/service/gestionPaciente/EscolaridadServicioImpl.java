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
import mx.itesm.sapi.bean.gestionPaciente.Escolaridad;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class EscolaridadServicioImpl implements EscolaridadServicio {

    @Override
    public Escolaridad mostrarEscolaridad(int idEscolaridad) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarEscolaridad";
        Escolaridad escolaridad = null;
     
        try {
            conn = Conexion.getConnection();
            escolaridad = new Escolaridad();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEscolaridad);
                  
            rs = cstmt.executeQuery();
            rs.next();
            escolaridad.setIdEscolaridad(rs.getInt("idEscolaridad"));
            escolaridad.setNombre(rs.getString("nombre"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           escolaridad = null;
        }   
        return escolaridad;
    }

    @Override
    public List<Escolaridad> mostrarEscolaridad() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarEscolaridad";
        List<Escolaridad> Escolaridades = null;
        Escolaridad escolaridad;

        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            Escolaridades =  new ArrayList<>();
            
            while(rs.next()){
                escolaridad = new Escolaridad();
                escolaridad.setIdEscolaridad(rs.getInt("idEscolaridad"));
                escolaridad.setNombre(rs.getString("nombre"));

                Escolaridades.add(escolaridad);
            }
		
		conn.close();
		cstmt.close();
		rs.close();

        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            Escolaridades = null;
	}
        return Escolaridades;
    }

    @Override
    public int agregarEscolaridad(Escolaridad escolaridad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoEscolaridad(int idEscolaridad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarEscolaridad(Escolaridad escolaridad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
