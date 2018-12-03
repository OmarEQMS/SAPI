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
import mx.itesm.sapi.bean.gestionPaciente.MotivoConsulta;

/**
 *
 * @author Uriel Díaz
 */
public class MotivoConsultaServicioImpl implements MotivoConsultaServicio{

    @Override
    public MotivoConsulta mostrarMotivoConsulta(int idMotivoConsulta) {
        Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        
        MotivoConsulta motivoConsulta = new MotivoConsulta();
        
        String stProcedure ="CALL mostrarMotivoConsulta(?)";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idMotivoConsulta);
            rs = cstmt.executeQuery();            
            rs.next();
            
            motivoConsulta.setIdMotivoConsulta(rs.getInt("idMotivoConsulta"));
            motivoConsulta.setNombre(rs.getString("nombre"));
            motivoConsulta.setEstatus(rs.getInt("estatus"));
            
        
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            motivoConsulta= null;
        }
        return motivoConsulta;
    }

    @Override
    public MotivoConsulta mostrarMotivoConsulta(String nombreMotivoConsulta) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        MotivoConsulta motivoConsulta = new MotivoConsulta();
        
        String stProcedure ="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();
            
            motivoConsulta.setIdMotivoConsulta(rs.getInt("idMotivoConsulta"));
            motivoConsulta.setNombre(rs.getString("nombre"));
            motivoConsulta.setEstatus(rs.getInt("estatus"));
            
        
            
            rs.close();
            cstmt.close();
            conn.close();
            
            
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            motivoConsulta = null;
        }
        return motivoConsulta;
    }

    @Override
    public List<MotivoConsulta> mostrarMotivoConsulta() {
        Connection conn;
        List<MotivoConsulta> listMotivoConsulta = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure="";
        
        ResultSet rs;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            MotivoConsulta motivoConsulta;
            
            while(rs.next()){
                motivoConsulta = new MotivoConsulta();
                motivoConsulta.setIdMotivoConsulta(rs.getInt("idMotivoConsulta"));
                motivoConsulta.setNombre(rs.getString("nombre"));
                motivoConsulta.setEstatus(rs.getInt("estatus"));
           
                
                listMotivoConsulta.add(motivoConsulta);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listMotivoConsulta = null;
        }
        return listMotivoConsulta;
    } 
    
}
