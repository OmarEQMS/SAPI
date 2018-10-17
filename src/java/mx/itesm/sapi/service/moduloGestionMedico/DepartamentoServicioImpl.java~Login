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
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.Departamento;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author feror
 */
public class DepartamentoServicioImpl implements DepartamentoServicio{

    @Override
    public Departamento mostrarDepartamento(int idDepartamento) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        Departamento departamento = new Departamento();
        
        //Call del store procedure
        String stProcedure="CALL estado(?)";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, idDepartamento);

            ResultSet rs = cstmt.executeQuery();
            
         
            
            rs.next();
            departamento.setIdDepartamento(rs.getInt(1));
            departamento.setNombre(rs.getString(2));
            departamento.setEstatus(rs.getInt(3));
            
            
           
            return departamento;
        }catch(SQLException ex){
            
            System.out.println("Estoy en el catch de mostrarDepartamento");
            System.out.println(ex.getMessage());
            return departamento;
        }
    }

    @Override
    public List<Departamento> mostrarDepartamento() {
        Connection conn = Conexion.getConnection();
        
        
        List<Departamento> departamentos = new ArrayList<>();
        CallableStatement cstmt;
        
        try{
            
            
            cstmt = conn.prepareCall("CALL -----");
            ResultSet rs = cstmt.executeQuery();
            Departamento departamento;
            
            while(rs.next()){
                
                departamento = new Departamento();
                
                departamento.setIdDepartamento(rs.getInt(1));
                departamento.setNombre(rs.getString(2));
                departamento.setEstatus(rs.getInt(3));
                
                departamentos.add(departamento);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception e){
            System.out.println("ERROR GET ESTADOS" + e.getMessage());
        }
        
        return departamentos;
    }

   
    
    
}
