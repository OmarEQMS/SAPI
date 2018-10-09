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
 * @author urieldiaz
 */
public interface ComentarioCitaService {
    public ComentarioCita getComentarioCita(int idComentarioCita);
    public List<ComentarioCita> getComentarioCita();
    public boolean agregarComentarioCita(ComentarioCita comentarioCita);
    public boolean borradoLogicoComentarioCita(ComentarioCita comentarioCita);
    public boolean actualizarComentarioCita(ComentarioCita comentarioCita);
}
