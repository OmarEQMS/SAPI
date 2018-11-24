/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.LlamadaCita;

/**
 *
 * @author Uriel Díaz
 */
public interface LlamadaCitaServicio {

    public LlamadaCita mostrarLlamadaCita(int idLlamadaCita);

    public LlamadaCita mostrarLlamadaCitaIdCita(int idCita);

    public List<LlamadaCita> mostrarLlamadaCita();

    public int agregarLlamadaCita(LlamadaCita llamadaCita);

    public boolean actualizarLlamadaCita(LlamadaCita llamadaCita);

    public boolean borradoLogicoLlamadaCita(int idLlamadaCita);

    public List<LlamadaCita> mostrarLlamaCitaPreconsultaPaciente(int idPaciente);
}
