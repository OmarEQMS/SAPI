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
public class OtroEstudio {
    private int idOtroEstudio;
    private int idEstudio;
    private String nombre;
    private int estatus;
    
     public OtroEstudio() {}
    
    @Override 
    public String toString(){
        String str= "OtroEstudio [idOtroEstudio:".concat(String.valueOf(idOtroEstudio))
                .concat(",idEstudio:").concat(String.valueOf(idEstudio))
                .concat(",nombre:").concat(nombre)
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }
}
