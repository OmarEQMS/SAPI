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
import mx.itesm.sapi.bean.gestionPaciente.BIRADS;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class BIRADSServicioImpl implements BIRADSServicio {

    @Override
    public BIRADS mostrarBIRADS(int idBIRADS) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarBIRADS";
        BIRADS birads = null;
     
        try {
            conn = Conexion.getConnection();
            birads = new BIRADS();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idBIRADS);
                  
            rs = cstmt.executeQuery();
            rs.next();
            birads.setIdBirads(rs.getInt("idBIRADS"));
            birads.setNombre(rs.getString("nombre"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           birads = null;
        }   
        return birads;
    }

    @Override
    public List<BIRADS> mostrarBIRADS() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarBIRADS";
        List<BIRADS> listabirads = null;
        BIRADS birads;

        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            listabirads =  new ArrayList<>();
            
            while(rs.next()){
                birads = new BIRADS();
                birads.setIdBirads(rs.getInt("idBirads"));
                birads.setNombre(rs.getString("nombre"));

                listabirads.add(birads);
            }
		
		conn.close();
		cstmt.close();
		rs.close();

        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listabirads = null;
	}
        return listabirads;
    }

    @Override
    public int agregarBIRADS(BIRADS birads) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoBIRADS(int idBIRADS) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarBIRADS(BIRADS birads) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
