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
public class ReceptorProgesterona {

    
    private int idReceptorProgesterona;
    private String nombre;
    private int estatus;
    
    public ReceptorProgesterona() {}
    
    @Override
    public String toString(){
        String str="ReceptorProgesterona [idReceptorProgesterona:".concat((String.valueOf(idReceptorProgesterona)))
                .concat(",nombre:").concat(nombre)
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public int getIdReceptorProgesterona() {
        return idReceptorProgesterona;
    }

    public void setIdReceptorProgesterona(int idReceptorProgesterona) {
        this.idReceptorProgesterona = idReceptorProgesterona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
