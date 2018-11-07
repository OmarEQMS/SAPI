/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.Connection;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.util.Conexion;
import mx.itesm.sapi.bean.gestionPaciente.GradoHistologico;

/**
 *
 * @author Alexis España
 */
public class GradoHistologicoServicioImpl implements GradoHistologicoServicio{

    @Override
    public GradoHistologico mostrarTipoHistologico(int idTipoHistologico) {
      Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        
        GradoHistologico gradoHistologico = new GradoHistologico();
        
        String stProcedure ="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();
            
            gradoHistologico.setIdGradoHistologico (rs.getInt("idGradoHistologico"));
            gradoHistologico.setNombre(rs.getString("nombre"));
            gradoHistologico.setEstatus(rs.getInt("estatus"));
            
        
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            gradoHistologico= null;
        }
        return gradoHistologico;  
    }

    @Override
    public List<GradoHistologico> mostrarGradoHistologico() {
        Connection conn;
        List<GradoHistologico> listGradoHistologico = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure="";
        
        ResultSet rs;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            GradoHistologico gradoHistologico;
            
            while(rs.next()){
                gradoHistologico = new GradoHistologico();
                gradoHistologico.setIdGradoHistologico (rs.getInt("idGradoHistologico"));
                gradoHistologico.setNombre(rs.getString("nombre"));
                gradoHistologico.setEstatus(rs.getInt("estatus"));
                
                listGradoHistologico.add(gradoHistologico);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listGradoHistologico = null;
        }
        return listGradoHistologico;
    }
    
}
