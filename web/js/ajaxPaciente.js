$(document).ready(function () {

    //Recuperar edificio
    var edificio;

    $("input:radio[name=Edificios]").click(function () {
        edificio = $(this).val();

    });

    //Recupera ColoR

    $('input[type=radio][name=Edificios]').on('change', function () {

        console.log('Valor seleccionado de EDIFICIOS: ' + parseInt($(this).val()));

        if (parseInt($(this).val()) === 1) {
            $('#colorCita').val($('input:radio[name=Edificios]:checked').attr("data-color"));
            console.log($('#colorCita').val());
        }

    });

    $('input[type=radio][name=Pisos]').on('change', function () {

        console.log('Valor seleccionado de PISOS: ' + parseInt($(this).val()));

        $('#colorCita').val($('input:radio[name=Pisos]:checked').attr("data-color"));

        console.log($('#colorCita').val());

    });

    //Recuperar piso
    var piso = 0;

    $("input:radio[name=Pisos]").click(function () {
        piso = $(this).val();
    });

    $('#RegistrarCita_hora').on('change', function () {

        $('#fechaProgramada').val($('#fechaTemp').val() + ' ' + $(this).val() + ":00");

        console.log($('#fechaProgramada').val());
    });

    //Recupera Titulo
    $('#RegistrarCita_tipo').on('change', function () {

        $('#tituloCita').val($(this).find(':selected').data('nombre'));

        console.log($('#tituloCita').val());

    });

    //REGISTRAR CITA
    $('#btn-citaRegistrar').on('click', () => {

        $.ajax({
            url: 'PacienteController',
            cache: false,
            method: 'POST',
            data: {
                key: 'agregarEvento',
                //hora: $('#RegistrarCita_hora').val(),
                tipo: $('#RegistrarCita_tipo').val(),
                medico: $('#RegistrarCita_medico').val(),
                edificio: edificio,
                piso: piso,
                idPaciente: $('#idPaciente').val(),
                fechaProgramada: $('#fechaProgramada').val()

            }
        })
                .done(function (response) {

                    console.log(response);

                    if (response === "success") {

                        var newEvent = {

                            title: $('#tituloCita').val(),
                            start: $('#fechaProgramada').val(),
                            color: $('#colorCita').val(),
                            textColor: 'white'

                        };

                        $('#calendarCitasPaciente').fullCalendar('renderEvent', newEvent);

                        swal({
                            title: "Buen Trabajo!",
                            text: "La cita se ha registrado correctamente!",
                            icon: "success",
                        });


                        $('#modalAgregarCita').modal('toggle');

                    } else {
                        swal({
                            title: "Algo salió mal!",
                            text: "No se pudo registrar la cita, intentalo de nuevo!",
                            icon: "error",
                        });
                    }

                })
                .fail(function (xhr, textStatus, errorThrown) {
                    console.log(xhr.responseText);
                });

        //VERIFICACION
        console.log($('#RegistrarCita_hora').val());
        console.log($('#RegistrarCita_tipo').val());
        console.log($('#RegistrarCita_medico').val());
        console.log('El edificio es: ' + edificio);
        console.log('El piso es: ' + piso);



    });

    $('#feedbackEdAntiguo').hide();
    $('#feedbackEdTorre').hide();
    $('#pisosDiv').hide();

    $('#EdAntiguo').on('mouseover', function () {
        $('#feedbackEdAntiguo').show();
        $('#feedbackEdAntiguo').disabled = true;
    });
    $('#feedbackEdAntiguo').on('mouseout', function () {
        $('#feedbackEdAntiguo').hide();
    });

    $('#EdTorre').on('mouseover', function () {
        $('#feedbackEdTorre').show();
    });
    $('#feedbackEdTorre').on('mouseout', function () {
        $('#feedbackEdTorre').hide();
    });


    $('input:radio[name=Edificios]').change(function () {
        if (this.value == 1) {
            $("input:radio[name=Pisos]").prop('checked', false);
            $('#pisosDiv').hide();
        } else if (this.value == 2) {
            $('#pisosDiv').show();
        }
    });

    //PARA IR A LA CUENTA
    $('#irACuenta').on('click', function () {
        $.get("SAPI", {
            file: "paciente/cuenta.jsp"
        },
                function (response, status, xhr) {
                    //console.log(response);
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

    //Eliminar Cuenta
    $('#eliminarCuenta').on('click',  function (){

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
                            url: "PacienteController",
                            data: {
                                key: "eliminarCuentaPaciente",
                                idCuenta: $("#sesionPaciente").val()

                            },
                            method: "POST",
                            success: function (response) {
                                if (response == "error") {
                                     console.log("Error al cargar");
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

                    }
                });



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



});