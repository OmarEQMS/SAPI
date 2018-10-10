/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.persona.CodigoPostal;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class CodigoPostalServicioImpl implements CodigoPostalServicio{

    @Override
    public CodigoPostal mostrarCodigoPostal(int idCodigoPostal) {
           Connection conn = Conexion.getConnection();
        
        CallableStatement cstmt;
        
        CodigoPostal codigoPostal = new CodigoPostal();
        
        //Call del store procedure
        String stProcedure="mostrarCodigoPostal";
        
        try{
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idCodigoPostal);
            
            ResultSet rs = cstmt.executeQuery();
            
         
            
            rs.next();
            codigoPostal.setIdCodigoPostal(rs.getInt("idCodigoPostal"));
            codigoPostal.setNumero(rs.getString("numero"));
            codigoPostal.setIdMunicipio(rs.getInt("idMunicipio"));
            codigoPostal.setEstatus(rs.getInt("estatus"));
            
            
           
            return codigoPostal;
        }catch(SQLException ex){
            
            System.out.println("Estoy en el catch de mostrarcodigoPostal");
            System.out.println(ex.getMessage());
            return codigoPostal;
        }
    }

    @Override
    public List<CodigoPostal> mostrarCodigoPostal() {
       Connection conn = Conexion.getConnection();
        
        
        List<CodigoPostal> auditoriaCreacionCuentas = new ArrayList<>();
        
        try{
            
            CallableStatement cstmt;
            cstmt = conn.prepareCall("CALL getCodigoPostal()");
            ResultSet rs = cstmt.executeQuery();
            CodigoPostal codigoPostal;
            
            while(rs.next()){
                
                codigoPostal = new CodigoPostal();
            
            codigoPostal.setIdCodigoPostal(rs.getInt(1));
            codigoPostal.setNumero(rs.getString(2));
            codigoPostal.setIdMunicipio(rs.getInt(3));
            codigoPostal.setEstatus(rs.getInt(4));
                
               
                
                auditoriaCreacionCuentas.add(codigoPostal);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(SQLException ex){
            System.out.println("ERROR GET codigopostal" + ex.getMessage());
        }
        
        return auditoriaCreacionCuentas;
    
    }

    @Override
    public int agregarCodigoPostal(CodigoPostal codigoPostal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarCodigoPostal(CodigoPostal codigoPostal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borradoLogicoCodigoPostal(int idCodigoPostal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
