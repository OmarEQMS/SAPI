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
public class Biopsia {

    private int idBiopsia;
    private int idPaciente;
    private int idLugarDelCuerpo;
    private int idTipoHistologico;
    private int idHer2;
    private int idReceptorProgesterona;
    private int idReceptorEstrogeno;
    private int idFish;
    private int idKi67;
    private int laminillas;
    private int bloques;
    private int previa;
    private int estatus;
    
    public Biopsia() {}
 	@Override
 	public String toString(){
 		String str="Biopsia [idBiopsia:".concat(String.valueOf(idBiopsia))
 			.concat(",idPaciente:").concat(String.valueOf(idPaciente))
 			.concat(",idLugarDelCuerpo:").concat(String.valueOf(idLugarDelCuerpo))
 			.concat(",idTipoHistologico:").concat(String.valueOf(idTipoHistologico))
                        .concat(",idHet2:").concat(String.valueOf(idHer2))
                        .concat(",idReceptorProgesterona:").concat(String.valueOf(idReceptorProgesterona))
 			.concat(",idReceptorEstrogeno:").concat(String.valueOf(idReceptorEstrogeno))
 			.concat(",idFish:").concat(String.valueOf(idFish))
 			.concat(",idKi67:").concat(String.valueOf(idKi67))
 			.concat(",laminillas:").concat(String.valueOf(laminillas))
 			.concat(",bloques:").concat(String.valueOf(bloques))
 			.concat(",previa:").concat(String.valueOf(previa))
 			.concat(",estatus:").concat(String.valueOf(estatus))
 			.concat("]");
 		return str;

 	}

    public int getIdBiopsia() {
        return idBiopsia;
    }

    public void setIdBiopsia(int idBiopsia) {
        this.idBiopsia = idBiopsia;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdLugarDelCuerpo() {
        return idLugarDelCuerpo;
    }

    public void setIdLugarDelCuerpo(int idLugarDelCuerpo) {
        this.idLugarDelCuerpo = idLugarDelCuerpo;
    }

    public int getIdTipoHistologico() {
        return idTipoHistologico;
    }

    public void setIdTipoHistologico(int idTipoHistologico) {
        this.idTipoHistologico = idTipoHistologico;
    }

    public int getIdHer2() {
        return idHer2;
    }

    public void setIdHer2(int idHer2) {
        this.idHer2 = idHer2;
    }

    public int getIdReceptorProgesterona() {
        return idReceptorProgesterona;
    }

    public void setIdReceptorProgesterona(int idReceptorProgesterona) {
        this.idReceptorProgesterona = idReceptorProgesterona;
    }

    public int getIdReceptorEstrogeno() {
        return idReceptorEstrogeno;
    }

    public void setIdReceptorEstrogeno(int idReceptorEstrogeno) {
        this.idReceptorEstrogeno = idReceptorEstrogeno;
    }

    public int getIdFish() {
        return idFish;
    }

    public void setIdFish(int idFish) {
        this.idFish = idFish;
    }

    public int getIdKi67() {
        return idKi67;
    }

    public void setIdKi67(int idKi67) {
        this.idKi67 = idKi67;
    }

    public int getLaminillas() {
        return laminillas;
    }

    public void setLaminillas(int laminillas) {
        this.laminillas = laminillas;
    }

    public int getBloques() {
        return bloques;
    }

    public void setBloques(int bloques) {
        this.bloques = bloques;
    }

    public int getPrevia() {
        return previa;
    }

    public void setPrevia(int previa) {
        this.previa = previa;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    
}
