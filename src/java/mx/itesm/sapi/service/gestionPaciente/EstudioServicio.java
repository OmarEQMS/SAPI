/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Estudio;

/**
 *
 * @author Oscar Miranda
 */
public interface EstudioServicio {
    public Estudio mostrarEstudio(int idEstudio);
    public List<Estudio> mostrarEstudio();
    public int agregarEstudio(Estudio estudio);
    public boolean borradoLogicoEstudio(int idEstudio);
    public boolean actualizarEstudio(Estudio  estudio);
    
}
