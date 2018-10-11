/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mx.itesm.sapi.util.Conexion;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.ResultadoPatologia;

/**
 *
 * @author urieldiaz
 */
public class ResultadoPatologiaServiceImpl implements ResultadoPatologiaService{

    @Override
    public ResultadoPatologia mostrarResultadoPatologia(int idResultadoPatologia) {
        Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        
        ResultadoPatologia resultadoPatologia = new ResultadoPatologia();
        
        String stProcedure ="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();
            
            resultadoPatologia.setIdResultadoPatologia(rs.getInt("idResultadoPatologia"));
            resultadoPatologia.setNombre(rs.getString("nombre"));
           
        
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            resultadoPatologia= null;
        }
        return resultadoPatologia;
    }

    @Override
    public List<ResultadoPatologia> mostrarAllResultadoPatologia() {
        Connection conn;
        List<ResultadoPatologia> listResultadoPatologia = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure="";
        
        ResultSet rs;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            ResultadoPatologia resultadoPatologia;
            
            while(rs.next()){
                resultadoPatologia = new ResultadoPatologia();
                resultadoPatologia.setIdResultadoPatologia(rs.getInt("idResultadoPatologia"));
                resultadoPatologia.setNombre(rs.getString("nombre"));
                
                listResultadoPatologia.add(resultadoPatologia);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listResultadoPatologia = null;
        }
        return listResultadoPatologia;
        
    }

    @Override
    public int agregarResultadoPatologia(ResultadoPatologia resultadoPatologia) {
        Connection conn; 
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        String stPrcedure="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);
            
            cstmt.setInt(1, resultadoPatologia.getIdResultadoPatologia());
            cstmt.setString(2, resultadoPatologia.getNombre());
            
           
            
            cstmt.executeUpdate();
            rs = cstmt.getGeneratedKeys();
            rs.next();
            id=rs.getInt(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
        }
        
        return id;
    }

    @Override
    public boolean borradoLogicoResultadoPatologia(int idResultadoPatologia) {
        Connection conn; 
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito = false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idResultadoPatologia);
            
            rs = cstmt.executeQuery();
            rs.next();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch( SQLException ex){
           
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito=false;
        }
        return exito;
    }

    @Override
    public boolean actualizarResultadoPatologia(ResultadoPatologia resultadoPatologia) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito= false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, resultadoPatologia.getIdResultadoPatologia());
            cstmt.setString(2, resultadoPatologia.getNombre());
            
            rs = cstmt.executeQuery();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito=false;
        }
        return exito;
    }
    
}
