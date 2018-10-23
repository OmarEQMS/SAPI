/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import {validation} from './validaciones.js';

//VALIDACIONES CUENTA

    //1.- Correo
    $('#myEmail').on('change', function(){
        if(validation.isValidEmail($('#myEmail'))){
            $('#error-correo').hide();
        }else{
            $('#error-correo').show();
        }
    }); 

    //2.- No expediente
    $('#numExpediente').on('change', function(){
        if(validation.isValidNoExpediente($('#numExpediente'))){
            $('#error-noExpediente').hide();
        }else{
            $('#error-noExpediente').show();
        }
    }); 

    //3.- Telefono
    $('#telephoneNum').on('change', function(){
        if(validation.isValidPhoneNumber($('#telephoneNum'))){
            $('#error-tel').hide();
        }else{
            $('#error-tel').show();
        }
    }); 

    //4.- Tipo Sangre
    $('#tipo-sangre').on('change', function(){
        if(validation.isValidBloodType($('#tipo-sangre'))){
            $('#error-tipoSangre').hide();
        }else{
            $('#error-tipoSangre').show();
        }
    });

    //5.- Contraseña
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

    //1.- Fecha
    $('#RegistrarCita_fecha').on('change', function(){
        if(validation.isValidDate($('#RegistrarCita_fecha'))){
            $('#error-fecha').hide();
        }else{
            $('#error-fecha').show();
        }
    }); 

    //2.- Tipo cita
    $('#RegistrarCita_tipo').on('change', function(){
        if(validation.isValidSelect($('#RegistrarCita_tipo'))){
            $('#error-tipoCita').hide();
        }else{
            $('#error-tipoCita').show();
        }
    });

     //3.- Médico
     $('#RegistrarCita_medico').on('change', function(){
        if(validation.isValidSelect($('#RegistrarCita_medico'))){
            $('#error-medico').hide();
        }else{
            $('#error-medico').show();
        }
    });


