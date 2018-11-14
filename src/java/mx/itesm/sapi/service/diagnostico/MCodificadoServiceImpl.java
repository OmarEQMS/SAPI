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
import mx.itesm.sapi.bean.diagnostico.MCodificado;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Diego Montoya
 */
public class MCodificadoServiceImpl implements MCodificadoService{

    @Override
    public MCodificado mostrarMCodificado(int idMCodificado) {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        MCodificado mCodificado = null;
        
        //Call del stored procedure
        String stProcedure="-----";
        
        try {    
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            mCodificado = new MCodificado();
            
            cstmt.setInt(1, idMCodificado);
            rs = cstmt.executeQuery();
            
            // Asignación de valores devuletos a mCodificado
            rs.next();
            mCodificado.setIdMCodificado(rs.getInt("idMCodificado"));
            mCodificado.setNombre(rs.getString("nombre"));
            mCodificado.setEstatus(rs.getInt("estatus"));
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            mCodificado = null;
            System.out.println("ID: " + idMCodificado);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return mCodificado;
    }

    @Override
    public List<MCodificado> mostrarMCodificado() {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<MCodificado> mCodificados = null;
        
        //Call del store procedure
        String stProcedure="CALL mostrarListaMCodificado()";
        
        try{
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            mCodificados = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            MCodificado mCodificado;
            
            while(rs.next()){
                
                mCodificado = new MCodificado();
                mCodificado.setIdMCodificado(rs.getInt("idMCodificado"));
                mCodificado.setNombre(rs.getString("nombre"));
                mCodificado.setEstatus(rs.getInt("estatus"));
                
                mCodificados.add(mCodificado);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception ex){
            mCodificados = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return mCodificados;
    }

}
