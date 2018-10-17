/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionTratamiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionTratamiento.Farmaco;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Admin
 */
public class FarmacoServiceImpl implements FarmacoService{

    @Override
    public Farmaco mostrarFarmaco(int idFarmaco) {
                        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        Farmaco farmaco = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarFarmaco(?)";
        
        try {    
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            farmaco = new Farmaco();
            
            cstmt.setInt(1, idFarmaco);
            rs = cstmt.executeQuery();
            
            // Asignación de valores devuletos a farmaco
            rs.next();
            farmaco.setIdFarmaco(rs.getInt("idFarmaco"));
            farmaco.setNombre(rs.getString("nombre"));
            farmaco.setEstatus(rs.getInt("estatus"));
            
        } catch (SQLException ex) {
            farmaco = null;
            System.out.println("ID: " + idFarmaco);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return farmaco;
    }

    @Override
    public List<Farmaco> mostrarFarmaco() {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<Farmaco> farmacos = null;
        
        //Call del store procedure
        String stProcedure="CALL mostrarListaFarmaco()";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            farmacos = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            Farmaco farmaco;
            
            while(rs.next()){
                
                farmaco = new Farmaco();
                farmaco.setIdFarmaco(rs.getInt(1));
                farmaco.setNombre(rs.getString(2));
                farmaco.setEstatus(rs.getInt(3));
                
                farmacos.add(farmaco);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception ex){
            farmacos = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return farmacos;
    }

}
