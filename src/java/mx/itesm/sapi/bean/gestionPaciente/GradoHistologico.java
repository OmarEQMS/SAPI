/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

/**
 *
 * @author Oscar Miranda
 */
public class GradoHistologico {
    private int idGradoHistologico;
    private String nombre;
    private int estatus;
    
    public GradoHistologico() {}
    
    @Override 
    public String toString(){
        String str= "GradoHistologico [idGradoHistologico:".concat(String.valueOf(idGradoHistologico))
                .concat(",nombre:").concat(nombre)
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public int getIdGradoHistologico() {
        return idGradoHistologico;
    }

    public void setIdGradoHistologico(int idGradoHistologico) {
        this.idGradoHistologico = idGradoHistologico;
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
