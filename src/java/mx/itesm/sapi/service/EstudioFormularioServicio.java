/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.util.List;
import mx.itesm.sapi.bean.formulario.EstudioFormulario;

/**
 *
 * @author Oscar Miranda
 */
public interface EstudioFormularioServicio {
    public List<EstudioFormulario> mostrarFormularioDinamicoFecha(int idPaciente, String nombreEstudio);
    public List<EstudioFormulario> mostrarFormularioDinamicoFechaTipo(int idPaciente, String nombreEstudio);
    public List<EstudioFormulario> mostrarFormularioDinamicoLTF(int idPaciente, String nombreEstudio);
}
