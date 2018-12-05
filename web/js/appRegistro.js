$(document).ready(function () {

    var pantalla1 = $('#pantalla1');
    var pantalla2 = $('#pantalla2');
    var btnRegresar = $('#btn-regresar');
    var btnContinuar = $('#btn-continuar');
    var btnRegistro = $('#btn-registro');
    
    $('#errorUsuarioRepetido').hide();
    $('#errorNombreUsuario').hide();
    $('#errorApellidoMaterno').hide();
    $('#errorPass1').hide();
    $('#errorCorreoRepetido').hide();
    $('#errorCorreo').hide();
    $("#error-datosRepetidos").hide();
    $("#error-campos").hide();
    

    oculta(btnRegistro);
    oculta(pantalla2);
    oculta(btnRegresar);

    //NOMBRE DE USUARIO EN EL REGISTRO
    $('#usuario').on('change', function () {

        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteUsuario",
                usuario: $('#usuario').val()


            },
            success: function (response) {
                if (response === 'UsuarioAlreadyExists') {
                    $('#usuario').css('color', 'orange');
                    $('#errorUsuarioRepetido').show();
                    repiteUsuario = true;
                } else {
                    $('#errorUsuarioRepetido').hide();
                    repiteUsuario = false;
                }

            }

        });

        if (isValidUserName($(this))) {
            $('#errorNombreUsuario').hide();
        } else if ($(this).val() == '') {
            $('#errorNombreUsuario').hide();
        } else {
            $('#errorNombreUsuario').show();
        }

    });

    //SEGUNDO APELLIDO EN EL REGISTRO
    var isValidSegundoApellidoRegistro = true;
    $('#apellido2').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoMaterno').hide();
            isValidSegundoApellidoRegistro = true;
        } else if ($(this).val() == '') {
            $('#errorApellidoMaterno').hide();
            $(this).css('border', '');
            $(this).css('color', '');
            isValidSegundoApellidoRegistro = true;
        } else {
            $('#errorApellidoMaterno').show();
            isValidSegundoApellidoRegistro = false;
        }

    });

    //CONTRASEÑAS IGUALES EN EL REGISTRO
    $('#pass2').on('change', function () {

        var pass1 = $('#pass1');
        var pass2 = $('#pass2');

        areEqualPasswords(pass1, pass2);

    });

    //CONTRASEÑA1 EN EL REGISTRO
    $('#pass1').on('change', function () {

        if (isValidPassword($(this))) {
            $('#errorPass1').hide();
        } else if ($(this).val() == '') {
            $('#errorPass1').hide();
        } else {
            $('#errorPass1').show();
        }

    });

    //CORREO EN EL REGISTRO
    $('#correo').on('change', function () {
        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteCorreo",
                correo: $('#correo').val()


            },
            success: function (response) {

                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#correo').css('color', 'orange');
                    $('#errorCorreoRepetido').show();
                    repiteCorreo = true;
                } else {
                    $('#errorCorreoRepetido').hide();
                    repiteCorreo = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#errorCorreo').hide();
        } else if ($(this).val() == '') {
            $('#errorCorreo').hide();
        } else {
            $('#errorCorreo').show();
        }

    });

    var repiteUsuario;
    var repiteCorreo;

    $('#btn-continuar').on('click', function () {
        if (!repiteUsuario && !repiteCorreo) {
            $("#error-datosRepetidos").hide();
            //Verificar que todos los campos que han marcado
            if (isValidName($('#nombre')) && isValidLastName($('#apellido1')) && isValidSegundoApellidoRegistro
                    && isValidUserName($('#usuario')) && isValidEmail($('#correo')) && isValidPassword($('#pass1'))
                    && areEqualPasswords($('#pass1'), $('#pass2'))) {
                $("#error-campos").hide();

                oculta(btnContinuar);
                oculta(pantalla1);
                muestra(pantalla2);
                muestra(btnRegistro);
                muestra(btnRegresar);
                
            } else {
                console.log("Entro al segundo else");
                $("#error-campos").show(); //No se llenaron los campos obligatorios
            }
        } else {
            console.log("Entro al segundo else");
            $("#error-datosRepetidos").show(); //ya existe un campo
        }

    });

    $('#btn-regresar').on('click', function () {

        oculta(pantalla2);
        oculta(btnRegistro);
        oculta(pantalla2);
        oculta(btnRegresar);
        muestra(pantalla1);
        muestra(btnContinuar);

    });

    $('#btn-registro').on('click', function () {

        swal(
                "¿Te han tratado por cáncer de mama previamente?", {
                    buttons: {
                        primeraVez: "No",
                        segundaOpinion: "Sí",
                    }
                })
                .then((value) => {
                    switch (value) {
                        case "primeraVez":

                            break;
                        case "segundaOpinion":

                            break;
                    }
                    $('#modalTerminos').modal('toggle');
                });

    });

    function oculta(campo) {
        campo.hide();
    }

    function muestra(campo) {
        campo.show();
    }

    function isValidUserName(input) {

        var m = input.val();

        var expreg = /^[a-zA-Z0-9]{4,16}$/;

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

    function isValidName(input) {

        var m = input.val();

        var expreg = /^[-a-zA-Z\u00E0-\u00FCñÑ. ]{2,255}$/;

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

    function isValidLastName(input) {

        var m = input.val();

        var expreg = /^[-a-zA-Z\u00E0-\u00FCñÑ. ]{2,127}$/;

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

    function areEqualPasswords(pass1, pass2) {

        if (pass1.val() != pass2.val()) {

            pass2.css('border', '1px solid red');
            pass1.css('border', '1px solid red');
            $('#noEqualPasswordsError').show();

            return false;

        } else {

            pass2.css('border', '');
            pass1.css('border', '');
            $('#noEqualPasswordsError').hide();

        }

        return true;
    }

});