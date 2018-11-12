/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.moduloGestionMedico;

import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.Especialidad;

/**
 *
 * @author Fernanda Orduña & Pablo Lugo
 */
public interface EspecialidadServicio {
    public Especialidad mostrarEspecialidad(int idEspecialidad);
    public List<Especialidad> mostrarEspecialidad();
    
}
