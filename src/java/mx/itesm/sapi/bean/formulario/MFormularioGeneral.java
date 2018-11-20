/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.formulario;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Angel GTZ
 */
/**
 * public class MFormularioGeneral Clase para mostrar los datos de formulario que ya fueron llenados
 */
/**
 * Cada dato es una parte del Formulario dividida por el input
 */
public class MFormularioGeneral  implements Serializable{
    private String prz;
    private Date fechaNavegacion;
    private Date fechaConsulta;
    private boolean tipoPaciente;
    private String medicoAdscrito;
    private String medicoRadiologo;
    private String medicoResidente;
    private boolean noAdscrito;
    private boolean noRadiologo;
    private String escolaridad;
    private String alergias;
    private boolean estadoHormonal;
    private String Seguro;
    private String noSeguro;
    private boolean mastografiaPreINCAN;
    private Date cirugiaFecha;
    private String cirugiaTipo;
    private String cirugiaComentario;
    
    
    
    
}

/*
    
    DECLARE v_quimioterapiaFecha TIMESTAMP DEFAULT NULL;
    DECLARE v_quimioterapiaCiclo INT;
    DECLARE v_quimioterapiaComentario MEDIUMTEXT DEFAULT NULL;
    DECLARE v_radioterapiaFecha TIMESTAMP DEFAULT NULL;
    DECLARE v_radioterapiaCiclo INT;
    DECLARE v_radioterapiaComentario MEDIUMTEXT DEFAULT NULL;
    
    DECLARE v_mastografiaBiradsNombre INT; 
    DECLARE v_ultrasonidoBiradsNombre INT;
    DECLARE v_mastografiaBiradsFecha TIMESTAMP DEFAULT NULL;
	DECLARE v_ultrasonidoBiradsFecha TIMESTAMP DEFAULT NULL;
    DECLARE v_resultadoPatologia VARCHAR(255) DEFAULT NULL;
    DECLARE v_otroResultado VARCHAR(255) DEFAULT NULL;
    DECLARE v_serieParafina VARCHAR(255) DEFAULT NULL;
    DECLARE v_cantidadParafina INT;
    DECLARE v_serieLaminillas VARCHAR(255) DEFAULT NULL;
    DECLARE v_cantidadLaminillas INT;
    DECLARE v_T  VARCHAR(255) DEFAULT NULL;
    DECLARE v_N  VARCHAR(255) DEFAULT NULL;
    DECLARE v_M  VARCHAR(255) DEFAULT NULL;
    DECLARE v_fechaFin TIMESTAMP DEFAULT NULL;
    DECLARE v_decisionCosulta VARCHAR(255) DEFAULT NULL;
    DECLARE v_socioeconomico VARCHAR(255) DEFAULT NULL;
    DECLARE v_comentarioLLamada MEDIUMTEXT DEFAULT NULL;
    DECLARE v_fechaLlamada TIMESTAMP DEFAULT NULL;
    DECLARE v_comentarioIncidencia MEDIUMTEXT DEFAULT NULL;
    DECLARE v_comentarioMedico MEDIUMTEXT DEFAULT NULL;
    DECLARE v_etapaClinica  VARCHAR(255) DEFAULT NULL;
    DECLARE v_masto VARCHAR(255) DEFAULT NULL;
    DECLARE v_ultra VARCHAR(255) DEFAULT NULL;
    DECLARE v_rp VARCHAR(255) DEFAULT NULL;
    DECLARE v_re VARCHAR(255) DEFAULT NULL;
    DECLARE v_her2 VARCHAR(255) DEFAULT NULL;
    DECLARE v_fish VARCHAR(255) DEFAULT NULL;
    DECLARE v_ki67 VARCHAR(255) DEFAULT NULL;
    DECLARE v_gradoH VARCHAR(255) DEFAULT NULL;
    DECLARE v_resultadoPatologiaPost VARCHAR(255) DEFAULT NULL;
*/