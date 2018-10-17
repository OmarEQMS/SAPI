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
import mx.itesm.sapi.bean.gestionTratamiento.Tratamiento;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Admin
 */
public class TratamientoServiceImpl implements TratamientoService{

    @Override
    public Tratamiento mostrarTratamiento(int idTratamiento) {
                        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        Tratamiento tratamiento = null;
        
        //Call del stored procedure
        String stProcedure="CALL mostrarTratamiento(?)";
        
        try {    
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            tratamiento = new Tratamiento();
            
            cstmt.setInt(1, idTratamiento);
            rs = cstmt.executeQuery();
            
            // Asignación de valores devuletos a tratamiento
            rs.next();
            tratamiento.setIdTratamiento(rs.getInt("idTratamiento"));
            tratamiento.setNombre(rs.getString("nombre"));
            tratamiento.setEstatus(rs.getInt("estatus"));
            
        } catch (SQLException ex) {
            tratamiento = null;
            System.out.println("ID: " + idTratamiento);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return tratamiento;
    }

    @Override
    public List<Tratamiento> mostrarTratamiento() {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<Tratamiento> tratamientos = null;
        
        //Call del store procedure
        String stProcedure="CALL mostrarListaTratamiento()";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            tratamientos = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            Tratamiento tratamiento;
            
            while(rs.next()){
                
                tratamiento = new Tratamiento();
                tratamiento.setIdTratamiento(rs.getInt(1));
                tratamiento.setNombre(rs.getString(2));
                tratamiento.setEstatus(rs.getInt(3));
                
                tratamientos.add(tratamiento);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception ex){
            tratamientos = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return tratamientos;
    }
    
}
