$(document).ready(function () {


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
                $('#editarCumpleNavegadoraAPaciente').val(data.fechaNacimiento);
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
        /*
        $.ajax({
                url: 'NavegadoraController',
                cache: false,
                method: 'POST',
                data: {
                    key: "actualizar-paciente",
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
                },success: function (response) {
                        swal({
                            title: 'Buen Trabajo',
                            text: "Cuenta registrada correctamente",
                            type: 'success',
                            confirmButtonColor: '#3085d6',
                            confirmButtonText: 'Ok'
                        })
                    }

            });*/
    });

    //Redirige a documentos
    $('#irADocumentos').on('click', function () {
        $.get("SAPI", {
            file: "navegadora/documentos.jsp"
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

    $('#idACalendario').on('click', function () {
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

                                        swal({
                                            title: 'Buen Trabajo',
                                            text: "Cambios guardados correctamente",
                                            type: 'success',
                                            confirmButtonColor: '#3085d6',
                                            confirmButtonText: 'Ok'
                                        })

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
        readURL(this);
    });

    //Cambiar contraseña

    $("#btn-updatePassword").on('click', function () {



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

    $('#irVerDocumento').on('click', function () {
        $.post("SAPI", {
            file: "navegadora/verDocumento.jsp"
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

    function salir() {
        alert();

    }
    ;



});

