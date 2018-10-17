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
import mx.itesm.sapi.bean.diagnostico.EtapaClinica;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Diego
 */
public class EtapaClinicaServiceImpl implements EtapaClinicaService{

    @Override
    public EtapaClinica mostrarEtapaClinica(int idEtapaClinica) {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        EtapaClinica etapaClinica = null;
        
        //Call del stored procedure
        String stProcedure="-----";
        
        try {    
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            etapaClinica = new EtapaClinica();
            
            cstmt.setInt(1, idEtapaClinica);
            rs = cstmt.executeQuery();
            
            // Asignación de valores devuletos a etapaClinica
            rs.next();
            etapaClinica.setIdEtapaClinica(rs.getInt("idEtapaClinica"));
            etapaClinica.setNombre(rs.getString("nombre"));
            etapaClinica.setEstatus(rs.getInt("estatus"));
            
        } catch (SQLException ex) {
            etapaClinica = null;
            System.out.println("ID: " + idEtapaClinica);
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return etapaClinica;
    }

    @Override
    public List<EtapaClinica> mostrarEtapaClinica() {
                
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        
        List<EtapaClinica> etapasClinicas = null;
        
        //Call del store procedure
        String stProcedure="-----";
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            etapasClinicas = new ArrayList<>();
            
            rs = cstmt.executeQuery();
            EtapaClinica etapaClinica;
            
            while(rs.next()){
                
                etapaClinica = new EtapaClinica();
                etapaClinica.setIdEtapaClinica(rs.getInt(1));
                etapaClinica.setNombre(rs.getString(2));
                etapaClinica.setEstatus(rs.getInt(3));
                
                etapasClinicas.add(etapaClinica);
            
            }
            
            rs.close();
            cstmt.close();
            conn.close();
                    
            
        }catch(Exception ex){
            etapasClinicas = null;
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        
        return etapasClinicas;
    }

}
