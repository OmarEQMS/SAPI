/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Author Angel Gtz

$(document).ready(function () {
    $('#errorCambiar').hide();

    $("#RestablcerContra").on('click', function () {
        if (isValidPassword($('#cambio1')) && isValidPassword($('#cambio2')) && areEqualPasswords($('#cambio1'), $('#cambio2'))) {
            console.log("Presionó cmabiar contrasena");
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
                        console.log("Intentando redireccionar");
                        document.open("text/html", "replace");
                        document.write(response);
                        document.close();
                    }
                },
                error: function (xhr) {

                }
            });
        } else {
            $('#errorCambiar').show();
        }

    });

    $('#recuperarEnviarCorreo').on('click', function () {
        console.log("Click en Recuperar después de ingresar el correo");

        swal({
            title: "Correo enviado",
            text: "Revisa el correo con el que creaste tu cuenta para poder cambiar tu contraseña",
            icon: "success",
            buttons: true,
            buttons: [, 'Aceptar']
        }).then(function () {
            var mail = $('#email');
            $.post("RecuperarController", {
                key: "recuperarEnviarCorreo",
                email: mail.val()

            },
                    function (response, status) {
                        console.log("---------------------------------");

                        if (response == "") {
                            console.log("Error al cargar");

                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
            );
        })
    });

    $('#ir-a-loginR').on('click', function () {
        console.log("Entro a ajaxRecuperar.jps btn ir-a-LoginR");
        $.get("LoginController", {
            key: "ir-a-login"
        },
                function (response, status) {
                    console.log(response);

                    if (response == "error") {
                        console.log("Error al cargar");
                    } else {
                        console.log("Intentando redireccionar");
                        document.open("text/html", "replace");
                        document.write(response);
                        document.close();
                    }
                }
        );

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

});