/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.moduloGestionMedico;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import mx.itesm.sapi.bean.moduloGestionMedico.DepartamentoDepartamentoInterno;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author feror
 */
public class DepartamentoDepartamentoInternoServicioImpl implements DepartamentoDepartamentoInternoServicio {

    @Override
    public DepartamentoDepartamentoInterno mostrarDepartamentoDepartamentoInterno(int idDepartamentoDepartamentoInterno) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        DepartamentoDepartamentoInterno departamentoDepartamentoInterno = new DepartamentoDepartamentoInterno();
        
        //Call del store procedure
        String stProcedure="-----";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idDepartamentoDepartamentoInterno);

            ResultSet rs = cstmt.executeQuery();
            
         
            
            rs.next();
            departamentoDepartamentoInterno.setIdDepartamentoDepartamentoInterno(rs.getInt(1));
            departamentoDepartamentoInterno.setIdDepartamentoPadre(rs.getInt(2));
            departamentoDepartamentoInterno.setIdDepartamento(rs.getInt(3));
            
            
           
            return departamentoDepartamentoInterno;
        }catch(SQLException ex){
            
            System.out.println("Estoy en el catch de mostrarDepartamentoDepartamentoInterno");
            System.out.println(ex.getMessage());
            return departamentoDepartamentoInterno;
        }
    }

    @Override
    public int agregarDepartamentoDepartamentoInterno(DepartamentoDepartamentoInterno departamentoDepartamentoInterno) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        int id=0;
        //Aquí va el call del procedure
        String stProcedure="-------";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            //Aquí van los sets

            cstmt.setInt(1,departamentoDepartamentoInterno.getIdDepartamentoPadre());
            cstmt.setInt(2,departamentoDepartamentoInterno.getIdDepartamento());

            
            
            //Aquí va el registerOutParameter
            //cstmt.registerOutParameter(12,Types.INTEGER);
            
            cstmt.executeUpdate();
            
            ResultSet rs = cstmt.getGeneratedKeys();
            
            rs.next();
            
           id=rs.getInt(1);
           
           cstmt.close();
            
        }catch(SQLException ex){
            
             System.out.println("Estoy en el catch de registrarDepartamentoDepartamentoInterno");
            System.out.println(ex.getMessage());
            
        }
        
        
        return id;
    }

    @Override
    public boolean borradoLogicoDepartamentoDepartamentoInterno(int idDepartamentoDepartamentoInterno) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        //Call del store procedure
        String stProcedure="";
        
        
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,idDepartamentoDepartamentoInterno);
            
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            
           return rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            System.out.println("Estoy en el catch de borradoLogicoDepartamentoDepartamentoInterno");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizarDepartamentoDepartamentoInterno(DepartamentoDepartamentoInterno departamentoDepartamentoInterno) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        //Call del store procedure
        String stProcedure="";
        
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1,departamentoDepartamentoInterno.getIdDepartamentoDepartamentoInterno());
            cstmt.setInt(2,departamentoDepartamentoInterno.getIdDepartamentoPadre());
            cstmt.setInt(3,departamentoDepartamentoInterno.getIdDepartamento());
            
            
            ResultSet rs = cstmt.executeQuery();
            
            rs.next();
            
           return rs.getBoolean(1);
            
            
        }catch(SQLException ex){
            System.out.println("Estoy en el catch de actualizarDepartamentoDepartamentoInterno");
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
}
