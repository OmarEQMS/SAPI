/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.diagnostico;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.diagnostico.LugarDelCuerpoEstadiajeTNM;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Diego
 */
public class LugarDelCuerpoEstadiajeTNMServiceImpl implements LugarDelCuerpoEstadiajeTNMService{

    @Override
    public int agregarLugarDelCuerpoEstadiajeTNM(LugarDelCuerpoEstadiajeTNM lugarDelCuerpoEstadiajeTNM) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        int id = -1;
        //Aquí va el call del procedure
        String stProcedure="-------";
        
        try {
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, lugarDelCuerpoEstadiajeTNM.getIdLugarDelCuerpoEstadiajeTNM());
            cstmt.setInt(2, lugarDelCuerpoEstadiajeTNM.getIdLugarDelCuerpo());
            cstmt.setInt(3, lugarDelCuerpoEstadiajeTNM.getIdRegistroTNM());
            cstmt.setInt(3, lugarDelCuerpoEstadiajeTNM.getEstatus());
            
            cstmt.executeQuery();
            
            rs = cstmt.getGeneratedKeys();
            rs.next();
            
            id = rs.getInt(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            id = -1;
            System.out.println("IdLugarDelCuerpoEstadiajeTNM: " + lugarDelCuerpoEstadiajeTNM.getIdLugarDelCuerpoEstadiajeTNM());
            System.out.println("IdLugarDelCuerpo: " + lugarDelCuerpoEstadiajeTNM.getIdLugarDelCuerpo());
            System.out.println("Estatus: " + lugarDelCuerpoEstadiajeTNM.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return id;
    }

    @Override
    public LugarDelCuerpoEstadiajeTNM mostrarLugarDelCuerpoEstadiajeTNM(int idLugarDelCuerpoEstadiajeTNM) {
                        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        LugarDelCuerpoEstadiajeTNM lugarDelCuerpoEstadiajeTNM = null;
        
        //Call del stored procedure
        String stProcedure="-----";
        
        try {    
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            lugarDelCuerpoEstadiajeTNM = new LugarDelCuerpoEstadiajeTNM();
            
            cstmt.setInt(1, idLugarDelCuerpoEstadiajeTNM);
            rs = cstmt.executeQuery();
            
            // Asignación de valores devuletos a lugarDelCuerpoEstadiajeTNM
            rs.next();
            lugarDelCuerpoEstadiajeTNM.setIdLugarDelCuerpoEstadiajeTNM(rs.getInt("idLugarDelCuerpoEstadiajeTNM"));
            lugarDelCuerpoEstadiajeTNM.setIdLugarDelCuerpo(rs.getInt("idLugarDelCuerpo"));
            lugarDelCuerpoEstadiajeTNM.setIdRegistroTNM(rs.getInt("idRegistroTNM"));
            lugarDelCuerpoEstadiajeTNM.setEstatus(rs.getInt("estatus"));
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            lugarDelCuerpoEstadiajeTNM = null;
            System.out.println("ID: " + idLugarDelCuerpoEstadiajeTNM);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return lugarDelCuerpoEstadiajeTNM;
    }

    @Override
    public List<LugarDelCuerpoEstadiajeTNM> mostrarLugarDelCuerpoEstadiajeTNM() {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<LugarDelCuerpoEstadiajeTNM> lugaresDelCuerpoEstadiajeTNM = null;
        
        //Call del store procedure
        String stProcedure="-----";
        
        try{
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            lugaresDelCuerpoEstadiajeTNM = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            LugarDelCuerpoEstadiajeTNM lugarDelCuerpoEstadiajeTNM;
            
            while(rs.next()){
                
                lugarDelCuerpoEstadiajeTNM = new LugarDelCuerpoEstadiajeTNM();
                lugarDelCuerpoEstadiajeTNM.setIdLugarDelCuerpoEstadiajeTNM(rs.getInt(1));
                lugarDelCuerpoEstadiajeTNM.setIdLugarDelCuerpo(rs.getInt(2));
                lugarDelCuerpoEstadiajeTNM.setIdRegistroTNM(rs.getInt(3));
                lugarDelCuerpoEstadiajeTNM.setEstatus(rs.getInt(4));
                
                lugaresDelCuerpoEstadiajeTNM.add(lugarDelCuerpoEstadiajeTNM);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(Exception ex){
            lugaresDelCuerpoEstadiajeTNM = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return lugaresDelCuerpoEstadiajeTNM;
    }

    @Override
    public boolean actualizarLugarDelCuerpoEstadiajeTNM(LugarDelCuerpoEstadiajeTNM lugarDelCuerpoEstadiajeTNM) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
     
        boolean exito = false;
        
        //Aquí va el call del procedure
        String stProcedure="-------";
        
        try {
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1, lugarDelCuerpoEstadiajeTNM.getIdLugarDelCuerpoEstadiajeTNM());
            cstmt.setInt(2, lugarDelCuerpoEstadiajeTNM.getIdLugarDelCuerpo());
            cstmt.setInt(3, lugarDelCuerpoEstadiajeTNM.getIdRegistroTNM());
            cstmt.setInt(4, lugarDelCuerpoEstadiajeTNM.getEstatus());
            
            rs = cstmt.executeQuery();
            
            rs.next();
            
            exito = rs.getBoolean(1);  
            
            rs.close();
            cstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            exito = false;
            System.out.println("IdLugarDelCuerpoEstadiajeTNM: " + lugarDelCuerpoEstadiajeTNM.getIdLugarDelCuerpoEstadiajeTNM());
            System.out.println("IdLugarDelCuerpo: " + lugarDelCuerpoEstadiajeTNM.getIdLugarDelCuerpo());
            System.out.println("IdRegistroTNM: " + lugarDelCuerpoEstadiajeTNM.getIdRegistroTNM());
            System.out.println("Estatus: " + lugarDelCuerpoEstadiajeTNM.getEstatus());
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }

    @Override
    public boolean borradoLogicoLugarDelCuerpoEstadiajeTNM(int idLugarDelCuerpoEstadiajeTNM) {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        boolean exito = false;
        
        //Call del store procedure
        String stProcedure="";
        
        try{
            
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,idLugarDelCuerpoEstadiajeTNM);
            
            rs = cstmt.executeQuery();
            
            rs.next();
            
            exito = rs.getBoolean(1);
            
            rs.close();
            cstmt.close();
            conn.close();
            
        }catch(SQLException ex){
            exito = false;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return exito;
    }

}
