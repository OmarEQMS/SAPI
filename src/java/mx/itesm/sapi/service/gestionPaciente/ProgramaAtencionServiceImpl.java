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
import mx.itesm.sapi.bean.gestionPaciente.ProgramaAtencion;

/**
 *
 * @author urieldiaz
 */
public class ProgramaAtencionServiceImpl implements ProgramaAtencionService{

    @Override
    public ProgramaAtencion mostrarProgramaAtencion(int idProgramaAtencion) {
        Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        
        ProgramaAtencion programaAtencion = new ProgramaAtencion();
        
        String stProcedure ="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();
            
            programaAtencion.setIdProgramaAtencion(rs.getInt("idProgramaAtencion"));
            programaAtencion.setIdPrograma(rs.getInt("idPrograma"));
            programaAtencion.setIdAtencion(rs.getInt("idAtencion"));
            programaAtencion.setEstatus(rs.getInt("idSeguro"));
            
        
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            programaAtencion = null;
        }
        return programaAtencion;
    }

    @Override
    public List<ProgramaAtencion> mostrarProgramaAtencion() {
        Connection conn;
        List<ProgramaAtencion> listProgramaAtencion = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure="";
        
        ResultSet rs;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            ProgramaAtencion programaAtencion;
            
            while(rs.next()){
                programaAtencion = new ProgramaAtencion();
                programaAtencion.setIdProgramaAtencion(rs.getInt("idProgramaAtencion"));
                programaAtencion.setIdPrograma(rs.getInt("idPrograma"));
                programaAtencion.setIdAtencion(rs.getInt("idAtencion"));
                programaAtencion.setEstatus(rs.getInt("idSeguro"));
                
                listProgramaAtencion.add(programaAtencion);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listProgramaAtencion = null;
        }
        return listProgramaAtencion;
       
    }

    @Override
    public int agregarProgramaAtencion(ProgramaAtencion programaAtencion) {
        Connection conn; 
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        String stPrcedure="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);
            
            cstmt.setInt(1, programaAtencion.getIdProgramaAtencion());
            cstmt.setInt(2, programaAtencion.getIdPrograma());
            cstmt.setInt(3, programaAtencion.getIdAtencion());
            cstmt.setInt(4, programaAtencion.getEstatus() );
          
            
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
    public boolean borradoLogicoProgramaAtencion(int idProgramaAtencion) {
         Connection conn; 
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito = false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idProgramaAtencion);
            
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
    public boolean actualizarProgramaAtencion(ProgramaAtencion programaAtencion) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito= false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, programaAtencion.getIdProgramaAtencion());
            cstmt.setInt(2, programaAtencion.getIdPrograma());
            cstmt.setInt(3, programaAtencion.getIdAtencion());
            cstmt.setInt(4, programaAtencion.getEstatus() );
            
            
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
