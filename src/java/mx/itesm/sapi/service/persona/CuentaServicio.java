/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.util.List;
import mx.itesm.sapi.bean.persona.Cuenta;

/**
 *
 * @author Angel GTZ
 */
public interface CuentaServicio {
    public Cuenta mostrarCuenta(int idCuenta);
    List<Cuenta> mostrarCuenta();
    public int agregarCuenta(Cuenta cuenta);
    public boolean actualizarCuenta(Cuenta cuenta);
    public boolean borradoLogicoCuenta(int idCuenta);
    public boolean existsUsuario(String usuario);
    public String getToken(String email);
    
}
