/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

/**
 *
 * @author Alex
 */
public class BiopsiaDocumentoEstudio {

	private int idBiopsiaDocumentoEstudio;
	private int idBiopsia;
	private int idDocumentoEstudio;
	private int estatus;

    public BiopsiaDocumentoEstudio() {}

    @Override
    public String toString(){
    	String str="BiopsiaDocumentoEstudio [idBiopsiaDocumentoEstudio:".concat(String.valueOf(idBiopsiaDocumentoEstudio))
    		.concat(",idBiopsia:").concat(String.valueOf(idBiopsia))
    		.concat(",idDocumentoEstudio:").concat(String.valueOf(idDocumentoEstudio))
    		.concat(",estatus:").concat(String.valueOf(estatus))
    		.concat("]");
    	return str;

    }

    public int getIdBiopsiaDocumentoEstudio() {
        return idBiopsiaDocumentoEstudio;
    }

    public void setIdBiopsiaDocumentoEstudio(int idBiopsiaDocumentoEstudio) {
        this.idBiopsiaDocumentoEstudio = idBiopsiaDocumentoEstudio;
    }

    public int getIdBiopsia() {
        return idBiopsia;
    }

    public void setIdBiopsia(int idBiopsia) {
        this.idBiopsia = idBiopsia;
    }

    public int getIdDocumentoEstudio() {
        return idDocumentoEstudio;
    }

    public void setIdDocumentoEstudio(int idDocumentoEstudio) {
        this.idDocumentoEstudio = idDocumentoEstudio;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
}
