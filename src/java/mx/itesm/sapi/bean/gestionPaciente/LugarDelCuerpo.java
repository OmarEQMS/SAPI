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
public class LugarDelCuerpo {
    private int idLugarDelCuerpo;
    private String nombre;
    private int estatus;
    
    public LugarDelCuerpo() {}

    @Override
    public String toString(){
        String str ="LugarDelCuerpo [idLugarDelCuerpo:".concat(String.valueOf(idLugarDelCuerpo))
                .concat(",nombre").concat(nombre)
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }
    
    public int getIdLugarDelCuerpo() {
        return idLugarDelCuerpo;
    }

    public void setIdLugarDelCuerpo(int idLugarDelCuerpo) {
        this.idLugarDelCuerpo = idLugarDelCuerpo;
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
