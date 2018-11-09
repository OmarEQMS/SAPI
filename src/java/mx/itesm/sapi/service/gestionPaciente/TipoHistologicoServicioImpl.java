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
import mx.itesm.sapi.util.Conexion;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.TipoHistologico;

/**
 *
 * @author Uriel Díaz & Alexis España
 */
public class TipoHistologicoServicioImpl implements TipoHistologicoServicio{

    @Override
    public TipoHistologico mostrarTipoHistologico(int idTipoHistologico) {
        Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        
        TipoHistologico tipoHistologico = new TipoHistologico();
        
        String stProcedure ="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();
            
            tipoHistologico.setIdTipoHistologico(rs.getInt("idTipoHistologico"));
            tipoHistologico.setNombre(rs.getString("nombre"));
            tipoHistologico.setEstatus(rs.getInt("estatus"));
            
        
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            tipoHistologico= null;
        }
        return tipoHistologico;
    }

    @Override
    public List<TipoHistologico> mostraTipoHistologico() {
        Connection conn;
        List<TipoHistologico> listTipoHistologico = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure="CALL mostrarListaTipoHistologico(?)";
        
        ResultSet rs;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            TipoHistologico tipoHistologico;
            
            while(rs.next()){
                tipoHistologico = new TipoHistologico();
                tipoHistologico.setIdTipoHistologico(rs.getInt("idTipoHistologico"));
                tipoHistologico.setNombre(rs.getString("nombre"));
                tipoHistologico.setEstatus(rs.getInt("estatus"));                
                listTipoHistologico.add(tipoHistologico);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listTipoHistologico = null;
        }
        return listTipoHistologico;
    }
    

}
