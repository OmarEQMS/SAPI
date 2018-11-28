/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.ComentarioCita;

/**
 *
 * @author Oscar Miranda
 */
public interface ComentarioCitaServicio {
    public ComentarioCita mostrarComentarioCita(int idComentarioCita);
    public ComentarioCita mostrarComentarioCitaIdCita(int idComentarioCita);
   
    public List<ComentarioCita> mostrarComentarioCita();
    public int agregarComentarioCita(ComentarioCita comentarioCita);
    public boolean borradoLogicoComentarioCita(int idComentarioCita);
    public boolean actualizarComentarioCita(ComentarioCita  comentarioCita);
    
}
