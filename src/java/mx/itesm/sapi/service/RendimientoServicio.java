/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.Date;
import java.util.ArrayList;
import mx.itesm.sapi.bean.Rendimiento;

/**
 *
 * @author Raul Orihuela
 */
/**
 * public interface RendimientoServicio Interfaz que define los metodos para
 * RendimientoServicioImpl
 */
public interface RendimientoServicio {
    public Rendimiento mostrarVisitaRango(int idEmpleado, Date fechaInicio, Date fechaFin);
    public ArrayList<Rendimiento> mostrarVisitaEdad(int idEmpleado, Date fechaInicio, Date fechaFin);
    public ArrayList<Rendimiento> mostrarVisitaEscolaridad(int idEmpleado, Date fechaInicio, Date fechaFin);
    public ArrayList<Rendimiento> mostrarVisitaLugarResidencia(int idEmpleado, Date fechaInicio, Date fechaFin);
    public ArrayList<Rendimiento> mostrarVisitaNivelSocioEconomico(int idEmpleado, Date fechaInicio, Date fechaFin);
    public ArrayList<Rendimiento> mostrarVisitaDecisionPreconsulta(int idEmpleado, Date fechaInicio, Date fechaFin);
    public ArrayList<Rendimiento> mostrarVisitaResultadoPatologia(int idEmpleado, Date fechaInicio, Date fechaFin);
}
