/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import {validation} from './validaciones.js';

//1.- Correo
$('#myEmail1').on('change', function () {
    if (validation.isValidEmail($('#myEmail1'))) {
        $('#error-correo').hide();
        console.log('saludos');
    } else {
        $('#error-correo').show();
        console.log('saludos2');
    }
});

//2.- Telefono
$('#telephoneNum').on('change', function () {
    if (validation.isValidPhoneNumber($('#telephoneNum'))) {
        $('#error-tel').hide();
    } else {
        $('#error-tel').show();
    }
});

//3.- Contraseña
$('#password').on('change', function () {
    if (validation.isValidBloodType($('#password'))) {
        $('#error-contraseña').hide();
    } else {
        $('#error-contraseña').show();
    }
});

//Verificar que las contraseñas son iguales
$('#password2').on('change', function () {

    areEqualPasswords($('#password'), $('#password2'));

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