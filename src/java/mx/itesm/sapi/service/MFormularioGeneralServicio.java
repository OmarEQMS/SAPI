/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.formulario.MFormularioGeneral;

/**
 *
 * @author Angel GTZ
 *
 * Se declaran los servicios que recuperan la informacion del formulario
 */
public interface MFormularioGeneralServicio {

    public MFormularioGeneral mostrarFormularioGeneralNavegadora(int idPaciente);

    public ArrayList<MFormularioGeneral> mostrarFormularioLugarTipoFecha(int idPaciente, String nombreEstudio);

    public ArrayList<MFormularioGeneral> mostrarFormularioLugarFecha(int idPaciente, String nombreEstudio);

    public ArrayList<MFormularioGeneral> mostrarFormularioFechaTipo(int idPaciente, String nombreEstudio);

    public ArrayList<MFormularioGeneral> mostrarFormularioFecha(int idPaciente, String nombreEstudio);

}
