/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import mx.itesm.sapi.bean.persona.Direccion;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author feror
 */
public class DireccionServicioImpl implements DireccionServicio{

    @Override
    public Direccion getPersona(int idDireccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveDireccion(Direccion direccion) {
         Connection conn = Conexion.getConnection();
           CallableStatement cstmt;
           
           try {
            
            cstmt = conn.prepareCall("CALL insertaDireccion(?,?,?,?,?,?)");
            
            
            cstmt.setString(1, direccion.getCalle());
            cstmt.setString(2, direccion.getNoInterior());
            cstmt.setString(3, direccion.getNoExterior());
            cstmt.setString(4, direccion.getColonia());
            cstmt.setInt(5, direccion.getIdPersona());
            cstmt.registerOutParameter(6,Types.INTEGER);
  
           return !cstmt.execute();
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            return false;
        }
           
       
       
    }

    @Override
    public boolean deleteDireccion(int idDireccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updatePersona(Direccion direccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
