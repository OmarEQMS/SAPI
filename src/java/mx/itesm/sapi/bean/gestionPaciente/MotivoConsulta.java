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
public class MotivoConsulta {
    
    private int idMotivoConsulta;
    private String nombre;
    private int estatus;
    public MotivoConsulta() {}
    
    @Override
    public String toString(){
        String str= "MotivoConsulta [idMotivoConsulta:".concat(String.valueOf(idMotivoConsulta))
                .concat(",nombre:").concat(nombre)
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public int getIdMotivoConsulta() {
        return idMotivoConsulta;
    }

    public void setIdMotivoConsulta(int idMotivoConsulta) {
        this.idMotivoConsulta = idMotivoConsulta;
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
