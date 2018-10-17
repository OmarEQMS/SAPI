/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionTratamiento;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class AlergiaPacienteFarmaco implements Serializable{
   
    private int idAlergiaPacienteFarmaco;
    private int idPaciente;
    private int idFarmaco;
    private int estatus;

    public int getIdAlergiaPacienteFarmaco() {
        return idAlergiaPacienteFarmaco;
    }

    public void setIdAlergiaPacienteFarmaco(int idAlergiaPacienteFarmaco) {
        this.idAlergiaPacienteFarmaco = idAlergiaPacienteFarmaco;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdFarmaco() {
        return idFarmaco;
    }

    public void setIdFarmaco(int idFarmaco) {
        this.idFarmaco = idFarmaco;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "AlergiaPacienteFarmaco{" + "idAlergiaPacienteFarmaco=" + idAlergiaPacienteFarmaco + ", idPaciente=" + idPaciente + ", idFarmaco=" + idFarmaco + ", estatus=" + estatus + '}';
    }

}
