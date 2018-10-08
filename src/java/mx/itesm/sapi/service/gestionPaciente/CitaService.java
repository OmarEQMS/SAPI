/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Cita;

/**
 *
 * @author urieldiaz
 */
public interface CitaService {
    public Cita mostrarCita(int idCita);
    public List<Cita> mostrarAllCita();
    public boolean agregarCita(Cita cita);
    public boolean borrarCita(int idCita);
    public boolean actualizarCita(Cita cita);
}
