$(document).ready(function () {
    
    mostrarContrasena($('#loginContrasena'),'password');

    $("#msj-error").hide();
    $("#msj-cargando").hide();

    $(document).on('click', function () {
        $("#msj-error").hide();
    });

    //Al dar enter te puedes loguear
    var elem = document.getElementById("password");

    elem.onkeyup = function (e) {
        if (e.keyCode == 13) {
            var usu = $("#user");
            var pass = $("#password");

            $.ajax({
                url: 'LoginController',
                method: "POST",
                cache: false,
                data: {
                    key: "verificar",
                    usuario: usu.val(),
                    password: pass.val()
                },
                beforeSend: function () {
                    $('#loading-screen').fadeIn();
                },
                complete: function () {
                    $('#loading-screen').fadeOut();
                },
                success: function (response) {
                    if (response == "LoginError") {
                        $("#msj-error").show();
                    } else {
                        document.open("text/html", "replace");
                        document.write(response);
                        document.close();
                    }
                }
            });
        }
    }

    $('#registrate').click(function () {
        $.postGo("ZonaController", {
            key: "getRegistro"
        });
    });

    $('#btn-login').on('click', function () {
        var usu = $("#user");
        var pass = $("#password");

        $.ajax({
            url: 'LoginController',
            method: "POST",
            cache: false,
            data: {
                key: "verificar",
                usuario: usu.val(),
                password: pass.val()
            },
            beforeSend: function () {
                $('#loading-screen').fadeIn();
            },
            complete: function () {
                $('#loading-screen').fadeOut();
            },
            success: function (response) {
                if (response == "LoginError") {
                    $("#msj-error").show();
                } else {
                    document.open("text/html", "replace");
                    document.write(response);
                    document.close();
                }
            }
        });
    });


    $('#recuperarContra').on('click', function () {
        console.log("Click en recuperarContra desde el Login");
        $.post("LoginController", {

            key: "recuperarContra"
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
    
    function mostrarContrasena(myButton, myField) {
        myButton.on('mousedown', function () {
            var x = document.getElementById(myField);
            x.type = "text";
        });
        myButton.on('mouseup', function () {
            var x = document.getElementById(myField);
            x.type = "password";
        });
    }

});


