/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.sql.Date;
import java.util.ArrayList;
import mx.itesm.sapi.bean.rendimiento.Rendimiento;

/**
 *
 * @author Angel GTZ
 */
public interface EstadisticaServicio {
    
    public Rendimiento mostrarEstadisticaRango(Date fechaInicio, Date fechaFin);
    public ArrayList<Rendimiento> mostrarEstadisticaEdad(Date fechaInicio, Date fechaFin);
    public ArrayList<Rendimiento> mostrarEstadisticaEscolaridad(Date fechaInicio, Date fechaFin);
    public ArrayList<Rendimiento> mostrarEstadisticaLugarResidencia(Date fechaInicio, Date fechaFin);
    public ArrayList<Rendimiento> mostrarEstadisticaNivelSocioEconomico(Date fechaInicio, Date fechaFin);
    public ArrayList<Rendimiento> mostrarEstadisticaDecisionPreconsulta(Date fechaInicio, Date fechaFin);
    public ArrayList<Rendimiento> mostrarEstadisticaResultadoPatologia(Date fechaInicio, Date fechaFin);
   
}
