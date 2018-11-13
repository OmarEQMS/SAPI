/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//1.- Correo
$('#myEmail').on('change', function () {
    if (isValidEmail($('#myEmail'))) {
        $('#error-correo').hide();
        console.log('saludos');
    } else {
        $('#error-correo').show();
        console.log('saludos2');
    }
});

//2.- Telefono
$('#telephoneNum').on('change', function () {
    if (isValidPhoneNumber($('#telephoneNum'))) {
        $('#error-tel').hide();
    } else {
        $('#error-tel').show();
    }
});

//3.- Contraseña
/*$('#password').on('change', function () {
    if (isValidPassword($(this))) {
            $('#error-contraseña').hide();
        } else if ($(this).val() == '') {
            $('#error-contraseña').hide();
        } else {
            $('#error-contraseña').show();
        }
});*/

//Verificar que las contraseñas son iguales
/*$('#password2').on('change', function () {

    areEqualPasswords($('#password'), $('#password2'));

});*/


//Métodos de las validaciones
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

function isValidEmail(input) {

    var m = input.val();

    ////Expresion regular por el estandard: RFC 5322
    var expreg = /^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;

    if (!expreg.test(m)) {

        input.css('border', '1px solid red');
        input.css('color', 'red');
        return false;

    } else {
        input.css('border', '');
        input.css('color', '');
    }

    return true;

}

function isValidPhoneNumber(input) {

    var m = input.val();

    var expreg = /^[0-9]{10,10}$/;

    if (!expreg.test(m)) {

        input.css('border', '1px solid red');
        input.css('color', 'red');
        return false;

    } else {
        input.css('border', '');
        input.css('color', '');
    }

    return true;
}

function isValidBloodType(input) {

    var m = input.val();

    var expreg = /^(A|B|AB|O)[-+]$/;

    if (!expreg.test(m)) {

        input.css('border', '1px solid red');
        input.css('color', 'red');
        return false;

    } else {
        input.css('border', '');
        input.css('color', '');
    }

    return true;

}
           