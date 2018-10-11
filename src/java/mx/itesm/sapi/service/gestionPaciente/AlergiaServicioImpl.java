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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Alergia;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class AlergiaServicioImpl implements AlergiaServicio{

    @Override
    public Alergia mostrarAlergia(int idAlergia) {
         Connection conn;
         CallableStatement cstmt;
         ResultSet rs;
         String stProcedure = "---";
         Alergia alergia = null;
     
        try {
            conn = Conexion.getConnection();
            alergia = new Alergia();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idAlergia);
                  
            rs = cstmt.executeQuery();
            rs.next();
            alergia.setIdAlergia(rs.getInt("idAlergia"));
            alergia.setNombre(rs.getString("nombre"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           alergia = null;
        }   
        return alergia;
    }

    @Override
    public List<Alergia> mostrarAlergia() {
        return null;
    }

    @Override
    public int agregarAlergia(Alergia alergia) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "";
        int id = -1;
        
	try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setString(1,alergia.getNombre());
            
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
    public boolean borradoLogicoAlergia(int idAlergia) {
        Connection conn;
	CallableStatement cstmt;
        String stProcedure = "";
        boolean exito = false;

	try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idAlergia);
            cstmt.registerOutParameter(1, Types.BOOLEAN);
            
            cstmt.executeUpdate();
            exito = cstmt.getBoolean(1);
            
            
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
    public boolean actualizarAlergia(Alergia  alergia) {
        Connection conn;
	CallableStatement cstmt;
        String stProcedure = "";
        boolean exito = false;

	try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setString(1, alergia.getNombre());
            cstmt.registerOutParameter(1, Types.BOOLEAN);
            
            cstmt.executeUpdate();
            exito = cstmt.getBoolean(1);
            
            conn.close();
            cstmt.close();
	}catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
	}
        return exito;
    }
    
}
