/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.diagnostico;

import java.util.List;
import mx.itesm.sapi.bean.diagnostico.EtapaClinica;

/**
 *
 * @author Diego
 */
public interface EtapaClinicaService {
    public EtapaClinica mostrarEtapaClinica(int idEtapaClinica);
    List<EtapaClinica> mostrarEtapaClinica();
}
