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
public class Escolaridad {
    
    private int idEscolardiad;
    private String nombre;
    private int estatus;
    
    public Escolaridad() {}
    
    @Override
    public String toString(){
        String str="Escolaridad [idEscolardiad:".concat(String.valueOf(idEscolardiad))
                .concat(",nombre:").concat(nombre)
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
    
        return str;
    }

    public int getIdEscolardiad() {
        return idEscolardiad;
    }

    public void setIdEscolardiad(int idEscolardiad) {
        this.idEscolardiad = idEscolardiad;
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
