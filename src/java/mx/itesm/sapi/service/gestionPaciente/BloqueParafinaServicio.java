/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.BloqueParafina;

/**
 *
 * @author OscarMiranda
 */
public interface BloqueParafinaServicio {
    public BloqueParafina mostrarBloqueParafina(int idBloqueParafina);
    public List<BloqueParafina> mostrarBloqueParafina();
    public int agregarBloqueParafina(BloqueParafina bloqueParafina);
    public boolean borradoLogicoBloqueParafina(int idBloqueParafina);
    public boolean actualizarBloqueParafina(BloqueParafina  bloqueParafina);
}
