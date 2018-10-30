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
                            if (response == "error") {
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

        $.ajax({

            url: "LoginController",
            method: "POST",
            data: {
                key: "verificar",
                usuario: usu.val(),
                password: pass.val()
            },
            success: function (response) {
                if (response != null) {
                    console.log("Cargó!!!");
                    var consultarDocumentosPreconsulta = new FormData;
                    consultarDocumentosPreconsulta.append("key", "consultarDocumentosPreconsulta");

                    console.log("Solicitar DOCUMENTOS de Preconsulta");
                    $.ajax({
                        url: "PotencialController",
                        method: "POST",
                        data: consultarDocumentosPreconsulta,
                        enctype: "multipart/form-data",
                        processData: false,
                        contentType: false,
                        success: function (response) {

                            if (response != null) {
                                var data = JSON.parse(response);
                                console.log(data);

                                $.post("SAPI", {
                                    file: "potencial/index.jsp"
                                },
                                        function (response, status, xhr) {
                                            console.log(response);
                                            if (status == "success") {
                                                if (response == "error") {
                                                    $("#msj-error").show();
                                                } else {
                                                    document.open("text/html", "replace");
                                                    document.write(response);
                                                    document.close();
                                                }
                                            }
                                        }
                                );


                            } else {
                                console.log("Algo pasó" + response);
                            }
                        },
                        error: function () {
                            console.log("error" + xhr.statusText);
                            alert("No enontre el controlador" + xhr.statusText);
                        }

                    });
                } else {
                    console.log("Algo pasó");
                }



            },
            error: function () {
                console.log("error" + xhr.statusText);
                alert("No enontre el controlador" + xhr.statusText);
            }
        });
        /*$.post("LoginController", {
         key: "verificar",
         usuario: usu.val(),
         password: pass.val()
         },
         function (response, status, xhr) {
         //console.log(response);
         if (status == "success") {
         console.log("Entró 1");
         if (response == "LoginError") {
         console.log("No entró 2");
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
         );*/
    });




    $('#recuperarContra').on('click', function () {
        console.log("Click en recuperarContra desde el Login");
        $.post("LoginController", {

            key: "recuperarContra"
        },
                function (response, status) {
                    console.log(response);

                    if (response != "") {
                        console.log("Intentando redireccionar");
                        document.open("text/html", "replace");
                        document.write(response);
                        document.close();
                    } else {
                        console.log("Error al cargar");

                    }
                }
        );

    });

});


