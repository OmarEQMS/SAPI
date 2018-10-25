/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.util.List;
import mx.itesm.sapi.bean.persona.Persona;

/**
 *
 * @author Angel GTZ
 */
public interface PersonaServicio {
    public Persona mostrarPersona(int idPersona);
    List<Persona> mostrarPersona();
    public int agregarPersona(Persona persona);
    public boolean actualizarPersona(Persona persona);
    public boolean borradoLogicoPersona(int idPersona);
    public boolean actualizarSexoPersona(int idPersona,int idSexo);
    
}
