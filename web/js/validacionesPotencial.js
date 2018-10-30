/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    
    //VALIDACIONES INDEX

//1.- Identificación oficial
$('#fileIdentificacion').on('change', function () {
    if (validDocument($('#fileIdentificacion'), document.querySelector('#fileIdentificacion').files)) {
        $('#error-identificacionOficial').hide();
    } else {
        $('#error-identificacionOficial').show();
    }
});

//2.- CURP
$('#fileCURP').on('change', function () {
    if (validDocument($('#fileCURP'), document.querySelector('#fileCURP').files)) {
        $('#error-CURP').hide();
        console.log('si se puede ' + document.querySelector('#fileCURP').files);
    } else {
        $('#error-CURP').show();
        console.log('no se puede ' + document.querySelector('#fileCURP').files);
    }
});

//3.- Comprobante de docimicilio
$('#fileComprobanteDomicilio').on('change', function () {
    if (validDocument($('#fileComprobanteDomicilio'), document.querySelector('#fileComprobanteDomicilio').files)) {
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
    if (validDocument($('#fileEstudioPrevioMasto'), document.querySelector('#fileEstudioPrevioMasto').files)) {
        $('#error-previoMasto').hide();
    } else {
        $('#error-previoMasto').show();
    }
});

//6.- Estudios previos usg
$('#fileEstudioPrevioUsg').on('change', function () {
    if (validDocument($('#fileEstudioPrevioUsg'), document.querySelector('#fileEstudioPrevioUsg').files)) {
        $('#error-previoUsg').hide();
    } else {
        $('#error-previoUsg').show();
    }
});

//7.- Biopsia previa
$('#fileEstudioBiopsia').on('change', function () {
    if (validDocument($('#fileEstudioBiopsia'), document.querySelector('#fileEstudioBiopsia').files)) {
        $('#error-biopsia').hide();
    } else {
        $('#error-biopsia').show();
    }
});

//Métodos validaciones
function validDocument(input, archivos) {

        for (let index = 0; index < archivos.length; index++) {

            if (archivos[index]["type"] == "image/jpg" || archivos[index]["type"] == "image/png"
                || archivos[index]["type"] == "image/jpeg" || archivos[index]["type"] == "application/pdf"
                || archivos[index]["type"] == "application/vnd.openxmlformats-officedocument.wordprocessingml.document" ||
                archivos[index]["type"] == "application/msword") {

                console.log('si se puede' + archivos[index]["type"]);
                input.css('border', '');
                return true;


            } else {
                console.log('no se puede' + archivos[index]["type"]);
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