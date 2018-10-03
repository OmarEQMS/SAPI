/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.diagnostico;

import java.io.Serializable;

/**
 *
 * @author Diego
 */
public class LugarDelCuerpoEstadiajeTNM implements Serializable{
    private int idLugarDelCuerpoEstadiajeTNM;
    private int idLugarDelCuerpo;
    private int idRegistroTNM;
    private int estatus;

    @Override
    public String toString() {
        return "LugarDelCuerpoEstadiajeTNM{" + "idLugarDelCuerpoEstadiajeTNM=" + idLugarDelCuerpoEstadiajeTNM + ", idLugarDelCuerpo=" + idLugarDelCuerpo + ", idRegistroTNM=" + idRegistroTNM + ", estatus=" + estatus + '}';
    }

    public int getIdLugarDelCuerpoEstadiajeTNM() {
        return idLugarDelCuerpoEstadiajeTNM;
    }

    public void setIdLugarDelCuerpoEstadiajeTNM(int idLugarDelCuerpoEstadiajeTNM) {
        this.idLugarDelCuerpoEstadiajeTNM = idLugarDelCuerpoEstadiajeTNM;
    }

    public int getIdLugarDelCuerpo() {
        return idLugarDelCuerpo;
    }

    public void setIdLugarDelCuerpo(int idLugarDelCuerpo) {
        this.idLugarDelCuerpo = idLugarDelCuerpo;
    }

    public int getIdRegistroTNM() {
        return idRegistroTNM;
    }

    public void setIdRegistroTNM(int idRegistroTNM) {
        this.idRegistroTNM = idRegistroTNM;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
