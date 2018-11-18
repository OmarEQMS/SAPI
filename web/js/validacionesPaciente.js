/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {



//VALIDACIONES CUENTA

    $('.error-correo').hide();
    $('#error-fecha').hide();
    $('#error-fechaFin').hide();
    $('#error-fechaInicio').hide();


    /*$('#error-contraseña').hide();
     $('#error-contraseña2').hide();*/

    //1.- Correo
    $('#correo').on('change', function () {

        if (isValidEmail($('#correo'))) {
            $('.error-correo').hide();
        } else {
            $('.error-correo').show();
        }
    });

    //2.- No expediente
    $('#noExpediente').on('change', function () {
        if (isValidNoExpediente($('#noExpediente'))) {
            $('#error-noExpediente').hide();
        } else {
            $('#error-noExpediente').show();
        }
    });

    //3.- Telefono
    $('#telefono').on('change', function () {
        if (isValidPhoneNumber($('#telefono'))) {
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
    /*$('#password').on('change', function(){
     if (isValidPassword($(this))) {
     $('#error-contraseña').hide();
     } else if ($(this).val() == '') {
     $('#error-contraseña').hide();
     } else {
     $('#error-contraseña').show();
     }
     });*/

    /*$('#password-confirm').on('change', function(){
     if (isValidPassword($(this))) {
     $('#error-contraseña').hide();
     } else if ($(this).val() == '') {
     $('#error-contraseña').hide();
     } else {
     $('#error-contraseña').show();
     }
     });*/

    //Verificar que las contraseñas son iguales
    /*$('#password-confirm').on('change', function(){
     
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
     }*/

    //VALIDACIONES TRATAMIENTO

    //1.- Fecha inicio
    $('#fechaInicioTratamiento').on('change', function () {
                
        
        if (isValidDate($('#fechaInicioTratamiento'), $('.fechaNacimientoPaciente'))) {
            $('#error-fechaInicio').hide();
        } else {
            $('#error-fechaInicio').show();
        }

    }); 
    
        //1.- Fecha fin
    $('#fechaFinTratamiento').on('change', function(){
        console.log("entro");
        if (isValidDate2($('#fechaFinTratamiento'), $('#fechaInicioTratamiento2'))) {
            $('#error-fechaFin').hide();
        }else{
            $('#error-fechaFin').show();
        }
    }); 
   

    function isValidNoExpediente(input) {

        var m = input.val();

        var expreg = /^([a-zA-Z]{3}|[\d]{3})([\d]{6})$/;


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
    ;

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
    ;

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
    ;

    function isValidDate(input, fechaNac) {

        //Obtener fecha
        let today = new Date();

        //Valor seleccionado del input
        let date_from = input.val();
        date_from = new Date(date_from);
        
        //Valor de la fecha de nacimiento
        let date_born = fechaNac.val();
        date_born = new Date(date_born);
        
        var year = today.getFullYear();
        var month = today.getMonth();
        var day = today.getDate();
        var futureDate = new Date(year, month + 2, day);
        
        console.log("Hoy: " + today);
        console.log("FechaReg: " + date_from);
        console.log("FechaFutura: " + futureDate);
        console.log("---------------------------------------------------")
        
        /*
        var todayYear = today.getFullYear();
        var inicioYear = date_from.getFullYear();*/
        var event = false;

        if (futureDate >= date_from && date_from >= date_born) {
            event = false;
            console.log("Valido");
        } else {
            event = true;
            console.log("Invalido");
        }

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
    ;


    function isValidDate2(input, fechaInicio) {
        
        //Valor seleccionado del input
        let date_from = input.val();
        date_from = new Date(date_from);
        
        //Valor de la fecha de inicio
        let date_start = fechaInicio.val();
        date_start = new Date(date_start);
        
        //Fecha de hoy
        let date_today = new Date();

        var event = false;
        
        console.log("Hoy: " + date_today);
        console.log("FechaFin: " + date_from);
        console.log("FechaInicio: " + date_start);

        if(date_start < date_from && date_from <= date_today){
            event = false;
            console.log(event);
            console.log("fechaValida");
        }
        else{
            event= true;
            console.log(event);
            console.log("fechaInValida");
        }

        if (!input.val() || event) {
            console.log("CAMBIAR COLOR");
            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;
        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    };

    function isValidExpediente(input) {

        var m = input.val();

        var expreg = /^[a-zA-Z\u00E0-\u00FCñÑ.0-9 ]{1,500}$/;


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
    ;

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
    ;

});
