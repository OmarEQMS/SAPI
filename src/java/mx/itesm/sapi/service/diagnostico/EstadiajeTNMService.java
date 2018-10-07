/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.diagnostico;

import java.util.List;
import mx.itesm.sapi.bean.diagnostico.EstadiajeTNM;

/**
 *
 * @author Diego
 */
public interface EstadiajeTNMService {
    public EstadiajeTNM getEstadiajeTNM(int idRegistroTNM);
    List<EstadiajeTNM> getEstadiajeTNM();
    public boolean agregarEstadiajeTNM(EstadiajeTNM estadiajeTNM);
    public boolean actualizarEstadiajeTNM(int idRegistroTNM);
    public boolean borradoLogicoEstadiajeTNM(int idRegistroTNM);
}
