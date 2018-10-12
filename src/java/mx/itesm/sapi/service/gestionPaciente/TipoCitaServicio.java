/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.TipoCita;

/**
 *
 * @author urieldiaz
 */
public interface TipoCitaServicio {
    public TipoCita mostrarTipoCita(int idTipoCita);
    public List<TipoCita> mostrarAllTipoCita();
    public int agregarTipoCita(TipoCita tipoCita);
    public boolean borradoLogicoTipoCita(int idTipoCita);
    public boolean actualizarTipoCita(TipoCita tipoCita);
}
