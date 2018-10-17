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
import mx.itesm.sapi.bean.gestionPaciente.ImportanciaCita;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author urieldiaz
 */
public class ImportanciaCitaServicioImpl implements ImportanciaCitaServicio{

    @Override
    public ImportanciaCita mostrarImportanciaCita(int idImportanciaCita) {
        Connection conn; 
        CallableStatement cstmt;
        ResultSet rs;
        ImportanciaCita importanciaCita = new ImportanciaCita();
        
        //Store procedure Procedure
        String stProcedure="";
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);        
            rs = cstmt.executeQuery();
            
            rs.next();
            importanciaCita.setIdImportanciaCita(rs.getInt("idImportanciaCita"));
            importanciaCita.setIdImportanciaCita(rs.getInt("importancia"));
            importanciaCita.setEstatus(rs.getInt("estatus"));
           
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            importanciaCita = null;
        }
        return importanciaCita;
    }

    @Override
    public List<ImportanciaCita> mostrarImportanciaCita() {
        Connection conn; 
        List<ImportanciaCita> importanciaCitas = new ArrayList<>();
        
        CallableStatement cstmt;
        ResultSet rs;
        try{
           conn = Conexion.getConnection();
           cstmt = conn.prepareCall("CALL getImportanciaCitas()");
           rs = cstmt.executeQuery();
           
           ImportanciaCita importanciaCita;
           
           while(rs.next()){
               importanciaCita= new ImportanciaCita();
               importanciaCita.setIdImportanciaCita(rs.getInt(1));
               importanciaCita.setImportancia(2);
               importanciaCita.setEstatus(3);
               
               importanciaCitas.add(importanciaCita);
               
           }
           
           rs.close();
           cstmt.close();
           conn.close();
           
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            importanciaCitas = null;
            
        }
        return importanciaCitas;
    }

    @Override
    public int agregarImportanciaCita(ImportanciaCita importanciaCita) {
        Connection conn;
        CallableStatement cstmt;
        int id=0;
        //Store Procedure
        String stProcedure = "stProcedure agregarImportancia";
        try{
            conn = Conexion.getConnection();
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, importanciaCita.getIdImportanciaCita());
            cstmt.setInt(2, importanciaCita.getImportancia());
            cstmt.setInt(3, importanciaCita.getEstatus());
            
            cstmt.executeUpdate();
            ResultSet rs = cstmt.getGeneratedKeys();
            rs.next();
            id=rs.getInt(1);
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(Exception ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id= -1;
        }
        return id;
    }

    @Override
    public boolean actualizarImportanciaCita(ImportanciaCita importanciaCita) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "";
        boolean exito = false;
        ResultSet rs;
        try{
            conn = Conexion.getConnection();
            
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, importanciaCita.getIdImportanciaCita());
            cstmt.setInt(2,importanciaCita.getImportancia());
            cstmt.setInt(3, importanciaCita.getEstatus() );
            
            rs = cstmt.executeQuery();
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

    @Override
    public boolean borradoLogicoImportanciaCita(int idImportanciaCita) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure= "";
        boolean exito = false;
        ResultSet rs;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1,idImportanciaCita);
            rs = cstmt.executeQuery();
        }catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito=false;
        
        }
        return exito;
        
    }
    
}
