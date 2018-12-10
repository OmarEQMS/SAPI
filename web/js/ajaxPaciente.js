$(document).ready(function () {

//esconder mensajes de error
    $("#error-campos").hide();
    $('#error-contrasena').hide();
    $('#noEqualPasswordsError').hide();
    $('#errorCorreoRepetido').hide();
    $('#error-imgPerfil').hide();

    $("#error-datosRepetidos").hide();

    var repiteCorreo;
    var cambioImagen = false;
    var imagenValida = false;

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
//Agregar contenido dinamico de etapaClinica


//REGISTRAR CITA
    $('#btn-citaRegistrar').on('click', () => {

        var esValid = false;
        //Verificar que todos los campos que han marcado
        if (isValidHour($('#RegistrarCita_hora')) && isValidSelect($('#RegistrarCita_tipo')) && isValidSelect($('#RegistrarCita_medico')) && isValidRadioChecked($('input[name=Edificios]'))) {
            $("#error-campos").hide();
            if (parseInt($('input[name=Edificios]:checked').val()) == 1) {
                esValid = true;
            } else {
//Validamos los pisos
                if (isValidRadioChecked($('input[name=Pisos]'))) {
                    esValid = true;
                    $("#error-campos").hide();
                } else {
                    $("#error-campos").show();
                }
            }


            if (esValid) {

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

                                $(".hora").val("");
                                $(".tipo").prop('selectedIndex', 0);
                                $(".medico").prop('selectedIndex', 0);
                                $("#RegistrarCita_edificioAntiguo").prop("checked", false);
                                $("#RegistrarCita_edificioNuevo").prop("checked", false);
                                $('input[name=Pisos]').prop("checked", false);
                                $('#pisosDiv').hide();
                                var newEvent = {

                                    title: $('#tituloCita').val(),
                                    start: $('#fechaProgramada').val(),
                                    color: $('#colorCita').val(),
                                    textColor: 'white'

                                };
                                $('#calendarCitasPaciente').fullCalendar('renderEvent', newEvent);
                                swal({
                                    title: "¡Buen Trabajo!",
                                    text: "La cita se ha registrado correctamente.",
                                    icon: "success",
                                    closeOnEsc: false,
                                    closeOnClickOutside: false,
                                    buttons: [, 'Aceptar'],
                                });
                                $('#modalAgregarCita').modal('toggle');
                            } else {
                                swal({
                                    title: "Error",
                                    text: "No se pudo registrar la cita, intentalo de nuevo.",
                                    icon: "error",
                                    closeOnEsc: false,
                                    closeOnClickOutside: false,
                                    buttons: [, 'Aceptar'],
                                });
                            }

                        })
                        .fail(function (xhr, textStatus, errorThrown) {
                            console.log(xhr.responseText);
                        });
            }

        } else {
            $("#error-campos").show();
        }

//CERRAR MODAL

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
    $('.irACuenta').on('click', function () {
        $.ajax({
            url: 'SAPI',
            method: "POST",
            cache: false,
            data: {
                file: "paciente/cuenta.jsp",
            },
            beforeSend: function () {
                $('.cargandoIrACuenta').fadeIn();
            },
            complete: function () {
                $('.cargandoIrACuenta').fadeOut();
            },
            success: function (response, status, xhr) {
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
        });
    });
    //PARA IR A INICIO PACIENTE
    $('.irAInicioPaciente').on('click', function () {
        $.ajax({
            url: 'SAPI',
            method: "POST",
            cache: false,
            data: {
                file: "paciente/index.jsp",
            },
            beforeSend: function () {
                $('.cargandoIrAMisCitas').fadeIn();
            },
            complete: function () {
                $('.cargandoIrAMisCitas').fadeOut();
            },
            success: function (response, status, xhr) {
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
        });
    });
    //PARA IR A mis Tratamientos
    $('#irATratamientos').on('click', function () {
        $.ajax({
            url: 'SAPI',
            method: "POST",
            cache: false,
            data: {
                file: "paciente/misTratamientos.jsp",
            },
            beforeSend: function () {
                $('.cargandoIrATratamientos').fadeIn();
            },
            complete: function () {
                $('.cargandoIrATratamientos').fadeOut();
            },
            success: function (response, status, xhr) {
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
        });
    });
    //PARA IR A mis Citas
    $('#irMisCitas').on('click', function () {
        $.ajax({
            url: 'SAPI',
            method: "POST",
            cache: false,
            data: {
                file: "paciente/index.jsp",
            },
            beforeSend: function () {
                $('.cargandoIrAMisCitas').fadeIn();
            },
            complete: function () {
                $('.cargandoIrAMisCitas').fadeOut();
            },
            success: function (response, status, xhr) {
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
        });
    });
    //PARA SALIR DE LA CUENTA
    $('#salirCuenta').on('click', function () {
        console.log("Salir cuenta");
        $.post("LoginController", {
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
    $('#eliminarCuenta').on('click', function () {

        swal({
            title: "¿Estás segura(o)?",
            text: "Los datos se eliminarán y no podrás recuperarlos ni poder acceder a tu cuenta.",
            icon: "warning",
            buttons: true,
            closeOnEsc: false,
            closeOnClickOutside: false,
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
        $.post("LoginController", {
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
    //
    function getValues(selector) {
        var els = document.querySelectorAll(selector);
        return [].map.call(els, el => el.value);
    }


    $('#correo').on('change', function () {
        $.ajax({

            url: 'PacienteController',
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
                    $('#correo').css('color', '');
                    $('#errorCorreoRepetido').hide();
                    repiteCorreo = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#error-correo').hide();
        } else if ($(this).val() == '') {
            $('#error-correo').hide();
        } else {
            $('#error-correo').show();
        }

    });

    $('#guardarCambios').on('click', function () {

        var continuar = false;

        if (cambioImagen) {
            if (imagenValida)
                continuar = true;
            else
                continuar = false;
        } else {
            continuar = true;
        }

        console.log("CambioImagen: " + cambioImagen);
        console.log("imagenValida: " + imagenValida);

        if (continuar)
            console.log("Se actualizan cambios");
        else
            console.log("No se puede (imagenInVálida");
        if (continuar) {
            if (!repiteCorreo) {
                $("#error-datosRepetidos").hide();
                if (isValidEmail($("#correo")) &&
                        isValidPhoneNumber($("#telefono")) &&
                        isValidNoExpediente($("#noExpediente"))) {

                    console.log("Presionó GuardarCambios")
                    var form = $("form")[0];
                    var data = new FormData(form);
                    data.append("key", "cambiarDatos");
                    data.forEach((value, key) => {
                        console.log(key + " " + value);
                    })
                    $.ajax({
                        url: "PacienteController",
                        data: data,
                        method: "POST",
                        beforeSend: function () {
                            $('.loading-screenGuardar').fadeIn();
                        },
                        encType: "multipart/form-data",
                        processData: false,
                        contentType: false,
                        cache: false,
                        complete: function () {
                            $('.loading-screenGuardar').fadeOut();
                        },
                        success: function (response) {
                            $.post("SAPI", {
                                file: "paciente/cuenta.jsp"
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
                } else {
                    swal({
                        title: "Error",
                        text: "Revisa todos los campos antes de continuar.",
                        icon: "error",
                        closeOnEsc: false,
                        closeOnClickOutside: false,
                        buttons: [, 'Aceptar'],
                    });
                }
            } else {
                $("#error-datosRepetidos").show(); //ya existe un campo
            }
        } else {
            swal({
                title: "Error",
                text: "Revisa todos los campos antes de continuar.",
                icon: "error",
                closeOnEsc: false,
                closeOnClickOutside: false,
                buttons: [, 'Aceptar'],
            });
        }
    });

//Cambiar imagen temporalmente en elfront
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
        cambioImagen = true;
        var tieneFoto = ($('#file-input').get(0).files.length === 0) ? false : true;
        console.log("Tiene algo? " + tieneFoto)
        if (validProfilePhoto($('#file-input'), document.querySelector('#file-input').files) || !tieneFoto) {
            imagenValida = true;
            $('#error-imgPerfil').hide();
            readURL(this);
        } else {
            imagenValida = false;
            $('#error-imgPerfil').show();
        }
    });

    //Agregar tratamientos
    $("#btn-agregarTratamiento").on('click', function () {

        if ($("#tipoTratamiento").val() != "Elegir Tratamiento")
            console.log($("#tipoTratamiento").val());

        if (isValidDate($('#fechaInicioTratamiento'), $('.fechaNacimientoPaciente')) && $("#tipoTratamiento").val() != null) {

            var fechaInicioTratamiento = $("#fechaInicioTratamiento").val();

            $.ajax({
                url: 'PacienteController',
                cache: false,
                method: 'POST',
                data: {
                    key: 'agregarTratamiento',
                    idTipoTratamiento: $('#tipoTratamiento').val(),
                    fechaInicio: $('#fechaInicioTratamiento').val(),
                }
            })
                    .done(function (response) {

                        console.log(response);

                        $('#modalAgregarTratamiento').modal('toggle'); //cerrar modal

                        swal({
                            title: "¡Buen trabajo!",
                            text: "Tratamiento registrado correctamente.",
                            icon: "success",
                            buttons: true,
                            buttons: [, 'Aceptar'],
                            closeOnEsc: false,
                            closeOnClickOutside: false,
                        });

                        console.log("FechaInicioTratamiento: " + $("#fechaInicioTratamiento").val());

                        var t = $('#tablaTratamientos').DataTable();

                        t.row.add([
                            "<input type='hidden' value='" + $("#nombreTipoTratamiento").val() + "' id='nombre-" + response + "'>" +
                                    "<input type='hidden' value='" + fechaInicioTratamiento + "' id='fechaInicio-" + response + "'>" +
                                    "<input type='hidden' value='" + response + "' id='boton-" + response + "'>" +
                                    $("#nombreTipoTratamiento").val(),
                            fechaInicioTratamiento,
                            "<span id='fecha-" + response + "'></span>",
                            "<button class='btn btn-primary terminarTratamiento' id='modal-" + response + "' data-id='" + response + "'data-toggle='modal' data-target='#modalEditarTerminado'> <i class='fas fa-edit'></i> </button>"
                        ]).draw(false);


                        console.log("WHALALALALA" + $("#nombre-" + response).val())


                        $('#tipoTratamiento').prop('selectedIndex', 0);

                        $("#fechaInicioTratamiento").val('');

                        //$('#idTratamientoPaciente').val(response);

                    })
                    .fail(function (xhr, textStatus, errorThrown) {
                        console.log(xhr.responseText);
                    });
        } else {
            swal({
                title: "Error",
                text: "Revisa todos los campos antes de continuar.",
                icon: "error",
                closeOnEsc: false,
                closeOnClickOutside: false,
                buttons: [, 'Aceptar'],
            });
        }
    });

    //Cambiar contraseña
    $("#btn-updatePassword").on('click', function () {
        if (isValidPassword($('#password')) && isValidPassword($('#password2')) && areEqualPasswords($('#password'), $('#password2'))) {
            //Modal cambiar contraseña 
            swal({
                title: "¿Estás segura(o) que deseas guardar los cambios de tu contraseña?",
                text: "No podrás volver a usar tu contraseña anterior para ingresar.",
                icon: "warning",
                buttons: true,
                closeOnEsc: false,
                closeOnClickOutside: false,
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

                                    $("#password").val('');
                                    $("#password2").val('');
                                },
                                error: function (xhr) {

                                }
                            });
                            $('#modalCambiarContraseña').modal('toggle');
                        }

                    });
        }
    });
    $("#password").on('change', function () {
        if (isValidPassword($(this)))
            $("#error-contrasena").hide();
        else
            $("#error-contrasena").show();
    });
    $("#password2").on('change', function () {
        var pass1 = $('#password');
        var pass2 = $(this);
        areEqualPasswords(pass1, pass2);
    });

    //Terminar tratamiento
    $("#fechaTerminarTratamiento").on('click', function () {
        var date_from = $('#fechaFinTratamiento').val();
        var date_by = $('#fechaInicioTratamiento2').val();
        console.log("#fechaFin: " + date_from);
        console.log("#fechaInicio: " + date_by);
        console.log("idTratamientoPaciente: " + $('.idTratamientoPaciente').val());

        if (isValidDate2($('#fechaFinTratamiento'), $('#fechaInicioTratamiento2'))) {

            var fechaFinTratamiento = $('#fechaFinTratamiento').val();

            $.ajax({
                url: 'PacienteController',
                cache: false,
                method: 'POST',
                data: {
                    key: 'terminarTratamiento',
                    idTratamientoPaciente: $('.idTratamientoPaciente').val(),
                    fechaFin: $('#fechaFinTratamiento').val()
                }
            })
                    .done(function (response) {

                        $('#modalEditarTerminado').modal('toggle'); //cerrar modal
                        swal({
                            title: "¡Buen trabajo!",
                            text: "Tratamiento finalizado.",
                            closeOnEsc: false,
                            closeOnClickOutside: false,
                            icon: "success",
                            buttons: true,
                            buttons: [, 'Aceptar']
                        });


                        //actualizar la tabla

                        console.log("fechaFinTratamiento: " + $('#fechaFinTratamiento').val());

                        $('#fecha-' + $('.idTratamientoPaciente').val()).html(fechaFinTratamiento);

                        $("#fechaFinTratamiento").val('');

                        $("#modal-" + $('.idTratamientoPaciente').val()).attr("disabled", "disabled").removeClass("btn-primary").addClass("btn-secondary");



                    })
                    .fail(function (xhr, textStatus, errorThrown) {
                        console.log(xhr.responseText);
                    });

        } else {
            swal({
                title: "Error",
                text: "Revisa todos los campos antes de continuar.",
                icon: "error",
                closeOnEsc: false,
                closeOnClickOutside: false,
                buttons: true,
                buttons: [, 'Aceptar']
            });
        }
    });
    //Designar idTratamientoPaciente
    $('body').on('click', '.terminarTratamiento', function () {

        $(".idTratamientoPaciente").val(
                $("#boton-" + $(this).data('id')).val()
                );

        console.log("idTratamientoPacienteUnico: " + $(".idTratamientoPaciente").val());

        $("#botonHidden").val($(this).data('id'));

        //alert($('#idTratamientoPaciente').val());

        $("#tipoTratamiento2").val(
                $("#nombre-" + $(this).data('id')).val()
                );
        $("#fechaInicioTratamiento2").val(
                $("#fechaInicio-" + $(this).data('id')).val()
                );

    });


    //Conseguir contenido del select

    $("#tipoTratamiento").on('change', function () {
        $('#nombreTipoTratamiento').val($('#tipoTratamiento option:selected').text());
        console.log($('#nombreTipoTratamiento').val());
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

    function validProfilePhoto(input, archivos) {

        for (let index = 0; index < archivos.length; index++) {

            if (archivos[index]["type"] == "image/jpg" || archivos[index]["type"] == "image/png"
                    || archivos[index]["type"] == "image/jpeg") {

                console.log('si se puede' + archivos[index]["type"]);
                input.css('border', '');
                return true;


            } else {
                console.log('no se puede' + archivos[index]["type"]);
                input.css('border', '1px solid red');
            }

        }

        return false;
    }

    function isValidNoExpediente(input) {

        var m = input.val();
        var expreg = /^[a-zA-Z0-9]{9,9}$/;
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
    function isValidHour(input) {

        if (!input.val()) {

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
    function isValidSelect(input) {

        if (!input.val()) {

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
    function isValidRadioChecked(input) {

        if (!input.is(':checked')) {

            return false;
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
        var futureDate = new Date(year, month + 2, day)

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

        //Setear la hora en 0 y sumarle uno al día registrado (porque se le resta 1)
        var year = date_from.getFullYear();
        var month = date_from.getMonth();
        var day = date_from.getDate();
        date_from = new Date(year, month, day + 1);
        date_from.setHours(0);

        //Valor de la fecha de inicio
        let date_start = fechaInicio.val();
        date_start = new Date(date_start);

        //Fecha de hoy
        let date_today = new Date();

        var event = false;

        console.log("Hoy: " + date_today);
        console.log("FechaFin: " + date_from);
        console.log("FechaInicio: " + date_start);

        if (date_start < date_from && date_from <= date_today) {
            event = false;
            console.log(event);
            console.log("fechaValida");
        } else {
            event = true;
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

});