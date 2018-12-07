/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mx.itesm.sapi.bean.rendimiento.Rendimiento;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class EstadisticaServicioImpl implements EstadisticaServicio{

    @Override
    public Rendimiento mostrarEstadisticaRango(Date fechaInicio, Date fechaFin) {
    
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        Rendimiento estadisticaPorMes = new Rendimiento();

        //Call del store procedure
        String stProcedure = "CALL mostrarRendimientoMes(?,?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setDate(1, fechaInicio);
            cstmt.setDate(2, fechaFin);

            rs = cstmt.executeQuery();

            rs.next();

            estadisticaPorMes.setDecripcion(rs.getString("rango"));
            estadisticaPorMes.setCantidad(rs.getInt("cuenta"));

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("RendimientoServicioImpl estadisticaPorMes");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            
        }
        return estadisticaPorMes;    
    }

    @Override
    public ArrayList<Rendimiento> mostrarEstadisticaEdad(Date fechaInicio, Date fechaFin) {
       Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<Rendimiento> estadisticaPorEdad = new ArrayList<>();

        //Call del store procedure
        String stProcedure = "CALL mostrarRendimientoPacientesEdad(?,?)";

        try {
            Rendimiento estadistica1 = new Rendimiento();
            Rendimiento estadistica2 = new Rendimiento();
            Rendimiento estadistica3 = new Rendimiento();
            Rendimiento estadistica4 = new Rendimiento();
            Rendimiento estadistica5 = new Rendimiento();
            Rendimiento estadistica6 = new Rendimiento();
            Rendimiento estadistica7 = new Rendimiento();
            Rendimiento estadistica8 = new Rendimiento();
            Rendimiento estadistica9 = new Rendimiento();

            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setDate(1, fechaInicio);
            cstmt.setDate(2, fechaFin);

            rs = cstmt.executeQuery();

            rs.next();

            estadistica1.setDecripcion("15 a 19");
            estadistica1.setCantidad(rs.getInt("edad_15_19"));
            estadisticaPorEdad.add(estadistica1);
            estadistica2.setDecripcion("20 a 29");
            estadistica2.setCantidad(rs.getInt("edad_20_29"));
            estadisticaPorEdad.add(estadistica2);
            estadistica3.setDecripcion("30 a 39");
            estadistica3.setCantidad(rs.getInt("edad_30_39"));
            estadisticaPorEdad.add(estadistica3);
            estadistica4.setDecripcion("40 a 49");
            estadistica4.setCantidad(rs.getInt("edad_40_49"));
            estadisticaPorEdad.add(estadistica4);
            estadistica5.setDecripcion("50 a 59");
            estadistica5.setCantidad(rs.getInt("edad_50_59"));
            estadisticaPorEdad.add(estadistica5);
            estadistica6.setDecripcion("60 a 69");
            estadistica6.setCantidad(rs.getInt("edad_60_69"));
            estadisticaPorEdad.add(estadistica6);
            estadistica7.setDecripcion("70 a 79");
            estadistica7.setCantidad(rs.getInt("edad_70_79"));
            estadisticaPorEdad.add(estadistica7);
            estadistica8.setDecripcion("80 a 89");
            estadistica8.setCantidad(rs.getInt("edad_80_89"));
            estadisticaPorEdad.add(estadistica8);
            estadistica9.setDecripcion("90 a 99");
            estadistica9.setCantidad(rs.getInt("edad_90_99"));
            estadisticaPorEdad.add(estadistica9);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("RendimientoServicioImpl mostrarRendimientoaEdad");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estadisticaPorEdad = null;
        }
        return estadisticaPorEdad;
    }

    @Override
    public ArrayList<Rendimiento> mostrarEstadisticaEscolaridad(Date fechaInicio, Date fechaFin) {
         Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<Rendimiento> estadisticaPorEscolaridad = new ArrayList<>();

        //Call del store procedure
        String stProcedure = "CALL mostrarRendimientoPacientesEscolaridad(?,?)";

        try {
            Rendimiento estadistica1 = new Rendimiento();
            Rendimiento estadistica2 = new Rendimiento();
            Rendimiento estadistica3 = new Rendimiento();
            Rendimiento estadistica4 = new Rendimiento();
            Rendimiento estadistica5 = new Rendimiento();
            Rendimiento estadistica6 = new Rendimiento();
            Rendimiento estadistica7 = new Rendimiento();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setDate(1, fechaInicio);
            cstmt.setDate(2, fechaFin);

            rs = cstmt.executeQuery();

            rs.next();

            estadistica1.setDecripcion("Analfabeta");
            estadistica1.setCantidad(rs.getInt("analfabeta"));
            estadisticaPorEscolaridad.add(estadistica1);

            estadistica2.setDecripcion("Primaria incompleta");
            estadistica2.setCantidad(rs.getInt("primaria_incompleta"));
            estadisticaPorEscolaridad.add(estadistica2);

            estadistica3.setDecripcion("Primaria");
            estadistica3.setCantidad(rs.getInt("primaria"));
            estadisticaPorEscolaridad.add(estadistica3);

            estadistica4.setDecripcion("Secundaria");
            estadistica4.setCantidad(rs.getInt("secundaria"));
            estadisticaPorEscolaridad.add(estadistica4);

            estadistica5.setDecripcion("Preparatoria");
            estadistica5.setCantidad(rs.getInt("preparatoria"));
            estadisticaPorEscolaridad.add(estadistica5);

            estadistica6.setDecripcion("Licenciatura");
            estadistica6.setCantidad(rs.getInt("licenciatura"));
            estadisticaPorEscolaridad.add(estadistica6);

            estadistica7.setDecripcion("Posgrado");
            estadistica7.setCantidad(rs.getInt("posgrado"));
            estadisticaPorEscolaridad.add(estadistica7);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("RendimientoServicioImpl mostrarRendimientoEscolaridad");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estadisticaPorEscolaridad = null;
        }
        return estadisticaPorEscolaridad;
    }

    @Override
    public ArrayList<Rendimiento> mostrarEstadisticaLugarResidencia(Date fechaInicio, Date fechaFin) {
       Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<Rendimiento> estadisticaPorLugarResidencia = new ArrayList<>();

        //Call del store procedure
        String stProcedure = "CALL mostrarRendimientoPacientesEstado(?,?)";

        try {
            Rendimiento estadistica1 = new Rendimiento();
            Rendimiento estadistica2 = new Rendimiento();
            Rendimiento estadistica3 = new Rendimiento();
            Rendimiento estadistica4 = new Rendimiento();
            Rendimiento estadistica5 = new Rendimiento();
            Rendimiento estadistica6 = new Rendimiento();
            Rendimiento estadistica7 = new Rendimiento();
            Rendimiento estadistica8 = new Rendimiento();
            Rendimiento estadistica9 = new Rendimiento();
            Rendimiento estadistica10 = new Rendimiento();
            Rendimiento estadistica11 = new Rendimiento();
            Rendimiento estadistica12 = new Rendimiento();
            Rendimiento estadistica13 = new Rendimiento();
            Rendimiento estadistica14 = new Rendimiento();
            Rendimiento estadistica15 = new Rendimiento();
            Rendimiento estadistica16 = new Rendimiento();
            Rendimiento estadistica17 = new Rendimiento();
            Rendimiento estadistica18 = new Rendimiento();
            Rendimiento estadistica19 = new Rendimiento();
            Rendimiento estadistica20 = new Rendimiento();
            Rendimiento estadistica21 = new Rendimiento();
            Rendimiento estadistica22 = new Rendimiento();
            Rendimiento estadistica23 = new Rendimiento();
            Rendimiento estadistica24 = new Rendimiento();
            Rendimiento estadistica25 = new Rendimiento();
            Rendimiento estadistica26 = new Rendimiento();
            Rendimiento estadistica27 = new Rendimiento();
            Rendimiento estadistica28 = new Rendimiento();
            Rendimiento estadistica29 = new Rendimiento();
            Rendimiento estadistica30 = new Rendimiento();
            Rendimiento estadistica31 = new Rendimiento();
            Rendimiento estadistica32 = new Rendimiento();

            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setDate(1, fechaInicio);
            cstmt.setDate(2, fechaFin);

            rs = cstmt.executeQuery();

            rs.next();
            estadistica1.setDecripcion("Aguascalientes");
            estadistica1.setCantidad(rs.getInt("E1"));
            estadisticaPorLugarResidencia.add(estadistica1);

            estadistica2.setDecripcion("Baja California");
            estadistica2.setCantidad(rs.getInt("E2"));
            estadisticaPorLugarResidencia.add(estadistica2);

            estadistica3.setDecripcion("Baja California Sur");
            estadistica3.setCantidad(rs.getInt("E3"));
            estadisticaPorLugarResidencia.add(estadistica3);

            estadistica4.setDecripcion("Campeche");
            estadistica4.setCantidad(rs.getInt("E4"));
            estadisticaPorLugarResidencia.add(estadistica4);

            estadistica5.setDecripcion("Coahuila de Zaragoza");
            estadistica5.setCantidad(rs.getInt("E5"));
            estadisticaPorLugarResidencia.add(estadistica5);

            estadistica6.setDecripcion("Colima");
            estadistica6.setCantidad(rs.getInt("E6"));
            estadisticaPorLugarResidencia.add(estadistica6);

            estadistica7.setDecripcion("Chiapas");
            estadistica7.setCantidad(rs.getInt("E7"));
            estadisticaPorLugarResidencia.add(estadistica7);

            estadistica8.setDecripcion("Chihuahua");
            estadistica8.setCantidad(rs.getInt("E8"));
            estadisticaPorLugarResidencia.add(estadistica8);

            estadistica9.setDecripcion("Ciudad de México");
            estadistica9.setCantidad(rs.getInt("E9"));
            estadisticaPorLugarResidencia.add(estadistica9);

            estadistica10.setDecripcion("Durango");
            estadistica10.setCantidad(rs.getInt("E10"));
            estadisticaPorLugarResidencia.add(estadistica10);

            estadistica11.setDecripcion("Guanajuato");
            estadistica11.setCantidad(rs.getInt("E11"));
            estadisticaPorLugarResidencia.add(estadistica11);

            estadistica12.setDecripcion("Guerrero");
            estadistica12.setCantidad(rs.getInt("E12"));
            estadisticaPorLugarResidencia.add(estadistica12);

            estadistica13.setDecripcion("Hidalgo");
            estadistica13.setCantidad(rs.getInt("E13"));
            estadisticaPorLugarResidencia.add(estadistica13);

            estadistica14.setDecripcion("Jalisco");
            estadistica14.setCantidad(rs.getInt("E14"));
            estadisticaPorLugarResidencia.add(estadistica14);

            estadistica15.setDecripcion("México");
            estadistica15.setCantidad(rs.getInt("E15"));
            estadisticaPorLugarResidencia.add(estadistica15);

            estadistica16.setDecripcion("Michoacán de Ocampo");
            estadistica16.setCantidad(rs.getInt("E16"));
            estadisticaPorLugarResidencia.add(estadistica16);

            estadistica17.setDecripcion("Morelos");
            estadistica17.setCantidad(rs.getInt("E17"));
            estadisticaPorLugarResidencia.add(estadistica17);

            estadistica18.setDecripcion("Nayarit");
            estadistica18.setCantidad(rs.getInt("E18"));
            estadisticaPorLugarResidencia.add(estadistica18);

            estadistica19.setDecripcion("Nuevo León");
            estadistica19.setCantidad(rs.getInt("E19"));
            estadisticaPorLugarResidencia.add(estadistica19);

            estadistica20.setDecripcion("Oaxaca");
            estadistica20.setCantidad(rs.getInt("E20"));
            estadisticaPorLugarResidencia.add(estadistica20);

            estadistica21.setDecripcion("Puebla");
            estadistica21.setCantidad(rs.getInt("E21"));
            estadisticaPorLugarResidencia.add(estadistica21);

            estadistica22.setDecripcion("Querétaro");
            estadistica22.setCantidad(rs.getInt("E22"));
            estadisticaPorLugarResidencia.add(estadistica22);

            estadistica23.setDecripcion("Quintana Roo");
            estadistica23.setCantidad(rs.getInt("E23"));
            estadisticaPorLugarResidencia.add(estadistica23);

            estadistica24.setDecripcion("San Luis Potosí");
            estadistica24.setCantidad(rs.getInt("E24"));
            estadisticaPorLugarResidencia.add(estadistica24);

            estadistica25.setDecripcion("Sinaloa");
            estadistica25.setCantidad(rs.getInt("E25"));
            estadisticaPorLugarResidencia.add(estadistica25);

            estadistica26.setDecripcion("Sonora");
            estadistica26.setCantidad(rs.getInt("E26"));
            estadisticaPorLugarResidencia.add(estadistica26);

            estadistica27.setDecripcion("Tabasco");
            estadistica27.setCantidad(rs.getInt("E27"));
            estadisticaPorLugarResidencia.add(estadistica27);

            estadistica28.setDecripcion("Tamaulipas");
            estadistica28.setCantidad(rs.getInt("E28"));
            estadisticaPorLugarResidencia.add(estadistica28);

            estadistica29.setDecripcion("Tlaxcala");
            estadistica29.setCantidad(rs.getInt("E29"));
            estadisticaPorLugarResidencia.add(estadistica29);

            estadistica30.setDecripcion("Veracruz de Ignacio de la Llave");
            estadistica30.setCantidad(rs.getInt("E30"));
            estadisticaPorLugarResidencia.add(estadistica30);

            estadistica31.setDecripcion("Yucatán");
            estadistica31.setCantidad(rs.getInt("E31"));
            estadisticaPorLugarResidencia.add(estadistica31);

            estadistica32.setDecripcion("Zacatecas");
            estadistica32.setCantidad(rs.getInt("E32"));
            estadisticaPorLugarResidencia.add(estadistica32);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("RendimientoServicioImpl mostrarRendimientoLugarResidencia");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estadisticaPorLugarResidencia = null;
        }
        return estadisticaPorLugarResidencia;  
    }

    @Override
    public ArrayList<Rendimiento> mostrarEstadisticaNivelSocioEconomico(Date fechaInicio, Date fechaFin) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<Rendimiento> estadisticaPorNivelSocioEconomico = new ArrayList<>();

        //Call del store procedure
        String stProcedure = "CALL mostrarRendimientoPacientesSocioEconomico(?,?)";

        try {
            Rendimiento estadistica1 = new Rendimiento();
            Rendimiento estadistica2 = new Rendimiento();
            Rendimiento estadistica3 = new Rendimiento();
            Rendimiento estadistica4 = new Rendimiento();
            Rendimiento estadistica5 = new Rendimiento();
            Rendimiento estadistica6 = new Rendimiento();

            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setDate(1, fechaInicio);
            cstmt.setDate(2, fechaFin);

            rs = cstmt.executeQuery();

            rs.next();
            estadistica1.setDecripcion("Uno");
            estadistica1.setCantidad(rs.getInt("uno"));
            estadisticaPorNivelSocioEconomico.add(estadistica1);
            estadistica2.setDecripcion("Dos");
            estadistica2.setCantidad(rs.getInt("dos"));
            estadisticaPorNivelSocioEconomico.add(estadistica2);
            estadistica3.setDecripcion("Tres");
            estadistica3.setCantidad(rs.getInt("tres"));
            estadisticaPorNivelSocioEconomico.add(estadistica3);
            estadistica4.setDecripcion("Cuatro");
            estadistica4.setCantidad(rs.getInt("cuatro"));
            estadisticaPorNivelSocioEconomico.add(estadistica4);
            estadistica5.setDecripcion("Cinco");
            estadistica5.setCantidad(rs.getInt("cinco"));
            estadisticaPorNivelSocioEconomico.add(estadistica5);
            estadistica6.setDecripcion("Seis");
            estadistica6.setCantidad(rs.getInt("seis"));
            estadisticaPorNivelSocioEconomico.add(estadistica6);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("RendimientoServicioImpl mostrarRendimientoNivelSocioEconomico");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estadisticaPorNivelSocioEconomico = null;
        }
        return estadisticaPorNivelSocioEconomico;
    }

    @Override
    public ArrayList<Rendimiento> mostrarEstadisticaDecisionPreconsulta(Date fechaInicio, Date fechaFin) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<Rendimiento> estadisticaPorDecisionPreconsulta = new ArrayList<>();

        //Call del store procedure
        String stProcedure = "CALL mostrarRendimientoPacientesPreconsulta(?,?)";

        try {
            Rendimiento estadistica1 = new Rendimiento();
            Rendimiento estadistica2 = new Rendimiento();
            Rendimiento estadistica3 = new Rendimiento();
            Rendimiento estadistica4 = new Rendimiento();
            Rendimiento estadistica5 = new Rendimiento();

            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setDate(1, fechaInicio);
            cstmt.setDate(2, fechaFin);
            System.out.println("Rendimiento decision preconsulta ".concat(cstmt.toString()));
            rs = cstmt.executeQuery();

            rs.next();
            estadistica1.setDecripcion("Unidad Funcional");
            estadistica1.setCantidad(rs.getInt("uf"));
            estadisticaPorDecisionPreconsulta.add(estadistica1);
            estadistica2.setDecripcion("Alta");
            estadistica2.setCantidad(rs.getInt("alta"));
            estadisticaPorDecisionPreconsulta.add(estadistica2);
            estadistica3.setDecripcion("Alta Voluntaria");
            estadistica3.setCantidad(rs.getInt("altaVoluntaria"));
            estadisticaPorDecisionPreconsulta.add(estadistica3);
            estadistica4.setDecripcion("Finada");
            estadistica4.setCantidad(rs.getInt("finada"));
            estadisticaPorDecisionPreconsulta.add(estadistica4);
            estadistica5.setDecripcion("Perdida");
            estadistica5.setCantidad(rs.getInt("perdida"));
            estadisticaPorDecisionPreconsulta.add(estadistica5);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("RendimientoServicioImpl mostrarVisitaDecisionPreconsulta");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estadisticaPorDecisionPreconsulta = null;
        }
        return estadisticaPorDecisionPreconsulta;
    }

    @Override
    public ArrayList<Rendimiento> mostrarEstadisticaResultadoPatologia(Date fechaInicio, Date fechaFin) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<Rendimiento> estadisticaPorResultadoPatologia = new ArrayList<>();

        //Call del store procedure
        String stProcedure = "CALL mostrarRendimientoPacientesDiagnostico(?,?)";

        try {
            Rendimiento estadistica1 = new Rendimiento();
            Rendimiento estadistica2 = new Rendimiento();
            Rendimiento estadistica3 = new Rendimiento();
            Rendimiento estadistica4 = new Rendimiento();
            Rendimiento estadistica5 = new Rendimiento();
            Rendimiento estadistica6 = new Rendimiento();
            Rendimiento estadistica7 = new Rendimiento();
            Rendimiento estadistica8 = new Rendimiento();
            Rendimiento estadistica9 = new Rendimiento();
            Rendimiento estadistica10 = new Rendimiento();
            Rendimiento estadistica11 = new Rendimiento();
            Rendimiento estadistica12 = new Rendimiento();
            Rendimiento estadistica13 = new Rendimiento();
            Rendimiento estadistica14 = new Rendimiento();
            Rendimiento estadistica15 = new Rendimiento();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);           
            cstmt.setDate(1, fechaInicio);
            cstmt.setDate(2, fechaFin);
            System.out.println("Visita resultado patología ".concat(cstmt.toString()));
            rs = cstmt.executeQuery();

            rs.next();

            estadistica1.setDecripcion("Carcinoma ductal in situ");
            estadistica1.setCantidad(rs.getInt("P1"));
            estadisticaPorResultadoPatologia.add(estadistica1);

            estadistica2.setDecripcion("Carcinoma lobulillar in situ");
            estadistica2.setCantidad(rs.getInt("P2"));
            estadisticaPorResultadoPatologia.add(estadistica2);

            estadistica3.setDecripcion("Carcinoma ductal infiltrante");
            estadistica3.setCantidad(rs.getInt("P3"));
            estadisticaPorResultadoPatologia.add(estadistica3);

            estadistica4.setDecripcion("Carcinoma tubular");
            estadistica4.setCantidad(rs.getInt("P4"));
            estadisticaPorResultadoPatologia.add(estadistica4);

            estadistica5.setDecripcion("Carcinoma mucinoso");
            estadistica5.setCantidad(rs.getInt("P5"));
            estadisticaPorResultadoPatologia.add(estadistica5);

            estadistica6.setDecripcion("Carcinoma medular");
            estadistica6.setCantidad(rs.getInt("P6"));
            estadisticaPorResultadoPatologia.add(estadistica6);

            estadistica7.setDecripcion("Carcinoma tubulolobulillar");
            estadistica7.setCantidad(rs.getInt("P7"));
            estadisticaPorResultadoPatologia.add(estadistica7);

            estadistica8.setDecripcion("Carcinoma micropapilar");
            estadistica8.setCantidad(rs.getInt("P8"));
            estadisticaPorResultadoPatologia.add(estadistica8);

            estadistica9.setDecripcion("Carcinoma metaplastico");
            estadistica9.setCantidad(rs.getInt("P9"));
            estadisticaPorResultadoPatologia.add(estadistica9);

            estadistica10.setDecripcion("Carcinoma adenoideo quístico");
            estadistica10.setCantidad(rs.getInt("P10"));
            estadisticaPorResultadoPatologia.add(estadistica10);

            estadistica11.setDecripcion("Sarcoma");
            estadistica11.setCantidad(rs.getInt("P11"));
            estadisticaPorResultadoPatologia.add(estadistica11);

            estadistica13.setDecripcion("Quiste no proliferativo");
            estadistica13.setCantidad(rs.getInt("P13"));
            estadisticaPorResultadoPatologia.add(estadistica13);

            estadistica14.setDecripcion("Cambios papilares apocrinos");
            estadistica14.setCantidad(rs.getInt("P14"));
            estadisticaPorResultadoPatologia.add(estadistica14);

            estadistica15.setDecripcion("Hiperplasia");
            estadistica15.setCantidad(rs.getInt("P15"));
            estadisticaPorResultadoPatologia.add(estadistica15);

            estadistica12.setDecripcion("Otro");
            estadistica12.setCantidad(rs.getInt("P12"));
            estadisticaPorResultadoPatologia.add(estadistica12);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("RendimientoServicioImpl mostrarVisitaResultadoPatologia");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            estadisticaPorResultadoPatologia = null;
        }
        return estadisticaPorResultadoPatologia;
    }
    
}
