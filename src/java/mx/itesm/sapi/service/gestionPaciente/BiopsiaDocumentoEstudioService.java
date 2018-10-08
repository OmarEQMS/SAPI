/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.BiopsiaDocumentoEstudio;

/**
 *
 * @author urieldiaz
 */
public interface BiopsiaDocumentoEstudioService {
    public BiopsiaDocumentoEstudio getBiopsiaDocumentoEstudio(int idBiopsiaDocumentoEstudio);
    public List<BiopsiaDocumentoEstudio> getAllBiopsiaDocumentoEstudio();
    public boolean saveBiopsiaDocumentoEstudio(BiopsiaDocumentoEstudio biopsiaDocumentoEstudio);
    public boolean deleteBiopsiaDocumentoEstudio(int idBiopsiaDocumentoEstudio);
    public boolean updateBiopsiaDocumentoEstudio(BiopsiaDocumentoEstudio bbiopsiaDocumentoEstudio);        
}
