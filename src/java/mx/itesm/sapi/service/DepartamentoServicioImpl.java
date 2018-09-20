/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.Departamento;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Admin
 */
public class DepartamentoServicioImpl implements DepartamentoServicio {

    @Override
    public int saveDepartamento(Departamento deparatemento) {
        Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        int id=0;
        //Aquí va el call del procedure
        String sql="";
        
        try{
            
            cstmt = conn.prepareCall(sql);
            
            //Aquí van los sets
            
            //Aquí va el registerOutParameter
            
            cstmt.executeUpdate();
            
            ResultSet rs = cstmt.getGeneratedKeys();
            
            rs.next();
            
           id=cstmt.getInt(1);
           
           cstmt.close();
            
        }catch(SQLException ex){
            
             System.out.println("Estoy en el catch de DepartamentoServicio");
            System.out.println(ex.getMessage());
            
        }
               
        return id;        
        }

    @Override
    public List<Departamento> getDepartamentos() {
        Connection conn = Conexion.getConnection();
        
        
        List<Departamento> departamentos = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("");
            ResultSet rs = cstmt.executeQuery();
            Departamento departamento;
            
            while(rs.next()){
                
                departamento = new Departamento();
                
                departamento.setIdDepartamento(rs.getInt(1));
                departamento.setNombre(rs.getString(2));
                
                departamentos.add(departamento);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception e){
            System.out.println("ERROR GET DEPARTAMENTOS" + e.getMessage());
        }
        
        return departamentos;

    }

    @Override
    public boolean existeDepartamento(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteDepartamento(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
