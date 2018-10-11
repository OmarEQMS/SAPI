/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.ResultadoPatologia;

/**
 *
 * @author urieldiaz
 */
public interface ResultadoPatologiaService {
    public ResultadoPatologia mostrarResultadoPatologia(int idResultadoPatologia);
    public List<ResultadoPatologia> mostrarAllResultadoPatologia();
    public int agregarResultadoPatologia(ResultadoPatologia resultadoPatologia);
    public boolean borradoLogicoResultadoPatologia(int idResultadoPatologia);
    public boolean actualizarResultadoPatologia (ResultadoPatologia resultadoPatologia);
}
