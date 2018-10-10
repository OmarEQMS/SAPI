/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;
import java.util.List;
import mx.itesm.sapi.bean.persona.Persona;

/**
 *
 * @author feror
 */
public interface PersonaServicio {
    public Persona getPersona(int idPersona);
    public List<Persona> getPersonas();
    public int savePersona(Persona persona);
    public boolean deletePersona(int idPersona);
    public boolean updatePersona(Persona persona);
    
    
    
}