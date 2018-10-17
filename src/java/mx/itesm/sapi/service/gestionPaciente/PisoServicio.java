/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Piso;
/**
 *
 * @author Alex
 */
public interface PisoServicio {
    public Piso mostrarPiso(int idPiso);
    public List<Piso> mostrarPiso();
    public int agregarPiso(Piso piso);
    public boolean actualizarPiso(Piso piso);
    public boolean borradoLogicoPiso(int idPiso);
}
