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
       Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        
        TipoSangre tipoSangre = null;
        
        //Call del store procedure
        String stProcedure="mostrarTipoSangre(?)";
        
        try{
            tipoSangre = new TipoSangre();
             conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idTipoSangre);
            
             rs = cstmt.executeQuery();
            
         
            
            rs.next();
            tipoSangre.setIdTipoSangre(rs.getInt("idTipoSangre"));
            tipoSangre.setNombre(rs.getString("nombre"));
            tipoSangre.setEstatus(rs.getInt("estatus"));
            
              rs.close();
            cstmt.close();
            conn.close();
           
            
        }catch(SQLException ex){
            
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
             tipoSangre=null;
        }
        return tipoSangre;
    }

    @Override
    public List<TipoSangre> mostrarTipoDeSangre() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        List<TipoSangre> tiposSangre = null;
        
        try{
            tiposSangre = new ArrayList<>();
             conn = Conexion.getConnection();
            cstmt = conn.prepareCall("mostrarListaTipoSangre()");
             rs = cstmt.executeQuery();
            TipoSangre tipoSangre;
            
            while(rs.next()){
                
                tipoSangre = new TipoSangre();
                
            tipoSangre.setIdTipoSangre(rs.getInt("idTipoSangre"));
            tipoSangre.setNombre(rs.getString("nombre"));
            tipoSangre.setEstatus(rs.getInt("estatus"));
                
                tiposSangre.add(tipoSangre);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(SQLException ex){
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
           tiposSangre=null;
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
