/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

/**
 *
 * @author Angel GTZ
 */
public class OtroResultadoPatologia {
    private int idOtroResultadoPatologia;
    private int idBiopsia;
    private String nombre;
    private int estatus;
    
    public OtroResultadoPatologia(){
        
    }
    
    @Override 
    public String toString(){
        String str= "OtroResultadoPatologia [idOtroResultadoPatologia:".concat(String.valueOf(idOtroResultadoPatologia))
                .concat(",idBiopsia:").concat(String.valueOf(idBiopsia))
                .concat(",nombre:").concat(nombre)
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public int getIdOtroResultadoPatologia() {
        return idOtroResultadoPatologia;
    }

    public int getIdBiopsia() {
        return idBiopsia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setIdOtroResultadoPatologia(int idOtroResultadoPatologia) {
        this.idOtroResultadoPatologia = idOtroResultadoPatologia;
    }

    public void setIdBiopsia(int idBiopsia) {
        this.idBiopsia = idBiopsia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
