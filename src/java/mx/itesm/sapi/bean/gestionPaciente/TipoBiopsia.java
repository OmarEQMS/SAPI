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
public class TipoBiopsia {
    private int idTipoBiopsia;
    private String nombre;
    private int estatus;
    
    
    public TipoBiopsia(){}
        @Override
        public String toString(){
            String str = "TipoBiopsia [idTipoBiopsia:".concat(String.valueOf(idTipoBiopsia))
 			.concat(",nombre:").concat(nombre).concat(",estatus:").concat(String.valueOf(estatus)).concat("]");
                    
            return str;
        }

    public int getIdTipoBiopsia() {
        return idTipoBiopsia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setIdTipoBiopsia(int idTipoBiopsia) {
        this.idTipoBiopsia = idTipoBiopsia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
        
        
}
