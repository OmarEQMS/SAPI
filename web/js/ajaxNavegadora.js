$(document).ready(function () {

    $('#errorNombreNavegadora').hide();
    $('#errorCurpNavegadora').hide();
    $('#errorCurpRepetidoNavegadora').hide();
    $('#errorFechaNavegadora').hide();
    $('#errorApellidoPaternoNavegadora').hide();
    $('#errorApellidoMaternoNavegadora').hide();
    $('#errorNombreUsuarioNavegadora').hide();
    $('#errorUsuarioRepetidoNavegadora').hide();
    $('#errorECivilNavegadora').hide();
    $('#errorColoniaNavegadora').hide();
    $('#errorCalleNavegadora').hide();
    $('#errorNoInteriorNavegadora').hide();
    $('#errorNoExteriorNavegadora').hide();
    $('#errorEstadoNavegadora').hide();
    $('#errorMunicipioNavegadora').hide();
    $('#errorTelefonoNavegadora').hide();
    $('#errorCorreoNavegadora').hide();
    $('#errorPass1Navegadora').hide();
    $('#errorPass2Navegadora').hide();
    $('#error-CPexisteNavegadora').hide();
    $('#errorCodigoPostalNavegadora').hide();
    $('#noEqualPasswordsErrorNavegadora').hide();


    $('#error-editar-NombreNavegadora').hide();
    $('#error-editar-ApellidoPaternoNavegadora').hide();
    $('#error-editar-ApellidoMaternoNavegadora').hide();
    $('#error-editar-NombreUsuarioNavegadora').hide();
    $('#error-editar-CorreoNavegadora').hide();
    $('#error-editar-CurpNavegadora').hide();
    $('#error-editar-ColoniaNavegadora').hide();
    $('#error-editar-CalleNavegadora').hide();
    $('#error-editar-NoExteriorNavegadora').hide();
    $('#error-editar-NoInteriorNavegadora').hide();
    $('#error-editar-CurpRepetidoNavegadora').hide();
    $('#error-editar-TelefonoNavegadora').hide();
    $('#error-editar-ECivilNavegadora').hide();
    $('#error-editar-FechaNavegadora').hide();
    $('#error-editar-EstadoNavegadora').hide();
    $('#error-editar-MunicipioNavegadora').hide();
    $('#error-editar-UsuarioRepetidoNavegadora').hide();

    $('#error-imgPerfil').hide();

    $('#error-contrasena').hide();
    $('#noEqualPasswordsError').hide();


//AutocompleteRayosX

    var rayosX = $("#listRayosX");

    $.ajax({
        url: 'NavegadoraController',
        cache: false,
        method: 'POST',
        data: {key: "autocompleteRayosX"}
    }).done(function (response) {
       
        var json = JSON.parse(response);
        for (var i = 0; i < json.length; i++) {
            var newObjeto = {value: json[i].nombre, data: json[i].idEstudio};
            rayosX.push(newObjeto);
        }

        console.log(rayosX);

    });

/*
    $("body").on("click", '.rayosX', function () {

        $('.rayosX').autocomplete({
            lookup: rayosX,
            onSelect: function (suggestion) {
                console.log('You selected: ' + suggestion.value + ', ' + suggestion.data);
            }
        });

    });
*/


//AutocompleteUltrasonido

    var ultraSonido = [];

    $.ajax({
        url: 'NavegadoraController',
        cache: false,
        method: 'POST',
        data: {key: "autocompleteUltraSonido"}
    })

            .done(function (response) {

                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {
                    var newObjeto = {value: json[i].nombre, data: json[i].idEstudio};
                    ultraSonido.push(newObjeto);
                }


                console.log(ultraSonido);

            });




    $("body").on("click", '.ultraSonido', function () {

        $('.ultraSonido').autocomplete({
            lookup: ultraSonido,
            onSelect: function (suggestion) {
                alert('You selected: ' + suggestion.value + ', ' + suggestion.data);

            }
        });

    });




//AutocompletePrograma

    var programa = [];

    $.ajax({
        url: 'NavegadoraController',
        cache: false,
        method: 'POST',
        data: {key: "autocompletePrograma"}
    })

            .done(function (response) {

                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {
                    var newObjeto = {value: json[i].nombre, data: json[i].idEstudio};
                    programa.push(newObjeto);
                }


                console.log(programa);

            });




    $("body").on("click", '.programa', function () {

        $('.programa').autocomplete({
            lookup: programa,
            onSelect: function (suggestion) {
                alert('You selected: ' + suggestion.value + ', ' + suggestion.data);

            }
        });

    });



//AutocompleteMedicinaNuclear

    var medicinaNuclear = [];

    $.ajax({
        url: 'NavegadoraController',
        cache: false,
        method: 'POST',
        data: {key: "autocompleteMedicinaNuclear"}
    })

            .done(function (response) {

                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {
                    var newObjeto = {value: json[i].nombre, data: json[i].idEstudio};
                    medicinaNuclear.push(newObjeto);
                }


                console.log(medicinaNuclear);

            });



    $("body").on("click", '.medicinaNuclear', function () {

        $('.medicinaNuclear').autocomplete({
            lookup: medicinaNuclear,
            onSelect: function (suggestion) {
                alert('You selected: ' + suggestion.value + ', ' + suggestion.data);

            }
        });

    });


//AutocompleteValoracion

    var valoracion = [];

    $.ajax({
        url: 'NavegadoraController',
        cache: false,
        method: 'POST',
        data: {key: "autocompleteValoracion"}
    })

            .done(function (response) {

                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {
                    var newObjeto = {value: json[i].nombre, data: json[i].idEstudio};
                    valoracion.push(newObjeto);
                }


                console.log(valoracion);

            });



    $('#valoracion').autocomplete({
        lookup: valoracion,
        onSelect: function (suggestion) {

        }
    });





    $("body").on("click", '.valoracion', function () {

        $('.valoracion').autocomplete({
            lookup: valoracion,
            onSelect: function (suggestion) {
                alert('You selected: ' + suggestion.value + ', ' + suggestion.data);

            }
        });

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
                    $("#estadoNavegadora").each(function () {
                        $(this).children().remove();
                    });

                    //Limpia los campos de municipio 
                    $("#municipioNavegadora").each(function () {
                        $(this).children().remove();
                    });

                    //Primera opcion de estado
                    $('#estadoNavegadora').append("<option disabled selected>" + "Seleccione un estado" + "</option>");

                    //Primera opcion de municipio
                    $('#municipioNavegadora').append("<option disabled selected>" + "Seleccione un municipio" + "</option>");

                    for (var i = 0; i < data.length; i++) {
                        //Carga estado
                        $('#estadoNavegadora').append("<option value='" + data[i].idEstado + "'>" + data[i].nombre + "</option>");
                    }

                    $('#estadoNavegadora').prop('selectedIndex', 0);
                    $('#municipioNavegadora').prop('selectedIndex', 0);

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
                    numeroCP: $('#codigo-postalNavegadora').val()

                },
                success: function (response) {

                    if (response == 'postalCodeDoesntExist') {
                        $('#error-CPexiste').show();

                    } else {
                        $('#error-CPexiste').hide();
                        var json = JSON.parse(response);

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

        }




    });

    //Agregar Paciente
    $('#agregarPaciente').on('click', function (e) {


        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "registraUsuario",
                nombre: $('#nombreNavegadora').val(),
                curp: $('#curpNavegadora').val(),
                fechaNacimiento: $('#cumpleNavegadora').val(),
                apellido1: $('#primer-apellidoNavegadora').val(),
                apellido2: $('#segundo-apellidoNavegadora').val(),
                usuario: $('#usuarioNavegadora').val(),
                estadoCivil: $('#estado-civilNavegadora').val(),
                calle: $('#calleNavegadora').val(),
                noInterior: $('#numIntNavegadora').val(),
                noExterior: $('#numExtNavegadora').val(),
                codigoPostal: $('#codigo-postalNavegadora').val(),
                estado: $('#estadoNavegadora').val(),
                municipio: $('#municipioNavegadora').val(),
                telefono: $('#telNavegadora').val(),
                correo: $('#correoNavegadora').val(),
                colonia: $('#colNavegadora').val(),
                pass1: $('#contraNavegadora').val(),
                pass2: $('#confContraNavegadora').val(),
                terminos: $('#acepto-terminos').val()

            },
            success: function (response) {
                console.log(response);
                console.log("FUNCIONÓ! (creo)");
            }

        });


    });

    //  Editar paciente
    $('.btn-editar').on('click', function () {

        $('#hidden-idPaciente').val($(this).data('id'));


        $.ajax({

            url: 'NavegadoraController',
            cache: false,
            method: 'POST',
            data: {

                key: "obtener-paciente",
                idPaciente: $('#hidden-idPaciente').val(),

            },
            success: function (response) {

                var data = JSON.parse(response);

                console.log(data);

                $('#editarNombreNavegadoraAPaciente').val(data.nombre);
                $('#editarCurpNavegadoraAPaciente').val(data.curp);
                $('#editarCumpleNavegadoraAPaciente').val(formatDate(new Date(data.fechaNacimiento)));
                $('#editarPrimer-apellidoNavegadoraAPaciente').val(data.primerApellido);
                $('#editarSegundo-apellidoNavegadoraAPaciente').val(data.segundoApellido);
                $('#editarSegundo-apellidoNavegadoraAPaciente').val(data.segundoApellido);
                $('#editarUsuarioNavegadoraAPaciente').val(data.usuario);
                $('#editarEstado-civilNavegadora').val(data.idEstadoCivil);
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

    $('#btn-guardarCambios').on('click', function () {
        console.log("Presionó Guardar Cambios");




        // FALTA OBTENER EL ID DEL PACIENTE 

        $.ajax({
            url: 'NavegadoraController',
            cache: false,
            method: 'POST',
            data: {
                key: "actualizar-paciente",
                idPaciente: $('#hidden-idPaciente').val(),
                nombre: $('#editarNombreNavegadoraAPaciente').val(),
                apellido1: $('#editarPrimer-apellidoNavegadoraAPaciente').val(),
                apellido2: $('#editarSegundo-apellidoNavegadoraAPaciente').val(),
                usuario: $("#editarUsuarioNavegadoraAPaciente").val(),
                correo: $('#editarCorreoNavegadoraAPaciente').val(),
                curp: $('#editarCurpNavegadoraAPaciente').val(),
                colonia: $('#editarColNavegadoraAPaciente').val(),
                calle: $('#editarCalleNavegadoraAPaciente').val(),
                noExterior: $("#editarNumExtNavegadoraAPaciente").val(),
                noInterior: $("#editarNumIntNavegadoraAPaciente").val(),
                telefono: $("#editarTelNavegadoraAPaciente").val(),
                estadoCivil: $("#editarEstado-civilNavegadora").val(),
                fechaNacimiento: $("#editarCumpleNavegadoraAPaciente").val(),
                estado: $("#editarEstadoNavegadoraAPaciente").val(),
                municipio: $("#editarMunicipioNavegadoraAPaciente").val()
            }, success: function (response) {
                swal({
                    title: 'Buen Trabajo',
                    text: "Cuenta editada correctamente",
                    type: 'success',
                    confirmButtonColor: '#3085d6',
                    confirmButtonText: 'Ok'
                });
            }

        });
    });

    //Redirige a documentos
    $('.btn-ver').on('click', function () {

        var id = $(this).data('id');
        console.log(id);
        //alert('saludos con el id: ' +  $('#hidden-idPaciente').val())

        $.post("SAPI", {
            file: "navegadora/documentos.jsp",
            idPacientePotencialAtendido: id
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

    $('.irAVerDocumento').on('click', function () {

        console.log("Click");
        console.log($(this).data('id') + " " + $("#hiddenIdPaciente").val());
        $.post("SAPI", {
            file: "navegadora/verDocumento.jsp",
            idDocumentoInicialVista: $(this).data('id'),
            idPacientePotencialAtendido: $("#hiddenIdPaciente").val(),

            siguiente: 0
        },
                function (response, status, xhr) {
                    //console.log(response);
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
        );
    });

    //Aprobar paciente

    //fecha navegacion
    $('#Fecha-Navegacion').on('change', function () {

        console.log($(this).val());

    });


    //Obtene Fecha consulta
    $('#Fecha-Consulta').on('change', function () {

        console.log($(this).val());

    });

    $('.btn-aceptar').on('click', function (e) {


        $('#hidden-idPaciente').val($(this).data('id'));


    });

    $('#btn-aceptarDocumento').on('click', function () {

        alert('el id final es:' + $('#hidden-idPaciente').val());

        $.ajax({

            url: 'NavegadoraController',
            cache: false,
            method: 'POST',
            data: {

                key: "aprobar-paciente",
                idPaciente: $('#hidden-idPaciente').val(),
                fechaNavegacion: $('#Fecha-Navegacion').val(),
                fechaConsulta: $('#Fecha-Consulta').val(),
                tipoPaciente: $('#tipo-paciente').val()


            },
            success: function (response) {
                if (response == 'success') {
                    swal("Buen trabajo!", "El paciente se aprobo correctamente!", "success");
                    //$('#modalAceptarUsuario').toggle();
                    $('#Fecha-Navegacion').val('').attr("type", "text");
                    $('#Fecha-Consulta').val('').attr("type", "text");
                    $('#tipo-paciente').prop('selectedIndex', 0);


                } else {
                    swal("Algo salio mal!", "El paciente no se pudo aprobar!", "error");
                }
            }

        });
    });

    //Eliminar paciente
    $('.btn-eliminar').on('click', function () {

        alert('saludos con el id' + $(this).data('id'));

        var idPaciente = $(this).data('id');
        var boton = $(this);

        swal({
            title: "¿Estás segura?",
            text: "Una vez eliminado, el paciente y sus datos ya no se podrán recuperar.",
            icon: "warning",
            buttons: true,
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
                            success: function (response) {


                                swal("Buen trabajo!", "El paciente se eliminó correctamente!", "success");
                                boton.parent().parent().remove();


                            },
                            error: function () {
                                swal("Buen trabajo!", "El paciente se eliminó correctamente!", "error");
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
            text: "Estas observaciones se enviarán al paciente.",
            icon: "warning",
            buttons: true,
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
                            var rayosx = {tipo: $(this).find('.tipoRayosX').val(),
                                fecha: $(this).find('.fechaRayos').val()
                            };
                            rayosxs.push(rayosx);
                            console.log(rayosx);
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
                        var llamadas = [];
                        $('.tuplaLlamada').each(function () {
                            var llamada = {
                                fecha: $(this).find('.fecha-llamada').val(),
                                motivo: $(this).find('.comentario-llamada').val()
                            };
                            llamadas.push(llamada);
                            console.log(llamada);
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
            text: "Este documento será guardado como un documento válido y no podrás cambiar ese estatus.",
            icon: "warning",
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
                            success: function (response) {
                                if (response == "true")
                                {
                                    swal({
                                        type: 'success',
                                        title: 'Éxito',
                                        text: 'Se aprobó con éxito el documento.',
                                    });
                                } else
                                {
                                    swal({
                                        type: 'error',
                                        title: 'Ups',
                                        text: 'Hubo un problema al aprobar el documento.',
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


    //rechazar documento
    $('#btn-rechazarDocumento').on('click', () => {


        //ajax para rechazar

        //location.href = "./documentos3.html"
        var data = {key: "rechazarDocumento", comentario: $('#motivoRechazo').val()};
        $('#motivoRechazo').val("");
        $.ajax({
            url: "NavegadoraController",
            data: data,
            method: "POST",
            success: function (response) {
                if (response == "true")
                {
                    swal({
                        type: 'success',
                        icon: 'success',
                        title: 'Éxito',
                        text: 'Se rechazo con éxito el documento.',
                    });
                } else
                {
                    swal({
                        type: 'error',
                        icon: 'error',
                        title: 'Ups',
                        text: 'Hubo un problema al rechazar el documento.',
                    });
                }
            },
            error: function (xhr) {
                //alert(xhr.statusText);
            }

        });

    });

    $('#btn-siguiente').on('click', function () {


        swal({
            icon: 'info',
            title: 'Cargando',
            text: 'Estamos buscando el siguiente documento',
            //timer:8000,         
            buttons: false
        });

        var data = {idPacientePotencialAtendido: $('#idPacientePotencialAtendido').val(), idDocumentoInicialVista: $('#idDocumentoInicialVista').val(), key: 1};

        console.log(JSON.stringify(data));

        $.post("SAPI", {
            idPacientePotencialAtendido: $('#idPacientePotencialAtendido').val(),
            idDocumentoInicialVista: $('#idDocumentoInicialVista').val(),
            siguiente: 1,
            file: "navegadora/verDocumento.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {

                        } else if (response == "todos")
                        {
                            console.log("Redireccionar a documentos");
                            $.post("SAPI", {
                                file: "navegadora/documentos.jsp",
                                idPacientePotencialAtendido: "hola"
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
                            swal({
                                title: 'No más documentos por revisar.',
                                timer: 3000
                            });

                        } else {
                            swal.close();
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });

    $('#irADashboard').on('click', function () {
        $.post("SAPI", {
            file: "navegadora/index.jsp"
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

    $('#irACalendario').on('click', function () {

        $.post("SAPI", {
            file: "navegadora/calendar.jsp"
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

    $('#irARendimiento').on('click', function () {
        $.post("SAPI", {
            file: "navegadora/rendimiento.jsp"
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

    $('#irACuenta').on('click', function () {

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
    });

    $('#guardarCambios').on('click', function () {

        if (isValidPhoneNumber($("#telefono")) && isValidEmail($("#correo"))) {

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
                success: function (response) {
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
                title: "Datos invalidos!",
                text: "Revisa todos los campos antes de continuar",
                icon: "error",
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
                text: "No podras volver a usar tu contraseña anterior para ingresar",
                icon: "warning",
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
                                            title: "Contraseña actualizada",
                                            icon: "success",
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

    function isValidEmail(input) {

        var m = input.val();

        ////Expresion regular por el estandard: RFC 5322
        var expreg = /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;

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


        $.post("NavegadoraController",
                {
                    key: 'descargarArchivo',
                    idDocumento: $(this).data('id')
                },
                function (data, status) {

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


    function salir() {
        alert();
    }
    ;

    //VALIDACIONES
    //NOMBRE EN EL REGISTRO
    $('#nombreNavegadora').on('change', function () {

        if (isValidName($(this))) {
            $('#errorNombreNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorNombreNavegadora').hide();
        } else {
            $('#errorNombreNavegadora').show();
        }

    });

    //PRIMER APELLIDO EN EL REGISTRO
    $('#primer-apellidoNavegadora').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoPaternoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoPaternoNavegadora').hide();
        } else {
            $('#errorApellidoPaternoNavegadora').show();
        }

    });

    //SEGUNDO APELLIDO EN EL REGISTRO
    $('#segundo-apellidoNavegadora').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoMaternoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoMaternoNavegadora').hide();
        } else {
            $('#errorApellidoMaternoNavegadora').show();
        }

    });

    //NOMBRE DE USUARIO EN EL REGISTRO
    $('#usuarioNavegadora').on('change', function () {

        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteUsuario",
                usuario: $('#usuarioNavegadora').val()


            },
            success: function (response) {

                if (response == 'UsuarioAlreadyExists') {
                    $('#usuarioNavegadora').css('color', 'orange');
                    $('#errorUsuarioRepetidoNavegadora').show();
                } else {
                    $('#errorUsuarioRepetidoNavegadora').hide();
                }

            }

        });

        if (isValidUserName($(this))) {
            $('#errorNombreUsuarioNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorNombreUsuarioNavegadora').hide();
        } else {
            $('#errorNombreUsuarioNavegadora').show();
        }

    });


    //CORREO EN EL REGISTRO
    $('#correoNavegadora').on('change', function () {

        if (isValidEmail($(this))) {
            $('#errorCorreoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorCorreoNavegadora').hide();
        } else {
            $('#errorCorreoNavegadora').show();
        }

    });

    //CONTRASEÑA1 EN EL REGISTRO
    $('#contraNavegadora').on('change', function () {

        if (isValidPassword($(this))) {
            $('#errorPass1Navegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorPass1Navegadora').hide();
        } else {
            $('#errorPass1Navegadora').show();
        }

    });

    //CONTRASEÑA2 EN EL REGISTRO
    $('#confContraNavegadora').on('change', function () {

        if (isValidPassword($(this))) {
            $('#errorPass2Navegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorPass2Navegadora').hide();
        } else {
            $('#errorPass2Navegadora').show();
        }

    });

    //CURP EN EL REGISTRO
    $('#curpNavegadora').on('change', function () {

        $.ajax({
            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {
                key: "repiteCurp",
                curp: $('#curpNavegadora').val()
            },
            success: function (response) {

                if (response === 'CurpAlreadyExists') {
                    $('#curpNavegadora').css('color', 'orange');
                    $('#errorCurpRepetidoNavegadora').show();
                } else {
                    $('#errorCurpRepetidoNavegadora').hide();
                }
            }
        });

        if (isValidCURP($(this))) {
            $('#errorCurpNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorCurpNavegadora').hide();
        } else {
            $('#errorCurpNavegadora').show();
        }
    });

    //TELEFONO EN EL REGISTRO
    $('#telNavegadora').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#errorTelefonoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorTelefonoNavegadora').hide();
        } else {
            $('#errorTelefonoNavegadora').show();
        }

    });

    //ESTADO CIVIL EN EL REGISTRO
    $('#estado-civilNavegadora').on('change', function () {

        if (isValidSelect($(this))) {
            $('#errorECivilNavegadora').hide();
        } else {
            $('#errorECivilNavegadora').show();
        }

    });

    //FECHA DE NACIMIENTO EN EL REGISTRO
    $('#cumpleNavegadora').on('change', function () {

        if (isValidDate($(this))) {
            $('#errorFechaNavegadora').hide();
        } else {
            $('#errorFechaNavegadora').show();
        }

    });

    //ESTADO EN EL REGISTRO
    $('#estadoNavegadora').on('change', function () {

        if (isValidSelect($(this))) {
            $('#errorEstadoNavegadora').hide();
        } else {
            $('#errorEstadoNavegadora').show();
        }

    });

    //MUNICIPIO EN EL REGISTRO
    $('#municipioNavegadora').on('change', function () {

        if (isValidSelect($(this))) {
            $('#errorMunicipioNavegadora').hide();
        } else {
            $('#errorMunicipioNavegadora').show();
        }

    });

    //COLONIA EN EL REGISTRO
    $('#colNavegadora').on('change', function () {

        if (isValidColonia($(this))) {
            $('#errorColoniaNavegadora').hide();
        } else {
            $('#errorColoniaNavegadora').show();
        }

    });

    //CALLE EN EL REGISTRO
    $('#calleNavegadora').on('change', function () {

        if (isValidStreet($(this))) {
            $('#errorCalleNavegadora').hide();
        } else {
            $('#errorCalleNavegadora').show();
        }

    });

    //NUMERO EXTERIOR EN EL REGISTRO
    $('#numExtNavegadora').on('change', function () {

        if (isValidExtNumber($(this))) {
            $('#errorNoExteriorNavegadora').hide();
        } else {
            $('#errorNoExteriorNavegadora').show();
        }

    });

    //NUMERO INTERIOR EN EL REGISTRO
    $('#numIntNavegadora').on('change', function () {

        if (isValidIntNumber($(this))) {
            $('#errorNoInteriorNavegadora').hide();
        } else {
            $('#errorNoInteriorNavegadora').show();
        }


    });


    //NOMBRE AL EDITAR
    $('#editarNombreNavegadoraAPaciente').on('change', function () {

        if (isValidName($(this))) {
            $('#error-editar-NombreNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-NombreNavegadora').hide();
        } else {
            $('#error-editar-NombreNavegadora').show();
        }

    });

    //PRIMER APELLIDO AL EDITAR
    $('#editarPrimer-apellidoNavegadoraAPaciente').on('change', function () {

        if (isValidLastName($(this))) {
            $('#error-editar-ApellidoPaternoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-ApellidoPaternoNavegadora').hide();
        } else {
            $('#error-editar-ApellidoPaternoNavegadora').show();
        }

    });

    //SEGUNDO APELLIDO AL EDITAR
    $('#editarSegundo-apellidoNavegadoraAPaciente').on('change', function () {

        if (isValidLastName($(this))) {
            $('#error-editar-ApellidoMaternoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-ApellidoMaternoNavegadora').hide();
        } else {
            $('#error-editar-ApellidoMaternoNavegadora').show();
        }

    });

    //NOMBRE DE USUARIO AL EDITAR
    $('#editarUsuarioNavegadoraAPaciente').on('change', function () {

        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteUsuario",
                usuario: $('#editarUsuarioNavegadoraAPaciente').val()


            },
            success: function (response) {

                if (response === 'UsuarioAlreadyExists') {
                    $('#editarUsuarioNavegadoraAPaciente').css('color', 'orange');
                    $('#error-editar-UsuarioRepetidoNavegadora').show();
                } else {
                    $('#error-editar-UsuarioRepetidoNavegadora').hide();
                }

            }

        });

        if (isValidUserName($(this))) {
            $('#error-editar-NombreUsuarioNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-NombreUsuarioNavegadora').hide();
        } else {
            $('#error-editar-NombreUsuarioNavegadora').show();
        }

    });

    //CORREO AL EDITAR
    $('#editarCorreoNavegadoraAPaciente').on('change', function () {

        if (isValidEmail($(this))) {
            $('#error-editar-CorreoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-CorreoNavegadora').hide();
        } else {
            $('#error-editar-CorreoNavegadora').show();
        }

    });



    //CURP AL EDITAR
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
                    $('#error-editar-CurpRepetidoNavegadora').show();
                } else {
                    $('#error-editar-CurpRepetidoNavegadora').hide();
                }

            }
        });


        if (isValidCURP($(this))) {
            $('#error-editar-CurpNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-CurpNavegadora').hide();
        } else {
            $('#error-editar-CurpNavegadora').show();
        }

    });

    //TELEFONO AL EDITAR
    $('#editarTelNavegadoraAPaciente').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#error-editar-TelefonoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-TelefonoNavegadora').hide();
        } else {
            $('#error-editar-TelefonoNavegadora').show();
        }

    });

    //ESTADO CIVIL AL EDITAR
    $('#editarEstado-civilNavegadora').on('change', function () {

        if (isValidSelect($(this))) {
            $('#error-editar-ECivilNavegadora').hide();
        } else {
            $('#error-editar-ECivilNavegadora').show();
        }

    });

    //FECHA DE NACIMIENTO AL EDITAR
    $('#editarCumpleNavegadoraAPaciente').on('change', function () {

        if (isValidDate($(this))) {
            $('#error-editar-FechaNavegadora').hide();
        } else {
            $('#error-editar-FechaNavegadora').show();
        }

    });

    //ESTADO AL EDITAR
    $('#editarEstadoNavegadoraAPaciente').on('change', function () {

        if (isValidSelect($(this))) {
            $('#error-editar-EstadoNavegadora').hide();
        } else {
            $('#error-editar-EstadoNavegadora').show();
        }

    });

    //MUNICIPIO AL EDITAR
    $('#editarMunicipioNavegadoraAPaciente').on('change', function () {

        if (isValidSelect($(this))) {
            $('#error-editar-MunicipioNavegadora').hide();
        } else {
            $('#error-editar-MunicipioNavegadora').show();
        }

    });

    //COLONIA AL EDITAR
    $('#editarColNavegadoraAPaciente').on('change', function () {

        if (isValidColonia($(this))) {
            $('#error-editar-ColoniaNavegadora').hide();
        } else {
            $('#error-editar-ColoniaNavegadora').show();
        }

    });

    //CALLE AL EDITAR
    $('#editarCalleNavegadoraAPaciente').on('change', function () {

        if (isValidStreet($(this))) {
            $('#error-editar-CalleNavegadora').hide();
        } else {
            $('#error-editar-CalleNavegadora').show();
        }

    });

    //NUMERO EXTERIOR AL EDITAR
    $('#editarNumExtNavegadoraAPaciente').on('change', function () {

        if (isValidExtNumber($(this))) {
            $('#error-editar-NoExteriorNavegadora').hide();
        } else {
            $('#error-editar-NoExteriorNavegadora').show();
        }

    });

    //NUMERO INTERIOR AL EDITAR
    $('#editarNumIntNavegadoraAPaciente').on('change', function () {

        if (isValidIntNumber($(this))) {
            $('#error-editar-NoInteriorNavegadora').hide();
        } else {
            $('#error-editar-NoInteriorNavegadora').show();
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



    $('.btn-ver-formulario').on('click', function () {
        console.log($(this).data('id'));
        var data = {idPotencial: $(this).data('id')};
        $.post("SAPI", {
            file: "navegadora/form.jsp",
            idPotencial:  $(this).data('id')

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

    var cambiarRol = 0;

    // Pantallas del formulario 

    $('#btn-save1, #btn-save2,#btn-save3,#btn-save4,#btn-save5').on('click', function () {

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
        if (cambiarRol == 1)
            data.append("cambiarRol", cambiarRol);


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

    });



    $('.btn-perder-cita').on('click', function () {
        var idPotencial = $(this).data('id');

        //


        swal({
            title: '¿Estás segure cancelar las citas de navegación y preconsulta?',
            text: "La paciente tendrá que solicitar una nueva cita de navegación y preconsulta.",
            icon: 'warning',
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
                    success: function (response) {
                        console.log(response);
                        if (response == 0)
                        {
                            swal({
                                title: "¡Ups!",
                                text: "Ha habido un error al cancelar las citas de navegación y preconsulta.",
                                icon: "error",
                                button: "Aceptar",
                            });
                        } else
                        {
                            swal({
                                title: "Cancelación exitosa",
                                text: "Ha habido un error al cancelar las citas de navegación y preconsulta.",
                                icon: "success",
                                button: "Aceptar",
                            });
                        }
                    }
                });
            }
        });

    });
   

    var data = new FormData();
    data.append("key", "mostrarFormularioNavegadora");

    $.ajax({
        url: "NavegadoraController",
        method: "POST",
        data: {key: "mostrarFormularioNavegadora"},

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
                $('#medico-residente').val(data[0][0].medicoResidente);
                /*   $('#medico-residente option:contains(' + data[0][0].medicoResidente + ')').each(function () {
                 if ($(this).text() === data[0][0].medicoResidente) {
                 $(this).attr('selected', 'selected');
                 }
                 
                 });
                 */
            }

            if (data[0][0].fechaNavegacion !== "ene 1, 1900")
                $('#fechaNavegacion').val(convertDate(new Date(data[0][0].fechaNavegacion)));


            if (data[0][0].fechaConsulta !== "ene 1, 1900")
                $('#fechaConsulta').val(convertDate(new Date(data[0][0].fechaConsulta)));

            if ((data[0][0].noAdscrito !== true))
                $('#noAdscrito').attr('checked', 'checked');
            if ((data[0][0].noRadiologo !== true))
                $('#esSustituto').attr('checked', 'checked');
         //    if ((data[0][0].noResidente === true))
           //     $('#noResidente').attr('checked', 'checked');

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
                $('#tieneSeguroPopular').attr('checked', 'checked');
            }

            if (data[0][0].cirugiaFecha !== "ene 1, 1900" || data[0][0].cirugiaTipo !== "" || data[0][0].cirugiaComentario !== "") {
                $('#tiene-cirugia').attr('checked', 'checked');
                if ($('#tiene-cirugia').is(':checked')) {
                    $('#divCirugia').show();
                } else {
                    $('#divCirugia').hide();
                }

                if (data[0][0].cirugiaFecha !== "ene 1, 1900")
                    $('#fecha-cirugia').val(convertDate(new Date(data[0][0].cirugiaFecha)));

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

            if (data[0][0].quimioterapiaFecha !== "ene 1, 1900" || data[0][0].quimioterapiaCiclo !== -1 || data[0][0].quimioterapiaComentario !== "") {
                $('#tiene-quimioterapia').attr('checked', 'checked');
                if ($('#tiene-quimioterapia').is(':checked')) {
                    $('#divQuimioterapia').show();
                } else {
                    $('#divQuimioterapia').hide();
                }

                if (data[0][0].quimioterapiaFecha !== "ene 1, 1900")
                    $('#fecha-quimioterapia').val(convertDate(new Date(data[0][0].quimioterapiaFecha)));

                if ((data[0][0].quimioterapiaCiclo !== -1)) {
                    $('#quimioterapia').val(data[0][0].quimioterapiaComentario);
                }
                if (data[0][0].quimioterapiaComentario !== "") {
                    $('#detalle-quimioterapia').val(data[0][0].quimioterapiaComentario);
                }

            }

            if (data[0][0].radioterapiaFecha !== "ene 1, 1900" || data[0][0].radioterapiaCiclo !== -1 || data[0][0].radioterapiaComentario !== "") {
                $('#tiene-radioterapia').attr('checked', 'checked');
                if ($('#tiene-radioterapia').is(':checked')) {
                    $('#divRadioterapia').show();
                } else {
                    $('#divRadioterapia').hide();
                }

                if (data[0][0].radioterapiaFecha !== "ene 1, 1900")
                    // $('#fecha-radioterapia').val(convertDate(new Date(data[0][0].radioterapiaFecha)));
                    $('#fecha-radioterapia').val(data[0][0].radioterapiaFecha);

                if ((data[0][0].cirugiaTipo !== -1)) {
                    $('#radioterapia').val(data[0][0].radioterapiaCiclo);
                }
                if (data[0][0].radioterapiaComentario !== "") {
                    $('#detalle-radioterapia').val(data[0][0].radioterapiaComentario);
                }

            }

            if (data[0][0].mastografiaBiradsNombre !== "" || data[0][0].mastografiaBiradsFecha !== "ene 1, 1900") {
                $('#tiene-mastografia').attr('checked', 'checked');
                if ($('#tiene-mastografia').is(':checked')) {
                    $('#tipoMastografia').show();
                    $('#fechaPreMasto').show();
                } else {
                    $('#tipoMastografia').hide();
                    $('#fechaPreMasto').hide();
                }

                if ((data[0][0].mastografiaBiradsFecha !== "ene 1, 1900")) {
                    $('#fechaPreMasto').val(data[0][0].mastografiaBiradsFecha);
                }
                if ((data[0][0].mastografiaBiradsNombre !== "")) {
                    $('#tipoMastografia option:contains(' + $.trim(data[0][0].mastografiaBiradsNombre) + ')').each(function () {
                        if ($.trim($(this).text()) === $.trim(data[0][0].mastografiaBiradsNombre)) {
                            $(this).attr('selected', 'selected');
                        }

                    });
                }
            }

            if (data[0][0].ultrasonidoBiradsNombre !== "" || data[0][0].ultrasonidoBiradsFecha !== "ene 1, 1900") {
                $('#tiene-ultrasonido-mama').attr('checked', 'checked');
                if ($('#tiene-ultrasonido-mama').is(':checked')) {
                    $('#fechaPreUsg').show();
                    $('#tipoUltrasonidoMama').show();
                } else {
                    $('#fechaPreUsg').hide();
                    $('#tipoUltrasonidoMama').hide();
                }

                if ((data[0][0].ultrasonidoBiradsFecha !== "ene 1, 1900")) {
                    $('#fechaPreUsg').val(data[0][0].ultrasonidoBiradsFecha);
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


//3. recorrer el arreglo
            for (var i = 0; i < data[1].length; i++) {
                var plantilla =
                        `<div class="form-group row mt-2 tuplaBiopsia">

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
                    <input name="fecha-BipsiaAdded" value="${data[1][i].CitaProgramada}" placeholder="Fecha de la biopsia" class="form-control fechaBiopsia" type="text" onfocus="(this.type='date')">
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
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaRayosX">

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
                        <input name ="fecha-RayosXAdded" value="${data[2][i].CitaProgramada}" placeholder="Fecha de los Rayos X" class="form-control fechaRayos" type="text" onfocus="(this.type='date')">
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
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaUltrasonido">

               
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
                        <input name ="fecha-USGAdded" value="${data[3][i].CitaProgramada}" placeholder="Fecha de USG" class="form-control fechaUltrasonido" type="text" onfocus="(this.type='date')">
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
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaMedicinaNuclear">
    
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
                            <input name ="fecha-mNuclearAdded" value="${data[4][i].CitaProgramada}" placeholder="Fecha de medicina nuclear" class="form-control fechaMedicinaNuclear" type="text" onfocus="(this.type='date')">
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
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaLaboratorio">

                <div class="col-10">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </div>
                        </div>
                        <input name ="fecha-LaboAdded" value="${data[5][i].CitaProgramada}" placeholder="Fecha de laboratorio" class="form-control fechaLaboratorio" type="text" onfocus="(this.type='date')">
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
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaValoracion">

       
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
                        <input name ="fecha-valoracionAdded" value="${data[6][i].CitaProgramada}" placeholder="Fecha de valoración" class="form-control fechaValoracion" type="text" onfocus="(this.type='date')">
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
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaEspirometria">

                <div class="col-10">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </div>
                        </div>
                        <input name="fecha-espilometriaAdded" value="${data[7][i].CitaProgramada}" placeholder="Fecha de espirometría" class="form-control fechaEspirometria" type="text" onfocus="(this.type='date')">
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
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaElectrocardiograma">

                    <div class="col-10">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fas fa-calendar-alt"></i>
                                </div>
                            </div>
                            <input name="fecha-ECGAdded" value="${data[8][i].CitaProgramada}" placeholder="Fecha de electrocardiograma" class="form-control fechaElectrocardiograma" type="text" onfocus="(this.type='date')">
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
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaEcocardiograma">

                    <div class="col-10">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fas fa-calendar-alt"></i>
                                </div>
                            </div>
                            <input name="fecha-ecoAdded" value="${data[9][i].CitaProgramada}" placeholder="Fecha de ecocardiograma" class="form-control fechaEcocardiograma" type="text" onfocus="(this.type='date')">
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
                var plantilla =
                        `
            <div class="form-group row mt-2 tuplaTrabajoSocial">

                <div class="col-10">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <i class="fas fa-calendar-alt"></i>
                            </div>
                        </div>
                        <input name="fecha-tSocilaAdded" value="${data[10][i].CitaProgramada}" placeholder="Fecha de trabajo social" class="form-control fechaTrabajoSocial" type="text" onfocus="(this.type='date')">
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
                var plantilla =
            `
            <div class="form-group row mt-2 tuplaPrograma">


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
                            <input name="fecha-programaAdded" value="${data[11][i].CitaProgramada}" placeholder="Fecha del programa" class="form-control fechaPrograma" type="text" onfocus="(this.type='date')">
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
              var plantilla =
            `
            <div class="form-group row mt-2 tuplaOtro">

                    <div class="col-5">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fas fa-calendar-alt"></i>
                                </div>
                            </div>
                            <input name="fecha-otroAdded" value="${data[12][i].CitaProgramada}" placeholder="Fecha de otro" class="form-control fechaOtro" type="text" onfocus="(this.type='date')">
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
                $('#llamadaInit').show();

            } else {
                $('#llamadaInit').hide();
            }


//3. recorrer el arreglo
            for (var i = 0; i < data[13].length; i++) {
                var plantilla =
                        `
            <div class="tuplaLlamada mt-3">
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
                        <textarea class="form-control comentario-llamada" style="min-height:100px;" value="${data[12][i].comentarioLLamada}" placeholder="Introduce el motivo de la llamada "></textarea>
                    </div>
                </div>
            </div>
        
     `

                $('.llamadaInit').append(plantilla);

            }

            if (data[0][0].fechaFin !== "ene 1, 1900")
                $('#fecha-decisionPreconsulta').val(data[0][0].fechaFin);

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
                $('#tipoMastografia option:contains(' + $.trim(data[0][0].masto) + ')').each(function () {
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

            if (data[0][0].ki67 !== "")
                $('#ki67').val(data[0][0].ki67);


        },
        error: function (request, status, error) {
            console.log("Enviar datos Error " + request.responseText);
            console.log("Enviar datos Error status " + status);
            console.log("Enviar datos Error error" + error);
            //alert("No enontre el controlador" + status);                               
        }
    });

    function convertDate(date) {

        var yyyy = date.getFullYear().toString();
        var mm = (date.getMonth() + 1).toString();
        var dd = date.getDate().toString();

        var mmChars = mm.split('');
        var ddChars = dd.split('');

        return yyyy + '-' + (mmChars[1] ? mm : "0" + mmChars[0]) + '-' + (ddChars[1] ? dd : "0" + ddChars[0]);
    }

});




function isValidEmail(input) {

    var m = input.val();

    ////Expresion regular por el estandard: RFC 5322
    var expreg = /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;

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

    var expreg = /^[-a-zA-Z\u00E0-\u00FCñÑ. ]{2,255}$/;

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

    var expreg = /^[-a-zA-Z\u00E0-\u00FCñÑ. ]{2,127}$/;

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