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
public class BloqueParafina {
    private int idBloqueParafina;
    private int idBiopsia;
    private String serie;
    private int estatus;
    private int cantidad;
    
    public BloqueParafina() {}
 	@Override
 	public String toString(){
 		String str="BloqueParafina [idBloqueParafina:".concat(String.valueOf(idBloqueParafina))
 			.concat(",idBiopsia:").concat(String.valueOf(idBiopsia))
                        .concat(",serie:").concat(serie)
                        .concat(",estatus:").concat(String.valueOf(estatus))
                        .concat("]");
                return str;
        }

    public int getIdBloqueParafina() {
        return idBloqueParafina;
    }

    public void setIdBloqueParafina(int idBloqueParafina) {
        this.idBloqueParafina = idBloqueParafina;
    }

    public int getIdBiopsia() {
        return idBiopsia;
    }

    public void setIdBiopsia(int idBiopsia) {
        this.idBiopsia = idBiopsia;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
        
}
