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
    public Cita getCita(int idCita);
    public List<Cita> getAllCita();
    public boolean saveCita(Cita cita);
    public boolean deleteCita(int idCita);
    public boolean updateCita(Cita cita);
}
