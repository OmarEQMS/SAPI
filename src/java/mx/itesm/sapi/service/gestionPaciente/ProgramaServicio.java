/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Programa;

/**
 *
 * @author Uriel Díaz
 */
public interface ProgramaServicio {
    public Programa mostrarPrograma(int idPrograma);
    public List<Programa> mostrarPrograma();
    public int agregarPrograma(Programa programa);
    //public boolean deletePrograma(int idPrograma);
     public boolean borradoLogicoPrograma(int idPrograma);
    public boolean actualizarPrograma(Programa programa);
}
