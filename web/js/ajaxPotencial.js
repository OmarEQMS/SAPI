//ajaxPotencial.js

$(document).ready(function () {


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

                    } else {

                    }
                });


    });

    $("#btn-enviarSolicitud").on('click', () => {

        //Modal borrar sintoma
        swal({
            title: "¡Buen Trabajo! se ha enviado tu solicitud",
            text: "En un lapso no mayor a 36 horas recibirás una respuesta",
            icon: "success",
            showCancelButton: false,
            showConfirmButton: true,
            buttons: [, 'Aceptar'],
            dangerMode: true,
        });

        var masculino, femenino, camilla, sillaDeRuedas, baston, oxigeno, biopsia, motivoConsulta,
                identificacionOficial, comprobanteDomicilio, estudioPrevio, estudioBiopsia;


        var data = [];

        masculino = $('#masculino').is(':checked') ? 1 : 0;
        femenino = $('#femenino').is(':checked') ? 1 : 0;

        sillaDeRuedas = $('#sillaRuedas').is(':checked') ? 1 : 0;
        camilla = $('#camilla').is(':checked') ? 1 : 0;
        baston = $('#baston').is(':checked') ? 1 : 0;
        oxigeno = $('#oxigeno').is(':checked') ? 1 : 0;
        motivoConsulta = $('#motivoConsulta').val();
        biopsia = $('#biopsiaInput').is(':checked') ? 1 : 0;

        identificacionOficial = $('#fileIdentificacion').prop('files')[0];
        comprobanteDomicilio = $('#fileComprobanteDomicilio').prop('files')[0];
        estudioPrevio = $('#fileEstudioPrevio').prop('files')[0];
        estudioBiopsia = $('#fileEstudioBiopsia').prop('files')[0];

        data.push(masculino);
        data.push(femenino);
        data.push(sillaDeRuedas);
        data.push(camilla);
        data.push(baston);
        data.push(oxigeno);
        data.push(biopsia);
        data.push(motivoConsulta);
        data.push(identificacionOficial);
        data.push(comprobanteDomicilio);
        data.push(estudioPrevio);
        data.push(estudioBiopsia);

        console.log("masculino: " + masculino + " femenino: " + femenino + " silla:  " + sillaDeRuedas + " camilla: " + camilla + " bastón: " +
                baston + " oxigeno " + oxigeno + " biopsia " + biopsia + " motivo " + motivoConsulta
                + " identificacion: " + identificacionOficial.name + " comprobante: " + comprobanteDomicilio.name + " estudio: " + estudioPrevio.name
                + " biopsia: " + estudioBiopsia.name);

        $.ajax({
            url: /*sin url aún,*/"URL",
            method: "POST",
            data: data,
            enctype: "multipart/form-data",
            processData: false,
            contentType: false,
            success: function (response) {
                if (response == "success") {
                    console.log("ok");
                } else {
                    console.log("Algo pasó");
                }
            },
            error: function () {
                console.log("error");
            }


        });

    });


    //Author: Angel Gtz
    //este ajax hace que manda la nueva contraeña de la cuenta del paciente potencial

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
    /*
     $("#irACuenta").on('click', function () {
     
     $.ajax({
     url: "FrontController",
     data: {
     key: "redirecionarACuenta",
     idCuenta: $("#sesionPaciente").val()
     },
     method: "POST",
     success: function (response) {
     console.log(response);
     if (response == "success") {
     
     } else {
     //Aqui no se que hace
     }
     },
     error: function (xhr) {
     
     }
     });
     });
     */
    $('#irACuenta').on('click', function () {
        $.get("SAPI", {
            file: "potencial/cuentaPaciente.jsp"
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

    $('#guardarCambios').on('click', function () {
        console.log("Presionó GuardarCambios")
        var corr = $("#myEmail");
        var tel = $("#telephoneNum");
        $.get("PotencialController", {
            key: "guardarCambios",
            file: "potencial/cuentaPaciente.jsp",
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