/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import {validation} from './validaciones.js';


$(document).ready(function () {
//VALIDACIONES CUENTA

    //1.- Correo
    $('#myEmail').on('change', function(){
        if(validation.isValidEmail($('#myEmail'))){
            $('#error-correo').hide();
        }else{
            $('#error-correo').show();
        }
    }); 

    //2.- Telefono
    $('#telephoneNum').on('change', function(){
        if(validation.isValidPhoneNumber($('#telephoneNum'))){
            $('#error-tel').hide();
        }else{
            $('#error-tel').show();
        }
    }); 

     //3.- Contraseña
     $('#password').on('change', function(){
        if(validation.isValidBloodType($('#password'))){
            $('#error-contraseña').hide();
        }else{
            $('#error-contraseña').show();
        }
    });

    //Verificar que las contraseñas son iguales
    $('#password-confirm').on('change', function(){

        areEqualPasswords($('#password'), $('#password-confirm'));

    });

    function areEqualPasswords(pass1, pass2) {

        if (pass1.val() != pass2.val()) {

            pass2.css('border', '1px solid red');
            pass1.css('border', '1px solid red');
            $('#error-notEqualPasswords').show();

            return false;

        } else {

            pass2.css('border', '');
            pass1.css('border', '');
            $('#error-notEqualPasswords').hide();

        }

        return true;
    }

     //VALIDACIONES INDEX

    //1.- Identificación oficial
    $('#fileIdentificacion').on('change', function(){
        if(validation.validDocument($('#fileIdentificacion'), document.querySelector('#fileIdentificacion').files)){
            $('#error-identificacionOficial').hide();
        }else{
            $('#error-identificacionOficial').show();
        }
    }); 

    //2.- CURP
    $('#fileCURP').on('change', function(){
        if(validation.validDocument($('#fileCURP'), document.querySelector('#fileCURP').files)){
            $('#error-CURP').hide();
            console.log('si se puede ' + document.querySelector('#fileCURP').files);
        }else{
            $('#error-CURP').show();
            console.log('no se puede ' + document.querySelector('#fileCURP').files);
        }
    }); 

    //3.- Comprobante de docimicilio
    $('#fileComprobanteDomicilio').on('change', function(){
        if(validation.validDocument($('#fileComprobanteDomicilio'),document.querySelector('#fileComprobanteDomicilio').files)){
            $('#error-comprobanteDomicilio').hide();
        }else{
            $('#error-comprobanteDomicilio').show();
        }
    }); 

    //4.- Motivo de consulta
    $('#motivoConsulta').on('change', function(){
        if(validation.isValidSelect($('#motivoConsulta'))){
            $('#error-motivoConsulta').hide();
        }else{
            $('#error-motivoConsulta').show();
        }
    }); 

    //5.- Estudios previos masto
    $('#fileEstudioPrevioMasto').on('change', function(){
        if(validation.validDocument($('#fileEstudioPrevioMasto'),document.querySelector('#fileEstudioPrevioMasto').files)){
            $('#error-previoMasto').hide();
        }else{
            $('#error-previoMasto').show();
        }
    }); 

    //6.- Estudios previos usg
    $('#fileEstudioPrevioUsg').on('change', function(){
        if(validation.validDocument($('#fileEstudioPrevioUsg'),document.querySelector('#fileEstudioPrevioUsg').files)){
            $('#error-previoUsg').hide();
        }else{
            $('#error-previoUsg').show();
        }
    }); 

    //7.- Biopsia previa
    $('#fileEstudioBiopsia').on('change', function(){
        if(validation.validDocument($('#fileEstudioBiopsia'),document.querySelector('#fileEstudioBiopsia').files)){
            $('#error-biopsia').hide();
        }else{
            $('#error-biopsia').show();
        }
    });


