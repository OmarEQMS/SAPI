/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.NivelSocioeconomico;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author shannonrosas
 */
public class NivelSocioeconomicoServicioImpl implements NivelSocioeconomicoServicio {

    @Override
    public List<NivelSocioeconomico> mostrarNivelSocioeconomico() {
        Connection conn;
        List<NivelSocioeconomico> listaNivelSocioEconomico = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure="CALL mostrarListaNivelSocioEconomico(?)";
        
        ResultSet rs;
        
        try{
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            NivelSocioeconomico nivelSocioEconomico;
            
            while(rs.next()){
                nivelSocioEconomico = new NivelSocioeconomico();
                nivelSocioEconomico.setIdNivelSocioEconomico(rs.getInt("idNivelSocioEconomico"));
                nivelSocioEconomico.setNombre(rs.getString("nombre"));
                nivelSocioEconomico.setEstatus(rs.getInt("estatus"));
                
                listaNivelSocioEconomico.add(nivelSocioEconomico);
            }
            
            rs.close();
            cstmt.close();
            conn.close();
        }catch(SQLException ex){
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            listaNivelSocioEconomico = null;
        }
        return listaNivelSocioEconomico;
    }
    
}
