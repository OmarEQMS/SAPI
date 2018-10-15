/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.util.List;
import mx.itesm.sapi.bean.persona.EstadoCivil;

/**
 *
 * @author Angel GTZ
 */
public interface EstadoCivilServicio {
    public EstadoCivil mostrarEstadoCivil(int idEstadoCivil);
    List<EstadoCivil> mostrarEstadoCivil();
    public boolean agregarEstadoCivil(EstadoCivil estadoCivil);
    public boolean actualizarEstadoCivil(EstadoCivil idEstadoCivil);
    public boolean borradoLogicoEstadoCivil(int idEstadoCivil);
    
}
