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
import mx.itesm.sapi.bean.formulario.ReporteNavegadora;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class ReporteNavegadoraServicioImpl implements ReporteNavegadoraServicio{

    @Override
    public ReporteNavegadora mostrarReporteNavegadora(int idPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "CALL mostrarFormularioNavegadora(?)";
        ReporteNavegadora reporteNavegadora = null;
        
        try{
            conn = Conexion.getConnection();
            reporteNavegadora = new ReporteNavegadora();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);
            
            rs = cstmt.executeQuery();
            rs.next();
            
            reporteNavegadora.setPrz(rs.getString("prz"));
            
        }catch(SQLException ex)
        {
             System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
             reporteNavegadora = null;
        }
        return reporteNavegadora;
    }
    
}
