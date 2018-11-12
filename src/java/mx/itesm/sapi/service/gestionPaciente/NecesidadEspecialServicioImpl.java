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
import mx.itesm.sapi.util.Conexion;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.NecesidadEspecial;

/**
 *
 * @author Uriel Díaz
 */
public class NecesidadEspecialServicioImpl implements NecesidadEspecialServicio{

    @Override
    public NecesidadEspecial mostrarNecesidadEspecial(int idNecesidadEspecial) {
        Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        
        NecesidadEspecial necesidadEspecial = new NecesidadEspecial();
        
        String stProcedure ="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();
            
            necesidadEspecial.setIdNecesidadEspecial(rs.getInt("idNecesidadEspecial"));
            necesidadEspecial.setNombre(rs.getString("nombre"));
            necesidadEspecial.setEstatus(rs.getInt("estatus"));
           
                   
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            necesidadEspecial = null;
        }
        return necesidadEspecial;
    }

    @Override
    public NecesidadEspecial mostrarNecesidadEspecial(String nombreNecesidadEspecial) {
         Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        NecesidadEspecial necesidadEspecial = new NecesidadEspecial();
        
        String stProcedure ="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();
            
            necesidadEspecial.setIdNecesidadEspecial(rs.getInt("idNecesidadEspecial"));
            necesidadEspecial.setNombre(rs.getString("nombre"));
            necesidadEspecial.setEstatus(rs.getInt("estatus"));
        
            
            rs.close();
            cstmt.close();
            conn.close();
            
            
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            necesidadEspecial = null;
        }
        return necesidadEspecial;
    }

    @Override
    public List<NecesidadEspecial> mostrarNecesidadEspecial() {
        Connection conn;
        List<NecesidadEspecial> listNecesidadEspecial = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure="";
        
        ResultSet rs;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            NecesidadEspecial necesidadEspecial;
            
            while(rs.next()){
                necesidadEspecial = new NecesidadEspecial();
                necesidadEspecial.setIdNecesidadEspecial(rs.getInt("idNecesidadEspecial"));
                necesidadEspecial.setNombre(rs.getString("nombre"));
                necesidadEspecial.setEstatus(rs.getInt("estatus"));
                
                listNecesidadEspecial.add(necesidadEspecial);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listNecesidadEspecial = null;
        }
        return listNecesidadEspecial;
    }

}
