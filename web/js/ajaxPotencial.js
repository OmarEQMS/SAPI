//ajaxPotencial.js

$(document).ready(function () {

    console.log("Se Actualizó!");
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
                    console.log("ok" + response);
                    
                } else {
                    console.log("Algo pasó" + response);
                }
            },
            error: function () {
                console.log("error" + xhr.statusText);
                alert("No enontre el controlador" + xhr.statusText);
            }

        });
    var consultarEstadoPreconsulta = new FormData;
    consultarEstadoPreconsulta.append("key", "consultarEstadoPreconsulta");
    
    console.log("Solicitar ESTADO de Preconsulta");
    $.ajax({
            url: "PotencialController",
            method: "POST",
            data: consultarEstadoPreconsulta,
            enctype: "multipart/form-data",
            processData: false,
            contentType: false,
            success: function (response) {
                if (response != null) {
                    console.log("ok" + response);
                    
                } else {
                    console.log("Algo pasó" + response);
                }
            },
            error: function () {
                console.log("error" + xhr.statusText);
                alert("No enontre el controlador" + xhr.statusText);
            }

        });
    $('#eliminarCuentaPotencial').on('click', () => {

        swal({
            title: "¿Estás segura(o)?",
            text: "Los datos se eliminarán y no podrás recuperarlos ni poder acceder a tu cuenta.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],

        })
                .then((eliminar) => {
                    if (eliminar) {
                        $.ajax({
                            url: "PotencialController",
                            data: {
                                key: "cambiarContrasena",
                                idCuenta: $("#sesionPaciente").val(),
                                password: $("#password").val(),
                                password2: $("#password2").val()
                            },
                            method: "POST"
                        });


                    } else {

                    }
                });



    });

    $("#btn-cancelarPreConsulta1").on('click', () => {

        //Modal borrar sintoma
        swal({
            title: "¿Estás segura(o) que deseas cancelar la cita?",
            text: "Tendrás que reiniciar tu solicitud a preconsulta",
            icon: "warning",
            buttons: true,
            buttons: ['Regresar', 'Cancelar cita'],
            dangerMode: true,
        })

                .then((cancelar) => {
                    if (cancelar) {

                        $('#modalMotivoCancelacion').modal('toggle');

                        $('#btn-cancelarDefinitivo').on('click', function () {

                            $.ajax({
                                url: "PotencialController",
                                data: {
                                    key: 'cancelarCita',
                                    idPaciente: $('#idPaciente').val()
                                },
                                method: "POST",
                                success: function (response) {
                                    if (response == "success") {

                                    }else{
                                        
                                    }
                                },
                                error: function (xhr) {

                                }
                            });

                        });


                    } else {

                    }
                });


    });

    $("#btn-cancelarPreConsulta2").on('click', () => {

        //Modal borrar sintoma
        swal({
            title: "¿Estás seguro que deseas cancelar la cita?",
            text: "Tendrás que reiniciar tu solicitud a preconsulta",
            icon: "warning",
            buttons: true,
            buttons: ['Regresar', 'Cancelar cita'],
            dangerMode: true,
        })

                .then((cancelar) => {
                    if (cancelar) {

                        $('#modalMotivoCancelacion').modal('toggle');
                        $('#modalVerCitaPreConsulta').modal('toggle');
                        
                        
                        //pegar ajax de cancelacion

                    } else {

                    }
                });


    });

    $("#btn-enviarSolicitud").on('click', function () {

        //Modal borrar sintoma
        swal({
            title: "¡Buen Trabajo! se ha enviado tu solicitud",
            text: "En un lapso no mayor a 36 horas recibirás una respuesta",
            icon: "success",
            showCancelButton: false,
            showConfirmButton: true,
            buttons: [, 'Aceptar'],
            dangerMode: true
        });

        var form = $("form")[0];
        var data = new FormData(form);

        var masculino = $('#masculino').is(':checked') ? 1 : 0;
        var femenino = $('#femenino').is(':checked') ? 1 : 0;
        var sillaDeRuedas = $('#sillaRuedas').is(':checked') ? 1 : 0;
        var camilla = $('#camilla').is(':checked') ? 1 : 0;
        var baston = $('#baston').is(':checked') ? 1 : 0;
        var oxigeno = $('#oxigeno').is(':checked') ? 1 : 0;
        var motivoConsulta = $('#motivoConsulta').val();
        var biopsia = $('#biopsiaInput').is(':checked') ? 1 : 0;

        data.append("key", "solicitarPreconsulta");
        data.append("femenino", femenino);
        data.append("masculino", masculino);
        data.append("sillaDeRuedas", sillaDeRuedas);
        data.append("camilla", camilla);
        data.append("baston", baston);
        data.append("oxigeno", oxigeno);
        data.append("motivoConsulta", motivoConsulta);
        data.append("biopsia", biopsia);



        console.log(data);

        // Imprimmir en consola los valores obtenidos del form para pruebas
        data.forEach((value, key) => {
            console.log(key + " " + value);
        });


        //console.log("after getting the form" + form.length);


        /*
         ¿Obtener los valores de entrada?   
         var masculino, femenino, camilla, sillaDeRuedas, baston, oxigeno, biopsia, motivoConsulta,
         identificacionOficial, comprobanteDomicilio, fileEstudioPrevioUsg, estudioBiopsia,
         fileEstudioPrevioMasto;
         
         
         masculino = $('#masculino').is(':checked') ? 1 : 0;
         femenino = $('#femenino').is(':checked') ? 1 : 0;
         
         sillaDeRuedas = $('#sillaRuedas').is(':checked') ? 1 : 0;
         camilla = $('#camilla').is(':checked') ? 1 : 0;
         baston = $('#baston').is(':checked') ? 1 : 0;
         oxigeno = $('#oxigeno').is(':checked') ? 1 : 0;
         motivoConsulta = $('#motivoConsulta').val();
         biopsia = $('#biopsiaInput').is(':checked') ? 1 : 0;
         */
        //Imprimir los valores de entrada
        /*console.log("masculino: " + masculino + " femenino: " + femenino + " silla:  " + sillaDeRuedas + " camilla: " + camilla + " bastón: " +
         baston + " oxigeno " + oxigeno + " biopsia " + biopsia + " motivo " + motivoConsulta
         + " identificacion: " + identificacionOficial.name + " comprobante: " + comprobanteDomicilio.name + " estudioMasto: " + fileEstudioPrevioMasto.name
         +" estudioUsg: " + fileEstudioPrevioUsg.name + " biopsia: " + estudioBiopsia.name);
         */
        $.ajax({
            url: "PotencialController",
            method: "POST",
            data: data,
            enctype: "multipart/form-data",
            processData: false,
            contentType: false,
            success: function (response) {
                if (response == "success") {
                    console.log("ok");
                } else {
                    console.log("Algo pasó" + response);
                }
            },
            error: function () {
                console.log("error" + xhr.statusText);
                alert("No enontre el controlador" + xhr.statusText);
            }


        });

    });


    //Author: Angel Gtz
    //este ajax hace que manda la nueva contraseña de la cuenta del paciente potencial

    $("#btn-cambiarContrasena").on('click', function () {



        //Modal cambiar contraseña 
        swal({
            title: "¿Estás segura(o) que deseas guardar los cambios de tu contraseña?",
            text: "No podras volver a usar tu contraseña anterior para ingresar",
            icon: "warning",
            buttons: true,
            buttons: ['Regresar', 'Cambiar contraseña'],
            dangerMode: true
        })
                .then((cambiar) => {
                    if (cambiar) {


                        $.ajax({
                            url: "PotencialController",
                            data: {
                                key: "cambiarContrasena",
                                idCuenta: $("#sesionPaciente").val(),
                                password: $("#password").val(),
                                password2: $("#password2").val()
                            },
                            method: "POST",
                            success: function (response) {
                                if (response == "success") {

                                } else {
                                    //Aqui no se que hace
                                }
                            },
                            error: function (xhr) {

                            }
                        });
                        $('#modalCambiarContraseña').modal('toggle');
                    } else {

                    }
                });


    });

    /* $("#irACuenta").on('click', function () {
     console.log("Presionó ir a cuenta");
     $.ajax({
     url: "FrontController",
     method: "POST",
     success: function (response) {
     
     console.log("Va a cambiar de pag");
     document.location.href = 'WEB-INF/index.jsp';
     console.log("cambió de pag");
     
     },
     error: function (xhr) {
     console.log("Algo pasó");
     }
     });
     });*/
    $('#irACitaPreconsulta').on('click', function () {
        console.log("Presionó CitaPreConsulta")
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
    });

    $('#irAMisCitas').on('click', function () {
        $.post("SAPI", {
            //CAMBIAR ESTE FILE
            file: "potencial/misCitas.jsp"
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
    });


    $('#irACuenta').on('click', function () {
        $.post("SAPI", {
            file: "potencial/cuentaPaciente.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
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
    });

    $('#irAPreguntasFrecuentes').on('click', function () {
        $.post("SAPI", {
            //CAMBIAR ESTE NOMBRE
            file: "potencial/preguntasFrecuentes.jsp"
        },
                function (response, status, xhr) {

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
    });
    /*
     $('#guardarCambios').on('click', function() {
     console.log("Presionó GuardarCambios") 
     var corr = $("#myEmail");
     var tel = $("#telephoneNum");
     var input = $("#file-input")
     $.get("PotencialController", {
     key: "guardarCambios",
     file: "potencial/cuentaPaciente.jsp",
     input: input.val(),
     correo: corr.val(),
     telefono: tel.val()
     },
     //Esto de aquí abajo para que?
     
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
     });*/


    $('#guardarCambios').on('click', function () {

        console.log("Presionó GuardarCambios")
        var form = $("form")[0];
        var data = new FormData(form);

        data.append("key", "guardarCambios");
        data.forEach((value, key) => {
            console.log(key + " " + value);
        })

        $.ajax({
            url: "PotencialController",
            data: data,
            method: "POST",
            encType: "multipart/form-data",
            processData: false,
            contentType: false,
            success: function (response) {
                $.post("SAPI", {
                    file: "potencial/cuentaPaciente.jsp"
                },
                        function (response, status, xhr) {
                            console.log("El ajax fue exitoso!!-----------------------");
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
            },
            error: function (xhr) {
                //alert(xhr.statusText);
            }
        });
    });



    //PARA SALIR DE LA CUENTA
    $('#salirCuenta').on('click', function () {
        console.log("Salir cuenta");
        $.get("LoginController", {
            key: "cerrar-sesion"
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
    });


    //PARA SALIR DE LA CUENTA
    $('#salirCuenta1').on('click', function () {
        console.log("Salir cuenta");
        $.get("LoginController", {
            key: "cerrar-sesion"
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
    });






    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#ImagenPerfil').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#file-input").on('change', function () {
        console.log("Llegó :)");
        readURL(this);
    });



});