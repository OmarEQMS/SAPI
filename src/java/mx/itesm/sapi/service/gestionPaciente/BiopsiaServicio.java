/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Biopsia;

/**
 *
 * @author Uriel Díaz & Oscar Miranda
 */
public interface BiopsiaServicio {
    public Biopsia mostrarBiopsia(int idBiopsia);
    public Biopsia mostrarBiopsiaIdPaciente(int idPaciente);
    public Biopsia mostrarBiopsiaPreviaPaciente(int idPaciente, int previo);
     public List<Biopsia> mostrarAllBiopsiaIdEspecifico(int idPaciente);
    public List<Biopsia> mostrarAllBiopsia();
    public int agregarBiopsia(Biopsia biopsia);
    public boolean borradoLogicoBiopsia (int idBiopsia);
    public boolean actualizarBiopsia(Biopsia biopsia);       
    public Biopsia mostrarUltimaBiopsiaPaciente(int idPaciente);
    public int agregarBiopsiaFormulario(Biopsia biopsia);
    public boolean actualizarBiopsiaFormulario(Biopsia biopsia);   
    public boolean actualizarBiopsiaResultado(Biopsia biopsia); 
    public int agregarBiopsiaResultado(Biopsia biopsia);
}
