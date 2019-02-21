
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Author Angel Gtz

$(document).ready(function () {

    $('#errorCambiar').hide();
    $('#errorCorreoNoExistente').hide();
    $('#errorCorreo').hide();
    
    

    $("#RestablcerContra").on('click', function () {
        if (isValidPassword($('#cambio1')) && isValidPassword($('#cambio2')) && areEqualPasswords($('#cambio1'), $('#cambio2'))) {
            $('#errorCambiar').hide();

            $.ajax({
                url: "RecuperarController",
                data: {
                    key: "cambiarContrasena",
                    password: $("#cambio1").val(),
                    password2: $("#cambio2").val()
                },
                method: "POST",
                success: function (response) {
                    if (response == "error") {

                    } else {
                        document.open("text/html", "replace");
                        document.write(response);
                        document.close();
                    }
                }
            });
        } else {
            $('#errorCambiar').show();
        }

    });

    $('#recuperarEnviarCorreo').on('click', function () {
        var mail = $('#email').val();

        if (repiteCorreo) {

            $.ajax({
                url: "RecuperarController",
                data: {
                    key: "recuperarEnviarCorreo",
                    email: mail
                },
                method: "POST",
                success: function (response) {
                    if (response == "error") {

                    } else {
                        swal({
                            title: "Correo enviado",
                            text: "Revisa el correo con el que creaste tu cuenta para poder cambiar tu contraseña",
                            icon: "success",
                            closeOnEsc: false,
                            closeOnClickOutside: false,
                            buttons: true,
                            buttons: [, 'Aceptar']
                        }).then(function () {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        })
                    }
                },
                beforeSend: function () {
                    $('.cargandoEnviandoCorreo').fadeIn();
                },
                complete: function () {
                    $('.cargandoEnviandoCorreo').fadeOut();
                }
            });
        }
    });

    $('#ir-a-loginR').on('click', function () {
        $.post("LoginController", {
            key: "ir-a-login"
        },
                function (response, status) {

                    if (response == "error") {
                    } else {
                        document.open("text/html", "replace");
                        document.write(response);
                        document.close();
                    }
                }
        );

    });

    var repiteCorreo = false;
    //CORREO EN RECUPERAR CONTRASEÑA
    $('#email').on('change', function () {

        var validEmail;

        if (isValidEmail($(this))) {
            $('#errorCorreo').hide();
            validEmail = true;
        } else if ($(this).val() == '') {
            $('#errorCorreo').hide();
            validEmail = true;
        } else {
            $('#errorCorreo').show();
            validEmail = false;
        }

        if (validEmail) {
            $.ajax({

                url: 'RegistraUsuarioController',
                cache: false,
                method: 'POST',
                data: {

                    key: "repiteCorreo",
                    correo: $('#email').val()


                },
                success: function (response) {

                    if (response === 'CorreoAlreadyExists') {
                        $('#errorCorreoNoExistente').hide();
                        repiteCorreo = true;
                    } else {
                        $('#email').css('color', 'orange');
                        $('#errorCorreoNoExistente').show();
                        repiteCorreo = false;
                    }

                }

            });
        }

    });



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

});