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
 * @author Diego Montoya
 */
public interface EstadiajeTNMService {
    public int agregarEstadiajeTNM(EstadiajeTNM estadiajeTNM);
    public EstadiajeTNM mostrarEstadiajeTNM(int idRegistroTNM);
    List<EstadiajeTNM> mostrarEstadiajeTNM();
    public boolean actualizarEstadiajeTNM(EstadiajeTNM idRegistroTNM);
    public boolean borradoLogicoEstadiajeTNM(int idRegistroTNM);
}
