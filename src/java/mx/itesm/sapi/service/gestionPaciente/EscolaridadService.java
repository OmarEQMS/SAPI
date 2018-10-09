/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Escolaridad;

/**
 *
 * @author urieldiaz
 */
public interface EscolaridadService {
    public Escolaridad mostrarEscolaridad(int idEscolaridad);
    public List<Escolaridad> mostrarAllEscolaridad();
    public boolean agregarEscolaridad(Escolaridad escolaridad);
    public boolean borradoLogicoEscolaridad(int idEscolaridad);
    public boolean actualizarEscolaridad(Escolaridad escolaridad);
}
