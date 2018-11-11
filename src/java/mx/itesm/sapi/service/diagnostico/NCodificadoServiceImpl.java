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
import mx.itesm.sapi.bean.diagnostico.NCodificado;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Diego Montoya
 */
public class NCodificadoServiceImpl implements NCodificadoService{

    @Override
    public NCodificado mostrarNCodificado(int idNCodificado) {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        NCodificado nCodificados = null;
        
        //Call del stored procedure
        String stProcedure="-----";
        
        try {    
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            nCodificados = new NCodificado();
            
            cstmt.setInt(1, idNCodificado);
            rs = cstmt.executeQuery();
            
            // Asignación de valores devuletos a nCodificados
            rs.next();
            nCodificados.setIdNCodificado(rs.getInt("idNCodificado"));
            nCodificados.setNombre(rs.getString("nombre"));
            nCodificados.setEstatus(rs.getInt("estatus"));
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            nCodificados = null;
            System.out.println("ID: " + idNCodificado);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return nCodificados;
    }

    @Override
    public List<NCodificado> mostrarNCodificado() {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<NCodificado> nCodificadoss = null;
        
        //Call del store procedure
        String stProcedure="CALL mostrarListaNCodificado()";
        
        try{
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            nCodificadoss = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            NCodificado nCodificados;
            
            while(rs.next()){
                
                nCodificados = new NCodificado();
                nCodificados.setIdNCodificado(rs.getInt("idNCodificado"));
                nCodificados.setNombre(rs.getString("nombre"));
                nCodificados.setEstatus(rs.getInt("estatus"));
                
                nCodificadoss.add(nCodificados);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception ex){
            nCodificadoss = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return nCodificadoss;
    }

}
