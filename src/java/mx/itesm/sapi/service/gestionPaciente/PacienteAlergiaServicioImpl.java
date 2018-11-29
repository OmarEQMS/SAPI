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
import mx.itesm.sapi.bean.gestionPaciente.PacienteAlergia;


/**
 *
 * @author Uriel Díaz
 */
public class PacienteAlergiaServicioImpl implements PacienteAlergiaServicio{

    @Override
    public PacienteAlergia mostrarPacienteAlergia(int idPacienteAlergia) {
        Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        
        PacienteAlergia pacienteAlergia = new PacienteAlergia();
        
        String stProcedure ="CALL mostrarPacienteAlergia(?)";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
             cstmt.setInt(1, idPacienteAlergia);
            rs = cstmt.executeQuery();
            rs.next();
            
            pacienteAlergia.setIdPacienteAlergia(rs.getInt("idPacienteAlergia"));
            pacienteAlergia.setIdPaciente(rs.getInt("idPaciente"));
            pacienteAlergia.setIdAlergia(rs.getInt("idAlergia"));
            pacienteAlergia.setEstatus(rs.getInt("estatus"));
            pacienteAlergia.setAlergia(rs.getString("alergia"));
            
        
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacienteAlergia= null;
        }
        return pacienteAlergia;
    }

    @Override
    public List<PacienteAlergia> mostrarPacienteAlergia() {
        Connection conn;
        List<PacienteAlergia> listPacienteAlergia = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure="CALL mostrarListaPacienteAlergia()";
        
        ResultSet rs;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            
            PacienteAlergia pacienteAlergia;
            
            while(rs.next()){
                pacienteAlergia = new PacienteAlergia();
                pacienteAlergia.setIdPacienteAlergia(rs.getInt("idPacienteAlergia"));
                pacienteAlergia.setIdPaciente(rs.getInt("idPaciente"));
                pacienteAlergia.setIdAlergia(rs.getInt("idAlergia"));
                pacienteAlergia.setEstatus(rs.getInt("estatus"));
                pacienteAlergia.setAlergia(rs.getString("alergia"));
                
                
                listPacienteAlergia.add(pacienteAlergia);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listPacienteAlergia = null;
        }
        return listPacienteAlergia;
    }

    @Override
    public int agregarPacienteAlergia(PacienteAlergia pacienteAlergia) {
       Connection conn; 
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        String stPrcedure="CALL agregarPacienteAlergia(?, ?, ?)";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);
            
            cstmt.setInt(1, pacienteAlergia.getIdPaciente());
            cstmt.setInt(2, pacienteAlergia.getIdAlergia());
            cstmt.setString(3, pacienteAlergia.getAlergia());
            
            
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
    public boolean actualizarPacienteAlergia(PacienteAlergia pacienteAlergia) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "CALL actualizarPacienteAlergia(?, ?)";
        boolean exito= false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, pacienteAlergia.getIdPacienteAlergia());
            cstmt.setString(2, pacienteAlergia.getAlergia());
           
            
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

    @Override
    public boolean borradoLogicoPacienteAlergia(int idPacienteAlergia) {
        Connection conn; 
        CallableStatement cstmt;
        String stProcedure = "CALL borradoLogicoPacienteAlergia(?)";
        boolean exito = false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPacienteAlergia);
            
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
    public PacienteAlergia mostrarPacienteAlergiaIdPaciente(int idPaciente) {
    Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        
        PacienteAlergia pacienteAlergia = new PacienteAlergia();
        
        String stProcedure ="CALL mostrarPacienteAlergiaIdPaciente(?)";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
             cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();
            rs.next();
            
            pacienteAlergia.setIdPacienteAlergia(rs.getInt("idPacienteAlergia"));
            pacienteAlergia.setIdPaciente(rs.getInt("idPaciente"));
            pacienteAlergia.setIdAlergia(rs.getInt("idAlergia"));
            pacienteAlergia.setEstatus(rs.getInt("estatus"));
            pacienteAlergia.setAlergia(rs.getString("alergia"));
            
        
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacienteAlergia= null;
        }
        return pacienteAlergia;
    }
    
}
