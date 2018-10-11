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
public class CategoriaEstudioServiceImpl implements CategoriaEstudioService{

    @Override
    public CategoriaEstudio mostrarCategoriaEstudio(int idCategoriaEstudio) {
        Connection conn;
	CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "---";
        CategoriaEstudio categoriaestudio = null;

	try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1,idCategoriaEstudio);

            rs = cstmt.executeQuery();
            rs.next();
            categoriaestudio.setIdCategoriaEstudio(rs.getInt("idCategoriaEstudio"));
            categoriaestudio.setNombre(rs.getString("nombre"));
            
            conn.close();
            cstmt.close();
            rs.close();
	}catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            categoriaestudio = null;
	}
            return categoriaestudio;
    }

    @Override
    public List<CategoriaEstudio> mostrarCategoriaEstudio() {
        Connection conn;
	CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "---";
        
        List<CategoriaEstudio> categoriasestudio = null;
        CategoriaEstudio categoriaestudio;
	try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            categoriasestudio =  new ArrayList<>();
            
            while(rs.next())
            {
                categoriaestudio = new CategoriaEstudio();
                categoriaestudio.setIdCategoriaEstudio(rs.getInt("idCategoriaEstudio"));
                categoriaestudio.setNombre(rs.getString("nombre"));
                categoriasestudio.add(categoriaestudio);
            }
            conn.close();
            cstmt.close();
            rs.close();
	}catch(SQLException ex){
            System.out.println(this.getClass().toString()
            .concat(ex.getMessage()));
            categoriasestudio = null;
	}
            return categoriasestudio;
    }

    @Override
    public int agregarCategoriaEstudio(CategoriaEstudio categoriaEstudio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarCategoriaEstudio(CategoriaEstudio categoriaEstudio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoCategoriaEstudio(int idCategoriaEstudio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
