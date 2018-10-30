/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//1.- Correo
$('#myEmail').on('change', function () {
    if (isValidEmail($('#myEmail'))) {
        $('#error-correo').hide();
    } else {
        $('#error-correo').show();
    }
});

//2.- No expediente
$('#numExpediente').on('change', function () {
    if (isValidNoExpediente($('#numExpediente'))) {
        $('#error-noExpediente').hide();
    } else {
        $('#error-noExpediente').show();
    }
});

//3.- Telefono
$('#telephoneNum').on('change', function () {
    if (isValidPhoneNumber($('#telephoneNum'))) {
        $('#error-tel').hide();
    } else {
        $('#error-tel').show();
    }
});

//4.- Tipo Sangre
$('#tipo-sangre').on('change', function () {
    if (isValidBloodType($('#tipo-sangre'))) {
        $('#error-tipoSangre').hide();
    } else {
        $('#error-tipoSangre').show();
    }
});

//5.- Contraseña
$('#password').on('change', function () {
    if (isValidBloodType($('#password'))) {
        $('#error-contraseña').hide();
    } else {
        $('#error-contraseña').show();
    }
});

//Verificar que las contraseñas son iguales
$('#password-confirm').on('change', function () {

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
$('#RegistrarCita_fecha').on('change', function () {
    if (isValidDate($('#RegistrarCita_fecha'))) {
        $('#error-fecha').hide();
    } else {
        $('#error-fecha').show();
    }
});

//2.- Tipo cita
$('#RegistrarCita_tipo').on('change', function () {
    if (isValidSelect($('#RegistrarCita_tipo'))) {
        $('#error-tipoCita').hide();
    } else {
        $('#error-tipoCita').show();
    }
});

//3.- Médico
$('#RegistrarCita_medico').on('change', function () {
    if (isValidSelect($('#RegistrarCita_medico'))) {
        $('#error-medico').hide();
    } else {
        $('#error-medico').show();
    }
});

function isValidEmail(input) {

    var m = input.val();

    ////Expresion regular por el estandard: RFC 5322
    var expreg = /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;

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

function isValidNoExpediente(input) {

    var m = input.val();

    var expreg = /^[a-zA-Z0-9]{9,9}$/;


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

function isValidDate(input) {

    //Obtener fecha
    let today = new Date();

    //Valor seleccionado del input
    let date_from = input.val();
    date_from = new Date(date_from);

    let event = false;

    today < date_from ? event = true : event = false;


    if (!input.val() || event) {

        input.css('border', '1px solid red');
        input.css('color', 'red');
        return false;

    } else {
        input.css('border', '');
        input.css('color', '');
    }

    return true;


}

function isValidPassword(input) {

        var m = input.val();

        //var expreg = /^[a-zA-Z0-9]{8,14}$/;
        var expreg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{8,14}$/;
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