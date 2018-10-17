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
import mx.itesm.sapi.bean.gestionPaciente.CategoriaEstudio;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class CategoriaEstudioServicioImpl implements CategoriaEstudioServicio{

    @Override
    public CategoriaEstudio mostrarCategoriaEstudio(int idCategoriaEstudio) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarCategoriaEstudio";
        CategoriaEstudio categoriaEstudio = null;
     
        try {
            conn = Conexion.getConnection();
            categoriaEstudio = new CategoriaEstudio();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idCategoriaEstudio);
                  
            rs = cstmt.executeQuery();
            rs.next();
            categoriaEstudio.setIdCategoriaEstudio(rs.getInt("idCategoriaEstudio"));
            categoriaEstudio.setNombre(rs.getString("nombre"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           categoriaEstudio = null;
        }   
        return categoriaEstudio;
    }

    @Override
    public List<CategoriaEstudio> mostrarCategoriaEstudio() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarCategoriaEstudio";
        List<CategoriaEstudio> categoriaEstudios = null;
        CategoriaEstudio categoriaEstudio;

        try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            categoriaEstudios =  new ArrayList<>();
            
            while(rs.next()){
                categoriaEstudio = new CategoriaEstudio();
                categoriaEstudio.setIdCategoriaEstudio(rs.getInt("idCategoriaEstudio"));
                categoriaEstudio.setNombre(rs.getString("nombre"));

                categoriaEstudios.add(categoriaEstudio);
            }
		
		conn.close();
		cstmt.close();
		rs.close();

        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            categoriaEstudios = null;
	}
        return categoriaEstudios;
    }

    @Override
    public int agregarCategoriaEstudio(CategoriaEstudio categoriaEstudio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoCategoriaEstudio(int idCategoriaEstudio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarCategoriaEstudio(CategoriaEstudio categoriaEstudio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
