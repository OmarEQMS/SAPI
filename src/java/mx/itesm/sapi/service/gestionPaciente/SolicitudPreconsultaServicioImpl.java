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
import mx.itesm.sapi.bean.gestionPaciente.SolicitudPreconsulta;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author urieldiaz
 */
public class SolicitudPreconsultaServicioImpl implements SolicitudPreconsultaServicio {

    @Override
    public SolicitudPreconsulta mostrarSolicitudPreconsulta(int idPaciente) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        SolicitudPreconsulta solicitudPreconsulta = null;

        //Call del store procedure
        String stProcedure = "CALL mostrarSolicitudPreconsulta(?)";

        try {
            solicitudPreconsulta = new SolicitudPreconsulta();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);

            rs = cstmt.executeQuery();

            rs.next();
            solicitudPreconsulta.setIdSexo(rs.getInt(1));
            solicitudPreconsulta.setSilla(rs.getInt(2));
            solicitudPreconsulta.setCamilla(rs.getInt(3));
            solicitudPreconsulta.setBaston(rs.getInt(4));
            solicitudPreconsulta.setOxigeno(rs.getInt(5));
            solicitudPreconsulta.setEstudioPrevio(rs.getInt(6));
            solicitudPreconsulta.setBiopsiaPrevia(rs.getInt(7));
            solicitudPreconsulta.setIdentificacion(rs.getInt(8));
            solicitudPreconsulta.setComprobante(rs.getInt(9));
            solicitudPreconsulta.setCurp(rs.getInt(10));
            solicitudPreconsulta.setReferencia(rs.getInt(11));
            solicitudPreconsulta.setMastografia(rs.getInt(12));
            solicitudPreconsulta.setUltrasonido(rs.getInt(13));
                        
            
            conn.close();
            rs.close();
            cstmt.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            solicitudPreconsulta = null;
        }
        return solicitudPreconsulta;
    }     
}
