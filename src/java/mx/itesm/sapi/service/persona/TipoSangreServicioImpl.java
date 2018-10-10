/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.persona.TipoSangre;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class TipoSangreServicioImpl implements TipoSangreServicio{

    @Override
    public boolean borradoLogicoTipoSangre(int idTipoSangre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoSangre mostrarTipoDeSangre(int idTipoSangre) {
       Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        TipoSangre tipoSangre = new TipoSangre();
        
        //Call del store procedure
        String stProcedure="mostrarTipoSangre";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idTipoSangre);
            
            ResultSet rs = cstmt.executeQuery();
            
         
            
            rs.next();
            tipoSangre.setIdTipoSangre(rs.getInt("idTipoSangre"));
            tipoSangre.setNombre(rs.getString("nombre"));
            tipoSangre.setEstatus(rs.getInt("estatus"));
            
            
           
            return tipoSangre;
        }catch(SQLException ex){
            
            System.out.println("Estoy en el catch de mostrarTipoSangre ");
            System.out.println(ex.getMessage());
            return tipoSangre;
        }
    }

    @Override
    public List<TipoSangre> mostrarTipoDeSangre() {
        Connection conn = Conexion.getConnection();
        
        
        List<TipoSangre> tiposSangre = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL getTipoSangre()");
            ResultSet rs = cstmt.executeQuery();
            TipoSangre tipoSangre;
            
            while(rs.next()){
                
                tipoSangre = new TipoSangre();
                
            tipoSangre.setIdTipoSangre(rs.getInt(1));
            tipoSangre.setNombre(rs.getString(2));
            tipoSangre.setEstatus(rs.getInt(3));
                
                tiposSangre.add(tipoSangre);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(SQLException ex){
            System.out.println("ERROR GET tiposSangre" + ex.getMessage());
        }
        
        return tiposSangre;
    }

    @Override
    public int agregarTipoSangre(TipoSangre tipoDeSangre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarTipoSangre(TipoSangre tipoSangre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
