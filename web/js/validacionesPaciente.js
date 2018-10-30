/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import {validation} from './validaciones.js';


$(document).ready(function () {

//VALIDACIONES CUENTA

     $('.error-correo').hide();
     $('#error-fecha').hide();
     $('#error-fechaFin').hide();
     $('#error-fechaInicio').hide();
        
    //1.- Correo
    $('#correo').on('change', function(){
        
        if(validation.isValidEmail($('#correo'))){
            $('.error-correo').hide();
        }else{
            $('.error-correo').show();
        }
    }); 

    //2.- No expediente
    $('#noExpediente').on('change', function(){
        if(validation.isValidNoExpediente($('#noExpediente'))){
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

    //1.- Fecha inicio
    $('#fechaInicioTratamiento').on('change', function(){
        
        
        if(validation.isValidDate($('#fechaInicioTratamiento'))){
            $('#error-fechaInicio').hide();
        }else{
            $('#error-fechaInicio').show();
        }
    }); 
    
        //1.- Fecha fin
    $('#fechaFinTratamiento').on('change', function(){
        alert($("#fechaInicio-"+$("#botonHidden").val()).val());
        if(validation.isValidDate2($('#fechaFinTratamiento'), $("#fechaInicio-"+$("#botonHidden").val()).val())){
            $('#error-fechaFin').hide();
        }else{
            $('#error-fechaFin').show();
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

});
