$(document).ready(function () {

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
            $.post("LoginController", {
                key: "verificar",
                usuario: usu.val(),
                password: pass.val()
            },
                    function (response, status, xhr) {
                        //console.log(response);
                        if (status == "success") {
                            if (response == "LoginError") {
                                $("#msj-error").show();
                            } else {
                                $("#msj-cargando").show();
                                document.open("text/html", "replace");
                                document.write(response);
                                document.close();
                            }
                        }
                    }
            );
        }
    }

    /*
     $('#btn-login').on('click', function () {
     
     var usuario = $('#user');
     var password = $('#password');
     
     $.ajax({
     
     url: 'LoginController',
     cache: false,
     method: 'POST',
     data: {
     key: 'verificar',
     usuario: usuario.val(),
     password: password.val()
     },
     success: function (response) {                                
     
     console.log(response);
     
     if (response === 'success') {
     
     $('#msj-error').hide();
     console.log("succes 2");
     } else {
     $('#msj-error').show();
     console.log("response 3");
     }
     
     
     }
     
     
     });
     
     });
     */
    /*
     $('#btn-login').on('click', function () {
     var usu = $("#user");
     var pass = $("#password");
     $.get("LoginController", {
     key: "verificar",
     usuario: usu.val(),
     password: pass.val()
     },
     function (response, status, xhr) {
     //console.log(response);
     if (status == "success") {
     if (response == "LoginError") {
     //console.log("No se pudo inicar sesion");
     $("#msj-error").show();
     } else {
     $("#msj-cargando").show();
     document.open("text/html", "replace");
     document.write(response);
     document.close();
     }
     }
     }
     );
     });*/

    $('#registrate').click(function () {
        $.postGo("ZonaController", {
            key: "getRegistro"
        });
    });

    $('#btn-login').on('click', function () {
        var usu = $("#user");
        var pass = $("#password");
        $.post("LoginController", {
            key: "verificar",
            usuario: usu.val(),
            password: pass.val(),
            beforeSend: function () {
                $('#loading-screen').fadeIn();
            }
        },
                function (response, status, xhr) {
                    //console.log(response);
                    if (status == "success") {
                        if (response == "LoginError") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
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

});


