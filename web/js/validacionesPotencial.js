/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    
    //VALIDACIONES INDEX

function cambiaNombre(input){
     input.next().next('.custom-file-label').addClass("selected").html(input.val());
}

//1.- Identificación oficial
$('#fileIdentificacion').on('change', function () {
    
    cambiaNombre($(this));
    
    if (validDocument($('#fileIdentificacion'), document.querySelector('#fileIdentificacion').files) || $('#fileIdentificacion').get(0).files.length === 0) {
        $(this).next('.custom-file-label').addClass("selected").html($(this).val());
        $('#error-identificacionOficial').hide();
    } else {
        $(this).next('.custom-file-label').addClass("selected").html($(this).val());
        $('#error-identificacionOficial').show();
    }
});

//2.- CURP
$('#fileCURP').on('change', function () {
    
   cambiaNombre($(this));
    
    if (validDocument($('#fileCURP'), document.querySelector('#fileCURP').files) || $('#fileCURP').get(0).files.length === 0) {
        $('#error-CURP').hide();
    } else {
        $('#error-CURP').show();
    }
});

//3.- Comprobante de docimicilio
$('#fileComprobanteDomicilio').on('change', function () {
    
    cambiaNombre($(this));
    
    if (validDocument($('#fileComprobanteDomicilio'), document.querySelector('#fileComprobanteDomicilio').files) || $('#fileComprobanteDomicilio').get(0).files.length === 0) {
        $('#error-comprobanteDomicilio').hide();
    } else {
        $('#error-comprobanteDomicilio').show();
    }
});

//4.- Motivo de consulta
$('#motivoConsulta').on('change', function () {
    
    
    
    if (isValidSelect($('#motivoConsulta'))) {
        $('#error-motivoConsulta').hide();
    } else {
        $('#error-motivoConsulta').show();
    }
});

//5.- Estudios previos masto
$('#fileEstudioPrevioMasto').on('change', function () {
    
    cambiaNombre($(this));
    
    if (validDocument($('#fileEstudioPrevioMasto'), document.querySelector('#fileEstudioPrevioMasto').files) || $('#fileEstudioPrevioMasto').get(0).files.length === 0) {
        $('#error-previoMasto').hide();
    } else {
        $('#error-previoMasto').show();
    }
});

//6.- Estudios previos usg
$('#fileEstudioPrevioUsg').on('change', function () {
    
    cambiaNombre($(this));
    
    if (validDocument($('#fileEstudioPrevioUsg'), document.querySelector('#fileEstudioPrevioUsg').files) || $('#fileEstudioPrevioUsg').get(0).files.length === 0) {
        $('#error-previoUsg').hide();
    } else {
        $('#error-previoUsg').show();
    }
});

//7.- Biopsia previa
$('#fileEstudioBiopsia').on('change', function () {
    
    cambiaNombre($(this));
    
    if (validDocument($('#fileEstudioBiopsia'), document.querySelector('#fileEstudioBiopsia').files) || $('#fileEstudioBiopsia').get(0).files.length === 0) {
        $('#error-biopsia').hide();
    } else {
        $('#error-biopsia').show();
    }
});

//4.5.1 - Motivo Preconsulta
$('body').on('change', '#referenciaArchivo', function () {
    
    cambiaNombre($(this));
    
    if (validDocument($('#referenciaArchivo'), document.querySelector('#referenciaArchivo').files)) {
        $('#error-referencia').hide();
    } else {
        $('#error-referencia').show();
    }
});



//Métodos validaciones
function validDocument(input, archivos) {

        for (let index = 0; index < archivos.length; index++) {

            if (archivos[index]["type"] == "image/jpg" || archivos[index]["type"] == "image/png"
                || archivos[index]["type"] == "image/jpeg" || archivos[index]["type"] == "application/pdf"
                ) {

                input.css('border', '');
                return true;


            } else {
                input.css('border', '1px solid red');
            }

        }

        return false;
    }

function isValidSelect(input) {

        if (!input.val()) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;


    }

    
});