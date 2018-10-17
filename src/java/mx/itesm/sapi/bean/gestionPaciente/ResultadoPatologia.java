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
public class ResultadoPatologia {

    private int idResultadoPatologia;
    private String nombre;
    
    
    public ResultadoPatologia() {}
    
    @Override
    public String toString(){

    	String str= "ResultadoPatologia [idResultadoPatologia:".concat(String.valueOf(idResultadoPatologia))
    		.concat(",nombre:").concat(nombre);
    	return str;


    }

    public int getIdResultadoPatologia() {
        return idResultadoPatologia;
    }

    public void setIdResultadoPatologia(int idResultadoPatologia) {
        this.idResultadoPatologia = idResultadoPatologia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
