/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.util.List;
import mx.itesm.sapi.bean.persona.EstadoCuenta;

/**
 *
 * @author Angel GTZ
 */
public interface EstadoCuentaServicio {
    public EstadoCuenta mostrarEstadoCuenta(int idEstadoCuenta);
    List<EstadoCuenta> mostrarEstadoCuenta();
    public int agregarEstadoCuenta(EstadoCuenta estadoCuenta);
    public boolean actualizarEstadoCuenta(EstadoCuenta estadoCuenta);
    public boolean borradoLogicoEstadoCuenta(int idEstadoCuenta);
    
}
