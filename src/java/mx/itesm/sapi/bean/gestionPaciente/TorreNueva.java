/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

/**
 *
 * @author A01422575
 */
public class TorreNueva {
    private int idTorreNueva;
    private int nombre;
    private int estatus;
    
    public TorreNueva() {}

    @Override 
    public String toString(){
        String str= "TorreNueva [idTorreNueva:".concat(String.valueOf(idTorreNueva))
                .concat(",nombre:").concat(String.valueOf(nombre))
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }
}
