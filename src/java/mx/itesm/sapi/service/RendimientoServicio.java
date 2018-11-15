/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import mx.itesm.sapi.bean.Rendimiento;

/**
 *
 * @author Raul Orihuela
 */
/**
 * Field summary private String decripcion: Contiene la descripcion del grupo de
 * datos private int cantidad: Contiene el total de datos dentro del grupo
 */
/**
 * public interface RendimientoServicio Interfaz que define los metodos para
 * RendimientoServicioImpl
 */
public interface RendimientoServicio {
    public Rendimiento mostrarVisitaMes(int idEmpleado, Timestamp fecha);
    public ArrayList<Rendimiento> mostrarVisitaEdad(int idEmpleado, Timestamp fecha);
    public ArrayList<Rendimiento> mostrarVisitaEscolaridad(int idEmpleado, Timestamp fecha);
    public ArrayList<Rendimiento> mostrarVisitaLugarResidencia(int idEmpleado, Timestamp fecha);
    public ArrayList<Rendimiento> mostrarVisitaNivelSocioEconomico(int idEmpleado, Timestamp fecha);
    public ArrayList<Rendimiento> mostrarVisitaDecisionPreconsulta(int idEmpleado, Timestamp fecha);
    public ArrayList<Rendimiento> mostrarVisitaResultadoPatologia(int idEmpleado, Timestamp fecha);
}
