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
import mx.itesm.sapi.bean.Rendimiento;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Raul Orihuela
 */
/**
 * public Rendimiento mostrarVisitaMes(int idEmpleado,
 *                                      Date fecha)
 * Regresa la cantidad de visitas que atiende un empleado por mes
 *
 * Parametros: int idEmpleado - id del empleado cuya informacion seque se desea
 * filtrar Date fecha - Date que debe contener mes y ano
 *
 * Regresa: Objeto de tipo Rendimiento el cual contiene descripcion y cantidad
 */
/**
 * public ArrayList<Rendimiento> mostrarVisitaEdad(int idEmpleado,
 *                                                  Date fecha)
 * Regresa un arreglo que contiene un objeto de tipo Rendimiento para
 * cada grupo de 'Edad' Cada objeto Rendimiento contiene la cantidad de visitas
 * y la descripcion del grupo
 *
 * Parametros: int idEmpleado - id del empleado cuya informacion seque se desea
 * filtrar Date fecha - Date que debe contener mes y ano
 *
 * Regresa: Arreglo que contiene un objeto de tipo Rendimiento para cada grupo
 * de 'Edad'
 */
/**
 * public ArrayList<Rendimiento> mostrarVisitaEscolaridad(int idEmpleado,
 *                                                          Date fecha)
 * Regresa un arreglo que contiene un objeto de tipo
 * Rendimiento para cada grupo de 'Escolaridad' Cada objeto Rendimiento contiene
 * la cantidad de visitas y la descripcion del grupo
 *
 * Parametros: int idEmpleado - id del empleado cuya informacion seque se desea
 * filtrar Date fecha - Date que debe contener mes y ano
 *
 * Regresa: Arreglo que contiene un objeto de tipo Rendimiento para cada grupo
 * de 'Escolaridad'
 */
/**
 * public ArrayList<Rendimiento> mostrarVisitaLugarResidencia(int idEmpleado,
 *                                                             Date fecha)
 * Regresa un arreglo que contiene un objeto de tipo
 * Rendimiento para cada grupo de 'LugarResidencia' Cada objeto Rendimiento
 * contiene la cantidad de visitas y la descripcion del grupo
 *
 * Parametros: int idEmpleado - id del empleado cuya informacion seque se desea
 * filtrar Date fecha - Date que debe contener mes y ano
 *
 * Regresa: Arreglo que contiene un objeto de tipo Rendimiento para cada grupo
 * de 'LugarResidencia'
 */
/**
 * public ArrayList<Rendimiento> mostrarVisitaNivelSocioEconomico(int idEmpleado,
 *                                                                  Date fecha)
 * Regresa un arreglo que contiene un objeto de
 * tipo Rendimiento para cada grupo de 'NivelSocioEconomico' Cada objeto
 * Rendimiento contiene la cantidad de visitas y la descripcion del grupo
 *
 * Parametros: int idEmpleado - id del empleado cuya informacion seque se desea
 * filtrar Date fecha - Date que debe contener mes y ano
 *
 * Regresa: Arreglo que contiene un objeto de tipo Rendimiento para cada grupo
 * de 'NivelSocioEconomico'
 */
/**
 * public ArrayList<Rendimiento> mostrarVisitaDecisionPreconsulta(int idEmpleado,
 *                                                                  Date fecha) 
 * Regresa un arreglo que contiene un objeto de
 * tipo Rendimiento para cada grupo de 'DecisionPreconsulta' Cada objeto
 * Rendimiento contiene la cantidad de visitas y la descripcion del grupo
 *
 * Parametros: int idEmpleado - id del empleado cuya informacion seque se desea
 * filtrar Date fecha - Date que debe contener mes y ano
 *
 * Regresa: Arreglo que contiene un objeto de tipo Rendimiento para cada grupo
 * de 'DecisionPreconsulta'
 */
/**
 * public ArrayList<Rendimiento> mostrarVisitaResultadoPatologia(int idEmpleado,
 *                                                                  Date fecha)
 * Regresa un arreglo que contiene un objeto de tipo
 * Rendimiento para cada grupo de 'ResultadoPatologia' Cada objeto Rendimiento
 * contiene la cantidad de visitas y la descripcion del grupo
 *
 * Parametros: int idEmpleado - id del empleado cuya informacion seque se desea
 * filtrar Date fecha - Date que debe contener mes y ano
 *
 * Regresa: Arreglo que contiene un objeto de tipo Rendimiento para cada grupo
 * de 'ResultadoPatologia'
 */
public class RendimientoServicioImpl implements RendimientoServicio {
    
    @Override
    public Rendimiento mostrarVisitaMes(int idEmpleado, Date fecha) {

        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        Rendimiento rendimientoPorMes = new Rendimiento();

        //Call del store procedure
        String stProcedure = "CALL pacientesPorMes(?,?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEmpleado);
            cstmt.setDate(2, fecha);

            rs = cstmt.executeQuery();

            rs.next();

            rendimientoPorMes.setDecripcion(rs.getString("mes"));
            rendimientoPorMes.setCantidad(rs.getInt("cuenta"));

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("RendimientoServicioImpl mostrarVisitaMes");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return rendimientoPorMes;

    }

    @Override
    public ArrayList<Rendimiento> mostrarVisitaEdad(int idEmpleado, Date fecha) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<Rendimiento> rendimientoPorEdad = new ArrayList<>();

        //Call del store procedure
        String stProcedure = "CALL EdadPacienteMes(?,?)";

        try {
            Rendimiento rendimiento1 = new Rendimiento();
            Rendimiento rendimiento2 = new Rendimiento();
            Rendimiento rendimiento3 = new Rendimiento();
            Rendimiento rendimiento4 = new Rendimiento();
            Rendimiento rendimiento5 = new Rendimiento();
            Rendimiento rendimiento6 = new Rendimiento();
            Rendimiento rendimiento7 = new Rendimiento();
            Rendimiento rendimiento8 = new Rendimiento();
            Rendimiento rendimiento9 = new Rendimiento();

            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEmpleado);
            cstmt.setDate(2, fecha);

            rs = cstmt.executeQuery();

            rs.next();

            rendimiento1.setDecripcion("edad_15_19");
            rendimiento1.setCantidad(rs.getInt("edad_15_19"));
            rendimientoPorEdad.add(rendimiento1);
            rendimiento2.setDecripcion("edad_20_29");
            rendimiento2.setCantidad(rs.getInt("edad_20_29"));
            rendimientoPorEdad.add(rendimiento2);
            rendimiento3.setDecripcion("edad_30_39");
            rendimiento3.setCantidad(rs.getInt("edad_30_39"));
            rendimientoPorEdad.add(rendimiento3);
            rendimiento4.setDecripcion("edad_40_49");
            rendimiento4.setCantidad(rs.getInt("edad_40_49"));
            rendimientoPorEdad.add(rendimiento4);
            rendimiento5.setDecripcion("edad_50_59");
            rendimiento5.setCantidad(rs.getInt("edad_50_59"));
            rendimientoPorEdad.add(rendimiento5);
            rendimiento6.setDecripcion("edad_60_69");
            rendimiento6.setCantidad(rs.getInt("edad_60_69"));
            rendimientoPorEdad.add(rendimiento6);
            rendimiento7.setDecripcion("edad_70_79");
            rendimiento7.setCantidad(rs.getInt("edad_70_79"));
            rendimientoPorEdad.add(rendimiento7);
            rendimiento8.setDecripcion("edad_80_89");
            rendimiento8.setCantidad(rs.getInt("edad_80_89"));
            rendimientoPorEdad.add(rendimiento8);
            rendimiento9.setDecripcion("edad_90_99");
            rendimiento9.setCantidad(rs.getInt("edad_90_99"));
            rendimientoPorEdad.add(rendimiento9);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("RendimientoServicioImpl mostrarVisitaEdad");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return rendimientoPorEdad;

    }

    @Override
    public ArrayList<Rendimiento> mostrarVisitaEscolaridad(int idEmpleado, Date fecha) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<Rendimiento> rendimientoPorEscolaridad = new ArrayList<>();

        //Call del store procedure
        String stProcedure = "CALL EscolaridadPacienteMes(?,?)";

        try {
            Rendimiento rendimiento1 = new Rendimiento();
            Rendimiento rendimiento2 = new Rendimiento();
            Rendimiento rendimiento3 = new Rendimiento();
            Rendimiento rendimiento4 = new Rendimiento();
            Rendimiento rendimiento5 = new Rendimiento();
            Rendimiento rendimiento6 = new Rendimiento();
            Rendimiento rendimiento7 = new Rendimiento();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEmpleado);
            cstmt.setDate(2, fecha);

            rs = cstmt.executeQuery();

            rs.next();

            rendimiento1.setDecripcion("analfabeta");
            rendimiento1.setCantidad(rs.getInt("analfabeta"));
            rendimientoPorEscolaridad.add(rendimiento1);

            rendimiento2.setDecripcion("primaria_incompleta");
            rendimiento2.setCantidad(rs.getInt("primaria_incompleta"));
            rendimientoPorEscolaridad.add(rendimiento2);

            rendimiento3.setDecripcion("primaria");
            rendimiento3.setCantidad(rs.getInt("primaria"));
            rendimientoPorEscolaridad.add(rendimiento3);

            rendimiento4.setDecripcion("secundaria");
            rendimiento4.setCantidad(rs.getInt("secundaria"));
            rendimientoPorEscolaridad.add(rendimiento4);

            rendimiento5.setDecripcion("preparatoria");
            rendimiento5.setCantidad(rs.getInt("preparatoria"));
            rendimientoPorEscolaridad.add(rendimiento5);

            rendimiento6.setDecripcion("licenciatura");
            rendimiento6.setCantidad(rs.getInt("licenciatura"));
            rendimientoPorEscolaridad.add(rendimiento6);

            rendimiento7.setDecripcion("posgrado");
            rendimiento7.setCantidad(rs.getInt("posgrado"));
            rendimientoPorEscolaridad.add(rendimiento7);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("RendimientoServicioImpl mostrarVisitaEscolaridad");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return rendimientoPorEscolaridad;
    }

    @Override
    public ArrayList<Rendimiento> mostrarVisitaLugarResidencia(int idEmpleado, Date fecha) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<Rendimiento> rendimientoPorLugarResidencia = new ArrayList<>();

        //Call del store procedure
        String stProcedure = "CALL ResidenciaPacienteMes(?,?)";

        try {
            Rendimiento rendimiento1 = new Rendimiento();
            Rendimiento rendimiento2 = new Rendimiento();
            Rendimiento rendimiento3 = new Rendimiento();
            Rendimiento rendimiento4 = new Rendimiento();
            Rendimiento rendimiento5 = new Rendimiento();
            Rendimiento rendimiento6 = new Rendimiento();
            Rendimiento rendimiento7 = new Rendimiento();
            Rendimiento rendimiento8 = new Rendimiento();
            Rendimiento rendimiento9 = new Rendimiento();
            Rendimiento rendimiento10 = new Rendimiento();
            Rendimiento rendimiento11 = new Rendimiento();
            Rendimiento rendimiento12 = new Rendimiento();
            Rendimiento rendimiento13 = new Rendimiento();
            Rendimiento rendimiento14 = new Rendimiento();
            Rendimiento rendimiento15 = new Rendimiento();
            Rendimiento rendimiento16 = new Rendimiento();
            Rendimiento rendimiento17 = new Rendimiento();
            Rendimiento rendimiento18 = new Rendimiento();
            Rendimiento rendimiento19 = new Rendimiento();
            Rendimiento rendimiento20 = new Rendimiento();
            Rendimiento rendimiento21 = new Rendimiento();
            Rendimiento rendimiento22 = new Rendimiento();
            Rendimiento rendimiento23 = new Rendimiento();
            Rendimiento rendimiento24 = new Rendimiento();
            Rendimiento rendimiento25 = new Rendimiento();
            Rendimiento rendimiento26 = new Rendimiento();
            Rendimiento rendimiento27 = new Rendimiento();
            Rendimiento rendimiento28 = new Rendimiento();
            Rendimiento rendimiento29 = new Rendimiento();
            Rendimiento rendimiento30 = new Rendimiento();
            Rendimiento rendimiento31 = new Rendimiento();
            Rendimiento rendimiento32 = new Rendimiento();

            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEmpleado);
            cstmt.setDate(2, fecha);

            rs = cstmt.executeQuery();

            rs.next();
            rendimiento1.setDecripcion("Aguascalientes");
            rendimiento1.setCantidad(rs.getInt("E1"));
            rendimientoPorLugarResidencia.add(rendimiento1);

            rendimiento2.setDecripcion("Baja California");
            rendimiento2.setCantidad(rs.getInt("E2"));
            rendimientoPorLugarResidencia.add(rendimiento2);

            rendimiento3.setDecripcion("Baja California Sur");
            rendimiento3.setCantidad(rs.getInt("E3"));
            rendimientoPorLugarResidencia.add(rendimiento3);

            rendimiento4.setDecripcion("Campeche");
            rendimiento4.setCantidad(rs.getInt("E4"));
            rendimientoPorLugarResidencia.add(rendimiento4);

            rendimiento5.setDecripcion("Coahuila de Zaragoza");
            rendimiento5.setCantidad(rs.getInt("E5"));
            rendimientoPorLugarResidencia.add(rendimiento5);

            rendimiento6.setDecripcion("Colima");
            rendimiento6.setCantidad(rs.getInt("E6"));
            rendimientoPorLugarResidencia.add(rendimiento6);

            rendimiento7.setDecripcion("Chiapas");
            rendimiento7.setCantidad(rs.getInt("E7"));
            rendimientoPorLugarResidencia.add(rendimiento7);

            rendimiento8.setDecripcion("Chihuahua");
            rendimiento8.setCantidad(rs.getInt("E8"));
            rendimientoPorLugarResidencia.add(rendimiento8);

            rendimiento9.setDecripcion("Ciudad de México");
            rendimiento9.setCantidad(rs.getInt("E9"));
            rendimientoPorLugarResidencia.add(rendimiento9);

            rendimiento10.setDecripcion("Durango");
            rendimiento10.setCantidad(rs.getInt("E10"));
            rendimientoPorLugarResidencia.add(rendimiento10);

            rendimiento11.setDecripcion("Guanajuato");
            rendimiento11.setCantidad(rs.getInt("E11"));
            rendimientoPorLugarResidencia.add(rendimiento11);

            rendimiento12.setDecripcion("Guerrero");
            rendimiento12.setCantidad(rs.getInt("E12"));
            rendimientoPorLugarResidencia.add(rendimiento12);

            rendimiento13.setDecripcion("Hidalgo");
            rendimiento13.setCantidad(rs.getInt("E13"));
            rendimientoPorLugarResidencia.add(rendimiento13);

            rendimiento14.setDecripcion("Jalisco");
            rendimiento14.setCantidad(rs.getInt("E14"));
            rendimientoPorLugarResidencia.add(rendimiento14);

            rendimiento15.setDecripcion("México");
            rendimiento15.setCantidad(rs.getInt("E15"));
            rendimientoPorLugarResidencia.add(rendimiento15);

            rendimiento16.setDecripcion("Michoacán de Ocampo");
            rendimiento16.setCantidad(rs.getInt("E16"));
            rendimientoPorLugarResidencia.add(rendimiento16);

            rendimiento17.setDecripcion("Morelos");
            rendimiento17.setCantidad(rs.getInt("E17"));
            rendimientoPorLugarResidencia.add(rendimiento17);

            rendimiento18.setDecripcion("Nayarit");
            rendimiento18.setCantidad(rs.getInt("E18"));
            rendimientoPorLugarResidencia.add(rendimiento18);

            rendimiento19.setDecripcion("Nuevo León");
            rendimiento19.setCantidad(rs.getInt("E19"));
            rendimientoPorLugarResidencia.add(rendimiento19);

            rendimiento20.setDecripcion("Oaxaca");
            rendimiento20.setCantidad(rs.getInt("E20"));
            rendimientoPorLugarResidencia.add(rendimiento20);

            rendimiento21.setDecripcion("Puebla");
            rendimiento21.setCantidad(rs.getInt("E21"));
            rendimientoPorLugarResidencia.add(rendimiento21);

            rendimiento22.setDecripcion("Querétaro");
            rendimiento22.setCantidad(rs.getInt("E22"));
            rendimientoPorLugarResidencia.add(rendimiento22);

            rendimiento23.setDecripcion("Quintana Roo");
            rendimiento23.setCantidad(rs.getInt("E23"));
            rendimientoPorLugarResidencia.add(rendimiento23);

            rendimiento24.setDecripcion("San Luis Potosí");
            rendimiento24.setCantidad(rs.getInt("E24"));
            rendimientoPorLugarResidencia.add(rendimiento24);

            rendimiento25.setDecripcion("Sinaloa");
            rendimiento25.setCantidad(rs.getInt("E25"));
            rendimientoPorLugarResidencia.add(rendimiento25);

            rendimiento26.setDecripcion("Sonora");
            rendimiento26.setCantidad(rs.getInt("E26"));
            rendimientoPorLugarResidencia.add(rendimiento26);

            rendimiento27.setDecripcion("Tabasco");
            rendimiento27.setCantidad(rs.getInt("E27"));
            rendimientoPorLugarResidencia.add(rendimiento27);

            rendimiento28.setDecripcion("Tamaulipas");
            rendimiento28.setCantidad(rs.getInt("E28"));
            rendimientoPorLugarResidencia.add(rendimiento28);

            rendimiento29.setDecripcion("Tlaxcala");
            rendimiento29.setCantidad(rs.getInt("E29"));
            rendimientoPorLugarResidencia.add(rendimiento29);

            rendimiento30.setDecripcion("Veracruz de Ignacio de la Llave");
            rendimiento30.setCantidad(rs.getInt("E30"));
            rendimientoPorLugarResidencia.add(rendimiento30);

            rendimiento31.setDecripcion("Yucatán");
            rendimiento31.setCantidad(rs.getInt("E31"));
            rendimientoPorLugarResidencia.add(rendimiento31);

            rendimiento32.setDecripcion("Zacatecas");
            rendimiento32.setCantidad(rs.getInt("E32"));
            rendimientoPorLugarResidencia.add(rendimiento32);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("RendimientoServicioImpl mostrarVisitaLugarResidencia");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return rendimientoPorLugarResidencia;
    }

    @Override
    public ArrayList<Rendimiento> mostrarVisitaNivelSocioEconomico(int idEmpleado, Date fecha) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<Rendimiento> rendimientoPorNivelSocioEconomico = new ArrayList<>();

        //Call del store procedure
        String stProcedure = "CALL SocioeconomicoPacienteMes(?,?)";

        try {
            Rendimiento rendimiento1 = new Rendimiento();
            Rendimiento rendimiento2 = new Rendimiento();
            Rendimiento rendimiento3 = new Rendimiento();
            Rendimiento rendimiento4 = new Rendimiento();
            Rendimiento rendimiento5 = new Rendimiento();
            Rendimiento rendimiento6 = new Rendimiento();

            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEmpleado);
            cstmt.setDate(2, fecha);

            rs = cstmt.executeQuery();

            rs.next();
            rendimiento1.setDecripcion("uno");
            rendimiento1.setCantidad(rs.getInt("uno"));
            rendimientoPorNivelSocioEconomico.add(rendimiento1);
            rendimiento2.setDecripcion("dos");
            rendimiento2.setCantidad(rs.getInt("dos"));
            rendimientoPorNivelSocioEconomico.add(rendimiento2);
            rendimiento3.setDecripcion("tres");
            rendimiento3.setCantidad(rs.getInt("tres"));
            rendimientoPorNivelSocioEconomico.add(rendimiento3);
            rendimiento4.setDecripcion("cuatro");
            rendimiento4.setCantidad(rs.getInt("cuatro"));
            rendimientoPorNivelSocioEconomico.add(rendimiento4);
            rendimiento5.setDecripcion("cinco");
            rendimiento5.setCantidad(rs.getInt("cinco"));
            rendimientoPorNivelSocioEconomico.add(rendimiento5);
            rendimiento6.setDecripcion("seis");
            rendimiento6.setCantidad(rs.getInt("seis"));
            rendimientoPorNivelSocioEconomico.add(rendimiento6);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("RendimientoServicioImpl mostrarVisitaNivelSocioEconomico");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return rendimientoPorNivelSocioEconomico;
    }

    @Override
    public ArrayList<Rendimiento> mostrarVisitaDecisionPreconsulta(int idEmpleado, Date fecha) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<Rendimiento> rendimientoPorDecisionPreconsulta = new ArrayList<>();

        //Call del store procedure
        String stProcedure = "CALL DecisionPreconsultaPacienteMes(?,?)";

        try {
            Rendimiento rendimiento1 = new Rendimiento();
            Rendimiento rendimiento2 = new Rendimiento();
            Rendimiento rendimiento3 = new Rendimiento();
            Rendimiento rendimiento4 = new Rendimiento();
            Rendimiento rendimiento5 = new Rendimiento();

            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEmpleado);
            cstmt.setDate(2, fecha);

            rs = cstmt.executeQuery();

            rs.next();
            rendimiento1.setDecripcion("Unidad Funcional");
            rendimiento1.setCantidad(rs.getInt("uf"));
            rendimientoPorDecisionPreconsulta.add(rendimiento1);
            rendimiento2.setDecripcion("Alta");
            rendimiento2.setCantidad(rs.getInt("alta"));
            rendimientoPorDecisionPreconsulta.add(rendimiento2);
            rendimiento3.setDecripcion("Alta Voluntaria");
            rendimiento3.setCantidad(rs.getInt("altaVoluntaria"));
            rendimientoPorDecisionPreconsulta.add(rendimiento3);
            rendimiento4.setDecripcion("Finada");
            rendimiento4.setCantidad(rs.getInt("finada"));
            rendimientoPorDecisionPreconsulta.add(rendimiento4);
            rendimiento5.setDecripcion("Perdida");
            rendimiento5.setCantidad(rs.getInt("perdida"));
            rendimientoPorDecisionPreconsulta.add(rendimiento5);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("RendimientoServicioImpl mostrarVisitaDecisionPreconsulta");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return rendimientoPorDecisionPreconsulta;
    }

    @Override
    public ArrayList<Rendimiento> mostrarVisitaResultadoPatologia(int idEmpleado, Date fecha) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        ArrayList<Rendimiento> rendimientoPorResultadoPatologia = new ArrayList<>();

        //Call del store procedure
        String stProcedure = "CALL DiagnosticoPatologiaPacienteMes(?,?)";

        try {
            Rendimiento rendimiento1 = new Rendimiento();
            Rendimiento rendimiento2 = new Rendimiento();
            Rendimiento rendimiento3 = new Rendimiento();
            Rendimiento rendimiento4 = new Rendimiento();
            Rendimiento rendimiento5 = new Rendimiento();
            Rendimiento rendimiento6 = new Rendimiento();
            Rendimiento rendimiento7 = new Rendimiento();
            Rendimiento rendimiento8 = new Rendimiento();
            Rendimiento rendimiento9 = new Rendimiento();
            Rendimiento rendimiento10 = new Rendimiento();
            Rendimiento rendimiento11 = new Rendimiento();
            Rendimiento rendimiento12 = new Rendimiento();
            Rendimiento rendimiento13 = new Rendimiento();
            Rendimiento rendimiento14 = new Rendimiento();
            Rendimiento rendimiento15 = new Rendimiento();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idEmpleado);
            cstmt.setDate(2, fecha);

            rs = cstmt.executeQuery();

            rs.next();

            rendimiento1.setDecripcion("Carcinoma ductal in situ");
            rendimiento1.setCantidad(rs.getInt("P1"));
            rendimientoPorResultadoPatologia.add(rendimiento1);

            rendimiento2.setDecripcion("Carcinoma lobulillar in situ");
            rendimiento2.setCantidad(rs.getInt("P2"));
            rendimientoPorResultadoPatologia.add(rendimiento2);

            rendimiento3.setDecripcion("Carcinoma ductal infiltrante");
            rendimiento3.setCantidad(rs.getInt("P3"));
            rendimientoPorResultadoPatologia.add(rendimiento3);

            rendimiento4.setDecripcion("Carcinoma tubular");
            rendimiento4.setCantidad(rs.getInt("P4"));
            rendimientoPorResultadoPatologia.add(rendimiento4);

            rendimiento5.setDecripcion("Carcinoma mucinoso");
            rendimiento5.setCantidad(rs.getInt("P5"));
            rendimientoPorResultadoPatologia.add(rendimiento5);

            rendimiento6.setDecripcion("Carcinoma medular");
            rendimiento6.setCantidad(rs.getInt("P6"));
            rendimientoPorResultadoPatologia.add(rendimiento6);

            rendimiento7.setDecripcion("Carcinoma tubulolobulillar");
            rendimiento7.setCantidad(rs.getInt("P7"));
            rendimientoPorResultadoPatologia.add(rendimiento7);

            rendimiento8.setDecripcion("Carcinoma micropapilar");
            rendimiento8.setCantidad(rs.getInt("P8"));
            rendimientoPorResultadoPatologia.add(rendimiento8);

            rendimiento9.setDecripcion("Carcinoma metaplastico");
            rendimiento9.setCantidad(rs.getInt("P9"));
            rendimientoPorResultadoPatologia.add(rendimiento9);

            rendimiento10.setDecripcion("Carcinoma adenoideo quístico");
            rendimiento10.setCantidad(rs.getInt("P10"));
            rendimientoPorResultadoPatologia.add(rendimiento10);

            rendimiento11.setDecripcion("Sarcoma");
            rendimiento11.setCantidad(rs.getInt("P11"));
            rendimientoPorResultadoPatologia.add(rendimiento11);

            rendimiento13.setDecripcion("Quiste no proliferativo");
            rendimiento13.setCantidad(rs.getInt("P13"));
            rendimientoPorResultadoPatologia.add(rendimiento13);

            rendimiento14.setDecripcion("Cambios papilares apocrinos");
            rendimiento14.setCantidad(rs.getInt("P14"));
            rendimientoPorResultadoPatologia.add(rendimiento14);

            rendimiento15.setDecripcion("Hiperplasia");
            rendimiento15.setCantidad(rs.getInt("P15"));
            rendimientoPorResultadoPatologia.add(rendimiento15);
            
            rendimiento12.setDecripcion("Otro");
            rendimiento12.setCantidad(rs.getInt("P12"));
            rendimientoPorResultadoPatologia.add(rendimiento12);
            
            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("RendimientoServicioImpl mostrarVisitaResultadoPatologia");
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
        }
        return rendimientoPorResultadoPatologia;
    }
    
}
