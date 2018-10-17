/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.util.List;
import mx.itesm.sapi.bean.persona.Rol;

/**
 *
 * @author Angel GTZ
 */
public interface RolServicio {
    public Rol mostrarRol(int idRol);
    List<Rol> mostrarRol();
    public boolean agregarRol(Rol rol);
    public boolean actualizarRol(Rol rol);
    public boolean borradoLogicoRol(int idRol);
}
