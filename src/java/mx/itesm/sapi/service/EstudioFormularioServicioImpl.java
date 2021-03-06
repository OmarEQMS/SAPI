/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.formulario.EstudioFormulario;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class EstudioFormularioServicioImpl implements EstudioFormularioServicio{

    @Override
    public List<EstudioFormulario> mostrarFormularioDinamicoFecha(int idPaciente, String nombreEstudio) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<EstudioFormulario> estudiosFormulario = null;
        
        String stProcedute = "CALL mostrarFormularioDinamicoFecha(?,?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedute);
            estudiosFormulario = new ArrayList<>();
            cstmt.setInt(1, idPaciente);
            cstmt.setString(2, nombreEstudio);
            rs = cstmt.executeQuery();
            EstudioFormulario estudioFormulario = null;
            
            while(rs.next())
            {
                estudioFormulario = new EstudioFormulario();
                estudioFormulario.setFecha(String.valueOf(new Date((rs.getTimestamp("FechaProgramada")).getTime())));
                
                estudiosFormulario.add(estudioFormulario);
            }
            
            conn.close();
            cstmt.close();
            rs.close();
            
        }catch(SQLException ex)
        {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estudiosFormulario = null;
        }
        return estudiosFormulario;
    }

    @Override
    public List<EstudioFormulario> mostrarFormularioDinamicoFechaTipo(int idPaciente, String nombreEstudio) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<EstudioFormulario> estudiosFormulario = null;
        
        String stProcedute = "CALL mostrarFormularioDinamicoFechaTipo(?,?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedute);
            cstmt.setInt(1, idPaciente);
            cstmt.setString(2, nombreEstudio);
            estudiosFormulario = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            EstudioFormulario estudioFormulario = null;
            
            while(rs.next())
            {
                estudioFormulario = new EstudioFormulario();
                estudioFormulario.setFecha(String.valueOf(new Date((rs.getTimestamp("FechaProgramada")).getTime())));
                estudioFormulario.setTipo(rs.getString("EstudioNombre"));
                
                estudiosFormulario.add(estudioFormulario);
            }
            
            conn.close();
            cstmt.close();
            rs.close();
            
        }catch(SQLException ex)
        {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estudiosFormulario = null;
        }
        return estudiosFormulario;
    }

    @Override
    public List<EstudioFormulario> mostrarFormularioDinamicoLTF(int idPaciente, String nombreEstudio) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<EstudioFormulario> estudiosFormulario = null;
        
        String stProcedute = "CALL mostrarFormularioDinamicoLTF(?,?)";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedute);
            estudiosFormulario = new ArrayList<>();
            cstmt.setInt(1, idPaciente);
            cstmt.setString(2, nombreEstudio);
            rs = cstmt.executeQuery();
            EstudioFormulario estudioFormulario = null;
            
            while(rs.next())
            {
                estudioFormulario = new EstudioFormulario();
                estudioFormulario.setFecha(String.valueOf(new Date((rs.getTimestamp("FechaProgramada")).getTime())));
                estudioFormulario.setTipo(rs.getString("EstudioNombre"));
                estudioFormulario.setLugarDelCuerpo(rs.getString("LugarCuerpo"));
                
                estudiosFormulario.add(estudioFormulario);
            }
            
            conn.close();
            cstmt.close();
            rs.close();
            
        }catch(SQLException ex)
        {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estudiosFormulario = null;
        }
        return estudiosFormulario;
    }
    
}
