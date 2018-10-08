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
public interface TipoCitaService {
    public TipoCita getTipoCita(int idTipoCita);
    public List<TipoCita> getAllTipoCita();
    public boolean saveTipoCita(TipoCita tipoCita);
    public boolean deleteTipoCita(int idTipoCita);
    public boolean updateTipoCita(TipoCita tipoCita);
}
