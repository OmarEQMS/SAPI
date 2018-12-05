//ajaxPotencial.js

$(document).ready(function () {


//Ocultar mensajes de error 
    $('#error-contrasena').hide();
    $('#noEqualPasswordsError').hide();
    $('#errorCorreoRepetido').hide();
    $('#error-imgPerfil').hide();
    $("#error-datosRepetidos").hide();
    $('#error-camposMotivo').hide();

    var repiteCorreo;

    var cambioImagen = false;
    var imagenValida = false;

    console.log("MotivoConsulta: " + $("#idMotivoConsulta").val());

    if ($("#idMotivoConsulta").val() == 0)
        $("#motivoConsulta").val(0);
    else
        $("#motivoConsulta").val($("#idMotivoConsulta").val());

    console.log("Se Actualizó!");
    $('#eliminarCuentaPotencial').on('click', function () {
        console.log("vaya vaya si llego");
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
                            url: "PotencialController",
                            data: {
                                key: "eliminarCuentaPacientePotencial",
                                idCuenta: $("#sesionPaciente").val(),
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
    $('#myEmail').on('change', function () {
        $.ajax({

            url: 'PotencialController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteCorreo",
                correo: $('#myEmail').val()


            },
            success: function (response) {

                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#myEmail').css('color', 'orange');
                    $('#errorCorreoRepetido').show();
                    repiteCorreo = true;
                } else {
                    $('#myEmail').css('color', '');
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
                if (isValidEmail($("#myEmail")) &&
                        isValidPhoneNumber($("#telephoneNum"))) {


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
                            console.log("Debió haber guardado");
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

    $(".motivoCancelacion").on('click', function () {
        $('#error-camposMotivo').hide();
    });

    var resp;

    $('#btn-cancelarDefinitivo').on('click', () => {

        if ($('.motivoCancelacion').val().trim().length < 1)
        {
            resp = true;
            $('#error-camposMotivo').show();
        } else {
            resp = false;
            $('#error-camposMotivo').hide();
        }

        if (!resp) {

            $.ajax({
                url: "PotencialController",
                data: {
                    key: 'cancelarCita',
                    idPaciente: $('#idPaciente').val()
                },
                beforeSend: function () {
                    $('.cancelarCitas').fadeIn();
                },
                complete: function () {
                    $('.cancelarCitas').fadeOut();
                },
                method: "POST",
                success: function (response) {
                    console.log("Solicitar ESTADO de Preconsulta");
                    $.ajax({
                        url: "PotencialController",
                        method: "POST",
                        data: {key: "consultarEstadoPreconsulta"},
                        success: function (response) {
                            $.post("PotencialController", {
                                key: 'obtenerEventos',
                                idPaciente: $('#idPaciente').val()
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
                            ).then(function () {
                                $.post("SAPI", {
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
                        },
                        error: function (xhr) {
                            console.log("error" + xhr.statusText);
                            console.log("Error SolicitarEstadoPreconsulta");
                            //alert(xhr);
                        }

                    });
                },
                error: function (xhr) {

                }
            });
        }
    });
    $('#cancelarCitaModal').on('click', function () {
        console.log("hola");
        $('#modalVerCitaPreConsulta').modal('toggle');
    });
    $('.mitadCancelar').on('click', function () {

//Modal borrar sintoma
        swal({
            title: "¿Estás segura(o) que deseas cancelar la cita?",
            text: "Tendrás que reiniciar tu solicitud de preconsulta ya que se cancelarán ambas citas.",
            icon: "warning",
            buttons: true,
            closeOnEsc: false,
            closeOnClickOutside: false,
            buttons: ['Regresar', 'Cancelar Cita'],
            dangerMode: true,
        })

                .then((cancelar) => {
                    if (cancelar) {

                        $('#modalMotivoCancelacion').modal('toggle');
                    } else {

                    }
                });
    });

    $("#btn-GuardarContinuar").on('click', function () {

        var funcionaIdentificacion = $('#labelIdentificacion').text().search("Elegir archivo") >= 0 ? true : false;
        var tieneIdentificacion = ($('#fileIdentificacion').get(0).files.length === 0 || funcionaIdentificacion) ? false : true;

        var funcionaCurp = $('#labelCurp').text().search("Elegir archivo") >= 0 ? true : false;
        var tieneCurp = ($('#fileCURP').get(0).files.length === 0 || funcionaCurp) ? false : true;

        var funcionaComprobante = $('#labelComprobante').text().search("Elegir archivo") >= 0 ? true : false;
        var tieneComprobante = ($('#fileComprobanteDomicilio').get(0).files.length === 0 || funcionaComprobante) ? false : true;

        var funcionaEstudioMasto = $('#labelEstudioMasto').text().search("Elegir archivo") >= 0 ? true : false;
        var tieneEstudioMasto = ($('#fileEstudioPrevioMasto').get(0).files.length === 0 || funcionaEstudioMasto) ? false : true;

        var funcionaEstudioUsg = $('#labelEstudioUsg').text().search("Elegir archivo") >= 0 ? true : false;
        var tieneEstudioUsg = ($('#fileEstudioPrevioUsg').get(0).files.length === 0 || funcionaEstudioUsg) ? false : true;

        var funcionaEstudioBiopsia = $('#labelEstudioBio').text().search("Elegir archivo") >= 0 ? true : false;
        var tieneEstudioBiopsia = ($('#fileEstudioBiopsia').get(0).files.length === 0 || funcionaEstudioBiopsia) ? false : true;

        var existe = document.body.contains(document.getElementById('referenciaArchivo'));
        var tieneReferencia = false;

        if (existe) {
            var funcionaReferencia = $('#labelReferencia').text().search("Elegir archivo") >= 0 ? true : false;
            tieneReferencia = ($('#referenciaArchivo').get(0).files.length === 0 || funcionaReferencia) ? false : true;
        }

        console.log('Identificacion: ' + tieneIdentificacion);
        console.log('Curp: ' + tieneCurp);
        console.log('Comprobante: ' + tieneComprobante);
        console.log('Referencia: ' + tieneReferencia);
        console.log('Estudio Masto: ' + tieneEstudioMasto);
        console.log('Estudio Usg: ' + tieneEstudioUsg);
        console.log('Estudio Biopsia: ' + tieneEstudioBiopsia);

        var continuar = true;

        if (tieneIdentificacion && continuar) {
            if (!validDocument($('#fileIdentificacion'), document.querySelector('#fileIdentificacion').files))
                continuar = false;
        }
        if (tieneCurp && continuar) {
            if (!validDocument($('#fileCURP'), document.querySelector('#fileCURP').files))
                continuar = false;
        }
        if (tieneComprobante && continuar) {
            if (!validDocument($('#fileComprobanteDomicilio'), document.querySelector('#fileComprobanteDomicilio').files))
                continuar = false;
        }
        if (tieneEstudioMasto && continuar) {
            if (!validDocument($('#fileEstudioPrevioMasto'), document.querySelector('#fileEstudioPrevioMasto').files))
                continuar = false;
        }
        if (tieneEstudioUsg && continuar) {
            if (!validDocument($('#fileEstudioPrevioUsg'), document.querySelector('#fileEstudioPrevioUsg').files))
                continuar = false;
        }
        if (tieneEstudioBiopsia && continuar) {
            if (!validDocument($('#fileEstudioBiopsia'), document.querySelector('#fileEstudioBiopsia').files))
                continuar = false;
        }
        if (tieneReferencia && continuar) {
            if (!validDocument($('#referenciaArchivo'), document.querySelector('#referenciaArchivo').files))
                continuar = false;
        }

        if (continuar) {
            console.log("Archivos VALIDOS! :3");
            console.log("Guardar-Continuar");
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

            data.append("key", "GuardarContinuar");
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
            $.ajax({
                url: "PotencialController",
                method: "POST",
                beforeSend: function () {
                    $('.loading-screenGuardar').fadeIn();
                },
                data: data,
                enctype: "multipart/form-data",
                processData: false,
                contentType: false,
                complete: function () {
                    $('.loading-screenGuardar').fadeOut();
                },
                success: function (response) {
                    console.log("dsafdsafdsafsdafsdafjsalkjflsadjfkjsañlfjkasjfklsjaflsñjfklsjdfkljaslkfjla");


                    swal({
                        title: "Datos guardados correctamente",
                        text: "Puedes regresar a editar/completar el resto de información en cualquier momento.",
                        icon: "success",
                        closeOnEsc: false,
                        closeOnClickOutside: false,
                        buttons: true,
                        buttons: [, 'Aceptar']

                    });

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

                                console.log("Solicitar ESTADO de Preconsulta");
                                $.ajax({
                                    url: "PotencialController",
                                    method: "POST",
                                    data: {key: "consultarEstadoPreconsulta"},
                                    success: function (response) {
                                        console.log("SUCCESS!")
                                        console.log("Solicitar EstadoPaciente");
                                        $.ajax({
                                            url: "PotencialController",
                                            method: "POST",
                                            data: {key: "consultarEstadoPaciente"},
                                            success: function (response) {
                                                //Ajax redireccionamiento
                                                $.ajax({
                                                    url: "SAPI",
                                                    method: "POST",
                                                    data: {file: "potencial/index.jsp"},
                                                    success: function (response) {
                                                        if (response == "error") {
                                                            console.log("Error al cargar");
                                                        } else {
                                                            console.log("Intentando redireccionar");
                                                            document.open("text/html", "replace");
                                                            document.write(response);
                                                            document.close();
                                                        }
                                                    }
                                                });
                                            },
                                            error: function () {
                                                console.log("error" + xhr.statusText);
                                                alert("No enontre el controlador" + xhr.statusText);
                                                console.log("Error SolicitarEstadoPaciente");
                                            }

                                        });
                                    },
                                    error: function (xhr) {
                                        console.log("error" + xhr.statusText);
                                        console.log("Error SolicitarEstadoPreconsulta");
                                        //alert(xhr);
                                    }

                                });

                            } else {
                                console.log("Algo pasó" + response);
                            }
                        },
                        error: function () {
                            alert("No enontre el controlador");
                        }

                    });
                },
                error: function (request, status, error) {
                    console.log("Enviar solicitud Error request " + request.responseText);
                    console.log("Enviar solicitud Error status " + status);
                    console.log("Enviar solicitud Error error" + error);
                    //alert("No enontre el controlador" + status);                               
                }
            });
        } else {
            swal({
                title: "Error",
                text: "¿Estás tratando de subir un documento no válido?",
                icon: "error",
                closeOnEsc: false,
                closeOnClickOutside: false,
                buttons: true,
                buttons: [, 'Aceptar']

            });

        }



    });

    //ENVIAR SOLICITUD QUE FUNCIONA (ANTERIOR)
    $("#btn-enviarSolicitud").on('click', function () {

        var funcionaIdentificacion = $('#labelIdentificacion').text().search("Elegir archivo...") >= 0 ? true : false;
        var tieneIdentificacion = ($('#fileIdentificacion').get(0).files.length === 0 || funcionaIdentificacion) ? false : true;
        var funcionaCurp = $('#labelCurp').text().search("Elegir archivo...") >= 0 ? true : false;
        var tieneCurp = ($('#fileCURP').get(0).files.length === 0 || funcionaCurp) ? false : true;
        var funcionaComprobante = $('#labelComprobante').text().search("Elegir archivo...") >= 0 ? true : false;
        var tieneComprobante = ($('#fileComprobanteDomicilio').get(0).files.length === 0 || funcionaComprobante) ? false : true;
        var funcionaEstudioMasto = $('#labelEstudioMasto').text().search("Elegir archivo...") >= 0 ? true : false;
        var tieneEstudioMasto = ($('#fileEstudioPrevioMasto').get(0).files.length === 0 || funcionaEstudioMasto) ? false : true;
        var funcionaEstudioUsg = $('#labelEstudioUsg').text().search("Elegir archivo...") >= 0 ? true : false;
        var tieneEstudioUsg = ($('#fileEstudioPrevioUsg').get(0).files.length === 0 || funcionaEstudioUsg) ? false : true;
        var funcionaEstudioBiopsia = $('#labelEstudioBio').text().search("Elegir archivo...") >= 0 ? true : false;
        var tieneEstudioBiopsia = ($('#fileEstudioBiopsia').get(0).files.length === 0 || funcionaEstudioBiopsia) ? false : true;
        var existe = document.body.contains(document.getElementById('referenciaArchivo'));
        var tieneReferencia = false;
        if (existe) {
            var funcionaReferencia = $('#labelReferencia').text().search("Elegir archivo...") >= 0 ? true : false;
            tieneReferencia = ($('#referenciaArchivo').get(0).files.length === 0 || funcionaReferencia) ? false : true;
        }

        var continuar = true;
        if (tieneIdentificacion && continuar) {
            if (!validDocument($('#fileIdentificacion'), document.querySelector('#fileIdentificacion').files))
                continuar = false;
        }
        if (tieneCurp && continuar) {
            if (!validDocument($('#fileCURP'), document.querySelector('#fileCURP').files))
                continuar = false;
        }
        if (tieneComprobante && continuar) {
            if (!validDocument($('#fileComprobanteDomicilio'), document.querySelector('#fileComprobanteDomicilio').files))
                continuar = false;
        }
        if (tieneEstudioMasto && continuar) {
            if (!validDocument($('#fileEstudioPrevioMasto'), document.querySelector('#fileEstudioPrevioMasto').files))
                continuar = false;
        }
        if (tieneEstudioUsg && continuar) {
            if (!validDocument($('#fileEstudioPrevioUsg'), document.querySelector('#fileEstudioPrevioUsg').files))
                continuar = false;
        }
        if (tieneEstudioBiopsia && continuar) {
            if (!validDocument($('#fileEstudioBiopsia'), document.querySelector('#fileEstudioBiopsia').files))
                continuar = false;
        }
        if (tieneReferencia && continuar) {
            if (!validDocument($('#referenciaArchivo'), document.querySelector('#referenciaArchivo').files)) {
                swal({title: "Error",
                    text: "Adjunta la referencia para poder enviar tu solicitud.",
                    icon: "error",
                    buttons: true,
                    closeOnEsc: false,
                    closeOnClickOutside: false,
                    buttons: [, 'Aceptar']
                });
                continuar = false;
            }
        }
        if (continuar) {

            //si selecciono me envio un medico o me enviaron de otro hospital
            if (parseInt($('#motivoConsulta option:selected').val()) == 1 || parseInt($('#motivoConsulta option:selected').val()) == 4) {

                console.log("Enviar solicitud");
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
                var otroMotivo = $('#otro-motivo-consulta').val();
                data.append("key", "solicitarPreconsulta");
                data.append("femenino", femenino);
                data.append("masculino", masculino);
                data.append("sillaDeRuedas", sillaDeRuedas);
                data.append("camilla", camilla);
                data.append("baston", baston);
                data.append("oxigeno", oxigeno);
                data.append("motivoConsulta", motivoConsulta);
                data.append("otroMotivo", otroMotivo);
                data.append("biopsia", biopsia);
                console.log(data);
                //Al presionar enviar los campos quedan ineditables
                $('#masculino').attr('readonly', 'true');
                $('#femenino').attr('readonly', 'true');
                $('#fileIdentificacionSubido').prop('disabled', true);
                // Imprimmir en consola los valores obtenidos del form para pruebas
                data.forEach((value, key) => {
                    console.log(key + " " + value);
                });
                swal({
                    title: "¿Estás segura(o) de enviar tu solicitud?",
                    text: "Ya no podrás modificar tu solicitud mas adelante.",
                    showCancelButton: false,
                    showConfirmButton: true,
                    closeOnEsc: false,
                    closeOnClickOutside: false,
                    buttons: {cancel: 'Cancelar', aceptar: 'Aceptar'},
                    dangerMode: true
                }).then(function (value) {
                    if (value == "aceptar") {
                        //AJAX PARA ENVIAR SOLICITUD
                        $.ajax({
                            url: "PotencialController",
                            method: "POST",
                            beforeSend: function () {
                                $('.loading-screen').fadeIn();
                            },
                            data: data,
                            enctype: "multipart/form-data",
                            processData: false,
                            contentType: false,
                            complete: function () {
                                $('.loading-screen').fadeOut();
                            },
                            success: function (response) {

                                if (response == "documentosNoSubidos") {
                                    swal({
                                        title: "Error",
                                        text: "Para enviar la solicitud debes seleccionar tu Sexo y al menos subir: Identificación Oficial, CURP, Comprobante de Domicilio y Motivo de Consulta.",
                                        icon: "error",
                                        closeOnEsc: false,
                                        closeOnClickOutside: false,
                                        buttons: true,
                                        buttons: [, 'Aceptar']
                                    })
                                } else {

                                    swal({
                                        title: "Solicitud enviada",
                                        text: "En 36 horas máximo, se te dará respuesta a tu solicitud.",
                                        icon: "success",
                                        closeOnEsc: false,
                                        closeOnClickOutside: false,
                                        buttons: true,
                                        buttons: [, 'Aceptar']

                                    }).then(function () {
                                        var consultarDocumentosPreconsulta = new FormData;
                                        consultarDocumentosPreconsulta.append("key", "consultarDocumentosPreconsulta");
                                        console.log("Solicitar DOCUMENTOS de Preconsulta");
                                        $.ajax({
                                            url: "PotencialController",
                                            method: "POST",
                                            beforeSend: function () {
                                                $('.loading-screenActualizar').fadeIn();
                                            },
                                            data: consultarDocumentosPreconsulta,
                                            enctype: "multipart/form-data",
                                            processData: false,
                                            contentType: false,
                                            complete: function () {
                                                $('.loading-screenActualizar').fadeOut();
                                            },
                                            success: function (response) {

                                                if (response != null) {
                                                    var data = JSON.parse(response);
                                                    console.log(data);
                                                    console.log("Solicitar ESTADO de Preconsulta");
                                                    $.ajax({
                                                        url: "PotencialController",
                                                        method: "POST",
                                                        data: {key: "consultarEstadoPreconsulta"},
                                                        success: function (response) {
                                                            console.log("SUCCESS!")
                                                            console.log("Solicitar EstadoPaciente");
                                                            $.ajax({
                                                                url: "PotencialController",
                                                                method: "POST",
                                                                data: {key: "consultarEstadoPaciente"},
                                                                success: function (response) {
                                                                    //Ajax redireccionamiento
                                                                    $.ajax({
                                                                        url: "SAPI",
                                                                        method: "POST",
                                                                        data: {file: "potencial/index.jsp"},
                                                                        success: function (response) {
                                                                            if (response == "error") {
                                                                                console.log("Error al cargar");
                                                                            } else {
                                                                                console.log("Intentando redireccionar");
                                                                                document.open("text/html", "replace");
                                                                                document.write(response);
                                                                                document.close();
                                                                            }
                                                                        }
                                                                    });
                                                                },
                                                                error: function () {
                                                                    console.log("error" + xhr.statusText);
                                                                    alert("No enontre el controlador" + xhr.statusText);
                                                                    console.log("Error SolicitarEstadoPaciente");
                                                                }
                                                            });
                                                        },
                                                        error: function (xhr) {
                                                            console.log("error" + xhr.statusText);
                                                            console.log("Error SolicitarEstadoPreconsulta");
                                                            //alert(xhr);
                                                        }
                                                    });
                                                } else {
                                                    console.log("Algo pasó" + response);
                                                }
                                            },
                                            error: function () {
                                                alert("No enontre el controlador");
                                            }
                                        });
                                    })
                                }
                            },
                            error: function (request, status, error) {
                                console.log("Enviar solicitud Error request " + request.responseText);
                                console.log("Enviar solicitud Error status " + status);
                                console.log("Enviar solicitud Error error" + error);
                            }
                        });
                    }
                });
            } else {
                console.log("Enviar solicitud");
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
                var otroMotivo = $('#otro-motivo-consulta').val();
                data.append("key", "solicitarPreconsulta");
                data.append("femenino", femenino);
                data.append("masculino", masculino);
                data.append("sillaDeRuedas", sillaDeRuedas);
                data.append("camilla", camilla);
                data.append("baston", baston);
                data.append("oxigeno", oxigeno);
                data.append("motivoConsulta", motivoConsulta);
                data.append("otroMotivo", otroMotivo);
                data.append("biopsia", biopsia);
                console.log(data);
                //Al presionar enviar los campos quedan ineditables
                $('#masculino').attr('readonly', 'true');
                $('#femenino').attr('readonly', 'true');
                $('#fileIdentificacionSubido').prop('disabled', true);
                // Imprimmir en consola los valores obtenidos del form para pruebas
                data.forEach((value, key) => {
                    console.log(key + " " + value);
                });
                swal({
                    title: "¿Estás segura(o) de enviar tu solicitud?",
                    text: "Ya no podrás modificar tu solicitud mas adelante.",
                    showCancelButton: false,
                    showConfirmButton: true,
                    closeOnEsc: false,
                    closeOnClickOutside: false,
                    buttons: {cancel: 'Cancelar', aceptar: 'Aceptar'},
                    dangerMode: true
                }).then(function (value) {
                    if (value == "aceptar") {
                        //AJAX PARA ENVIAR SOLICITUD
                        $.ajax({
                            url: "PotencialController",
                            method: "POST",
                            beforeSend: function () {
                                $('.loading-screen').fadeIn();
                            },
                            data: data,
                            enctype: "multipart/form-data",
                            processData: false,
                            contentType: false,
                            complete: function () {
                                $('.loading-screen').fadeOut();
                            },
                            success: function (response) {

                                if (response == "documentosNoSubidos") {
                                    swal({
                                        title: "Error",
                                        text: "Para enviar la solicitud debes seleccionar tu Sexo y al menos subir: Identificación Oficial, CURP, Comprobante de Domicilio y Motivo de Consulta.",
                                        icon: "error",
                                        closeOnEsc: false,
                                        closeOnClickOutside: false,
                                        buttons: true,
                                        buttons: [, 'Aceptar']
                                    })
                                } else {

                                    swal({
                                        title: "Solicitud enviada",
                                        text: "En 36 horas máximo, se te dará respuesta a tu solicitud.",
                                        icon: "success",
                                        closeOnEsc: false,
                                        closeOnClickOutside: false,
                                        buttons: true,
                                        buttons: [, 'Aceptar']

                                    }).then(function () {
                                        var consultarDocumentosPreconsulta = new FormData;
                                        consultarDocumentosPreconsulta.append("key", "consultarDocumentosPreconsulta");
                                        console.log("Solicitar DOCUMENTOS de Preconsulta");
                                        $.ajax({
                                            url: "PotencialController",
                                            method: "POST",
                                            beforeSend: function () {
                                                $('.loading-screenActualizar').fadeIn();
                                            },
                                            data: consultarDocumentosPreconsulta,
                                            enctype: "multipart/form-data",
                                            processData: false,
                                            contentType: false,
                                            complete: function () {
                                                $('.loading-screenActualizar').fadeOut();
                                            },
                                            success: function (response) {
                                                if (response != null) {
                                                    var data = JSON.parse(response);
                                                    console.log(data);
                                                    console.log("Solicitar ESTADO de Preconsulta");
                                                    $.ajax({
                                                        url: "PotencialController",
                                                        method: "POST",
                                                        data: {key: "consultarEstadoPreconsulta"},
                                                        success: function (response) {
                                                            console.log("SUCCESS!")
                                                            console.log("Solicitar EstadoPaciente");
                                                            $.ajax({
                                                                url: "PotencialController",
                                                                method: "POST",
                                                                data: {key: "consultarEstadoPaciente"},
                                                                success: function (response) {
                                                                    //Ajax redireccionamiento
                                                                    $.ajax({
                                                                        url: "SAPI",
                                                                        method: "POST",
                                                                        data: {file: "potencial/index.jsp"},
                                                                        success: function (response) {
                                                                            if (response == "error") {
                                                                                console.log("Error al cargar");
                                                                            } else {
                                                                                console.log("Intentando redireccionar");
                                                                                document.open("text/html", "replace");
                                                                                document.write(response);
                                                                                document.close();
                                                                            }
                                                                        }
                                                                    });
                                                                },
                                                                error: function () {
                                                                    console.log("error" + xhr.statusText);
                                                                    alert("No enontre el controlador" + xhr.statusText);
                                                                    console.log("Error SolicitarEstadoPaciente");
                                                                }

                                                            });
                                                        },
                                                        error: function (xhr) {
                                                            console.log("error" + xhr.statusText);
                                                            console.log("Error SolicitarEstadoPreconsulta");
                                                        }

                                                    });
                                                } else {
                                                    console.log("Algo pasó" + response);
                                                }
                                            },
                                            error: function () {
                                                alert("No enontre el controlador");
                                            }
                                        });
                                    })
                                }
                            },
                            error: function (request, status, error) {
                                console.log("Enviar solicitud Error request " + request.responseText);
                                console.log("Enviar solicitud Error status " + status);
                                console.log("Enviar solicitud Error error" + error);
                            }
                        });
                    }
                });
            }
        } else {
            swal({
                title: "Error",
                text: "¿Estás tratando de enviar un documento no válido?",
                icon: "error",
                closeOnEsc: false,
                closeOnClickOutside: false,
                buttons: true,
                buttons: [, 'Aceptar']
            });
        }
    });

    $('#irACitaPreconsulta').on('click', function () {
        console.log("Presionó CitaPreConsulta")
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
                    console.log("Solicitar ESTADO de Preconsulta");
                    $.ajax({
                        url: "PotencialController",
                        method: "POST",
                        data: {key: "consultarEstadoPreconsulta"},
                        success: function (response) {
                            console.log("SUCCESS!")
                            console.log("Solicitar EstadoPaciente");
                            $.ajax({
                                url: "PotencialController",
                                method: "POST",
                                data: {key: "consultarEstadoPaciente"},
                                success: function (response) {
                                    //Ajax redireccionamiento
                                    $.ajax({
                                        url: "SAPI",
                                        method: "POST",
                                        data: {file: "potencial/index.jsp"},
                                        success: function (response) {
                                            if (response == "error") {
                                                console.log("Error al cargar");
                                            } else {
                                                console.log("Intentando redireccionar");
                                                document.open("text/html", "replace");
                                                document.write(response);
                                                document.close();
                                            }
                                        }
                                    });
                                },
                                error: function () {
                                    console.log("error" + xhr.statusText);
                                    alert("No enontre el controlador" + xhr.statusText);
                                    console.log("Error SolicitarEstadoPaciente");
                                }

                            });
                        },
                        error: function (xhr) {
                            console.log("error" + xhr.statusText);
                            console.log("Error SolicitarEstadoPreconsulta");
                            //alert(xhr);
                        }

                    });
                } else {
                    console.log("Algo pasó" + response);
                }
            },
            error: function () {
                alert("No enontre el controlador");
            }

        });
    });
    $('#enviar').on('click', function () {
        $.ajax({
            url: "PotencialController",
            method: "POST",
            data: consultarDocumentosPreconsulta,
            enctype: "multipart/form-data",
            processData: false,
            contentType: false,
            success: function (response) {
                var data = JSON.parse(response);
                console.log(data);
            }
        });
    });
    $('#irAMisCitas').on('click', function () {
        console.log("Solicitar ESTADO de Preconsulta");
        $.ajax({
            url: "PotencialController",
            method: "POST",
            data: {key: "consultarEstadoPreconsulta"},
            success: function (response) {
                $.post("PotencialController", {
                    key: 'obtenerEventos',
                    idPaciente: $('#idPaciente').val()
                },
                        function (response, status, xhr) {
                            console.log("El ajax fue exitoso!!-----------------------");
                            if (status == "success") {
                                if (response == "error") {
                                    $("#msj-error").show();
                                }
                            }
                        }
                ).then(function () {
                    $.post("SAPI", {
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
            },
            error: function (xhr) {
                console.log("error" + xhr.statusText);
                console.log("Error SolicitarEstadoPreconsulta");
                //alert(xhr);
            }

        });
    });
    $('#irAMisCitas2').on('click', function () {
        console.log("Solicitar ESTADO de Preconsulta");
        $.ajax({
            url: "PotencialController",
            method: "POST",
            data: {key: "consultarEstadoPreconsulta"},
            success: function (response) {
                $.post("PotencialController", {
                    key: 'obtenerEventos',
                    idPaciente: $('#idPaciente').val()
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
                ).then(function () {
                    $.post("SAPI", {
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
            },
            error: function (xhr) {
                console.log("error" + xhr.statusText);
                console.log("Error SolicitarEstadoPreconsulta");
                //alert(xhr);
            }

        });
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
    $('#irAInicioPotencial').on('click', function () {
        $.post("SAPI", {
            file: "potencial/index.jsp"
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
    $('#irACuenta1').on('click', function () {
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
    $("#btn-cambiarContrasena").on('click', function () {
//Modal cambiar contraseña 
        if (isValidPassword($('#password')) && isValidPassword($('#password2')) && areEqualPasswords($('#password'), $('#password2'))) {
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

                                },
                                error: function (xhr) {

                                }
                            });
                            $('#modalCambiarContraseña').modal('toggle');
                        } else {
                            console.log("Hola");
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
    //VALIDACIONES
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


    function validDocument(input, archivos) {

        for (let index = 0; index < archivos.length; index++) {

            if (archivos[index]["type"] == "image/jpg" || archivos[index]["type"] == "image/png"
                    || archivos[index]["type"] == "image/jpeg" || archivos[index]["type"] == "application/pdf"
                    ) {

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

    //Mediaqueries


});