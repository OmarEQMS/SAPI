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
import mx.itesm.sapi.bean.gestionPaciente.Estudio;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class EstudioServicioImpl implements EstudioServicio {

    @Override
    public Estudio mostrarEstudio(int idEstudio) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarEstudio";
        Estudio estudio = null;
     
        try {
            conn = Conexion.getConnection();
            estudio = new Estudio();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEstudio);
                  
            rs = cstmt.executeQuery();
            rs.next();
            estudio.setIdEstudio(rs.getInt("idEstudio"));
            estudio.setIdPiso(rs.getInt("idPiso"));
            estudio.setIdCategoriaEstudio(rs.getInt("idCategoriaEstudio"));
            estudio.setNombre(rs.getString("nombre"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           estudio = null;
        }   
        return estudio;
    }

    @Override
    public List<Estudio> mostrarEstudio() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarEstudio";
        List<Estudio> estudios = null;
        Estudio estudio;

        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            estudios =  new ArrayList<>();
            
            while(rs.next()){
                estudio = new Estudio();
                estudio.setIdEstudio(rs.getInt("idEstudio"));
                estudio.setIdPiso(rs.getInt("idPiso"));
                estudio.setIdCategoriaEstudio(rs.getInt("idCategoriaEstudio"));
                estudio.setNombre(rs.getString("nombre"));

                estudios.add(estudio);
            }
		
		conn.close();
		cstmt.close();
		rs.close();

        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estudios = null;
	}
        return estudios;
    }

    @Override
    public int agregarEstudio(Estudio estudio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoEstudio(int idEstudio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarEstudio(Estudio estudio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // OMAR
    public Estudio mostrarEstudio(String nombre){
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarEstudioPorNombre(?)";
        Estudio estudio = null;

        try {
            conn = Conexion.getConnection();
            estudio = new Estudio();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setString(1, nombre);                  
            rs = cstmt.executeQuery();
            rs.next();
            estudio.setIdEstudio(rs.getInt("idEstudio"));
            estudio.setIdCategoriaEstudio(rs.getInt("idCategoriaEstudio"));
            estudio.setNombre(rs.getString("nombre"));
            
            conn.close();
            cstmt.close();
            rs.close();            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           estudio = null;
        }   
        return estudio;
    }
}
