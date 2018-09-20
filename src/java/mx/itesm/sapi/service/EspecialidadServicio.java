/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.util.List;
import mx.itesm.sapi.bean.Especialidad;

/**
 *
 * @author Admin
 */
public interface EspecialidadServicio {
    
    public Especialidad getEspecilidades(int idEspecialidad);
    public List<Especialidad> getEspecialidades();
    public boolean saveEspecialidad(Especialidad especialidad);
    public boolean deleteEspecialidad(int idEspecialidad);
    public boolean existsEspecialidad(String nombre);
    
}
