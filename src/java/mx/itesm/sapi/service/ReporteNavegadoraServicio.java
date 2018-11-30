/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import mx.itesm.sapi.bean.formulario.ReporteNavegadora;

/**
 *
 * @author Oscar Miranda
 */
public interface ReporteNavegadoraServicio {
    public ReporteNavegadora mostrarReporteNavegadora(int idPaciente, int idEmpleado, int idRol);
}
