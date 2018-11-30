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
 * @author Uriel Díaz & Alexis España
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
            System.out.println("MOSTRAR SOLICITUD PRECONSULTA ".concat(cstmt.toString()));
            rs = cstmt.executeQuery();

            while(rs.next()){
                System.out.println("En el while de rs next ".concat(rs.getString("MOTIVOCONSULTA")));
                solicitudPreconsulta.setIdSexo(rs.getInt(1));
                solicitudPreconsulta.setSilla(rs.getInt(2));
                solicitudPreconsulta.setCamilla(rs.getInt(3));
                solicitudPreconsulta.setBaston(rs.getInt(4));
                solicitudPreconsulta.setOxigeno(rs.getInt(5));

                solicitudPreconsulta.setEstudioPrevio(rs.getNString(6));
                solicitudPreconsulta.setBiopsiaPrevia(rs.getNString(7));
                solicitudPreconsulta.setIdentificacion(rs.getNString(8));
                solicitudPreconsulta.setComprobante(rs.getNString(9));
                solicitudPreconsulta.setCurp(rs.getNString(10));
                solicitudPreconsulta.setReferencia(rs.getNString(11));
                solicitudPreconsulta.setMastografia(rs.getNString(12));
                solicitudPreconsulta.setUltrasonido(rs.getNString(13));
                solicitudPreconsulta.setMotivoCosulta(rs.getInt("MOTIVOCONSULTA"));
                solicitudPreconsulta.setOtro(rs.getNString("OTRO"));
                solicitudPreconsulta.setHospital(rs.getNString(16));

                System.out.println("sexo " + (rs.getInt(1)));
                System.out.println("silla " + (rs.getInt(2)));
                System.out.println("camilla " + (rs.getInt(3)));
                System.out.println("baston " + (rs.getInt(4)));
                System.out.println("oxigeno " + (rs.getInt(5)));

                System.out.println("estudio previo " + (rs.getNString(6)));
                System.out.println("biopsia previa " + (rs.getNString(7)));
                System.out.println("identificacion " + (rs.getNString(8)));
                System.out.println("comprobante " + (rs.getNString(9)));
                System.out.println("curp " + (rs.getNString(10)));
                System.out.println("referncia " + (rs.getNString(11)));
                System.out.println("masto " + (rs.getNString(12)));
                System.out.println("usg " + (rs.getNString(13)));
                System.out.println("idmotivo con " + (rs.getInt("MOTIVOCONSULTA")));
                System.out.println("otro motivo  " + (rs.getNString("OTRO")));
                System.out.println("hospital " + (rs.getNString(16)));
            }
                                    
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
