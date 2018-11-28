/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;


import java.sql.Timestamp;
import java.util.List;
import mx.itesm.sapi.bean.persona.InformacionGeneralPersona;
import mx.itesm.sapi.bean.persona.Persona;

/**
 *
 * @author Angel GTZ
 */
public interface PersonaServicio {
    public Persona mostrarPersona(int idPersona);
    public List<Persona> mostrarPersona();
    public int agregarPersona(Persona persona);
    public int agregarMedico(Persona persona,int idRol);
    public boolean actualizarPersona(Persona persona);
    public boolean borradoLogicoPersona(int idPersona);
    public boolean existsCurp(String curp);
    public boolean existsCorreo(String correo);
    public boolean existsCorreo(String correo, int idPersona);
    public boolean actualizarSexoPersona(int idPersona,int idSexo);
    public Persona mostrarPersonaPorIdPaciente(int idPaciente);

    public List<Persona> mostrarMedicos();

    List<Persona> mostrarMedicosRadiologos();
    List<Persona> mostrarMedicosAdscritos();
    List<Persona> mostrarMedicosResidentes();

    public InformacionGeneralPersona mostrarInformacionGeneralPersona(int idPaciente);
    public boolean actualizarInformacionGeneralPersona(int idPaciente, InformacionGeneralPersona persona);
    public boolean actualizarPersonaMedico(Persona persona);
}
