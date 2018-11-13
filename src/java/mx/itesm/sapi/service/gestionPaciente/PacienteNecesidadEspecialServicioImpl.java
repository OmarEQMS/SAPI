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
import mx.itesm.sapi.bean.gestionPaciente.PacienteNecesidadEspecial;

/**
 *
 * @author Uriel Díaz
 */
public class PacienteNecesidadEspecialServicioImpl implements PacienteNecesidadEspecialServicio{

    @Override
    public PacienteNecesidadEspecial mostrarPacienteNecesidadEspecial(int idPacienteNecesidadEspecial) {
        Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        
        PacienteNecesidadEspecial pacienteNecesidadEspecial = new PacienteNecesidadEspecial();
        
        String stProcedure ="CALL mostrarPacienteNecesidadEspecial(?)";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPacienteNecesidadEspecial);
            rs = cstmt.executeQuery();
            rs.next();
            
            pacienteNecesidadEspecial.setIdNecesidadEspecial(rs.getInt("idPaciente"));
            pacienteNecesidadEspecial.setIdPaciente(rs.getInt("idCuenta"));
            pacienteNecesidadEspecial.setIdNecesidadEspecial(rs.getInt("idEscolaridad"));
            pacienteNecesidadEspecial.setEstatus(rs.getInt("idSeguro"));
           
        
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacienteNecesidadEspecial = null;
        }
        return pacienteNecesidadEspecial;
    }

    @Override
    public List<PacienteNecesidadEspecial> mostrarPacienteNecesidadEspecial() {
        Connection conn;
        List<PacienteNecesidadEspecial> listpacienteNecesidadEspecial = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure="CALL mostrarListaPacienteNecesidadEspecial()";
        
        ResultSet rs;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            PacienteNecesidadEspecial pacienteNecesidadEspecial;
            
            while(rs.next()){
                pacienteNecesidadEspecial = new PacienteNecesidadEspecial();
                pacienteNecesidadEspecial.setIdNecesidadPaciente(rs.getInt("idNecesidadPaciente"));
                pacienteNecesidadEspecial.setIdPaciente(rs.getInt("idPaciente"));
                pacienteNecesidadEspecial.setIdNecesidadEspecial(rs.getInt("idNecesidadEspecial"));
                pacienteNecesidadEspecial.setEstatus(rs.getInt("estatus"));
                
                listpacienteNecesidadEspecial.add(pacienteNecesidadEspecial);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listpacienteNecesidadEspecial = null;
        }
        return listpacienteNecesidadEspecial;
        
    }

    @Override
    public int agregarPacienteNecesidadEspecial(PacienteNecesidadEspecial pacienteNecesidadEspecial) {
         Connection conn; 
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;
        String stPrcedure="CALL agregarPacienteNecesidadEspecial(?,?)";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);
                        
            cstmt.setInt(1, pacienteNecesidadEspecial.getIdPaciente());
            cstmt.setInt(2, pacienteNecesidadEspecial.getIdNecesidadEspecial());            
                        
            cstmt.executeQuery();
            rs = cstmt.getGeneratedKeys();
            rs.next();
            id=rs.getInt(1);
            
            //System.out.println("INT IdNecesidadEspecial ".concat(String.valueOf(id)));
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
    public boolean borradoLogicoPacienteNecesidadEspecial(int idPacienteNecesidadEspecial) {
        Connection conn; 
        CallableStatement cstmt;
        String stProcedure = "CALL borradoLogicoPacienteNecesidadEspecial(?)";
        boolean exito = false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPacienteNecesidadEspecial);
            
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
    public boolean actualizarPacienteNecesidadEspecial(PacienteNecesidadEspecial pacienteNecesidadEspecial) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "CALL actualizarPacienteNecesidadEspecial(?, ?)";
        boolean exito= false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
             cstmt.setInt(1, pacienteNecesidadEspecial.getIdNecesidadPaciente());
            cstmt.setInt(2, pacienteNecesidadEspecial.getIdPaciente());
            cstmt.setInt(3, pacienteNecesidadEspecial.getIdNecesidadEspecial());
            cstmt.setInt(4, pacienteNecesidadEspecial.getEstatus() );
            
            
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
    public PacienteNecesidadEspecial mostrarPacienteNecesidadEspecialIdPaciente(int idPaciente) {
     Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        
        PacienteNecesidadEspecial pacienteNecesidadEspecial = new PacienteNecesidadEspecial();
        
        String stProcedure ="CALL mostrarPacienteNecesidadEspecialIdPaciente(?)";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);
            rs = cstmt.executeQuery();
            rs.next();
            
            pacienteNecesidadEspecial.setIdNecesidadEspecial(rs.getInt("idNecesidadPaciente"));
            pacienteNecesidadEspecial.setIdPaciente(rs.getInt("idPaciente"));
            pacienteNecesidadEspecial.setIdNecesidadEspecial(rs.getInt("idNecesidadEspecial"));
            pacienteNecesidadEspecial.setEstatus(rs.getInt("estatus"));
           
        
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacienteNecesidadEspecial = null;
        }
        return pacienteNecesidadEspecial;
    }
    
}
