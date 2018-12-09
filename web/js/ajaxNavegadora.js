$(document).ready(function () {

    //Errores en cuenta
    $('#error-correoNavegadora').hide();
    $('#error-correoRepetidoNavegadora').hide();
    $('#error-camposMotivo').hide();

    $('#errorFechaNavegacion').hide();
    $('#errorFechaPre').hide();
    $('#errorDatos').hide();


    //Errores al agregar a un paciente
    $('#errorNombrePaciente').hide();
    $('#errorCurpPaciente').hide();
    $('#errorCurpRepetidoPaciente').hide();
    $('#errorFechaPaciente').hide();
    $('#errorApellidoPaternoPaciente').hide();
    $('#errorApellidoMaternoPaciente').hide();
    $('#errorNombreUsuarioPaciente').hide();
    $('#errorUsuarioRepetidoPaciente').hide();
    $('#errorECivilPaciente').hide();
    $('#errorColoniaPaciente').hide();
    $('#errorCallePaciente').hide();
    $('#errorNoInteriorPaciente').hide();
    $('#errorNoExteriorPaciente').hide();
    $('#errorEstadoPaciente').hide();
    $('#errorMunicipioPaciente').hide();
    $('#errorTelefonoPaciente').hide();
    $('#errorCorreoPaciente').hide();
    $('#errorCorreoRepetidoPaciente').hide();
    $('#errorPass1Paciente').hide();
    $('#errorPass2Paciente').hide();
    $('#error-CPexistePaciente').hide();
    $('#errorCodigoPostalPaciente').hide();
    $('#noEqualPasswordsErrorPaciente').hide();
    $('#error-terminos').hide();
    $('#error-camposPaciente').hide();
    $('#error-datosRepetidosPaciente').hide();

    $("#error-editarDatosRepetidosPaciente").hide();
    $('#error-editar-NombrePaciente').hide();
    $('#error-editar-ApellidoPaternoPaciente').hide();
    $('#error-editar-ApellidoMaternoPaciente').hide();
    $('#error-editar-NombreUsuarioPaciente').hide();
    $('#error-editar-CorreoPaciente').hide();
    $('#error-editar-CurpPaciente').hide();
    $('#error-editar-ColoniaPaciente').hide();
    $('#error-editar-CallePaciente').hide();
    $('#error-editar-NoExteriorPaciente').hide();
    $('#error-editar-NoInteriorPaciente').hide();
    $('#error-editar-CurpRepetidoPaciente').hide();
    $('#error-editar-TelefonoPaciente').hide();
    $('#error-editar-ECivilPaciente').hide();
    $('#error-editar-FechaPaciente').hide();
    $('#error-editar-EstadoPaciente').hide();
    $('#error-editar-MunicipioPaciente').hide();
    $('#error-editar-UsuarioRepetidoPaciente').hide();
    $('#errorEditarPacienteCorreoRepetido').hide();
    $("#error-camposEditarPaciente").hide();

    $('#error-imgPerfil').hide();
    $('#error-contrasena').hide();
    $('#noEqualPasswordsError').hide();



    /////ERRORES FORMULARIO
    $('#error-fechaNavegacion').hide();
    $('#error-fechaConsulta').hide();
    $('#error-PRZ').hide();
    $('#error-alergias').hide();
    $('#error-numSeguro').hide();
    $('#error-fechaCirugia').hide();
    $('#error-fechaQuimio').hide();
    $('#error-fechaRadio').hide();
    $('#error-numCiclosQuimio').hide();
    $('#error-numCiclosRadio').hide();
    $('#error-fechaMastografia').hide();
    $('#error-fechaUltra').hide();
    $('#error-OtroResultadoPatologia').hide();
    $('#error-numeroLaminillas').hide();
    $('#error-serieLaminillas').hide();
    $('#error-numeroParafrina').hide();
    $('#error-serieParafrina').hide();
    $('#error-fechaDecision').hide();
    $('#error-comentarioIncidencias').hide();
    $('#error-comentarioAdicionales').hide();
    $('#error-ki67').hide();


    var repiteCorreoCuenta;

    $('#correo').on('change', function () {
        $.ajax({

            url: 'NavegadoraController',
            method: "POST",
            cache: false,
            data: {
                key: "repiteCorreo",
                correo: $('#correo').val()
            },
            success: function (response) {

                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#correo').css('color', 'orange');
                    $('#error-correoRepetidoNavegadora').show();
                    repiteCorreoCuenta = true;
                } else {
                    $('#error-correoRepetidoNavegadora').hide();
                    repiteCorreoCuenta = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#error-correoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#error-correoNavegadora').hide();
            $('#correo').css('border', '');
            $('#correo').css('color', '');
        } else {
            $('#error-correoNavegadora').show();
        }

    });

    var lugarDelCuerpo = $("#listLugarDelCuerpo");

    $.ajax({
        url: 'NavegadoraController',
        cache: false,
        method: 'POST',
        data: {key: "autocompleteLugarDelCuerpo"}
    })

            .done(function (response) {
                console.log('voy a imprimir la respuesta de lugarDelCuerpo');
                console.log(response);
                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {

                    var newObjeto = $('<option value="' + json[i].nombre + '"></option>');
                    console.log(newObjeto);
                    lugarDelCuerpo.append(newObjeto);
                }


                console.log(JSON.stringify(lugarDelCuerpo));

            });


    var biopsia = $("#listBiopsia");

    $.ajax({
        url: 'NavegadoraController',
        cache: false,
        method: 'POST',
        data: {key: "autocompleteBiopsia"}
    })

            .done(function (response) {
                console.log('voy a imprimir la respuesta de Biopsia');
                console.log(response);
                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {

                    var newObjeto = $('<option value="' + json[i].nombre + '"></option>');
                    biopsia.append(newObjeto);
                }


                console.log(JSON.stringify(biopsia));

            });


    var rayosX = $("#listRayosX");

    $.ajax({
        url: 'NavegadoraController',
        cache: false,
        method: 'POST',
        data: {key: "autocompleteRayosX"}
    })

            .done(function (response) {
                console.log('voy a imprimir la respuesta de RayosX');
                console.log(response);
                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {

                    var newObjeto = $('<option value="' + json[i].nombre + '"></option>');
                    rayosX.append(newObjeto);
                }


                console.log(JSON.stringify(rayosX));

            });






//AutocompleteRayosX





//AutocompleteUltrasonido

    var ultraSonido = $("#listUltraSonido");

    $.ajax({
        url: 'NavegadoraController',
        cache: false,
        method: 'POST',
        data: {key: "autocompleteUltraSonido"}
    })

            .done(function (response) {
                console.log('voy a imprimir la respuesta UltraSonido');
                console.log(response);
                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {
                    var newObjeto = $('<option value="' + json[i].nombre + '"></option>');
                    ultraSonido.append(newObjeto);
                }


                console.log(ultraSonido);

            });









//AutocompletePrograma

    var programa = $("#listPrograma");

    $.ajax({
        url: 'NavegadoraController',
        cache: false,
        method: 'POST',
        data: {key: "autocompletePrograma"}
    })

            .done(function (response) {
                console.log('voy a imprimir la respuesta Programa');
                console.log(response);
                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {
                    var newObjeto = $('<option value="' + json[i].nombre + '"></option>');
                    programa.append(newObjeto);
                }


                console.log(programa);

            });




//AutocompleteMedicinaNuclear

    var medicinaNuclear = $("#listMedicinaNuclear");

    $.ajax({
        url: 'NavegadoraController',
        cache: false,
        method: 'POST',
        data: {key: "autocompleteMedicinaNuclear"}
    })

            .done(function (response) {
                console.log('voy a imprimir la respuesta MedicinaNuclear');
                console.log(response);
                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {
                    var newObjeto = $('<option value="' + json[i].nombre + '"></option>');
                    medicinaNuclear.append(newObjeto);
                }


                console.log(medicinaNuclear);

            });


//AutocompleteValoracion

    var valoracion = $("#listValoracion");

    $.ajax({
        url: 'NavegadoraController',
        cache: false,
        method: 'POST',
        data: {key: "autocompleteValoracion"}
    })

            .done(function (response) {
                console.log('voy a imprimir la respuesta Valoracion');
                console.log(response);
                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {
                    var newObjeto = $('<option value="' + json[i].nombre + '"></option>');
                    valoracion.append(newObjeto);
                }


                console.log(valoracion);

            });


    //Terminos y condiciones
    $('#acepto-terminos').change(function () {

        if (parseInt($(this).val()) === parseInt('0')) {
            $(this).val('1');
        } else {
            $(this).val('0');
        }


    });

    //Codigo Postal en Agregar Paciente
    $('#codigo-postalNavegadora').on('change', function () {

        $.ajax({
            url: 'ZonaController',
            cache: false,
            method: 'POST',
            data: {
                key: "getEstadoyMunicipio",
                numeroCP: $('#codigo-postalNavegadora').val()

            },
            success: function (response) {

                if (response == 'postalCodeDoesntExist') {
                    $('#error-CPexiste').show();
                    repiteCURP = false;
                } else {
                    $('#error-CPexiste').hide();
                    var json = JSON.parse(response);
                    repiteCURP = false;

                    if ($('#codigo-postalNavegadora').val().length === 5) {
                        //Limpia los campos 
                        $("#estadoNavegadora").each(function () {
                            $(this).children().remove();
                        });

                        $("#municipioNavegadora").each(function () {
                            $(this).children().remove();
                        });

                        //Carga estado
                        $('#estadoNavegadora').append("<option value='" + json[0] + "'>" + json[1] + "</option>");

                        //Carga Municipio
                        $('#municipioNavegadora').append("<option value='" + json[2] + "'>" + json[3] + "</option>");

                    } else {

                        $('#estadoNavegadora').removeAttr('disabled');
                        $('#estadoNavegadora').removeAttr('selected');

                    }

                    console.log(json);
                }

            }

        });


    });

    //Reporte Jaspersoft
    $('body').on('click', '#btn-export1', function () {
        swal({
            title: "Asegurese de haber guardado los cambios",
            text: "¿Desea generar el reporte?",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true
        })
                .then((aceptar) => {
                    if (aceptar) {
                        $('.generarReporte').fadeIn();
                        var form = document.createElement("form");
                        form.method = "post";
                        form.action = "/SAPI/ReporteControllerJaspersoft?key=generar-reporte1";
                        document.body.appendChild(form);
                        form.submit();
                        document.body.removeChild(form);
                        //Cerrar       
                        $('.generarReporte').fadeOut();
                    }
                });
    });
    $('body').on('click', '#btn-export2', function () {
        swal({
            title: "Asegurese de haber guardado los cambios",
            text: "¿Desea generar el reporte?",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true
        })
                .then((aceptar) => {
                    if (aceptar) {
                        $('.generarReporte').fadeIn();
                        var form = document.createElement("form");
                        form.method = "post";
                        form.action = "/SAPI/ReporteControllerJaspersoft?key=generar-reporte2";
                        document.body.appendChild(form);
                        form.submit();
                        document.body.removeChild(form);
                        $('.generarReporte').fadeOut();
                    }
                });
    });
    //Fin Reporte Jaspersoft
    //Agregar Paciente
    $('#btn-agregarPaciente').on('click', function () {
        if (!repiteCorreoPaciente && !curpRepetidoPaciente) {

            $("#error-datosRepetidosPaciente").hide();

            if (isValidName($('#nombrePaciente')) && isValidLastName($('#primer-apellidoPaciente')) && isValidSegundoApellidoPaciente &&
                    isValidColPaciente && isValidCPPaciente && isValidCallePaciente && isValidNumIntPaciente && isValidNumExtPaciente &&
                    isValidUserName($('#usuarioPaciente')) && isValidEmail($('#correoPaciente')) &&
                    isValidPassword($('#contraPaciente')) && isValidPassword($('#confContraPaciente')) && isValidCURP($('#curpPaciente')) &&
                    isValidPhoneNumber($('#telPaciente')) && isValidSelect($('#estado-civilPaciente')) &&
                    isValidDate($('#cumplePaciente')) && isValidSelect($('#estadoPaciente')) && isValidSelect($('#municipioPaciente')) &&
                    areEqualPasswords($('#contraPaciente'), $('#confContraPaciente'))) {

                if (!isValidTerminosPaciente) {
                    $('#error-terminos').show();
                } else {
                    isValidTerminosPaciente = false;
                    $('#error-terminos').hide();
                    console.log("TODO BIEN");

                    $.ajax({
                        url: 'RegistraUsuarioController',
                        cache: false,
                        method: 'POST',
                        beforeSend: function () {
                            $('.cargandoAgregarPaciente').fadeIn();
                        },
                        data: {

                            key: "registraUsuario",
                            nombre: $('#nombrePaciente').val(),
                            curp: $('#curpPaciente').val(),
                            fechaNacimiento: $('#cumplePaciente').val(),
                            apellido1: $('#primer-apellidoPaciente').val(),
                            apellido2: $('#segundo-apellidoPaciente').val(),
                            usuario: $('#usuarioPaciente').val(),
                            estadoCivil: $('#estado-civilPaciente').val(),
                            calle: $('#callePaciente').val(),
                            noInterior: $('#numIntPaciente').val(),
                            noExterior: $('#numExtPaciente').val(),
                            codigoPostal: $('#codigo-postalPaciente').val(),
                            estado: $('#estadoPaciente').val(),
                            municipio: $('#municipioPaciente').val(),
                            telefono: $('#telPaciente').val(),
                            correo: $('#correoPaciente').val(),
                            colonia: $('#colPaciente').val(),
                            pass1: $('#contraPaciente').val(),
                            pass2: $('#confContraPaciente').val(),
                            terminos: $('#acepto-terminos').val()

                        },
                        complete: function () {
                            $('.cargandoAgregarPaciente').fadeOut();
                        },
                        success: function (response) {

                            //mensaje de confirmacion
                            swal({
                                title: "¡Buen trabajo!",
                                text: "Paciente agregado correctamente.",
                                closeOnEsc: false,
                                closeOnClickOutside: false,
                                icon: "success",
                                buttons: [, 'Aceptar'],
                            });

                            //cerrar el modal
                            $('#modalAgregarPaciente').modal('toggle');

                            console.log("Response!" + response);
                            console.log("FUNCIONÓ! (creo)");
                            var t = $('#tabla1').DataTable();

                            var today = new Date();

                            var year = today.getFullYear();
                            var month = today.getMonth();
                            var day = today.getDate();

                            if (day < 10) {
                                t.row.add([
                                    "<span class='nombre-" + response + "'>" + $("#nombrePaciente").val() + " " + $("#primer-apellidoPaciente").val() + " " + $("#segundo-apellidoPaciente").val() + "</span>",
                                    "<span id='estado-" + response + "'>Potencial en proceso</span>",
                                    "<span id='fecha-" + response + "'>" + year + "-" + month + "-0" + day + "</span>",
                                    "<span id='curp-" + response + "'>" + $('#curpPaciente').val() + "</span>",
                                    "<span class='telefono-" + response + "'>" + $("#telPaciente").val() + "</span>",
                                    "<button class='btn btn-info btn-ver  m-1' data-id=" + response + " id='btn-ver'><i class='far fa-eye'></i></button>" +
                                            "<button class='btn btn-success btn-aceptar-potencial m-1' id='aceptar-" + response + "' data-id=" + response + " data-toggle='modal' data-target='#modalAceptarUsuario'><i class='fas fa-check'></i></button>" +
                                            "<button class='btn btn-primary btn-editar m-1' data-id=" + response + " id='btn-editar' data-toggle='modal' data-target='#modalEditarPaciente'><i class='fas fa-edit'></i></button>" +
                                            "<button class='btn btn-danger btn-eliminar m-1' data-id=" + response + " id='btn-eliminar' data-toggle='modal' data-target='#modalEliminarUsuario'><i class='fas fa-trash-alt'></i></button>"
                                ]).draw(false);
                            } else {
                                t.row.add([
                                    "<span class='nombre-" + response + "'>" + $("#nombrePaciente").val() + " " + $("#primer-apellidoPaciente").val() + " " + $("#segundo-apellidoPaciente").val() + "</span>",
                                    "<span id='estado-" + response + "'>Potencial en proceso</span>",
                                    "<span id='fecha-" + response + "'>" + year + "-" + month + "-" + day + "</span>",
                                    "<span id='curp-" + response + "'>" + $('#curpPaciente').val() + "</span>",
                                    "<span class='telefono-" + response + "'>" + $("#telPaciente").val() + "</span>",
                                    "<button class='btn btn-info btn-ver  m-1' data-id=" + response + " id='btn-ver'><i class='far fa-eye'></i></button>" +
                                            "<button class='btn btn-success btn-aceptar-potencial m-1' id='aceptar-" + response + "' data-id=" + response + " data-toggle='modal' data-target='#modalAceptarUsuario'><i class='fas fa-check'></i></button>" +
                                            "<button class='btn btn-primary btn-editar m-1' data-id=" + response + " id='btn-editar' data-toggle='modal' data-target='#modalEditarPaciente'><i class='fas fa-edit'></i></button>" +
                                            "<button class='btn btn-danger btn-eliminar m-1' data-id=" + response + " id='btn-eliminar' data-toggle='modal' data-target='#modalEliminarUsuario'><i class='fas fa-trash-alt'></i></button>"
                                ]).draw(false);
                            }

                            //Insertar en la tabla
                            $('#nombrePaciente').val("");
                            $('#curpPaciente').val("");
                            $("#cumplePaciente").attr("type", "text").val('').attr("placeholder", "Fecha de nacimiento");
                            $('#primer-apellidoPaciente').val("");
                            $('#segundo-apellidoPaciente').val("");
                            $('#codigo-postalPaciente').val("");
                            $('#usuarioPaciente').val("");
                            $("#estado-civilPaciente").prop('selectedIndex', 0);
                            $('#colPaciente').val("");
                            $('#callePaciente').val("");
                            $('#numIntPaciente').val("");
                            $('#numExtPaciente').val("");
                            $('#estadoPaciente').prop('selectedIndex', 0);
                            $('#municipioPaciente').append("<option disabled selected>" + "Seleccione un Municipio" + "</option>");
                            $("#acepto-terminos").prop("checked", false);
                            $('#telPaciente').val("");
                            $('#correoPaciente').val("");
                            $('#contraPaciente').val("");
                            $('#confContraPaciente').val("");

                        }
                    });

                }
            } else {
                $("#error-camposPaciente").show();
            }
        } else {
            console.log("Entro al segundo else");
            $("#error-datosRepetidosPaciente").show(); //ya existe un campo
            $("#error-camposPaciente").hide();
        }
    });

    //  Editar paciente

    $('body').on('click', '.btn-editar', function () {

        var idPaciente = $(this).data('id');

        $('#idPacienteAEditar').val($(this).data('id'));

        console.log("idPaciente: " + idPaciente);

        $.ajax({

            url: 'AdministradorController',
            cache: false,
            method: 'POST',
            data: {

                key: "obtener-paciente",
                idPaciente: idPaciente

            },
            success: function (response) {

                var data = JSON.parse(response);

                console.log(data);

                $('#editarNombreNavegadoraAPaciente').val(data.nombre);
                $('#editarCurpNavegadoraAPaciente').val(data.curp);
                $('#editarCumpleNavegadoraAPaciente').val(convertDate3(new Date(data.fechaNacimiento)));
                $('#editarPrimer-apellidoNavegadoraAPaciente').val(data.primerApellido);
                $('#editarSegundo-apellidoNavegadoraAPaciente').val(data.segundoApellido);
                $('#editarUsuarioNavegadoraAPaciente').val(data.usuario);
                $('#editarEstado-civilPaciente').val(data.idEstadoCivil);
                $('#editarColNavegadoraAPaciente').val(data.colonia);
                $('#editarCalleNavegadoraAPaciente').val(data.calle);
                $('#editarNumIntNavegadoraAPaciente').val(data.noInt);
                $('#editarNumExtNavegadoraAPaciente').val(data.noExt);
                $('#editarEstadoNavegadoraAPaciente').val(data.idEstado);
                $('#editarTelNavegadoraAPaciente').val(data.telefono);
                $('#editarCorreoNavegadoraAPaciente').val(data.correo);

                $.ajax({

                    url: 'ZonaController',
                    cache: false,
                    method: 'POST',
                    data: {

                        key: "getByEstado",
                        idEstado: data.idEstado

                    },
                    success: function (response) {

                        //Limpiar el select antes de que haga una consulta para que no se emapalmen los municipios
                        $(".editarMunicipios select").each(function () {
                            $(this).children().remove();
                        });
                        var json = JSON.parse(response);
                        for (var i = 0; i < json.length; i++) {
                            $('.editarMunicipios select').append("<option value=" + json[i].idMunicipio + ">" + json[i].nombre + "</option>");
                        }
                        $('.editarMunicipios select').prop('selectedIndex', 0);
                        console.log(json);
                        $('#editarMunicipioNavegadoraAPaciente').val(data.idMunicipio);
                    }

                });
            }

        });

    });

    //GUARDA EL PACIENTE DESDE EL MODAL 
    $('#btn-guardarCambios').on('click', function () {
        if (!repiteCorreo && !repiteUsuarioPaciente) {
            $("#error-editarDatosRepetidosPaciente").hide();

            if (isValidName($('#editarNombreNavegadoraAPaciente')) && isValidLastName($('#editarPrimer-apellidoNavegadoraAPaciente'))
                    && isValidUserName($('#editarUsuarioNavegadoraAPaciente')) &&
                    isValidEdit2ApellidoPaciente && isValidEditColPaciente && isValidEditCallePaciente && isValidEditNumIntPaciente &&
                    isValidEditExtNumPaciente &&
                    isValidEmail($('#editarCorreoNavegadoraAPaciente')) && isValidCURP($('#editarCurpNavegadoraAPaciente'))
                    && isValidPhoneNumber($('#editarTelNavegadoraAPaciente')) &&
                    isValidSelect($('#editarEstado-civilPaciente')) && isValidDate($('#editarCumpleNavegadoraAPaciente'))
                    && isValidSelect($('#editarEstadoNavegadoraAPaciente')) && isValidSelect($('#editarMunicipioNavegadoraAPaciente'))) {

                $("#error-camposEditarPaciente").hide();

                $.ajax({

                    url: "AdministradorController",
                    method: "POST",
                    beforeSend: function () {
                        $('.cargandoEditarPaciente').fadeIn();
                    },
                    cache: false,
                    data: {
                        key: "actualizar-paciente",
                        idPaciente: $('#idPacienteAEditar').val(),
                        nombre: $('#editarNombreNavegadoraAPaciente').val(),
                        apellido1: $('#editarPrimer-apellidoNavegadoraAPaciente').val(),
                        apellido2: $('#editarSegundo-apellidoNavegadoraAPaciente').val(),
                        usuario: $("#editarUsuarioNavegadoraAPaciente").val(),
                        correo: $('#editarCorreoNavegadoraAPaciente').val(),
                        curp: $('#editarCurpNavegadoraAPaciente').val(),
                        colonia: $('#editarColNavegadoraAPaciente').val(),
                        calle: $('#editarCalleNavegadoraAPaciente').val(),
                        noExterior: $("#editarNumExtNavegadoraAPaciente").val(),
                        noInterior: $("#editarNumIntAdministradorAPacient").val(),
                        telefono: $("#editarTelNavegadoraAPaciente").val(),
                        estadoCivil: $("#editarEstado-civilPaciente").val(),
                        fechaNacimiento: $("#editarCumpleNavegadoraAPaciente").val(),
                        estado: $("#editarEstadoNavegadoraAPaciente").val(),
                        municipio: $("#editarMunicipioNavegadoraAPaciente").val()


                    },
                    complete: function () {
                        $('.cargandoEditarPaciente').fadeOut();
                    },
                    success: function (response) {

                        swal({
                            title: "Cambios guardados correctamente",
                            icon: "success",
                            closeOnEsc: false,
                            closeOnClickOutside: false,
                            buttons: true,
                            buttons: [, 'Aceptar']
                        });

                        //Cerrar modal
                        $("#modalEditarPaciente").modal('toggle');

                        //Actualizar informacion de la tabla
                        $(".nombre-" + $('#idPacienteAEditar').val()).html($("#editarNombreNavegadoraAPaciente").val() + ' ' + $('#editarPrimer-apellidoNavegadoraAPaciente').val() + ' ' + $('#editarSegundo-apellidoNavegadoraAPaciente').val());
                        $(".telefono-" + $('#idPacienteAEditar').val()).html($("#editarTelNavegadoraAPaciente").val());
                        $("#curp-" + $('#idPacienteAEditar').val()).html($("#editarCurpNavegadoraAPaciente").val());

                    }

                });
            } else {
                $("#error-camposEditarPaciente").show();
            }
        } else {
            console.log("Entro al segundo else");
            $("#error-editarDatosRepetidosPaciente").show(); //ya existe un campo
            $("#error-camposEditarPaciente").hide();
        }

    });

    //Redirige a documentos    
    $('body').on('click', '.btn-ver', function () {

        var id = $(this).data('id');
        console.log(id);
        //alert('saludos con el id: ' +  $('#hidden-idPaciente').val())

        $.ajax({
            url: 'SAPI',
            method: "POST",
            cache: false,
            data: {
                file: "navegadora/documentos.jsp",
                idPacientePotencialAtendido: id
            },
            beforeSend: function () {
                $('.listarDoc').fadeIn();
            },
            complete: function () {
                $('.listarDoc').fadeOut();
            },
            success: function (response, status, xhr) {
                if (status == "success") {
                    if (response == "error") {
                        console.log(response);
                    } else {
                        document.open("text/html", "replace");
                        document.write(response);
                        document.close();
                    }
                }
            }
        });
    });

    $('.irAVerDocumento').on('click', function () {

        console.log("Click");
        console.log($(this).data('id') + " " + $("#hiddenIdPaciente").val());
        $.ajax({
            url: 'SAPI',
            method: "POST",
            cache: false,
            data: {
                file: "navegadora/verDocumento.jsp",
                idDocumentoInicialVista: $(this).data('id'),
                idPacientePotencialAtendido: $("#hiddenIdPaciente").val(),
                siguiente: 0
            },
            beforeSend: function () {
                $('.verDoc').fadeIn();
            },
            complete: function () {
                $('.verDoc').fadeOut();
            },
            success: function (response, status, xhr) {
                if (status == "success") {
                    if (response == "error") {
                        console.log(response);
                    } else {
                        document.open("text/html", "replace");
                        document.write(response);
                        document.close();
                    }
                }
            }
        });
    });

    //fecha navegacion
    $('#Fecha-Navegacion').on('change', function () {

        console.log($(this).val());

    });

    $('#tipo-paciente').on('change', function () {

        $(this).css('border', '');
        $(this).css('color', '');

    });


    //Obtene Fecha consulta
    $('#Fecha-Consulta').on('change', function () {

        console.log($(this).val());

    });

    $('.btn-aceptar').on('click', function (e) {


        $('#hidden-idPaciente').val($(this).data('id'));


    });

    //Aprobar paciente
    $('#btn-aceptarDocumento').on('click', function () {

        if (!isPastDate($('#Fecha-Navegacion')) && !isPastDate($('#Fecha-Consulta'))
                && isValidSelect($('#tipo-paciente'))) {

            $('#errorDatos').hide();

            var idPaciente = $('#hidden-idPaciente').val();


            $.ajax({

                url: 'NavegadoraController',
                cache: false,
                method: 'POST',
                data: {

                    key: "aprobar-paciente",
                    idPaciente: idPaciente,
                    fechaNavegacion: $('#Fecha-Navegacion').val(),
                    fechaConsulta: $('#Fecha-Consulta').val(),
                    tipoPaciente: $('#tipo-paciente').val()


                },
                success: function (response) {
                    if (response == 'success') {
                        swal({
                            title: '¡Buen Trabajo!',
                            text: "El paciente se aprobó correctamente.",
                            icon: 'success',
                            closeOnEsc: false,
                            closeOnClickOutside: false,
                            buttons: true,
                            buttons: [, 'Aceptar'],
                        });
                        $('#modalAceptarUsuario').modal('toggle');
                        $('#Fecha-Navegacion').val('').attr("type", "text");
                        $('#Fecha-Consulta').val('').attr("type", "text");
                        $('#tipo-paciente').prop('selectedIndex', 0);

                        //Actualizar estado de la primer tabla
                        $("#estado-" + idPaciente).html("Potencial aceptado");

                        //Insertar al paciente en la segunda tabla
                        var date = new Date($('#Fecha-Navegacion').val());
                        var year = date.getFullYear();
                        var month = date.getMonth();
                        var day = date.getDate();
                        var t = $('#tabla2').DataTable();

                        if ($('#tipo-paciente').val() == 0) {
                            t.row.add([
                                "",
                                "<span class='nombre-" + idPaciente + "'>" + $('.nombre-' + idPaciente).html() + "</span>",
                                "<span id='tipo-" + idPaciente + "'>Primera vez</span>",
                                "",
                                year + "-" + month + "-" + day,
                                "<span class='telefono-" + idPaciente + "'>" + $(".telefono-" + idPaciente).html() + "</span>",
                                "<span id='estadoCita-" + idPaciente + "'>Aprobada</span>",
                                "<button class='btn btn-info m-1 btn-ver-formulario boton-" + idPaciente + "' data-id='" + idPaciente + "' id='btn-ver'><i class='fab fa-wpforms'></i></button>" +
                                        "<button class='btn btn-primary m-1 btn-editar' data-id='" + idPaciente + "' id='btn-editar' data-toggle='modal' data-target='#modalEditarPaciente'><i class='fas fa-edit'></i></button>" +
                                        "<button class='btn btn-danger m-1 btn-perder-cita' id='cancelarCita-" + idPaciente + "' data-id='" + idPaciente + "' data-toggle='modal' data-target='#modalEliminarUsuario'><i class='fas fa-ban'></i></button>"
                            ]).draw(false);
                        } else {
                            t.row.add([
                                "",
                                "<span class='nombre-" + idPaciente + "'>" + $('.nombre-' + idPaciente).html() + "</span>",
                                "<span id='tipo-" + idPaciente + "'>Segunda opinión</span>",
                                "",
                                year + "-" + month + "-" + day,
                                "<span class='telefono-" + idPaciente + "'>" + $(".telefono-" + idPaciente).html() + "</span>",
                                "<span id='estadoCita-" + idPaciente + "'>Aprobada</span>",
                                "<button class='btn btn-info m-1 btn-ver-formulario boton-" + idPaciente + "' data-id='" + idPaciente + "' id='btn-ver'><i class='fab fa-wpforms'></i></button>" +
                                        "<button class='btn btn-primary m-1 btn-editar' data-id='" + idPaciente + "' id='btn-editar' data-toggle='modal' data-target='#modalEditarPaciente'><i class='fas fa-edit'></i></button>" +
                                        "<button class='btn btn-danger m-1 btn-perder-cita' id='cancelarCita-" + idPaciente + "' data-id='" + idPaciente + "' data-toggle='modal' data-target='#modalEliminarUsuario'><i class='fas fa-ban'></i></button>"
                            ]).draw(false);
                        }

                        var boton = $('.boton-' + idPaciente);
                        boton.parent().parent().addClass("table-danger");

                        $("#Fecha-Navegacion").attr("type", "text").val('').attr("placeholder", "Fecha navegación");
                        $("#Fecha-Consulta").attr("type", "text").val('').attr("placeholder", "Fecha consulta");
                        $("#tipo-paciente").prop('selectedIndex', 0);
                        $("#aceptar-" + idPaciente).hide();

                    } else {
                        swal({
                            title: "Error",
                            text: "El paciente no se pudo aprobar.",
                            icon: "error",
                            closeOnEsc: false,
                            closeOnClickOutside: false,
                            buttons: true,
                            buttons: [, 'Aceptar'],
                        })
                    }
                }

            });
        } else {
            $('#errorDatos').show();
        }
    });

    //Eliminar paciente

    $('body').on('click', '.btn-eliminar', function () {

        //alert('saludos con el id' + $(this).data('id'));

        var idPaciente = $(this).data('id');
        var boton = $(this);

        swal({
            title: "¿Estás segura(o)?",
            text: "Una vez eliminado, el paciente y sus datos ya no se podrán recuperar.",
            icon: "warning",
            buttons: true,
            closeOnEsc: false,
            closeOnClickOutside: false,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
                .then((eliminar) => {

                    if (eliminar) {

                        $.ajax({

                            url: 'NavegadoraController',
                            cache: false,
                            method: 'POST',
                            data: {

                                key: "eliminar-paciente",
                                idPaciente: idPaciente,

                            },
                            beforeSend: function () {
                                $('.eliminarPaciente').fadeIn();
                            },
                            complete: function () {
                                $('.eliminarPaciente').fadeOut();
                            },
                            success: function (response) {
                                swal({
                                    title: "¡Buen trabajo!",
                                    text: "El paciente se eliminó correctamente.",
                                    icon: "success",
                                    closeOnEsc: false,
                                    closeOnClickOutside: false,
                                    buttons: true,
                                    buttons: [, 'Aceptar'],
                                })
                                boton.parent().parent().remove();


                            },
                            error: function () {
                                swal({
                                    title: "Error",
                                    text: "El paciente no se eliminó correctamente.",
                                    icon: "error",
                                    closeOnEsc: false,
                                    closeOnClickOutside: false,
                                    buttons: true,
                                    buttons: [, 'Aceptar'],
                                })
                            }

                        });



                    } else {

                    }
                });

    });


    /*
     $('.irAVerDocumento').on('click', function () {     
     
     $.get("SAPI", {
     file: "navegadora/verDocumento.jsp",
     idDocumentoInicial : $(this).data('id'),
     idPaciente: $("#hiddenIdPaciente")
     
     
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
     */

    //Eliminar cuenta
    $('#eliminarCuentaNavegadora').on('click', () => {

        swal({
            title: "¿Estás segura(o)?",
            text: "Los datos se eliminarán y no podrás recuperarlos ni poder acceder a tu cuenta.",
            icon: "warning",
            closeOnEsc: false,
            closeOnClickOutside: false,
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],

        })
                .then((eliminar) => {
                    if (eliminar) {
                        $.ajax({
                            url: "NavegadoraController",
                            data: {
                                key: "eliminarCuentaNavegadora",
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

    //Enviar Observaciones
    $('#enviarObservaciones').on('click', () => {

        swal({
            title: "¿Estás segura(o)?",
            text: "Las observaciones se enviarán al paciente.",
            icon: "warning",
            buttons: true,
            closeOnEsc: false,
            closeOnClickOutside: false,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
                .then((enviar) => {
                    if (enviar) {

                        //ajax para aprobar

                        location.href = "./index.html"

                    } else {

                    }
                });

    });

    $('#btn-cancelar').on('click', () => {

        swal({
            title: "¿Estás segura(o) de cancelar la cita?",
            text: "El paciente tendrá que solicitar de nuevo cita a preconsulta.",
            icon: "warning",
            buttons: true,
            closeOnEsc: false,
            closeOnClickOutside: false,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
                .then((cancelar) => {
                    if (cancelar) {



                    } else {

                    }
                });

    });

    //Enviar todos los datos del formulario
    $('#btn-sendAll').on('click', () => {

        swal({
            title: "¿Estás segura(o)?",
            text: "Los datos serán almacenados y no será posible su posterior edición.",
            icon: "warning",
            buttons: true,
            closeOnEsc: false,
            closeOnClickOutside: false,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
                .then((enviar) => {
                    if (enviar) {

                        //Aquí se va agregagar
                        // OMAR
                        var biopsias = [];
                        console.log("Biopsia 1");
                        $('.tuplaBiopsia').each(function () {
                            if ($(this).find('.tipoBiopsia').val() != "" || $(this).find('.fechaBiopsia').val() != "" || $(this).find('.parteCuerpoBiopsia').val() != "") {
                                var biopsia = {
                                    id: $(this).data("id"),
                                    accion: $(this).data("accion"),
                                    tipo: $(this).find('.tipoBiopsia').val(),
                                    fecha: $(this).find('.fechaBiopsia').val(),
                                    lugar: $(this).find('.parteCuerpoBiopsia').val()
                                };
                                biopsias.push(biopsia);
                                console.log(biopsia);
                            }
                        });


                        var rayosxs = [];

                        $('.tuplaRayosX').each(function () {
                            if ($(this).find('.rayosX').val() != "" || $(this).find('.fechaRayos').val() != "") {
                                var rayosx = {
                                    id: $(this).data("id"),
                                    accion: $(this).data("accion"),
                                    tipo: $(this).find('.rayosX').val(),
                                    fecha: $(this).find('.fechaRayos').val()
                                };
                                rayosxs.push(rayosx);
                                console.log(rayosx);
                            }

                        });
                        console.log("Rayox x");

                        var ultrasonidos = [];
                        console.log("Ultrasonido");
                        $('.tuplaUltrasonido').each(function () {

                            if ($(this).find('.parteCuerpoUltrasonido').val() != "" || $(this).find('.fechaUltrasonido').val() != "") {
                                var ultrasonido = {
                                    id: $(this).data("id"),
                                    accion: $(this).data("accion"),
                                    parte: $(this).find('.parteCuerpoUltrasonido').val(),
                                    fecha: $(this).find('.fechaUltrasonido').val()
                                };

                                ultrasonidos.push(ultrasonido);
                                console.log(ultrasonido);
                            }

                        });
                        console.log("Ultrasonido");


                        var medicinasNucleares = []
                        console.log("Medicina Nuclear");
                        $('.tuplaMedicinaNuclear').each(function () {

                            if ($(this).find('.medicinaNuclear').val() != "" || $(this).find('.fechaMedicinaNuclear').val() != "") {
                                var medicinaNuclear = {
                                    id: $(this).data("id"),
                                    accion: $(this).data("accion"),
                                    medicinaNuclear: $(this).find('.medicinaNuclear').val(),
                                    fecha: $(this).find('.fechaMedicinaNuclear').val()
                                };
                                console.log(medicinaNuclear);
                                medicinasNucleares.push(medicinaNuclear);
                            }

                        });
                        console.log("Medicina Nuclear");


                        var laboratorios = [];
                        console.log("tuplaLaboratorio");
                        $('.tuplaLaboratorio').each(function () {

                            if ($(this).find('.fechaLaboratorio').val() != "") {
                                var laboratorio = {
                                    id: $(this).data("id"),
                                    accion: $(this).data("accion"),
                                    fecha: $(this).find('.fechaLaboratorio').val()
                                };
                                laboratorios.push(laboratorio);
                                console.log(laboratorio);
                            }

                        });
                        console.log("tuplaLaboratorio");


                        var valoraciones = [];
                        console.log("tuplaValoracion");
                        $('.tuplaValoracion').each(function () {

                            if ($(this).find('.valoracion').val() != "" || $(this).find('.fechaValoracion').val() != "") {
                                var valoracion = {
                                    id: $(this).data("id"),
                                    accion: $(this).data("accion"),
                                    valoracion: $(this).find('.valoracion').val(),
                                    fecha: $(this).find('.fechaValoracion').val()
                                };
                                valoraciones.push(valoracion);
                                console.log(valoracion);
                            }

                        });
                        console.log("tuplaValoracion");


                        var espirometrias = [];
                        console.log("tuplaEspirometria");
                        $('.tuplaEspirometria').each(function () {

                            if ($(this).find('.fechaEspirometria').val() != "") {
                                var espirometria = {
                                    id: $(this).data("id"),
                                    accion: $(this).data("accion"),
                                    fecha: $(this).find('.fechaEspirometria').val()
                                };
                                espirometrias.push(espirometria);
                                console.log(espirometria);
                            }

                        });
                        console.log("tuplaEspirometria");


                        var electrocardiogramas = [];
                        console.log("tuplaElectrocardiograma");
                        $('.tuplaElectrocardiograma').each(function () {

                            if ($(this).find('.fechaElectrocardiograma').val() != "") {
                                var electrocardiograma = {
                                    id: $(this).data("id"),
                                    accion: $(this).data("accion"),
                                    fecha: $(this).find('.fechaElectrocardiograma').val()
                                };
                                electrocardiogramas.push(electrocardiograma);
                                console.log(electrocardiograma);
                            }

                        });
                        console.log("tuplaElectrocardiograma");


                        var ecocardiogramas = [];
                        console.log("tuplaEcocardiograma");
                        $('.tuplaEcocardiograma').each(function () {

                            if ($(this).find('.fechaEcocardiograma').val() != "") {
                                var ecocardiograma = {
                                    id: $(this).data("id"),
                                    accion: $(this).data("accion"),
                                    fecha: $(this).find('.fechaEcocardiograma').val()
                                };
                                ecocardiogramas.push(ecocardiograma);
                                console.log(ecocardiograma);
                            }

                        });
                        console.log("tuplaEcocardiograma");


                        var trabajosSociales = []
                        console.log("tuplaTrabajoSocial");
                        $('.tuplaTrabajoSocial').each(function () {

                            if ($(this).find('.fechaTrabajoSocial').val() != "") {
                                var trabajoSocial = {
                                    id: $(this).data("id"),
                                    accion: $(this).data("accion"),
                                    fecha: $(this).find('.fechaTrabajoSocial').val()
                                };
                                trabajosSociales.push(trabajoSocial);
                                console.log(trabajoSocial);
                            }

                        });
                        console.log("tuplaTrabajoSocial");


                        var programas = [];
                        console.log("tuplaPrograma");
                        $('.tuplaPrograma').each(function () {

                            if ($(this).find('.programa').val() != "" || $(this).find('.fechaPrograma').val() != "") {
                                var programa = {
                                    id: $(this).data("id"),
                                    accion: $(this).data("accion"),
                                    programa: $(this).find('.programa').val(),
                                    fecha: $(this).find('.fechaPrograma').val()
                                };
                                programas.push(programa);
                                console.log(programa);
                            }

                        });
                        console.log("tuplaPrograma");


                        var otrosEstudios = [];
                        console.log("tuplaOtro");
                        $('.tuplaOtro').each(function () {

                            if ($(this).find('.fechaOtro').val() != "" || $(this).find('.otro-estudioPreconsulta').val() != "") {
                                var otroEstudio = {
                                    id: $(this).data("id"),
                                    accion: $(this).data("accion"),
                                    fecha: $(this).find('.fechaOtro').val(),
                                    otroEstudio: $(this).find('.otro-estudioPreconsulta').val()
                                };
                                otrosEstudios.push(otroEstudio);
                                console.log(otroEstudio);
                            }
                        });
                        console.log("tuplaOtro");
                        // OMAR                       
                        console.log("tuplaLlamada");
                        var llamadas = [];
                        $('.tuplaLlamada').each(function () {
                            if ($(this).find('.fecha-llamada').val() != "" || $(this).find('.comentario-llamada').val() != "") {
                                var llamada = {
                                    id: $(this).data("id"),
                                    accion: $(this).data("accion"),
                                    fecha: $(this).find('.fecha-llamada').val(),
                                    motivo: $(this).find('.comentario-llamada').val()
                                };
                                llamadas.push(llamada);
                                console.log(llamada);
                            }
                        });



                        console.log("Comentarios del médico");
                        var comentariosMedico = $("#comentariosAdicionales").val();
                        if (comentariosMedico == null)
                        {
                            comentariosMedico = "";
                        }
                        console.log(comentariosMedico);
                        console.log("Comentarios del médico");

                        var tipoUltrasonidoMama = $('#tipoUltrasonidoMama').val();
                        if (tipoUltrasonidoMama == null)
                            tipoUltrasonidoMama = "";


                        var biradsMasto = $('#ResultadoTipoMastografia').val();
                        if (biradsMasto === null)
                            biradsMasto = "";

                        var biradUSG = $('#tipoUSG').val();
                        if (biradUSG === null)
                            biradUSG = "";

                        var etapaClinica = $("#etapaClinica").val();
                        if (etapaClinica == null)
                            etapaClinica = "";

                        console.log("click on 'btn-save[i]'");

                        var data = new FormData();
                        var form;
                        var dataTemp;
                        var formValues;

                        for (var i = 0; i < 5; i++) {
                            form = $("form")[i];
                            dataTemp = new FormData(form);
                            formValues = dataTemp.entries();
                            while (!(ent = formValues.next()).done) {
                                // ent.value[0] es la 'key' and ent.value[1] es el valor
                                data.append(ent.value[0], ent.value[1]);
                                console.log(ent.value[0] + " : " + ent.value[1]);
                            }
                        }
                        console.log("##########################################################################################");
                        data.append("key", "btn-save");
                        data.append("biopsias", JSON.stringify(biopsias));
                        data.append("rayosxs", JSON.stringify(rayosxs));
                        data.append("ultrasonidos", JSON.stringify(ultrasonidos));
                        data.append("medicinasNucleares", JSON.stringify(medicinasNucleares));
                        data.append("laboratorios", JSON.stringify(laboratorios));
                        data.append("valoraciones", JSON.stringify(valoraciones));
                        data.append("espirometrias", JSON.stringify(espirometrias));
                        data.append("electrocardiogramas", JSON.stringify(electrocardiogramas));
                        data.append("ecocardiogramas", JSON.stringify(ecocardiogramas));
                        data.append("trabajosSociales", JSON.stringify(trabajosSociales));
                        data.append("programas", JSON.stringify(programas));
                        data.append("otrosEstudios", JSON.stringify(otrosEstudios));
                        data.append("comentariosMedico", comentariosMedico);
                        data.append("tipoUltrasonidoMama", tipoUltrasonidoMama);
                        data.append("llamadasCita", JSON.stringify(llamadas));
                        data.append("biradsMasto", biradsMasto);
                        data.append("biradUSG", biradUSG);
                        data.append("cambiarRol", 1);
                        data.append("etapaClinica", etapaClinica);
                        data.append("ResultadoTipoMastografia", resultadoTipoMastografia);
                        data.append("tipoUSG", tipoUSG);
                        data.append("tumorPrimarioT", tumorPrimarioT);
                        data.append("gangliosN", gangliosN);
                        data.append("metastasisM", metastasisM);
                        data.append("resultado-patologia", resultadoPatologia);
                        data.append("grado-histologico", gradoHistologico);
                        data.append("receptor-her2", receptorHer2);
                        data.append("receptor-fish", receptorFish);
                        data.append("receptor-re", receptorRe);
                        data.append("receptor-rp", receptorRp);
                        data.append("ki67", ki67);
                        data.append("otroResultadoPatologiaPost", otroResultadoPatologiaPost);


                        data.forEach((value, key) => {
                            console.log(key + " " + value);
                        });
                        $.ajax({
                            url: "NavegadoraController",
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
                            error: function (request, status, error) {
                                console.log("Enviar datos Error " + request.responseText);
                                console.log("Enviar datos Error status " + status);
                                console.log("Enviar datos Error error" + error);
                                //alert("No enontre el controlador" + status);                               
                            }
                        });




                        //
                    } else {

                    }
                });

    });

    //aprobar
    $('#btn-aprobar').on('click', () => {

        swal({
            title: "¿Estás segura(o)?",
            text: "El documento será guardado como un documento válido y no podrás cambiar ese estatus.",
            icon: "warning",
            closeOnEsc: false,
            closeOnClickOutside: false,
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
                .then((aprobar) => {
                    if (aprobar) {

                        //ajax para aprobar

                        //location.href = "./documentos3.html"
                        var data = {key: "aprobarDocumento"};
                        $.ajax({
                            url: "NavegadoraController",
                            data: data,
                            method: "POST",
                            beforeSend: function () {
                                $('.cargandoAceptarDoc').fadeIn();
                            },
                            complete: function () {
                                $('.cargandoAceptarDoc').fadeOut();
                            },
                            success: function (response) {
                                if (response === "true")
                                {
                                    swal({
                                        icon: 'success',
                                        title: '¡Buen trabajo!',
                                        closeOnEsc: false,
                                        closeOnClickOutside: false,
                                        text: 'Se aprobó con éxito el documento.',
                                        buttons: [, 'Aceptar']
                                    });
                                } else
                                {
                                    swal({
                                        icon: 'error',
                                        title: 'Error',
                                        closeOnEsc: false,
                                        closeOnClickOutside: false,
                                        text: 'Hubo un problema al aprobar el documento.',
                                        buttons: [, 'Aceptar']
                                    });
                                }
                            },
                            error: function (xhr) {
                                //alert(xhr.statusText);
                            }

                        });

                    } else {

                    }
                });

    });

    $("#motivoRechazo").on('click', function () {
        $('#error-camposMotivo').hide();
    });

    var resp;

    //rechazar documento 
    $('#btn-rechazarDocumento').on('click', () => {

        if ($('#motivoRechazo').val().trim().length < 1)
        {
            resp = true;
            $('#error-camposMotivo').show();
        } else {
            resp = false;
            $('#error-camposMotivo').hide();
        }
        //ajax para rechazar
        if (!resp) {

            $.ajax({
                url: "NavegadoraController",
                data: {
                    key: "rechazarDocumento",
                    comentario: $('#motivoRechazo').val()
                },
                beforeSend: function () {
                    $('.cargandoRechazarDoc').fadeIn();
                },
                complete: function () {
                    $('.cargandoRechazarDoc').fadeOut();
                },
                method: "POST",
                success: function (response) {
                    if (response === "true")

                    {
                        swal({
                            icon: 'success',
                            title: '¡Buen trabajo!',
                            text: 'Se rechazó con éxito el documento.',
                            closeOnEsc: false,
                            closeOnClickOutside: false,
                            buttons: [, 'Aceptar'],
                        });
                        $("#btn-aprobar").attr("disabled", "disabled").removeClass("btn-primary").addClass("btn-secondary");
                        $("#btn-rechazar").attr("disabled", "disabled").removeClass("btn-primary").addClass("btn-secondary");
                    } else
                    {
                        swal({
                            icon: 'error',
                            title: 'Error',
                            text: 'Hubo un problema al rechazar el documento.',
                            closeOnEsc: false,
                            closeOnClickOutside: false,
                            buttons: [, 'Aceptar'],
                        });
                    }
                },
                error: function (xhr) {

                }

            });
            $("#modalAgregarComentario").modal('toggle');
        }

    });

    $('#btn-siguiente').on('click', function () {

        var data = {idPacientePotencialAtendido: $('#idPacientePotencialAtendido').val(), idDocumentoInicialVista: $('#idDocumentoInicialVista').val(), key: 1};

        console.log(JSON.stringify(data));

        $.ajax({
            url: 'SAPI',
            method: "POST",
            cache: false,
            data: {
                file: "navegadora/verDocumento.jsp",
                idPacientePotencialAtendido: $('#idPacientePotencialAtendido').val(),
                idDocumentoInicialVista: $('#idDocumentoInicialVista').val(),
                siguiente: 1,
            },
            beforeSend: function () {
                $('.cargandoSiguiente').fadeIn();
            },
            complete: function () {
                $('.cargandoSiguiente').fadeOut();
            },
            success: function (response) {

                if (response == "error") {

                    $("#msj-error").show();

                } else if (response == "todos")
                {
                    console.log("Redireccionar a documentos");
                    $.ajax({
                        url: 'SAPI',
                        method: "POST",
                        cache: false,
                        data: {
                            file: "navegadora/documentos.jsp",
                            idPacientePotencialAtendido: "hola"
                        },
                        beforeSend: function () {
                            $('.cargandoListaDocs').fadeIn();
                        },
                        complete: function () {
                            $('.cargandoListaDocs').fadeOut();
                        },
                        success: function (response) {
                            if (response == "error") {
                                $("#msj-error").show();
                            } else {
                                document.open("text/html", "replace");
                                document.write(response);
                                document.close();
                            }
                        }
                    });
                    swal({
                        title: 'No hay más documentos por revisar.',
                        closeOnEsc: false,
                        closeOnClickOutside: false,
                        buttons: [, 'Aceptar']
                    });

                } else {
                    document.open("text/html", "replace");
                    document.write(response);
                    document.close();
                }
            }
        });
    });


    $('#irADashboard').on('click', function () {
        $.ajax({
            url: 'SAPI',
            method: "POST",
            cache: false,
            data: {
                file: "navegadora/index.jsp",
            },
            beforeSend: function () {
                $('.cargandoIrAInicio').fadeIn();
            },
            complete: function () {
                $('.cargandoIrAInicio').fadeOut();
            },
            success: function (response) {
                if (response == "error") {
                    $("#msj-error").show();
                } else {
                    document.open("text/html", "replace");
                    document.write(response);
                    document.close();
                }
            }
        });

    });

    $('#irACalendario').on('click', function () {
        $.ajax({
            url: 'SAPI',
            method: "POST",
            cache: false,
            data: {
                file: "navegadora/calendar.jsp",
            },
            beforeSend: function () {
                $('.cargandoIrACalendar').fadeIn();
            },
            complete: function () {
                $('.cargandoIrACalendar').fadeOut();
            },
            success: function (response) {
                if (response == "error") {
                    $("#msj-error").show();
                } else {
                    document.open("text/html", "replace");
                    document.write(response);
                    document.close();
                }
            }
        });
    });

    $('#irAEstadisticas').on('click', function () {
        $.ajax({
            url: 'SAPI',
            method: "POST",
            cache: false,
            data: {
                file: "navegadora/rendimiento.jsp",
            },
            beforeSend: function () {
                $('.cargandoIrAEstadisticas').fadeIn();
            },
            complete: function () {
                $('.cargandoIrAEstadisticas').fadeOut();
            },
            success: function (response) {
                if (response === "error") {
                    $("#msj-error").show();
                } else {
                    document.open("text/html", "replace");
                    document.write(response);
                    document.close();
                }
            }
        });
    });

    $('#irACuenta').on('click', function () {
        $.ajax({
            url: 'SAPI',
            method: "POST",
            cache: false,
            data: {
                file: "navegadora/cuentaNavegadora.jsp",
            },
            beforeSend: function () {
                $('.cargandoIrACuenta').fadeIn();
            },
            complete: function () {
                $('.cargandoIrACuenta').fadeOut();
            },
            success: function (response) {
                if (response == "error") {
                    $("#msj-error").show();
                } else {
                    document.open("text/html", "replace");
                    document.write(response);
                    document.close();
                }
            }
        });
    });

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

    var cambioImagen = false;
    var imagenValida = false;

    //EN CUENTA
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

            if (isValidPhoneNumber($("#telefono")) && isValidEmail($("#correo")) && !repiteCorreoCuenta) {

                console.log("Presionó GuardarCambios")
                var form = $("form")[0];
                var data = new FormData(form);
                data.append("key", "cambiarDatos");
                data.forEach((value, key) => {
                    console.log(key + " " + value);
                })


                $.ajax({
                    url: "NavegadoraController",
                    data: data,
                    method: "POST",
                    encType: "multipart/form-data",
                    processData: false,
                    contentType: false,
                    cache: false,
                    beforeSend: function () {
                        $('.cargandoGuardarCambios').fadeIn();
                    },
                    complete: function () {
                        $('.cargandoGuardarCambios').fadeOut();
                    },
                    success: function (response) {

                        swal({
                            title: "¡Buen trabajo!",
                            text: "Cuenta actualizada correctamente.",
                            closeOnEsc: false,
                            closeOnClickOutside: false,
                            icon: "success",
                            button: "Aceptar",
                        })

                        $.post("SAPI", {
                            file: "navegadora/cuentaNavegadora.jsp"
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
                    }, error: function (xhr) {
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
            swal({
                title: "Error",
                text: "Revisa todos los campos antes de continuar.",
                closeOnEsc: false,
                closeOnClickOutside: false,
                icon: "error",
                button: "Aceptar",
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
        if (validProfilePhoto($('#file-input'), document.querySelector('#file-input').files)) {
            $('#error-imgPerfil').hide();
            readURL(this);
        } else {
            $('#error-imgPerfil').show();
        }
    });

    //Cambiar contraseña

    $("#btn-updatePassword").on('click', function () {

        //Modal cambiar contraseña 
        if (isValidPassword($('#password')) && isValidPassword($('#password2')) && areEqualPasswords($('#password'), $('#password2'))) {
            swal({
                title: "¿Estás segura(o) que deseas guardar los cambios de tu contraseña?",
                text: "No podrás volver a usar tu contraseña anterior para ingresar.",
                icon: "warning",
                closeOnEsc: false,
                closeOnClickOutside: false,
                buttons: true,
                buttons: ['Regresar', 'Cambiar contraseña'],
                dangerMode: true
            })
                    .then((cambiar) => {
                        if (cambiar) {
                            $.ajax({
                                url: "NavegadoraController",
                                data: {
                                    key: "cambiarContrasena",
                                    idCuenta: $("#sesionPaciente").val(),
                                    password: $("#password").val(),
                                    password2: $("#password-confirm").val()
                                },
                                method: "POST",
                                success: function (response) {
                                    if (response == "success") {
                                        swal({
                                            title: "¡Buen trabajo!",
                                            text: "Contraseña actualizada.",
                                            icon: "success",
                                            closeOnEsc: false,
                                            closeOnClickOutside: false,
                                            buttons: [, 'Aceptar'],
                                        });
                                        $("#password").val('');
                                        $("#password-confirm").val('');
                                    } else {
                                        //Aqui no se que hace
                                    }
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
        console.log("Cambio la ocntra");
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

    //Cargar los municipios con base en el estado
    $('#estadoNavegadora').on('change', function () {
        $.ajax({
            url: 'ZonaController',
            data: {
                key: "getByEstado",
                idEstado: $('#estadoNavegadora').val()
            },
            method: 'POST',
            success: function (response) {

                //Limpiar el select antes de que haga una consulta para que no se emapalmen los municipios
                $(".municipios select").each(function () {
                    $(this).children().remove();
                });
                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {
                    $('.municipios select').append("<option value=" + json[i].idMunicipio + ">" + json[i].nombre + "</option>");
                }
                $('.municipios select').prop('selectedIndex', 0);
                console.log(json);
            }
        });
    });

    $('#editarEstadoNavegadoraAPaciente').on('change', function () {
        $.ajax({
            url: 'ZonaController',
            data: {
                key: "getByEstado",
                idEstado: $('#editarEstadoNavegadoraAPaciente').val()
            },
            method: 'POST',
            success: function (response) {

                //Limpiar el select antes de que haga una consulta para que no se emapalmen los municipios
                $(".editarMunicipios select").each(function () {
                    $(this).children().remove();
                });
                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {
                    $('.editarMunicipios select').append("<option value=" + json[i].idMunicipio + ">" + json[i].nombre + "</option>");
                }
                $('.editarMunicipios select').prop('selectedIndex', 0);
                console.log(json);
            }
        });
    });

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

    $('#irVerForm').on('click', function () {
        $.post("SAPI", {
            file: "navegadora/form.jsp"
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

    $('.descargarDocumento').on('click', function () {

        $.ajax({
            url: 'NavegadoraController',
            method: "POST",
            cache: false,
            data: {
                key: "descargarArchivo",
                idDocumento: $(this).data('id')
            },
            beforeSend: function () {
                $('.descargarDoc').fadeIn();
            },
            complete: function () {
                $('.descargarDoc').fadeOut();
            },
            success: function (response) {
                if (response == "success") {

                }
            },
            error: function (xhr) {

            }

        });

    });

    $('#irAForm').on('click', function () {
        $.post("SAPI", {
            file: "navegadora/form.jsp"

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


    //VALIDACIONES
    $('#nombrePaciente').on('change', function () {

        if (isValidName($(this))) {
            $('#errorNombrePaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorNombrePaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');

        } else {
            $('#errorNombrePaciente').show();
        }

    });

    //PRIMER APELLIDO EN AGREGAR PACIENTE
    $('#primer-apellidoPaciente').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoPaternoPaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoPaternoPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
        } else {
            $('#errorApellidoPaternoPaciente').show();
        }

    });

    //SEGUNDO APELLIDO EN AGREGAR PACIENTE
    var isValidSegundoApellidoPaciente = true;
    $('#segundo-apellidoPaciente').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoMaternoPaciente').hide();
            isValidSegundoApellidoPaciente = true;
        } else if ($(this).val() == '') {
            $('#errorApellidoMaternoPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
            isValidSegundoApellidoPaciente = true;
        } else {
            $('#errorApellidoMaternoPaciente').show();
            isValidSegundoApellidoPaciente = false;
        }

    });

    var isValidCPPaciente = true;
    $('#codigo-postalPaciente').on('change', function () {
        if (isValidFormatCP($(this))) {
            $('#errorCodigoPostalPaciente').hide();
            isValidCPPaciente = true;
        } else if ($(this).val() == '') {
            $('#errorCodigoPostalPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
            isValidCPPaciente = true;
        } else {
            $('#errorCodigoPostalPaciente').show();
            isValidCPPaciente = false;
        }

    })

    //NOMBRE DE USUARIO EN AGREGAR PACIENTE
    $('#usuarioPaciente').on('change', function () {

        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteUsuario",
                usuario: $('#usuarioPaciente').val()


            },
            success: function (response) {

                if (response == 'UsuarioAlreadyExists') {
                    $('#usuarioPaciente').css('color', 'orange');
                    $('#errorUsuarioRepetidoPaciente').show();
                } else {
                    $('#errorUsuarioRepetidoPaciente').hide();
                    $("#error-datosRepetidosPaciente").hide();
                }

            }

        });

        if (isValidUserName($(this))) {
            $('#errorNombreUsuarioPaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorNombreUsuarioPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
        } else {
            $('#errorNombreUsuarioPaciente').show();
        }

    });


    //CORREO EN AGREGAR PACIENTE 
    var repiteCorreoPaciente;

    $('#correoPaciente').on('change', function () {
        $.ajax({

            url: 'RegistraUsuarioController',
            method: "POST",
            cache: false,
            data: {
                key: "repiteCorreo",
                correo: $('#correoPaciente').val()
            },
            success: function (response) {

                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#correoPaciente').css('color', 'orange');
                    $('#errorCorreoRepetidoPaciente').show();
                    repiteCorreoPaciente = true;
                } else {
                    $('#errorCorreoRepetidoPaciente').hide();
                    $("#error-datosRepetidosPaciente").hide();
                    repiteCorreoPaciente = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#errorCorreoPaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorCorreoPaciente').hide();
            $('#correoPaciente').css('border', '');
            $('#correoPaciente').css('color', '');
        } else {
            $('#errorCorreoPaciente').show();
        }

    });

    //CONTRASEÑA1 EN AGREGAR PACIENTE
    $('#contraPaciente').on('change', function () {

        if (isValidPassword($(this))) {
            $('#errorPass1Paciente').hide();
        } else if ($(this).val() == '') {
            $('#errorPass1Paciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
        } else {
            $('#errorPass1Paciente').show();
        }

    });

    //CONTRASEÑA2 EN AGREGAR PACIENTE
    $('#confContraPaciente').on('change', function () {

        if (areEqualPasswords($('#contraPaciente'), $(this))) {
            $('#noEqualPasswordsErrorPaciente').hide();
        } else if ($(this).val() == '') {
            $('#noEqualPasswordsErrorPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
        } else {
            $('#noEqualPasswordsErrorPaciente').show();
        }

    });

    var curpRepetidoPaciente;
    //CURP EN AGREGAR PACIENTE
    $('#curpPaciente').on('change', function () {

        $.ajax({
            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {
                key: "repiteCurp",
                curp: $('#curpPaciente').val()
            },
            success: function (response) {

                if (response === 'CurpAlreadyExists') {
                    $('#curpPaciente').css('color', 'orange');
                    $('#errorCurpRepetidoPaciente').show();
                    curpRepetidoPaciente = true;
                } else {
                    $('#errorCurpRepetidoPaciente').hide();
                    $("#error-datosRepetidosPaciente").hide();
                    curpRepetidoPaciente = false;
                }
            }
        });

        if (isValidCURP($(this))) {
            $('#errorCurpPaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorCurpPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
        } else {
            $('#errorCurpPaciente').show();
        }
    });

    //TELEFONO EN AGREGAR PACIENTE
    $('#telPaciente').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#errorTelefonoPaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorTelefonoPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
        } else {
            $('#errorTelefonoPaciente').show();
        }

    });

    //ESTADO CIVIL EN AGREGAR PACIENTE
    $('#estado-civilPaciente').on('change', function () {

        if (isValidSelect($(this))) {
            $('#errorECivilPaciente').hide();
        } else {
            $('#errorECivilPaciente').show();
        }

    });

    //FECHA DE NACIMIENTO EN AGREGAR PACIENTE
    $('#cumplePaciente').on('change', function () {

        if (isValidDate($(this))) {
            $('#errorFechaPaciente').hide();
        } else {
            $('#errorFechaPaciente').show();
        }

    });

    //FECHA DE NAVEGACIÓN EN AGREGAR PACIENTE 
    $('#Fecha-Navegacion').on('change', function () {
        if (isPastDate($(this))) {
            $('#errorFechaNavegacion').show();
        } else {
            $('#errorFechaNavegacion').hide();
        }

    });

    //FECHA DE PRECONSULTA EN AGREGAR PACIENTE
    $('#Fecha-Consulta').on('change', function () {
        if (isPastDate($(this))) {
            $('#errorFechaPre').show();
        } else {
            $('#errorFechaPre').hide();
        }
    });


    //ESTADO EN AGREGAR PACIENTE
    $('#estadoPaciente').on('change', function () {

        if (isValidSelect($(this))) {
            $('#errorEstadoPaciente').hide();
        } else {
            $('#errorEstadoPaciente').show();
        }

    });

    //MUNICIPIO EN AGREGAR PACIENTE
    $('#municipioPaciente').on('change', function () {

        if (isValidSelect($(this))) {
            $('#errorMunicipioPaciente').hide();
        } else {
            $('#errorMunicipioPaciente').show();
        }

    });

    //COLONIA EN AGREGAR PACIENTE
    var isValidColPaciente = true;
    $('#colPaciente').on('change', function () {

        if (isValidColonia($(this))) {
            $('#errorColoniaPaciente').hide();
            isValidColPaciente = true;
        } else if ($(this).val() == '') {
            $('#errorColoniaPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
            isValidColPaciente = true;
        } else {
            $('#errorColoniaPaciente').show();
            isValidColPaciente = false;
        }

    });

    //CALLE EN AGREGAR PACIENTE
    var isValidCallePaciente = true;
    $('#callePaciente').on('change', function () {

        if (isValidStreet($(this))) {
            $('#errorCallePaciente').hide();
            isValidCallePaciente = true;
        } else if ($(this).val() == '') {
            $('#errorCallePaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
            isValidCallePaciente = true;
        } else {
            $('#errorCallePaciente').show();
            isValidCallePaciente = false;
        }
    });

    //NUMERO EXTERIOR EN AGREGAR PACIENTE
    var isValidNumExtPaciente = true;
    $('#numExtPaciente').on('change', function () {

        if (isValidExtNumber($(this))) {
            $('#errorNoExteriorPaciente').hide();
            isValidNumExtPaciente = true;
        } else if ($(this).val() == '') {
            $('#errorNoExteriorPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
            isValidNumExtPaciente = true;
        } else {
            $('#errorNoExteriorPaciente').show();
            isValidNumExtPaciente = false;
        }

    });

    //NUMERO INTERIOR EN AGREGAR PACIENTE
    var isValidNumIntPaciente = true;
    $('#numIntPaciente').on('change', function () {

        if (isValidIntNumber($(this))) {
            $('#errorNoInteriorPaciente').hide();
            isValidNumIntPaciente = true;
        } else if ($(this).val() == '') {
            $('#errorNoInteriorPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
            isValidNumIntPaciente = true;
        } else {
            $('#errorNoInteriorPaciente').show();
            isValidNumIntPaciente = false;
        }

    });

    var isValidTerminosPaciente;
    $('#acepto-terminos').on('change', function () {

        if (isValidCheckbox($(this))) {
            $('#error-terminos').hide();
            isValidTerminosPaciente = true;
        } else {
            $('#error-terminos').hide();
            isValidTerminosPaciente = false;
        }

    });

    var isValidExistenciaCP;
    //Codigo Postal en Agregar Paciente
    $('#codigo-postalPaciente').on('change', function () {

        if ($(this).val().length === 0) {
            //Obtener estados
            $.ajax({
                url: 'ZonaController',
                cache: false,
                method: 'POST',
                data: {
                    key: "getEstados"
                },
                success: function (response) {
                    var data = JSON.parse(response);
                    //Limpia los campos de estado 
                    $("#estadoPaciente").each(function () {
                        $(this).children().remove();
                    });
                    //Limpia los campos de municipio 
                    $("#municipioPaciente").each(function () {
                        $(this).children().remove();
                    });
                    //Primera opcion de estado
                    $('#estadoPaciente').append("<option disabled selected>" + "Seleccione un Estado" + "</option>");
                    //Primera opcion de municipio
                    $('#municipioPaciente').append("<option disabled selected>" + "Seleccione un Municipio" + "</option>");
                    for (var i = 0; i < data.length; i++) {
                        //Carga estado
                        $('#estadoPaciente').append("<option value='" + data[i].idEstado + "'>" + data[i].nombre + "</option>");
                    }
                    $('#estadoPaciente').prop('selectedIndex', 0);
                    $('#municipioPaciente').prop('selectedIndex', 0);
                    console.log(data);
                }
            });
        } else if ($(this).val().length === 5) {
            $.ajax({
                url: 'ZonaController',
                cache: false,
                method: 'POST',
                data: {
                    key: "getEstadoyMunicipio",
                    numeroCP: $('#codigo-postalPaciente').val()
                },
                success: function (response) {
                    if (response == 'postalCodeDoesntExist') {
                        $('#error-CPexistePaciente').show();
                        isValidExistenciaCP = false;
                    } else {
                        $('#error-CPexistePaciente').hide();
                        isValidExistenciaCP = true;
                        var json = JSON.parse(response);
                        if ($('#codigo-postalPaciente').val().length === 5) {
                            //Limpia los campos 
                            $("#estadoPaciente").each(function () {
                                $(this).children().remove();
                            });
                            $("#municipioPaciente").each(function () {
                                $(this).children().remove();
                            });
                            //Carga estado
                            $('#estadoPaciente').append("<option value='" + json[0] + "'>" + json[1] + "</option>");
                            //Carga Municipio
                            $('#municipioPaciente').append("<option value='" + json[2] + "'>" + json[3] + "</option>");
                        } else {
                            $('#estadoPaciente').removeAttr('disabled');
                            $('#estadoPaciente').removeAttr('selected');
                        }
                        console.log(json);
                    }
                }
            });
        }
    });

    //Cargar los municipios con base en el estado
    $('#estadoPaciente').on('change', function () {
        $.ajax({
            url: 'ZonaController',
            data: {
                key: "getByEstado",
                idEstado: $('#estadoPaciente').val()
            },
            method: 'POST',
            success: function (response) {

                //Limpiar el select antes de que haga una consulta para que no se emapalmen los municipios
                $(".municipios select").each(function () {
                    $(this).children().remove();
                });
                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {
                    $('.municipios select').append("<option value=" + json[i].idMunicipio + ">" + json[i].nombre + "</option>");
                }
                $('.municipios select').prop('selectedIndex', 0);
                console.log(json);
            }
        });
    });

    //NOMBRE AL EDITAR
    $('#editarNombreNavegadoraAPaciente').on('change', function () {

        if (isValidName($(this))) {
            $('#error-editar-NombrePaciente').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-NombrePaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
        } else {
            $('#error-editar-NombrePaciente').show();
        }

    });

    //PRIMER APELLIDO AL EDITAR PACIENTE
    $('#editarPrimer-apellidoNavegadoraAPaciente').on('change', function () {

        if (isValidLastName($(this))) {
            $('#error-editar-ApellidoPaternoPaciente').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-ApellidoPaternoPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
        } else {
            $('#error-editar-ApellidoPaternoPaciente').show();
        }

    });

    //SEGUNDO APELLIDO AL EDITAR PACIENTE
    var isValidEdit2ApellidoPaciente = true;
    $('#editarSegundo-apellidoNavegadoraAPaciente').on('change', function () {

        if (isValidLastName($(this))) {
            $('#error-editar-ApellidoMaternoPaciente').hide();
            isValidEdit2ApellidoPaciente = true;
        } else if ($(this).val() == '') {
            $('#error-editar-ApellidoMaternoPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
            isValidEdit2ApellidoPaciente = true;
        } else {
            $('#error-editar-ApellidoMaternoPaciente').show();
            isValidEdit2ApellidoPaciente = false;
        }

    });

    var repiteUsuarioPaciente;
    //NOMBRE DE USUARIO AL EDITAR PACIENTE
    $('#editarUsuarioNavegadoraAPaciente').on('change', function () {
        var idPaciente = $('#idPacienteAEditar').val();
        console.log("holaaaaaa");
        console.log("idPaciente: " + idPaciente)
        $.ajax({
            url: 'AdministradorController',
            method: "POST",
            cache: false,
            data: {
                key: "repiteUsuarioEdit",
                usuario: $('#editarUsuarioNavegadoraAPaciente').val(),
                idPaciente: idPaciente
            },
            success: function (response) {

                if (response === 'UsuarioAlreadyExists') {
                    $('#editarUsuarioNavegadoraAPaciente').css('color', 'orange');
                    $('#error-editar-UsuarioRepetidoPaciente').show();
                    repiteUsuarioPaciente = true;
                } else {
                    $('#error-editar-UsuarioRepetidoPaciente').hide();
                    $("#error-editarDatosRepetidosPaciente").hide();
                    repiteUsuarioPaciente = false;
                }

            }

        });

        if (isValidUserName($(this))) {
            $('#error-editar-NombreUsuarioPaciente').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-NombreUsuarioPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
        } else {
            $('#error-editar-NombreUsuarioPaciente').show();
        }

    });

    var repiteCorreo;
    //CORREO AL EDITAR PACIENTE
    $('#editarCorreoNavegadoraAPaciente').on('change', function () {

        var idPaciente = $('#idPacienteAEditar').val();

        $.ajax({
            url: 'AdministradorController',
            cache: false,
            method: 'POST',
            data: {
                key: "repiteCorreoEditPaciente",
                correo: $('#editarCorreoNavegadoraAPaciente').val(),
                idPaciente: idPaciente
            },
            success: function (response) {
                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#editarCorreoNavegadoraAPaciente').css('color', 'orange');
                    $('#errorEditarPacienteCorreoRepetido').show();
                    repiteCorreo = true;
                } else {
                    $('#errorEditarPacienteCorreoRepetido').hide();
                    $("#error-editarDatosRepetidosPaciente").hide();
                    repiteCorreo = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#error-editar-CorreoPaciente').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-CorreoPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
        } else {
            $('#error-editar-CorreoPaciente').show();
        }

    });



    //CURP AL EDITAR PACIENTE
    $('#editarCurpNavegadoraAPaciente').on('change', function () {

        $.ajax({
            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {
                key: "repiteCurp",
                curp: $('#editarCurpNavegadoraAPaciente').val()
            },
            success: function (response) {

                if (response === 'CurpAlreadyExists') {
                    $('#editarCurpNavegadoraAPaciente').css('color', 'orange');
                    $('#error-editar-CurpRepetidoPaciente').show();
                } else {
                    $('#error-editar-CurpRepetidoPaciente').hide();
                }

            }
        });


        if (isValidCURP($(this))) {
            $('#error-editar-CurpPaciente').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-CurpPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
        } else {
            $('#error-editar-CurpPaciente').show();
        }

    });

    //TELEFONO AL EDITAR PACIENTE
    $('#editarTelNavegadoraAPaciente').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#error-editar-TelefonoPaciente').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-TelefonoPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
        } else {
            $('#error-editar-TelefonoPaciente').show();
        }

    });

    //ESTADO CIVIL AL EDITAR PACIENTE
    $('#editarEstado-civilPaciente').on('change', function () {

        if (isValidSelect($(this))) {
            $('#error-editar-ECivilPaciente').hide();
        } else {
            $('#error-editar-ECivilPaciente').show();
        }

    });

    //FECHA DE NACIMIENTO AL EDITAR PACIENTE
    $('#editarCumpleNavegadoraAPaciente').on('change', function () {

        if (isValidDate($(this))) {
            $('#error-editar-FechaPaciente').hide();
        } else {
            $('#error-editar-FechaPaciente').show();
        }

    });

    //ESTADO AL EDITAR PACIENTE
    $('#editarEstadoNavegadoraAPaciente').on('change', function () {

        if (isValidSelect($(this))) {
            $('#error-editar-EstadoPaciente').hide();
        } else {
            $('#error-editar-EstadoPaciente').show();
        }

    });

    //MUNICIPIO AL EDITAR PACIENTE
    $('#editarMunicipioNavegadoraAPaciente').on('change', function () {

        if (isValidSelect($(this))) {
            $('#error-editar-MunicipioPaciente').hide();
        } else {
            $('#error-editar-MunicipioPaciente').show();
        }

    });

    //COLONIA AL EDITAR PACIENTE
    var isValidEditColPaciente = true;
    $('#editarColNavegadoraAPaciente').on('change', function () {

        if (isValidColonia($(this))) {
            $('#error-editar-ColoniaPaciente').hide();
            isValidEditColPaciente = true;
        } else if ($(this).val() == '') {
            $('#error-editar-ColoniaPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
            isValidEditColPaciente = true;
        } else {
            $('#error-editar-ColoniaPaciente').show();
            isValidEditColPaciente = false;
        }

    });

    //CALLE AL EDITAR PACIENTE
    var isValidEditCallePaciente = true;
    $('#editarCalleNavegadoraAPaciente').on('change', function () {

        if (isValidStreet($(this))) {
            $('#error-editar-CallePaciente').hide();
            isValidEditCallePaciente = true;
        } else if ($(this).val() == '') {
            $('#error-editar-CallePaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
            isValidEditCallePaciente = true;
        } else {
            $('#error-editar-CallePaciente').show();
            isValidEditCallePaciente = false;
        }
    });

    //NUMERO EXTERIOR AL EDITAR PACIENTE
    var isValidEditExtNumPaciente = true;
    $('#editarNumExtNavegadoraAPaciente').on('change', function () {

        if (isValidExtNumber($(this))) {
            $('#error-editar-NoExteriorPaciente').hide();
            isValidEditExtNumPaciente = true;
        } else if ($(this).val() == '') {
            $('#error-editar-NoExteriorPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
            isValidEditExtNumPaciente = true;
        } else {
            $('#error-editar-NoExteriorPaciente').show();
            isValidEditExtNumPaciente = false;
        }

    });

    //NUMERO INTERIOR AL EDITAR PACIENTE
    var isValidEditNumIntPaciente = true;
    $('#editarNumIntNavegadoraAPaciente').on('change', function () {

        if (isValidIntNumber($(this))) {
            $('#error-editar-NoInteriorPaciente').hide();
            isValidEditNumIntPaciente = true;
        } else if ($(this).val() == '') {
            $('#error-editar-NoInteriorPaciente').hide();
            $(this).css('border', '');
            $(this).css('color', '');
            isValidEditNumIntPaciente = true;
        } else {
            $('#error-editar-NoInteriorPaciente').show();
            isValidEditNumIntPaciente = false;
        }

    });


    $('#irAForm').on('click', function () {
        $.post("SAPI", {
            file: "navegadora/form.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            console.log(response);
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });


    $('body').on('click', '.btn-ver-formulario', function () {

        console.log($(this).data('id'));
        var data = {idPotencial: $(this).data('id')};
        $.ajax({
            url: 'SAPI',
            method: "POST",
            cache: false,
            data: {
                file: "navegadora/form.jsp",
                idPotencial: $(this).data('id')
            },
            beforeSend: function () {
                $('.cargandoFormulario').fadeIn();
            },
            complete: function () {
                $('.cargandoFormulario').fadeOut();
            },
            success: function (response, status, xhr) {
                if (status == "success") {
                    if (response == "error") {
                        console.log(response);
                    } else {
                        document.open("text/html", "replace");
                        document.write(response);
                        document.close();
                    }
                }
            }
        });
    });

    var cambiarRol = 0;

    //////////////////////////
    /////VALIDACIONES////////
    /////////////////////////

    //**PANTALLA 1

    //PRZ
    $('#prz-expediente').on('change', function () {


        if (!isValidPRZ($(this))) {
            $('#error-PRZ').show();
        } else {
            $('#error-PRZ').hide();
        }
    });


    //fecha navegacion
    $('#fechaNavegacion').on('change', function () {

        if (!isValidDate6months($(this))) {
            $('#error-fechaNavegacion').show();
        } else {
            $('#error-fechaNavegacion').hide();
        }

    });

    //fecha consulta
    $('#fechaConsulta').on('change', function () {

        if (!isValidDate6months($(this))) {
            $('#error-fechaConsulta').show();
        } else {
            $('#error-fechaConsulta').hide();
        }

    });

    //**PANTALLA2

    //fecha consulta
    $('#alergias').on('change', function () {

        if (!isValidAllergy($(this))) {
            $('#error-alergias').show();
        } else {
            $('#error-alergias').hide();
        }

    });

    //numero del seguro
    $('#numSeguro').on('change', function () {

        if (!isValidNumSeguro($(this))) {
            $('#error-numSeguro').show();
        } else {
            $('#error-numSeguro').hide();
        }

    });

    //fecha cirugia
    $('#fecha-cirugia').on('change', function () {

        if (!isValidTratamientoPrevio($(this))) {
            $('#error-fechaCirugia').show();
        } else {
            $('#error-fechaCirugia').hide();
        }

    });

    //fecha quimioterapia
    $('#fecha-quimioterapia').on('change', function () {

        if (!isValidTratamientoPrevio($(this))) {
            $('#error-fechaQuimio').show();
        } else {
            $('#error-fechaQuimio').hide();
        }

    });

    //fecha radioterapia
    $('#fecha-radioterapia').on('change', function () {

        if (!isValidTratamientoPrevio($(this))) {
            $('#error-fechaRadio').show();
        } else {
            $('#error-fechaRadio').hide();
        }

    });

    //numero de ciclos quimioterapia
    $('#quimioterapia').on('change', function () {

        if (!isValidNumCiclos($(this))) {
            $('#error-numCiclosQuimio').show();
        } else {
            $('#error-numCiclosQuimio').hide();
        }

    });

    //numero de ciclos radioterapia
    $('#radioterapia').on('change', function () {

        if (!isValidNumCiclos($(this))) {
            $('#error-numCiclosRadio').show();
        } else {
            $('#error-numCiclosRadio').hide();
        }

    });

    //estudio previo MASTOGRAFIA
    $('#fechaPreMasto').on('change', function () {

        if (!isValidFechaEstudioPrevio($(this))) {
            $('#error-fechaMastografia').show();
        } else {
            $('#error-fechaMastografia').hide();
        }

    });

    //estudio previo ULTRASONIDO
    $('#fechaPreUsg').on('change', function () {

        if (!isValidFechaEstudioPrevio($(this))) {
            $('#error-fechaUltra').show();
        } else {
            $('#error-fechaUltra').hide();
        }

    });

    //Otro resultado de patologia
    $('#OtroResultadoPatologia').on('change', function () {

        if (!isValidAlfanumerico($(this))) {
            $('#error-OtroResultadoPatologia').show();
        } else {
            $('#error-OtroResultadoPatologia').hide();
        }

    });

    //numero de laminillas
    $('#numLaminillas').on('change', function () {

        if (!isValidNumerico($(this))) {
            $('#error-numeroLaminillas').show();
        } else {
            $('#error-numeroLaminillas').hide();
        }

    });

    //serie laminillas
    $('#serieLaminillas').on('change', function () {

        if (!isValidAlfanumerico($(this))) {
            $('#error-serieLaminillas').show();
        } else {
            $('#error-serieLaminillas').hide();
        }

    });

    //numero bloques parafrina
    $('#numBloques').on('change', function () {

        if (!isValidNumerico($(this))) {
            $('#error-numeroParafrina').show();
        } else {
            $('#error-numeroParafrina').hide();
        }

    });

    //serie bloques
    $('#serieBloques').on('change', function () {

        if (!isValidAlfanumerico($(this))) {
            $('#error-serieParafrina').show();
        } else {
            $('#error-serieParafrina').hide();
        }

    });

    //**PANTALLA3

    //Biopsia
    $('body').on('change', '.fechaBiopsia', function () {

        if (!isValidDate6months($(this))) {

            $(this).css('border', "1px solid red");
            $(this).css('color', 'red');

            $(this).parent().parent().append("<span class='text-danger fechaIncorrectaBiopsia'>Fecha Incorrecta</span>");

        } else {


            $(this).css('border', "");
            $(this).css('color', '');

            $(this).parent().parent().find("span.fechaIncorrectaBiopsia").remove();

        }

    });

    //Rayos
    $('body').on('change', '.fechaRayos', function () {

        if (!isValidDate6months($(this))) {

            $(this).css('border', "1px solid red");
            $(this).css('color', 'red');

            $(this).parent().parent().append("<span class='text-danger fechaIncorrectaRayos'>Fecha Incorrecta</span>");

        } else {


            $(this).css('border', "");
            $(this).css('color', '');

            $(this).parent().parent().find("span.fechaIncorrectaRayos").remove();

        }

    });

    //Ultrasonido
    $('body').on('change', '.fechaUltrasonido', function () {

        if (!isValidDate6months($(this))) {

            $(this).css('border', "1px solid red");
            $(this).css('color', 'red');

            $(this).parent().parent().append("<span class='text-danger fechaIncorrectaUltra'>Fecha Incorrecta</span>");

        } else {


            $(this).css('border', "");
            $(this).css('color', '');

            $(this).parent().parent().find("span.fechaIncorrectaUltra").remove();

        }

    });

    //Medicina nuclear
    $('body').on('change', '.fechaMedicinaNuclear', function () {

        if (!isValidDate6months($(this))) {

            $(this).css('border', "1px solid red");
            $(this).css('color', 'red');

            $(this).parent().parent().append("<span class='text-danger fechaIncorrectaMNuclear'>Fecha Incorrecta</span>");

        } else {


            $(this).css('border', "");
            $(this).css('color', '');

            $(this).parent().parent().find("span.fechaIncorrectaMNuclear").remove();

        }

    });

    //Laboratorio
    $('body').on('change', '.fechaLaboratorio', function () {

        if (!isValidDate6months($(this))) {

            $(this).css('border', "1px solid red");
            $(this).css('color', 'red');

            $(this).parent().parent().append("<span class='text-danger fechaIncorrectaMLabo'>Fecha Incorrecta</span>");

        } else {


            $(this).css('border', "");
            $(this).css('color', '');

            $(this).parent().parent().find("span.fechaIncorrectaLabo").remove();

        }

    });

    //Valoracion
    $('body').on('change', '.fechaValoracion', function () {

        if (!isValidDate6months($(this))) {

            $(this).css('border', "1px solid red");
            $(this).css('color', 'red');

            $(this).parent().parent().append("<span class='text-danger fechaIncorrectaValoracion'>Fecha Incorrecta</span>");

        } else {


            $(this).css('border', "");
            $(this).css('color', '');

            $(this).parent().parent().find("span.fechaIncorrectaValoracion").remove();

        }

    });

    //Espirometria
    $('body').on('change', '.fechaEspirometria', function () {

        if (!isValidDate6months($(this))) {

            $(this).css('border', "1px solid red");
            $(this).css('color', 'red');

            $(this).parent().parent().append("<span class='text-danger fechaIncorrectaEspirometria'>Fecha Incorrecta</span>");

        } else {


            $(this).css('border', "");
            $(this).css('color', '');

            $(this).parent().parent().find("span.fechaIncorrectaEspirometria").remove();

        }

    });

    //Electrocardiograma
    $('body').on('change', '.fechaElectrocardiograma', function () {

        if (!isValidDate6months($(this))) {

            $(this).css('border', "1px solid red");
            $(this).css('color', 'red');

            $(this).parent().parent().append("<span class='text-danger fechaIncorrectaElectro'>Fecha Incorrecta</span>");

        } else {


            $(this).css('border', "");
            $(this).css('color', '');

            $(this).parent().parent().find("span.fechaIncorrectaElectro").remove();

        }

    });

    //Ecocardiograma
    $('body').on('change', '.fechaEcocardiograma', function () {

        if (!isValidDate6months($(this))) {

            $(this).css('border', "1px solid red");
            $(this).css('color', 'red');

            $(this).parent().parent().append("<span class='text-danger fechaIncorrectaEco'>Fecha Incorrecta</span>");

        } else {


            $(this).css('border', "");
            $(this).css('color', '');

            $(this).parent().parent().find("span.fechaIncorrectaEco").remove();

        }

    });

    //Trabajo Social
    $('body').on('change', '.fechaTrabajoSocial', function () {

        if (!isValidDate6months($(this))) {

            $(this).css('border', "1px solid red");
            $(this).css('color', 'red');

            $(this).parent().parent().append("<span class='text-danger fechaIncorrectaTSocial'>Fecha Incorrecta</span>");

        } else {


            $(this).css('border', "");
            $(this).css('color', '');

            $(this).parent().parent().find("span.fechaIncorrectaTSocial").remove();

        }

    });

    //Programa
    $('body').on('change', '.fechaPrograma', function () {

        if (!isValidDate6months($(this))) {

            $(this).css('border', "1px solid red");
            $(this).css('color', 'red');

            $(this).parent().parent().append("<span class='text-danger fechaIncorrectaPrograma'>Fecha Incorrecta</span>");

        } else {


            $(this).css('border', "");
            $(this).css('color', '');

            $(this).parent().parent().find("span.fechaIncorrectaPrograma").remove();

        }

    });

    //Otro
    $('body').on('change', '.fechaOtro', function () {

        if (!isValidDate6months($(this))) {

            $(this).css('border', "1px solid red");
            $(this).css('color', 'red');

            $(this).parent().parent().append("<span class='text-danger fechaIncorrectaOtro'>Fecha Incorrecta</span>");

        } else {


            $(this).css('border', "");
            $(this).css('color', '');

            $(this).parent().parent().find("span.fechaIncorrectaOtro").remove();

        }

    });


    //PANTALLA 4

    //Llamada

    $('body').on('change', '.fecha-llamada', function () {

        if (!isValidDate6months($(this))) {

            $(this).parent().parent().find("span.fechaIncorrectaLlamada").remove();

            $(this).css('border', "1px solid red");
            $(this).css('color', 'red');

            $(this).parent().parent().append("<span class='text-danger fechaIncorrectaLlamada'>Fecha Incorrecta</span>");

        } else {


            $(this).css('border', "");
            $(this).css('color', '');

            $(this).parent().parent().find("span.fechaIncorrectaLlamada").remove();

        }

    });

    $('body').on('change', '.comentario-llamada', function () {

        if (!isValidComentarioLlamada($(this))) {

            $(this).parent().parent().find("span.comentarioLlamadaIncorrecto").remove();

            $(this).css('border', "1px solid red");
            $(this).css('color', 'red');

            $(this).parent().parent().append("<span class='text-danger comentarioLlamadaIncorrecto'>El texto excede el limite</span>");

        } else {

            $(this).css('border', "");
            $(this).css('color', '');

            $(this).parent().parent().find("span.comentarioLlamadaIncorrecto").remove();

        }

    });

    //fecha decision de preconsulta
    $('#fecha-decisionPreconsulta').on('change', function () {

        if (!isValidDate6months($(this))) {
            $('#error-fechaDecision').show();
        } else {
            $('#error-fechaDecision').hide();
        }

    });

    //comentario y reporte de incidencias
    $('#comentarioIncidencias').on('change', function () {

        if (!isValidComentarioGeneric($(this))) {
            $('#error-comentarioIncidencias').show();
        } else {
            $('#error-comentarioIncidencias').hide();
        }

    });

    //comentarios adicionales
    $('#comentariosAdicionales').on('change', function () {

        if (!isValidComentarioGeneric($(this))) {
            $('#error-comentarioAdicionales').show();
        } else {
            $('#error-comentarioAdicionales').hide();
        }

    });

    //**PANTALA 5

    //ki67
    $('#ki67').on('change', function () {

        if (!isValidki67($(this))) {
            $('#error-ki67').show();
        } else {
            $('#error-ki67').hide();
        }

    });



    function areValidDynamicDates6Months(dates) {

        for (var i = 0; i < dates.length; i++) {
            console.log("***FECHA***: " + dates[i].value);
            if (!isValidDate6monthsDynamic(dates[i].value))
                return false;
        }

        return true;


    }

    function areValidDynamicNonemptyDates(dates) {

        for (var i = 0; i < dates.length; i++) {

            if (!isValidNonEmptyDynamicDate(dates[i].value))
                return false;
        }

        return true;

    }

    function areValidDynamicSelects(selects) {

        for (var i = 0; i < selects.length; i++) {

            if (!isValidSelectDynamic(selects[i].value))
                return false;
        }

        return true;

    }



    function areValidComentarioLlamada(llamadas) {

        for (var i = 0; i < llamadas.length; i++) {
            if (!isValidComentarioLlamada(llamadas[i].value))
                return false;
        }

        return true;

    }

    // Pantallas del formulario 
    $('#btn-save1, #btn-save2,#btn-save3,#btn-save4,#btn-save5').on('click', function () {

        console.log('*********');

        console.log(document.querySelectorAll('.fechaBiopsia'));
        console.log(document.querySelectorAll('.tipoBiopsia'));

        console.log('*********');


        // OMAR
        var biopsias = [];
        console.log("Biopsia 1");
        $('.tuplaBiopsia').each(function () {
            if ($(this).find('.tipoBiopsia').val() != "" || $(this).find('.fechaBiopsia').val() != "" || $(this).find('.parteCuerpoBiopsia').val() != "") {
                var biopsia = {
                    id: $(this).data("id"),
                    accion: $(this).data("accion"),
                    tipo: $(this).find('.tipoBiopsia').val(),
                    fecha: $(this).find('.fechaBiopsia').val(),
                    lugar: $(this).find('.parteCuerpoBiopsia').val()
                };
                biopsias.push(biopsia);
                console.log(biopsia);
            }
        });


        var rayosxs = [];

        $('.tuplaRayosX').each(function () {
            if ($(this).find('.rayosX').val() != "" || $(this).find('.fechaRayos').val() != "") {
                var rayosx = {
                    id: $(this).data("id"),
                    accion: $(this).data("accion"),
                    tipo: $(this).find('.rayosX').val(),
                    fecha: $(this).find('.fechaRayos').val()
                };
                rayosxs.push(rayosx);
                console.log(rayosx);
            }
        });
        console.log("Rayox x");

        var ultrasonidos = [];
        console.log("Ultrasonido");
        $('.tuplaUltrasonido').each(function () {
            if ($(this).find('.parteCuerpoUltrasonido').val() != "" || $(this).find('.fechaUltrasonido').val() != "") {
                var ultrasonido = {
                    id: $(this).data("id"),
                    accion: $(this).data("accion"),
                    parte: $(this).find('.parteCuerpoUltrasonido').val(),
                    fecha: $(this).find('.fechaUltrasonido').val()
                };

                ultrasonidos.push(ultrasonido);
                console.log(ultrasonido);
            }
        });
        console.log("Ultrasonido");


        var medicinasNucleares = []
        console.log("Medicina Nuclear");
        $('.tuplaMedicinaNuclear').each(function () {


            if ($(this).find('.medicinaNuclear').val() != "" || $(this).find('.fechaMedicinaNuclear').val() != "") {
                var medicinaNuclear = {
                    id: $(this).data("id"),
                    accion: $(this).data("accion"),
                    medicinaNuclear: $(this).find('.medicinaNuclear').val(),
                    fecha: $(this).find('.fechaMedicinaNuclear').val()
                };
                console.log(medicinaNuclear);
                medicinasNucleares.push(medicinaNuclear);
            }
        });
        console.log("Medicina Nuclear");


        var laboratorios = [];
        console.log("tuplaLaboratorio");
        $('.tuplaLaboratorio').each(function () {

            if ($(this).find('.fechaLaboratorio').val() != "") {
                var laboratorio = {
                    id: $(this).data("id"),
                    accion: $(this).data("accion"),
                    fecha: $(this).find('.fechaLaboratorio').val()
                };
                laboratorios.push(laboratorio);
                console.log(laboratorio);
            }

        });
        console.log("tuplaLaboratorio");


        var valoraciones = [];
        console.log("tuplaValoracion");
        $('.tuplaValoracion').each(function () {
            if ($(this).find('.valoracion').val() != "" || $(this).find('.fechaValoracion').val() != "") {
                var valoracion = {
                    id: $(this).data("id"),
                    accion: $(this).data("accion"),
                    valoracion: $(this).find('.valoracion').val(),
                    fecha: $(this).find('.fechaValoracion').val()
                };
                valoraciones.push(valoracion);
                console.log(valoracion);
            }
        });
        console.log("tuplaValoracion");


        var espirometrias = [];
        console.log("tuplaEspirometria");
        $('.tuplaEspirometria').each(function () {

            if ($(this).find('.fechaEspirometria').val() != "") {
                var espirometria = {
                    id: $(this).data("id"),
                    accion: $(this).data("accion"),
                    fecha: $(this).find('.fechaEspirometria').val()
                };
                espirometrias.push(espirometria);
                console.log(espirometria);
            }
        });
        console.log("tuplaEspirometria");


        var electrocardiogramas = [];
        console.log("tuplaElectrocardiograma");
        $('.tuplaElectrocardiograma').each(function () {

            if ($(this).find('.fechaElectrocardiograma').val() != "") {
                var electrocardiograma = {
                    id: $(this).data("id"),
                    accion: $(this).data("accion"),
                    fecha: $(this).find('.fechaElectrocardiograma').val()
                };
                electrocardiogramas.push(electrocardiograma);
                console.log(electrocardiograma);
            }
        });
        console.log("tuplaElectrocardiograma");


        var ecocardiogramas = [];
        console.log("tuplaEcocardiograma");
        $('.tuplaEcocardiograma').each(function () {

            if ($(this).find('.fechaEcocardiograma').val() != "") {
                var ecocardiograma = {
                    id: $(this).data("id"),
                    accion: $(this).data("accion"),
                    fecha: $(this).find('.fechaEcocardiograma').val()
                };
                ecocardiogramas.push(ecocardiograma);
                console.log(ecocardiograma);
            }
        });
        console.log("tuplaEcocardiograma");


        var trabajosSociales = []
        console.log("tuplaTrabajoSocial");
        $('.tuplaTrabajoSocial').each(function () {

            if ($(this).find('.fechaTrabajoSocial').val() != "") {
                var trabajoSocial = {
                    id: $(this).data("id"),
                    accion: $(this).data("accion"),
                    fecha: $(this).find('.fechaTrabajoSocial').val()
                };
                trabajosSociales.push(trabajoSocial);
                console.log(trabajoSocial);
            }
        });
        console.log("tuplaTrabajoSocial");


        var programas = [];
        console.log("tuplaPrograma");
        $('.tuplaPrograma').each(function () {

            if ($(this).find('.programa').val() != "" || $(this).find('.fechaPrograma').val() != "") {
                var programa = {
                    id: $(this).data("id"),
                    accion: $(this).data("accion"),
                    programa: $(this).find('.programa').val(),
                    fecha: $(this).find('.fechaPrograma').val()
                };
                programas.push(programa);
                console.log(programa);
            }
        });
        console.log("tuplaPrograma");


        var otrosEstudios = [];
        console.log("tuplaOtro");
        $('.tuplaOtro').each(function () {
            if ($(this).find('.fechaOtro').val() != "" || $(this).find('.otro-estudioPreconsulta').val() != "") {
                var otroEstudio = {
                    id: $(this).data("id"),
                    accion: $(this).data("accion"),
                    fecha: $(this).find('.fechaOtro').val(),
                    otroEstudio: $(this).find('.otro-estudioPreconsulta').val()
                };
                otrosEstudios.push(otroEstudio);
                console.log(otroEstudio);
            }
        });

        console.log("tuplaLlamada");
        var llamadas = [];
        $('.tuplaLlamada').each(function () {
            if ($(this).find('.fecha-llamada').val() != "" || $(this).find('.comentario-llamada').val() != "") {
                var llamada = {
                    id: $(this).data("id"),
                    accion: $(this).data("accion"),
                    fecha: $(this).find('.fecha-llamada').val(),
                    motivo: $(this).find('.comentario-llamada').val()
                };
                llamadas.push(llamada);
                console.log(llamada);
            }
        });



        console.log("Comentarios del médico");
        var comentariosMedico = $("#comentariosAdicionales").val();
        if (comentariosMedico == null)
        {
            comentariosMedico = "";
        }
        console.log(comentariosMedico);
        console.log("Comentarios del médico");

        var tipoUltrasonidoMama = $('#tipoUltrasonidoMama').val();
        if (tipoUltrasonidoMama == null)
            tipoUltrasonidoMama = "";

        var biradsMasto = $('#ResultadoTipoMastografia').val();
        if (biradsMasto === null)
            biradsMasto = "";

        var biradUSG = $('#tipoUSG').val();
        if (biradUSG === null)
            biradUSG = "";


        var etapaClinica = $("#etapaClinica").val();
        if (etapaClinica == null)
            etapaClinica = "";

        var resultadoTipoMastografia = $("#ResultadoTipoMastografia").val();
        if (resultadoTipoMastografia == null)
            resultadoTipoMastografia = "";

        var tipoUSG = $("#tipoUSG").val();
        if (tipoUSG == null)
            tipoUSG = "";

        var tumorPrimarioT = $("#tumorPrimarioT").val();
        if (tumorPrimarioT == null)
            tumorPrimarioT = "";

        var gangliosN = $("#gangliosN").val();
        if (gangliosN == null)
            gangliosN = "";

        var metastasisM = $("#metastasisM").val();
        if (metastasisM == null)
            metastasisM = "";

        var resultadoPatologia = $("#resultado-patologia").val();
        if (resultadoPatologia == null)
            resultadoPatologia = "";

        var gradoHistologico = $("#grado-histologico").val();
        if (gradoHistologico == null)
            gradoHistologico = "";

        var receptorHer2 = $("#receptor-her2").val();
        if (receptorHer2 == null)
            receptorHer2 = "";

        var receptorFish = $("#receptor-fish").val();

        if (receptorFish == null)
            receptorFish = "";

        var receptorRe = $("#receptor-re").val();
        if (receptorRe == null)
            receptorRe = "";

        var receptorRp = $("#receptor-rp").val();
        if (receptorRp == null)
            receptorRp = "";

        var ki67 = $("#ki67").val();
        if (ki67 == null)
            ki67 = "";

        var otroResultadoPatologiaPost = $("#otroResultadoPatologiaPost").val();
        if (otroResultadoPatologiaPost == null)
            otroResultadoPatologiaPost = "";
        console.log("click on 'btn-save[i]'");



        var data = new FormData();
        var form;
        var dataTemp;
        var formValues;

        for (var i = 0; i < 5; i++) {
            form = $("form")[i];
            dataTemp = new FormData(form);
            formValues = dataTemp.entries();
            while (!(ent = formValues.next()).done) {
                // ent.value[0] es la 'key' and ent.value[1] es el valor
                data.append(ent.value[0], ent.value[1]);
                console.log(ent.value[0] + " : " + ent.value[1]);
            }
        }
        console.log("##########################################################################################");
        data.append("key", "btn-save");
        data.append("biopsias", JSON.stringify(biopsias));
        data.append("rayosxs", JSON.stringify(rayosxs));
        data.append("ultrasonidos", JSON.stringify(ultrasonidos));
        data.append("medicinasNucleares", JSON.stringify(medicinasNucleares));
        data.append("laboratorios", JSON.stringify(laboratorios));
        data.append("valoraciones", JSON.stringify(valoraciones));
        data.append("espirometrias", JSON.stringify(espirometrias));
        data.append("electrocardiogramas", JSON.stringify(electrocardiogramas));
        data.append("ecocardiogramas", JSON.stringify(ecocardiogramas));
        data.append("trabajosSociales", JSON.stringify(trabajosSociales));
        data.append("programas", JSON.stringify(programas));
        data.append("otrosEstudios", JSON.stringify(otrosEstudios));
        data.append("comentariosMedico", comentariosMedico);
        data.append("tipoUltrasonidoMama", tipoUltrasonidoMama);
        data.append("llamadasCita", JSON.stringify(llamadas));
        data.append("biradsMasto", biradsMasto);
        data.append("biradUSG", biradUSG);
        data.append("etapaClinica", etapaClinica);
        data.append("ResultadoTipoMastografia", resultadoTipoMastografia);
        data.append("tipoUSG", tipoUSG);
        data.append("tumorPrimarioT", tumorPrimarioT);
        data.append("gangliosN", gangliosN);
        data.append("metastasisM", metastasisM);
        data.append("resultado-patologia", resultadoPatologia);
        data.append("grado-histologico", gradoHistologico);
        data.append("receptor-her2", receptorHer2);
        data.append("receptor-fish", receptorFish);
        data.append("receptor-re", receptorRe);
        data.append("receptor-rp", receptorRp);
        data.append("ki67", ki67);
        data.append("otroResultadoPatologiaPost", otroResultadoPatologiaPost);


        if (cambiarRol === 1)
            data.append("cambiarRol", cambiarRol);
        data.forEach((value, key) => {
            console.log(key + " " + value);
        });

        /////MEGA IF
        if (isValidDate6months($('#fechaNavegacion')) && isValidDate6months($('#fechaConsulta')) &&
                isValidAllergy($('#alergias')) && isValidNumSeguro($('#numSeguro')) && isValidTratamientoPrevio($('#fecha-cirugia')) &&
                isValidTratamientoPrevio($('#fecha-quimioterpia')) &&
                isValidNumCiclos($('#quimioterapia')) && isValidNumCiclos($('#radioterapia'))
                && isValidFechaEstudioPrevio($('#fechaPreMasto')) && isValidFechaEstudioPrevio($('#fechaPreUsg'))
                && isValidAlfanumerico($('#OtroResultadoPatologia')) && isValidNumerico($('#numLaminillas'))
                && isValidAlfanumerico($('#serieLaminillas')) && isValidNumerico($('#numBloques'))
                && isValidAlfanumerico($('#serieBloques')) && areValidDynamicDates6Months(document.querySelectorAll(".fechaBiopsia"))
                && areValidDynamicDates6Months(document.querySelectorAll(".fechaRayos")) && areValidDynamicDates6Months(document.querySelectorAll(".fechaUltrasonido"))
                && areValidDynamicDates6Months(document.querySelectorAll(".fechaMedicinaNuclear")) && areValidDynamicDates6Months(document.querySelectorAll(".fechaLaboratorio"))
                && areValidDynamicDates6Months(document.querySelectorAll(".fechaValoracion")) && areValidDynamicDates6Months(document.querySelectorAll(".fechaEspirometria"))
                && areValidDynamicDates6Months(document.querySelectorAll(".fechaElectrocardiograma")) && areValidDynamicDates6Months(document.querySelectorAll(".fechaEcocardiograma"))
                && areValidDynamicDates6Months(document.querySelectorAll(".fechaTrabajoSocial")) && areValidDynamicDates6Months(document.querySelectorAll(".fechaPrograma"))
                && areValidDynamicDates6Months(document.querySelectorAll(".fechaOtro")) && areValidDynamicDates6Months(document.querySelectorAll(".fecha-llamada"))
                && areValidComentarioLlamada(document.querySelectorAll(".comentario-llamada")) && isValidDate6months($('#fecha-decisionPreconsulta'))
                && isValidComentarioGeneric($('#comentarioIncidencias')) && isValidComentarioGeneric($('#comentariosAdicionales'))
                && isValidki67($('#ki67'))) {

            //alert('pase el primer if');

            var seguroPopular = true;

            //PANTALLA 1

            //****Verificar que si marco que tiene seguro popular introduzca el numero del seguro
            if (parseInt($('.tiene-seguro option:selected').val()) == 1) {

                if ($('#numSeguro').val().length == 0) {

                    seguroPopular = false;

                    $('#numSeguro').css('border', '1px solid red');
                    $('#numSeguro').css('color', 'red');

                } else {
                    seguroPopular = true;
                    $('#numSeguro').css('border', '');
                    $('#numSeguro').css('color', '');
                }

            }

            //PANTALLA 2

            //****Verificar que si marco algun check de tratamiento previo haya completado los dos primeros campos

            var tratamientoCirugia = true;
            var tratamientoQuimioterapia = true;
            var tratamientoRadioterapia = true;

            //1.- Cirugia
            if ($('#tiene-cirugia').is(':checked')) {

                if (!isValidNonEmptyDate($('#fecha-cirugia')) || !isValidSelect($('#cirugia'))) {

                    tratamientoCirugia = false;

                } else {

                    tratamientoCirugia = true;
                }

            }

            //2.- Quimioterapia
            if ($('#tiene-quimioterapia').is(':checked')) {

                if (!isValidNonEmptyDate($('#fecha-quimioterapia')) || !isValidSelect($('#quimioterapia'))) {
                    tratamientoQuimioterapia = false;
                } else {
                    tratamientoQuimioterapia = true;
                }

            }


            //3.- Radioterapia
            if ($('#tiene-radioterapia').is(':checked')) {

                if (!isValidNonEmptyDate($('#fecha-radioterapia')) || !isValidSelect($('#radioterapia'))) {
                    tratamientoRadioterapia = false;
                } else {
                    tratamientoRadioterapia = true;
                }

            }

            //****Verificar que si marco algun check de estudios previos haya completado todos los campos

            var estudioMastografia = true;
            var estudioUltrasonido = true;

            //1.- Mastrografia
            if ($('#tiene-mastografia').is(':checked')) {

                if (!isValidNonEmptyDate($('#fechaPreMasto')) || !isValidSelect($('#tipoMastografia'))) {
                    estudioMastografia = false;
                } else {
                    estudioMastografia = true;
                }

            }

            //2.- Ultrasonido
            if ($('#tiene-ultrasonido-mama').is(':checked')) {

                if (!isValidNonEmptyDate($('#fechaPreUsg')) || !isValidSelect($('#tipoUltrasonidoMama'))) {
                    estudioUltrasonido = false;
                } else {
                    estudioUltrasonido = true;
                }

            }

            //****Verificar que selecciono otro en resultado o reporte de patologia tiene que completar el input

            var otroResultadoPatologia = true;

            if (parseInt($('#resultadoAnterior-patologia option:selected').val()) == 16) {

                if ($('#OtroResultadoPatologia').val().length == 0) {

                    otroResultadoPatologia = false;

                    $('#OtroResultadoPatologia').css('border', '1px solid red');
                    $('#OtroResultadoPatologia').css('color', 'red');

                } else {

                    otroResultadoPatologia = true;

                    $('#OtroResultadoPatologia').css('border', '');
                    $('#OtroResultadoPatologia').css('color', '');

                }

            }

            //****Verificar que si esta marcado laminillas o bloques, tiene que poner un resultado o reporte de patologia

            var pusoResultadoPatologia = true;

            if ($('#entregaLaminillas').is(':checked') || $('#entregaBloques').is(':checked')) {

                if (!isValidSelect($('#resultadoAnterior-patologia'))) {
                    pusoResultadoPatologia = false;
                } else {
                    pusoResultadoPatologia = true;
                }

            }

            //PANTALLA 3

            var ePreconsultaBiopsia = true;
            var ePreconsultaRayos = true;
            var ePreconsultaUltrasonido = true;
            var ePreconsultaMedicinaNuclear = true;
            var ePreconsultaLaboratorio = true;
            var ePreconsultaValoracion = true;
            var ePreconsultaEspirometria = true;
            var ePreconsultaElectrocardiograma = true;
            var ePreconsultaEcocardiograma = true;
            var ePreconsultaTrabajoSocial = true;
            var ePreconsultaPrograma = true;
            var ePreconsultaOtro = true;

            //biopsia
            if ($('#tiene-biopsia').is(':checked')) {

                if (!areValidDynamicNonemptyDates(document.querySelectorAll('.fechaBiopsia')) || !areValidDynamicSelects(document.querySelectorAll('.tipoBiopsia'))) {
                    $('#biopsia-contenedor').find('span.error-datosFaltantesBiopsia').remove();
                    ePreconsultaBiopsia = false;
                    $('#biopsia-contenedor').append('<span class="text-danger error-datosFaltantesBiopsia">Completa todo los tipos de cuerpo y las fechas para continuar</span>');
                } else {
                    ePreconsultaBiopsia = true;
                    $('#biopsia-contenedor').find('span.error-datosFaltantesBiopsia').remove();
                }

            }

            //rayos x
            if ($('#tiene-rayosX').is(':checked')) {

                if (!areValidDynamicNonemptyDates(document.querySelectorAll('.fechaRayos')) || !areValidDynamicSelects(document.querySelectorAll('.rayosX'))) {
                    $('#rayos-contenedor').find('span.error-datosFaltantesRayos').remove();
                    ePreconsultaRayos = false;
                    $('#rayos-contenedor').append('<span class="text-danger error-datosFaltantesRayos">Completa todo los campos para continuar</span>');
                } else {
                    ePreconsultaRayos = true;
                    $('#rayos-contenedor').find('span.error-datosFaltantesRayos').remove();
                }

            }

            //ultrasonido
            if ($('#tiene-ultrasonido').is(':checked')) {

                if (!areValidDynamicNonemptyDates(document.querySelectorAll('.fechaUltrasonido')) || !areValidDynamicSelects(document.querySelectorAll('.parteCuerpoUltrasonido'))) {
                    $('#ultrasonido-contenedor').find('span.error-datosFaltantesUltrasonido').remove();
                    ePreconsultaUltrasonido = false;
                    $('#ultrasonido-contenedor').append('<span class="text-danger error-datosFaltantesUltrasonido">Completa todo los campos para continuar</span>');
                } else {
                    ePreconsultaUltrasonido = true;
                    $('#ultrasonido-contenedor').find('span.error-datosFaltantesUltrasonido').remove();
                }

            }

            //medicina nuclear
            if ($('#tiene-medicina-nuclear').is(':checked')) {

                if (!areValidDynamicNonemptyDates(document.querySelectorAll('.fechaMedicinaNuclear')) || !areValidDynamicSelects(document.querySelectorAll('.medicinaNuclear'))) {
                    $('#medicinaNuclear-contenedor').find('span.error-datosFaltantesMedicinaNuclear').remove();
                    ePreconsultaMedicinaNuclear = false;
                    $('#medicinaNuclear-contenedor').append('<span class="text-danger error-datosFaltantesMedicinaNuclear">Completa todo los campos para continuar</span>');
                } else {
                    ePreconsultaMedicinaNuclear = true;
                    $('#medicinaNuclear-contenedor').find('span.error-datosFaltantesMedicinaNuclear').remove();
                }

            }

            //laboratorio
            if ($('#tiene-laboratorio').is(':checked')) {

                if (!areValidDynamicNonemptyDates(document.querySelectorAll('.fechaLaboratorio'))) {
                    $('#laboratorio-contenedor').find('span.error-datosFaltantesLaboratorio').remove();
                    ePreconsultaLaboratorio = false;
                    $('#laboratorio-contenedor').append('<span class="text-danger error-datosFaltantesLaboratorio">Completa todo los campos para continuar</span>');
                } else {
                    ePreconsultaLaboratorio = true;
                    $('#laboratorio-contenedor').find('span.error-datosFaltantesLaboratorio').remove();
                }

            }

            //valoracion
            if ($('#tiene-valoracion').is(':checked')) {

                if (!areValidDynamicNonemptyDates(document.querySelectorAll('.fechaValoracion')) || !areValidDynamicSelects(document.querySelectorAll('.valoracion'))) {
                    $('#valoracion-contenedor').find('span.error-datosFaltantesValoracion').remove();
                    ePreconsultaValoracion = false;
                    $('#valoracion-contenedor').append('<span class="text-danger error-datosFaltantesValoracion">Completa todo los campos para continuar</span>');
                } else {
                    ePreconsultaValoracion = true;
                    $('#valoracion-contenedor').find('span.error-datosFaltantesValoracion').remove();
                }

            }

            //espirometria
            if ($('#tiene-espirometria').is(':checked')) {

                if (!areValidDynamicNonemptyDates(document.querySelectorAll('.fechaEspirometria'))) {
                    $('#espirometria-contenedor').find('span.error-datosFaltantesEspirometria').remove();
                    ePreconsultaEspirometria = false;
                    $('#espirometria-contenedor').append('<span class="text-danger error-datosFaltantesEspirometria">Completa todo los campos para continuar</span>');
                } else {
                    ePreconsultaEspirometria = true;
                    $('#espirometria-contenedor').find('span.error-datosFaltantesEspirometria').remove();
                }

            }

            //electrocardiograma
            if ($('#tiene-electrocardiograma').is(':checked')) {

                if (!areValidDynamicNonemptyDates(document.querySelectorAll('.fechaElectrocardiograma'))) {
                    $('#electrocardiograma-contenedor').find('span.error-datosFaltantesElectrocardiograma').remove();
                    ePreconsultaElectrocardiograma = false;
                    $('#electrocardiograma-contenedor').append('<span class="text-danger error-datosFaltantesElectrocardiograma">Completa todo los campos para continuar</span>');
                } else {
                    ePreconsultaElectrocardiograma = true;
                    $('#electrocardiograma-contenedor').find('span.error-datosFaltantesElectrocardiograma').remove();
                }

            }

            //ecocardiograma
            if ($('#tiene-ecocardiograma').is(':checked')) {

                if (!areValidDynamicNonemptyDates(document.querySelectorAll('.fechaEcocardiograma'))) {
                    $('#ecocardiograma-contenedor').find('span.error-datosFaltantesEcocardiograma').remove();
                    ePreconsultaEcocardiograma = false;
                    $('#ecocardiograma-contenedor').append('<span class="text-danger error-datosFaltantesEcocardiograma">Completa todo los campos para continuar</span>');
                } else {
                    ePreconsultaEcocardiograma = true;
                    $('#ecocardiograma-contenedor').find('span.error-datosFaltantesEcocardiograma').remove();
                }

            }

            //trabajo social
            if ($('#tiene-trabajo-social').is(':checked')) {

                if (!areValidDynamicNonemptyDates(document.querySelectorAll('.fechaTrabajoSocial'))) {
                    $('#trabajoSocial-contenedor').find('span.error-datosFaltantesTrabajoSocial').remove();
                    ePreconsultaTrabajoSocial = false;
                    $('#trabajoSocial-contenedor').append('<span class="text-danger error-datosFaltantesTrabajoSocial">Completa todo los campos para continuar</span>');
                } else {
                    ePreconsultaTrabajoSocial = true;
                    $('#trabajoSocial-contenedor').find('span.error-datosFaltantesTrabajoSocial').remove();
                }

            }

            //programa
            if ($('#tiene-programa').is(':checked')) {

                if (!areValidDynamicNonemptyDates(document.querySelectorAll('.fechaPrograma')) || !areValidDynamicSelects(document.querySelectorAll('.programa'))) {
                    $('#programa-contenedor').find('span.error-datosFaltantesPrograma').remove();
                    ePreconsultaPrograma = false;
                    $('#programa-contenedor').append('<span class="text-danger error-datosFaltantesPrograma">Completa todo los campos para continuar</span>');
                } else {
                    ePreconsultaPrograma = true;
                    $('#programa-contenedor').find('span.error-datosFaltantesPrograma').remove();
                }

            }

            //otro
            if ($('#tiene-otro').is(':checked')) {

                if (!areValidDynamicNonemptyDates(document.querySelectorAll('.fechaOtro')) || !areValidDynamicSelects(document.querySelectorAll('.otro-estudioPreconsulta'))) {
                    $('#otro-contenedor').find('span.error-datosFaltantesOtro').remove();
                    ePreconsultaOtro = false;
                    $('#otro-contenedor').append('<span class="text-danger error-datosFaltantesOtro">Completa todo los campos para continuar</span>');
                } else {
                    ePreconsultaOtro = true;
                    $('#otro-contenedor').find('span.error-datosFaltantesOtro').remove();
                }

            }

            //* Verificar que los inputs coincidan con los autocompletados



            if (seguroPopular && tratamientoCirugia && tratamientoQuimioterapia && tratamientoRadioterapia
                    && estudioMastografia && estudioUltrasonido && otroResultadoPatologia && ePreconsultaBiopsia
                    && ePreconsultaRayos && ePreconsultaUltrasonido && ePreconsultaMedicinaNuclear && ePreconsultaLaboratorio
                    && ePreconsultaValoracion && ePreconsultaEspirometria && ePreconsultaElectrocardiograma
                    && ePreconsultaEcocardiograma && ePreconsultaTrabajoSocial && ePreconsultaPrograma && ePreconsultaOtro
                    && pusoResultadoPatologia) {
                swal("Felicidades!", "Se puede enviar todo!", "success");
                btnSave(data);
            } else {
                swal({
                    title: "Error",
                    text: "Verifica que hayas completado todos los datos.",
                    icon: "error",
                    closeOnEsc: false,
                    closeOnClickOutside: false,
                    button: "Aceptar",
                });
            }


        } else {
            swal({
                title: "Error",
                text: "Hay datos incorrectos o faltantes.",
                icon: "error",
                closeOnEsc: false,
                closeOnClickOutside: false,
                button: "Aceptar",
            });
        }



    });

    function btnSave(data) {
        $.ajax({
            url: "NavegadoraController",
            beforeSend: function () {
                $('.cargandoGuardarCambiosFormulario').fadeIn();
            },
            complete: function () {
                $('.cargandoGuardarCambiosFormulario').fadeOut();
            },
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
            error: function (request, status, error) {
                console.log("Enviar datos Error " + request.responseText);
                console.log("Enviar datos Error status " + status);
                console.log("Enviar datos Error error" + error);
                //alert("No enontre el controlador" + status);                               
            }
        });

    }


    $('body').on('click', '.btn-perder-cita', function () {
        var idPotencial = $(this).data('id');
        
        alert(idPotencial);

        swal({
            title: '¿Estás segura(o) de cancelar las citas de navegación y preconsulta?',
            text: "La paciente tendrá que solicitar una nueva cita de navegación y preconsulta.",
            icon: 'warning',
            closeOnEsc: false,
            closeOnClickOutside: false,
            buttons: ["Cancelar", "Aceptar"]

        }).then((result) => {

            if (result === true) {

                $.ajax({

                    url: 'NavegadoraController',
                    cache: false,
                    method: 'POST',
                    data: {
                        key: 'cancelarCitaPotencial',
                        idPotencial: idPotencial
                    },
                    beforeSend: function () {
                        $('.cancelarCitas').fadeIn();
                    },
                    complete: function () {
                        $('.cancelarCitas').fadeOut();
                    },
                    success: function (response) {
                        console.log(response);
                        if (response == 0)
                        {
                            swal({
                                title: "Error",
                                text: "Ha habido un error al cancelar las citas de navegación y preconsulta.",
                                icon: "error",
                                closeOnEsc: false,
                                closeOnClickOutside: false,
                                button: "Aceptar",
                            });
                        } else
                        {
                            swal({
                                title: "¡Buen trabajo!",
                                text: "Se cancelaron correctamente las citas de navegación y preconsulta.",
                                icon: "success",
                                button: "Aceptar",
                                closeOnEsc: false,
                                closeOnClickOutside: false,
                            });

                            $("#estadoCita-" + idPotencial).html("Cancelada");
                                                                
                            $("#cancelarCita-" + idPotencial).removeClass('btn-perder-cita');
                            $("#cancelarCita-" + idPotencial).addClass('btn-comentario-cita');                     
                            $("#cancelarCita-" + idPotencial).html("");
                            $("#cancelarCita-" + idPotencial).append("<i class='far fa-comment-alt'></i>");

                        }
                    }
                });
            }
        });
    });

    $('body').on('click', '.btn-comentario-cita', function () {
        var idPotencial = $(this).data('id');;
        
        alert("hola");
        $("#cancelarCita-" + idPotencial).attr('data-target' , '#modalComentarioCita');

        $.ajax({
            url: 'NavegadoraController',
            cache: false,
            method: 'POST',
            data: {
                key: 'comentarioCancelacionCita',
                idPaciente: idPotencial
            },
            success: function (response) {
                if (response != "SinComentario") {
                    $('#motivoRechazo').val(response);                    
                }                
            }
        });
    });

    var data = new FormData();
    data.append("key", "mostrarFormularioNavegadora");

    $.ajax({
        url: "NavegadoraController",
        method: "POST",
        data: {key: "mostrarFormularioNavegadora"},
        beforeSend: function () {
            $('.CargandoFormulario').fadeIn();
        },
        complete: function () {
            $('.CargandoFormulario').fadeOut();
            //alert("YA CARGÓ!");
        },
        success: function (response) {

            var data = JSON.parse(response);

            console.log(data);
            // console.log(data[0][0].medicoRadiologo);
// Primera pagina formulario

            if (data[0][0].prz !== 0)
                $('#prz-expediente').val(data[0][0].prz);

            if (data[0][0].tipoPaciente !== "") {
                if (data[0][0].tipoPaciente === true) {
                    $('#tipoPaciente option:contains(' + "Segunda opinión" + ')').each(function () {
                        if ($(this).text() === "Segunda opinión") {
                            $(this).attr('selected', 'selected');
                        }

                    });
                } else {
                    $('#tipoPaciente option:contains(' + "Primera vez" + ')').each(function () {
                        if ($(this).text() === "Primera vez") {
                            $(this).attr('selected', 'selected');
                        }

                    });
                }
            }
            if (data[0][0].medicoAdscrito !== "") {
                $('#medico-adscrito option:contains(' + $.trim(data[0][0].medicoAdscrito) + ')').each(function () {

                    if ($.trim($(this).text()) === $.trim(data[0][0].medicoAdscrito)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }
            if (data[0][0].medicoRadiologo !== "") {
                $('#medico-radiologo option:contains(' + $.trim(data[0][0].medicoRadiologo) + ')').each(function () {

                    if ($.trim($(this).text()) === $.trim(data[0][0].medicoRadiologo)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }
            if (data[0][0].medicoResidente !== "") {
                $('#medico-residente option:contains(' + $.trim(data[0][0].medicoResidente) + ')').each(function () {

                    if ($.trim($(this).text()) === $.trim(data[0][0].medicoResidente)) {
                        $(this).attr('selected', 'selected');
                    }

                });
                /*      
                 $('#medico-residente option:contains(' + data[0][0].medicoResidente + ')').each(function () {
                 if ($(this).text() === data[0][0].medicoResidente) {
                 $(this).attr('selected', 'selected');
                 }
                 
                 });
                 */
            }

            if (data[0][0].fechaNavegacion !== "Jan 1, 1900" && data[0][0].fechaNavegacion !== "ene 1, 1900") {
                var fecha = data[0][0].fechaNavegacion;
                fecha = convertDate(fecha);
                $('#fechaNavegacion').val(fecha);
            }

            if (data[0][0].fechaConsulta !== "Jan 1, 1900" && data[0][0].fechaConsulta !== "ene 1, 1900") {
                var fecha = data[0][0].fechaConsulta;
                fecha = convertDate(fecha);
                $('#fechaConsulta').val(fecha);
                // $('#fechaConsulta').val(convertDate(new Date(data[0][0].fechaConsulta)));
            }
            if ((data[0][0].noAdscrito === true))
                $('#noAdscritoAdscrito').attr('checked', 'checked');
            if ((data[0][0].noRadiologo === true))
                $('#noAdscritoRadiologo').attr('checked', 'checked');
            if ((data[0][0].noResidente === true))
                $('#noAdscritoResidente').attr('checked', 'checked');

// Segunda pagina formulario

            if (data[0][0].escolaridad !== "") {
                $('#nivelEducativo option:contains(' + $.trim(data[0][0].escolaridad) + ')').each(function () {

                    if ($.trim($(this).text()) === $.trim(data[0][0].escolaridad)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }
            if (data[0][0].alergias !== 0)
                $('#alergias').val(data[0][0].alergias);

            if (data[0][0].estadoHormonal !== "") {
                if (data[0][0].estadoHormonal === true) {
                    $('#estadoHormonal option:contains(' + "Postmenopáusica" + ')').each(function () {
                        if ($(this).text() === "Postmenopáusica") {
                            $(this).attr('selected', 'selected');
                        }

                    });
                } else {
                    $('#estadoHormonal option:contains(' + "Premenopáusica" + ')').each(function () {
                        if ($(this).text() === "Premenopáusica") {
                            $(this).attr('selected', 'selected');
                        }

                    });
                }
            }

            if (data[0][0].Seguro !== "") {
                $('#tieneSeguroPopular').attr('checked', 'checked');

                if ($('#tieneSeguroPopular').is(':checked')) {
                    $('#tiene-seguro').show();
                    if ((data[0][0].Seguro === "Seguro Popular")) {

                        $('#numSeguro').show(),
                                $('#numSeguro').val(data[0][0].noSeguro);

                    }
                } else {
                    $('#tiene-seguro').hide();
                }

                if ((data[0][0].Seguro === "Seguro Popular")) {

                    $('#numSeguro').show(),
                            $('#numSeguro').val(data[0][0].noSeguro);

                }
                $('#tiene-seguro option:contains(' + $.trim(data[0][0].Seguro) + ')').each(function () {
                    if ($.trim($(this).text()) === $.trim(data[0][0].Seguro)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }

            if (data[0][0].mastografiaPreINCAN === true) {
                $('#primeraMasto').attr('checked', 'checked');
            }

            if (data[0][0].cirugiaFecha !== "Jan 1, 1900" && data[0][0].cirugiaFecha !== "ene 1, 1900" || data[0][0].cirugiaTipo !== "" || data[0][0].cirugiaComentario !== "") {
                $('#tiene-cirugia').attr('checked', 'checked');
                if ($('#tiene-cirugia').is(':checked')) {
                    $('#divCirugia').show();
                } else {
                    $('#divCirugia').hide();
                }

                if (data[0][0].cirugiaFecha !== "Jan 1, 1900" && data[0][0].cirugiaFecha !== "ene 1, 1900") {
                    var fecha = data[0][0].cirugiaFecha;
                    fecha = convertDate(fecha);
                    $('#fecha-cirugia').val(fecha);
                    //$('#fecha-cirugia').val(convertDate(new Date(data[0][0].cirugiaFecha)));
                }
                if ((data[0][0].cirugiaTipo !== "")) {
                    $('#cirugia option:contains(' + $.trim(data[0][0].cirugiaTipo) + ')').each(function () {
                        if ($.trim($(this).text()) === $.trim(data[0][0].cirugiaTipo)) {
                            $(this).attr('selected', 'selected');
                        }

                    });
                }
                if (data[0][0].cirugiaComentario !== "") {
                    $('#detalle-cirugia').val(data[0][0].cirugiaComentario);
                }

            }

            if (data[0][0].quimioterapiaFecha !== "Jan 1, 1900" && data[0][0].quimioterapiaFecha !== "ene 1, 1900" || data[0][0].quimioterapiaCiclo !== -1 || data[0][0].quimioterapiaComentario !== "") {
                $('#tiene-quimioterapia').attr('checked', 'checked');
                if ($('#tiene-quimioterapia').is(':checked')) {
                    $('#divQuimioterapia').show();
                } else {
                    $('#divQuimioterapia').hide();
                }

                if (data[0][0].quimioterapiaFecha !== "Jan 1, 1900" && data[0][0].quimioterapiaFecha !== "ene 1, 1900") {
                    var fecha = data[0][0].quimioterapiaFecha;
                    fecha = convertDate(fecha);
                    $('#fecha-quimioterapia').val(fecha);
                    // $('#fecha-quimioterapia').val(convertDate(new Date(data[0][0].quimioterapiaFecha)));
                }

                if ((data[0][0].quimioterapiaCiclo !== -1)) {
                    $('#quimioterapia').val(data[0][0].quimioterapiaCiclo);
                }
                if (data[0][0].quimioterapiaComentario !== "") {
                    $('#detalle-quimioterapia').val(data[0][0].quimioterapiaComentario);
                }

            }

            if (data[0][0].radioterapiaFecha !== "Jan 1, 1900" && data[0][0].radioterapiaFecha !== "ene 1, 1900" || data[0][0].radioterapiaCiclo !== -1 || data[0][0].radioterapiaComentario !== "") {
                $('#tiene-radioterapia').attr('checked', 'checked');
                if ($('#tiene-radioterapia').is(':checked')) {
                    $('#divRadioterapia').show();
                } else {
                    $('#divRadioterapia').hide();
                }

                if (data[0][0].radioterapiaFecha !== "Jan 1, 1900" && data[0][0].radioterapiaFecha !== "ene 1, 1900") {
                    var fecha = data[0][0].radioterapiaFecha;
                    fecha = convertDate(fecha);
                    $('#fecha-radioterapia').val(fecha);
                    // $('#fecha-radioterapia').val(convertDate(new Date(data[0][0].radioterapiaFecha)));
                }

                if ((data[0][0].cirugiaTipo !== -1)) {
                    $('#radioterapia').val(data[0][0].radioterapiaCiclo);
                }
                if (data[0][0].radioterapiaComentario !== "") {
                    $('#detalle-radioterapia').val(data[0][0].radioterapiaComentario);
                }

            }

            if (data[0][0].mastografiaBiradsNombre !== "" || data[0][0].mastografiaBiradsFecha !== "Jan 1, 1900" && data[0][0].mastografiaBiradsFecha !== "ene 1, 1900") {
                $('#tiene-mastografia').attr('checked', 'checked');
                if ($('#tiene-mastografia').is(':checked')) {
                    $('#tiene-mastografiaPrevia').show();
                    $('#tipoMastografia').show();
                    $('#fechaMasto').show();
                } else {
                    $('#tiene-mastografiaPrevia').hide();
                    $('#tipoMastografia').hide();
                    $('#fechaPreMasto').hide();
                }

                if ((data[0][0].mastografiaBiradsFecha !== "Jan 1, 1900" && data[0][0].mastografiaBiradsFecha !== "ene 1, 1900")) {
                    var fecha = data[0][0].mastografiaBiradsFecha;
                    fecha = convertDate(fecha);
                    $('#fechaPreMasto').val(fecha);
                    //.$('#fechaPreMasto').val(convertDate(new Date(data[0][0].mastografiaBiradsFecha)));
                }
                if ((data[0][0].mastografiaBiradsNombre !== "")) {
                    $('#tipoMastografia option:contains(' + $.trim(data[0][0].mastografiaBiradsNombre) + ')').each(function () {
                        if ($.trim($(this).text()) === $.trim(data[0][0].mastografiaBiradsNombre)) {
                            $(this).attr('selected', 'selected');
                        }

                    });
                }
            }

            if (data[0][0].ultrasonidoBiradsNombre !== "" || data[0][0].ultrasonidoBiradsFecha !== "Jan 1, 1900" && data[0][0].ultrasonidoBiradsFecha !== "ene 1, 1900") {
                $('#tiene-ultrasonido-mama').attr('checked', 'checked');
                if ($('#tiene-ultrasonido-mama').is(':checked')) {

                    $('#tiene-UltrasonidoPrevio').show();
                    $('#fechaUsg').show();
                    $('#tipoUltrasonidoMama').show();
                } else {
                    $('#tiene-UltrasonidoPrevio').hide();
                    $('#fechaUsg').hide();
                    $('#tipoUltrasonidoMama').hide();
                }

                if ((data[0][0].ultrasonidoBiradsFecha !== "Jan 1, 1900" && data[0][0].ultrasonidoBiradsFecha !== "ene 1, 1900")) {
                    //   $('#fechaPreUsg').val(data[0][0].ultrasonidoBiradsFecha);
                    var fecha = data[0][0].ultrasonidoBiradsFecha;
                    fecha = convertDate(fecha);
                    $('#fechaPreUsg').val(fecha);
                }
                if ((data[0][0].ultrasonidoBiradsNombre !== "")) {
                    $('#tipoUltrasonidoMama option:contains(' + $.trim(data[0][0].ultrasonidoBiradsNombre) + ')').each(function () {
                        if ($.trim($(this).text()) === $.trim(data[0][0].ultrasonidoBiradsNombre)) {
                            $(this).attr('selected', 'selected');
                        }

                    });
                }
            }

            if (data[0][0].resultadoPatologia !== "") {
                if ((data[0][0].resultadoPatologia === "Otro")) {
                    $('#introducirOtroPatologia').show(),
                            $('#OtroResultadoPatologia').val(data[0][0].otroResultado);

                }
                $('#resultadoAnterior-patologia option:contains(' + $.trim(data[0][0].resultadoPatologia) + ')').each(function () {
                    if ($.trim($(this).text()) === $.trim(data[0][0].resultadoPatologia)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }

            if (data[0][0].serieLaminillas !== "" || data[0][0].cantidadLaminillas !== -1) {
                $('#entregaLaminillas').attr('checked', 'checked');
                if ($('#entregaLaminillas').is(':checked')) {
                    $('#contenedor-laminillas').show();
                } else {
                    $('#contenedor-laminillas').hide();
                }

                if ((data[0][0].cantidadLaminillas !== -1)) {
                    $('#numLaminillas').val(data[0][0].cantidadLaminillas);
                }
                if ((data[0][0].serieLaminillas !== "")) {
                    $('#serieLaminillas').val(data[0][0].serieLaminillas);
                }
            }

            if (data[0][0].serieParafina !== "" || data[0][0].cantidadParafina !== -1) {
                $('#entregaBloques').attr('checked', 'checked');
                if ($('#entregaBloques').is(':checked')) {
                    $('#contenedor-bloques').show();
                } else {
                    $('#contenedor-bloques').hide();
                }

                if ((data[0][0].cantidadParafina !== -1)) {
                    $('#numBloques').val(data[0][0].cantidadParafina);
                }
                if ((data[0][0].serieParafina !== "")) {
                    $('#serieBloques').val(data[0][0].serieParafina);
                }
            }

// tercera pagina formulario

//Biopsia

//1./ checkbox habilitado
            if ($('#tiene-biopsia').prop('checked', true)) {
//2. habilitar init
                $('#biopsiaInit').show();
                $('#biopsia-contenedor').show();
            } else {
                $('#biopsia-contenedor').hide();
                $('#biopsiaInit').hide();

            }

            // $('#fechaConsulta').val(convertDate(new Date(data[0][0].fechaConsulta)));
//3. recorrer el arreglo
            for (var i = 0; i < data[1].length; i++) {

                var fecha = data[1][i].CitaProgramada;
                fecha = convertDate(fecha);


                var plantilla =
                        `<div class="form-group row mt-2 tuplaBiopsia" data-id="${data[1][i].idCita}" data-accion="actualizar">

            <!-- tipo biopsia -->
            <div class="col-3">
                <input  name="tipo-BipsiaAdded" value="${data[1][i].nombreEstudio}" type="text" class="form-control tipoBiopsia" placeholder="Tipo de biopsiaa">
            </div>

            <!-- fecha biopsia -->
            <div class="col-4">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <div class="input-group-text">
                            <i class="fas fa-calendar-alt"></i>
                        </div>
                    </div>
                    <input name="fecha-BipsiaAdded" value="${fecha}" placeholder="Fecha de la biopsia" class="form-control fechaBiopsia" type="text" onfocus="(this.type='date')">
                </div>
            </div>

            <!-- parte del cuerpo -->
            <div class="col-3">
                <div class="input-group text-center">
                    <div class="input-group-prepend">
                        <div class="input-group-text">
                            <i class="fas fa-hand-paper"></i>
                        </div>
                    </div>
                    <input name ="parte-BipsiaAdded" value="${data[1][i].lugarCuerpo}" type="text" class="form-control parteCuerpoBiopsia" placeholder="Parte del cuerpo">
                </div>
            </div>

            <div class="col-2">
                <button type="button" class="btn btn-outline-danger ml-2 remove-biopsia" style="border-radius: 25px;">
                <i class="fas fa-times"></i>
                </button>
            </div>


        </div>`

                $('#biopsia-contenedor').append(plantilla);

            }

//Rayos X

//1./ checkbox habilitado
            if ($('#tiene-rayosX').prop('checked', true)) {
//2. habilitar init
                $('#rayosInit').show();

            } else {
                $('#rayosInit').hide();
            }


//3. recorrer el arreglo
            for (var i = 0; i < data[2].length; i++) {
                var fecha = data[2][i].CitaProgramada;
                fecha = convertDate(fecha);
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaRayosX" data-id="${data[2][i].idCita}" data-accion="actualizar">

                <!-- tipo rayos -->
                <div class="col-5">

                    <input name="tipo-RayosXAdded" value="${data[2][i].nombreEstudio}" type="text" class="form-control tipoBiopsia rayosX" placeholder="Tipo de rayos X">
                </div>

                <!-- fecha rayos -->
                <div class="col-5">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </div>
                        </div>
                        <input name ="fecha-RayosXAdded" value="${fecha}" placeholder="Fecha de los Rayos X" class="form-control fechaRayos" type="text" onfocus="(this.type='date')">
                    </div>
                </div>

                <div class="col-2">
                <button type="button" class="btn btn-outline-danger ml-2 remove-biopsia" style="border-radius: 25px;">
                <i class="fas fa-times"></i>
                </button>
            </div>

            </div>
        
     `

                $('#rayos-contenedor').append(plantilla);

            }

//UltraSonido

//1./ checkbox habilitado
            if ($('#tiene-ultrasonido').prop('checked', true)) {
//2. habilitar init
                $('#ultrasonidoInit').show();
            } else {
                $('#ultrasonidoInit').hide();
            }


//3. recorrer el arreglo
            for (var i = 0; i < data[3].length; i++) {
                var fecha = data[3][i].CitaProgramada;
                fecha = convertDate(fecha);
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaUltrasonido" data-id="${data[3][i].idCita}" data-accion="actualizar">

               
                <div class="col-5">
                    <input name ="parteCuperpo-USGAdded"type="text" value="${data[3][i].lugarCuerpo}" class="form-control parteCuerpoUltrasonido" placeholder="Parte del cuerpo">
                </div>

            
                <div class="col-5">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </div>
                        </div>
                        <input name ="fecha-USGAdded" value="${fecha}" placeholder="Fecha de USG" class="form-control fechaUltrasonido" type="text" onfocus="(this.type='date')">
                    </div>
                </div>

                <div class="col-2">
                    <button type="button" class="btn btn-outline-danger ml-2 remove-ultrasonido" style="border-radius: 25px;">
                    <i class="fas fa-times"></i>
                    </button>
                </div>


            </div>
        
     `

                $('#ultrasonido-contenedor').append(plantilla);
            }

//Medicina Nuclear

//1./ checkbox habilitado
            if ($('#tiene-medicina-nuclear').prop('checked', true)) {
//2. habilitar init
                $('#medicinaNuclearInit').show();
            } else {
                $('#medicinaNuclearInit').hide();
            }


//3. recorrer el arreglo
            for (var i = 0; i < data[4].length; i++) {
                var fecha = data[4][i].CitaProgramada;
                fecha = convertDate(fecha);
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaMedicinaNuclear" data-id="${data[4][i].idCita}" data-accion="actualizar">
    
                    <div class="col-5">
                        <input name ="mNuclearAdded" type="text" class="form-control medicinaNuclear" value="${data[4][i].nombreEstudio}" placeholder="Introduce medicina nuclear">
                    </div>

      
                    <div class="col-5">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fas fa-calendar-alt"></i>
                                </div>
                            </div>
                            <input name ="fecha-mNuclearAdded" value="${fecha}" placeholder="Fecha de medicina nuclear" class="form-control fechaMedicinaNuclear" type="text" onfocus="(this.type='date')">
                        </div>
                    </div>

                    <div class="col-2">
                        <button type="button" class="btn btn-outline-danger ml-2 remove-medicinaNuclear" style="border-radius: 25px;">
                        <i class="fas fa-times"></i>
                        </button>
                    </div>

                </div>
        
     `

                $('#medicinaNuclear-contenedor').append(plantilla);

            }

//Laboratorio

//1./ checkbox habilitado
            if ($('#tiene-laboratorio').prop('checked', true)) {
//2. habilitar init
                $('#laboratorioInit').show();
            } else {
                $('#laboratorioInit').hide();
            }


//3. recorrer el arreglo
            for (var i = 0; i < data[5].length; i++) {
                var fecha = data[5][i].CitaProgramada;
                fecha = convertDate(fecha);
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaLaboratorio" data-id="${data[5][i].idCita}" data-accion="actualizar">

                <div class="col-10">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </div>
                        </div>
                        <input name ="fecha-LaboAdded" value="${fecha}" placeholder="Fecha de laboratorio" class="form-control fechaLaboratorio" type="text" onfocus="(this.type='date')">
                    </div>
                </div>

                <div class="col-2">
                    <button type="button" class="btn btn-outline-danger ml-2 remove-laboratorio" style="border-radius: 25px;">
                    <i class="fas fa-times"></i>
                    </button>
                </div>
                    
            </div>
        
     `

                $('#laboratorio-contenedor').append(plantilla);

            }

//Valoracion

//1./ checkbox habilitado
            if ($('#tiene-valoracion').prop('checked', true)) {
//2. habilitar init
                $('#valoracionInit').show();
            } else {
                $('#valoracionInit').hide();
            }


//3. recorrer el arreglo
            for (var i = 0; i < data[6].length; i++) {
                var fecha = data[6][i].CitaProgramada;
                fecha = convertDate(fecha);
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaValoracion" data-id="${data[6][i].idCita}" data-accion="actualizar">

       
                <div class="col-5">
                    <input name ="valoracionAdded" value="${data[6][i].nombreEstudio}" type="text" class="form-control valoracion" placeholder="Introduce valoración">
                </div>

                <div class="col-5">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </div>
                        </div>
                        <input name ="fecha-valoracionAdded" value="${fecha}" placeholder="Fecha de valoración" class="form-control fechaValoracion" type="text" onfocus="(this.type='date')">
                    </div>
                </div>

                <div class="col-2">
                    <button type="button" class="btn btn-outline-danger ml-2 remove-valoracion" style="border-radius: 25px;">
                    <i class="fas fa-times"></i>
                    </button>
                </div>

            </div>
        
     `

                $('#valoracion-contenedor').append(plantilla);

            }

// Espirometróa/Inhaloterapia

//1./ checkbox habilitado
            if ($('#tiene-espirometria').prop('checked', true)) {
//2. habilitar init
                $('#espirometriaInit').show();
            } else {
                $('#espirometriaInit').hide();
            }


//3. recorrer el arreglo
            for (var i = 0; i < data[7].length; i++) {
                var fecha = data[7][i].CitaProgramada;
                fecha = convertDate(fecha);
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaEspirometria" data-id="${data[7][i].idCita}" data-accion="actualizar">

                <div class="col-10">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </div>
                        </div>
                        <input name="fecha-espilometriaAdded" value="${fecha}" placeholder="Fecha de espirometría" class="form-control fechaEspirometria" type="text" onfocus="(this.type='date')">
                    </div>
                </div>

                <div class="col-2">
                    <button type="button" class="btn btn-outline-danger ml-2 remove-espirometria" style="border-radius: 25px;">
                    <i class="fas fa-times"></i>
                    </button>
                </div>

            </div>
        
     `

                $('#espirometria-contenedor').append(plantilla);

            }

// Electrocardiograma

//1./ checkbox habilitado
            if ($('#tiene-electrocardiograma').prop('checked', true)) {
//2. habilitar init
                $('#electrocardiogramaInit').show();
            } else {
                $('#electrocardiogramaInit').hide();
            }


//3. recorrer el arreglo
            for (var i = 0; i < data[8].length; i++) {
                var fecha = data[8][i].CitaProgramada;
                fecha = convertDate(fecha);
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaElectrocardiograma" data-id="${data[8][i].idCita}" data-accion="actualizar">

                    <div class="col-10">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fas fa-calendar-alt"></i>
                                </div>
                            </div>
                            <input name="fecha-ECGAdded" value="${fecha}" placeholder="Fecha de electrocardiograma" class="form-control fechaElectrocardiograma" type="text" onfocus="(this.type='date')">
                        </div>
                    </div>

                    <div class="col-2">
                        <button type="button" class="btn btn-outline-danger ml-2 remove-electrocardiograma" style="border-radius: 25px;">
                        <i class="fas fa-times"></i>
                        </button>
                    </div>

                </div>
        
     `

                $('#electrocardiograma-contenedor').append(plantilla);

            }


//ecocrdiaograma

//1./ checkbox habilitado
            if ($('#tiene-ecocardiograma').prop('checked', true)) {
//2. habilitar init
                $('#ecocardiogramaInit').show();
            } else {
                $('#ecocardiogramaInit').hide();
            }

//3. recorrer el arreglo
            for (var i = 0; i < data[9].length; i++) {
                var fecha = data[9][i].CitaProgramada;
                fecha = convertDate(fecha);
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaEcocardiograma" data-id="${data[9][i].idCita}" data-accion="actualizar">

                    <div class="col-10">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fas fa-calendar-alt"></i>
                                </div>
                            </div>
                            <input name="fecha-ecoAdded" value="${fecha}" placeholder="Fecha de ecocardiograma" class="form-control fechaEcocardiograma" type="text" onfocus="(this.type='date')">
                        </div>
                    </div>

                    <div class="col-2">
                        <button type="button" class="btn btn-outline-danger ml-2 remove-ecocardiograma" style="border-radius: 25px;">
                        <i class="fas fa-times"></i>
                        </button>
                    </div>
                    

                </div>
        
     `

                $('#ecocardiograma-contenedor').append(plantilla);
            }



//Trabajo social

//1./ checkbox habilitado
            if ($('#tiene-trabajo-social').prop('checked', true)) {
//2. habilitar init
                $('#trabajoSocialInit').show();
            } else {
                $('#trabajoSocialInit').hide();
            }

//3. recorrer el arreglo

            for (var i = 0; i < data[10].length; i++) {
                var fecha = data[10][i].CitaProgramada;
                fecha = convertDate(fecha);
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaTrabajoSocial" data-id="${data[10][i].idCita}" data-accion="actualizar">

                <div class="col-10">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </div>
                        </div>
                        <input name="fecha-tSocilaAdded" value="${fecha}" placeholder="Fecha de trabajo social" class="form-control fechaTrabajoSocial" type="text" onfocus="(this.type='date')">
                    </div>
                </div>

                <div class="col-2">
                        <button type="button" class="btn btn-outline-danger ml-2 remove-trabajoSocial" style="border-radius: 25px;">
                        <i class="fas fa-times"></i>
                        </button>
                    </div>

            </div>
        
     `;

                $('#trabajoSocial-contenedor').append(plantilla);
            }

// Programa

//1./ checkbox habilitado
            if ($('#tiene-programa').prop('checked', true)) {
//2. habilitar init
                $('#programaInit').show();
            } else {
                $('#programaInit').hide();
            }


//3. recorrer el arreglo
            for (var i = 0; i < data[11].length; i++) {
                var fecha = data[11][i].CitaProgramada;
                fecha = convertDate(fecha);
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaPrograma" data-id="${data[11][i].idCita}" data-accion="actualizar">


                    <div class="col-5">
                        <input name="programaAdded" value="${data[10][i].nombreEstudio}" type="text" id="tipoPrograma" class="form-control" placeholder="Introduce programa">
                    </div>

                    <div class="col-5">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fas fa-calendar-alt"></i>
                                </div>
                            </div>
                            <input name="fecha-programaAdded" value="${fecha}" placeholder="Fecha del programa" class="form-control fechaPrograma" type="text" onfocus="(this.type='date')">
                        </div>
                    </div>

                    <div class="col-2">
                        <button type="button" class="btn btn-outline-danger ml-2 remove-programa" style="border-radius: 25px;">
                        <i class="fas fa-times"></i>
                        </button>
                    </div>
                    
                </div>
        
     `

                $('#programa-contenedor').append(plantilla);

            }

// Otro

//1./ checkbox habilitado
            if ($('#tiene-otro').prop('checked', true)) {
//2. habilitar init
                $('#otroInit').show();
            } else {
                $('#otroInit').hide();
            }


//3. recorrer el arreglo
            for (var i = 0; i < data[12].length; i++) {
                var fecha = data[12][i].CitaProgramada;
                fecha = convertDate(fecha);
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaOtro" data-id="${data[12][i].idCita}" data-accion="actualizar">

                    <div class="col-5">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fas fa-calendar-alt"></i>
                                </div>
                            </div>
                            <input name="fecha-otroAdded" value="${fecha}" placeholder="Fecha de otro" class="form-control fechaOtro" type="text" onfocus="(this.type='date')">
                        </div>
                    </div>

                    <div class="col-5">
                        <input name="otroAdded" value="${data[12][i].nombreEstudio}" type="text" class="form-control otro-estudioPreconsulta" placeholder="Introduce otro">
                    </div>

                    <div class="col-2">
                        <button type="button" class="btn btn-outline-danger ml-2 remove-otro" style="border-radius: 25px;">
                        <i class="fas fa-times"></i>
                        </button>
                    </div>

                </div>
        
     `

                $('#otro-contenedor').append(plantilla);

            }



// cuarta pagina formulario


// LLamada al paciente

//1./ checkbox habilitado
            if ($('#seLlamo').prop('checked', true)) {
//2. habilitar init
                $('.llamadaInit').show();

            } else {
                $('.llamadaInit').hide();
            }


//3. recorrer el arreglo
            for (var i = 0; i < data[13].length; i++) {
                var fecha = data[13][i].CitaProgramada;
                fecha = convertDate(fecha);
                var plantilla =
                        `
            <div class="tuplaLlamada mt-3" data-id="${data[13][i].idCita}" data-accion="actualizar">
                <div class="row">
                    <div class="col-12">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fas fa-calendar-alt"></i>
                                </div>
                            </div>
                            <input value="${data[13][i].fechaLlamada}" placeholder="Fecha llamada" class="form-control fecha-llamada" type="text" onfocus="(this.type='date')">
                            <button type="button" class="btn btn-outline-danger ml-3 remove-llamada" style="border-radius: 25px;">
                            <i class="fas fa-times"></i>
                            </button>
                        </div>
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <textarea class="form-control comentario-llamada" style="min-height:100px;" value="${fecha}" placeholder="Introduce el motivo de la llamada "></textarea>
                    </div>
                </div>
            </div>
        
     `

                $('.llamadaInit').append(plantilla);

            }

            if ((data[0][0].resultados === true))
                $('#resultadosCheckbox').attr('checked', 'checked');

            if (data[0][0].fechaFin !== "Jan 1, 1900" && data[0][0].fechaFin !== "ene 1, 1900")
            {
                var fecha = data[0][0].fechaFin;
                fecha = convertDate(fecha);
                $('#fecha-decisionPreconsulta').val(fecha);
            }


            if ((data[0][0].decisionCosulta !== "")) {
                $('#decisionPreconsulta option:contains(' + $.trim(data[0][0].decisionCosulta) + ')').each(function () {
                    if ($.trim($(this).text()) === $.trim(data[0][0].decisionCosulta)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }

            if ((data[0][0].socioeconomico !== "")) {
                $('#nivelSocioeconomico option:contains(' + $.trim(data[0][0].socioeconomico) + ')').each(function () {
                    if ($.trim($(this).text()) === $.trim(data[0][0].socioeconomico)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }

            if (data[0][0].comentarioIncidencia !== "")
                $('#exampleFormControlTextarea1').val(data[0][0].comentarioIncidencia);
            if (data[0][0].comentarioMedico !== "")
                $('#comentariosAdicionales').val(data[0][0].comentarioMedico);




// quinta pagina formulario

            if ((data[0][0].etapaClinica !== "")) {
                $('#etapaClinica option:contains(' + $.trim(data[0][0].etapaClinica) + ')').each(function () {
                    if ($.trim($(this).text()) === $.trim(data[0][0].etapaClinica)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }

            if ((data[0][0].masto !== "")) {
                $('#ResultadoTipoMastografia option:contains(' + $.trim(data[0][0].masto) + ')').each(function () {
                    if ($.trim($(this).text()) === $.trim(data[0][0].masto)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }

            if ((data[0][0].ultra !== "")) {
                $('#tipoUSG option:contains(' + $.trim(data[0][0].ultra) + ')').each(function () {
                    if ($.trim($(this).text()) === $.trim(data[0][0].ultra)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }

            if ((data[0][0].T !== "")) {
                $('#tumorPrimarioT option:contains(' + $.trim(data[0][0].T) + ')').each(function () {
                    if ($.trim($(this).text()) === $.trim(data[0][0].T)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }

            if ((data[0][0].N !== "")) {
                $('#gangliosN option:contains(' + $.trim(data[0][0].N) + ')').each(function () {
                    if ($.trim($(this).text()) === $.trim(data[0][0].N)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }

            if ((data[0][0].M !== "")) {
                $('#metastasisM option:contains(' + $.trim(data[0][0].M) + ')').each(function () {
                    if ($.trim($(this).text()) === $.trim(data[0][0].M)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }

            if (data[0][0].resultadoPatologiaPost !== "") {
                if ((data[0][0].resultadoPatologiaPost === "Otro")) {
                    $('#introducirOtro').show(),
                            $('#otroResultadoPatologiaPost').val(data[0][0].otroResultadoPost);

                }
                $('#resultado-patologia option:contains(' + $.trim(data[0][0].resultadoPatologiaPost) + ')').each(function () {
                    if ($.trim($(this).text()) === $.trim(data[0][0].resultadoPatologiaPost)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }

            if ((data[0][0].gradoH !== "")) {
                $('#grado-histologico option:contains(' + $.trim(data[0][0].gradoH) + ')').each(function () {
                    if ($.trim($(this).text()) === $.trim(data[0][0].gradoH)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }

            if ((data[0][0].her2 !== "")) {
                $('#receptor-her2 option:contains(' + $.trim(data[0][0].her2) + ')').each(function () {
                    if ($.trim($(this).text()) === $.trim(data[0][0].her2)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }

            if ((data[0][0].fish !== "")) {
                $('#receptor-fish option:contains(' + $.trim(data[0][0].fish) + ')').each(function () {
                    if ($.trim($(this).text()) === $.trim(data[0][0].fish)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }

            if ((data[0][0].re !== "")) {
                $('#receptor-re option:contains(' + $.trim(data[0][0].re) + ')').each(function () {
                    if ($.trim($(this).text()) === $.trim(data[0][0].re)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }

            if ((data[0][0].rp !== "")) {
                $('#receptor-rp option:contains(' + $.trim(data[0][0].rp) + ')').each(function () {
                    if ($.trim($(this).text()) === $.trim(data[0][0].rp)) {
                        $(this).attr('selected', 'selected');
                    }

                });
            }

            if (data[0][0].ki67 !== "") {
                $('#ki67').val(data[0][0].ki67);

                /*      $('#ki67 option:contains(' + $.trim(data[0][0].ki67) + ')').each(function () {
                 if ($.trim($(this).text()) === $.trim(data[0][0].ki67)) {
                 $(this).attr('selected', 'selected');
                 }
                 
                 });
                 */
            }



        },
        error: function (request, status, error) {
            console.log("Enviar datos Error " + request.responseText);
            console.log("Enviar datos Error status " + status);
            console.log("Enviar datos Error error" + error);
            //alert("No enontre el controlador" + status);                               
        }
    });

    $('.salirCuenta').on('click', function () {
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

    $('.IrAMiIndex').on('click', function () {
        $.ajax({
            url: 'SAPI',
            method: "POST",
            cache: false,
            data: {
                file: "navegadora/index.jsp",
            },
            beforeSend: function () {
                $('.cargandoIrAInicio').fadeIn();
            },
            complete: function () {
                $('.cargandoIrAInicio').fadeOut();
            },
            success: function (response) {
                if (response == "error") {
                    $("#msj-error").show();
                } else {
                    document.open("text/html", "replace");
                    document.write(response);
                    document.close();
                }
            }
        });
    });

    $('.IrAMiCuenta').on('click', function () {
        $.ajax({
            url: 'SAPI',
            method: "POST",
            cache: false,
            data: {
                file: "navegadora/cuentaNavegadora.jsp",
            },
            beforeSend: function () {
                $('.cargandoIrACuenta').fadeIn();
            },
            complete: function () {
                $('.cargandoIrACuenta').fadeOut();
            },
            success: function (response) {
                if (response == "error") {
                    $("#msj-error").show();
                } else {
                    document.open("text/html", "replace");
                    document.write(response);
                    document.close();
                }
            }
        });
    });

// 'ene 1, 2001'
    function convertDate(fecha) {
        if (fecha !== "Jan 1, 1900") {
            console.log(fecha);
            fecha = fecha.replace("ene", "jan");
            fecha = fecha.replace("feb", "feb");
            fecha = fecha.replace("mar", "mar");
            fecha = fecha.replace("abr", "apr");
            fecha = fecha.replace("may", "may");
            fecha = fecha.replace("jun", "jun");
            fecha = fecha.replace("jul", "jul");
            fecha = fecha.replace("ago", "aug");
            fecha = fecha.replace("sep", "sep");
            fecha = fecha.replace("oct", "oct");
            fecha = fecha.replace("nov", "nov");
            fecha = fecha.replace("dic", "dec");
            var date = new Date(fecha);
            var yyyy = date.getFullYear().toString();
            var mm = (date.getMonth() + 1).toString();
            var dd = date.getDate().toString();

            var mmChars = mm.split('');
            var ddChars = dd.split('');

            return yyyy + '-' + (mmChars[1] ? mm : "0" + mmChars[0]) + '-' + (ddChars[1] ? dd : "0" + ddChars[0]);
        }
    }

    function convertDate2(date) {
        // console.log(date);
        var yyyy = date.getFullYear().toString();
        var mm = (date.getMonth() + 1).toString();
        var dd = date.getDate().toString();

        var mmChars = mm.split('');
        var ddChars = dd.split('');

        return yyyy + '-' + (mmChars[1] ? mm : "0" + mmChars[0]) + '-' + (ddChars[1] ? dd : "0" + ddChars[0]);
    }

    function convertDate3(date) {

        var yyyy = date.getFullYear().toString();
        var mm = (date.getMonth() + 1).toString();
        var dd = date.getDate().toString();

        var mmChars = mm.split('');
        var ddChars = dd.split('');

        return yyyy + '-' + (mmChars[1] ? mm : "0" + mmChars[0]) + '-' + (ddChars[1] ? dd : "0" + ddChars[0]);
    }


    $('.button').click(function () {
        myFunction(this);
    });


    function myFunction(ele) {
        var lastID;
        lastID = $(ele).attr("id");
        $('#hidden-idPaciente').val(lastID);
        console.log(lastID);
    }

});





function isValidPRZ(input) {

    var m = input.val();

    var expreg = /(PRZ)(\d){6}$/;

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

function isValidTratamientoPrevio(input) {

    let valorSeleccionado = input.val();

    let fechaIntroducida = new Date(valorSeleccionado);

    var year2 = fechaIntroducida.getFullYear();
    var month2 = fechaIntroducida.getMonth();
    var day2 = fechaIntroducida.getDate();

    fechaIntroducida = new Date(year2, month2, day2 + 1);
    fechaIntroducida.setHours(0);

    console.log("fecha introducida: " + fechaIntroducida);

    let hoy = new Date();
    hoy.setHours(0);

    /*var year = hoy.getFullYear();
     var month = hoy.getMonth();
     var day = hoy.getDate();
     
     hoy = new Date(year, month, day+1);
     hoy.setHours(0);*/

    console.log("HOY:" + hoy);

    if (fechaIntroducida > hoy) {
        console.log("MMM NO PUEDES");
        return false;
    }


    return true;
}

function isValidFechaEstudioPrevio(input) {
    console.log(input);
    let valorSeleccionado = input.val();

    let fechaIntroducida = new Date(valorSeleccionado);

    var year2 = fechaIntroducida.getFullYear();
    var month2 = fechaIntroducida.getMonth();
    var day2 = fechaIntroducida.getDate();

    fechaIntroducida = new Date(year2, month2, day2 + 1);
    fechaIntroducida.setHours(0);

    console.log("fecha introducida: " + fechaIntroducida);

    let hoy = new Date();
    hoy.setHours(0);

    console.log("HOY:" + hoy);

    if (fechaIntroducida > hoy) {
        console.log("MMM NO PUEDES");
        return false;
    }


    return true;
}


function isValidDate6months(input) {

    let valorSeleccionado = input.val();

    let fechaIntroducida = new Date(valorSeleccionado);

    var year2 = fechaIntroducida.getFullYear();
    var month2 = fechaIntroducida.getMonth();
    var day2 = fechaIntroducida.getDate();

    fechaIntroducida = new Date(year2, month2, day2 + 1);
    fechaIntroducida.setHours(0);

    console.log("fecha introducida: " + fechaIntroducida);

    let hoy = new Date();

    //obtener dia mes y año PARA LAS FECHAS POSIBLES
    var year = hoy.getFullYear();
    var month = hoy.getMonth();
    var day = hoy.getDate();

    //fechas posibles
    let mesesAdelante = new Date(year, month + 6, day);
    let mesesAtras = new Date(year, month - 6, day);

    if (fechaIntroducida >= mesesAdelante) {
        console.log("**SOBREPASA LOS 6 MESES**");
        return false;

    } else if (fechaIntroducida <= mesesAtras) {
        console.log("**NO ES POSIBLE TAN ATRAS**");
        return false;
    }

    console.log("Meses adelante: " + mesesAdelante);
    console.log("Meses atras: " + mesesAtras)
    console.log("hoy: " + hoy);

    return true;

}

function isValidDate6monthsDynamic(input) {

    let valorSeleccionado = input;

    let fechaIntroducida = new Date(valorSeleccionado);

    var year2 = fechaIntroducida.getFullYear();
    var month2 = fechaIntroducida.getMonth();
    var day2 = fechaIntroducida.getDate();

    fechaIntroducida = new Date(year2, month2, day2 + 1);
    fechaIntroducida.setHours(0);

    console.log("fecha introducida: " + fechaIntroducida);

    let hoy = new Date();

    //obtener dia mes y año PARA LAS FECHAS POSIBLES
    var year = hoy.getFullYear();
    var month = hoy.getMonth();
    var day = hoy.getDate();

    //fechas posibles
    let mesesAdelante = new Date(year, month + 6, day);
    let mesesAtras = new Date(year, month - 6, day);

    if (fechaIntroducida >= mesesAdelante) {
        console.log("**SOBREPASA LOS 6 MESES**");
        return false;

    } else if (fechaIntroducida <= mesesAtras) {
        console.log("**NO ES POSIBLE TAN ATRAS**");
        return false;
    }

    console.log("Meses adelante: " + mesesAdelante);
    console.log("Meses atras: " + mesesAtras)
    console.log("hoy: " + hoy);

    return true;

}



function formatDate(date) {
    var d = new Date(date),
            month = '' + (d.getMonth() + 1),
            day = '' + d.getDate(),
            year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [year, month, day].join('-');
}

function isValidName(input) {

    var m = input.val();

    var expreg = /^([a-z ñáéíóú]{2,255})$/i;

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

    var expreg = /^([a-z ñáéíóú]{2,255})$/i;

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

function isValidAlfanumerico(input) {

    var m = input.val();

    var expreg = /^$|[a-zA-Z0-9\u00E0-\u00FCñÑ., ]$/;

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

function isValidPassword(input) {

    var m = input.val();

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

function isValidCURP(input) {

    var m = input.val();

    var expreg = /^([A-Z][AEIOUX][A-Z]{2}\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\d])(\d)$/;

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

function isValidNumerico(input) {

    var m = input.val();

    var expreg = /^$|[0-9]+$/;

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

function isValidki67(input) {

    var m = input.val();

    var expreg = /^[0-9]{0,100}$/;

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

function isValidNumSeguro(input) {

    var m = input.val();

    var expreg = /^$|[0-9]+$/;

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

function isValidNumCiclos(input) {

    var m = input.val();

    var expreg = /^$|[0-9]+$/;

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

function isValidSelectDynamic(input) {

    if (!input) {


        return false;

    } else {

    }

    return true;
}

function isValidNonEmptyDate(input) {

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

function isValidNonEmptyDynamicDate(input) {

    if (!input) {


        return false;

    } else {

    }

    return true;
}

function isValidAllergy(input) {

    var m = input.val();

    var expreg = /^$|[a-zA-Z0-9\u00E0-\u00FCñÑ., ]{2,255}$/;

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

function isValidAllergy(input) {

    var m = input.val();

    var expreg = /^$|[a-zA-Z0-9\u00E0-\u00FCñÑ., ]{2,255}$/;

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

function isValidComentarioLlamada(input) {

    var m = input.val();

    var expreg = /^$|[a-zA-Z0-9\u00E0-\u00FCñÑ., ]{0,16777215}$/;

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

function isValidComentarioGeneric(input) {

    var m = input.val();

    var expreg = /^$|[a-zA-Z0-9\u00E0-\u00FCñÑ., ]{0,16777215}$/;

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

function isValidDate(input) {

//Obtener fecha
    let today = new Date();
    //Valor seleccionado del input
    let date_from = input.val();
    date_from = new Date(date_from);
    let event = false;
    today < date_from ? event = true : event = false;
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

function isValidFutureDate(input) {


    let valorSeleccionado = input;

    let date_from = new Date(valorSeleccionado);

    var year2 = date_from.getFullYear();
    var month2 = date_from.getMonth();
    var day2 = date_from.getDate();

    date_from = new Date(year2, month2, day2 + 1);
    date_from.setHours(0);

    console.log("fecha introducida Shannon: " + date_from);

    let today = new Date();


    let event = false;

    today <= date_from ? event = false : event = true;


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

function isPastDate(input) {

    let valorSeleccionado = input.val();

    let fechaIntroducida = new Date(valorSeleccionado);

    var year2 = fechaIntroducida.getFullYear();
    var month2 = fechaIntroducida.getMonth();
    var day2 = fechaIntroducida.getDate();

    fechaIntroducida = new Date(year2, month2, day2 + 1);
    fechaIntroducida.setHours(0);

    let hoy = new Date();

    //obtener dia mes y año PARA LAS FECHAS POSIBLES
    var year = hoy.getFullYear();
    var month = hoy.getMonth();
    var day = hoy.getDate();

    //fechas posibles
    let diasAtras = new Date(year, month, day - 1);

    if (fechaIntroducida <= diasAtras) {
        input.css('border', '1px solid red');
        input.css('color', 'red');
        return true;

    }

    input.css('border', '');
    input.css('color', '');
    return false;
}

function isValidColonia(input) {

    var m = input.val();
    var expreg = /^[a-zA-Z\u00E0-\u00FCñÑ.0-9 ]{1,500}$/;
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

function isValidStreet(input) {

    var m = input.val();
    var expreg = /^[a-zA-Z\u00E0-\u00FCñÑ.0-9 ]{1,255}$/;
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

function isValidIntNumber(input) {

    var m = input.val();
    var expreg = /^[#a-zA-Z0-9]{1,100000}$/;
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

function isValidExtNumber(input) {

    var m = input.val();
    var expreg = /^[#0-9]{1,100000}$/;
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

function isValidFormatCP(input) {

    var m = input.val();
    var expreg = /^\d{5}$/;
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

function isValidCheckbox(input) {

    if (input.is(':checked')) {
        return true;
    }

    return false;
}