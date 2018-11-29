$(document).ready(function () {

    /////////////////// GESTION ADMINISTRADORES

    ///////Agregar un nuevo administrador

    //Esconder mensajes de error
    $('#errorNombreAdministrador').hide();
    $('#errorTelefonoAdministrador').hide();
    $('#errorApellidoPaternoAdministrador').hide();
    $('#errorApellidoMaternoAdministrador').hide();
    $('#errorCorreoAdministrador').hide();
    $('#errorCorreoRepetidoAdministrador').hide();
    $('#errorNumEmpleadoAdministrador').hide();
    $('#errorAgregarEspecialidadAdministrador').hide();
    $('#errorAgregarPosicionAdministrador').hide();
    $('#errorCedulaAdministrador').hide();
    $('#errorPass1Administrador').hide();
    $('#errorPass2Administrador').hide();
    $('#noEqualPasswordsErrorAdministrador').hide();
    $('#errorTerminosAdministrador').hide();


    var cambioImagen = false;
    var imagenValida = false;

    $("#error-camposAdministrador").hide();
    $("#error-datosRepetidosAdministrador").hide();


    $('#btn-agregarAdministrador').on('click', function () {
        if (!repiteCorreoAdministrador) {

            $("#error-datosRepetidosAdministrador").hide();

            if (isValidName($("#agregar-nombreAdministrador")) && isValidPhoneNumber($("#agregar-telefonoAdministrador"))
                    && isValidLastName($('#agregar-primerApellidoAdministrador')) && $('#errorApellidoMaternoAdministrador').hide()
                    && isValidEmail($('#agregar-correoAdministrador')) && isValidNumEmpleado($('#agregar-noEmpleadoAdministrador'))
                    && isValidAddEspecialidadAdmin && isValidAddPosicionAdmin
                    && $('#errorCedulaAdministrador').hide() && isValidPassword($('#agregar-passwordAdministrador'))
                    && isValidPassword($('#agregar-password2Administradores'))
                    && areEqualPasswords($('#agregar-passwordAdministrador'), $('#agregar-password2Administradores'))
                    && isValidCheckbox($('#terminosAdministrador'))) {

                $("#error-camposAdministrador").hide();


                $.ajax({
                    url: 'RegistraUsuarioController',
                    method: "POST",
                    beforeSend: function () {
                        $('.cargandoAgregarAdmin').fadeIn();
                    },
                    cache: false,
                    data: {
                        key: "agregarAdministrador",
                        nombre: $('#agregar-nombreAdministrador').val(),
                        telefono: $('#agregar-telefonoAdministrador').val(),
                        primerApellido: $('#agregar-primerApellidoAdministrador').val(),
                        segundoApellido: $('#agregar-segundoApellidoAdministrador').val(),
                        correo: $('#agregar-correoAdministrador').val(),
                        noEmpleado: $('#agregar-noEmpleadoAdministrador').val(),
                        especialidad: $('#agregar-especialidadAdministrador').val(),
                        posicion: $('#agregar-posiciondAdministrador').val(),
                        cedula: $('#agregar-cedulaAdministrador').val(),
                        password: $('#agregar-passwordAdministrador').val()

                    },
                    complete: function () {
                        $('.cargandoAgregarAdmin').fadeOut();
                    },
                    success: function (response) {
                        if (response == "success") {

                            //mensaje de confirmacion
                            swal({
                                title: "¡Buen trabajo!",
                                text: "Administrador agregado correctamente.",
                                icon: "success",
                                buttons: [, 'Aceptar'],
                            });


                            //limpiar los campos del modal
                            $('#agregar-nombreAdministrador').val('');
                            $('#agregar-telefonoAdministrador').val('');
                            $('#agregar-primerApellidoAdministrador').val('');
                            $('#agregar-segundoApellidoAdministrador').val('');
                            $('#agregar-correoAdministrador').val('');
                            $('#agregar-noEmpleadoAdministrador').val('');
                            $('#agregar-especialidadAdministrador').val('');
                            $('#agregar-posiciondAdministrador').val('');
                            $('#agregar-cedulaAdministrador').val('');
                            $('#agregar-passwordAdministrador').val('');
                            $('#agregar-password2Administradores').val('');
                            $("#terminosAdministrador").prop("checked", false);

                            //cerrar el modal
                            $('#modalAgregarAdministrador').modal('toggle');

                        } else {
                            swal("Error", "Hubo un problema al agregar el administrador", "error");
                        }

                    }


                });

            } else {
                swal("Error", "Verifica que todos los campos sean correctos", "error");
            }

        } else {
            console.log("Entro al segundo else");
            $("#error-datosRepetidosAdministrador").show(); //ya existe un campo
            $("#error-camposAdministrador").hide();
        }
    });

    ///////Editar un administrador

    //Esconder mensajes de error
    $('#errorEditarNombreAdministrador').hide();
    $('#errorEditarApellidoPaternoAdministrador').hide();
    $('#errorEditarApellidoMaternoAdministrador').hide();
    $('#errorEditarCorreoAdministrador').hide();
    $('#errorEditarCorreoRepetidoAdministrador').hide();
    $('#errorEditarTelefonoAdministrador').hide();
    $('#errorEditarNumEmpleadoAdministrador').hide();
    $('#errorEditarEspecialidadAdministrador').hide();
    $('#errorEditarCedulaAdministrador').hide();
    $('#error-editarDatosRepetidosAdministrador').hide();
    $('#errorEditarPosicionAdministrador').hide();



    //Recupera administrador
    $('body').on('click', '.btn-editarAdministrador', function () {

        var idAdmin = $(this).data('id');
        console.log("idAdmin " + idAdmin);

        $.ajax({

            url: 'AdministradorController',
            method: "POST",
            cache: false,
            data: {
                key: "obtener-admin",
                idAdmin: idAdmin
            },
            success: function (response) {

                response = JSON.parse(response);

                console.log("EL RESPONSE");
                console.log(response);

                $('#idAdministrador').val(response.idEmpleado);
                $('#editar-nombreAdministrador').val(response.nombre);
                $('#editar-primerApellidoAdministrador').val(response.primerApellido);
                $('#editar-segundoApellidoAdministrador').val(response.segundoApellido);
                $('#editar-correoAdministrador').val(response.correo);
                $('#editar-telefonoAdministrador').val(response.telefono);
                $('#editar-noEmpleadoAdministrador').val(response.noEmpleado);
                $('#editar-especialidadAdministrador').val(response.nombreEspecialidad);
                $('#editar-posicionAdministrador').val(response.nombrePosicion);
                $('#editar-cedulaProfesionalAdministrador').val(response.cedulaProfesional);

            }
        });

    });

    ///////Eliminar un administrador
    $('body').on('click', '.btn-eliminarAdministrador', function () {

        var t = $('#tablaAdministradores').DataTable();
        var fila = $(this).parents('tr');

        var idAdmin = $(this).data('id');


        swal({
            title: "¿Estás seguro?",
            text: "Los datos se eliminarán y no podrás recuperarlos.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
                .then((eliminar) => {
                    if (eliminar) {

                        $.ajax({

                            url: 'AdministradorController',
                            cache: false,
                            method: 'POST',
                            data: {
                                key: 'eliminarEmpleado',
                                idEmpleado: idAdmin
                            },
                            success: function (response) {
                                if (response == "error") {
                                    alert("Error al cargar");
                                } else {
                                    t.row(fila).remove().draw();
                                }
                            },
                            error: function (xhr) {

                            }
                        });
                    }
                });

    });


    //Guarda administrador
    $('#btn-guardarAdministrador').on('click', function () {

        if (!repiteCorreoAdministrador) {
            $("#error-editarDatosRepetidosAdministrador").hide();

            if (isValidName($('#editar-nombreAdministrador')) && isValidLastName($('#editar-primerApellidoAdministrador')) && $('#errorEditarApellidoMaternoAdministrador').hide()
                    && $('#errorEditarCedulaAdministrador').hide()
                    && isValidNumEmpleado($('#editar-noEmpleadoAdministrador')) && isValidEmail($('#editar-correoAdministrador'))
                    && isValidPhoneNumber($('#editar-telefonoAdministrador')) && isValidEditEspecialidadAdmin && isValidEditPosicionAdmin
                    && $('#errorEditarCorreoRepetidoAdministrador').hide()) {

                var idAdmin = $('#idAdministrador').val();

                $.ajax({

                    url: 'AdministradorController',
                    method: 'POST',
                    beforeSend: function () {
                        $('.cargandoEditarAdmin').fadeIn();
                    },
                    cache: false,
                    data: {
                        key: 'actualizar-admin',
                        idAdmin: $('#idAdministrador').val(),
                        nombre: $('#editar-nombreAdministrador').val(),
                        primerApellido: $('#editar-primerApellidoAdministrador').val(),
                        segundoApellido: $('#editar-segundoApellidoAdministrador').val(),
                        correo: $('#editar-correoAdministrador').val(),
                        telefono: $('#editar-telefonoAdministrador').val(),
                        noEmpleado: $('#editar-noEmpleadoAdministrador').val(),
                        especialidad: $('#editar-especialidadAdministrador').val(),
                        posicion: $('#editar-posicionAdministrador').val(),
                        cedula: $('#editar-cedulaProfesionalAdministrador').val()
                    },
                    complete: function () {
                        $('.cargandoEditarAdmin').fadeOut();
                    },
                    success: function (response) {

                        $('#modalEditarAdministrador').modal('toggle'); //cerrar modal
                        console.log("Cierra el modal");
                        swal({
                            title: "Cambios guardados correctamente",
                            icon: "success",
                            buttons: true,
                            buttons: [, 'Aceptar']
                        });
                        console.log("ESTOY EN EL SUCCESS!! :o");
                        $('#nombre-' + idAdmin).html($('#editar-nombreAdministrador').val() + " " + $('#editar-primerApellidoAdministrador').val() + " " + $('#editar-segundoApellidoAdministrador').val());
                        $('#correo-' + idAdmin).html($('#editar-correoAdministrador').val());
                        $('#telefono-' + idAdmin).html($('#editar-telefonoAdministrador').val());
                        $('#noEmpleado-' + idAdmin).html($('#editar-noEmpleadoAdministrador').val());
                        $('#nombreEspecialidad-' + idAdmin).html($('#editar-especialidadAdministrador').val());
                        $('#cedulaProfesional-' + idAdmin).html($('#editar-cedulaProfesionalAdministrador').val());

                    }


                });

            }
        } else {
            console.log("Entro al segundo else");
            $("#error-editarDatosRepetidosAdministrador").show(); //ya existe un campo
        }

    });

    ////////////////////////////////////////////////////////////////////////////
    //////////////////////Validaciones Agregar Administrador////////////////////
    ////////////////////////////////////////////////////////////////////////////

    $('#agregar-nombreAdministrador').on('change', function () {

        if (isValidName($(this))) {
            $('#errorNombreAdministrador').hide();
        } else if ($(this).val() == '') {
            $('#errorNombreAdministrador').hide();
        } else {
            $('#errorNombreAdministrador').show();
        }
    });

    $('#agregar-telefonoAdministrador').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#errorTelefonoAdministrador').hide();
        } else if ($(this).val() == '') {
            $('#errorTelefonoAdministrador').hide();
        } else {
            $('#errorTelefonoAdministrador').show();
        }

    });

    $('#agregar-primerApellidoAdministrador').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoPaternoAdministrador').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoPaternoAdministrador').hide();
        } else {
            $('#errorApellidoPaternoAdministrador').show();
        }

    });


    var repiteCorreoAdministrador;

    $('#agregar-correoAdministrador').on('change', function () {
        $.ajax({

                url: 'RegistraUsuarioController',
                method: "POST",
                cache: false,
                data: {
                    key: "repiteCorreo",
                    correo: $('#agregar-correoAdministrador').val()
                },
            success: function (response) {

                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#agregar-correoAdministrador').css('color', 'orange');
                    $('#errorCorreoRepetidoAdministrador').show();
                    repiteCorreoAdministrador = true;
                } else {
                    $('#errorCorreoRepetidoAdministrador').hide();
                    repiteCorreoAdministrador = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#errorCorreoAdministrador').hide();
        } else if ($(this).val() == '') {
            $('#errorCorreoAdministrador').hide();
        } else {
            $('#errorCorreoAdministrador').show();
        }

    });

    $('#agregar-segundoApellidoAdministrador').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoMaternoAdministrador').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoMaternoAdministrador').hide();
        } else {
            $('#errorApellidoMaternoAdministrador').show();
        }

    });

    $('#agregar-noEmpleadoAdministrador').on('change', function () {

        if (isValidNumEmpleado($(this))) {
            $('#errorNumEmpleadoAdministrador').hide();
        } else if ($(this).val() == '') {
            $('#errorNumEmpleadoAdministrador').hide();
        } else {
            $('#errorNumEmpleadoAdministrador').show();
        }

    });

    $('#agregar-cedulaAdministrador').on('change', function () {

        if (isValidCedula($(this))) {
            $('#errorCedulaAdministrador').hide();
        } else if ($(this).val() == '') {
            $('#errorCedulaAdministrador').hide();
        } else {
            $('#errorCedulaAdministrador').show();
        }

    });

    $('#agregar-passwordAdministrador').on('change', function () {

        if (isValidPassword($(this))) {
            $('#errorPass1Administrador').hide();
        } else if ($(this).val() == '') {
            $('#errorPass1Administrador').hide();
        } else {
            $('#errorPass1Administrador').show();
        }

    });

    $('#agregar-password2Administradores').on('change', function () {

        var pass1 = $('#agregar-passwordAdministrador');
        var pass2 = $('#agregar-password2Administradores');

        areEqualPasswords(pass1, pass2);

    });

    //12.- Terminos
    $('#terminosAdministrador').on('change', function () {

        if (isValidCheckbox($(this))) {
            $('#errorTerminosAdministrador').hide();
        } else {
            $('#errorTerminosAdministrador').show();
        }
    });


    /////////////////////////////// MI CUENTA ////////
    $('#error-imgPerfil').hide();
    $('.error-correo').hide();
    $('.error-correoRepetido').hide();
    $('.error-usuario').hide();
    $('.error-usuarioRepetido').hide();
    $('#error-contrasena').hide();
    $('#noEqualPasswordsError').hide();

    //Limpiar los campos en el modal y cerrar los mensajes de error
    $('.cleanerModal').on('click', function () {
        $('#password').val('');
        $('#password2').val('');
        $('#error-contrasena').hide();
        $('#noEqualPasswordsError').hide();
        $('#password').css('border', '');
        $('#password').css('color', '');
        $('#password2').css('border', '');
        $('#password2').css('color', '');

    });

    //Guardar cambios

    $("#guardarCambios").on('click', function () {

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
            if (isValidEmail($('#correo')) && !existeCorreo($("#correo").val())) {

                console.log("Presionó GuardarCambios");
                var form = $("form")[0];
                console.log(form);
                var data = new FormData(form);
                data.append("key", "guardarCambios");
                data.forEach((value, key) => {
                    console.log(key + " " + value);
                });

                $.ajax({
                    url: "AdministradorController",
                    data: data,
                    method: "POST",
                    enctype: 'multipart/form-data',
                    processData: false, // Important!
                    contentType: false,
                    cache: false,
                    success: function (response) {

                        swal({
                            title: "Buen trabajo!",
                            text: "Cuenta actualizada correctamente",
                            icon: "success",
                            button: "Ok",
                        })
                                .then((value) => {
                                    $.post("SAPI", {
                                        file: "administrador/cuentaAdministrador.jsp"
                                    },
                                            function (response, status, xhr) {
                                                console.log("El ajax fue exitoso!!-----------------------");
                                                if (status == "success") {
                                                    if (response == "error") {
                                                        swal("Error", "Hubo un error actualizando tus datos", "error");
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
                        //alert(xhr.statusText);
                    }
                });


            } else {
                swal({
                    title: "Error",
                    text: "Verifica que todos los datos sean validos",
                    icon: "error",
                    button: "Entendido!",
                });
            }
        } else {
            swal({
                title: "¡Datos inválidos!",
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

    ////*****CAMBIAR CONTRASEÑA
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
                                url: "AdministradorController",
                                data: {
                                    key: "cambiarContrasena",
                                    idCuenta: $("#sesionPaciente").val(),
                                    password: $("#password").val(),
                                    password2: $("#password2").val()
                                },
                                method: "POST",
                                success: function (response) {
                                    if (response == "success") {
                                        swal({
                                            title: "Buen trabajo!",
                                            text: "Contraseña actualizada correctamente!",
                                            icon: "success",
                                            button: "Entendido!",
                                        });

                                        //limpia los campos y cierra el modal
                                        $("#password").val('');
                                        $("#password2").val('');
                                        $('#modalCambiarContraseña').modal('toggle');
                                    }
                                },
                                error: function (xhr) {

                                }
                            });

                        }
                    });
        }

    });


    ////*****VERIFICAR QUE EL USUARIO Y EL EMAIL NO EXISTAN
    $('#username').on('change', function () {

        $.ajax({

            url: 'RegistraUsuarioController',
            method: "POST",
            cache: false,
            data: {
                key: "repiteUsuario",
                usuario: $('#username').val()
            },
            success: function (response) {
                if (response == "UsuarioAlreadyExists") {
                    $('.error-usuarioRepetido').show();
                } else {
                    $('.error-usuarioRepetido').hide();
                }
            }

        });


    });

    $("#correo").on("change", function () {

        $.ajax({

            url: 'PotencialController',
            method: "POST",
            cache: false,
            data: {
                key: "repiteCorreo",
                correo: $('#correo').val()
            },
            success: function (response) {

                if (response == "CorreoAlreadyExists") {
                    $('.error-correoRepetido').show();
                    $('#correo').css('color', 'orange');
                } else {
                    $('.error-correoRepetido').hide();
                    $('#correo').css('color', '');
                }
            }

        });

    });

    function existeUsuario(usuario) {

        var existe = true;

        $.ajax({

            url: 'PotencialController',
            method: "POST",
            async: false,
            cache: false,
            data: {
                key: "repiteUsuario",
                usuario: usuario
            },
            success: function (response) {

                if (response != "UsuarioAlreadyExists") {
                    existe = false;
                }
            }

        });


        return existe;
    }

    function existeCorreo(correo) {

        var existe = true;

        $.ajax({

            url: 'PacienteController',
            method: "POST",
            async: false,
            cache: false,
            data: {
                key: "repiteCorreo",
                correo: correo
            },
            success: function (response) {
                if (response != "CorreoAlreadyExists") {
                    existe = false;
                }
            }

        });


        return existe;
    }

    //1.- Usuario
    $('#username').on('change', function () {
        if (isValidUserName($('#username'))) {
            $('#error-usuario').hide();

        } else {
            $('#error-usuario').show();

        }
    });

    //2.- Correo
    $('#correo').on('change', function () {
        if (isValidEmail($('#correo'))) {
            $('.error-correo').hide();

        } else {
            $('.error-correo').show();

        }
    });

    $("#password").on('change', function () {
        if (isValidPassword($(this)))
            $("#error-contrasena").hide();
        else
            $("#error-contrasena").show();
    });

    //CONTRASEÑAS IGUALES EN CUENTA
    $('#password2').on('change', function () {

        var pass1 = $('#password');
        var pass2 = $('#password2');

        areEqualPasswords(pass1, pass2);

    });


    //CONTRASEÑA EN AGREGAR MÉDICO
    $('#password').on('change', function () {

        if (isValidPassword($(this))) {
            $('#error-contrasena').hide();
        } else if ($(this).val() == '') {
            $('#error-contrasena').hide();
        } else {
            $('#error-contrasena').show();
        }
    });

    /////////////////////////////// GESTION MEDICOS ////// 

    //Errores al agregar a un médico
    $('#errorNombreMedico').hide();
    $('#errorTelefonoMedico').hide();
    $('#errorApellidoPaternoMedico').hide();
    $('#errorApellidoMaternoMedico').hide();
    $('#errorCorreoMedico').hide();
    $('#errorCorreoRepetido').hide();
    $('#errorNumEmpleado').hide();
    $('#errorCedulaMedicos').hide();
    $('#errorPass1Medico').hide();
    $('#noEqualPasswordsError').hide();
    $('#error-campos').hide();
    $('#error-datosRepetidos').hide();
    $('#errorAgregarEspecialidad').hide();
    $('#errorAgregarPosicion').hide();

    //Errores al editar a un médico
    $('#errorEditarNombreMedico').hide();
    $('#errorEditarTelefonoMedico').hide();
    $('#errorEditarApellidoPaternoMedico').hide();
    $('#errorEditarApellidoMaternoMedico').hide();
    $('#errorEditarCorreoMedico').hide();
    $('#errorEditarCorreoRepetido').hide();
    $('#errorEditarNumEmpleado').hide();
    $('#errorEditarCedulaMedicos').hide();
    $('#error-editarDatosRepetidos').hide();
    $('#errorEditarEspecialidad').hide();
    $('#errorEditarPosicion').hide();


    var repiteCorreo;

    ////////////////////////////////////////////////////////////////////////////
    /////////////////// VALIDACIONES AGREGAR MEDICO ////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    //TELEFONO EN AGREGAR MÉDICO
    $('#agregar-telefonoMedico').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#errorTelefonoMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorTelefonoMedico').hide();
        } else {
            $('#errorTelefonoMedico').show();
        }

    });

    //CÉDULA PROFESIONAL EN AGREGAR MÉDICO
    $('#agregar-cedulaMedico').on('change', function () {

        if (isValidCedula($(this))) {
            $('#errorCedulaMedicos').hide();
        } else if ($(this).val() == '') {
            $('#errorCedulaMedicos').hide();
        } else {
            $('#errorCedulaMedicos').show();
        }

    });

    //NÚMERO DE EMPLEADO EN AGREGAR MÉDICO
    $('#agregar-noEmpleadoMedico').on('change', function () {

        if (isValidNumEmpleado($(this))) {
            $('#errorNumEmpleado').hide();
        } else if ($(this).val() == '') {
            $('#errorNumEmpleado').hide();
        } else {
            $('#errorNumEmpleado').show();
        }

    });

    //PARA MÉDICOS
    var isValidAddEspecialidad;
    var dato2 = $("#agregar-especialidadMedico");

    dato2.on('keyup', function (e) {
        var option = $('#listEspecialidades option').filter(function () {
            return this.value === $("#agregar-especialidadMedico").val();
        }).val();

        if (option) {
            $('#errorAgregarEspecialidad').hide();
            dato2.css('border', '');
            dato2.css('color', '');
            isValidAddEspecialidad = true;
        } else if (dato2.val() == '') {
            $('#errorAgregarEspecialidad').hide();
            dato2.css('border', '');
            dato2.css('color', '');
            isValidAddEspecialidad = false;
        } else {
            $('#errorAgregarEspecialidad').show();
            dato2.css('border', '1px solid red');
            dato2.css('color', 'red');
            isValidAddEspecialidad = false;
        }
    });

    //PARA ADMINISTRADORES
    var isValidAddEspecialidadAdmin;
    var datoAdmin = $("#agregar-especialidadAdministrador");

    datoAdmin.on('keyup', function (e) {
        var option = $('#listEspecialidades option').filter(function () {
            return this.value === $("#agregar-especialidadAdministrador").val();
        }).val();

        if (option) {
            $('#errorAgregarEspecialidadAdministrador').hide();
            datoAdmin.css('border', '');
            datoAdmin.css('color', '');
            isValidAddEspecialidadAdmin = true;
        } else if (datoAdmin.val() == '') {
            $('#errorAgregarEspecialidadAdministrador').hide();
            datoAdmin.css('border', '');
            datoAdmin.css('color', '');
            isValidAddEspecialidadAdmin = false;
        } else {
            $('#errorAgregarEspecialidadAdministrador').show();
            datoAdmin.css('border', '1px solid red');
            datoAdmin.css('color', 'red');
            isValidAddEspecialidadAdmin = false;
        }
    });


    //PARA MÉDICO
    var isValidEditEspecialidad = true;
    var dato2EditEspecialidad = $("#editar-especialidadMedico");

    dato2EditEspecialidad.on('keyup', function (e) {
        var option = $('#listEspecialidades option').filter(function () {
            return this.value === $("#editar-especialidadMedico").val();
        }).val();

        if (option) {
            $('#errorEditarEspecialidad').hide();
            dato2EditEspecialidad.css('border', '');
            dato2EditEspecialidad.css('color', '');
            isValidEditEspecialidad = true;
        } else if (dato2EditEspecialidad.val() == '') {
            $('#errorAgregarEspecialidad').hide();
            dato2EditEspecialidad.css('border', '');
            dato2EditEspecialidad.css('color', '');
            isValidEditEspecialidad = false;
        } else {
            $('#errorEditarEspecialidad').show();
            dato2EditEspecialidad.css('border', '1px solid red');
            dato2EditEspecialidad.css('color', 'red');
            isValidEditEspecialidad = false;
        }
    });

    //PARA ADMINISTRADOR
    var isValidEditEspecialidadAdmin = true;
    var dato2EditEspecialidadAdmin = $("#editar-especialidadAdministrador");

    dato2EditEspecialidadAdmin.on('keyup', function (e) {
        var option = $('#listEspecialidades option').filter(function () {
            return this.value === $("#editar-especialidadAdministrador").val();
        }).val();

        if (option) {
            $('#errorEditarEspecialidadAdministrador').hide();
            dato2EditEspecialidadAdmin.css('border', '');
            dato2EditEspecialidadAdmin.css('color', '');
            isValidEditEspecialidadAdmin = true;
        } else if (dato2EditEspecialidadAdmin.val() == '') {
            $('#errorEditarEspecialidadAdministrador').hide();
            dato2EditEspecialidadAdmin.css('border', '');
            dato2EditEspecialidadAdmin.css('color', '');
            isValidEditEspecialidadAdmin = false;
        } else {
            $('#errorEditarEspecialidadAdministrador').show();
            dato2EditEspecialidadAdmin.css('border', '1px solid red');
            dato2EditEspecialidadAdmin.css('color', 'red');
            isValidEditEspecialidadAdmin = false;
        }
    });

    //PARA MÉDICO
    var isValidAddPosicion;
    var dato = $("#agregar-posiciondMedico");

    dato.on('keyup', function (e) {
        var option = $('#listPosiciones option').filter(function () {
            return this.value === $("#agregar-posiciondMedico").val();
        }).val();

        if (option) {
            $('#errorAgregarPosicion').hide();
            dato.css('border', '');
            dato.css('color', '');
            isValidAddPosicion = true;
        } else if (dato.val() == '') {
            $('#errorAgregarPosicion').hide();
            dato.css('border', '');
            dato.css('color', '');
            isValidAddPosicion = false;
        } else {
            $('#errorAgregarPosicion').show();
            dato.css('border', '1px solid red');
            dato.css('color', 'red');
            isValidAddPosicion = false;
        }
    });

    //PARA ADMINISTRADOR
    var isValidAddPosicionAdmin;
    var datoAdminPosicion = $("#agregar-posiciondAdministrador");

    datoAdminPosicion.on('keyup', function (e) {
        var option = $('#listPosiciones option').filter(function () {
            return this.value === $("#agregar-posiciondAdministrador").val();
        }).val();

        if (option) {
            $('#errorAgregarPosicionAdministrador').hide();
            datoAdminPosicion.css('border', '');
            datoAdminPosicion.css('color', '');
            isValidAddPosicionAdmin = true;
        } else if (datoAdminPosicion.val() == '') {
            $('#errorAgregarPosicionAdministrador').hide();
            datoAdminPosicion.css('border', '');
            datoAdminPosicion.css('color', '');
            isValidAddPosicionAdmin = false;
        } else {
            $('#errorAgregarPosicionAdministrador').show();
            datoAdminPosicion.css('border', '1px solid red');
            datoAdminPosicion.css('color', 'red');
            isValidAddPosicionAdmin = false;
        }
    });

    //PARA MÉDICO
    var isValidEditPosicion = true;
    var dato2EditPosicion = $("#editar-posicionMedico");

    dato2EditPosicion.on('keyup', function (e) {
        var option = $('#listPosiciones option').filter(function () {
            return this.value === $("#editar-posicionMedico").val();
        }).val();
        if (option) {
            $('#errorEditarPosicion').hide();
            dato2EditPosicion.css('border', '');
            dato2EditPosicion.css('color', '');
            isValidEditPosicion = true;
        } else if (dato2EditPosicion.val() == '') {
            $('#errorAgregarPosicion').hide();
            dato2EditPosicion.css('border', '');
            dato2EditPosicion.css('color', '');
            isValidEditPosicion = false;
        } else {
            $('#errorEditarPosicion').show();
            dato2EditPosicion.css('border', '1px solid red');
            dato2EditPosicion.css('color', 'red');
            isValidEditPosicion = false;
        }
    });

    //PARA ADMINISTRADOR
    var isValidEditPosicionAdmin = true;
    var dato2EditPosicionAdmin = $("#editar-posicionAdministrador");

    dato2EditPosicionAdmin.on('keyup', function (e) {
        var option = $('#listPosiciones option').filter(function () {
            return this.value === $("#editar-posicionAdministrador").val();
        }).val();
        if (option) {
            $('#errorEditarPosicionAdministrador').hide();
            dato2EditPosicionAdmin.css('border', '');
            dato2EditPosicionAdmin.css('color', '');
            isValidEditPosicionAdmin = true;
        } else if (dato2EditPosicionAdmin.val() == '') {
            $('#errorEditarPosicionAdministrador').hide();
            dato2EditPosicionAdmin.css('border', '');
            dato2EditPosicionAdmin.css('color', '');
            isValidEditPosicionAdmin = false;
        } else {
            $('#errorEditarPosicionAdministrador').show();
            dato2EditPosicionAdmin.css('border', '1px solid red');
            dato2EditPosicionAdmin.css('color', 'red');
            isValidEditPosicionAdmin = false;
        }
    });

    //NOMBRE EN AGREGAR MÉDICO
    $('#agregar-nombreMedico').on('change', function () {

        if (isValidName($(this))) {
            $('#errorNombreMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorNombreMedico').hide();
        } else {
            $('#errorNombreMedico').show();
        }
    });

    //PRIMER APELLIDO EN AGREGAR MÉDICO
    $('#agregar-primerApellidoMedico').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoPaternoMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoPaternoMedico').hide();
        } else {
            $('#errorApellidoPaternoMedico').show();
        }

    });

    //SEGUNDO APELLIDO EN AGREGAR MÉDICO
    $('#agregar-segundoApellidoMedico').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoMaternoMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoMaternoMedico').hide();
        } else {
            $('#errorApellidoMaternoMedico').show();
        }

    });

    //CONTRASEÑA EN AGREGAR MÉDICO
    $('#agregar-passwordMedico').on('change', function () {

        if (isValidPassword($(this))) {
            $('#errorPass1Medico').hide();
        } else if ($(this).val() == '') {
            $('#errorPass1Medico').hide();
        } else {
            $('#errorPass1Medico').show();
        }

    });


    //CONTRASEÑAS IGUALES EN AGREGAR MÉDICO
    $('#agregar-password2Medico').on('change', function () {

        var pass1 = $('#agregar-passwordMedico');
        var pass2 = $('#agregar-password2Medico');

        areEqualPasswords(pass1, pass2);

    });

    $('#agregar-correoMedico').on('change', function () {
        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteCorreo",
                correo: $('#agregar-correoMedico').val()


            },
            success: function (response) {
                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#agregar-correoMedico').css('color', 'orange');
                    $('#errorCorreoRepetido').show();
                    repiteCorreo = true;
                } else {
                    $('#errorCorreoRepetido').hide();
                    repiteCorreo = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#errorCorreoMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorCorreoMedico').hide();
        } else {
            $('#errorCorreoMedico').show();
        }

    });


    //GESTION PACIENTES
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
    $('#errorPass1Paciente').hide();
    $('#errorPass2Paciente').hide();
    $('#error-CPexistePaciente').hide();
    $('#errorCodigoPostalPaciente').hide();
    $('#noEqualPasswordsErrorPaciente').hide();
    $('#error-terminos').hide();

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


    //////////////////////////////////////////////////////
    ///////////////// VALIDACIONES AGREGAR PACIENTE //////
    //////////////////////////////////////////////////////
    //NOMBRE EN AGREGAR PACIENTE
    $('#nombrePaciente').on('change', function () {

        if (isValidName($(this))) {
            $('#errorNombrePaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorNombrePaciente').hide();
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
        } else {
            $('#errorApellidoPaternoPaciente').show();
        }

    });

    //SEGUNDO APELLIDO EN AGREGAR PACIENTE
    $('#segundo-apellidoPaciente').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoMaternoPaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoMaternoPaciente').hide();
        } else {
            $('#errorApellidoMaternoPaciente').show();
        }

    });

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
                }

            }

        });

        if (isValidUserName($(this))) {
            $('#errorNombreUsuarioPaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorNombreUsuarioPaciente').hide();
        } else {
            $('#errorNombreUsuarioPaciente').show();
        }

    });


    //CORREO EN AGREGAR PACIENTE
    $('#correoPaciente').on('change', function () {

        if (isValidEmail($(this))) {
            $('#errorCorreoPaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorCorreoPaciente').hide();
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
        } else {
            $('#noEqualPasswordsErrorPaciente').show();
        }

    });

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
                } else {
                    $('#errorCurpRepetidoPaciente').hide();
                }
            }
        });

        if (isValidCURP($(this))) {
            $('#errorCurpPaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorCurpPaciente').hide();
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
    $('#colPaciente').on('change', function () {

        if (isValidColonia($(this))) {
            $('#errorColoniaPaciente').hide();
        } else {
            $('#errorColoniaPaciente').show();
        }

    });

    //CALLE EN AGREGAR PACIENTE
    $('#callePaciente').on('change', function () {

        if (isValidStreet($(this))) {
            $('#errorCallePaciente').hide();
        } else {
            $('#errorCallePaciente').show();
        }

    });

    //NUMERO EXTERIOR EN AGREGAR PACIENTE
    $('#numExtPaciente').on('change', function () {

        if (isValidExtNumber($(this))) {
            $('#errorNoExteriorPaciente').hide();
        } else {
            $('#errorNoExteriorPaciente').show();
        }

    });

    //NUMERO INTERIOR EN AGREGAR PACIENTE
    $('#numIntPaciente').on('change', function () {

        if (isValidIntNumber($(this))) {
            $('#errorNoInteriorPaciente').hide();
        } else {
            $('#errorNoInteriorPaciente').show();
        }


    });

    //NOMBRE AL EDITAR
    $('#editarNombreAdministradorAPaciente').on('change', function () {

        if (isValidName($(this))) {
            $('#error-editar-NombrePaciente').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-NombrePaciente').hide();
        } else {
            $('#error-editar-NombrePaciente').show();
        }

    });

    //PRIMER APELLIDO AL EDITAR PACIENTE
    $('#editarPrimer-apellidoAdministradorAPaciente').on('change', function () {

        if (isValidLastName($(this))) {
            $('#error-editar-ApellidoPaternoPaciente').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-ApellidoPaternoPaciente').hide();
        } else {
            $('#error-editar-ApellidoPaternoPaciente').show();
        }

    });

    //SEGUNDO APELLIDO AL EDITAR PACIENTE
    $('#editarSegundo-apellidoAdministradorAPaciente').on('change', function () {

        if (isValidLastName($(this))) {
            $('#error-editar-ApellidoMaternoPaciente').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-ApellidoMaternoPaciente').hide();
        } else {
            $('#error-editar-ApellidoMaternoPaciente').show();
        }

    });

    //NOMBRE DE USUARIO AL EDITAR PACIENTE
    $('#editarUsuarioAdministradorAPaciente').on('change', function () {

        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteUsuario",
                usuario: $('#editarUsuarioAdministradorAPaciente').val()


            },
            success: function (response) {

                if (response === 'UsuarioAlreadyExists') {
                    $('#editarUsuarioAdministradorAPaciente').css('color', 'orange');
                    $('#error-editar-UsuarioRepetidoPaciente').show();
                } else {
                    $('#error-editar-UsuarioRepetidoPaciente').hide();
                }

            }

        });

        if (isValidUserName($(this))) {
            $('#error-editar-NombreUsuarioPaciente').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-NombreUsuarioPaciente').hide();
        } else {
            $('#error-editar-NombreUsuarioPaciente').show();
        }

    });

    //CORREO AL EDITAR PACIENTE
    $('#editarCorreoAdministradorAPaciente').on('change', function () {

        var idPaciente = $('#idPacienteAEditar').val();

        $.ajax({
            url: 'AdministradorController',
            cache: false,
            method: 'POST',
            data: {
                key: "repiteCorreoEditPaciente",
                correo: $('#editarCorreoAdministradorAPaciente').val(),
                idPaciente: idPaciente
            },
            success: function (response) {
                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#editarCorreoAdministradorAPaciente').css('color', 'orange');
                    $('#errorEditarPacienteCorreoRepetido').show();
                    repiteCorreo = true;
                } else {
                    $('#errorEditarPacienteCorreoRepetido').hide();
                    repiteCorreo = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#error-editar-CorreoPaciente').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-CorreoPaciente').hide();
        } else {
            $('#error-editar-CorreoPaciente').show();
        }

    });



    //CURP AL EDITAR PACIENTE
    $('#editarCurpAdministradorAPaciente').on('change', function () {

        $.ajax({
            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {
                key: "repiteCurp",
                curp: $('#editarCurpAdministradorAPaciente').val()
            },
            success: function (response) {

                if (response === 'CurpAlreadyExists') {
                    $('#editarCurpAdministradorAPaciente').css('color', 'orange');
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
        } else {
            $('#error-editar-CurpPaciente').show();
        }

    });

    //TELEFONO AL EDITAR PACIENTE
    $('#editarTelAdministradorAPaciente').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#error-editar-TelefonoPaciente').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-TelefonoPaciente').hide();
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
    $('#editarCumpleAdministradorAPaciente').on('change', function () {

        if (isValidDate($(this))) {
            $('#error-editar-FechaPaciente').hide();
        } else {
            $('#error-editar-FechaPaciente').show();
        }

    });

    //ESTADO AL EDITAR PACIENTE
    $('#editarEstadoAdministradorAPaciente').on('change', function () {

        if (isValidSelect($(this))) {
            $('#error-editar-EstadoPaciente').hide();
        } else {
            $('#error-editar-EstadoPaciente').show();
        }

    });

    //MUNICIPIO AL EDITAR PACIENTE
    $('#editarMunicipioAdministradorAPaciente').on('change', function () {

        if (isValidSelect($(this))) {
            $('#error-editar-MunicipioPaciente').hide();
        } else {
            $('#error-editar-MunicipioPaciente').show();
        }

    });

    //COLONIA AL EDITAR PACIENTE
    $('#editarColAdministradorAPaciente').on('change', function () {

        if (isValidColonia($(this))) {
            $('#error-editar-ColoniaPaciente').hide();
        } else {
            $('#error-editar-ColoniaPaciente').show();
        }

    });

    //CALLE AL EDITAR PACIENTE
    $('#editarCalleAdministradorAPaciente').on('change', function () {

        if (isValidStreet($(this))) {
            $('#error-editar-CallePaciente').hide();
        } else {
            $('#error-editar-CallePaciente').show();
        }

    });

    //NUMERO EXTERIOR AL EDITAR PACIENTE
    $('#editarNumExtAdministradorAPaciente').on('change', function () {

        if (isValidExtNumber($(this))) {
            $('#error-editar-NoExteriorPaciente').hide();
        } else {
            $('#error-editar-NoExteriorPaciente').show();
        }

    });

    //NUMERO INTERIOR AL EDITAR PACIENTE
    $('#editarNumIntAdministradorAPaciente').on('change', function () {

        if (isValidIntNumber($(this))) {
            $('#error-editar-NoInteriorPaciente').hide();
        } else {
            $('#error-editar-NoInteriorPaciente').show();
        }

    });

    //////////////////////////////////////////////////////
    /////////////////////////////// GESTION MEDICOS ////// 
    //////////////////////////////////////////////////////
    /**AGREGAR MEDICO */
    $('#btn-agregarMedico').on('click', function () {
        if (!repiteCorreo) {

            $("#error-datosRepetidos").hide();

            if (isValidName($('#agregar-nombreMedico')) && isValidLastName($('#agregar-primerApellidoMedico')) && $('#errorApellidoMaternoMedico').hide() && $('#errorCedulaMedicos').hide()
                    && isValidNumEmpleado($('#agregar-noEmpleadoMedico')) && isValidEmail($('#agregar-correoMedico')) && isValidPassword($('#agregar-passwordMedico')) &&
                    isValidPassword($('#agregar-password2Medico'))
                    && isValidPhoneNumber($('#agregar-telefonoMedico')) && isValidCheckbox($('#terminosMedico')) && isValidAddEspecialidad && isValidAddPosicion
                    && areEqualPasswords($('#agregar-passwordMedico'), $('#agregar-password2Medico'))
                    && $('#errorCorreoRepetido').hide()) {

                $("#error-campos").hide();

                var nombre = $('#agregar-nombreMedico');
                var telefono = $('#agregar-telefonoMedico');
                var primerApellido = $('#agregar-primerApellidoMedico');
                var segundoApellido = $('#agregar-segundoApellidoMedico');
                var correo = $('#agregar-correoMedico');
                var noEmpleado = $('#agregar-noEmpleadoMedico');
                var especialidad = $('#agregar-especialidadMedico');
                var posicion = $('#agregar-posiciondMedico');
                var cedula = $('#agregar-cedulaMedico');
                var password = $('#agregar-passwordMedico');

                $.ajax({

                    url: 'RegistraUsuarioController',
                    cache: false,
                    beforeSend: function () {
                        $('.cargandoAgregarMedico').fadeIn();
                    },
                    method: 'POST',
                    data: {
                        key: 'agregarMedico',
                        nombre: nombre.val(),
                        primerApellido: primerApellido.val(),
                        segundoApellido: segundoApellido.val(),
                        telefono: telefono.val(),
                        correo: correo.val(),
                        noEmpleado: noEmpleado.val(),
                        especialidad: especialidad.val(),
                        posicion: posicion.val(),
                        cedula: cedula.val(),
                        password: password.val()
                    },
                    complete: function () {
                        $('.cargandoAgregarMedico').fadeOut();
                    },
                    success: function (response) {

                        var t = $('#tablaMedicos').DataTable();

                        t.row.add([
                            $("#agregar-nombreMedico").val() + " " + $("#agregar-primerApellidoMedico").val() + " " + $("#agregar-segundoApellidoMedico").val(),
                            $("#agregar-correoMedico").val(),
                            $("#agregar-telefonoMedico").val(),
                            $("#agregar-noEmpleadoMedico").val(),
                            $("#agregar-especialidadMedico").val(),
                            $("#agregar-cedulaMedico").val(),
                            "<button class='btn btn-primary btn-editarMedico m-1' data-toggle='modal' data-id='" + response + "' data-target='#modalEditarMedico'><i class='fas fa-edit'></i></button>" +
                                    "<button class='btn btn-danger m-1 btn-eliminarMedico' data-id='" + response + "'><i class='fas fa-trash-alt'></i></button>"
                        ]).draw(false);

                        console.log(response);
                        swal({
                            title: "¡Buen trabajo!",
                            text: "Se ha agregado correctamente al médico.",
                            icon: "success",
                            buttons: [, 'Aceptar'],
                        });

                        //Limpiar los campos después de registrarse 

                        $("#agregar-nombreMedico").val("");
                        $("#agregar-telefonoMedico").val("");
                        $("#agregar-primerApellidoMedico").val("");
                        $("#agregar-segundoApellidoMedico").val("");
                        $("#agregar-correoMedico").val("");
                        $("#agregar-noEmpleadoMedico").val("");
                        $("#agregar-especialidadMedico").val("");
                        $("#agregar-posiciondMedico").val("");
                        $("#agregar-cedulaMedico").val("");
                        $("#agregar-passwordMedico").val("");
                        $("#agregar-password2Medico").val("");
                        $("#terminosMedico").prop("checked", false);

                        //Cerrar el modal
                        $('#modalAgregarMedico').modal('toggle');


                    },
                    error: function (xhr) {
                        //alert(xhr.statusText);
                    }
                })
                        .done(function (response) {


                        });
            } else {
                console.log("Entro al segundo else");
                $("#error-campos").show(); //No se llenaron los campos obligatorios
            }
        } else {
            console.log("Entro al segundo else");
            $("#error-datosRepetidos").show(); //ya existe un campo
            $("#error-campos").hide();
        }
    });


    ////////////////////////////////////////////////////////////// VALIDACIONES EDITAR UN MÉDICO

    //TELEFONO EN EDITAR MÉDICO
    $('#editar-telefonoMedico').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#errorEditarTelefonoMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarTelefonoMedico').hide();
        } else {
            $('#errorEditarTelefonoMedico').show();
        }

    });

    //CÉDULA PROFESIONAL EN EDITAR MÉDICO
    $('#editar-cedulaProfesionalMedico').on('change', function () {

        if (isValidCedula($(this))) {
            $('#errorEditarCedulaMedicos').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarCedulaMedicos').hide();
        } else {
            $('#errorEditarCedulaMedicos').show();
        }

    });

    //NÚMERO DE EMPLEADO EN EDITAR MÉDICO
    $('#editar-noEmpleadoMedico').on('change', function () {

        if (isValidNumEmpleado($(this))) {
            $('#errorEditarNumEmpleado').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarNumEmpleado').hide();
        } else {
            $('#errorEditarNumEmpleado').show();
        }

    });

    //NOMBRE EN EDITAR MÉDICO
    $('#editar-nombreMedico').on('change', function () {

        if (isValidName($(this))) {
            $('#errorEditarNombreMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarNombreMedico').hide();
        } else {
            $('#errorEditarNombreMedico').show();
        }
    });

    //PRIMER APELLIDO EN EDITAR MÉDICO
    $('#editar-primerApellidoMedico').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorEditarApellidoPaternoMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarApellidoPaternoMedico').hide();
        } else {
            $('#errorEditarApellidoPaternoMedico').show();
        }

    });

    //SEGUNDO APELLIDO EN EDITAR MÉDICO
    $('#editar-segundoApellidoMedico').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorEditarApellidoMaternoMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarApellidoMaternoMedico').hide();
        } else {
            $('#errorEditarApellidoMaternoMedico').show();
        }

    });

    $('#editar-correoMedico').on('change', function () {
        var idMedico = $('#idMedico').val();

        $.ajax({
            url: 'AdministradorController',
            cache: false,
            method: 'POST',
            data: {
                key: "repiteCorreoEditEmpleado",
                correo: $('#editar-correoMedico').val(),
                idEmpleado: idMedico
            },
            success: function (response) {
                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#editar-correoMedico').css('color', 'orange');
                    $('#errorEditarCorreoRepetido').show();
                    repiteCorreo = true;
                } else {
                    $('#errorEditarCorreoRepetido').hide();
                    repiteCorreo = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#errorEditarCorreoMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarCorreoMedico').hide();
        } else {
            $('#errorEditarCorreoMedico').show();
        }

    });

    /**EDITAR MEDICO */
    //RECUPERA EL MEDICO PARA PONERLO EN EL MODAL
    $('body').on('click', '.btn-editarMedico', function () {

        var idMedico = $(this).data('id');
        console.log("idMédico " + idMedico);

        $.ajax({

            url: 'AdministradorController',
            cache: false,
            dataType: 'JSON',
            method: "POST",
            data: {
                key: 'obtener-medico',
                idMedicoAdministrador: idMedico
            },
            success: function (response) {

                //$("#idMedico").val(response.id);
                console.log(response);

                var json = response;
                $('#idMedico').val(json.idEmpleado);
                $('#editar-nombreMedico').val(json.nombre);
                $('#editar-primerApellidoMedico').val(json.primerApellido);
                $('#editar-segundoApellidoMedico').val(json.segundoApellido);
                $('#editar-correoMedico').val(json.correo);
                $('#editar-telefonoMedico').val(json.telefono);
                $('#editar-noEmpleadoMedico').val(json.noEmpleado);
                $('#editar-especialidadMedico').val(json.nombreEspecialidad);
                $('#editar-posicionMedico').val(json.nombrePosicion);
                $('#editar-cedulaProfesionalMedico').val(json.cedulaProfesional);

            }

        });
    });

    //RECUPERA AL ADMIN PARA PONERLO EN EL MODAL 
    $('body').on('click', '.btn-editarAdministrador', function () {

        var idAdmin = $(this).data('id');

        $.ajax({

            url: 'AdministradorController',
            cache: false,
            dataType: 'JSON',
            method: "POST",
            data: {
                key: 'obtener-admin',
                idAdmin: idAdmin
            },
            success: function (response) {

                //$("#idMedico").val(response.id);
                console.log(response);

                var json = response;
                $('#idAdministrador').val(json.idEmpleado);
                $('#editar-nombreAdministrador').val(json.nombre);
                $('#editar-primerApellidoAdministrador').val(json.primerApellido);
                $('#editar-segundoApellidoAdministrador').val(json.segundoApellido);
                $('#editar-correoAdministrador').val(json.correo);
                $('#editar-telefonoAdministrador').val(json.telefono);
                $('#editar-noEmpleadoAdministrador').val(json.noEmpleado);
                $('#editar-especialidadAdministrador').val(json.nombreEspecialidad);
                $('#editar-posicionAdministrador').val(json.nombrePosicion);
                $('#editar-cedulaProfesionalAdministrador').val(json.cedulaProfesional);

            }

        });
    });

    $('#IrAGestionMedicos').on('click', function () {
        $.post("SAPI", {
            file: "administrador/gestionMedicos.jsp"
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

    $('#IrAGestionNavegadora').on('click', function () {
        $.post("SAPI", {
            file: "administrador/gestionNavegadora.jsp"
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
    $('#IrAGestionPaciente').on('click', function () {
        console.log("VE!");
        $.post("SAPI", {
            file: "administrador/gestionPacientes.jsp"
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
    $('#IrAGestionAdministrador').on('click', function () {
        $.post("SAPI", {
            file: "administrador/gestionarAdministradores.jsp"
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
    $('#IrAReasignarMedico').on('click', function () {
        $.post("SAPI", {
            file: "administrador/reAsignarMedico.jsp"
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

    $('#IrAInicio').on('click', function () {
        $.post("SAPI", {
            file: "administrador/gestionMedicos.jsp"
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


    $('body').on('click', '.btn-verNavegadora', function () {

        console.log("VerNavegadora");
        var idNavegadora = $(this).data('id');

        $.post("SAPI", {
            file: "administrador/rendimientoNavegadora.jsp",
            idNavegadora: idNavegadora
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


    $('#IrAMiCuenta').on('click', function () {
        $.post("SAPI", {
            file: "administrador/cuentaAdministrador.jsp"
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

    ////////////////////////////////////////////////////////////////////////////
    //////////////////VALIDACIONES EDITAR UN ADMINISTRADOR//////////////////////
    ////////////////////////////////////////////////////////////////////////////

    //TELEFONO EN EDITAR ADMINISTRADOR
    $('#editar-telefonoAdministrador').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#errorEditarTelefonoAdministrador').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarTelefonoAdministrador').hide();
        } else {
            $('#errorEditarTelefonoAdministrador').show();
        }

    });

    //CÉDULA PROFESIONAL EN EDITAR ADMINISTRADOR
    $('#editar-cedulaProfesionalAdministrador').on('change', function () {

        if (isValidCedula($(this))) {
            $('#errorEditarCedulaAdministrador').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarCedulaAdministrador').hide();
        } else {
            $('#errorEditarCedulaAdministrador').show();
        }

    });

    //NÚMERO DE EMPLEADO EN EDITAR ADMINISTRADOR
    $('#editar-noEmpleadoAdministrador').on('change', function () {

        if (isValidNumEmpleado($(this))) {
            $('#errorEditarNumEmpleadoAdministrador').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarNumEmpleadoAdministrador').hide();
        } else {
            $('#errorEditarNumEmpleadoAdministrador').show();
        }

    });

    //NOMBRE EN EDITAR ADMINISTRADOR
    $('#editar-nombreAdministrador').on('change', function () {

        if (isValidName($(this))) {
            $('#errorEditarNombreAdministrador').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarNombreAdministrador').hide();
        } else {
            $('#errorEditarNombreAdministrador').show();
        }
    });

    //PRIMER APELLIDO EN EDITAR ADMINISTRADOR
    $('#editar-primerApellidoAdministrador').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorEditarApellidoPaternoAdministrador').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarApellidoPaternoAdministrador').hide();
        } else {
            $('#errorEditarApellidoPaternoAdministrador').show();
        }

    });

    //SEGUNDO APELLIDO EN EDITAR ADMINISTRADOR
    $('#editar-segundoApellidoAdministrador').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorEditarApellidoMaternoAdministrador').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarApellidoMaternoAdministrador').hide();
        } else {
            $('#errorEditarApellidoMaternoAdministrador').show();
        }

    });

    $('#editar-correoAdministrador').on('change', function () {
        var idAdmin = $('#idAdministrador').val();

        $.ajax({
            url: 'AdministradorController',
            cache: false,
            method: 'POST',
            data: {
                key: "repiteCorreoEditEmpleado",
                correo: $('#editar-correoAdministrador').val(),
                idEmpleado: idAdmin
            },
            success: function (response) {
                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#editar-correoAdministrador').css('color', 'orange');
                    $('#errorEditarCorreoRepetidoAdministrador').show();
                    repiteCorreo = true;
                } else {
                    $('#errorEditarCorreoRepetidoAdministrador').hide();
                    repiteCorreo = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#errorEditarCorreoAdministrador').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarCorreoAdministrador').hide();
        } else {
            $('#errorEditarCorreoAdministrador').show();
        }

    });

    //GUARDA EL MEDICO DESDE EL MODAL
    $('#btn-guardarMedico').on('click', function () {

        if (!repiteCorreo) {
            $("#error-editarDatosRepetidos").hide();

            if (isValidName($('#editar-nombreMedico')) && isValidLastName($('#editar-primerApellidoMedico')) && $('#errorApellidoMaternoMedico').hide() && $('#errorCedulaMedicos').hide()
                    && isValidNumEmpleado($('#editar-noEmpleadoMedico')) && isValidEmail($('#editar-correoMedico'))
                    && isValidPhoneNumber($('#editar-telefonoMedico')) && isValidEditEspecialidad && isValidEditPosicion
                    && $('#errorCorreoRepetido').hide()) {

                var idMedico = $('#idMedico').val();
                var nombre = $('#editar-nombreMedico').val();
                var telefono = $('#editar-telefonoMedico').val();
                var primerApellido = $('#editar-primerApellidoMedico').val();
                var segundoApellido = $('#editar-segundoApellidoMedico').val();
                var correo = $('#editar-correoMedico').val();
                var noEmpleado = $('#editar-noEmpleadoMedico').val();
                var especialidad = $('#editar-especialidadMedico').val();
                var posicion = $('#editar-posicionMedico').val();
                var cedula = $('#editar-cedulaProfesionalMedico').val();

                console.log("idMédicoooo " + idMedico);
                console.log("nombre " + nombre);
                console.log("phone " + telefono);
                console.log("ape 1 " + primerApellido);
                console.log("ape 2 " + segundoApellido);
                console.log("mail " + correo);
                console.log("empleado no " + noEmpleado);
                console.log("especiliad  " + especialidad);
                console.log("cedula " + cedula);

                console.log("Holi, hará el ajax");
                $.ajax({

                    url: 'AdministradorController',
                    cache: false,
                    beforeSend: function () {
                        $('.cargandoEditarMedico').fadeIn();
                    },
                    method: 'POST',
                    data: {
                        key: 'actualizar-medico',
                        idMedico: idMedico,
                        nombre: nombre,
                        telefono: telefono,
                        primerApellido: primerApellido,
                        segundoApellido: segundoApellido,
                        correo: correo,
                        noEmpleado: noEmpleado,
                        especialidad: especialidad,
                        posicion: posicion,
                        cedula: cedula
                    },
                    complete: function () {
                        $('.cargandoEditarMedico').fadeOut();
                    },
                    success: function (response) {
                        $('#modalEditarMedico').modal('toggle'); //cerrar modal
                        console.log("Cierra el modal");
                        swal({
                            title: "Cambios guardados correctamente",
                            icon: "success",
                            buttons: true,
                            buttons: [, 'Aceptar']
                        });
                        console.log("ESTOY EN EL SUCCESS!! :o");
                        $('#nombre-' + idMedico).html(nombre + " " + primerApellido + " " + segundoApellido);
                        $('#correo-' + idMedico).html(correo);
                        $('#telefono-' + idMedico).html(telefono);
                        $('#noEmpleado-' + idMedico).html(noEmpleado);
                        $('#nombreEspecialidad-' + idMedico).html(especialidad);
                        $('#cedulaProfesional-' + idMedico).html(cedula);
                    },
                    error: function (xhr) {
                        //alert(xhr.statusText);
                    }

                });

            }
        } else {
            console.log("Entro al segundo else");
            $("#error-datosRepetidos").show(); //ya existe un campo
        }

    });




    /** ELIMINAR MEDICO */
    $('body').on('click', '.btn-eliminarMedico', function () {

        var t = $('#tablaMedicos').DataTable();
        var fila = $(this).parents('tr');

        var idMedico = $(this).data('id');


        swal({
            title: "¿Estás seguro?",
            text: "Los datos se eliminarán y no podrás recuperarlos.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
                .then((eliminar) => {
                    if (eliminar) {

                        $.ajax({

                            url: 'AdministradorController',
                            cache: false,
                            method: 'POST',
                            data: {
                                key: 'eliminarEmpleado',
                                idEmpleado: idMedico
                            },
                            success: function (response) {
                                if (response == "error") {
                                    alert("Error al cargar");
                                } else {
                                    t.row(fila).remove().draw();
                                }
                            },
                            error: function (xhr) {

                            }
                        });
                    }
                });

    });

    ///////////////////////////////GESTIÓN NAVEGADORAS 

    //Errores al agregar a una navegadora
    $('#errorNombreNavegadora').hide();
    $('#errorTelefonoNavegadora').hide();
    $('#errorApellidoPaternoNavegadora').hide();
    $('#errorApellidoMaternoNavegadora').hide();
    $('#errorCorreoNavegadora').hide();
    $('#errorCorreoRepetidoNavegadora').hide();
    $('#errorNumEmpleadoNavegadora').hide();
    $('#errorAgregarEspecialidadNavegadora').hide();
    $('#errorCedulaNavegadora').hide();
    $('#errorPass1Navegadora').hide();
    $('#noEqualPasswordsError').hide();
    $('#error-camposNavegadora').hide();
    $('#error-datosRepetidosNavegadora').hide();


    //Errores al editar a una navegadora 
    $('#errorEditarNombreNavegadora').hide();
    $('#errorEditarTelefonoNavegadora').hide();
    $('#errorEditarApellidoPaternoNavegadora').hide();
    $('#errorEditarApellidoMaternoNavegadora').hide();
    $('#errorEditarCorreoNavegadora').hide();
    $('#errorEditarCorreoRepetidoNavegadora').hide();
    $('#errorEditarNumNavegadora').hide();
    $('#errorEditarCedulaNavegadora').hide();
    $('#errorEditarEspecialidadNavegadora').hide();
    $('#error-editarDatosRepetidosNavegadora').hide();

    //////////////////////////////////////////////////////
    /////////////////// VALIDACIONES EDITAR NAVEGADORA ///
    //////////////////////////////////////////////////////

    //TELEFONO EN EDITAR NAVEGADORA
    $('#editar-telefonoNavegadora').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#errorEditarTelefonoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarTelefonoNavegadora').hide();
        } else {
            $('#errorEditarTelefonoNavegadora').show();
        }

    });

    //CÉDULA PROFESIONAL EN EDITAR MÉDICO
    $('#editar-cedulaProfesionalNavegadora').on('change', function () {

        if (isValidCedula($(this))) {
            $('#errorEditarCedulaNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarCedulaNavegadora').hide();
        } else {
            $('#errorEditarCedulaNavegadora').show();
        }

    });

    //NÚMERO DE EMPLEADO EN EDITAR NAVEGADORA
    $('#editar-noEmpleadoNavegadora').on('change', function () {

        if (isValidNumEmpleado($(this))) {
            $('#errorEditarNumNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarNumNavegadora').hide();
        } else {
            $('#errorEditarNumNavegadora').show();
        }

    });

    //NOMBRE EN EDITAR NAVEGADORA
    $('#editar-nombreNavegadora').on('change', function () {

        if (isValidName($(this))) {
            $('#errorEditarNombreNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarNombreNavegadora').hide();
        } else {
            $('#errorEditarNombreNavegadora').show();
        }
    });

    //PRIMER APELLIDO EN EDITAR NAVEGADORA
    $('#editar-primerApellidoNavegadora').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorEditarApellidoPaternoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarApellidoPaternoNavegadora').hide();
        } else {
            $('#errorEditarApellidoPaternoNavegadora').show();
        }

    });

    //SEGUNDO APELLIDO EN EDITAR NAVEGADORA
    $('#editar-segundoApellidoNavegadora').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorEditarApellidoMaternoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarApellidoMaternoNavegadora').hide();
        } else {
            $('#errorEditarApellidoMaternoNavegadora').show();
        }

    });

    $('#editar-correoNavegadora').on('change', function () {
        var idNavegadora = $('#idNavegadora').val();

        $.ajax({
            url: 'AdministradorController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteCorreoEditEmpleado",
                correo: $('#editar-correoNavegadora').val(),
                idEmpleado: idNavegadora
            },
            success: function (response) {

                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#editar-correoNavegadora').css('color', 'orange');
                    $('#errorEditarCorreoRepetidoNavegadora').show();
                    repiteCorreoNavegadora = true;
                } else {
                    $('#errorEditarCorreoRepetidoNavegadora').hide();
                    repiteCorreoNavegadora = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#errorEditarCorreoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarCorreoNavegadora').hide();
        } else {
            $('#errorEditarCorreoNavegadora').show();
        }

    });


    //////////////////////////////////////////////////////
    /////////////////// VALIDACIONES AGREGAR NAVEGADORA //
    //////////////////////////////////////////////////////

    //TELEFONO EN AGREGAR NAVEGADORA
    $('#agregar-telefonoNavegadora').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#errorTelefonoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorTelefonoNavegadora').hide();
        } else {
            $('#errorTelefonoNavegadora').show();
        }

    });

    //CÉDULA PROFESIONAL EN AGREGAR NAVEGADORA
    $('#agregar-cedulaNavegadora').on('change', function () {

        if (isValidCedula($(this))) {
            $('#errorCedulaNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorCedulaNavegadora').hide();
        } else {
            $('#errorCedulaNavegadora').show();
        }

    });

    //NÚMERO DE EMPLEADO EN AGREGAR NAVEGADORA
    $('#agregar-noEmpleadoNavegadora').on('change', function () {

        if (isValidNumEmpleado($(this))) {
            $('#errorNumEmpleadoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorNumEmpleadoNavegadora').hide();
        } else {
            $('#errorNumEmpleadoNavegadora').show();
        }

    });

    //ESPECIALIDAD EN AGREGAR NAVEGADORA
    $('#agregar-especialidadNavegadora').on('change', function () {

        if (isValidEspecialidad($(this))) {
            $('#errorAgregarEspecialidadNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorAgregarEspecialidadNavegadora').hide();
        } else {
            $('#errorAgregarEspecialidadNavegadora').show();
        }

    });

    //NOMBRE EN AGREGAR NAVEGADORA
    $('#agregar-nombreNavegadora').on('change', function () {

        if (isValidName($(this))) {
            $('#errorNombreNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorNombreNavegadora').hide();
        } else {
            $('#errorNombreNavegadora').show();
        }
    });

    //PRIMER APELLIDO EN AGREGAR NAVEGADORA
    $('#agregar-primerApellidoNavegadora').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoPaternoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoPaternoNavegadora').hide();
        } else {
            $('#errorApellidoPaternoNavegadora').show();
        }

    });

    //SEGUNDO APELLIDO EN AGREGAR NAVEGADORA
    $('#agregar-segundoApellidoNavegadora').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoMaternoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoMaternoNavegadora').hide();
        } else {
            $('#errorApellidoMaternoNavegadora').show();
        }

    });

    //CONTRASEÑA EN AGREGAR NAVEGADORA
    $('#agregar-passwordNavegadora').on('change', function () {

        if (isValidPassword($(this))) {
            $('#errorPass1Navegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorPass1Navegadora').hide();
        } else {
            $('#errorPass1Navegadora').show();
        }

    });


    //CONTRASEÑAS IGUALES EN AGREGAR NAVEGADORA
    $('#agregar-password2Navegadora').on('change', function () {

        var pass1 = $('#agregar-passwordNavegadora');
        var pass2 = $('#agregar-password2Navegadora');

        areEqualPasswords(pass1, pass2);

    });

    var repiteCorreoNavegadora;

    $('#agregar-correoNavegadora').on('change', function () {
        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteCorreo",
                correo: $('#agregar-correoNavegadora').val()


            },
            success: function (response) {

                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#agregar-correoNavegadora').css('color', 'orange');
                    $('#errorCorreoRepetidoNavegadora').show();
                    repiteCorreoNavegadora = true;
                } else {
                    $('#errorCorreoRepetidoNavegadora').hide();
                    repiteCorreoNavegadora = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#errorCorreoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorCorreoNavegadora').hide();
        } else {
            $('#errorCorreoNavegadora').show();
        }

    });

    /**AGREGAR NAVEGADORA*/
    $('#btn-agregarNavegadora').on('click', function () {
        if (!repiteCorreoNavegadora) {

            $("#error-datosRepetidosNavegadora").hide();

            if (isValidName($('#agregar-nombreNavegadora')) && isValidLastName($('#agregar-primerApellidoNavegadora')) && $('#errorApellidoMaternoNavegadora').hide() && $('#errorCedulaNavegadora').hide()
                    && isValidNumEmpleado($('#agregar-noEmpleadoNavegadora')) && isValidEmail($('#agregar-correoNavegadora')) && isValidPassword($('#agregar-passwordNavegadora')) &&
                    isValidPassword($('#agregar-password2Navegadora'))
                    && isValidPhoneNumber($('#agregar-telefonoNavegadora')) && isValidCheckbox($('#terminosNavegadora')) && isValidEspecialidad($('#agregar-especialidadNavegadora'))
                    && areEqualPasswords($('#agregar-passwordNavegadora'), $('#agregar-password2Navegadora')) && $('#errorCorreoRepetidoNavegadora').hide()) {

                $("#error-camposNavegadora").hide();

                var nombre = $('#agregar-nombreNavegadora');
                var telefono = $('#agregar-telefonoNavegadora');
                var primerApellido = $('#agregar-primerApellidoNavegadora');
                var segundoApellido = $('#agregar-segundoApellidoNavegadora');
                var correo = $('#agregar-correoNavegadora');
                var noEmpleado = $('#agregar-noEmpleadoNavegadora');
                var especialidad = $('#agregar-especialidadNavegadora');
                var cedula = $('#agregar-cedulaNavegadora');
                var password = $('#agregar-passwordNavegadora');

                console.log(nombre);
                console.log(telefono);
                console.log(primerApellido);
                console.log(segundoApellido);
                console.log(correo);
                console.log(noEmpleado);
                console.log(especialidad);
                console.log(cedula);
                console.log(password);

                $.ajax({

                    url: 'RegistraUsuarioController',
                    cache: false,
                    method: 'POST',
                    beforeSend: function () {
                        $('.cargandoAgregarNavegadora').fadeIn();
                    },
                    data: {
                        key: 'agregarNavegadora',
                        nombre: nombre.val(),
                        telefono: telefono.val(),
                        primerApellido: primerApellido.val(),
                        segundoApellido: segundoApellido.val(),
                        correo: correo.val(),
                        noEmpleado: noEmpleado.val(),
                        especialidad: especialidad.val(),
                        cedula: cedula.val(),
                        password: password.val()
                    },
                    complete: function () {
                        $('.cargandoAgregarNavegadora').fadeOut();
                    },
                    success: function (response) {

                        var t = $('#tablaNavegadoras').DataTable();

                        t.row.add([
                            $("#agregar-nombreNavegadora").val() + " " + $("#agregar-primerApellidoNavegadora").val() + " " + $("#agregar-segundoApellidoNavegadora").val(),
                            $("#agregar-correoNavegadora").val(),
                            $("#agregar-telefonoNavegadora").val(),
                            $("#agregar-noEmpleadoNavegadora").val(),
                            $("#agregar-especialidadNavegadora").val(),
                            $("#agregar-cedulaNavegadora").val(),
                            "<button class='btn btn-success m-1 btn-verNavegadora' data-id='" + response + "'><i class='fas fa-chart-line'></i></button>" +
                                    "<button class='btn btn-primary btn-editarNavegadora m-1' data-toggle='modal' data-target='#modalEditarNavegadora' data-id='" + response + "'><i class='fas fa-edit'></i></button>" +
                                    "<button class='btn btn-danger m-1 btn-eliminarNavegadora' data-id='" + response + "'><i class='fas fa-trash-alt'></i></button>"
                        ]).draw(false);


                        swal({
                            title: "¡Buen trabajo!",
                            text: "Se ha agregado correctamente a la navegadora.",
                            icon: "success",
                            buttons: [, 'Aceptar'],
                        });

                        //Limpiar los campos después de registrarse 

                        $("#agregar-nombreNavegadora").val("");
                        $("#agregar-telefonoNavegadora").val("");
                        $("#agregar-primerApellidoNavegadora").val("");
                        $("#agregar-segundoApellidoNavegadora").val("");
                        $("#agregar-correoNavegadora").val("");
                        $("#agregar-noEmpleadoNavegadora").val("");
                        $("#agregar-especialidadNavegadora").val("");
                        $("#agregar-cedulaNavegadora").val("");
                        $("#agregar-passwordNavegadora").val("");
                        $("#agregar-password2Navegadora").val("");
                        $("#terminosNavegadora").prop("checked", false);

                        //Cerrar el modal
                        $('#modalAgregarNavegadora').modal('toggle');
                    }
                });
            } else {
                console.log("Entro al segundo else");
                $("#error-camposNavegadora").show(); //No se llenaron los campos obligatorios
            }
        } else {
            console.log("Entro al segundo else");
            $("#error-datosRepetidosNavegadora").show(); //ya existe un campo
            $("#error-camposNavegadora").hide();
        }
    });

    /**EDITAR NAVEGADORA */
    //RECUPERA LA NAVEGADORA PARA PONERLO EN EL MODAL
    $('body').on('click', '.btn-editarNavegadora', function () {

        var idNavegadora = $(this).data('id');
        console.log(idNavegadora);

        $.ajax({

            url: 'AdministradorController',
            cache: false,
            dataType: 'JSON',
            method: "POST",
            data: {
                key: 'obtener-navegadora',
                idNavegadora: idNavegadora,
            },
            success: function (response) {

                console.log(response);
                $('#idNavegadora').val(response.idEmpleado);
                $('#editar-nombreNavegadora').val(response.nombre);
                $('#editar-telefonoNavegadora').val(response.telefono);
                $('#editar-primerApellidoNavegadora').val(response.primerApellido);
                $('#editar-segundoApellidoNavegadora').val(response.segundoApellido);
                $('#editar-correoNavegadora').val(response.correo);
                $('#editar-no-empleadoNavegadora').val(response.noEmpleado);
                $('#editar-especialidad').val(response.nombreEspecialidad);
                $('#editar-cedulaNavegadora').val(response.cedulaProfesional);
            }

        });

    });

    //GUARDA LA NAVEGADORA DESDE EL MODAL 
    $('#btn-guardarNavegadora').on('click', function () {

        if (!repiteCorreoNavegadora) {
            $("#error-editarDatosRepetidosNavegadora").hide();

            if (isValidName($('#editar-nombreNavegadora')) && isValidLastName($('#editar-primerApellidoNavegadora')) && $('#errorApellidoMaternoNavegadora').hide() && $('#errorCedulaNavegadora').hide()
                    && isValidNumEmpleado($('#editar-no-empleadoNavegadora')) && isValidEmail($('#editar-correoNavegadora'))
                    && isValidPhoneNumber($('#editar-telefonoNavegadora')) && isValidEspecialidad($('#editar-especialidad'))
                    && $('#errorCorreoRepetidoNavegadora').hide()) {

                var idNavegadora = $('#idNavegadora').val();

                var nombre = $('#editar-nombreNavegadora').val();
                var telefono = $('#editar-telefonoNavegadora').val();
                var primerApellido = $('#editar-primerApellidoNavegadora').val();
                var segundoApellido = $('#editar-segundoApellidoNavegadora').val();
                var correo = $('#editar-correoNavegadora').val();
                var noEmpleado = $('#editar-no-empleadoNavegadora').val();
                var especialidad = $('#editar-especialidad').val();
                var cedula = $('#editar-cedulaNavegadora').val();

                console.log("idNavegadoraaaaa " + idNavegadora);
                console.log("nombre " + nombre);
                console.log("phone " + telefono);
                console.log("ape 1 " + primerApellido);
                console.log("ape 2 " + segundoApellido);
                console.log("mail " + correo);
                console.log("empleado no " + noEmpleado);
                console.log("especiliad  " + especialidad);
                console.log("cedula " + cedula);

                console.log("Holi, hará el ajax");

                $.ajax({

                    url: 'AdministradorController',
                    cache: false,
                    method: 'POST',
                    beforeSend: function () {
                        $('.cargandoEditarNavegadora').fadeIn();
                    },
                    data: {
                        key: 'actualiza-navegadora',
                        idNavegadora: idNavegadora,
                        nombre: nombre,
                        telefono: telefono,
                        primerApellido: primerApellido,
                        segundoApellido: segundoApellido,
                        correo: correo,
                        noEmpleado: noEmpleado,
                        especialidad: especialidad,
                        cedula: cedula,
                    },
                    complete: function () {
                        $('.cargandoEditarNavegadora').fadeOut();
                    },
                    success: function (response) {
                        $('#modalEditarNavegadora').modal('toggle'); //cerrar modal
                        console.log("Cierra el modal");
                        swal({
                            title: "Cambios guardados correctamente",
                            icon: "success",
                            buttons: true,
                            buttons: [, 'Aceptar']
                        });
                        console.log("ESTOY EN EL SUCCESS!! :o");
                        $('#nombre-' + idNavegadora).html(nombre + " " + primerApellido + " " + segundoApellido);
                        $('#correo-' + idNavegadora).html(correo);
                        $('#telefono-' + idNavegadora).html(telefono);
                        $('#noEmpleado-' + idNavegadora).html(noEmpleado);
                        $('#nombreEspecialidad-' + idNavegadora).html(especialidad);
                        $('#cedulaProfesional-' + idNavegadora).html(cedula);
                    }
                });
            }
        } else {
            console.log("Entro al segundo else");
            $("#error-datosRepetidosNavegadora").show(); //ya existe un campo
        }
    });


    /** ELIMINAR NAVEGADORA */
    $('body').on('click', '.btn-eliminarNavegadora', function () {

        var t = $('#tablaNavegadoras').DataTable();
        var fila = $(this).parents('tr');

        var idNavegadora = $(this).data('id');


        swal({
            title: "¿Estás seguro?",
            text: "Los datos se eliminarán y no podrás recuperarlos.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
                .then((eliminar) => {
                    if (eliminar) {

                        $.ajax({

                            url: 'AdministradorController',
                            cache: false,
                            method: 'POST',
                            data: {
                                key: 'eliminarEmpleado',
                                idEmpleado: idNavegadora
                            },
                            success: function (response) {
                                if (response == "error") {
                                    alert("Error al cargar");
                                } else {
                                    t.row(fila).remove().draw();
                                }
                            },
                            error: function (xhr) {

                            }


                        });

                    }
                });

    });

    //////////////////////////////////////////////////////
    ///////////////////////////// GESTION PACIENTES //////
    //////////////////////////////////////////////////////
    //  Recupera paciente
    $('body').on('click', '.btn-editarPaciente', function () {

        var idPaciente = $(this).data('id');

        $('#idPacienteAEditar').val($(this).data('id'));

        //alert($('#idPacienteAEditar').val());

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


                /*alert(data.fechaNacimiento);
                 alert(new Date(data.fechaNacimiento));
                 alert(convertDate(new Date(data.fechaNacimiento)));*/


                $('#editarNombreAdministradorAPaciente').val(data.nombre);
                $('#editarCurpAdministradorAPaciente').val(data.curp);
                $('#editarCumpleAdministradorAPaciente').val(convertDate(new Date(data.fechaNacimiento)));
                $('#editarPrimer-apellidoAdministradorAPaciente').val(data.primerApellido);
                $('#editarSegundo-apellidoAdministradorAPaciente').val(data.segundoApellido);
                $('#editarUsuarioAdministradorAPaciente').val(data.usuario);
                $('#editarEstado-civilPaciente').val(data.idEstadoCivil);
                $('#editarColAdministradorAPaciente').val(data.colonia);
                $('#editarCalleAdministradorAPaciente').val(data.calle);
                $('#editarNumIntAdministradorAPaciente').val(data.noInt);
                $('#editarNumExtAdministradorAPaciente').val(data.noExt);
                $('#editarEstadoAdministradorAPaciente').val(data.idEstado);
                $('#editarTelAdministradorAPaciente').val(data.telefono);
                $('#editarCorreoAdministradorAPaciente').val(data.correo);

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
                        $('#editarMunicipioAdministradorAPaciente').val(data.idMunicipio);
                    }

                });
            }

        });

    });

    //Guarda el paciente
    $('#btn-guardarCambios').on('click', function () {
        if (!repiteCorreo) {
            $("#error-editarDatosRepetidosNavegadora").hide();
            if (isValidName($('#editarNombreAdministradorAPaciente')) && isValidLastName($('#editarPrimer-apellidoAdministradorAPaciente')) && isValidUserName($('#editarUsuarioAdministradorAPaciente')) &&
                    isValidEmail($('#editarCorreoAdministradorAPaciente')) && isValidCURP($('#editarCurpAdministradorAPaciente')) && isValidPhoneNumber($('#editarTelAdministradorAPaciente')) &&
                    isValidSelect($('#editarEstado-civilPaciente')) && isValidDate($('#editarCumpleAdministradorAPaciente')) && isValidSelect($('#editarEstadoAdministradorAPaciente')) && isValidSelect($('#editarMunicipioAdministradorAPaciente'))) {
                $.ajax({

                    url: "AdministradorController",
                    method: "POST",
                    cache: false,
                    data: {
                        key: "actualizar-paciente",
                        idPaciente: $('#idPacienteAEditar').val(),
                        nombre: $('#editarNombreAdministradorAPaciente').val(),
                        apellido1: $('#editarPrimer-apellidoAdministradorAPaciente').val(),
                        apellido2: $('#editarSegundo-apellidoAdministradorAPaciente').val(),
                        usuario: $("#editarUsuarioAdministradorAPaciente").val(),
                        correo: $('#editarCorreoAdministradorAPaciente').val(),
                        curp: $('#editarCurpAdministradorAPaciente').val(),
                        colonia: $('#editarColAdministradorAPaciente').val(),
                        calle: $('#editarCalleAdministradorAPaciente').val(),
                        noExterior: $("#editarNumExtAdministradorAPaciente").val(),
                        noInterior: $("#editarNumIntAdministradorAPacient").val(),
                        telefono: $("#editarTelAdministradorAPaciente").val(),
                        estadoCivil: $("#editarEstado-civilPaciente").val(),
                        fechaNacimiento: $("#editarCumpleAdministradorAPaciente").val(),
                        estado: $("#editarEstadoAdministradorAPaciente").val(),
                        municipio: $("#editarMunicipioAdministradorAPaciente").val()


                    },
                    success: function (response) {

                        swal("Buen trabajo", "Cuenta editada satisfactoriamente", "success");

                        //Cerrar modal
                        $("#modalEditarPaciente").modal('toggle');

                        //Actualizar informacion de la tabla
                        $("#nombre-" + $('#idPacienteAEditar').val()).html($("#editarNombreAdministradorAPaciente").val() + ' ' + $('#editarPrimer-apellidoAdministradorAPaciente').val() + ' ' + $('#editarSegundo-apellidoAdministradorAPaciente').val());
                        $("#telefono-" + $('#idPacienteAEditar').val()).html($("#editarTelAdministradorAPaciente").val());
                        $("#estado-" + $('#idPacienteAEditar').val()).html($("#editarEstadoAdministradorAPaciente option:selected").text());

                    }

                });
            }
        } else {
            console.log("Entro al segundo else");
            $("#error-editarDatosRepetidosPaciente").show(); //ya existe un campo
        }

    });

    //Agregar Paciente
    $('#btn-agregarPaciente').on('click', function (e) {

        console.log("Entró");

        if (isValidName($('#nombrePaciente')) && isValidLastName($('#primer-apellidoPaciente')) &&
                isValidUserName($('#usuarioPaciente')) && isValidEmail($('#correoPaciente')) &&
                isValidPassword($('#contraPaciente')) && isValidPassword($('#confContraPaciente')) && isValidCURP($('#curpPaciente')) &&
                isValidPhoneNumber($('#telPaciente')) && isValidSelect($('#estado-civilPaciente')) &&
                isValidDate($('#cumplePaciente')) && isValidSelect($('#estadoPaciente')) && isValidSelect($('#municipioPaciente')) &&
                areEqualPasswords($('#contraPaciente'), $('#confContraPaciente'))) {
            if (!isValidCheckbox($('#acepto-terminos'))) {
                $('#error-terminos').show();
            } else {
                $('#error-terminos').hide();
                console.log("TODO BIEN");


                $.ajax({
                    url: 'RegistraUsuarioController',
                    cache: false,
                    method: 'POST',
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
                    success: function (response) {
                        console.log("Response!" + response);
                        console.log("FUNCIONÓ! (creo)");
                        var t = $('#tablaPacientes').DataTable();

                        t.row.add([
                            '',
                            $("#nombrePaciente").val() + " " + $("#primer-apellidoPaciente").val() + " " + $("#segundo-apellidoPaciente").val(),
                            '',
                            '',
                            $("#telPaciente").val(),
                            $("#estadoPaciente option:selected").text(),
                            '',
                            "<button class='btn btn-primary btn-editarPaciente m-1' data-toggle='modal' data-target='#modalEditarPaciente' data-id='" + response + "'><i class='fas fa-edit'></i></button>" +
                                    "<button class='btn btn-primary descargarFormulario m-1' data-id='" + response + "'><i class='fas fa-cloud-download-alt'></i></button>" +
                                    "<button class='btn btn-danger btn-eliminarPaciente m-1' data-id='" + response + "'><i class='fas fa-trash-alt'></i></button>"
                        ]).draw(false);
                    }
                });
            }
        } else {
            console.log("ALGO MAL");
        }
    });


    //GUARDA EL PACIENTE DESDE EL MODAL
    $('#btn-guardarPaciente').on('click', function () {

        var idPaciente = $('#idPaciente');

        var prz = $('#editar-przPaciente');
        var nombre = $('#editar-nombrePaciente');
        var primerApellido = $('#editar-primerApellidoMedico');
        var segundoApellido = $('#editar-segundoApellidoMedico');
        var usuario = $('#editar-usuarioPaciente');
        var estadoCivil = $('#editar-estadoCivilPaciente');
        var fechaNacimiento = $('#editar-fechaNacimientoPaciente');
        var tratamiento = $('#editar-tratamientoPaciente');
        var estadio = $('#editar-estadioPaciente');
        var calle = $('#editar-callePaciente');
        var noInt = $('#editar-noIntPaciente');
        var noExt = $('#editar-noExtPaciente');
        var telefono = $('#editar-telefonoPaciente');
        var correo = $('#editarcorreoPaciente');

        $.ajax({

            url: 'AdminController',
            cache: false,
            method: 'POST',
            data: {
                key: 'recuperaPaciente',
                idPaciente: idPaciente.val(),
                prz: prz.val(),
                nombre: nombre.val(),
                primerApellido: primerApellido.val(),
                segundoApellido: segundoApellido.val(),
                usuario: usuario.val(),
                estadoCivil: estadoCivil.val(),
                fechaNacimiento: fechaNacimiento.val(),
                tratamiento: tratamiento.val(),
                estadio: estadio.val(),
                calle: calle.val(),
                noInt: noInt.val(),
                noExt: noExt.val(),
                telefono: telefono.val(),
                correo: correo.val()


            }
        })
                .done(function (response) {


                });

    });

    ///ELIMINA PACIENTE
    $('body').on('click', ".btn-eliminarPaciente", function () {

        var t = $('#tablaAdministradores').DataTable();
        var fila = $(this).parents('tr');

        var id = $(this).data('id');

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

                            url: 'AdministradorController',
                            cache: false,
                            method: 'POST',
                            data: {

                                key: "eliminar-paciente",
                                idPaciente: id

                            },
                            success: function (response) {


                                swal("Buen trabajo!", "El paciente se eliminó correctamente!", "success");
                                t.row(fila).remove().draw();

                            }

                        });



                    }
                });

    });

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
                    $('#estadoPaciente').append("<option disabled selected>" + "Seleccione un estado" + "</option>");
                    //Primera opcion de municipio
                    $('#municipioPaciente').append("<option disabled selected>" + "Seleccione un municipio" + "</option>");
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
                        $('#error-CPexiste').show();
                    } else {
                        $('#error-CPexiste').hide();
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

    $('#editarEstadoAdministradorAPaciente').on('change', function () {
        $.ajax({
            url: 'ZonaController',
            data: {
                key: "getByEstado",
                idEstado: $('#editarEstadoAdministradorAPaciente').val()
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

    /** ELIMINAR MEDICO */
    $('body').on('click', '#btn-eliminarPaciente', function () {

        var idPaciente = $(this).data('id');

        //Modal editar medicos
        swal({
            title: "Estas seguro?",
            text: "Los datos se eliminarán y no podrás recuperarlos.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
                .then((eliminar) => {
                    if (eliminar) {

                        $.ajax({

                            url: 'AdminController',
                            cache: false,
                            method: 'POST',
                            data: {
                                key: 'eliminarPaciente',
                                idPaciente: idPaciente
                            },
                            success: function (response) {

                            }
                        });

                    } else {

                    }
                });
    });

    //AUTOCOMPLETAR Especialidades
    var especialidades = $('#listEspecialidades');

    $.ajax({
        url: 'AdministradorController',
        cache: false,
        method: 'POST',
        data: {key: "autocompletarEspecialidades"}
    })

            .done(function (response) {

                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {

                    var newObjeto = $('<option value="' + json[i].nombre + '"></option>');
                    especialidades.append(newObjeto);
                }


                console.log(JSON.stringify(especialidades));

            });


    // AUTOCOMPLETAR POSICIONES

    var posiciones = $('#listPosiciones');


    $.ajax({
        url: 'AdministradorController',
        cache: false,
        method: 'POST',
        data: {key: "autocompletarPosiciones"}
    })
            .done(function (response) {

                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {

                    var newObjeto = $('<option value="' + json[i].nombre + '"></option>');
                    posiciones.append(newObjeto);
                }

                console.log(JSON.stringify(posiciones));

            });

    //VALIDACIONES
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
    function convertDate(date) {

        var yyyy = date.getFullYear().toString();
        var mm = (date.getMonth() + 1).toString();
        var dd = date.getDate().toString();

        var mmChars = mm.split('');
        var ddChars = dd.split('');

        return yyyy + '-' + (mmChars[1] ? mm : "0" + mmChars[0]) + '-' + (ddChars[1] ? dd : "0" + ddChars[0]);
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

    function isValidEspecialidad(input) {

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

    function isValidDate(input) {

        //Obtener fecha
        let today = new Date();

        //Valor seleccionado del input
        let date_from = input.val();
        date_from = new Date(date_from);

        //Tomar los valores de hoy
        var year = today.getFullYear();
        var month = today.getMonth();
        var day = today.getDate();

        //Hoy hace 16 años y hoy hace 115 años
        var maxDate = new Date(year - 16, month, day);
        var minDate = new Date(year - 115, month, day);

        let event = true;

        if (maxDate > date_from && date_from > minDate) {
            event = false;
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

    function isValidNumEmpleado(input) {

        var m = input.val();

        var expreg = /^[0-9]{6,6}$/;


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

    function isValidCedula(input) {

        var m = input.val();

        var expreg = /^[0-9]{7,7}$/;


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
});