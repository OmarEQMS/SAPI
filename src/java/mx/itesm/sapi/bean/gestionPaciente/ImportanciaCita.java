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
public class ImportanciaCita {

	private int idImportanciaCita;
	private int importancia;
	private int estatus;

    public ImportanciaCita() {}

    @Override
    public String toString(){

    	String str="ImportanciaCita [idImportanciaCita:".concat(String.valueOf(idImportanciaCita))
    		.concat(",importancia:").concat(String.valueOf(importancia))
    		.concat(",estatus:").concat(String.valueOf(estatus))
    		.concat("]");

    	return str;

    }

    public int getIdImportanciaCita() {
        return idImportanciaCita;
    }

    public void setIdImportanciaCita(int idImportanciaCita) {
        this.idImportanciaCita = idImportanciaCita;
    }

    public int getImportancia() {
        return importancia;
    }

    public void setImportancia(int importancia) {
        this.importancia = importancia;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
