/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.util.List;
import mx.itesm.sapi.bean.persona.Estado;

/**
 *
 * @author Angel GTZ
 */
public interface EstadoServicio {
    
    public Estado mostrarEstado(int idEstado);
    List<Estado> mostrarEstado();
    public int agregarEstado(Estado estado);
    public boolean actualizarEstado(Estado estado);
    public boolean borradoLogicoEstado(int idEstado);
    
}
