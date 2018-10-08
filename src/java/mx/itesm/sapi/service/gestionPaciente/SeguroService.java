/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Seguro;

/**
 *
 * @author urieldiaz
 */
public interface SeguroService {
    public Seguro getSeguro(int idSeguro);
    public List<Seguro> getAllSeguro();
    public boolean saveSeguro(Seguro seguro);
    public boolean updateSeguro(Seguro seguro);
    public boolean deleteSeguro(int idSeguro);
}
