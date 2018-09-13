/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import mx.itesm.sapi.bean.Direccion;
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
        
        String sql="INSERT INTO direccion ( calle, noInterior, noExterior, colonia, idPersona) "
                  .concat(" VALUES ( ?, ?, ?, ?, ?)");
        
          System.out.println(sql); 
       
           
           PreparedStatement ps;
           
           try {
            
            ps = conn.prepareStatement(sql);
            
           
            ps.setString(1, direccion.getCalle());
            ps.setString(2, direccion.getNoInterior());
            ps.setString(3, direccion.getNoExterior());
            ps.setString(4, direccion.getColonia());
            ps.setInt(5, direccion.getIdPersona());
  
           return !ps.execute();
            
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
