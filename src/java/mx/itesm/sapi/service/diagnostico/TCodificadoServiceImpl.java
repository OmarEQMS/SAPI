/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.diagnostico;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.diagnostico.TCodificado;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Diego Montoya
 */
public class TCodificadoServiceImpl implements TCodificadoService {
    
    @Override
    public TCodificado mostrarTCodificado(int idTCodificado) {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        TCodificado tCodificado = null;
        
        //Call del stored procedure
        String stProcedure="-----";
        
        try {    
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            tCodificado = new TCodificado();
            
            cstmt.setInt(1, idTCodificado);
            rs = cstmt.executeQuery();
            
            // Asignación de valores devuletos a tCodificado
            rs.next();
            tCodificado.setIdTCodificado(rs.getInt("idTCodificado"));
            tCodificado.setNombre(rs.getString("nombre"));
            tCodificado.setEstatus(rs.getInt("estatus"));
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            tCodificado = null;
            System.out.println("ID: " + idTCodificado);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return tCodificado;
    }

    @Override
    public List<TCodificado> mostrarTCodificado() {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<TCodificado> tCodificados = null;
        
        //Call del store procedure
        String stProcedure="CALL mostrarListaTCodificado(?)";
        
        try{
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            tCodificados = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            TCodificado tCodificado;
            
            while(rs.next()){
                
                tCodificado = new TCodificado();
                tCodificado.setIdTCodificado(rs.getInt("idTCodificado"));
                tCodificado.setNombre(rs.getString("nombre"));
                tCodificado.setEstatus(rs.getInt("estatus"));
                
                tCodificados.add(tCodificado);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception ex){
            tCodificados = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return tCodificados;
    }
}
